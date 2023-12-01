package c.t.m.g;

import android.content.Context;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/j6.class */
public class j6 implements d4 {

    /* renamed from: c  reason: collision with root package name */
    public static volatile j6 f3854c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f3855a = true;
    public n6 b;

    public j6(Context context) {
        this.b = new n6(context);
    }

    public static j6 a(Context context) {
        if (f3854c == null) {
            synchronized (j6.class) {
                try {
                    if (f3854c == null) {
                        if (context == null) {
                            throw new NullPointerException(com.anythink.expressad.foundation.g.b.b.f7836a);
                        }
                        f3854c = new j6(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f3854c;
    }

    @Override // c.t.m.g.d4
    public boolean a() {
        return this.b.c();
    }

    @Override // c.t.m.g.d4
    public double[] getPosition() {
        return this.b.b();
    }

    @Override // c.t.m.g.d4
    public boolean isSupport() {
        return this.b.d();
    }

    @Override // c.t.m.g.d4
    public int startDrEngine(int i) {
        if (this.f3855a) {
            try {
                return this.b.a(i);
            } catch (Exception e) {
                return com.anythink.expressad.video.bt.a.c.f8290a;
            }
        }
        return -7;
    }

    @Override // c.t.m.g.d4
    public void terminateDrEngine() {
        this.b.i();
    }
}
