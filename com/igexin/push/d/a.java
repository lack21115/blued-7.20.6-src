package com.igexin.push.d;

import com.igexin.c.a.b.a.a.d;
import com.igexin.c.a.b.a.a.j;
import com.igexin.c.a.b.e;
import com.igexin.c.a.d.f;
import com.igexin.push.c.c;
import com.igexin.push.c.c.c;
import com.igexin.push.c.c.i;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.d;
import com.igexin.push.core.j;
import com.igexin.push.core.l;
import com.igexin.push.f.g;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/d/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f9983a = a.class.getName();
    public boolean b;

    private int a(String str, c cVar) {
        return a(str, cVar, false);
    }

    public static void a(int i) {
        if (i == j.f9628a) {
            e.a().a(new com.igexin.push.c.b.b());
            e.a().b();
        } else if (i == j.b) {
            e.a().a(new com.igexin.push.c.b.a());
            e.a().b();
        }
    }

    public static void a(c cVar) {
        if (cVar == null) {
            return;
        }
        com.igexin.push.core.a.b.d().a(cVar);
    }

    public static void a(boolean z) {
        com.igexin.c.a.c.a.a(f9983a + "|call -> disconnect, reset delay = " + z, new Object[0]);
        if (z) {
            com.igexin.push.core.e.O = 0L;
        }
        d.a().d();
    }

    private void b(boolean z) {
        String str = f9983a;
        com.igexin.c.a.c.a.a(str, "call setActive, param active = " + z + "; this.active = " + this.b + "; reConnectDelayTime=" + com.igexin.push.core.e.O);
        com.igexin.c.a.c.a.a(f9983a + "|call setActive, param active = " + z + "; this.active = " + this.b + "; reConnectDelayTime=" + com.igexin.push.core.e.O, new Object[0]);
        boolean z2 = this.b;
        if (z2 == z) {
            if (!z2 || com.igexin.push.core.e.u || com.igexin.push.core.e.O <= com.igexin.push.config.c.j) {
                return;
            }
            com.igexin.c.a.c.a.a(f9983a + "|start active again, online = false, reset delay", new Object[0]);
            com.igexin.push.core.e.O = 0L;
            c();
            return;
        }
        this.b = z;
        if (z) {
            com.igexin.c.a.c.a.a(f9983a + "|active = true, start connect~~~~", new Object[0]);
            g();
            return;
        }
        com.igexin.c.a.c.a.a(f9983a + "|active = false, disconnect...", new Object[0]);
        a(true);
    }

    public static void c() {
        com.igexin.push.core.e.O = c.b.a().e.a();
        com.igexin.push.e.b.e.g().a(com.igexin.push.core.e.O);
    }

    public static boolean d() {
        return (com.igexin.push.core.e.p && com.igexin.push.core.e.s) ? false : true;
    }

    public static void e() {
        com.igexin.push.core.j.a().a(j.a.d);
        boolean e = com.igexin.push.f.c.e();
        String str = f9983a;
        com.igexin.c.a.c.a.a(str, "network changed, available = " + e + ", last = " + com.igexin.push.core.e.n);
        com.igexin.c.a.c.a.a(f9983a + "|network changed, available = " + e + ", last = " + com.igexin.push.core.e.n, new Object[0]);
        c.b.a().a();
        if (!e) {
            com.igexin.c.a.c.a.a(f9983a + "|network changed, available = false, do nothing", new Object[0]);
            a(false);
        } else if (!com.igexin.push.core.e.n) {
            com.igexin.c.a.c.a.a(f9983a + "|network changed, try connect reset delay", new Object[0]);
            g();
        }
        if (e) {
            com.igexin.push.b.c.a().c();
        }
        com.igexin.push.core.e.n = e;
    }

    private boolean f() {
        return this.b;
    }

    private static void g() {
        com.igexin.c.a.c.a.a(f9983a + "|call -> tryConnect and reset delay = 0", new Object[0]);
        a(true);
    }

    private static void h() {
        com.igexin.push.b.c.a().d().c();
        com.igexin.push.b.a d = com.igexin.push.b.c.a().d();
        com.igexin.push.core.j.a().a(j.a.f9959c);
        d.f();
        if (d()) {
            com.igexin.c.a.c.a.a(f9983a, "sdkOn = false or pushOn = false, disconect|user");
            com.igexin.c.a.c.a.a(f9983a + "|sdkOn = false or pushOn = false, disconect|user", new Object[0]);
        } else {
            com.igexin.c.a.c.a.a(f9983a + "|disconnect by network", new Object[0]);
        }
        com.igexin.c.a.d.e<f> eVar = e.a().s;
        if (eVar != null) {
            eVar.a(com.igexin.c.a.b.a.a.f.class);
        }
        a(false);
    }

    private static void i() {
        com.igexin.push.c.a.c.b = -1;
        if (com.igexin.push.core.e.q) {
            com.igexin.c.a.c.a.a(f9983a, "isAppidWrong = true");
            com.igexin.c.a.c.a.a(f9983a + "|isAppidWrong = true", new Object[0]);
            com.igexin.c.a.c.a.d.a().a("isAppidWrong = true");
        } else if (!g.a()) {
            com.igexin.c.a.c.a.a(f9983a, "so error ++++++++");
            com.igexin.c.a.c.a.a(f9983a + "|so error ++++++++", new Object[0]);
        } else if (com.igexin.push.core.e.az) {
            c();
        } else {
            com.igexin.c.a.c.a.a(f9983a, "initSuccess = false");
            com.igexin.c.a.c.a.a(f9983a + "|initSuccess = false", new Object[0]);
        }
    }

    public final int a(String str, com.igexin.push.c.c.c cVar, boolean z) {
        if (str == null || cVar == null) {
            return -1;
        }
        if (!com.igexin.push.core.e.u && !(cVar instanceof com.igexin.push.c.c.g) && !(cVar instanceof i) && !(cVar instanceof com.igexin.push.c.c.d)) {
            com.igexin.c.a.c.a.a("networkLayer|sendData|not online|" + cVar.getClass().getName(), new Object[0]);
            return -3;
        } else if (this.b) {
            if (z) {
                return e.a().a(SDKUrlConfig.getConnectAddress(), d.a.f9866a.g, cVar, com.igexin.push.config.d.f > 0 ? com.igexin.push.config.d.f : 10, new com.igexin.push.c.f()) == null ? -2 : 0;
            }
            return e.a().a(SDKUrlConfig.getConnectAddress(), d.a.f9866a.g, cVar) == null ? -2 : 0;
        } else {
            return 0;
        }
    }

    public final void a() {
        boolean z = com.igexin.push.core.e.p;
        boolean z2 = com.igexin.push.core.e.s;
        boolean a2 = com.igexin.push.f.c.a(System.currentTimeMillis());
        boolean a3 = com.igexin.push.f.c.a();
        if (z && z2 && !a2 && a3) {
            b(true);
        }
    }

    public final void b() {
        b(false);
        if (com.igexin.push.core.e.u) {
            com.igexin.push.core.e.u = false;
            l.a().b();
        }
        com.igexin.c.a.c.a.a(f9983a + "|stop by user", new Object[0]);
        com.igexin.push.b.c.a().d().f();
    }
}
