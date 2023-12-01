package com.tencent.liteav.txcplayer.e;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import java.net.URLDecoder;
import java.security.MessageDigest;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcplayer/e/a.class */
public final class a {
    public static String a(String str) {
        int lastIndexOf;
        if (str == null || str.length() <= 0 || (lastIndexOf = str.lastIndexOf(46)) < 0 || lastIndexOf >= str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    public static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer("");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= digest.length) {
                    return stringBuffer.toString();
                }
                byte b = digest[i2];
                byte b2 = b;
                if (b < 0) {
                    b2 = b + 256;
                }
                if (b2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(b2));
                i = i2 + 1;
            }
        } catch (Exception e) {
            return str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v39, types: [int] */
    public static String c(String str) {
        try {
            if (e(str)) {
                LiteavLog.w("CommonUtil", "URL has been encoded");
                return str;
            }
            byte[] bytes = str.getBytes("UTF-8");
            StringBuilder sb = new StringBuilder(bytes.length);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= bytes.length) {
                    return sb.toString();
                }
                byte b = bytes[i2] < 0 ? bytes[i2] + 256 : bytes[i2];
                if (b <= 32 || b >= Byte.MAX_VALUE || b == 34 || b == 37 || b == 60 || b == 62 || b == 91 || b == 125 || b == 92 || b == 93 || b == 94 || b == 96 || b == 123 || b == 124) {
                    sb.append(String.format("%%%02X", Integer.valueOf(b)));
                } else {
                    sb.append((char) b);
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            LiteavLog.e("CommonUtil", "tryEncodeUrl failed.", e);
            return str;
        }
    }

    public static String d(String str) {
        String b = b(str);
        String a2 = a(Uri.parse(str).getPath());
        String str2 = b;
        if (!TextUtils.isEmpty(a2)) {
            if (a2.toLowerCase().endsWith("m3u8")) {
                return b + ".hls";
            }
            if (a2.toLowerCase().endsWith("mp4")) {
                b = b(f(str));
            }
            str2 = b + "." + a2;
        }
        return str2;
    }

    private static boolean e(String str) {
        if (str == null) {
            return true;
        }
        try {
            return !str.replace("+", " ").equals(URLDecoder.decode(str, "UTF-8").replace("+", " "));
        } catch (Exception e) {
            LiteavLog.e("CommonUtil", "isUrlEncoded error : ", e);
            return false;
        }
    }

    private static String f(String str) {
        int indexOf = str.indexOf("voddrm.token.");
        String str2 = str;
        if (indexOf >= 0) {
            int indexOf2 = str.indexOf(".", indexOf + 13);
            str2 = str;
            if (indexOf2 >= 0) {
                str2 = str;
                if (indexOf2 < str.length() - 1) {
                    str2 = str.substring(0, indexOf) + str.substring(indexOf2 + 1);
                }
            }
        }
        int indexOf3 = str2.indexOf("?");
        String str3 = str2;
        if (indexOf3 >= 0) {
            str3 = str2.substring(0, indexOf3);
        }
        return str3;
    }
}
