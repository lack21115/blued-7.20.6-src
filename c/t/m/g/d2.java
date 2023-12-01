package c.t.m.g;

import android.os.Looper;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/d2.class */
public abstract class d2 extends e2 {
    public int a(Looper looper) {
        synchronized (this.b) {
            if (this.f3801a) {
                return -1;
            }
            this.f3801a = true;
            if (g3.a()) {
                a();
            }
            return b(looper);
        }
    }

    public abstract int b(Looper looper);

    @Override // c.t.m.g.e2
    public int e() {
        return a(Looper.myLooper());
    }

    @Override // c.t.m.g.e2
    public int f() {
        return 0;
    }
}
