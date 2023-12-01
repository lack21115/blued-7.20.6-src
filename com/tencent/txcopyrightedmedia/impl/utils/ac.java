package com.tencent.txcopyrightedmedia.impl.utils;

import com.tencent.cos.xml.crypto.JceEncryptionConstants;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/ac.class */
public final class ac {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f26350a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] b = "0123456789ABCDEF".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f26351c = "0123456789ABCDEF".toCharArray();

    private static int a(char c2, int i) {
        int digit = Character.digit(c2, 16);
        if (digit != -1) {
            return digit;
        }
        throw new Exception("Illegal hexadecimal character " + c2 + " at index " + i);
    }

    public static String a() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 32) {
                return sb.toString();
            }
            char[] cArr = b;
            sb.append(cArr[ad.a(0, cArr.length)]);
            i = i2 + 1;
        }
    }

    public static byte[] a(String str) {
        try {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            if ((length & 1) != 0) {
                throw new Exception("Odd number of characters.");
            }
            byte[] bArr = new byte[length >> 1];
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i >= length) {
                    return bArr;
                }
                int a2 = a(charArray[i], i);
                int i4 = i + 1;
                i = i4 + 1;
                bArr[i3] = (byte) (((a2 << 4) | a(charArray[i4], i4)) & 255);
                i2 = i3 + 1;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] a(byte[] bArr, int i, byte[] bArr2, String str) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/".concat(String.valueOf(str)));
            cipher.init(1, new SecretKeySpec(bArr2, "AES"));
            return cipher.doFinal(bArr, 0, i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] a(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, String str) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/".concat(String.valueOf(str)));
            cipher.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr, 0, i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
            cipher.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) {
        return a(bArr, bArr.length, bArr2, bArr3, str);
    }

    public static String b(String str) {
        byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
        StringBuilder sb = new StringBuilder(digest.length * 2);
        int length = digest.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            byte b2 = digest[i2];
            sb.append(f26351c[(b2 >> 4) & 15]);
            sb.append(f26351c[b2 & 15]);
            i = i2 + 1;
        }
    }

    public static byte[] b(byte[] bArr, int i, byte[] bArr2, String str) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/".concat(String.valueOf(str)));
            cipher.init(2, new SecretKeySpec(bArr2, "AES"));
            return cipher.doFinal(bArr, 0, i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
