package com.opos.mobad.f.a;

import android.content.Context;
import com.opos.mobad.ad.b;
import com.opos.mobad.service.a.e;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/h.class */
public class h extends com.opos.mobad.l.h {

    /* renamed from: a  reason: collision with root package name */
    private String f26103a;
    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.d.a> b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f26104c;
    private String d;
    private com.opos.mobad.ad.d.a g;
    private boolean h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/h$a.class */
    public class a extends com.opos.mobad.f.a.a.b implements com.opos.mobad.ad.d.b {

        /* renamed from: c  reason: collision with root package name */
        private final int f26109c;

        public a(int i, com.opos.mobad.f.a.a.n nVar) {
            super(i, nVar);
            this.f26109c = i;
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            h hVar = h.this;
            hVar.c("onAdFailed code=" + i + ",msg=" + str + ",currentState=" + h.this.d());
            if (1 == h.this.d()) {
                super.a(i, str);
                return;
            }
            h hVar2 = h.this;
            hVar2.c("current:" + this.f26109c + ",select=" + h.this.b.j());
            if (this.f26109c != h.this.b.j()) {
                return;
            }
            h.this.c(i, str);
        }

        @Override // com.opos.mobad.ad.d.b, com.opos.mobad.ad.i.b
        public void a(long j) {
            if (this.f26109c != h.this.b.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().b(h.this.f26103a);
            h.this.a(j);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            if (this.f26109c != h.this.b.j()) {
                return;
            }
            h.this.q();
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
            if (this.f26109c != h.this.b.j()) {
                return;
            }
            h.this.a(objArr);
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void b() {
            if (this.f26109c != h.this.b.j()) {
                return;
            }
            h.this.i_();
        }

        @Override // com.opos.mobad.ad.d.b
        public void b(long j) {
            if (this.f26109c != h.this.b.j()) {
                return;
            }
            h.this.b(j);
        }

        @Override // com.opos.mobad.ad.d.b
        public void b(String str) {
            if (this.f26109c != h.this.b.j()) {
                return;
            }
            h.this.d(str);
        }

        @Override // com.opos.mobad.ad.d.b
        public void c() {
            if (this.f26109c != h.this.b.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().a(h.this.f26103a);
            h.this.i();
        }

        @Override // com.opos.mobad.ad.d.b
        public void d() {
            if (this.f26109c != h.this.b.j()) {
                return;
            }
            h.this.h_();
        }

        @Override // com.opos.mobad.ad.d.b
        public void e() {
            if (this.f26109c != h.this.b.j()) {
                return;
            }
            h.this.k();
        }

        @Override // com.opos.mobad.ad.d.b
        public void f() {
            if (this.f26109c != h.this.b.j()) {
                return;
            }
            h.this.m();
        }
    }

    public h(final Context context, final String str, com.opos.mobad.f.a.d.a aVar, com.opos.mobad.ad.d.b bVar, final boolean z, List<e.a> list, e.a aVar2, long j, final com.opos.mobad.f.b bVar2) {
        super(bVar);
        this.h = false;
        this.f26103a = str;
        com.opos.mobad.f.a.b.b<com.opos.mobad.ad.d.a> bVar3 = new com.opos.mobad.f.a.b.b<com.opos.mobad.ad.d.a>() { // from class: com.opos.mobad.f.a.h.1
            @Override // com.opos.mobad.f.a.b.a
            /* renamed from: a */
            public com.opos.mobad.ad.d.a b(e.a aVar3, com.opos.mobad.f.a.a.n nVar) {
                com.opos.mobad.ad.c b = bVar2.b(aVar3.f27301a);
                if (b == null) {
                    return null;
                }
                return b.a(context, str, aVar3.b, z, new a(aVar3.f27301a, nVar));
            }
        };
        this.g = a(context, bVar2, str);
        this.b = a(str, aVar, list, aVar2, j, bVar3, new com.opos.mobad.f.a.c.a(context));
    }

    private com.opos.mobad.ad.d.a a(Context context, com.opos.mobad.f.b bVar, String str) {
        com.opos.mobad.ad.c b;
        com.opos.mobad.ad.d.a aVar = null;
        if (context != null) {
            if (bVar == null || (b = bVar.b(1000)) == null) {
                return null;
            }
            aVar = b.a(context, str, str, true, new com.opos.mobad.ad.d.b() { // from class: com.opos.mobad.f.a.h.3
                @Override // com.opos.mobad.ad.b.a
                public void a() {
                }

                @Override // com.opos.mobad.ad.b.a
                public void a(int i, String str2) {
                }

                @Override // com.opos.mobad.ad.d.b, com.opos.mobad.ad.i.b
                public void a(long j) {
                    h.this.a(j);
                }

                @Override // com.opos.mobad.ad.i.b
                public void a(String str2) {
                    h.this.q();
                }

                @Override // com.opos.mobad.ad.h
                public void a(Object... objArr) {
                    h.this.a(objArr);
                }

                @Override // com.opos.mobad.ad.b.a
                public void b() {
                    h.this.i_();
                }

                @Override // com.opos.mobad.ad.d.b
                public void b(long j) {
                    h.this.b(j);
                }

                @Override // com.opos.mobad.ad.d.b
                public void b(String str2) {
                    h.this.d(str2);
                }

                @Override // com.opos.mobad.ad.d.b
                public void c() {
                    h.this.i();
                }

                @Override // com.opos.mobad.ad.d.b
                public void d() {
                    h.this.h_();
                }

                @Override // com.opos.mobad.ad.d.b
                public void e() {
                    h.this.k();
                }

                @Override // com.opos.mobad.ad.d.b
                public void f() {
                    h.this.m();
                }
            });
        }
        return aVar;
    }

    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.d.a> a(String str, com.opos.mobad.f.a.d.a aVar, List<e.a> list, e.a aVar2, long j, com.opos.mobad.f.a.b.b<com.opos.mobad.ad.d.a> bVar, com.opos.mobad.f.a.c.a aVar3) {
        return com.opos.mobad.f.a.a.k.a(str, aVar, list, aVar2, j, bVar, aVar3, new b.a() { // from class: com.opos.mobad.f.a.h.2
            @Override // com.opos.mobad.ad.b.a
            public void a() {
                h.this.c("onAdReady");
                h.this.o();
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i, String str2) {
                h hVar = h.this;
                hVar.c("onAdFailed code= " + i + ",msg= " + str2);
                if (h.this.g != null && h.this.d(i) && h.this.g.d() == 2) {
                    h.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.f.a.h.2.1
                        @Override // java.util.concurrent.Callable
                        /* renamed from: a */
                        public Boolean call() throws Exception {
                            h.this.h = true;
                            return true;
                        }
                    });
                } else {
                    h.this.b(com.opos.mobad.f.a.a.l.a(i), str2);
                }
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
                h.this.i_();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(int i) {
        if (i == 10011) {
            return true;
        }
        if (i == -1 || i == -2 || i == -5 || i == -8 || i == -3) {
            c("need to intercept check errorCode = " + i);
            return true;
        }
        return false;
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.service.f.b().q());
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void a(int i, String str, int i2) {
        if (com.opos.mobad.service.f.b().b(this.f26103a) && d() == 2 && !this.f26104c) {
            this.f26104c = true;
            com.opos.mobad.service.i.d.a().a(this.f26103a, this.d, i, str, this.b.j(), g(), i2);
        }
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.b.b();
        com.opos.mobad.ad.d.a aVar = this.g;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void b(int i) {
        if (com.opos.mobad.service.f.b().b(this.f26103a) && d() == 2 && !this.f26104c) {
            this.f26104c = true;
            com.opos.mobad.service.i.d.a().a(this.f26103a, this.d, this.b.j(), g(), i);
        }
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str, int i) {
        c("doload");
        this.f26104c = false;
        this.d = str;
        this.h = false;
        com.opos.mobad.ad.d.a aVar = this.g;
        if (aVar != null) {
            aVar.a(str, i);
        }
        this.b.a(str, i);
        return true;
    }

    @Override // com.opos.mobad.l.h
    public boolean b(boolean z) {
        c("doShow");
        com.opos.mobad.ad.d.a i = this.h ? this.g : this.b.i();
        if (i == null) {
            c(-1, "ad is null");
            return false;
        }
        i.a(z);
        boolean z2 = false;
        if (i.d() == 3) {
            z2 = true;
        }
        return z2;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return 0;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i) {
        com.opos.mobad.ad.d.a i2;
        if (com.opos.mobad.service.f.b().b(this.f26103a) && (i2 = this.b.i()) != null) {
            i2.c(i);
        }
    }

    public void c(String str) {
        com.opos.cmn.an.f.a.b("delegator RWVideo", str);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public boolean e() {
        com.opos.mobad.ad.d.a i;
        if (this.h) {
            i = this.g;
        } else {
            i = this.b.i();
            if (i == null) {
                return false;
            }
        }
        return i.e();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        com.opos.mobad.ad.d.a i;
        if (com.opos.mobad.service.f.b().b(this.f26103a) && (i = this.b.i()) != null) {
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
