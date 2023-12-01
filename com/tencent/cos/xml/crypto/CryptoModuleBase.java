package com.tencent.cos.xml.crypto;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.common.Range;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadResult;
import com.tencent.cos.xml.model.object.InitMultipartUploadRequest;
import com.tencent.cos.xml.model.object.InitMultipartUploadResult;
import com.tencent.cos.xml.model.object.PutObjectRequest;
import com.tencent.cos.xml.model.object.PutObjectResult;
import com.tencent.cos.xml.model.object.UploadPartRequest;
import com.tencent.cos.xml.model.object.UploadPartResult;
import com.tencent.cos.xml.s3.Base64;
import com.tencent.cos.xml.utils.DigestUtils;
import com.tencent.qcloud.core.auth.QCloudCredentialProvider;
import com.tencent.qcloud.core.util.ContextHolder;
import com.tencent.qcloud.core.util.QCloudUtils;
import com.tencentcloudapi.kms.v20190118.models.GenerateDataKeyRequest;
import com.tencentcloudapi.kms.v20190118.models.GenerateDataKeyResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Provider;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/CryptoModuleBase.class */
public abstract class CryptoModuleBase implements CryptoModule {
    protected static final int DEFAULT_BUFFER_SIZE = 2048;
    private static final boolean IS_MULTI_PART = true;
    protected final ContentCryptoScheme contentCryptoScheme;
    protected final CosXmlSimpleService cos;
    protected final COSCryptoScheme cryptoScheme;
    protected final EncryptionMaterialsProvider kekMaterialsProvider;
    protected final QCLOUDKMS kms;
    protected final Map<String, MultipartUploadCryptoContext> multipartUploadContexts = Collections.synchronizedMap(new HashMap());

    protected CryptoModuleBase(CosXmlSimpleService cosXmlSimpleService, QCloudCredentialProvider qCloudCredentialProvider, EncryptionMaterialsProvider encryptionMaterialsProvider) {
        this.kekMaterialsProvider = encryptionMaterialsProvider;
        this.cos = cosXmlSimpleService;
        COSCryptoScheme from = COSCryptoScheme.from();
        this.cryptoScheme = from;
        this.contentCryptoScheme = from.getContentCryptoScheme();
        this.kms = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CryptoModuleBase(QCLOUDKMS qcloudkms, CosXmlSimpleService cosXmlSimpleService, QCloudCredentialProvider qCloudCredentialProvider, EncryptionMaterialsProvider encryptionMaterialsProvider) {
        this.kekMaterialsProvider = encryptionMaterialsProvider;
        this.cos = cosXmlSimpleService;
        COSCryptoScheme from = COSCryptoScheme.from();
        this.cryptoScheme = from;
        this.contentCryptoScheme = from.getContentCryptoScheme();
        this.kms = qcloudkms;
    }

    private ContentCryptoMaterial buildContentCryptoMaterial(EncryptionMaterials encryptionMaterials, Provider provider, CosXmlRequest cosXmlRequest) throws CosXmlClientException {
        byte[] bArr = new byte[this.contentCryptoScheme.getIVLengthInBytes()];
        this.cryptoScheme.getSecureRandom().nextBytes(bArr);
        if (encryptionMaterials.isKMSEnabled()) {
            Map<String, String> mergeMaterialDescriptions = ContentCryptoMaterial.mergeMaterialDescriptions(encryptionMaterials, cosXmlRequest);
            GenerateDataKeyRequest generateDataKeyRequest = new GenerateDataKeyRequest();
            try {
                generateDataKeyRequest.setEncryptionContext(JSONUtils.toJsonString(mergeMaterialDescriptions));
                generateDataKeyRequest.setKeyId(encryptionMaterials.getCustomerMasterKeyId());
                generateDataKeyRequest.setKeySpec(this.contentCryptoScheme.getKeySpec());
                GenerateDataKeyResponse generateDataKey = this.kms.generateDataKey(generateDataKeyRequest);
                return ContentCryptoMaterial.wrap(new SecretKeySpec(Base64.decode(generateDataKey.getPlaintext()), this.contentCryptoScheme.getKeyGeneratorAlgorithm()), bArr, this.contentCryptoScheme, provider, new KMSSecuredCEK(generateDataKey.getCiphertextBlob().getBytes(), mergeMaterialDescriptions));
            } catch (JSONException e) {
                throw CosXmlClientException.internalException("generate datakey request set encryption context got json processing exception");
            }
        }
        return ContentCryptoMaterial.create(generateCEK(encryptionMaterials, provider), bArr, encryptionMaterials, this.cryptoScheme, provider, this.kms, cosXmlRequest);
    }

    static Range getAdjustedCryptoRange(Range range) {
        if (range == null) {
            return null;
        }
        long cipherBlockLowerBound = getCipherBlockLowerBound(range.getStart());
        long j = -1;
        if (range.getEnd() != -1) {
            j = getCipherBlockUpperBound(range.getEnd());
        }
        return new Range(cipherBlockLowerBound, j);
    }

    static long[] getAdjustedCryptoRange(long[] jArr) {
        if (jArr == null || jArr[0] > jArr[1]) {
            return null;
        }
        return new long[]{getCipherBlockLowerBound(jArr[0]), getCipherBlockUpperBound(jArr[1])};
    }

    private static long getCipherBlockLowerBound(long j) {
        long j2 = (j - (j % 16)) - 16;
        long j3 = j2;
        if (j2 < 0) {
            j3 = 0;
        }
        return j3;
    }

    private static long getCipherBlockUpperBound(long j) {
        long j2 = j + (16 - (j % 16)) + 16;
        long j3 = j2;
        if (j2 < 0) {
            j3 = Long.MAX_VALUE;
        }
        return j3;
    }

    private CipherLiteInputStream newCOSCipherLiteInputStream(PutObjectRequest putObjectRequest, ContentCryptoMaterial contentCryptoMaterial, long j) throws CosXmlClientException {
        try {
            InputStream openInputStream = openInputStream(putObjectRequest);
            LengthCheckInputStream lengthCheckInputStream = openInputStream;
            if (j > -1) {
                lengthCheckInputStream = new LengthCheckInputStream(openInputStream, j, false);
            }
            CipherLite cipherLite = contentCryptoMaterial.getCipherLite();
            return cipherLite.markSupported() ? new CipherLiteInputStream(lengthCheckInputStream, cipherLite, 2048) : new RenewableCipherLiteInputStream(lengthCheckInputStream, cipherLite, 2048);
        } catch (Exception e) {
            throw CosXmlClientException.internalException("Unable to create cipher input stream: " + e.getMessage());
        }
    }

    private ContentCryptoMaterial newContentCryptoMaterial(EncryptionMaterialsProvider encryptionMaterialsProvider, Provider provider, CosXmlRequest cosXmlRequest) throws CosXmlClientException {
        EncryptionMaterials encryptionMaterials = encryptionMaterialsProvider.getEncryptionMaterials();
        if (encryptionMaterials != null) {
            return buildContentCryptoMaterial(encryptionMaterials, provider, cosXmlRequest);
        }
        throw CosXmlClientException.internalException("No material available from the encryption material provider");
    }

    private ContentCryptoMaterial newContentCryptoMaterial(EncryptionMaterialsProvider encryptionMaterialsProvider, Map<String, String> map, Provider provider, CosXmlRequest cosXmlRequest) throws CosXmlClientException {
        EncryptionMaterials encryptionMaterials = encryptionMaterialsProvider.getEncryptionMaterials(map);
        if (encryptionMaterials == null) {
            return null;
        }
        return buildContentCryptoMaterial(encryptionMaterials, provider, cosXmlRequest);
    }

    private InputStream openInputStream(PutObjectRequest putObjectRequest) throws IOException {
        String srcPath = putObjectRequest.getSrcPath();
        Uri uri = putObjectRequest.getUri();
        if (srcPath != null) {
            return new FileInputStream(srcPath);
        }
        if (uri == null || ContextHolder.getAppContext() == null) {
            return null;
        }
        return ContextHolder.getAppContext().getContentResolver().openInputStream(uri);
    }

    protected final InitMultipartUploadRequest cipherInitMultipartUploadRequest(InitMultipartUploadRequest initMultipartUploadRequest) {
        ObjectMetadata metadata = initMultipartUploadRequest.getMetadata();
        if (metadata == null) {
            return initMultipartUploadRequest;
        }
        if (metadata.getContentMD5() != null) {
            metadata.addUserMetadata(Headers.UNENCRYPTED_CONTENT_MD5, metadata.getContentMD5());
        }
        metadata.setContentMD5(null);
        if (metadata.getContentLength() != 0) {
            metadata.addUserMetadata(Headers.UNENCRYPTED_CONTENT_LENGTH, Long.toString(metadata.getContentLength()));
            metadata.setContentLength(0L);
        }
        initMultipartUploadRequest.setMetadata(metadata);
        return initMultipartUploadRequest;
    }

    abstract CipherLite cipherLiteForNextPart(MultipartUploadCryptoContext multipartUploadCryptoContext);

    protected abstract long ciphertextLength(long j);

    @Override // com.tencent.cos.xml.crypto.CryptoModule
    public CompleteMultiUploadResult completeMultipartUploadSecurely(CompleteMultiUploadRequest completeMultiUploadRequest) throws CosXmlClientException, CosXmlServiceException {
        String uploadId = completeMultiUploadRequest.getUploadId();
        MultipartUploadCryptoContext multipartUploadCryptoContext = this.multipartUploadContexts.get(uploadId);
        if (multipartUploadCryptoContext == null || multipartUploadCryptoContext.hasFinalPartBeenSeen()) {
            CompleteMultiUploadResult completeMultiUpload = this.cos.completeMultiUpload(completeMultiUploadRequest);
            this.multipartUploadContexts.remove(uploadId);
            return completeMultiUpload;
        }
        throw CosXmlClientException.internalException("Unable to complete an encrypted multipart upload without being told which part was the last.  Without knowing which part was the last, the encrypted data in COS is incomplete and corrupt.");
    }

    abstract long computeLastPartSize(UploadPartRequest uploadPartRequest);

    protected final ContentCryptoMaterial createContentCryptoMaterial(CosXmlRequest cosXmlRequest) throws CosXmlClientException {
        return newContentCryptoMaterial(this.kekMaterialsProvider, null, cosXmlRequest);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009d, code lost:
        throw com.tencent.cos.xml.exception.CosXmlClientException.internalException("Failed to generate secret key");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final javax.crypto.SecretKey generateCEK(com.tencent.cos.xml.crypto.EncryptionMaterials r5, java.security.Provider r6) throws com.tencent.cos.xml.exception.CosXmlClientException {
        /*
            Method dump skipped, instructions count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cos.xml.crypto.CryptoModuleBase.generateCEK(com.tencent.cos.xml.crypto.EncryptionMaterials, java.security.Provider):javax.crypto.SecretKey");
    }

    public final COSCryptoScheme getCOSCryptoScheme() {
        return this.cryptoScheme;
    }

    public MultipartUploadCryptoContext getCryptoContext(String str) {
        return this.multipartUploadContexts.get(str);
    }

    public boolean hasMultipartUploadContext(String str) {
        return this.multipartUploadContexts.containsKey(str);
    }

    @Override // com.tencent.cos.xml.crypto.CryptoModule
    public InitMultipartUploadResult initMultipartUploadSecurely(InitMultipartUploadRequest initMultipartUploadRequest) throws CosXmlClientException, CosXmlServiceException {
        cipherInitMultipartUploadRequest(initMultipartUploadRequest);
        ContentCryptoMaterial createContentCryptoMaterial = createContentCryptoMaterial(initMultipartUploadRequest);
        ObjectMetadata metadata = initMultipartUploadRequest.getMetadata();
        ObjectMetadata objectMetadata = metadata;
        if (metadata == null) {
            objectMetadata = new ObjectMetadata();
        }
        initMultipartUploadRequest.setMetadata(updateMetadataWithContentCryptoMaterial(objectMetadata, createContentCryptoMaterial));
        InitMultipartUploadResult initMultipartUpload = this.cos.initMultipartUpload(initMultipartUploadRequest);
        this.multipartUploadContexts.put(initMultipartUpload.initMultipartUpload.uploadId, newUploadContext(initMultipartUploadRequest, createContentCryptoMaterial));
        return initMultipartUpload;
    }

    public CipherLiteInputStream newCOSCipherLiteInputStream(PutObjectRequest putObjectRequest, CipherLite cipherLite) throws CosXmlClientException {
        try {
            InputStream openInputStream = openInputStream(putObjectRequest);
            return cipherLite.markSupported() ? new CipherLiteInputStream(openInputStream, cipherLite, 2048) : new RenewableCipherLiteInputStream(openInputStream, cipherLite, 2048);
        } catch (Exception e) {
            throw CosXmlClientException.internalException("Unable to create cipher input stream: " + e.getMessage());
        }
    }

    public final CipherLiteInputStream newMultipartCOSCipherInputStream(UploadPartRequest uploadPartRequest, CipherLite cipherLite) throws CosXmlClientException {
        String srcPath = uploadPartRequest.getSrcPath();
        Uri uri = uploadPartRequest.getUri();
        try {
            InputSubstream inputSubstream = new InputSubstream(!TextUtils.isEmpty(srcPath) ? new ResettableInputStream(srcPath) : (uri == null || ContextHolder.getAppContext() == null) ? null : ContextHolder.getAppContext().getContentResolver().openInputStream(uri), uploadPartRequest.getFileOffset(), uploadPartRequest.getFileContentLength(), uploadPartRequest.isLastPart());
            return cipherLite.markSupported() ? new CipherLiteInputStream(inputSubstream, cipherLite, 2048, true, uploadPartRequest.isLastPart()) : new RenewableCipherLiteInputStream(inputSubstream, cipherLite, 2048, true, uploadPartRequest.isLastPart());
        } catch (Exception e) {
            throw CosXmlClientException.internalException("Unable to create cipher input stream: " + e.getMessage());
        }
    }

    abstract MultipartUploadCryptoContext newUploadContext(InitMultipartUploadRequest initMultipartUploadRequest, ContentCryptoMaterial contentCryptoMaterial);

    protected final long plaintextLength(PutObjectRequest putObjectRequest, ObjectMetadata objectMetadata) {
        Context appContext;
        String srcPath = putObjectRequest.getSrcPath();
        Uri uri = putObjectRequest.getUri();
        if (TextUtils.isEmpty(srcPath)) {
            if (uri == null || (appContext = ContextHolder.getAppContext()) == null) {
                return -1L;
            }
            return QCloudUtils.getUriContentLength2(uri, appContext.getContentResolver());
        }
        return new File(srcPath).length();
    }

    @Override // com.tencent.cos.xml.crypto.CryptoModule
    public PutObjectResult putObjectSecurely(PutObjectRequest putObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        ContentCryptoMaterial createContentCryptoMaterial = createContentCryptoMaterial(putObjectRequest);
        PutObjectRequest wrapWithCipher = wrapWithCipher(putObjectRequest, createContentCryptoMaterial);
        putObjectRequest.setMetadata(updateMetadataWithContentCryptoMaterial(putObjectRequest.getMetadata(), createContentCryptoMaterial));
        return this.cos.putObject(wrapWithCipher);
    }

    protected final ObjectMetadata updateMetadataWithContentCryptoMaterial(ObjectMetadata objectMetadata, ContentCryptoMaterial contentCryptoMaterial) throws CosXmlClientException {
        ObjectMetadata objectMetadata2 = objectMetadata;
        if (objectMetadata == null) {
            objectMetadata2 = new ObjectMetadata();
        }
        try {
            return contentCryptoMaterial.toObjectMetadata(objectMetadata2);
        } catch (JSONException e) {
            throw CosXmlClientException.internalException(e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x013f  */
    @Override // com.tencent.cos.xml.crypto.CryptoModule
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void uploadPartAsyncSecurely(com.tencent.cos.xml.model.object.UploadPartRequest r8, com.tencent.cos.xml.listener.CosXmlResultListener r9) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cos.xml.crypto.CryptoModuleBase.uploadPartAsyncSecurely(com.tencent.cos.xml.model.object.UploadPartRequest, com.tencent.cos.xml.listener.CosXmlResultListener):void");
    }

    @Override // com.tencent.cos.xml.crypto.CryptoModule
    public UploadPartResult uploadPartSecurely(UploadPartRequest uploadPartRequest) throws CosXmlClientException, CosXmlServiceException {
        int blockSizeInBytes = this.contentCryptoScheme.getBlockSizeInBytes();
        boolean isLastPart = uploadPartRequest.isLastPart();
        String uploadId = uploadPartRequest.getUploadId();
        boolean z = 0 == uploadPartRequest.getFileLength() % ((long) blockSizeInBytes);
        if (!isLastPart && !z) {
            throw CosXmlClientException.internalException("Invalid part size: part sizes for encrypted multipart uploads must be multiples of the cipher block size (" + blockSizeInBytes + ") with the exception of the last part.");
        }
        MultipartUploadCryptoContext multipartUploadCryptoContext = this.multipartUploadContexts.get(uploadId);
        if (multipartUploadCryptoContext == null) {
            throw CosXmlClientException.internalException("No client-side information available on upload ID " + uploadId);
        }
        multipartUploadCryptoContext.beginPartUpload(uploadPartRequest.getPartNumber());
        try {
            uploadPartRequest.setInputStream(newMultipartCOSCipherInputStream(uploadPartRequest, cipherLiteForNextPart(multipartUploadCryptoContext)));
            uploadPartRequest.setSrcPath(null);
            uploadPartRequest.setFileOffset(0L);
            if (isLastPart) {
                long computeLastPartSize = computeLastPartSize(uploadPartRequest);
                if (computeLastPartSize > -1) {
                    uploadPartRequest.setFileContentLength(computeLastPartSize);
                }
                if (multipartUploadCryptoContext.hasFinalPartBeenSeen()) {
                    throw CosXmlClientException.internalException("This part was specified as the last part in a multipart upload, but a previous part was already marked as the last part.  Only the last part of the upload should be marked as the last part.");
                }
            }
            UploadPartResult uploadPart = this.cos.uploadPart(uploadPartRequest);
            if (isLastPart) {
                multipartUploadCryptoContext.setHasFinalPartBeenSeen(true);
            }
            return uploadPart;
        } finally {
            multipartUploadCryptoContext.endPartUpload();
        }
    }

    protected final PutObjectRequest wrapWithCipher(PutObjectRequest putObjectRequest, ContentCryptoMaterial contentCryptoMaterial) throws CosXmlClientException {
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        ObjectMetadata objectMetadata = metadata;
        if (metadata == null) {
            objectMetadata = new ObjectMetadata();
        }
        String contentMD5 = objectMetadata.getContentMD5();
        String str = contentMD5;
        if (TextUtils.isEmpty(contentMD5)) {
            try {
                InputStream openInputStream = openInputStream(putObjectRequest);
                str = contentMD5;
                if (openInputStream != null) {
                    str = DigestUtils.getCOSMd5(openInputStream, 0L, -1L);
                }
            } catch (IOException e) {
                e.printStackTrace();
                str = contentMD5;
            }
        }
        if (str != null) {
            objectMetadata.addUserMetadata(Headers.UNENCRYPTED_CONTENT_MD5, str);
        }
        objectMetadata.setContentMD5(null);
        long plaintextLength = plaintextLength(putObjectRequest, objectMetadata);
        if (plaintextLength >= 0) {
            objectMetadata.addUserMetadata(Headers.UNENCRYPTED_CONTENT_LENGTH, Long.toString(plaintextLength));
            objectMetadata.setContentLength(ciphertextLength(plaintextLength));
        }
        putObjectRequest.setMetadata(objectMetadata);
        putObjectRequest.setInputStream(newCOSCipherLiteInputStream(putObjectRequest, contentCryptoMaterial, plaintextLength));
        putObjectRequest.setSrcPath(null);
        return putObjectRequest;
    }
}
