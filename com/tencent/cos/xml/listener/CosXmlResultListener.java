package com.tencent.cos.xml.listener;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/listener/CosXmlResultListener.class */
public interface CosXmlResultListener {
    void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException);

    void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult);
}
