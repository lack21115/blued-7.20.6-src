package com.amap.api.col.p0003sl;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.amap.api.col.3sl.ht  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ht.class */
public final class ht {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f5109a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] b = new byte[128];

    static {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 128) {
                break;
            }
            b[i2] = -1;
            i = i2 + 1;
        }
        int i3 = 65;
        while (true) {
            int i4 = i3;
            if (i4 > 90) {
                break;
            }
            b[i4] = (byte) (i4 - 65);
            i3 = i4 + 1;
        }
        int i5 = 97;
        while (true) {
            int i6 = i5;
            if (i6 > 122) {
                break;
            }
            b[i6] = (byte) ((i6 - 97) + 26);
            i5 = i6 + 1;
        }
        int i7 = 48;
        while (true) {
            int i8 = i7;
            if (i8 > 57) {
                byte[] bArr = b;
                bArr[43] = 62;
                bArr[47] = 63;
                return;
            }
            b[i8] = (byte) ((i8 - 48) + 52);
            i7 = i8 + 1;
        }
    }

    public static String a(String str) {
        return ib.a(b(str));
    }

    public static byte[] a(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ib.c("EQUVT"));
        if (keyGenerator == null) {
            return null;
        }
        keyGenerator.init(256);
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        PublicKey d = ib.d();
        if (d == null) {
            return null;
        }
        byte[] a2 = a(encoded, d);
        byte[] a3 = a(encoded, bArr);
        byte[] bArr2 = new byte[a2.length + a3.length];
        System.arraycopy((Object) a2, 0, (Object) bArr2, 0, a2.length);
        System.arraycopy((Object) a3, 0, (Object) bArr2, a2.length, a3.length);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(byte[] bArr, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(ib.c("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
        cipher.init(1, key);
        return cipher.doFinal(bArr);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            return c(bArr, bArr2, ib.c());
        } catch (Throwable th) {
            it.a(th, "er", "asEn");
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, ib.c("EQUVT"));
        Cipher cipher = Cipher.getInstance(ib.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr2);
    }

    public static String b(byte[] bArr) {
        try {
            return d(bArr);
        } catch (Throwable th) {
            it.a(th, "er", "e64");
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c8, code lost:
        if (r0 == (-1)) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00cb, code lost:
        r0.write(((r0 & 15) << 4) | ((r0 & 60) >>> 2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e1, code lost:
        r0 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e3, code lost:
        if (r0 != r0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00eb, code lost:
        return r0.toByteArray();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ec, code lost:
        r6 = r0 + 1;
        r0 = r0[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f7, code lost:
        if (r0 != 61) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ff, code lost:
        return r0.toByteArray();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0100, code lost:
        r0 = com.amap.api.col.p0003sl.ht.b[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0108, code lost:
        if (r6 >= r0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x010d, code lost:
        if (r0 == (-1)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x011a, code lost:
        if (r0 == (-1)) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x011d, code lost:
        r0.write(r0 | ((r0 & 3) << 6));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] b(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.ht.b(java.lang.String):byte[]");
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return c(bArr, bArr2, bArr3);
    }

    public static String c(byte[] bArr) {
        try {
            return d(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] c(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, ib.c("EQUVT"));
        Cipher cipher = Cipher.getInstance(ib.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        try {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return cipher.doFinal(bArr2);
    }

    private static String d(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            if (i3 == length) {
                stringBuffer.append(f5109a[i4 >>> 2]);
                stringBuffer.append(f5109a[(i4 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i5 = i3 + 1;
            int i6 = bArr[i3] & 255;
            if (i5 == length) {
                stringBuffer.append(f5109a[i4 >>> 2]);
                stringBuffer.append(f5109a[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
                stringBuffer.append(f5109a[(i6 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            int i7 = bArr[i5] & 255;
            stringBuffer.append(f5109a[i4 >>> 2]);
            stringBuffer.append(f5109a[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
            stringBuffer.append(f5109a[((i6 & 15) << 2) | ((i7 & 192) >>> 6)]);
            stringBuffer.append(f5109a[i7 & 63]);
            i = i5 + 1;
        }
        return stringBuffer.toString();
    }
}
