package c.t.m.g;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/b0.class */
public class b0 {
    public static byte[] b = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    public static b0 f3755c;

    /* renamed from: a  reason: collision with root package name */
    public s f3756a = new s();

    public static b0 b() {
        b0 b0Var;
        synchronized (b) {
            b0Var = f3755c;
        }
        return b0Var;
    }

    public void a(int i, int i2, float f, double[][] dArr, double[][] dArr2, double[][] dArr3, double[] dArr4) {
        synchronized (this) {
            synchronized (b) {
                f3755c = this;
            }
            this.f3756a.a(i, i2, f, dArr, dArr2, dArr3, dArr4);
        }
    }

    public void a(long j, float f) {
        synchronized (this) {
            g3.a();
            this.f3756a.a(j, f);
        }
    }

    public void a(long j, float[] fArr, float[] fArr2) {
        synchronized (this) {
            this.f3756a.a(j, fArr, fArr2);
        }
    }

    public double[] a() {
        double[] dArr;
        synchronized (this) {
            g3.a();
            dArr = s.l;
        }
        return dArr;
    }

    public double[] a(long j) {
        double[] a2;
        synchronized (this) {
            g3.a();
            a2 = this.f3756a.a(j);
            if (g3.a()) {
                k2.a(a2, 4, true);
            }
        }
        return a2;
    }

    public void c() {
        synchronized (this) {
            this.f3756a.a();
        }
    }

    public void d() {
        synchronized (this) {
            this.f3756a.b();
            synchronized (b) {
                f3755c = null;
            }
        }
    }
}
