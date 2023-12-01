package com.sina.weibo.sdk.utils;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/utils/Base64.class */
public final class Base64 {
    private static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
    private static byte[] codes = new byte[256];

    static {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 256) {
                break;
            }
            codes[i2] = -1;
            i = i2 + 1;
        }
        int i3 = 65;
        while (true) {
            int i4 = i3;
            if (i4 > 90) {
                break;
            }
            codes[i4] = (byte) (i4 - 65);
            i3 = i4 + 1;
        }
        int i5 = 97;
        while (true) {
            int i6 = i5;
            if (i6 > 122) {
                break;
            }
            codes[i6] = (byte) ((i6 + 26) - 97);
            i5 = i6 + 1;
        }
        int i7 = 48;
        while (true) {
            int i8 = i7;
            if (i8 > 57) {
                byte[] bArr = codes;
                bArr[43] = 62;
                bArr[47] = 63;
                return;
            }
            codes[i8] = (byte) ((i8 + 52) - 48);
            i7 = i8 + 1;
        }
    }

    public static byte[] decode(byte[] bArr) {
        int length = ((bArr.length + 3) / 4) * 3;
        int i = length;
        if (bArr.length > 0) {
            i = length;
            if (bArr[bArr.length - 1] == 61) {
                i = length - 1;
            }
        }
        int i2 = i;
        if (bArr.length > 1) {
            i2 = i;
            if (bArr[bArr.length - 2] == 61) {
                i2 = i - 1;
            }
        }
        byte[] bArr2 = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i3 >= bArr.length) {
                break;
            }
            byte b = codes[bArr[i3] & 255];
            int i8 = i4;
            int i9 = i5;
            int i10 = i7;
            if (b >= 0) {
                int i11 = i7 + 6;
                int i12 = (i5 << 6) | b;
                i8 = i4;
                i9 = i12;
                i10 = i11;
                if (i11 >= 8) {
                    i10 = i11 - 8;
                    bArr2[i4] = (byte) ((i12 >> i10) & 255);
                    i8 = i4 + 1;
                    i9 = i12;
                }
            }
            i3++;
            i4 = i8;
            i5 = i9;
            i6 = i10;
        }
        if (i4 == i2) {
            return bArr2;
        }
        throw new RuntimeException("miscalculated data length!");
    }

    public static char[] encode(byte[] bArr) {
        boolean z;
        char[] cArr = new char[((bArr.length + 2) / 3) * 4];
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= bArr.length) {
                return cArr;
            }
            int i4 = (bArr[i] & 255) << 8;
            int i5 = i + 1;
            boolean z2 = true;
            if (i5 < bArr.length) {
                i4 |= bArr[i5] & 255;
                z = true;
            } else {
                z = false;
            }
            int i6 = i4 << 8;
            int i7 = i + 2;
            if (i7 < bArr.length) {
                i6 |= bArr[i7] & 255;
            } else {
                z2 = false;
            }
            cArr[i3 + 3] = alphabet[z2 ? i6 & 63 : 64];
            int i8 = i6 >> 6;
            char[] cArr2 = alphabet;
            int i9 = 64;
            if (z) {
                i9 = i8 & 63;
            }
            cArr[i3 + 2] = cArr2[i9];
            int i10 = i8 >> 6;
            char[] cArr3 = alphabet;
            cArr[i3 + 1] = cArr3[i10 & 63];
            cArr[i3 + 0] = cArr3[(i10 >> 6) & 63];
            i += 3;
            i2 = i3 + 4;
        }
    }

    public static byte[] encodebyte(byte[] bArr) {
        boolean z;
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= bArr.length) {
                return bArr2;
            }
            int i4 = (bArr[i] & 255) << 8;
            int i5 = i + 1;
            boolean z2 = true;
            if (i5 < bArr.length) {
                i4 |= bArr[i5] & 255;
                z = true;
            } else {
                z = false;
            }
            int i6 = i4 << 8;
            int i7 = i + 2;
            if (i7 < bArr.length) {
                i6 |= bArr[i7] & 255;
            } else {
                z2 = false;
            }
            bArr2[i3 + 3] = (byte) alphabet[z2 ? i6 & 63 : 64];
            int i8 = i6 >> 6;
            char[] cArr = alphabet;
            int i9 = 64;
            if (z) {
                i9 = i8 & 63;
            }
            bArr2[i3 + 2] = (byte) cArr[i9];
            int i10 = i8 >> 6;
            char[] cArr2 = alphabet;
            bArr2[i3 + 1] = (byte) cArr2[i10 & 63];
            bArr2[i3 + 0] = (byte) cArr2[(i10 >> 6) & 63];
            i += 3;
            i2 = i3 + 4;
        }
    }
}
