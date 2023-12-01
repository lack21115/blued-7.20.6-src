package com.oplus.instant.router.b;

import android.util.Base64;
import com.oplus.instant.router.g.d;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/b/a.class */
public class a {
    public static String a(String str, String str2) {
        try {
            return a(a(str.getBytes(), str2.getBytes()));
        } catch (Throwable th) {
            d.a("AESEncoder", "AES encrypt fail", th);
            return null;
        }
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return stringBuffer.toString();
            }
            stringBuffer.append("0123456789ABCDEF".charAt((bArr[i2] >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(bArr[i2] & 15));
            i = i2 + 1;
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(bArr2);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, IvParameterSpec ivParameterSpec) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr2);
    }

    public static String b(String str, String str2) {
        try {
            return a(a(str.getBytes(), str2.getBytes(), new IvParameterSpec(Base64.decode(str, 0), 0, 12)));
        } catch (Throwable th) {
            d.a("AESEncoder", "AES encrypt fail", th);
            return null;
        }
    }
}
