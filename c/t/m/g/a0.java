package c.t.m.g;

import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/a0.class */
public class a0 {
    public static final a0 o = new a0();

    /* renamed from: a  reason: collision with root package name */
    public double[] f3733a = new double[141];
    public double[] b = new double[8];

    /* renamed from: c  reason: collision with root package name */
    public double[] f3734c = new double[7];
    public double[] d = new double[36];
    public double[] e = new double[128];
    public double[] f = new double[128];
    public double[] g = new double[128];
    public double[] h = null;
    public double[] i = null;
    public double[] j = null;
    public double[] k = null;
    public double[] l = null;
    public double[] m = null;
    public double[] n = null;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/a0$a.class */
    public enum a {
        TIME,
        FFT
    }

    public static double[] b(double[][] dArr) {
        return o.a(dArr);
    }

    public final void a(double[] dArr) {
        int length = dArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            dArr[i2] = 0.5d - (Math.cos((i2 * 6.283185307179586d) / (length - 1)) * 0.5d);
            i = i2 + 1;
        }
    }

    public final void a(double[] dArr, int i, double d) {
        int length = (dArr.length - i) / 2;
        int length2 = dArr.length;
        while (true) {
            int i2 = length2 - 1;
            if (i2 < 0) {
                return;
            }
            if (i2 >= i + length || i2 < length) {
                dArr[i2] = d;
            } else {
                dArr[i2] = dArr[i2 - length];
            }
            length2 = i2;
        }
    }

    public final void a(double[] dArr, int i, a aVar, double[] dArr2, double d) {
        if (aVar == a.TIME) {
            b(this.b, dArr2);
            double[] dArr3 = this.b;
            System.arraycopy((Object) dArr3, 0, (Object) dArr, i, dArr3.length);
        } else if (aVar == a.FFT) {
            a(this.f3734c, dArr2, d);
            double[] dArr4 = this.f3734c;
            System.arraycopy((Object) dArr4, 0, (Object) dArr, i, dArr4.length);
        }
    }

    public final void a(double[] dArr, double[] dArr2) {
        int i;
        int length = dArr2.length;
        Arrays.fill(dArr, 0.0d);
        System.arraycopy((Object) dArr2, 0, (Object) this.f, 0, dArr2.length);
        Arrays.sort(this.f);
        if (length % 2 == 0) {
            double[] dArr3 = this.f;
            int i2 = length / 2;
            dArr[0] = (dArr3[i2 - 1] + dArr3[i2]) / 2.0d;
        } else {
            dArr[0] = this.f[(int) Math.floor((length + 0) / 2.0d)];
        }
        double[] dArr4 = this.f;
        double d = dArr4[0];
        int i3 = length - 1;
        dArr[1] = (d + dArr4[i3]) / 2.0d;
        double b = h3.b(dArr2);
        double d2 = 1.0d / r.f3954c;
        Arrays.fill(this.g, 0.0d);
        double d3 = 0.0d;
        int i4 = 0;
        int i5 = 0;
        while (i4 < dArr2.length) {
            int i6 = i5;
            double d4 = d3;
            if (dArr2[i4] > b) {
                this.g[i5] = dArr2[i4];
                d4 = d3 + dArr2[i4];
                i6 = i5 + 1;
            }
            i4++;
            i5 = i6;
            d3 = d4;
        }
        double d5 = d3;
        if (i5 != 0) {
            d5 = d3 / i5;
        }
        a(this.g, i5, d5);
        double[] dArr5 = this.g;
        int length2 = (dArr5.length - i5) / 2;
        a(this.b, dArr5, length2, length2 + i5);
        dArr[2] = i5;
        double[] dArr6 = this.b;
        System.arraycopy((Object) dArr6, 0, (Object) dArr, 3, dArr6.length);
        a(this.f3734c, this.g, d2);
        double[] dArr7 = this.f3734c;
        System.arraycopy((Object) dArr7, 0, (Object) dArr, 11, dArr7.length);
        Arrays.fill(this.g, 0.0d);
        double d6 = 0.0d;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            i = i8;
            if (i7 >= dArr2.length) {
                break;
            }
            double d7 = d6;
            int i9 = i;
            if (dArr2[i7] < b) {
                this.g[i] = dArr2[i7];
                d7 = d6 + dArr2[i7];
                i9 = i + 1;
            }
            i7++;
            d6 = d7;
            i8 = i9;
        }
        double d8 = d6;
        if (i != 0) {
            d8 = d6 / i;
        }
        a(this.g, i, d8);
        double[] dArr8 = this.g;
        int length3 = (dArr8.length - i) / 2;
        a(this.b, dArr8, length3, length3 + i);
        dArr[18] = i;
        double[] dArr9 = this.b;
        System.arraycopy((Object) dArr9, 0, (Object) dArr, 19, dArr9.length);
        a(this.f3734c, this.g, d2);
        double[] dArr10 = this.f3734c;
        System.arraycopy((Object) dArr10, 0, (Object) dArr, 27, dArr10.length);
        double[] dArr11 = this.f;
        dArr[34] = dArr11[i3] - b;
        dArr[35] = b - dArr11[0];
    }

    public void a(double[] dArr, double[] dArr2, double d) {
        double[] dArr3;
        int length = dArr2.length;
        int i = (length / 2) + 1;
        double[] dArr4 = this.h;
        if (dArr4 == null || dArr4.length != length) {
            this.h = new double[length];
            this.i = new double[length];
            double[] dArr5 = new double[length];
            this.j = dArr5;
            this.k = new double[i];
            this.l = new double[i];
            this.m = new double[i];
            this.n = new double[i];
            a(dArr5);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                double[] dArr6 = this.l;
                if (i3 >= dArr6.length) {
                    break;
                }
                dArr6[i3] = ((i3 * (1.0d / d)) / 2.0d) / (i - 1);
                i2 = i3 + 1;
            }
        }
        Arrays.fill(dArr, 0.0d);
        System.arraycopy((Object) dArr2, 0, (Object) this.h, 0, length);
        Arrays.fill(this.i, 0.0d);
        double b = h3.b(this.h);
        double[] dArr7 = this.h;
        h3.a(dArr7, dArr7, b);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            dArr3 = this.h;
            if (i5 >= dArr3.length) {
                break;
            }
            dArr3[i5] = dArr3[i5] * this.j[i5];
            i4 = i5 + 1;
        }
        y2.a(dArr3, this.i);
        double d2 = -1.7976931348623157E308d;
        Arrays.fill(this.m, 0.0d);
        double d3 = 0.0d;
        double d4 = 0.0d;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= i) {
                break;
            }
            double[] dArr8 = this.k;
            double[] dArr9 = this.h;
            double d5 = dArr9[i7];
            double d6 = dArr9[i7];
            double[] dArr10 = this.i;
            dArr8[i7] = (Math.abs(Math.sqrt((d5 * d6) + (dArr10[i7] * dArr10[i7]))) * 2.0d) / i;
            double[] dArr11 = this.k;
            if (d2 <= dArr11[i7]) {
                d2 = dArr11[i7];
            }
            double[] dArr12 = this.k;
            d3 += dArr12[i7];
            double d7 = dArr12[i7] * dArr12[i7];
            double d8 = d7 * d7;
            d4 += d8;
            this.m[i7] = d8;
            i6 = i7 + 1;
        }
        double length2 = d3 / this.k.length;
        double d9 = 0.0d;
        double d10 = 0.0d;
        int i8 = 0;
        while (i8 < i) {
            double[] dArr13 = this.m;
            dArr13[i8] = d4 == 0.0d ? 0.0d : dArr13[i8] / d4;
            double d11 = d9 + (this.m[i8] * this.l[i8]);
            double d12 = d3 == 0.0d ? 0.0d : this.k[i8] / d3;
            double d13 = d12;
            if (d12 == 0.0d) {
                d13 = 1.0E-7d;
            }
            d10 -= d13 * Math.log(d13);
            i8++;
            d9 = d11;
        }
        h3.a(this.n, this.k, this.l);
        double b2 = h3.b(this.n);
        double a2 = h3.a(this.n, b2);
        double d14 = a2 == 0.0d ? 0.0d : b2 / a2;
        double a3 = h3.a(this.k, length2);
        dArr[0] = d9;
        dArr[1] = a3 == 0.0d ? 0.0d : length2 / a3;
        dArr[2] = length2;
        dArr[3] = d2;
        dArr[4] = b2;
        dArr[5] = d14;
        dArr[6] = d10;
    }

    public void a(double[] dArr, double[] dArr2, int i, int i2) {
        int i3;
        int i4;
        Arrays.fill(dArr, 0.0d);
        double d = 0.0d;
        for (int i5 = i; i5 < i2; i5++) {
            d += dArr2[i5];
        }
        double d2 = i2 - i;
        double d3 = d / d2;
        double d4 = -1.7976931348623157E308d;
        double d5 = Double.MAX_VALUE;
        int i6 = Integer.MIN_VALUE;
        int i7 = i;
        double d6 = 0.0d;
        double d7 = 0.0d;
        int i8 = Integer.MAX_VALUE;
        int i9 = 0;
        while (i7 < i2) {
            double d8 = d6 + ((dArr2[i7] - d3) * (dArr2[i7] - d3));
            double d9 = d4;
            if (d4 < dArr2[i7]) {
                d9 = dArr2[i7];
            }
            double d10 = d5;
            if (d5 > dArr2[i7]) {
                d10 = dArr2[i7];
            }
            double signum = Math.signum(dArr2[i7] - d3);
            if (i7 <= i || signum == 0.0d || signum == d7) {
                i3 = i8;
                i4 = i6;
            } else {
                int i10 = i8;
                if (i8 == Integer.MAX_VALUE) {
                    i10 = i7;
                }
                i9++;
                i4 = i7;
                i3 = i10;
            }
            i7++;
            d7 = signum;
            d4 = d9;
            d5 = d10;
            i6 = i4;
            i8 = i3;
            d6 = d8;
        }
        double sqrt = Math.sqrt(d6 / d2);
        double d11 = sqrt != 0.0d ? d3 / sqrt : 0.0d;
        double d12 = i9 > 1 ? (i6 - i8) / (i9 - 1.0d) : 0.0d;
        dArr[0] = d3;
        dArr[1] = sqrt;
        dArr[2] = d11;
        dArr[3] = d4;
        dArr[4] = d5;
        dArr[5] = d4 - d5;
        dArr[6] = i9;
        dArr[7] = d12;
    }

    public final double[] a(double[][] dArr) {
        double[] dArr2;
        synchronized (this) {
            Arrays.fill(this.f3733a, 0.0d);
            double[] dArr3 = dArr[3];
            double[] dArr4 = dArr[4];
            double[] dArr5 = dArr[5];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < dArr5.length) {
                    this.e[i2] = dArr5[i2] - dArr5[0];
                    i = i2 + 1;
                } else {
                    double d = 1.0d / r.f3954c;
                    a(this.f3733a, 0, a.TIME, dArr3, d);
                    a(this.f3733a, 8, a.FFT, dArr3, d);
                    a(this.f3733a, 15, a.TIME, dArr4, d);
                    a(this.f3733a, 23, a.FFT, dArr4, d);
                    a(this.f3733a, 30, a.TIME, this.e, d);
                    a(this.f3733a, 38, a.FFT, this.e, d);
                    a(this.d, dArr3);
                    double[] dArr6 = this.d;
                    System.arraycopy((Object) dArr6, 0, (Object) this.f3733a, 45, dArr6.length);
                    a(this.f3733a, 81, a.TIME, dArr[6], d);
                    a(this.f3733a, 89, a.FFT, dArr[6], d);
                    a(this.f3733a, 96, a.TIME, dArr[7], d);
                    a(this.f3733a, 104, a.FFT, dArr[7], d);
                    a(this.f3733a, 111, a.TIME, dArr[8], d);
                    a(this.f3733a, 119, a.FFT, dArr[8], d);
                    a(this.f3733a, 126, a.TIME, dArr[9], d);
                    a(this.f3733a, 134, a.FFT, dArr[9], d);
                    dArr2 = this.f3733a;
                }
            }
        }
        return dArr2;
    }

    public final void b(double[] dArr, double[] dArr2) {
        a(dArr, dArr2, 0, dArr2.length);
    }
}
