package com.tencent.cos.xml.utils;

import android.text.TextUtils;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/utils/URLEncodeUtils.class */
public class URLEncodeUtils {
    public static String cosPathEncode(String str) throws CosXmlClientException {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        try {
            String[] split = str.split("/", -1);
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                if (i2 != 0 || !"".equals(split[i2])) {
                    if (length > 1 && i2 == length - 1 && "".equals(split[i2])) {
                        break;
                    }
                    if (!"".equals(split[i2])) {
                        String[] split2 = split[i2].split(" ", -1);
                        int length2 = split2.length;
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= length2) {
                                break;
                            }
                            if (i4 != 0 || !"".equals(split2[i4])) {
                                if (length2 > 1 && i4 == length2 - 1 && "".equals(split2[i4])) {
                                    break;
                                }
                                sb.append(URLEncoder.encode(split2[i4], "utf-8"));
                                if (i4 != length2 - 1) {
                                    sb.append("%20");
                                }
                            } else {
                                sb.append("%20");
                            }
                            i3 = i4 + 1;
                        }
                    }
                    if (i2 != length - 1) {
                        sb.append("/");
                    }
                } else {
                    sb.append('/');
                }
                i = i2 + 1;
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), e);
        }
    }
}
