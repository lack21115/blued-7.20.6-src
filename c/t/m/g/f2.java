package c.t.m.g;

import android.os.Looper;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/f2.class */
public abstract class f2 extends n3 {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f3808a = false;
    public byte[] b = new byte[0];

    public abstract int a(Looper looper);

    public abstract String a();

    public boolean b() {
        boolean z;
        synchronized (this.b) {
            z = this.f3808a;
        }
        return z;
    }

    public abstract void c();
}
