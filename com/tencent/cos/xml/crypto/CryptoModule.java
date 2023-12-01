package com.tencent.cos.xml.crypto;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.object.CompleteMultiUploadRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadResult;
import com.tencent.cos.xml.model.object.GetObjectRequest;
import com.tencent.cos.xml.model.object.GetObjectResult;
import com.tencent.cos.xml.model.object.InitMultipartUploadRequest;
import com.tencent.cos.xml.model.object.InitMultipartUploadResult;
import com.tencent.cos.xml.model.object.PutObjectRequest;
import com.tencent.cos.xml.model.object.PutObjectResult;
import com.tencent.cos.xml.model.object.UploadPartRequest;
import com.tencent.cos.xml.model.object.UploadPartResult;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/CryptoModule.class */
public interface CryptoModule {
    CompleteMultiUploadResult completeMultipartUploadSecurely(CompleteMultiUploadRequest completeMultiUploadRequest) throws CosXmlClientException, CosXmlServiceException;

    GetObjectResult getObjectSecurely(GetObjectRequest getObjectRequest) throws CosXmlClientException, CosXmlServiceException;

    InitMultipartUploadResult initMultipartUploadSecurely(InitMultipartUploadRequest initMultipartUploadRequest) throws CosXmlClientException, CosXmlServiceException;

    PutObjectResult putObjectSecurely(PutObjectRequest putObjectRequest) throws CosXmlClientException, CosXmlServiceException;

    void uploadPartAsyncSecurely(UploadPartRequest uploadPartRequest, CosXmlResultListener cosXmlResultListener);

    UploadPartResult uploadPartSecurely(UploadPartRequest uploadPartRequest) throws CosXmlClientException, CosXmlServiceException;
}
