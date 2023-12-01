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

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/COSDirect.class */
public interface COSDirect {
    void cancel(CosXmlRequest cosXmlRequest);

    CompleteMultiUploadResult completeMultipartUpload(CompleteMultiUploadRequest completeMultiUploadRequest) throws CosXmlClientException, CosXmlServiceException;

    CosXmlSimpleService getCosService();

    CryptoModuleBase getCryptoModule();

    GetObjectResult getObject(GetObjectRequest getObjectRequest) throws CosXmlClientException, CosXmlServiceException;

    HeadObjectResult headObject(HeadObjectRequest headObjectRequest) throws CosXmlClientException, CosXmlServiceException;

    InitMultipartUploadResult initMultipartUpload(InitMultipartUploadRequest initMultipartUploadRequest) throws CosXmlClientException, CosXmlServiceException;

    boolean isTransferSecurely();

    PutObjectResult putObject(PutObjectRequest putObjectRequest) throws CosXmlClientException, CosXmlServiceException;

    UploadPartResult uploadPart(UploadPartRequest uploadPartRequest) throws CosXmlClientException, CosXmlServiceException;

    void uploadPartAsync(UploadPartRequest uploadPartRequest, CosXmlResultListener cosXmlResultListener);
}
