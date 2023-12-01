package com.igexin.c.b;

import android.text.TextUtils;
import com.igexin.c.a.b.g;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/b/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f23278a = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static String a() {
        Random random = new Random();
        char[] cArr = new char[32];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 32) {
                return new String(cArr);
            }
            char[] cArr2 = f23278a;
            cArr[i2] = cArr2[random.nextInt(cArr2.length)];
            i = i2 + 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder("");
            int length = digest.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
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
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    private static String a(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                return sb.toString();
            }
            sb.append(String.format("%02X", Byte.valueOf(bArr[i4])));
            i3 = i4 + 1;
        }
    }

    public static boolean a(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    public static byte[] a(byte[] bArr) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            com.igexin.c.a.c.a.a(e);
            messageDigest = null;
        }
        if (messageDigest == null) {
            return null;
        }
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    public static String b(String str) {
        MessageDigest messageDigest;
        byte[] bytes = str.getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            com.igexin.c.a.c.a.a(e);
            messageDigest = null;
        }
        if (messageDigest == null) {
            return null;
        }
        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        char[] cArr2 = new char[32];
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            byte b = digest[i2];
            int i3 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i3 + 1;
            cArr2[i3] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    public static String b(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    public static byte[] b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] a2 = g.a(bArr);
        byte[] bArr2 = null;
        if (a2 != null) {
            String b = b(String.valueOf(System.currentTimeMillis()));
            int length = a2.length;
            bArr2 = new byte[length + 16];
            byte[] bytes = b.substring(0, 8).getBytes();
            byte[] bytes2 = b.substring(24, 32).getBytes();
            System.arraycopy((Object) bytes, 0, (Object) bArr2, 0, 8);
            System.arraycopy((Object) a2, 0, (Object) bArr2, 8, length);
            System.arraycopy((Object) bytes2, 0, (Object) bArr2, length + 8, 8);
        }
        return bArr2;
    }

    public static byte[] c(byte[] bArr) {
        if (bArr == null || bArr.length < 16) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length - 16];
        System.arraycopy((Object) bArr, 8, (Object) bArr2, 0, bArr.length - 16);
        return g.b(bArr2);
    }
}
