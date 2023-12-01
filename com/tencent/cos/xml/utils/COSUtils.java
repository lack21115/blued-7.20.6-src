package com.tencent.cos.xml.utils;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/utils/COSUtils.class */
public class COSUtils {
    public static Exception mergeException(CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
        return cosXmlClientException != null ? cosXmlClientException : cosXmlServiceException;
    }
}
