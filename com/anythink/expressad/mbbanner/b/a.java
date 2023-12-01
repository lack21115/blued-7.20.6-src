package com.anythink.expressad.mbbanner.b;

import com.anythink.expressad.foundation.d.d;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.y;
import com.anythink.expressad.mbbanner.a.c.b;
import com.anythink.expressad.mbbanner.a.d.c;
import com.anythink.expressad.out.TemplateBannerView;
import com.anythink.expressad.out.h;
import com.anythink.expressad.out.i;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/mbbanner/b/a.class */
public final class a {
    private static String b = "BannerController";

    /* renamed from: a  reason: collision with root package name */
    i f5212a;

    /* renamed from: c  reason: collision with root package name */
    private String f5213c;
    private String d;
    private boolean e;
    private int f;
    private TemplateBannerView g;
    private int h;
    private int i;
    private int j;
    private h l;
    private d m;
    private c n;
    private com.anythink.expressad.d.c o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int k = -1;
    private com.anythink.expressad.mbbanner.a.c.c u = new com.anythink.expressad.mbbanner.a.c.c() { // from class: com.anythink.expressad.mbbanner.b.a.1
        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void a() {
            if (a.this.l != null) {
                h unused = a.this.l;
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            if (a.this.l != null) {
                a.this.l.a(cVar);
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z) {
            if (a.this.l == null || z) {
                return;
            }
            a.this.l.b();
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void a(String str) {
            a.this.a(str);
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void a(List<com.anythink.expressad.foundation.d.c> list) {
            if (a.this.l != null) {
                a.this.l.a();
            }
            o.d(a.b, "onShowSuccessed:");
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void a(boolean z) {
            if (z) {
                com.anythink.expressad.mbbanner.a.d.a a2 = com.anythink.expressad.mbbanner.a.d.a.a();
                String unused = a.this.d;
                a2.a(2, a.this.f5213c);
                return;
            }
            com.anythink.expressad.mbbanner.a.d.a a3 = com.anythink.expressad.mbbanner.a.d.a.a();
            String unused2 = a.this.d;
            String str = a.this.f5213c;
            new com.anythink.expressad.mbbanner.a.b.d(a.this.i + "x" + a.this.h, a.this.j * 1000);
            b unused3 = a.this.v;
            a3.a(3, str);
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void b() {
            if (a.this.l != null) {
                h unused = a.this.l;
                a.this.t = true;
                com.anythink.expressad.mbbanner.a.d.a a2 = com.anythink.expressad.mbbanner.a.d.a.a();
                String unused2 = a.this.d;
                a2.a(2, a.this.f5213c);
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void c() {
            if (a.this.l != null) {
                h unused = a.this.l;
                a.this.t = false;
                com.anythink.expressad.mbbanner.a.d.a a2 = com.anythink.expressad.mbbanner.a.d.a.a();
                String unused2 = a.this.d;
                String str = a.this.f5213c;
                new com.anythink.expressad.mbbanner.a.b.d(a.this.i + "x" + a.this.h, a.this.j * 1000);
                b unused3 = a.this.v;
                a2.a(3, str);
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void d() {
            if (a.this.l != null) {
                a.this.l.f();
            }
        }
    };
    private b v = new b() { // from class: com.anythink.expressad.mbbanner.b.a.2
        @Override // com.anythink.expressad.mbbanner.a.c.b
        public final void a() {
            d unused = a.this.m;
            if (a.this.g != null) {
                a.j(a.this);
                a.this.h();
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.b
        public final void a(d dVar) {
            a.this.m = dVar;
        }

        @Override // com.anythink.expressad.mbbanner.a.c.b
        public final void a(String str) {
            if (a.this.l != null) {
                a.this.l.a(str);
            }
            o.d(a.b, "onCampaignFail:".concat(String.valueOf(str)));
        }

        @Override // com.anythink.expressad.mbbanner.a.c.b
        public final void b() {
            if (a.this.l != null) {
                a.this.l.a(com.anythink.expressad.mbbanner.a.a.f5155c);
            }
            o.d(a.b, "onResourceFail:");
        }
    };

    public a(TemplateBannerView templateBannerView, i iVar, String str, String str2) {
        this.g = templateBannerView;
        if (iVar != null) {
            this.h = iVar.a();
            this.i = iVar.b();
        }
        this.f5212a = iVar;
        this.f5213c = str2;
        this.d = str;
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.c c2 = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), this.f5213c);
        this.o = c2;
        if (c2 == null) {
            this.o = com.anythink.expressad.d.c.c(this.f5213c);
        }
        if (this.k == -1) {
            int b2 = this.o.b();
            int i = b2;
            if (b2 > 0) {
                if (b2 < 10) {
                    i = 10;
                } else {
                    i = b2;
                    if (b2 > 180) {
                        i = 180;
                    }
                }
            }
            this.j = i;
        }
        if (this.f == 0) {
            boolean z = this.o.d() != 1 ? false : true;
            this.e = z;
            c cVar = this.n;
            if (cVar != null) {
                cVar.a(z);
            }
        }
    }

    private static int a(int i) {
        int i2 = i;
        if (i > 0) {
            if (i < 10) {
                return 10;
            }
            i2 = i;
            if (i > 180) {
                i2 = 180;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        h hVar = this.l;
        if (hVar != null) {
            hVar.a(str);
        }
        o.d(b, "showFailed:".concat(String.valueOf(str)));
    }

    private void f() {
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.c c2 = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), this.f5213c);
        this.o = c2;
        if (c2 == null) {
            this.o = com.anythink.expressad.d.c.c(this.f5213c);
        }
        if (this.k == -1) {
            int b2 = this.o.b();
            int i = b2;
            if (b2 > 0) {
                if (b2 < 10) {
                    i = 10;
                } else {
                    i = b2;
                    if (b2 > 180) {
                        i = 180;
                    }
                }
            }
            this.j = i;
        }
        if (this.f == 0) {
            boolean z = true;
            if (this.o.d() != 1) {
                z = false;
            }
            this.e = z;
            c cVar = this.n;
            if (cVar != null) {
                cVar.a(z);
            }
        }
    }

    private void g() {
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.c c2 = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), this.f5213c);
        this.o = c2;
        if (c2 == null) {
            this.o = com.anythink.expressad.d.c.c(this.f5213c);
        }
        if (this.k == -1) {
            int b2 = this.o.b();
            int i = b2;
            if (b2 > 0) {
                if (b2 < 10) {
                    i = 10;
                } else {
                    i = b2;
                    if (b2 > 180) {
                        i = 180;
                    }
                }
            }
            this.j = i;
        }
        if (this.f == 0) {
            boolean z = true;
            if (this.o.d() != 1) {
                z = false;
            }
            this.e = z;
            c cVar = this.n;
            if (cVar != null) {
                cVar.a(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.r || !this.s) {
            return;
        }
        if (this.m != null) {
            if (this.n == null) {
                this.n = new c(this.g, this.u, this.d, this.f5213c, this.e, this.o);
            }
            this.n.a(this.f5212a);
            this.n.b(this.p);
            this.n.c(this.q);
            this.n.a(this.e, this.f);
            this.n.a(this.m);
        } else {
            a(com.anythink.expressad.mbbanner.a.a.h);
        }
        this.s = false;
    }

    private static boolean i() {
        return true;
    }

    private static void j() {
    }

    static /* synthetic */ boolean j(a aVar) {
        aVar.s = true;
        return true;
    }

    private void k() {
        TemplateBannerView templateBannerView = this.g;
        if (templateBannerView != null) {
            if (!this.p || !this.q || this.t || y.a(templateBannerView)) {
                com.anythink.expressad.mbbanner.a.d.a.a().a(2, this.f5213c);
            } else {
                com.anythink.expressad.mbbanner.a.d.a a2 = com.anythink.expressad.mbbanner.a.d.a.a();
                String str = this.f5213c;
                new com.anythink.expressad.mbbanner.a.b.d(this.i + "x" + this.h, this.j * 1000);
                a2.a(3, str);
            }
            if (this.p) {
                return;
            }
            com.anythink.expressad.mbbanner.a.d.a.a().a(4, this.f5213c);
            com.anythink.expressad.mbbanner.a.d.a.a().a(this.f5213c);
        }
    }

    private void l() {
        k();
        c cVar = this.n;
        if (cVar != null) {
            cVar.b(this.p);
            this.n.c(this.q);
        }
    }

    public final String a() {
        d dVar = this.m;
        return (dVar == null || dVar.f() == null) ? "" : this.m.f();
    }

    public final void a(int i, int i2, int i3, int i4) {
        c cVar = this.n;
        if (cVar != null) {
            cVar.a(i, i2, i3, i4);
        }
    }

    public final void a(d dVar) {
        this.m = dVar;
        com.anythink.expressad.mbbanner.a.d.a.a().a(this.f5213c, dVar, this.v);
    }

    public final void a(h hVar) {
        this.l = hVar;
    }

    public final void a(i iVar) {
        if (iVar != null) {
            this.h = iVar.a();
            this.i = iVar.b();
        }
    }

    public final void a(boolean z) {
        this.e = z;
        this.f = z ? 1 : 2;
    }

    public final void b() {
        this.r = true;
        if (this.l != null) {
            this.l = null;
        }
        if (this.v != null) {
            this.v = null;
        }
        if (this.u != null) {
            this.u = null;
        }
        if (this.g != null) {
            this.g = null;
        }
        com.anythink.expressad.mbbanner.a.d.a.a().a(4, this.f5213c);
        com.anythink.expressad.mbbanner.a.d.a.a().a(this.f5213c);
        com.anythink.expressad.mbbanner.a.d.a.a().b();
        c cVar = this.n;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void b(boolean z) {
        this.p = z;
        l();
        h();
    }

    public final void c() {
        com.anythink.expressad.mbbanner.a.d.a a2 = com.anythink.expressad.mbbanner.a.d.a.a();
        String str = this.f5213c;
        new com.anythink.expressad.mbbanner.a.b.d(this.i + "x" + this.h, this.j * 1000);
        a2.a(4, str);
    }

    public final void c(boolean z) {
        this.q = z;
        l();
    }

    public final void d() {
        com.anythink.expressad.mbbanner.a.d.a a2 = com.anythink.expressad.mbbanner.a.d.a.a();
        String str = this.f5213c;
        new com.anythink.expressad.mbbanner.a.b.d(this.i + "x" + this.h, this.j * 1000);
        a2.a(3, str);
    }
}
