package com.oplus.log.d;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/d/a.class */
public final class a {
    public static String a(String str, String str2) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes());
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(str, 2), "AES");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, secretKeySpec, ivParameterSpec);
        return a(cipher.doFinal(str2.getBytes()));
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            sb.append("0123456789abcdef".charAt((bArr[i2] >> 4) & 15));
            sb.append("0123456789abcdef".charAt(bArr[i2] & 15));
            i = i2 + 1;
        }
    }
}
