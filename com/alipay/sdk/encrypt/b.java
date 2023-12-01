package com.alipay.sdk.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/encrypt/b.class */
public class b {
    public static String a(int i, String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "DES");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(i, secretKeySpec);
            byte[] doFinal = cipher.doFinal(i == 2 ? a.a(str) : str.getBytes("UTF-8"));
            return i == 2 ? new String(doFinal) : a.a(doFinal);
        } catch (Exception e) {
            com.alipay.sdk.util.c.a(e);
            return null;
        }
    }

    public static String a(String str, String str2) {
        return a(1, str, str2);
    }

    public static String b(String str, String str2) {
        return a(2, str, str2);
    }
}
