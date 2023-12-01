package com.alipay.sdk.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/encrypt/f.class */
public class f {
    private static String a = "DESede/CBC/PKCS5Padding";

    public static String a(String str, String str2, String str3) {
        try {
            return a.a(a(str, str2.getBytes(), str3));
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] a(String str, byte[] bArr, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
            Cipher cipher = Cipher.getInstance(a);
            cipher.init(1, secretKeySpec, new IvParameterSpec(d.a(cipher, str2)));
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String b(String str, String str2, String str3) {
        try {
            return new String(b(str, a.a(str2), str3));
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
            Cipher cipher = Cipher.getInstance(a);
            cipher.init(2, secretKeySpec, new IvParameterSpec(d.a(cipher, str2)));
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            return null;
        }
    }
}
