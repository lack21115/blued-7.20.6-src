package com.kwad.components.core.d.kwai;

import java.nio.ByteBuffer;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/d/kwai/c.class */
public final class c {
    private final int[] Iu;

    private c(int[] iArr) {
        this.Iu = iArr;
    }

    private static long a(int i, int[] iArr, long j) {
        long j2 = j >>> 48;
        long e = e(i, iArr, j2);
        return (e(i, iArr, j2) << 32) | ((((j & 65535) ^ e) ^ (i + 1)) << 48) | (((j >> 32) & 65535) << 16) | ((j >> 16) & 65535);
    }

    private static long a(long j, int[] iArr) {
        int i;
        long j2;
        int i2;
        long j3;
        int i3;
        long j4;
        int i4 = 0;
        long j5 = j;
        while (true) {
            i = i4;
            j2 = j5;
            if (i4 >= 8) {
                break;
            }
            j5 = a(i4, iArr, j5);
            i4++;
        }
        while (true) {
            i2 = i;
            j3 = j2;
            if (i >= 16) {
                break;
            }
            j2 = b(i, iArr, j2);
            i++;
        }
        while (true) {
            j4 = j3;
            if (i2 >= 24) {
                break;
            }
            j3 = a(i2, iArr, j3);
            i2++;
        }
        for (i3 = i2; i3 < 32; i3++) {
            j4 = b(i3, iArr, j4);
        }
        return j4;
    }

    public static c a(int[] iArr) {
        return new c(iArr);
    }

    private static long b(int i, int[] iArr, long j) {
        long j2 = j >>> 48;
        return (((i + 1) ^ (j2 ^ ((j >> 32) & 65535))) << 16) | ((j & 65535) << 48) | (e(i, iArr, j2) << 32) | ((j >> 16) & 65535);
    }

    private static long b(long j, int[] iArr) {
        int i;
        long j2;
        int i2;
        long j3;
        int i3;
        long j4;
        int i4 = 31;
        long j5 = j;
        while (true) {
            i = i4;
            j2 = j5;
            if (i4 <= 23) {
                break;
            }
            j5 = d(i4, iArr, j5);
            i4--;
        }
        while (true) {
            i2 = i;
            j3 = j2;
            if (i <= 15) {
                break;
            }
            j2 = c(i, iArr, j2);
            i--;
        }
        while (true) {
            j4 = j3;
            if (i2 <= 7) {
                break;
            }
            j3 = d(i2, iArr, j3);
            i2--;
        }
        for (i3 = i2; i3 >= 0; i3--) {
            j4 = c(i3, iArr, j4);
        }
        return j4;
    }

    private static long c(int i, int[] iArr, long j) {
        long j2 = (j >> 32) & 65535;
        return ((i + 1) ^ ((j >>> 48) ^ j2)) | ((j & 65535) << 16) | (f(i, iArr, j2) << 48) | (((j >> 16) & 65535) << 32);
    }

    private static long d(int i, int[] iArr, long j) {
        long j2 = (j >> 32) & 65535;
        long f = f(i, iArr, j2);
        return (((i + 1) ^ (f(i, iArr, j2) ^ ((j >> 16) & 65535))) << 32) | (f << 48) | ((j & 65535) << 16) | (j >>> 48);
    }

    private static long e(int i, int[] iArr, long j) {
        int i2 = (int) (j & 255);
        int i3 = i * 4;
        int i4 = iArr[i3 % 10];
        int i5 = iArr[(i3 + 1) % 10];
        int i6 = iArr[(i3 + 2) % 10];
        int i7 = iArr[(i3 + 3) % 10];
        int i8 = b.It[i4 ^ i2] ^ ((int) (j >>> 8));
        int i9 = b.It[i5 ^ i8] ^ i2;
        int i10 = i8 ^ b.It[i9 ^ i6];
        return (i10 << 8) | (b.It[i7 ^ i10] ^ i9);
    }

    private static long f(int i, int[] iArr, long j) {
        int i2 = (int) (j >>> 8);
        int i3 = i * 4;
        int i4 = iArr[(i3 + 3) % 10];
        int i5 = iArr[(i3 + 2) % 10];
        int i6 = iArr[(i3 + 1) % 10];
        int i7 = iArr[i3 % 10];
        int i8 = b.It[i4 ^ i2] ^ ((int) (255 & j));
        int i9 = b.It[i8 ^ i5] ^ i2;
        int i10 = i8 ^ b.It[i9 ^ i6];
        return i10 | ((b.It[i7 ^ i10] ^ i9) << 8);
    }

    public final long an(String str) {
        byte[] decode = com.kwad.sdk.core.kwai.c.vK().decode(str);
        if (decode == null || decode.length != 8) {
            throw new RuntimeException("fail to decode: " + str);
        }
        return b(ByteBuffer.wrap(decode).getLong(), this.Iu);
    }

    public final String p(long j) {
        return com.kwad.sdk.core.kwai.c.vI().encodeToString(ByteBuffer.allocate(8).putLong(a(j, this.Iu)).array());
    }
}
