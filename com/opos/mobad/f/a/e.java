package com.opos.mobad.f.a;

import android.app.Activity;
import com.opos.mobad.ad.b;
import com.opos.mobad.service.a.e;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/e.class */
public class e extends com.opos.mobad.l.d {

    /* renamed from: a  reason: collision with root package name */
    private String f12395a;
    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.b.c> b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12396c;
    private String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/e$a.class */
    public class a extends com.opos.mobad.f.a.a.b implements com.opos.mobad.ad.b.d {
        private final int b;

        public a(int i, com.opos.mobad.f.a.a.n nVar) {
            super(i, nVar);
            this.b = i;
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            if (1 == e.this.d()) {
                super.a(i, str);
            } else if (this.b != e.this.b.j()) {
            } else {
                e.this.c(i, str);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j) {
            if (this.b != e.this.b.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().b(e.this.f12395a);
            e.this.p();
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            if (this.b != e.this.b.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().a(e.this.f12395a);
            e.this.q();
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void b() {
            if (this.b != e.this.b.j()) {
                return;
            }
            e.this.i_();
        }

        @Override // com.opos.mobad.ad.b.d
        public void c() {
            if (this.b != e.this.b.j()) {
                return;
            }
            e.this.h();
        }
    }

    public e(final Activity activity, final String str, com.opos.mobad.f.a.d.a aVar, com.opos.mobad.ad.b.d dVar, final boolean z, List<e.a> list, e.a aVar2, long j, final com.opos.mobad.f.b bVar) {
        super(dVar);
        this.f12395a = str;
        this.b = a(str, aVar, list, aVar2, j, new com.opos.mobad.f.a.b.b<com.opos.mobad.ad.b.c>() { // from class: com.opos.mobad.f.a.e.1
            @Override // com.opos.mobad.f.a.b.a
            /* renamed from: a */
            public com.opos.mobad.ad.b.c b(e.a aVar3, com.opos.mobad.f.a.a.n nVar) {
                com.opos.mobad.ad.c b = bVar.b(aVar3.f13613a);
                if (b == null) {
                    return null;
                }
                return b.a(activity, str, aVar3.b, z, new a(aVar3.f13613a, nVar));
            }
        }, new com.opos.mobad.f.a.c.a(activity));
    }

    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.b.c> a(String str, com.opos.mobad.f.a.d.a aVar, List<e.a> list, e.a aVar2, long j, com.opos.mobad.f.a.b.b<com.opos.mobad.ad.b.c> bVar, com.opos.mobad.f.a.c.a aVar3) {
        return com.opos.mobad.f.a.a.k.a(str, aVar, list, aVar2, j, bVar, aVar3, new b.a() { // from class: com.opos.mobad.f.a.e.2
            @Override // com.opos.mobad.ad.b.a
            public void a() {
                e.this.o();
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i, String str2) {
                com.opos.cmn.an.f.a.b("delegator InterstitialVideo", "onAdFailed code=" + i + ",msg =" + str2);
                e.this.b(com.opos.mobad.f.a.a.l.a(i), str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
                e.this.i_();
            }
        });
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.service.f.b().p());
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void a(int i, String str, int i2) {
        if (com.opos.mobad.service.f.b().b(this.f12395a) && d() == 2 && !this.f12396c) {
            this.f12396c = true;
            com.opos.mobad.service.i.d.a().a(this.f12395a, this.d, i, str, this.b.j(), g(), i2);
        }
    }

    @Override // com.opos.mobad.l.d, com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.b.b();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void b(int i) {
        if (com.opos.mobad.service.f.b().b(this.f12395a) && d() == 2 && !this.f12396c) {
            this.f12396c = true;
            com.opos.mobad.service.i.d.a().a(this.f12395a, this.d, this.b.j(), g(), i);
        }
    }

    @Override // com.opos.mobad.l.k
    public boolean b(Activity activity) {
        com.opos.mobad.ad.b.c i = this.b.i();
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
        this.f12396c = false;
        this.d = str;
        this.b.a(str, i);
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return 0;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i) {
        com.opos.mobad.ad.b.c i2;
        if (com.opos.mobad.service.f.b().b(this.f12395a) && (i2 = this.b.i()) != null) {
            i2.c(i);
        }
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public boolean e() {
        com.opos.mobad.ad.b.c i = this.b.i();
        if (i != null) {
            return i.e();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        com.opos.mobad.ad.b.c i;
        if (com.opos.mobad.service.f.b().b(this.f12395a) && (i = this.b.i()) != null) {
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
