package com.tencent.mapsdk.internal;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/sa.class */
public class sa {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24312a = "AESCrypt";
    private static final String b = "AES/CBC/PKCS7Padding";

    /* renamed from: c  reason: collision with root package name */
    private static final String f24313c = "UTF-8";
    private static final String d = "SHA-256";
    private static final byte[] e = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    private sa() {
    }

    public static String a(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance(d);
        byte[] bytes = str.getBytes("UTF-8");
        messageDigest.update(bytes, 0, bytes.length);
        return Base64.encodeToString(messageDigest.digest(), 2);
    }

    public static String a(String str, String str2) throws GeneralSecurityException {
        try {
            return new String(a(new SecretKeySpec(Base64.decode(str, 2), "AES"), e, Base64.decode(str2, 2)), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new GeneralSecurityException(e2);
        }
    }

    private static String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return new String(cArr2);
            }
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            cArr2[i4] = cArr[i3 >>> 4];
            cArr2[i4 + 1] = cArr[i3 & 15];
            i = i2 + 1;
        }
    }

    public static byte[] a(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(b);
        cipher.init(2, secretKeySpec, new IvParameterSpec(bArr));
        return cipher.doFinal(bArr2);
    }

    public static String b(String str, String str2) throws GeneralSecurityException {
        try {
            return Base64.encodeToString(b(new SecretKeySpec(Base64.decode(str, 2), "AES"), e, str2.getBytes("UTF-8")), 2);
        } catch (UnsupportedEncodingException e2) {
            throw new GeneralSecurityException(e2);
        }
    }

    public static byte[] b(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(b);
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr));
        return cipher.doFinal(bArr2);
    }
}
