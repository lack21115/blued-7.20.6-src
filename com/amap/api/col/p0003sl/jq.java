package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.jq  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jq.class */
public final class jq {
    private static int a = 4;

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        int i;
        if (bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length;
        int i2 = a;
        int i3 = ((length / i2) + 1) * i2;
        byte[] bArr3 = new byte[i3];
        System.arraycopy((Object) bArr, 0, (Object) bArr3, 0, bArr.length);
        int i4 = length;
        while (true) {
            int i5 = i4;
            if (i5 >= i3) {
                break;
            }
            bArr3[i5] = (byte) (i2 - (length % i2));
            i4 = i5 + 1;
        }
        int[] a2 = a(bArr3);
        int[] a3 = a(bArr2);
        int length2 = a2.length - 1;
        if (length2 > 0) {
            int[] iArr = a3;
            if (a3.length < 4) {
                iArr = new int[4];
                System.arraycopy((Object) a3, 0, (Object) iArr, 0, a3.length);
            }
            int i6 = a2[length2];
            int i7 = (52 / (length2 + 1)) + 6;
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i7 <= 0) {
                    break;
                }
                int i10 = i9 - 1640531527;
                int i11 = (i10 >>> 2) & 3;
                int i12 = 0;
                while (true) {
                    i = i12;
                    if (i < length2) {
                        int i13 = i + 1;
                        int i14 = a2[i13];
                        i6 = ((((i6 >>> 5) ^ (i14 << 2)) + ((i14 >>> 3) ^ (i6 << 4))) ^ ((i14 ^ i10) + (i6 ^ iArr[(i & 3) ^ i11]))) + a2[i];
                        a2[i] = i6;
                        i12 = i13;
                    }
                }
                int i15 = a2[0];
                i6 = ((((i6 >>> 5) ^ (i15 << 2)) + ((i15 >>> 3) ^ (i6 << 4))) ^ ((i15 ^ i10) + (i6 ^ iArr[i11 ^ (i & 3)]))) + a2[length2];
                a2[length2] = i6;
                i7--;
                i8 = i10;
            }
        }
        int length3 = a2.length << 2;
        byte[] bArr4 = new byte[length3];
        int i16 = 0;
        while (true) {
            int i17 = i16;
            if (i17 >= length3) {
                return bArr4;
            }
            bArr4[i17] = (byte) ((a2[i17 >>> 2] >>> ((i17 & 3) << 3)) & 255);
            i16 = i17 + 1;
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
}
