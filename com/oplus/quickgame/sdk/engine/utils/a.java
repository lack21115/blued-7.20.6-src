package com.oplus.quickgame.sdk.engine.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/a.class */
public class a {
    public static String a(String str, String str2) throws Throwable {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes(), 0, 12);
        return new String(a(str.getBytes(), a(str2), ivParameterSpec));
    }

    public static byte[] a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            int i3 = i2 * 2;
            bArr[i2] = Integer.valueOf(str.substring(i3, i3 + 2), 16).byteValue();
            i = i2 + 1;
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, IvParameterSpec ivParameterSpec) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr2);
    }
}
