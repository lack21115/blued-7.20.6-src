package c.t.m.g;

import java.lang.reflect.Array;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/x.class */
public class x extends u {
    public static double[][] d = (double[][]) Array.newInstance(Double.TYPE, 3, 141);
    public static double[] e = new double[3];

    /* renamed from: a  reason: collision with root package name */
    public int f4045a;
    public double[][] b;

    /* renamed from: c  reason: collision with root package name */
    public double[] f4046c;

    public x() {
        int i = r.f3953a;
        this.f4045a = i;
        this.b = (double[][]) Array.newInstance(Double.TYPE, i, i);
        this.f4046c = new double[i];
    }

    @Override // c.t.m.g.u
    public void a() {
    }

    @Override // c.t.m.g.u
    public double[] a(double[] dArr) {
        int i;
        int i2;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.f4045a - 1) {
                break;
            }
            int i5 = i4 + 1;
            int i6 = i5;
            while (true) {
                int i7 = i6;
                int i8 = this.f4045a;
                if (i7 < i8) {
                    int i9 = ((i8 * i4) + i7) - (((i4 + 2) * i5) / 2);
                    double a2 = h3.a(dArr, d[i9]) + e[i9];
                    double d2 = a2;
                    if (a2 > 100.0d) {
                        d2 = 100.0d;
                    }
                    double d3 = d2;
                    if (d2 < -100.0d) {
                        d3 = -100.0d;
                    }
                    double d4 = -d3;
                    this.b[i4][i7] = 1.0d / (Math.exp(d4 / 1.0d) + 1.0d);
                    this.b[i7][i4] = 1.0d / (Math.exp((-d4) / 1.0d) + 1.0d);
                    i6 = i7 + 1;
                }
            }
            i3 = i5;
        }
        double d5 = 0.0d;
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (i11 >= this.f4045a) {
                break;
            }
            this.f4046c[i11] = 0.0d;
            int i12 = 0;
            while (true) {
                int i13 = i12;
                i2 = this.f4045a;
                if (i13 < i2) {
                    if (i11 != i13) {
                        double[] dArr2 = this.f4046c;
                        dArr2[i11] = dArr2[i11] + (1.0d / this.b[i11][i13]);
                    }
                    i12 = i13 + 1;
                }
            }
            double[] dArr3 = this.f4046c;
            dArr3[i11] = 1.0d / (dArr3[i11] - (i2 - 2.0d));
            d5 += dArr3[i11];
            i10 = i11 + 1;
        }
        for (i = 0; i < this.f4045a; i++) {
            double[] dArr4 = this.f4046c;
            dArr4[i] = dArr4[i] / d5;
        }
        return this.f4046c;
    }

    @Override // c.t.m.g.u
    public double[] a(double[][] dArr) {
        return a0.b(dArr);
    }

    @Override // c.t.m.g.u
    public String b() {
        return "SVM";
    }

    @Override // c.t.m.g.u
    public void c() {
    }

    @Override // c.t.m.g.u
    public void d() {
    }
}
