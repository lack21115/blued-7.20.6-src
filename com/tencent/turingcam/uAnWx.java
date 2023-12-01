package com.tencent.turingcam;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/uAnWx.class */
public class uAnWx {
    private static void a(byte[] bArr, int[] iArr) {
        int i;
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= (length >> 2)) {
                break;
            }
            int i4 = i + 1;
            iArr[i2] = bArr[i] & 255;
            int i5 = i4 + 1;
            iArr[i2] = iArr[i2] | ((bArr[i4] & 255) << 8);
            int i6 = i5 + 1;
            iArr[i2] = iArr[i2] | ((bArr[i5] & 255) << 16);
            iArr[i2] = iArr[i2] | ((bArr[i6] & 255) << 24);
            i2++;
            i3 = i6 + 1;
        }
        if (i >= bArr.length) {
            return;
        }
        int i7 = i + 1;
        iArr[i2] = bArr[i] & 255;
        int i8 = 8;
        while (true) {
            int i9 = i8;
            if (i7 >= bArr.length) {
                return;
            }
            iArr[i2] = iArr[i2] | ((bArr[i7] & 255) << i9);
            i7++;
            i8 = i9 + 8;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        int i;
        int i2;
        byte[] bArr3 = bArr2;
        if (bArr2 != null) {
            bArr3 = bArr2;
            if (bArr2.length > 16) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(bArr2);
                    bArr3 = messageDigest.digest();
                } catch (NoSuchAlgorithmException e) {
                    bArr3 = null;
                }
            }
        }
        if (bArr == null || bArr3 == null) {
            return bArr;
        }
        if (bArr.length == 0) {
            return bArr;
        }
        if (bArr.length % 4 != 0 || bArr.length < 8) {
            return null;
        }
        int length = bArr.length >>> 2;
        int[] iArr = new int[length];
        a(bArr, iArr);
        int length2 = bArr3.length % 4 == 0 ? bArr3.length >>> 2 : (bArr3.length >>> 2) + 1;
        if (length2 < 4) {
            length2 = 4;
        }
        int[] iArr2 = new int[length2];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                break;
            }
            iArr2[i4] = 0;
            i3 = i4 + 1;
        }
        a(bArr3, iArr2);
        int i5 = length - 1;
        int i6 = iArr[i5];
        int i7 = iArr[0];
        int i8 = ((52 / (i5 + 1)) + 6) * (-1640531527);
        while (true) {
            int i9 = i8;
            if (i9 == 0) {
                break;
            }
            int i10 = (i9 >>> 2) & 3;
            int i11 = i5;
            while (true) {
                i2 = i11;
                if (i2 > 0) {
                    int i12 = iArr[i2 - 1];
                    i7 = iArr[i2] - (((i7 ^ i9) + (i12 ^ iArr2[(i2 & 3) ^ i10])) ^ (((i12 >>> 5) ^ (i7 << 2)) + ((i7 >>> 3) ^ (i12 << 4))));
                    iArr[i2] = i7;
                    i11 = i2 - 1;
                }
            }
            int i13 = iArr[i5];
            i7 = iArr[0] - (((i7 ^ i9) + (iArr2[i10 ^ (i2 & 3)] ^ i13)) ^ (((i13 >>> 5) ^ (i7 << 2)) + ((i7 >>> 3) ^ (i13 << 4))));
            iArr[0] = i7;
            i8 = i9 + 1640531527;
        }
        int i14 = iArr[i5];
        if (i14 < 0 || i14 > (i5 << 2)) {
            return null;
        }
        byte[] bArr4 = new byte[i14];
        int i15 = i14 >> 2;
        int i16 = i15;
        if (i15 > i5) {
            i16 = i5;
        }
        int i17 = 0;
        int i18 = 0;
        while (true) {
            i = i18;
            if (i >= i16) {
                break;
            }
            int i19 = i17 + 1;
            bArr4[i17] = (byte) (iArr[i] & 255);
            int i20 = i19 + 1;
            bArr4[i19] = (byte) ((iArr[i] >>> 8) & 255);
            int i21 = i20 + 1;
            bArr4[i20] = (byte) ((iArr[i] >>> 16) & 255);
            i17 = i21 + 1;
            bArr4[i21] = (byte) ((iArr[i] >>> 24) & 255);
            i18 = i + 1;
        }
        if (i5 > i16 && i17 < i14) {
            bArr4[i17] = (byte) (iArr[i] & 255);
            int i22 = 8;
            for (int i23 = i17 + 1; i22 <= 24 && i23 < i14; i23++) {
                bArr4[i23] = (byte) ((iArr[i] >>> i22) & 255);
                i22 += 8;
            }
        }
        return bArr4;
    }
}
