package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.gq  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gq.class */
public final class gq {
    private static int a = 4;

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length;
        int i = a;
        int i2 = ((length / i) + 1) * i;
        byte[] bArr3 = new byte[i2];
        System.arraycopy((Object) bArr, 0, (Object) bArr3, 0, bArr.length);
        int i3 = length;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return a(a(a(bArr3), a(bArr2)));
            }
            bArr3[i4] = (byte) (i - (length % i));
            i3 = i4 + 1;
        }
    }

    private static byte[] a(int[] iArr) {
        int length = iArr.length << 2;
        byte[] bArr = new byte[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            bArr[i2] = (byte) ((iArr[i2 >>> 2] >>> ((i2 & 3) << 3)) & 255);
            i = i2 + 1;
        }
    }

    private static int[] a(byte[] bArr) {
        int[] iArr = new int[bArr.length >>> 2];
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return iArr;
            }
            int i3 = i2 >>> 2;
            iArr[i3] = iArr[i3] | ((bArr[i2] & 255) << ((i2 & 3) << 3));
            i = i2 + 1;
        }
    }

    private static int[] a(int[] iArr, int[] iArr2) {
        int i;
        int length = iArr.length - 1;
        if (length <= 0) {
            return iArr;
        }
        int[] iArr3 = iArr2;
        if (iArr2.length < 4) {
            iArr3 = new int[4];
            System.arraycopy((Object) iArr2, 0, (Object) iArr3, 0, iArr2.length);
        }
        int i2 = iArr[length];
        int i3 = (52 / (length + 1)) + 6;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i3 <= 0) {
                return iArr;
            }
            int i6 = i5 - 1640531527;
            int i7 = (i6 >>> 2) & 3;
            int i8 = 0;
            while (true) {
                i = i8;
                if (i < length) {
                    int i9 = i + 1;
                    int i10 = iArr[i9];
                    i2 = ((((i2 >>> 5) ^ (i10 << 2)) + ((i10 >>> 3) ^ (i2 << 4))) ^ ((i10 ^ i6) + (i2 ^ iArr3[(i & 3) ^ i7]))) + iArr[i];
                    iArr[i] = i2;
                    i8 = i9;
                }
            }
            int i11 = iArr[0];
            i2 = ((((i2 >>> 5) ^ (i11 << 2)) + ((i11 >>> 3) ^ (i2 << 4))) ^ ((i11 ^ i6) + (i2 ^ iArr3[i7 ^ (i & 3)]))) + iArr[length];
            iArr[length] = i2;
            i3--;
            i4 = i6;
        }
    }
}
