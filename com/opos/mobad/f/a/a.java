package com.opos.mobad.f.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.opos.mobad.ad.b;
import com.opos.mobad.f.a.i;
import com.opos.mobad.service.a.e;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a.class */
public class a extends com.opos.mobad.l.a {
    private static Map<String, Boolean> g = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    private String f12323a;
    private com.opos.mobad.f.a.a.m<com.opos.mobad.ad.a.a> b;

    /* renamed from: c  reason: collision with root package name */
    private b f12324c;
    private n d;
    private Context h;
    private String i;
    private int j;
    private boolean k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a$a.class */
    public class C0522a extends com.opos.mobad.f.a.a.b implements com.opos.mobad.ad.a.b {

        /* renamed from: c  reason: collision with root package name */
        private final int f12332c;

        public C0522a(int i, com.opos.mobad.f.a.a.n nVar) {
            super(i, nVar);
            this.f12332c = i;
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            if (1 == a.this.d()) {
                super.a(i, str);
            } else if (this.f12332c != a.this.b.j()) {
            } else {
                a.this.c(i, str);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j) {
            if (this.f12332c != a.this.b.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().b(a.this.f12323a);
            a.this.i();
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            if (this.f12332c != a.this.b.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().a(a.this.f12323a);
            a.this.g_();
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void b() {
            if (this.f12332c == a.this.j) {
                a.this.j = -1;
                a.this.i_();
                a.this.q();
                return;
            }
            a aVar = a.this;
            aVar.c("channel is diff =" + this.f12332c + ", " + a.this.b.j());
        }
    }

    public a(final Activity activity, final String str, com.opos.mobad.f.a.d.a aVar, final boolean z, com.opos.mobad.ad.a.b bVar, List<e.a> list, e.a aVar2, long j, final com.opos.mobad.f.b bVar2) {
        super(bVar);
        this.j = -1;
        this.k = false;
        this.f12323a = str;
        Context applicationContext = activity.getApplicationContext();
        this.h = applicationContext;
        this.f12324c = new b(applicationContext, new i.a() { // from class: com.opos.mobad.f.a.a.1
            @Override // com.opos.mobad.f.a.i.a
            public void a(int i, int i2) {
                a.this.b(i, i2);
            }
        });
        this.b = a(str, aVar, list, aVar2, j, new com.opos.mobad.f.a.b.b<com.opos.mobad.ad.a.a>() { // from class: com.opos.mobad.f.a.a.2
            @Override // com.opos.mobad.f.a.b.a
            /* renamed from: a */
            public com.opos.mobad.ad.a.a b(e.a aVar3, com.opos.mobad.f.a.a.n nVar) {
                com.opos.mobad.ad.c b = bVar2.b(aVar3.f13613a);
                if (b == null) {
                    a aVar4 = a.this;
                    aVar4.c("new banner ad but creator = null,channel is =" + aVar3.f13613a);
                    return null;
                }
                return b.a(activity, str, aVar3.b, z, new C0522a(aVar3.f13613a, nVar));
            }
        }, new com.opos.mobad.f.a.c.a(activity));
    }

    private com.opos.mobad.f.a.a.m<com.opos.mobad.ad.a.a> a(String str, com.opos.mobad.f.a.d.a aVar, List<e.a> list, e.a aVar2, long j, com.opos.mobad.f.a.b.b<com.opos.mobad.ad.a.a> bVar, com.opos.mobad.f.a.c.a aVar3) {
        return com.opos.mobad.f.a.a.k.a(this.h, str, aVar, list, aVar2, j, bVar, aVar3, new b.a() { // from class: com.opos.mobad.f.a.a.3
            @Override // com.opos.mobad.ad.b.a
            public void a() {
                a.this.c("onAdReady");
                a.this.o();
                a.this.k();
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i, String str2) {
                a aVar4 = a.this;
                aVar4.c("onAdFailed code=" + i + ",msg =" + str2);
                a.this.b(com.opos.mobad.f.a.a.l.a(i), str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
                a.this.c("onAdClose");
                a.this.i_();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        com.opos.mobad.f.a.a.m<com.opos.mobad.ad.a.a> mVar = this.b;
        if (mVar != null) {
            mVar.a(i, i2);
        }
        c("notify banner size change w = " + i + ",h =" + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        c("banner showView");
        com.opos.mobad.ad.a.a i = this.b.i();
        this.j = this.b.j();
        this.f12324c.a(i.h());
    }

    private void m() {
        if (this.d == null) {
            n nVar = new n(new Runnable() { // from class: com.opos.mobad.f.a.a.4
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f12324c == null || !a.this.f12324c.c()) {
                        a.this.c("banner is invisibile");
                    } else if (a.this.r() || com.opos.cmn.i.j.a(a.this.h, a.this.h())) {
                        a.this.p();
                        a.this.c(11004, "you should't play ad on the top in the shaped screen mobile");
                        return;
                    } else {
                        a.this.a();
                    }
                    if (a.this.d != null) {
                        a.this.d.a(com.opos.mobad.service.f.a().a(a.this.f12323a));
                    }
                }
            });
            this.d = nVar;
            nVar.a(com.opos.mobad.service.f.a().a(this.f12323a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        try {
            c("setBannerCovered posId=" + this.f12323a);
            g.put(this.f12323a, true);
            q();
            if (this.f12324c != null) {
                this.f12324c.b();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("delegator banner", "", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        n nVar = this.d;
        if (nVar != null) {
            nVar.a();
            this.d.b();
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        boolean z;
        try {
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("delegator banner", "", e);
        }
        if (g.containsKey(this.f12323a)) {
            z = g.get(this.f12323a).booleanValue();
            c("isBannerCovered=" + z);
            return z;
        }
        z = false;
        c("isBannerCovered=" + z);
        return z;
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.service.f.b().i());
    }

    @Override // com.opos.mobad.ad.a.a
    public void a(int i, int i2) {
        b(i, i2);
        c("setBannerWidthAndHeight width = " + i + ", height = " + i2);
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void a(int i, String str, int i2) {
        if (com.opos.mobad.service.f.b().b(this.f12323a) && d() == 2 && !this.k) {
            this.k = true;
            com.opos.mobad.service.i.d.a().a(this.f12323a, this.i, i, str, this.b.j(), g(), i2);
        }
    }

    @Override // com.opos.mobad.l.a, com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        q();
        this.b.b();
        this.f12324c.b();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void b(int i) {
        if (com.opos.mobad.service.f.b().b(this.f12323a) && d() == 2 && !this.k) {
            this.k = true;
            com.opos.mobad.service.i.d.a().a(this.f12323a, this.i, this.b.j(), g(), i);
        }
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str, int i) {
        c("doload");
        this.k = false;
        this.i = str;
        if (r() || com.opos.cmn.i.j.a(this.h, h())) {
            p();
            c(11004, "you should't play ad on the top in the shaped screen mobile");
            return false;
        }
        this.b.a(str, i);
        m();
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return 0;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i) {
        com.opos.mobad.ad.a.a i2;
        if (com.opos.mobad.service.f.b().b(this.f12323a) && (i2 = this.b.i()) != null) {
            i2.c(i);
        }
    }

    public void c(String str) {
        com.opos.cmn.an.f.a.b("delegator banner", str);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public boolean e() {
        com.opos.mobad.ad.a.a i = this.b.i();
        if (i != null) {
            return i.e();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        com.opos.mobad.ad.a.a i;
        if (com.opos.mobad.service.f.b().b(this.f12323a) && (i = this.b.i()) != null) {
            int g2 = i.g();
            if (g2 > 0) {
                return g2;
            }
            e.a k = this.b.k();
            if (k == null || k.g <= 0) {
                return 0;
            }
            return k.g;
        }
        return 0;
    }

    @Override // com.opos.mobad.ad.a.a
    public View h() {
        return this.f12324c.a();
    }
}
