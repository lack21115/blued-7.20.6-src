package com.opos.exoplayer.core.a;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/n.class */
final class n {

    /* renamed from: a  reason: collision with root package name */
    private final int f25043a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final float f25044c;
    private final float d;
    private final float e;
    private final int f;
    private final int g;
    private final int h;
    private final short[] i;
    private int j;
    private short[] k;
    private int l;
    private short[] m;
    private int n;
    private short[] o;
    private int r;
    private int s;
    private int t;
    private int u;
    private int w;
    private int x;
    private int y;
    private int p = 0;
    private int q = 0;
    private int v = 0;

    public n(int i, int i2, float f, float f2, int i3) {
        this.f25043a = i;
        this.b = i2;
        this.f = i / 400;
        int i4 = i / 65;
        this.g = i4;
        int i5 = i4 * 2;
        this.h = i5;
        this.i = new short[i5];
        this.j = i5;
        this.k = new short[i5 * i2];
        this.l = i5;
        this.m = new short[i5 * i2];
        this.n = i5;
        this.o = new short[i5 * i2];
        this.f25044c = f;
        this.d = f2;
        this.e = i / i3;
    }

    private int a(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f >= 2.0f) {
            i3 = (int) (i2 / (f - 1.0f));
        } else {
            this.u = (int) ((i2 * (2.0f - f)) / (f - 1.0f));
            i3 = i2;
        }
        a(i3);
        a(i3, this.b, this.m, this.s, sArr, i, sArr, i + i2);
        this.s += i3;
        return i3;
    }

    private int a(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.b;
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

    private int a(short[] sArr, int i, boolean z) {
        int i2;
        int i3 = this.f25043a;
        int i4 = i3 > 4000 ? i3 / 4000 : 1;
        if (this.b == 1 && i4 == 1) {
            i2 = a(sArr, i, this.f, this.g);
        } else {
            b(sArr, i, i4);
            int a2 = a(this.i, 0, this.f / i4, this.g / i4);
            if (i4 != 1) {
                int i5 = a2 * i4;
                int i6 = i4 * 4;
                int i7 = i5 - i6;
                int i8 = i5 + i6;
                int i9 = this.f;
                int i10 = i7;
                if (i7 < i9) {
                    i10 = i9;
                }
                int i11 = this.g;
                int i12 = i8;
                if (i8 > i11) {
                    i12 = i11;
                }
                if (this.b == 1) {
                    i2 = a(sArr, i, i10, i12);
                } else {
                    b(sArr, i, 1);
                    i2 = a(this.i, 0, i10, i12);
                }
            } else {
                i2 = a2;
            }
        }
        int i13 = a(this.x, this.y, z) ? this.v : i2;
        this.w = this.x;
        this.v = i2;
        return i13;
    }

    private void a(float f) {
        int a2;
        int i;
        int i2 = this.r;
        if (i2 < this.h) {
            return;
        }
        int i3 = 0;
        do {
            if (this.u > 0) {
                a2 = d(i3);
            } else {
                int a3 = a(this.k, i3, true);
                short[] sArr = this.k;
                a2 = ((double) f) > 1.0d ? a3 + a(sArr, i3, f, a3) : b(sArr, i3, f, a3);
            }
            i = i3 + a2;
            i3 = i;
        } while (this.h + i <= i2);
        c(i);
    }

    private void a(float f, int i) {
        int i2;
        int i3;
        if (this.s == i) {
            return;
        }
        int i4 = this.f25043a;
        int i5 = (int) (i4 / f);
        while (true) {
            if (i5 <= 16384 && i4 <= 16384) {
                break;
            }
            i5 /= 2;
            i4 /= 2;
        }
        e(i);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            int i8 = this.t;
            boolean z = true;
            if (i7 >= i8 - 1) {
                f(i8 - 1);
                return;
            }
            while (true) {
                i2 = this.p;
                i3 = this.q;
                if ((i2 + 1) * i5 <= i3 * i4) {
                    break;
                }
                a(1);
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    int i11 = this.b;
                    if (i10 < i11) {
                        this.m[(this.s * i11) + i10] = b(this.o, (i11 * i7) + i10, i4, i5);
                        i9 = i10 + 1;
                    }
                }
                this.q++;
                this.s++;
            }
            int i12 = i2 + 1;
            this.p = i12;
            if (i12 == i4) {
                this.p = 0;
                if (i3 != i5) {
                    z = false;
                }
                com.opos.exoplayer.core.i.a.b(z);
                this.q = 0;
            }
            i6 = i7 + 1;
        }
    }

    private void a(int i) {
        int i2 = this.s;
        int i3 = this.l;
        if (i2 + i > i3) {
            int i4 = i3 + (i3 / 2) + i;
            this.l = i4;
            this.m = Arrays.copyOf(this.m, i4 * this.b);
        }
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

    private void a(short[] sArr, int i, int i2) {
        a(i2);
        int i3 = this.b;
        System.arraycopy((Object) sArr, i * i3, (Object) this.m, this.s * i3, i3 * i2);
        this.s += i2;
    }

    private boolean a(int i, int i2, boolean z) {
        if (i == 0 || this.v == 0) {
            return false;
        }
        return z ? i2 <= i * 3 && i * 2 > this.w * 3 : i > this.w;
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
        a(i4);
        int i5 = this.b;
        System.arraycopy((Object) sArr, i5 * i, (Object) this.m, this.s * i5, i5 * i2);
        a(i3, this.b, this.m, this.s + i2, sArr, i + i2, sArr, i);
        this.s += i4;
        return i3;
    }

    private short b(short[] sArr, int i, int i2, int i3) {
        short s = sArr[i];
        short s2 = sArr[this.b + i];
        int i4 = this.q;
        int i5 = this.p;
        int i6 = (i5 + 1) * i3;
        int i7 = i6 - (i4 * i2);
        int i8 = i6 - (i5 * i3);
        return (short) (((s * i7) + (s2 * (i8 - i7))) / i8);
    }

    private void b(int i) {
        int i2 = this.r;
        int i3 = this.j;
        if (i2 + i > i3) {
            int i4 = i3 + (i3 / 2) + i;
            this.j = i4;
            this.k = Arrays.copyOf(this.k, i4 * this.b);
        }
    }

    private void b(short[] sArr, int i, int i2) {
        int i3 = this.h / i2;
        int i4 = this.b;
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
            this.i[i7] = (short) (s / i5);
            i6 = i7 + 1;
        }
    }

    private void c() {
        int i = this.s;
        float f = this.f25044c;
        float f2 = this.d;
        float f3 = f / f2;
        float f4 = this.e * f2;
        double d = f3;
        if (d > 1.00001d || d < 0.99999d) {
            a(f3);
        } else {
            a(this.k, 0, this.r);
            this.r = 0;
        }
        if (f4 != 1.0f) {
            a(f4, i);
        }
    }

    private void c(int i) {
        int i2 = this.r - i;
        short[] sArr = this.k;
        int i3 = this.b;
        System.arraycopy((Object) sArr, i * i3, (Object) sArr, 0, i3 * i2);
        this.r = i2;
    }

    private int d(int i) {
        int min = Math.min(this.h, this.u);
        a(this.k, i, min);
        this.u -= min;
        return min;
    }

    private void e(int i) {
        int i2 = this.s - i;
        int i3 = this.t;
        int i4 = this.n;
        if (i3 + i2 > i4) {
            int i5 = i4 + (i4 / 2) + i2;
            this.n = i5;
            this.o = Arrays.copyOf(this.o, i5 * this.b);
        }
        short[] sArr = this.m;
        int i6 = this.b;
        System.arraycopy((Object) sArr, i6 * i, (Object) this.o, this.t * i6, i6 * i2);
        this.s = i;
        this.t = i2 + this.t;
    }

    private void f(int i) {
        if (i == 0) {
            return;
        }
        short[] sArr = this.o;
        int i2 = this.b;
        System.arraycopy((Object) sArr, i2 * i, (Object) sArr, 0, (this.t - i) * i2);
        this.t -= i;
    }

    public void a() {
        int i;
        int i2 = this.r;
        float f = this.f25044c;
        float f2 = this.d;
        int i3 = this.s + ((int) ((((i2 / (f / f2)) + this.t) / (this.e * f2)) + 0.5f));
        b((this.h * 2) + i2);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            i = this.h;
            int i6 = this.b;
            if (i5 >= i * 2 * i6) {
                break;
            }
            this.k[(i6 * i2) + i5] = (short) 0;
            i4 = i5 + 1;
        }
        this.r += i * 2;
        c();
        if (this.s > i3) {
            this.s = i3;
        }
        this.r = 0;
        this.u = 0;
        this.t = 0;
    }

    public void a(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.b;
        int i2 = remaining / i;
        b(i2);
        shortBuffer.get(this.k, this.r * this.b, ((i * i2) * 2) / 2);
        this.r = i2 + this.r;
        c();
    }

    public int b() {
        return this.s;
    }

    public void b(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.b, this.s);
        shortBuffer.put(this.m, 0, this.b * min);
        int i = this.s - min;
        this.s = i;
        short[] sArr = this.m;
        int i2 = this.b;
        System.arraycopy((Object) sArr, min * i2, (Object) sArr, 0, i * i2);
    }
}
