package com.igexin.push.b;

import com.igexin.push.b.a;
import com.igexin.push.b.b;
import com.igexin.push.config.SDKUrlConfig;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/b/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9698a = b.f9692a + c.class.getName();
    private static c b;

    /* renamed from: c  reason: collision with root package name */
    private static int f9699c;

    private c() {
        f9699c = com.igexin.push.f.c.b() ? b.EnumC0279b.f9696a : b.EnumC0279b.b;
    }

    public static c a() {
        c cVar;
        synchronized (c.class) {
            try {
                if (b == null) {
                    b = new c();
                }
                cVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public static void b() {
        if (SDKUrlConfig.hasMultipleXfr()) {
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) f.g(), false, true);
            return;
        }
        com.igexin.c.a.c.a.a(f9698a + "|xfr len = 1, detect = false", new Object[0]);
    }

    public final void c() {
        if (SDKUrlConfig.hasMultipleXfr()) {
            try {
                f().e();
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    public final a d() {
        return f().d;
    }

    public final void e() {
        if (SDKUrlConfig.hasMultipleXfr()) {
            try {
                j.a();
                j.k();
                j.a().g();
                g.a().g();
                h f = f();
                if (f != null) {
                    f.i();
                    return;
                }
                return;
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
                return;
            }
        }
        j.a().f();
        g.a().f();
        f.g().h();
        try {
            g.a().d.a((List<a.b>) null);
            j.a().d.a((List<a.b>) null);
            j.a().h();
            g.a().h();
            j.a();
            j.k();
        } catch (Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
        }
    }

    public final h f() {
        h a2;
        synchronized (this) {
            a2 = com.igexin.push.f.c.b() ? j.a() : g.a();
            int c2 = a2.c();
            if (c2 != f9699c) {
                if (c2 == b.EnumC0279b.f9696a) {
                    g.a().f();
                } else if (c2 == b.EnumC0279b.b) {
                    j.a().f();
                }
            }
            f9699c = c2;
        }
        return a2;
    }
}
