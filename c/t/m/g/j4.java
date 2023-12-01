package c.t.m.g;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/j4.class */
public class j4 {
    public float b;
    public double g;
    public double j;
    public double d = -1.0d;
    public double e = -1.0d;
    public double f = -1.0d;

    /* renamed from: a  reason: collision with root package name */
    public float f3803a = -1.0f;

    /* renamed from: c  reason: collision with root package name */
    public long f3804c = -1;
    public double h = 0.0d;
    public double i = 0.0d;

    public double a() {
        return this.d;
    }

    public void a(double d, double d2, double d3, long j) {
        if (d3 < 1.0d) {
            d3 = 1.0d;
        }
        if (j - this.f3804c >= 20000) {
            c();
        }
        this.f3803a = (float) (Math.abs(d - this.d) * 1000000.0d);
        this.b = (float) (Math.abs(d2 - this.e) * 1000000.0d);
        if (this.f < 0.0d) {
            this.f3804c = j;
            this.d = d;
            this.e = d2;
            this.f = d3 * d3;
            return;
        }
        long j2 = j - this.f3804c;
        long j3 = j2;
        if (j2 < 1000) {
            j3 = 1000;
        }
        if (j3 > 0) {
            double d4 = j3;
            this.f += d4;
            this.g += d4;
        }
        double d5 = this.f;
        double d6 = d3 * d3;
        double d7 = d5 / ((d5 + d6) + (this.f3803a * 5.0f));
        double d8 = this.g;
        double d9 = d8 / ((d8 + d6) + (this.b * 5.0f));
        if (d7 < 0.4d || d9 < 0.4d) {
            if ((this.h > 0.0d && d - this.d > 0.0d) || (this.h < 0.0d && d - this.d < 0.0d)) {
                this.d += this.h * (j3 / 1000);
            }
            if ((this.i > 0.0d && d2 - this.e > 0.0d) || (this.i < 0.0d && d2 - this.e < 0.0d)) {
                this.e += this.i * (j3 / 1000);
            }
            double d10 = j3;
            this.f -= d10;
            this.g -= d10;
        } else {
            double d11 = this.d;
            if ((this.h > 0.0d && d - d11 > 0.0d) || (this.h < 0.0d && d - this.d < 0.0d)) {
                this.d += this.h * (j3 / 1000);
            }
            double d12 = this.d;
            double d13 = d12 + ((d - d12) * d7);
            this.d = d13;
            double d14 = j3 / 1000;
            this.h = (d13 - d11) / d14;
            double d15 = this.e;
            if ((this.i > 0.0d && d2 - d15 > 0.0d) || (this.i < 0.0d && d2 - this.e < 0.0d)) {
                this.e += this.i * d14;
            }
            double d16 = this.e;
            double d17 = d16 + ((d2 - d16) * d9);
            this.e = d17;
            this.i = (d17 - d15) / d14;
            this.f = (1.0d - d7) * this.f;
            this.g = (1.0d - d9) * this.g;
            this.f3804c = j;
        }
        if (d3 == 30.0d && d7 >= 0.5d && d9 >= 0.5d) {
            this.d = d;
            this.e = d2;
            this.h = 0.0d;
            this.i = 0.0d;
            this.f3804c = j;
            this.f = d6;
        }
        if (this.j > 100.0d && d3 <= 30.0d) {
            this.d = d;
            this.e = d2;
            this.h = 0.0d;
            this.i = 0.0d;
            this.f3804c = j;
            this.f = d6;
        }
        this.j = d3;
    }

    public double b() {
        return this.e;
    }

    public void c() {
        this.f = -1.0d;
        this.f3803a = -1.0f;
        this.f3804c = -1L;
        this.h = 0.0d;
        this.i = 0.0d;
    }
}
