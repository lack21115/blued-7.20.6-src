package c.t.m.g;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/e2.class */
public abstract class e2 {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f3801a = false;
    public byte[] b = new byte[0];

    public abstract String a();

    public boolean b() {
        boolean z;
        synchronized (this.b) {
            z = this.f3801a;
        }
        return z;
    }

    public void c() {
        synchronized (this.b) {
            if (this.f3801a) {
                if (g3.a()) {
                    a();
                }
                d();
                this.f3801a = false;
            }
        }
    }

    public abstract void d();

    public int e() {
        synchronized (this.b) {
            if (this.f3801a) {
                return -1;
            }
            this.f3801a = true;
            if (g3.a()) {
                a();
            }
            return f();
        }
    }

    public abstract int f();
}
