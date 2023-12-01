package com.tencent.cos.xml.crypto;

import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadResult;
import com.tencent.cos.xml.model.object.GetObjectRequest;
import com.tencent.cos.xml.model.object.GetObjectResult;
import com.tencent.cos.xml.model.object.HeadObjectRequest;
import com.tencent.cos.xml.model.object.HeadObjectResult;
import com.tencent.cos.xml.model.object.InitMultipartUploadRequest;
import com.tencent.cos.xml.model.object.InitMultipartUploadResult;
import com.tencent.cos.xml.model.object.PutObjectRequest;
import com.tencent.cos.xml.model.object.PutObjectResult;
import com.tencent.cos.xml.model.object.UploadPartRequest;
import com.tencent.cos.xml.model.object.UploadPartResult;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/COSDirectImpl.class */
public class COSDirectImpl implements COSDirect {
    private CosXmlSimpleService cosService;
    private CryptoModuleBase cryptoModule;

    public COSDirectImpl(CosXmlSimpleService cosXmlSimpleService, CryptoModuleBase cryptoModuleBase) {
        this.cosService = cosXmlSimpleService;
        this.cryptoModule = cryptoModuleBase;
    }

    @Override // com.tencent.cos.xml.crypto.COSDirect
    public void cancel(CosXmlRequest cosXmlRequest) {
        CosXmlSimpleService cosXmlSimpleService = this.cosService;
        if (cosXmlSimpleService != null) {
            cosXmlSimpleService.cancel(cosXmlRequest);
        }
    }

    @Override // com.tencent.cos.xml.crypto.COSDirect
    public CompleteMultiUploadResult completeMultipartUpload(CompleteMultiUploadRequest completeMultiUploadRequest) throws CosXmlClientException, CosXmlServiceException {
        if (isTransferSecurely()) {
            return this.cryptoModule.completeMultipartUploadSecurely(completeMultiUploadRequest);
        }
        CosXmlSimpleService cosXmlSimpleService = this.cosService;
        if (cosXmlSimpleService != null) {
            return cosXmlSimpleService.completeMultiUpload(completeMultiUploadRequest);
        }
        throw CosXmlClientException.internalException("Api implementation not found");
    }

    @Override // com.tencent.cos.xml.crypto.COSDirect
    public CosXmlSimpleService getCosService() {
        return this.cosService;
    }

    @Override // com.tencent.cos.xml.crypto.COSDirect
    public CryptoModuleBase getCryptoModule() {
        return this.cryptoModule;
    }

    @Override // com.tencent.cos.xml.crypto.COSDirect
    public GetObjectResult getObject(GetObjectRequest getObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        if (isTransferSecurely()) {
            return this.cryptoModule.getObjectSecurely(getObjectRequest);
        }
        CosXmlSimpleService cosXmlSimpleService = this.cosService;
        if (cosXmlSimpleService != null) {
            return cosXmlSimpleService.getObject(getObjectRequest);
        }
        throw CosXmlClientException.internalException("Api implementation not found");
    }

    @Override // com.tencent.cos.xml.crypto.COSDirect
    public HeadObjectResult headObject(HeadObjectRequest headObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        return this.cosService.headObject(headObjectRequest);
    }

    @Override // com.tencent.cos.xml.crypto.COSDirect
    public InitMultipartUploadResult initMultipartUpload(InitMultipartUploadRequest initMultipartUploadRequest) throws CosXmlClientException, CosXmlServiceException {
        if (isTransferSecurely()) {
            return this.cryptoModule.initMultipartUploadSecurely(initMultipartUploadRequest);
        }
        CosXmlSimpleService cosXmlSimpleService = this.cosService;
        if (cosXmlSimpleService != null) {
            return cosXmlSimpleService.initMultipartUpload(initMultipartUploadRequest);
        }
        throw CosXmlClientException.internalException("Api implementation not found");
    }

    @Override // com.tencent.cos.xml.crypto.COSDirect
    public boolean isTransferSecurely() {
        return this.cryptoModule != null;
    }

    @Override // com.tencent.cos.xml.crypto.COSDirect
    public PutObjectResult putObject(PutObjectRequest putObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        if (isTransferSecurely()) {
            return this.cryptoModule.putObjectSecurely(putObjectRequest);
        }
        CosXmlSimpleService cosXmlSimpleService = this.cosService;
        if (cosXmlSimpleService != null) {
            return cosXmlSimpleService.putObject(putObjectRequest);
        }
        throw CosXmlClientException.internalException("Api implementation not found");
    }

    @Override // com.tencent.cos.xml.crypto.COSDirect
    public UploadPartResult uploadPart(UploadPartRequest uploadPartRequest) throws CosXmlClientException, CosXmlServiceException {
        if (isTransferSecurely()) {
            return this.cryptoModule.uploadPartSecurely(uploadPartRequest);
        }
        CosXmlSimpleService cosXmlSimpleService = this.cosService;
        if (cosXmlSimpleService != null) {
            return cosXmlSimpleService.uploadPart(uploadPartRequest);
        }
        throw CosXmlClientException.internalException("Api implementation not found");
    }

    @Override // com.tencent.cos.xml.crypto.COSDirect
    public void uploadPartAsync(UploadPartRequest uploadPartRequest, CosXmlResultListener cosXmlResultListener) {
        if (isTransferSecurely()) {
            this.cryptoModule.uploadPartAsyncSecurely(uploadPartRequest, cosXmlResultListener);
            return;
        }
        CosXmlSimpleService cosXmlSimpleService = this.cosService;
        if (cosXmlSimpleService != null) {
            cosXmlSimpleService.uploadPartAsync(uploadPartRequest, cosXmlResultListener);
        } else {
            cosXmlResultListener.onFail(uploadPartRequest, CosXmlClientException.internalException("Api implementation not found"), null);
        }
    }
}
