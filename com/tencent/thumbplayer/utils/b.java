package com.tencent.thumbplayer.utils;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/b.class */
public class b {
    public static int a(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                TPLogUtil.e("TPCommonUtils", e);
            }
        }
        return i;
    }

    public static String a(String str) {
        String hexString;
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(40);
            int length = digest.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return sb.toString();
                }
                int i3 = digest[i2] & 255;
                if ((i3 >> 4) == 0) {
                    sb.append("0");
                    hexString = Integer.toHexString(i3);
                } else {
                    hexString = Integer.toHexString(i3);
                }
                sb.append(hexString);
                i = i2 + 1;
            }
        } catch (Exception e) {
            TPLogUtil.e("TPCommonUtils", e.toString());
            return null;
        }
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            if (TextUtils.isEmpty(str)) {
                str = "this argument should not be null!";
            }
            throw new IllegalArgumentException(str);
        }
    }

    public static boolean a(Collection<? extends Object> collection) {
        return collection == null || collection.size() <= 0;
    }

    public static boolean a(Map<? extends Object, ? extends Object> map) {
        return map == null || map.size() <= 0;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return str.split(":")[0].matches("^((https|http|ftp|rtsp|mms)?)");
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}
