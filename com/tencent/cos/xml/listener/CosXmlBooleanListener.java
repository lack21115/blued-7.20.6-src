package com.tencent.cos.xml.listener;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/listener/CosXmlBooleanListener.class */
public interface CosXmlBooleanListener {
    void onFail(CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException);

    void onSuccess(boolean z);
}
