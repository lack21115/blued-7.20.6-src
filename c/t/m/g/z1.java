package c.t.m.g;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/z1.class */
public class z1 implements Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public double[][] f4023a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f4024c;

    public z1(int i, int i2) {
        this.b = i;
        this.f4024c = i2;
        this.f4023a = (double[][]) Array.newInstance(Double.TYPE, i, i2);
    }

    public double a(int i, int i2) {
        return this.f4023a[i][i2];
    }

    public z1 a() {
        z1 z1Var = new z1(this.b, this.f4024c);
        double[][] b = z1Var.b();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b) {
                return z1Var;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.f4024c) {
                    b[i2][i4] = this.f4023a[i2][i4];
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public void a(double d) {
        int i = 0;
        while (true) {
            int i2 = i;
            double[][] dArr = this.f4023a;
            if (i2 >= dArr.length) {
                return;
            }
            Arrays.fill(dArr[i2], d);
            i = i2 + 1;
        }
    }

    public void a(int i, int i2, double d) {
        this.f4023a[i][i2] = d;
    }

    public z1 b(double d) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b) {
                return this;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.f4024c) {
                    double[][] dArr = this.f4023a;
                    dArr[i2][i4] = dArr[i2][i4] * d;
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public double[][] b() {
        return this.f4023a;
    }

    public int c() {
        return this.f4024c;
    }

    public Object clone() {
        return a();
    }

    public int d() {
        return this.b;
    }
}
