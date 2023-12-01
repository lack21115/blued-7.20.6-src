package com.sdk.tencent.q;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/q/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f14385a;
    public static final byte[] b;

    static {
        boolean z = com.sdk.tencent.f.c.b;
        f14385a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        b = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 63, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, 0, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    }

    public static String a(byte[] bArr) {
        int i;
        StringBuffer stringBuffer = new StringBuffer(((bArr.length - 1) / 3) << 6);
        int i2 = 0;
        for (i = 0; i < bArr.length; i = i + 1) {
            int i3 = i % 3;
            int i4 = 16 - (i3 * 8);
            int i5 = i2 | ((bArr[i] << i4) & (255 << i4));
            if (i3 != 2) {
                i2 = i5;
                i = i != bArr.length - 1 ? i + 1 : 0;
            }
            char[] cArr = f14385a;
            stringBuffer.append(cArr[(16515072 & i5) >>> 18]);
            stringBuffer.append(cArr[(258048 & i5) >>> 12]);
            stringBuffer.append(cArr[(i5 & 4032) >>> 6]);
            stringBuffer.append(cArr[i5 & 63]);
            i2 = 0;
        }
        if (bArr.length % 3 > 0) {
            stringBuffer.setCharAt(stringBuffer.length() - 1, '=');
        }
        if (bArr.length % 3 == 1) {
            stringBuffer.setCharAt(stringBuffer.length() - 2, '=');
        }
        return stringBuffer.toString();
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length % 4 != 0) {
            throw new IllegalArgumentException("Base64 string length must be 4*n");
        }
        if (str.length() == 0) {
            return new byte[0];
        }
        int i = str.charAt(length - 1) == '=' ? 1 : 0;
        int i2 = i;
        if (str.charAt(length - 2) == '=') {
            i2 = i + 1;
        }
        int i3 = ((length / 4) * 3) - i2;
        byte[] bArr = new byte[i3];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length) {
                return bArr;
            }
            int i6 = (i5 / 4) * 3;
            char charAt = str.charAt(i5);
            char charAt2 = str.charAt(i5 + 1);
            char charAt3 = str.charAt(i5 + 2);
            char charAt4 = str.charAt(i5 + 3);
            byte[] bArr2 = b;
            int i7 = (bArr2[charAt] << 18) | (bArr2[charAt2] << 12) | (bArr2[charAt3] << 6) | bArr2[charAt4];
            bArr[i6] = (byte) ((16711680 & i7) >> 16);
            if (i5 < length - 4) {
                bArr[i6 + 1] = (byte) ((65280 & i7) >> 8);
                bArr[i6 + 2] = (byte) (i7 & 255);
            } else {
                int i8 = i6 + 1;
                if (i8 < i3) {
                    bArr[i8] = (byte) ((65280 & i7) >> 8);
                }
                int i9 = i6 + 2;
                if (i9 < i3) {
                    bArr[i9] = (byte) (i7 & 255);
                }
            }
            i4 = i5 + 4;
        }
    }
}
