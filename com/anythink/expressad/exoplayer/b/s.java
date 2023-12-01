package com.anythink.expressad.exoplayer.b;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/s.class */
final class s {

    /* renamed from: a  reason: collision with root package name */
    private static final int f7216a = 65;
    private static final int b = 400;

    /* renamed from: c  reason: collision with root package name */
    private static final int f7217c = 4000;
    private final int d;
    private final int e;
    private final float f;
    private final float g;
    private final float h;
    private final int i;
    private final int j;
    private final int k;
    private final short[] l;
    private short[] m;
    private int n;
    private short[] o;
    private int p;
    private short[] q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;

    public s(int i, int i2, float f, float f2, int i3) {
        this.d = i;
        this.e = i2;
        this.f = f;
        this.g = f2;
        this.h = i / i3;
        this.i = i / 400;
        int i4 = i / 65;
        this.j = i4;
        int i5 = i4 * 2;
        this.k = i5;
        this.l = new short[i5];
        this.m = new short[i5 * i2];
        this.o = new short[i5 * i2];
        this.q = new short[i5 * i2];
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00fb, code lost:
        if ((r0 * 2) <= (r7.w * 3)) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a(short[] r8, int r9) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.b.s.a(short[], int):int");
    }

    private int a(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f >= 2.0f) {
            i3 = (int) (i2 / (f - 1.0f));
        } else {
            this.u = (int) ((i2 * (2.0f - f)) / (f - 1.0f));
            i3 = i2;
        }
        short[] a2 = a(this.o, this.p, i3);
        this.o = a2;
        a(i3, this.e, a2, this.p, sArr, i, sArr, i + i2);
        this.p += i3;
        return i3;
    }

    private int a(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.e;
        int i5 = 1;
        int i6 = 255;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i2 > i3) {
                this.x = i5 / i7;
                this.y = i9 / i6;
                return i7;
            }
            int i10 = 0;
            for (int i11 = 0; i11 < i2; i11++) {
                i10 += Math.abs(sArr[i4 + i11] - sArr[(i4 + i2) + i11]);
            }
            int i12 = i5;
            int i13 = i7;
            if (i10 * i7 < i5 * i2) {
                i13 = i2;
                i12 = i10;
            }
            int i14 = i6;
            int i15 = i9;
            if (i10 * i6 > i9 * i2) {
                i14 = i2;
                i15 = i10;
            }
            i2++;
            i5 = i12;
            i6 = i14;
            i7 = i13;
            i8 = i15;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0141, code lost:
        if ((r0 * 2) <= (r10.w * 3)) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(float r11) {
        /*
            Method dump skipped, instructions count: 673
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.b.s.a(float):void");
    }

    private void a(float f, int i) {
        int i2;
        int i3;
        int i4;
        boolean z;
        if (this.p == i) {
            return;
        }
        int i5 = this.d;
        int i6 = (int) (i5 / f);
        while (true) {
            if (i6 <= 16384 && i5 <= 16384) {
                break;
            }
            i6 /= 2;
            i5 /= 2;
        }
        int i7 = this.p - i;
        short[] a2 = a(this.q, this.r, i7);
        this.q = a2;
        short[] sArr = this.o;
        int i8 = this.e;
        System.arraycopy((Object) sArr, i * i8, (Object) a2, this.r * i8, i8 * i7);
        this.p = i;
        this.r += i7;
        int i9 = 0;
        while (true) {
            int i10 = i9;
            i2 = this.r;
            if (i10 >= i2 - 1) {
                break;
            }
            while (true) {
                i3 = this.s;
                i4 = this.t;
                z = true;
                if ((i3 + 1) * i6 <= i4 * i5) {
                    break;
                }
                this.o = a(this.o, this.p, 1);
                int i11 = 0;
                while (true) {
                    int i12 = i11;
                    int i13 = this.e;
                    if (i12 < i13) {
                        short[] sArr2 = this.o;
                        int i14 = this.p;
                        short[] sArr3 = this.q;
                        int i15 = (i10 * i13) + i12;
                        short s = sArr3[i15];
                        short s2 = sArr3[i15 + i13];
                        int i16 = this.t;
                        int i17 = this.s;
                        int i18 = (i17 + 1) * i6;
                        int i19 = i18 - (i16 * i5);
                        int i20 = i18 - (i17 * i6);
                        sArr2[(i14 * i13) + i12] = (short) (((s * i19) + ((i20 - i19) * s2)) / i20);
                        i11 = i12 + 1;
                    }
                }
                this.t++;
                this.p++;
            }
            int i21 = i3 + 1;
            this.s = i21;
            if (i21 == i5) {
                this.s = 0;
                if (i4 != i6) {
                    z = false;
                }
                com.anythink.expressad.exoplayer.k.a.b(z);
                this.t = 0;
            }
            i9 = i10 + 1;
        }
        int i22 = i2 - 1;
        if (i22 != 0) {
            short[] sArr4 = this.q;
            int i23 = this.e;
            System.arraycopy((Object) sArr4, i22 * i23, (Object) sArr4, 0, (i2 - i22) * i23);
            this.r -= i22;
        }
    }

    private void a(int i) {
        int i2 = this.n - i;
        short[] sArr = this.m;
        int i3 = this.e;
        System.arraycopy((Object) sArr, i * i3, (Object) sArr, 0, i3 * i2);
        this.n = i2;
    }

    private static void a(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= i2) {
                return;
            }
            int i8 = (i3 * i2) + i7;
            int i9 = (i5 * i2) + i7;
            int i10 = (i4 * i2) + i7;
            int i11 = 0;
            while (true) {
                int i12 = i11;
                if (i12 < i) {
                    sArr[i8] = (short) (((sArr2[i10] * (i - i12)) + (sArr3[i9] * i12)) / i);
                    i8 += i2;
                    i10 += i2;
                    i9 += i2;
                    i11 = i12 + 1;
                }
            }
            i6 = i7 + 1;
        }
    }

    private boolean a(int i, int i2) {
        return i != 0 && this.v != 0 && i2 <= i * 3 && i * 2 > this.w * 3;
    }

    private short[] a(short[] sArr, int i, int i2) {
        int length = sArr.length;
        int i3 = this.e;
        int i4 = length / i3;
        return i + i2 <= i4 ? sArr : Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
    }

    private int b(int i) {
        int min = Math.min(this.k, this.u);
        b(this.m, i, min);
        this.u -= min;
        return min;
    }

    private int b(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f < 0.5f) {
            i3 = (int) ((i2 * f) / (1.0f - f));
        } else {
            this.u = (int) ((i2 * ((2.0f * f) - 1.0f)) / (1.0f - f));
            i3 = i2;
        }
        int i4 = i2 + i3;
        short[] a2 = a(this.o, this.p, i4);
        this.o = a2;
        int i5 = this.e;
        System.arraycopy((Object) sArr, i * i5, (Object) a2, this.p * i5, i5 * i2);
        a(i3, this.e, this.o, this.p + i2, sArr, i + i2, sArr, i);
        this.p += i4;
        return i3;
    }

    private short b(short[] sArr, int i, int i2, int i3) {
        short s = sArr[i];
        short s2 = sArr[i + this.e];
        int i4 = this.t;
        int i5 = this.s;
        int i6 = (i5 + 1) * i3;
        int i7 = i6 - (i4 * i2);
        int i8 = i6 - (i5 * i3);
        return (short) (((s * i7) + ((i8 - i7) * s2)) / i8);
    }

    private void b(short[] sArr, int i, int i2) {
        short[] a2 = a(this.o, this.p, i2);
        this.o = a2;
        int i3 = this.e;
        System.arraycopy((Object) sArr, i * i3, (Object) a2, this.p * i3, i3 * i2);
        this.p += i2;
    }

    private void c(int i) {
        int i2 = this.p - i;
        short[] a2 = a(this.q, this.r, i2);
        this.q = a2;
        short[] sArr = this.o;
        int i3 = this.e;
        System.arraycopy((Object) sArr, i * i3, (Object) a2, this.r * i3, i3 * i2);
        this.p = i;
        this.r += i2;
    }

    private void c(short[] sArr, int i, int i2) {
        int i3 = this.k / i2;
        int i4 = this.e;
        int i5 = i2 * i4;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= i3) {
                return;
            }
            short s = 0;
            for (int i8 = 0; i8 < i5; i8++) {
                s += sArr[(i7 * i5) + (i * i4) + i8];
            }
            this.l[i7] = (short) (s / i5);
            i6 = i7 + 1;
        }
    }

    private void d() {
        int i = this.p;
        float f = this.f;
        float f2 = this.g;
        float f3 = f / f2;
        float f4 = this.h * f2;
        double d = f3;
        if (d > 1.00001d || d < 0.99999d) {
            a(f3);
        } else {
            b(this.m, 0, this.n);
            this.n = 0;
        }
        if (f4 != 1.0f) {
            a(f4, i);
        }
    }

    private void d(int i) {
        if (i == 0) {
            return;
        }
        short[] sArr = this.q;
        int i2 = this.e;
        System.arraycopy((Object) sArr, i * i2, (Object) sArr, 0, (this.r - i) * i2);
        this.r -= i;
    }

    public final void a() {
        int i;
        int i2 = this.n;
        float f = this.f;
        float f2 = this.g;
        int i3 = this.p + ((int) ((((i2 / (f / f2)) + this.r) / (this.h * f2)) + 0.5f));
        this.m = a(this.m, i2, (this.k * 2) + i2);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            i = this.k;
            int i6 = this.e;
            if (i5 >= i * 2 * i6) {
                break;
            }
            this.m[(i6 * i2) + i5] = 0;
            i4 = i5 + 1;
        }
        this.n += i * 2;
        d();
        if (this.p > i3) {
            this.p = i3;
        }
        this.n = 0;
        this.u = 0;
        this.r = 0;
    }

    public final void a(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.e;
        int i2 = remaining / i;
        short[] a2 = a(this.m, this.n, i2);
        this.m = a2;
        shortBuffer.get(a2, this.n * this.e, ((i * i2) * 2) / 2);
        this.n += i2;
        d();
    }

    public final void b() {
        this.n = 0;
        this.p = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
    }

    public final void b(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.e, this.p);
        shortBuffer.put(this.o, 0, this.e * min);
        int i = this.p - min;
        this.p = i;
        short[] sArr = this.o;
        int i2 = this.e;
        System.arraycopy((Object) sArr, min * i2, (Object) sArr, 0, i * i2);
    }

    public final int c() {
        return this.p;
    }
}
