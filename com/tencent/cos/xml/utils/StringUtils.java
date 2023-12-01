package com.tencent.cos.xml.utils;

import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.qcloud.core.util.QCloudHttpUtils;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/utils/StringUtils.class */
public class StringUtils {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String extractFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf < 0) {
            return str;
        }
        int i = lastIndexOf;
        if (lastIndexOf == str.length() - 1) {
            i = str.substring(0, str.length() - 1).lastIndexOf(47);
        }
        return str.substring(i + 1);
    }

    public static String extractNameNoSuffix(String str) {
        String extractFileName = extractFileName(str);
        if (TextUtils.isEmpty(extractFileName)) {
            return "";
        }
        int lastIndexOf = extractFileName.lastIndexOf(46);
        String str2 = extractFileName;
        if (lastIndexOf > 0) {
            str2 = extractFileName.substring(0, lastIndexOf);
        }
        return str2;
    }

    public static String extractSuffix(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.endsWith(BridgeUtil.SPLIT_MARK)) {
            return BridgeUtil.SPLIT_MARK;
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf > 0 ? str.substring(lastIndexOf) : "";
    }

    public static String flat(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!z) {
                sb.append("&");
            }
            sb.append(key);
            z = false;
            if (!TextUtils.isEmpty(value)) {
                sb.append("=");
                sb.append(QCloudHttpUtils.urlEncodeString(value));
                z = false;
            }
        }
        return sb.toString();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            byte b = bArr[i2];
            sb.append(HEX_DIGITS[(b & 240) >>> 4]);
            sb.append(HEX_DIGITS[b & 15]);
            i = i2 + 1;
        }
    }
}
