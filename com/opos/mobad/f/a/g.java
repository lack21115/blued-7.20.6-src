package com.opos.mobad.f.a;

import android.content.Context;
import android.view.View;
import com.opos.mobad.ad.b;
import com.opos.mobad.ad.c.p;
import com.opos.mobad.ad.c.q;
import com.opos.mobad.ad.c.s;
import com.opos.mobad.f.a.a.o;
import com.opos.mobad.service.a.e;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/g.class */
public class g extends com.opos.mobad.l.g {
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f12408c;
    private o<com.opos.mobad.ad.c.n, p> d;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/g$a.class */
    public class a extends com.opos.mobad.f.a.a.p<p> implements com.opos.mobad.ad.c.o {

        /* renamed from: c  reason: collision with root package name */
        private int f12412c;

        public a(int i, com.opos.mobad.f.a.a.n nVar) {
            super(i, nVar);
            this.f12412c = i;
        }

        @Override // com.opos.mobad.ad.c.o
        public void a(p pVar) {
            if (this.f12412c == g.this.d.j()) {
                com.opos.mobad.service.j.n.a().b(g.this.b);
                g.this.a(pVar);
            }
        }

        @Override // com.opos.mobad.ad.c.o
        public void a(q qVar, p pVar) {
            if (this.f12412c == g.this.d.j()) {
                g.this.a(qVar, pVar);
            }
        }

        @Override // com.opos.mobad.ad.c.o
        public void b(p pVar) {
            if (this.f12412c == g.this.d.j()) {
                com.opos.mobad.service.j.n.a().a(g.this.b);
                g.this.b(pVar);
            }
        }

        @Override // com.opos.mobad.ad.c.o
        public void c(p pVar) {
            if (this.f12412c == g.this.d.j()) {
                g.this.c(pVar);
            }
        }

        @Override // com.opos.mobad.ad.c.o
        public void d(p pVar) {
            if (this.f12412c == g.this.d.j()) {
                g.this.d(pVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/g$b.class */
    public static class b implements p {

        /* renamed from: a  reason: collision with root package name */
        private String f12413a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private int f12414c;
        private boolean d = false;
        private p e;
        private int f;

        public b(p pVar, String str, String str2, int i, int i2) {
            this.e = pVar;
            this.f12413a = str;
            this.b = str2;
            this.f12414c = i;
            this.f = i2;
        }

        @Override // com.opos.mobad.ad.c.p
        public View a() {
            return this.e.a();
        }

        @Override // com.opos.mobad.ad.g
        public void a(int i, String str, int i2) {
            if (!com.opos.mobad.service.f.b().b(this.f12413a) || this.d) {
                return;
            }
            this.d = true;
            com.opos.mobad.service.i.d.a().a(this.f12413a, this.b, i, str, this.f12414c, this.f, i2);
        }

        @Override // com.opos.mobad.ad.c.p
        public void a(Object obj) {
            this.e.a(obj);
        }

        @Override // com.opos.mobad.ad.c.p
        public void b() {
            this.e.b();
        }

        @Override // com.opos.mobad.ad.g
        public void b(int i) {
            if (!com.opos.mobad.service.f.b().b(this.f12413a) || this.d) {
                return;
            }
            this.d = true;
            com.opos.mobad.service.i.d.a().a(this.f12413a, this.b, this.f12414c, this.f, i);
        }

        @Override // com.opos.mobad.ad.c.p
        public void c() {
            this.e.c();
        }

        @Override // com.opos.mobad.ad.g
        public void c(int i) {
            if (!com.opos.mobad.service.f.b().b(this.f12413a) || this.d) {
                return;
            }
            this.e.c(i);
        }

        @Override // com.opos.mobad.ad.c.p
        public Object d() {
            return this.e.d();
        }

        @Override // com.opos.mobad.ad.g
        public int f() {
            return 0;
        }

        @Override // com.opos.mobad.ad.g
        public int g() {
            if (com.opos.mobad.service.f.b().b(this.f12413a)) {
                return this.f;
            }
            return 0;
        }
    }

    public g(final Context context, final s sVar, final String str, com.opos.mobad.f.a.d.a aVar, com.opos.mobad.ad.c.o oVar, List<e.a> list, e.a aVar2, long j, final com.opos.mobad.f.b bVar) {
        super(oVar);
        this.b = str;
        this.d = a(str, aVar, list, aVar2, j, new com.opos.mobad.f.a.b.c<com.opos.mobad.ad.c.n>() { // from class: com.opos.mobad.f.a.g.1
            @Override // com.opos.mobad.f.a.b.a
            /* renamed from: a */
            public com.opos.mobad.ad.c.n b(e.a aVar3, com.opos.mobad.f.a.a.n nVar) {
                com.opos.mobad.ad.c b2 = bVar.b(aVar3.f13613a);
                if (b2 == null) {
                    return null;
                }
                return b2.a(context, new s.a().a(sVar.f11988a).b(sVar.b).a(), str, aVar3.b, new a(aVar3.f13613a, nVar));
            }
        }, new com.opos.mobad.f.a.c.a(context));
    }

    private o<com.opos.mobad.ad.c.n, p> a(String str, com.opos.mobad.f.a.d.a aVar, List<e.a> list, e.a aVar2, long j, com.opos.mobad.f.a.b.c<com.opos.mobad.ad.c.n> cVar, com.opos.mobad.f.a.c.a aVar3) {
        return com.opos.mobad.f.a.a.k.a(str, aVar, list, aVar2, j, cVar, aVar3, new b.a() { // from class: com.opos.mobad.f.a.g.2
            @Override // com.opos.mobad.ad.b.a
            public void a() {
                List h = g.this.d.h();
                g gVar = g.this;
                gVar.a(gVar.a(h, gVar.d.j()));
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i, String str2) {
                com.opos.cmn.an.f.a.b("dispatcher NT", "onAdFailed code=" + i + ",msg =" + str2);
                g.this.a(com.opos.mobad.f.a.a.l.a(i), str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<p> a(List<p> list, int i) {
        ArrayList arrayList = list;
        if (list != null) {
            if (list.size() <= 0) {
                return list;
            }
            arrayList = new ArrayList();
            for (p pVar : list) {
                if (pVar != null) {
                    int g = pVar.g();
                    int i2 = g;
                    if (g <= 0) {
                        e.a k = this.d.k();
                        i2 = (k == null || k.g <= 0) ? 0 : k.g;
                    }
                    arrayList.add(new b(pVar, this.b, this.f12408c, i, i2));
                }
            }
        }
        return arrayList;
    }

    @Override // com.opos.mobad.l.f, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.service.f.b().u());
    }

    @Override // com.opos.mobad.l.f, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.d.b();
    }

    @Override // com.opos.mobad.l.f
    public boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.f
    public boolean b(String str, int i) {
        this.f12408c = str;
        this.d.a(str, i);
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return 0;
    }

    @Override // com.opos.mobad.l.f, com.opos.mobad.ad.b
    public boolean e() {
        return false;
    }
}
