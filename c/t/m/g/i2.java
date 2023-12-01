package c.t.m.g;

import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/i2.class */
public class i2 {

    /* renamed from: a  reason: collision with root package name */
    public int f3789a;
    public double[] b;

    /* renamed from: c  reason: collision with root package name */
    public double f3790c;
    public int d;
    public int e;

    public i2(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("cacheSize max > 0.");
        }
        this.f3789a = i;
        this.b = new double[i];
        a();
    }

    public final int a(int i) {
        int i2 = this.e;
        int i3 = this.f3789a;
        return i2 < i3 ? i : ((this.d + i) + i3) % i3;
    }

    public void a() {
        this.d = 0;
        this.e = 0;
        this.f3790c = 0.0d;
        Arrays.fill(this.b, 0.0d);
    }

    public void a(double d) {
        double d2 = this.f3790c;
        double[] dArr = this.b;
        int i = this.d;
        double d3 = d2 - dArr[i];
        this.f3790c = d3;
        this.f3790c = d3 + d;
        dArr[i] = d;
        int i2 = i + 1;
        this.d = i2;
        if (i2 == this.f3789a) {
            this.d = 0;
        }
        int i3 = this.e;
        if (i3 < Integer.MAX_VALUE) {
            this.e = i3 + 1;
        }
    }

    public double b(int i) {
        if (i < 0 || i >= b()) {
            throw new ArrayIndexOutOfBoundsException("cache max size is " + this.f3789a + ",current size is " + b() + ",index is " + i);
        }
        return this.b[a(i)];
    }

    public int b() {
        int i = this.e;
        int i2 = this.f3789a;
        return i < i2 ? i : i2;
    }
}
