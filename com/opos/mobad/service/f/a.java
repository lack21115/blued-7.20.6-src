package com.opos.mobad.service.f;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.cdo.oaps.ad.af;
import com.opos.cmn.i.a;
import com.sobot.chat.core.channel.Const;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/f/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f27353a = com.opos.cmn.an.a.b.a(com.cdo.oaps.ad.a.b);
    private static a b;

    /* renamed from: c  reason: collision with root package name */
    private Context f27354c;
    private c d;
    private g e;
    private InterfaceC0735a f;
    private f g;
    private e h;
    private String i;
    private String j;
    private String k;
    private com.opos.cmn.i.a l;
    private com.opos.cmn.i.a m;
    private com.opos.cmn.i.a n;
    private com.opos.cmn.i.a o;
    private String p;
    private String q;
    private volatile d r;
    private b s;
    private volatile String t = "";
    private volatile String u = "";

    /* renamed from: com.opos.mobad.service.f.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/f/a$a.class */
    public interface InterfaceC0735a {
        String a();

        String b();

        String c();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/f/a$b.class */
    public interface b {
        String a();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/f/a$c.class */
    public interface c {
        String a();

        String b();

        boolean c();

        void d();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/f/a$d.class */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f27363a;
        public final String b;

        public d(int i, String str) {
            this.f27363a = i;
            this.b = str;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/f/a$e.class */
    public interface e {
        String a();

        long b();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/f/a$f.class */
    public interface f {
        int a();

        String b();

        int c();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/f/a$g.class */
    public interface g {
        String a();

        String b();

        boolean c();

        void d();
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d A() {
        this.r = new d(b(this.f27354c), a(this.f27354c));
        return this.r;
    }

    public static final a a() {
        a aVar;
        a aVar2 = b;
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (a.class) {
            try {
                if (b == null) {
                    b = new a();
                }
                aVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    private String a(Context context) {
        String str = af.e;
        if (!com.opos.cmn.an.h.d.a.d(context, af.e)) {
            str = f27353a;
        }
        return com.opos.cmn.an.h.d.a.c(context, str);
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && "CHILD".equals(str);
    }

    private int b(Context context) {
        String str = af.e;
        if (!com.opos.cmn.an.h.d.a.d(context, af.e)) {
            str = f27353a;
        }
        return com.opos.cmn.an.h.d.a.b(context, str);
    }

    private void z() {
        this.n = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.f.a.1
            @Override // com.opos.cmn.i.a.b
            public void a(final a.InterfaceC0645a interfaceC0645a) {
                com.opos.cmn.an.f.a.b("infoManager", "init instant");
                if (a.this.d == null) {
                    interfaceC0645a.b();
                } else {
                    com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.f.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a.this.d.d();
                                if (interfaceC0645a != null) {
                                    interfaceC0645a.a();
                                }
                            } catch (Exception e2) {
                                com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                                a.InterfaceC0645a interfaceC0645a2 = interfaceC0645a;
                                if (interfaceC0645a2 != null) {
                                    interfaceC0645a2.b();
                                }
                            }
                        }
                    });
                }
            }
        }, Integer.MAX_VALUE, Const.SOCKET_CHECK_CHANNEL);
        this.o = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.f.a.2
            @Override // com.opos.cmn.i.a.b
            public void a(final a.InterfaceC0645a interfaceC0645a) {
                com.opos.cmn.an.f.a.b("infoManager", "init xgame");
                if (a.this.e == null) {
                    interfaceC0645a.b();
                } else {
                    com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.f.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a.this.e.d();
                                if (interfaceC0645a != null) {
                                    interfaceC0645a.a();
                                }
                            } catch (Exception e2) {
                                com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                                a.InterfaceC0645a interfaceC0645a2 = interfaceC0645a;
                                if (interfaceC0645a2 != null) {
                                    interfaceC0645a2.b();
                                }
                            }
                        }
                    });
                }
            }
        }, Integer.MAX_VALUE, Const.SOCKET_CHECK_CHANNEL);
        this.l = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.f.a.3
            @Override // com.opos.cmn.i.a.b
            public void a(final a.InterfaceC0645a interfaceC0645a) {
                com.opos.cmn.an.f.a.b("infoManager", "init market");
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.f.a.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a.this.A();
                            if (interfaceC0645a != null) {
                                interfaceC0645a.a();
                            }
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                            a.InterfaceC0645a interfaceC0645a2 = interfaceC0645a;
                            if (interfaceC0645a2 != null) {
                                interfaceC0645a2.b();
                            }
                        }
                    }
                });
            }
        }, Integer.MAX_VALUE, Const.SOCKET_CHECK_CHANNEL);
        this.m = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.f.a.4
            @Override // com.opos.cmn.i.a.b
            public void a(final a.InterfaceC0645a interfaceC0645a) {
                com.opos.cmn.an.f.a.b("infoManager", "init operator");
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.f.a.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a.this.p = com.opos.cmn.an.h.e.a.e(a.this.f27354c);
                            if (interfaceC0645a != null) {
                                interfaceC0645a.a();
                            }
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                            a.InterfaceC0645a interfaceC0645a2 = interfaceC0645a;
                            if (interfaceC0645a2 != null) {
                                interfaceC0645a2.b();
                            }
                        }
                    }
                });
            }
        }, Integer.MAX_VALUE, 180000);
    }

    public void a(Context context, c cVar, g gVar, InterfaceC0735a interfaceC0735a, f fVar, e eVar, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.f27354c = applicationContext;
        this.q = applicationContext.getPackageName();
        this.d = cVar;
        this.e = gVar;
        this.f = interfaceC0735a;
        this.g = fVar;
        this.h = eVar;
        this.s = bVar;
        z();
    }

    public String b() {
        c cVar = this.d;
        if (cVar == null) {
            return "";
        }
        this.n.a();
        return cVar.b();
    }

    public boolean c() {
        c cVar = this.d;
        if (cVar == null) {
            return false;
        }
        this.n.a();
        return cVar.c();
    }

    public String d() {
        c cVar = this.d;
        if (cVar == null) {
            return "";
        }
        this.n.a();
        return cVar.a();
    }

    public boolean e() {
        g gVar = this.e;
        if (gVar == null) {
            return false;
        }
        this.o.a();
        return gVar.c();
    }

    public String f() {
        g gVar = this.e;
        if (gVar == null) {
            return "";
        }
        this.o.a();
        return gVar.a();
    }

    public String g() {
        g gVar = this.e;
        if (gVar == null) {
            return "";
        }
        this.o.a();
        return gVar.b();
    }

    public String h() {
        if (TextUtils.isEmpty(this.i)) {
            this.i = com.opos.cmn.an.b.d.b();
        }
        return this.i;
    }

    public String i() {
        if (TextUtils.isEmpty(this.j)) {
            this.j = com.opos.cmn.an.b.d.a();
        }
        return this.j;
    }

    public String j() {
        if (TextUtils.isEmpty(this.k)) {
            this.k = com.opos.cmn.an.b.c.c();
        }
        return this.k;
    }

    public String k() {
        InterfaceC0735a interfaceC0735a = this.f;
        return interfaceC0735a == null ? "" : interfaceC0735a.b();
    }

    public String l() {
        InterfaceC0735a interfaceC0735a = this.f;
        return interfaceC0735a == null ? "" : interfaceC0735a.a();
    }

    public String m() {
        InterfaceC0735a interfaceC0735a = this.f;
        return interfaceC0735a == null ? "" : interfaceC0735a.c();
    }

    public d n() {
        d dVar = this.r;
        if (dVar != null) {
            this.l.a();
            return dVar;
        }
        d A = A();
        this.r = A;
        return A;
    }

    public int o() {
        return this.g.a();
    }

    public String p() {
        return this.g.b();
    }

    public int q() {
        return this.g.c();
    }

    public String r() {
        e eVar = this.h;
        return eVar == null ? "" : eVar.a();
    }

    public long s() {
        e eVar = this.h;
        if (eVar == null) {
            return 0L;
        }
        return eVar.b();
    }

    public String t() {
        if (!TextUtils.isEmpty(this.p)) {
            this.m.a();
            return this.p;
        }
        String e2 = com.opos.cmn.an.h.e.a.e(this.f27354c);
        this.p = e2;
        return e2;
    }

    public String u() {
        return this.q;
    }

    public String v() {
        if (this.s == null) {
            return "";
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.u = this.s.a();
        if (TextUtils.isEmpty(this.u) || (!"ADULT".equals(this.u) && !"CHILD".equals(this.u) && !"TEEN".equals(this.u))) {
            this.u = "UNKNOWN";
        }
        com.opos.cmn.an.f.a.b("infoManager", "age provider =" + this.u + ", time = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        return this.u;
    }

    public String w() {
        if (this.s == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.u)) {
            v();
        }
        return this.u;
    }

    public String x() {
        return this.t;
    }

    public void y() {
        this.f = null;
        this.h = null;
        this.s = null;
        this.d = null;
        this.e = null;
        this.t = "";
    }
}
