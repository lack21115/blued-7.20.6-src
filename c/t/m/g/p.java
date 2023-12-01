package c.t.m.g;

import android.content.Context;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/p.class */
public class p {

    /* renamed from: c  reason: collision with root package name */
    public static volatile p f3865c;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f3866a = new byte[0];
    public d0 b;

    public p(Context context) {
        this.b = null;
        q2.a(context);
        this.b = new d0();
    }

    public static p a(Context context) {
        if (f3865c == null) {
            synchronized (p.class) {
                try {
                    if (f3865c == null) {
                        Context applicationContext = context == null ? null : context.getApplicationContext();
                        if (applicationContext == null) {
                            throw new NullPointerException("context is null." + a());
                        }
                        f3865c = new p(applicationContext);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f3865c;
    }

    public static String a() {
        return "0.5.28_220414";
    }

    public static String a(int i) {
        return h0.a(i);
    }

    public void a(q qVar) {
        if (qVar == null) {
            throw new NullPointerException("listener cannot be null.");
        }
        synchronized (this.f3866a) {
            this.b.a(qVar);
        }
    }

    public boolean a(String str, String str2) {
        boolean a2;
        synchronized (this.f3866a) {
            a2 = this.b.a(str, str2);
        }
        return a2;
    }

    public void b() {
        synchronized (this.f3866a) {
            this.b.a(200L);
        }
    }

    public void b(q qVar) {
        synchronized (this.f3866a) {
            this.b.b(qVar);
        }
    }

    public int c() {
        int g;
        synchronized (this.f3866a) {
            g = this.b.g();
        }
        return g;
    }
}
