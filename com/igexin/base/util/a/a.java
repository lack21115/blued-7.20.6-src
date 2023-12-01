package com.igexin.base.util.a;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/base/util/a/a.class */
public final class a {
    private static void a(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    public static boolean a(byte[] bArr) {
        int length = bArr.length;
        if (length <= 0 || length > 256) {
            return false;
        }
        int length2 = bArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length2) {
                return true;
            }
            int i4 = i3;
            if ((bArr[i] & 255) == 14) {
                int i5 = i3 + 1;
                i4 = i5;
                if (i5 > 3) {
                    return false;
                }
            }
            i++;
            i2 = i4;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (!a(bArr2)) {
            throw new IllegalArgumentException("key is fail!");
        }
        if (bArr.length <= 0) {
            throw new IllegalArgumentException("data is fail!");
        }
        int[] iArr = new int[256];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 256) {
                break;
            }
            iArr[i2] = i2;
            i = i2 + 1;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            i3 = ((i3 + iArr[i4]) + (bArr2[i4 % bArr2.length] & 255)) % 256;
            a(iArr, i4, i3);
        }
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= length) {
                return bArr3;
            }
            i5 = (i5 + 1) % 256;
            i6 = (i6 + iArr[i5]) % 256;
            a(iArr, i5, i6);
            bArr3[i8] = (byte) (iArr[(iArr[i5] + iArr[i6]) % 256] ^ bArr[i8]);
            i7 = i8 + 1;
        }
    }
}
