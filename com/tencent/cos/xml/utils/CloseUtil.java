package com.tencent.cos.xml.utils;

import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/utils/CloseUtil.class */
public class CloseUtil {
    public static void closeQuietly(Closeable closeable) throws CosXmlClientException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                throw new CosXmlClientException(ClientErrorCode.IO_ERROR.getCode(), e);
            }
        }
    }
}
