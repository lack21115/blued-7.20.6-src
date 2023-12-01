package com.opos.exoplayer.core.c;

import com.anythink.expressad.exoplayer.k.o;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/j.class */
public final class j {
    private static final String[] h = {o.u, o.v, "audio/mpeg"};
    private static final int[] i = {44100, 48000, 32000};
    private static final int[] j = {32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448};
    private static final int[] k = {32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256};
    private static final int[] l = {32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384};
    private static final int[] m = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320};
    private static final int[] n = {8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};

    /* renamed from: a  reason: collision with root package name */
    public int f25247a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public int f25248c;
    public int d;
    public int e;
    public int f;
    public int g;

    public static int a(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if ((i2 & (-2097152)) != -2097152 || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return -1;
        }
        int i8 = i[i6];
        if (i3 == 2) {
            i7 = i8 / 2;
        } else {
            i7 = i8;
            if (i3 == 0) {
                i7 = i8 / 4;
            }
        }
        int i9 = (i2 >>> 9) & 1;
        if (i4 == 3) {
            return ((((i3 == 3 ? j[i5 - 1] : k[i5 - 1]) * 12000) / i7) + i9) * 4;
        }
        int i10 = i3 == 3 ? i4 == 2 ? l[i5 - 1] : m[i5 - 1] : n[i5 - 1];
        int i11 = 144000;
        if (i3 == 3) {
            return ((i10 * 144000) / i7) + i9;
        }
        if (i4 == 1) {
            i11 = 72000;
        }
        return ((i11 * i10) / i7) + i9;
    }

    private void a(int i2, String str, int i3, int i4, int i5, int i6, int i7) {
        this.f25247a = i2;
        this.b = str;
        this.f25248c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
    }

    public static boolean a(int i2, j jVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z = false;
        if ((i2 & (-2097152)) != -2097152 || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0) {
            return false;
        }
        int i10 = (i2 >>> 12) & 15;
        if (i10 != 0) {
            if (i10 == 15 || (i5 = (i2 >>> 10) & 3) == 3) {
                return false;
            }
            int i11 = i[i5];
            if (i3 == 2) {
                i6 = i11 / 2;
            } else {
                i6 = i11;
                if (i3 == 0) {
                    i6 = i11 / 4;
                }
            }
            int i12 = (i2 >>> 9) & 1;
            int i13 = 1152;
            if (i4 == 3) {
                i9 = i3 == 3 ? j[i10 - 1] : k[i10 - 1];
                i7 = (((i9 * 12000) / i6) + i12) * 4;
                i8 = 384;
            } else {
                int i14 = 144000;
                if (i3 == 3) {
                    i9 = i4 == 2 ? l[i10 - 1] : m[i10 - 1];
                    i7 = i12 + ((144000 * i9) / i6);
                    i8 = 1152;
                } else {
                    int i15 = n[i10 - 1];
                    if (i4 == 1) {
                        i13 = 576;
                    }
                    if (i4 == 1) {
                        i14 = 72000;
                    }
                    i7 = i12 + ((i14 * i15) / i6);
                    i8 = i13;
                    i9 = i15;
                }
            }
            jVar.a(i3, h[3 - i4], i7, i6, ((i2 >> 6) & 3) == 3 ? 1 : 2, i9 * 1000, i8);
            z = true;
        }
        return z;
    }
}
