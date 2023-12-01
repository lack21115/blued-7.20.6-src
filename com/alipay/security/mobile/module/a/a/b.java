package com.alipay.security.mobile.module.a.a;

import java.security.MessageDigest;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/security/mobile/module/a/a/b.class */
public final class b {
    public static String a(String str) {
        try {
            if (com.alipay.security.mobile.module.a.a.a(str)) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= digest.length) {
                    return sb.toString();
                }
                sb.append(String.format("%02x", Byte.valueOf(digest[i2])));
                i = i2 + 1;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
