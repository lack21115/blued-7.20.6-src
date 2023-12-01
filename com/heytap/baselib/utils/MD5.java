package com.heytap.baselib.utils;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/baselib/utils/MD5.class */
class MD5 {
    MD5() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= digest.length) {
                    return sb.toString();
                }
                byte b = digest[i2];
                byte b2 = b;
                if (b < 0) {
                    b2 = b + 256;
                }
                if (b2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b2));
                i = i2 + 1;
            }
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String md5_16(String str) {
        String md5 = md5(str);
        String str2 = md5;
        if (!TextUtils.isEmpty(md5)) {
            str2 = md5.substring(8, 24);
        }
        return str2;
    }
}
