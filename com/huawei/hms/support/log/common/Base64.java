package com.huawei.hms.support.log.common;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/support/log/common/Base64.class */
public final class Base64 {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f22895a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/', '='};
    public static final byte[] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    public static int a(String str) {
        int i;
        int length = str.length();
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt <= 255) {
                i = length;
                if (b[charAt] >= 0) {
                    i2++;
                    length = i;
                }
            }
            i = length - 1;
            i2++;
            length = i;
        }
        return length;
    }

    public static byte[] decode(String str) {
        int a2 = a(str);
        int i = (a2 / 4) * 3;
        int i2 = a2 % 4;
        int i3 = i;
        if (i2 == 3) {
            i3 = i + 2;
        }
        int i4 = i3;
        if (i2 == 2) {
            i4 = i3 + 1;
        }
        byte[] bArr = new byte[i4];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i5 >= str.length()) {
                break;
            }
            char charAt = str.charAt(i5);
            byte b2 = charAt > 255 ? (byte) -1 : b[charAt];
            int i10 = i6;
            int i11 = i7;
            int i12 = i9;
            if (b2 >= 0) {
                int i13 = i9 + 6;
                int i14 = (i7 << 6) | b2;
                i10 = i6;
                i11 = i14;
                i12 = i13;
                if (i13 >= 8) {
                    i12 = i13 - 8;
                    bArr[i6] = (byte) (255 & (i14 >> i12));
                    i10 = i6 + 1;
                    i11 = i14;
                }
            }
            i5++;
            i6 = i10;
            i7 = i11;
            i8 = i12;
        }
        return i6 != i4 ? new byte[0] : bArr;
    }

    public static String encode(byte[] bArr) {
        return encode(bArr, bArr.length);
    }

    public static String encode(byte[] bArr, int i) {
        boolean z;
        char[] cArr = new char[((i + 2) / 3) * 4];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= i) {
                return new String(cArr);
            }
            int i5 = (bArr[i2] & 255) << 8;
            int i6 = i2 + 1;
            boolean z2 = true;
            if (i6 < i) {
                i5 |= bArr[i6] & 255;
                z = true;
            } else {
                z = false;
            }
            int i7 = i5 << 8;
            int i8 = i2 + 2;
            if (i8 < i) {
                i7 |= bArr[i8] & 255;
            } else {
                z2 = false;
            }
            cArr[i4 + 3] = f22895a[z2 ? i7 & 63 : 64];
            int i9 = i7 >> 6;
            char[] cArr2 = f22895a;
            int i10 = 64;
            if (z) {
                i10 = i9 & 63;
            }
            cArr[i4 + 2] = cArr2[i10];
            int i11 = i9 >> 6;
            char[] cArr3 = f22895a;
            cArr[i4 + 1] = cArr3[i11 & 63];
            cArr[i4 + 0] = cArr3[(i11 >> 6) & 63];
            i2 += 3;
            i3 = i4 + 4;
        }
    }
}
