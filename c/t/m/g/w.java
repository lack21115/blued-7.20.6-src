package c.t.m.g;

import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/w.class */
public class w extends u {
    public x b;

    /* renamed from: c  reason: collision with root package name */
    public double[] f3982c = new double[3];

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<u> f3981a = new ArrayList<>();

    public w() {
        x xVar = new x();
        this.b = xVar;
        this.f3981a.add(xVar);
    }

    @Override // c.t.m.g.u
    public void a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3981a.size()) {
                return;
            }
            this.f3981a.get(i2).a();
            i = i2 + 1;
        }
    }

    @Override // c.t.m.g.u
    public double[] a(double[] dArr) {
        Arrays.fill(this.f3982c, 0.0d);
        double[] a2 = this.b.a(dArr);
        k2.a(a2, 4, false);
        double[] dArr2 = this.f3982c;
        System.arraycopy(a2, 0, dArr2, 0, dArr2.length);
        return this.f3982c;
    }

    @Override // c.t.m.g.u
    public double[] a(double[][] dArr) {
        return a0.b(dArr);
    }

    @Override // c.t.m.g.u
    public String b() {
        StringBuilder sb = new StringBuilder(this.f3981a.get(0).b());
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3981a.size()) {
                return sb.toString();
            }
            sb.append('_');
            sb.append(this.f3981a.get(i2).b());
            i = i2 + 1;
        }
    }

    @Override // c.t.m.g.u
    public void c() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3981a.size()) {
                return;
            }
            this.f3981a.get(i2).c();
            i = i2 + 1;
        }
    }

    @Override // c.t.m.g.u
    public void d() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3981a.size()) {
                return;
            }
            this.f3981a.get(i2).d();
            i = i2 + 1;
        }
    }
}
