package com.igexin.assist.util;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/util/a.class */
public final class a {
    public static String a(String str) {
        byte[] bArr;
        try {
            bArr = MessageDigest.getInstance("md5").digest(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            com.igexin.c.a.c.a.a(e);
            bArr = null;
        }
        return new BigInteger(1, bArr).toString(16);
    }

    public static String a(String str, String str2) {
        try {
            byte[] decode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(a(new StringBuilder(str2).reverse().toString().getBytes()), "AES");
            Cipher cipher = Cipher.getInstance("AES/CFB128/NoPadding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(a("".getBytes())));
            byte[] doFinal = cipher.doFinal(decode);
            if (doFinal != null) {
                return new String(doFinal);
            }
            return null;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    private static byte[] a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }
}
