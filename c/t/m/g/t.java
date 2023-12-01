package c.t.m.g;

import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/t.class */
public class t {
    public z1 f;
    public z1 g;
    public z1 h;
    public z1 i;
    public z1 j;
    public z1 k;
    public double l;
    public volatile double d = -1.0d;
    public volatile long e = 0;
    public double[] m = new double[7];
    public double[] n = new double[3];
    public z b = new z();

    /* renamed from: a  reason: collision with root package name */
    public u f3986a = new w();

    /* renamed from: c  reason: collision with root package name */
    public y f3987c = new y(15);

    public t() {
        int i = r.f3953a;
        this.l = 1.0d / i;
        z1 z1Var = new z1(i, i);
        this.f = z1Var;
        a2.a(z1Var, r.e);
        this.g = new z1(r.f3953a, 1);
        this.k = new z1(r.f3953a, 1);
        this.h = new z1(r.f3953a, 1);
        this.i = new z1(r.f3953a, 1);
        this.j = new z1(r.f3953a, 1);
        this.g.a(this.l);
        this.h.a(this.l);
        this.i.a(this.l);
        this.j.a(this.l);
        c();
    }

    public void a(long j, double d) {
        this.e = j;
        this.d = d;
        this.f3987c.a(j, d);
    }

    public final void a(z1 z1Var) {
        double d = 0.0d;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= z1Var.d()) {
                z1Var.b(1.0d / d);
                return;
            } else {
                d += z1Var.a(i2, 0);
                i = i2 + 1;
            }
        }
    }

    public final void a(z1 z1Var, double d) {
        if (Double.isNaN(z1Var.a(0, 0)) || Double.isNaN(z1Var.a(z1Var.d() - 1, z1Var.c() - 1))) {
            z1Var.a(d);
        }
    }

    public final void a(double[] dArr, z1 z1Var) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= z1Var.d()) {
                return;
            }
            int i3 = i2 + 1;
            dArr[i3] = z1Var.a(i2, 0);
            i = i3;
        }
    }

    public final double[] a() {
        boolean z = System.currentTimeMillis() - this.e <= 5000 && this.d > 2.5d && this.d < 1000.0d;
        double d = this.d == 0.0d ? 1.0E-5d : this.d;
        a(this.f, this.l);
        a(this.g, this.l);
        a(this.h, this.l);
        a(this.i, this.l);
        a(this.j, this.l);
        Arrays.fill(this.n, this.l);
        a(this.h);
        a2.b(this.k, this.f, this.g);
        a2.a(this.g, this.k, this.h);
        a(this.g);
        a2.b(this.k, this.f, this.i);
        a2.a(this.i, this.k, this.h);
        a(this.i);
        a(s.l, this.g);
        if (z) {
            double log = Math.log(d);
            double sqrt = Math.sqrt(6.283185307179586d);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 3) {
                    break;
                }
                double[][] dArr = r.f;
                double d2 = log - dArr[i2][1];
                this.n[i2] = (((dArr[i2][0] * Math.exp(((-d2) * d2) / ((dArr[i2][2] * 2.0d) * dArr[i2][2]))) / r.f[i2][2]) / sqrt) / d;
                i = i2 + 1;
            }
            double d3 = h3.d(this.n);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= 3) {
                    break;
                }
                double[] dArr2 = this.n;
                dArr2[i4] = dArr2[i4] / d3;
                this.j.a(i4, 0, dArr2[i4]);
                i3 = i4 + 1;
            }
            z1 z1Var = this.i;
            a2.a(z1Var, z1Var, this.j);
            a(this.i);
        }
        a(this.m, this.i);
        return this.m;
    }

    public double[] a(long j, double[][] dArr) {
        Arrays.fill(this.m, 0.0d);
        Arrays.fill(s.l, 0.0d);
        if (!this.f3987c.a()) {
            if (r.i) {
                double[] dArr2 = this.m;
                dArr2[0] = 1.0d;
                s.l[0] = 1.0d;
                return dArr2;
            }
            this.f3987c.b();
        }
        double[] b = b(j, dArr);
        int a2 = h3.a(s.l);
        this.f3987c.a(j, a2, s.l[a2]);
        return b;
    }

    public final double[] a(double[] dArr) {
        double[] a2 = this.f3986a.a(dArr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a2.length) {
                return a();
            }
            this.h.a(i2, 0, a2[i2]);
            i = i2 + 1;
        }
    }

    public void b() {
        j0.a("ArStrategy", "destroy().");
        this.f3986a.a();
        this.f3987c.b();
        this.e = 0L;
        this.d = -1.0d;
    }

    public double[] b(long j, double[][] dArr) {
        boolean z;
        int i = 1;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= dArr[3].length) {
                    z = true;
                    break;
                } else if (dArr[3][i2] != dArr[3][i2 - 1]) {
                    z = false;
                    break;
                } else {
                    i = i2 + 1;
                }
            } catch (Throwable th) {
                j0.a("ArStrategy", "classify error.", th);
                double[] dArr2 = this.m;
                dArr2[0] = 1.0d;
                s.l[0] = 1.0d;
                return dArr2;
            }
        }
        double b = h3.b(dArr[3]);
        if (!z && Math.abs(b) >= 1.0E-10d) {
            if (h3.a(dArr[3], b) < 0.06d) {
                j0.a("ArStrategy", "detect still.");
                e();
                this.h.a(0.0d);
                this.h.a(0, 0, 1.0d);
                return a();
            } else if (this.b.a(dArr)) {
                j0.a("ArStrategy", "detect tilting.");
                e();
                this.m[6] = 1.0d;
                s.l[6] = 1.0d;
                return this.m;
            } else {
                double[] a2 = this.f3986a.a(dArr);
                j0.a("DATA_AR", "#DATA,AR," + System.currentTimeMillis() + ",FEA," + k2.a(a2, 4, false));
                return a(a2);
            }
        }
        this.m[0] = 1.0d;
        s.l[0] = 1.0d;
        return this.m;
    }

    public void c() {
        j0.a("ArStrategy", "init start[" + this.f3986a.b() + ", f=" + r.f3954c + ", t=" + String.format("%.2f", Float.valueOf(128.0f / r.f3954c)) + ",size=128,numClass=" + r.f3953a + ",SVM feaLen=141,LR feaLen=141]");
        this.f3986a.c();
        j0.a("ArStrategy", "init finished.");
        this.f3987c.b();
    }

    public void d() {
        j0.a("ArStrategy", "reset().");
        e();
        this.g.a(this.l);
    }

    public final void e() {
        j0.a("ArStrategy", "resetAlgo().");
        this.f3986a.d();
    }
}
