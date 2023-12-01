package com.opos.mobad.f.a;

import android.app.Activity;
import com.opos.mobad.ad.b;
import com.opos.mobad.service.a.e;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/d.class */
public class d extends com.opos.mobad.l.c {

    /* renamed from: a  reason: collision with root package name */
    private String f26076a;
    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.b.a> b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f26077c;
    private String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/d$a.class */
    public class a extends com.opos.mobad.f.a.a.b implements com.opos.mobad.ad.b.b {

        /* renamed from: c  reason: collision with root package name */
        private final int f26082c;

        public a(int i, com.opos.mobad.f.a.a.n nVar) {
            super(i, nVar);
            this.f26082c = i;
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            if (1 == d.this.d()) {
                super.a(i, str);
            } else if (this.f26082c != d.this.b.j()) {
            } else {
                d.this.c(i, str);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j) {
            if (this.f26082c != d.this.b.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().b(d.this.f26076a);
            d.this.p();
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            if (this.f26082c != d.this.b.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().a(d.this.f26076a);
            d.this.q();
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void b() {
            if (this.f26082c != d.this.b.j()) {
                return;
            }
            d.this.i_();
        }
    }

    public d(final Activity activity, final String str, com.opos.mobad.f.a.d.a aVar, com.opos.mobad.ad.b.b bVar, List<e.a> list, e.a aVar2, long j, final com.opos.mobad.f.b bVar2) {
        super(bVar);
        this.f26076a = str;
        this.b = a(str, aVar, list, aVar2, j, new com.opos.mobad.f.a.b.b<com.opos.mobad.ad.b.a>() { // from class: com.opos.mobad.f.a.d.1
            @Override // com.opos.mobad.f.a.b.a
            /* renamed from: a */
            public com.opos.mobad.ad.b.a b(e.a aVar3, com.opos.mobad.f.a.a.n nVar) {
                com.opos.mobad.ad.c b = bVar2.b(aVar3.f27301a);
                if (b == null) {
                    return null;
                }
                return b.a(activity, str, aVar3.b, new a(aVar3.f27301a, nVar));
            }
        }, new com.opos.mobad.f.a.c.a(activity));
    }

    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.b.a> a(String str, com.opos.mobad.f.a.d.a aVar, List<e.a> list, e.a aVar2, long j, com.opos.mobad.f.a.b.b<com.opos.mobad.ad.b.a> bVar, com.opos.mobad.f.a.c.a aVar3) {
        return com.opos.mobad.f.a.a.k.a(str, aVar, list, aVar2, j, bVar, aVar3, new b.a() { // from class: com.opos.mobad.f.a.d.2
            @Override // com.opos.mobad.ad.b.a
            public void a() {
                d.this.o();
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i, String str2) {
                com.opos.cmn.an.f.a.b("delegator Interstitial", "onAdFailed code=" + i + ",msg =" + str2);
                d.this.b(com.opos.mobad.f.a.a.l.a(i), str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
                d.this.i_();
            }
        });
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.service.f.b().n());
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void a(int i, String str, int i2) {
        if (com.opos.mobad.service.f.b().b(this.f26076a) && d() == 2 && !this.f26077c) {
            this.f26077c = true;
            com.opos.mobad.service.i.d.a().a(this.f26076a, this.d, i, str, this.b.j(), g(), i2);
        }
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.b.b();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void b(int i) {
        if (com.opos.mobad.service.f.b().b(this.f26076a) && d() == 2 && !this.f26077c) {
            this.f26077c = true;
            com.opos.mobad.service.i.d.a().a(this.f26076a, this.d, this.b.j(), g(), i);
        }
    }

    @Override // com.opos.mobad.l.k
    public boolean b(Activity activity) {
        com.opos.mobad.ad.b.a i = this.b.i();
        boolean z = false;
        if (i == null) {
            c(-1, "ad is null");
            return false;
        }
        i.a(activity);
        if (i.d() == 3) {
            z = true;
        }
        return z;
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str, int i) {
        this.d = str;
        this.f26077c = false;
        this.b.a(str, i);
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return 0;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i) {
        com.opos.mobad.ad.b.a i2;
        if (com.opos.mobad.service.f.b().b(this.f26076a) && (i2 = this.b.i()) != null) {
            i2.c(i);
        }
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public boolean e() {
        com.opos.mobad.ad.b.a i = this.b.i();
        if (i != null) {
            return i.e();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        com.opos.mobad.ad.b.a i;
        if (com.opos.mobad.service.f.b().b(this.f26076a) && (i = this.b.i()) != null) {
            int g = i.g();
            if (g > 0) {
                return g;
            }
            e.a k = this.b.k();
            if (k == null || k.g <= 0) {
                return 0;
            }
            return k.g;
        }
        return 0;
    }
}
