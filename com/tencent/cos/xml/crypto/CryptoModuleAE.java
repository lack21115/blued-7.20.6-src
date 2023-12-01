package com.tencent.cos.xml.crypto;

import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.common.Range;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.object.GetObjectRequest;
import com.tencent.cos.xml.model.object.GetObjectResult;
import com.tencent.cos.xml.model.object.InitMultipartUploadRequest;
import com.tencent.cos.xml.model.object.UploadPartRequest;
import com.tencent.cos.xml.utils.FileUtils;
import com.tencent.qcloud.core.auth.QCloudCredentialProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/CryptoModuleAE.class */
public class CryptoModuleAE extends CryptoModuleBase {
    public CryptoModuleAE(CosXmlSimpleService cosXmlSimpleService, QCloudCredentialProvider qCloudCredentialProvider, EncryptionMaterialsProvider encryptionMaterialsProvider) {
        this(null, cosXmlSimpleService, qCloudCredentialProvider, encryptionMaterialsProvider);
    }

    public CryptoModuleAE(QCLOUDKMS qcloudkms, CosXmlSimpleService cosXmlSimpleService, QCloudCredentialProvider qCloudCredentialProvider, EncryptionMaterialsProvider encryptionMaterialsProvider) {
        super(qcloudkms, cosXmlSimpleService, qCloudCredentialProvider, encryptionMaterialsProvider);
    }

    private void assertParameterNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    @Override // com.tencent.cos.xml.crypto.CryptoModuleBase
    final CipherLite cipherLiteForNextPart(MultipartUploadCryptoContext multipartUploadCryptoContext) {
        return multipartUploadCryptoContext.getCipherLite();
    }

    @Override // com.tencent.cos.xml.crypto.CryptoModuleBase
    protected final long ciphertextLength(long j) {
        return j + (this.contentCryptoScheme.getTagLengthInBits() / 8);
    }

    @Override // com.tencent.cos.xml.crypto.CryptoModuleBase
    final long computeLastPartSize(UploadPartRequest uploadPartRequest) {
        return uploadPartRequest.getFileLength() + (this.contentCryptoScheme.getTagLengthInBits() / 8);
    }

    @Override // com.tencent.cos.xml.crypto.CryptoModule
    public GetObjectResult getObjectSecurely(GetObjectRequest getObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        GetObjectResult object = this.cos.getObject(getObjectRequest);
        ObjectMetadata objectMetadata = new ObjectMetadata(object.headers);
        Range range = getObjectRequest.getRange();
        try {
            CipherLiteInputStream cipherLiteInputStream = new CipherLiteInputStream(new FileInputStream(getObjectRequest.getDownloadPath()), ContentCryptoMaterial.fromObjectMetadata(objectMetadata, this.kekMaterialsProvider, null, range == null ? null : new long[]{range.getStart(), range.getEnd()}, false, this.kms).getCipherLite());
            String downloadPath = getObjectRequest.getDownloadPath();
            File file = new File(downloadPath + ".decrypt");
            FileUtils.saveInputStreamToTmpFile(cipherLiteInputStream, file, 0L, -1L);
            FileUtils.deleteFileIfExist(downloadPath);
            if (file.renameTo(new File(downloadPath))) {
                return object;
            }
            throw CosXmlClientException.internalException("decrypt file failed.");
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            throw CosXmlClientException.internalException(e.getMessage());
        }
    }

    protected boolean isStrict() {
        return false;
    }

    @Override // com.tencent.cos.xml.crypto.CryptoModuleBase
    final MultipartUploadCryptoContext newUploadContext(InitMultipartUploadRequest initMultipartUploadRequest, ContentCryptoMaterial contentCryptoMaterial) {
        return new MultipartUploadCryptoContext(initMultipartUploadRequest.getBucket(), initMultipartUploadRequest.getCosPath(), contentCryptoMaterial);
    }
}
