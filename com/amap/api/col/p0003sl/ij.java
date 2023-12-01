package com.amap.api.col.p0003sl;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.amap.api.col.3sl.ij  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ij.class */
public final class ij {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f5155a;
    private static String[] b = {"kp6SsA", "cHE4dQ", "JKekrA", "XBxOHQ", "CSnpKw", "VwcThw", "wkp6Sg", "1cHE4Q"};

    /* renamed from: c  reason: collision with root package name */
    private static int[] f5156c = null;

    private static int a(int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 >> 1) | Integer.MIN_VALUE;
        }
        return (i << i2) | ((i & i3) >>> (32 - i2));
    }

    public static String a() {
        SecureRandom secureRandom = new SecureRandom();
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ib.c("EQUVT"));
            keyGenerator.init(128, secureRandom);
            return ie.a(keyGenerator.generateKey().getEncoded());
        } catch (Throwable th) {
            return null;
        }
    }

    private static String a(int i) {
        char[] cArr = new char[4];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 4) {
                return new String(cArr);
            }
            int i4 = (4 - i3) - 1;
            cArr[i4] = (char) ((i >>> (i3 * 8)) & 255);
            char c2 = cArr[i4];
            String str = " ";
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < 32) {
                    str = str + (((Integer.MIN_VALUE >>> i6) & c2) >>> (31 - i6));
                    i5 = i6 + 1;
                }
            }
            i2 = i3 + 1;
        }
    }

    public static String a(String str) {
        return hw.b(str);
    }

    private static String a(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        if (iArr != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= iArr.length) {
                    break;
                }
                sb.append(a(a(b(iArr[i2]), i2)));
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    private static byte[] a(byte[] bArr) {
        try {
            if (f5155a == null) {
                f5155a = ib.c("YAAAAAAAAAAAAAAAAAAAAAA").getBytes();
            }
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f5155a);
            SecretKeySpec secretKeySpec = new SecretKeySpec(a(b()).getBytes("UTF-8"), ib.c("EQUVT"));
            Cipher cipher = Cipher.getInstance(ib.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static int b(int i) {
        int i2 = 1;
        for (int i3 = 0; i3 < 15; i3++) {
            i2 = (i2 << 2) | 1;
        }
        return ((i & i2) << 1) | (((i2 << 1) & i) >>> 1);
    }

    public static String b(String str) {
        try {
            return ie.a(a(str.getBytes("UTF-8")));
        } catch (Throwable th) {
            return null;
        }
    }

    private static int[] b() {
        int[] iArr = f5156c;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[8];
        int i = 0;
        while (true) {
            int i2 = i;
            String[] strArr = b;
            if (i2 >= strArr.length) {
                return iArr2;
            }
            byte[] b2 = ht.b(strArr[i2]);
            iArr2[i2] = ((b2[0] & 255) << 24) | (b2[3] & 255) | ((b2[2] & 255) << 8) | ((b2[1] & 255) << 16);
            i = i2 + 1;
        }
    }
}
