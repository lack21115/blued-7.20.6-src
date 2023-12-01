package c.t.m.g;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/i6.class */
public class i6 {

    /* renamed from: a  reason: collision with root package name */
    public double f3842a;
    public double b;

    /* renamed from: c  reason: collision with root package name */
    public double f3843c;
    public double d;
    public double e;
    public double f;
    public long g;
    public double h;
    public String i;

    public i6(double[] dArr) {
        try {
            this.g = (long) dArr[0];
            this.f3842a = dArr[1];
            this.b = dArr[2];
            this.f = dArr[3];
            this.h = dArr[4];
            this.e = dArr[5];
            this.d = dArr[6];
            double d = dArr[7];
            if (d == 1.0d) {
                this.i = "gps";
            } else if (d == 0.0d) {
                this.i = "fused";
            } else {
                this.i = "unknown";
            }
            double d2 = dArr[8];
            this.f3843c = dArr[9];
        } catch (Exception e) {
        }
    }

    public double a() {
        return this.d;
    }

    public double b() {
        return this.f3843c;
    }

    public double c() {
        return this.f;
    }

    public double d() {
        return this.f3842a;
    }

    public double e() {
        return this.b;
    }

    public double f() {
        return this.h;
    }

    public String g() {
        return this.i;
    }

    public double h() {
        return this.e;
    }

    public long i() {
        return this.g;
    }
}
