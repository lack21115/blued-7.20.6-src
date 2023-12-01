package com.tencent.cos.xml;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.object.BasePutObjectRequest;
import com.tencent.cos.xml.model.object.BasePutObjectResult;
import com.tencent.cos.xml.model.object.GetObjectRequest;
import com.tencent.cos.xml.model.object.GetObjectResult;
import com.tencent.cos.xml.model.object.UploadPartRequest;
import com.tencent.cos.xml.model.object.UploadPartResult;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/BaseCosXml.class */
public interface BaseCosXml {
    BasePutObjectResult basePutObject(BasePutObjectRequest basePutObjectRequest) throws CosXmlClientException, CosXmlServiceException;

    void basePutObjectAsync(BasePutObjectRequest basePutObjectRequest, CosXmlResultListener cosXmlResultListener);

    void cancel(CosXmlRequest cosXmlRequest);

    void cancelAll();

    GetObjectResult getObject(GetObjectRequest getObjectRequest) throws CosXmlClientException, CosXmlServiceException;

    byte[] getObject(String str, String str2) throws CosXmlClientException, CosXmlServiceException;

    void getObjectAsync(GetObjectRequest getObjectRequest, CosXmlResultListener cosXmlResultListener);

    String getObjectUrl(String str, String str2, String str3);

    void release();

    UploadPartResult uploadPart(UploadPartRequest uploadPartRequest) throws CosXmlClientException, CosXmlServiceException;

    void uploadPartAsync(UploadPartRequest uploadPartRequest, CosXmlResultListener cosXmlResultListener);
}
