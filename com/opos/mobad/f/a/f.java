package com.opos.mobad.f.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.ad.b;
import com.opos.mobad.ad.c.h;
import com.opos.mobad.f.a.a.o;
import com.opos.mobad.f.a.a.p;
import com.opos.mobad.service.a.e;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/f.class */
public class f extends com.opos.mobad.l.e {
    private o<com.opos.mobad.ad.c.g, com.opos.mobad.ad.c.h> b;

    /* renamed from: c  reason: collision with root package name */
    private String f26089c;
    private String d;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/f$a.class */
    public class a extends p<com.opos.mobad.ad.c.h> implements com.opos.mobad.ad.c.j {
        public a(int i, com.opos.mobad.f.a.a.n nVar) {
            super(i, nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/f$b.class */
    public static class b implements com.opos.mobad.ad.c.h {

        /* renamed from: a  reason: collision with root package name */
        private com.opos.mobad.ad.c.h f26094a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f26095c;
        private boolean d = false;
        private int e;
        private int f;

        public b(com.opos.mobad.ad.c.h hVar, String str, String str2, int i, int i2) {
            this.f26094a = hVar;
            this.b = str;
            this.f26095c = str2;
            this.e = i;
            this.f = i2;
        }

        @Override // com.opos.mobad.ad.c.h
        public String a() {
            return this.f26094a.a();
        }

        @Override // com.opos.mobad.ad.g
        public void a(int i, String str, int i2) {
            if (!com.opos.mobad.service.f.b().b(this.b) || this.d) {
                return;
            }
            this.d = true;
            com.opos.mobad.service.i.d.a().a(this.b, this.f26095c, i, str, this.e, this.f, i2);
        }

        @Override // com.opos.mobad.ad.c.h
        public void a(Context context, FrameLayout frameLayout, com.opos.mobad.ad.c.k kVar) {
            this.f26094a.a(context, frameLayout, kVar);
        }

        @Override // com.opos.mobad.ad.c.h
        public void a(Context context, FrameLayout frameLayout, List<View> list) {
            this.f26094a.a(context, frameLayout, list);
        }

        @Override // com.opos.mobad.ad.c.h
        public void a(Context context, List<View> list, h.a aVar, List<View> list2, h.a aVar2) {
            this.f26094a.a(context, list, aVar, list2, aVar2);
        }

        @Override // com.opos.mobad.ad.c.h
        public void a(com.opos.mobad.ad.c.i iVar) {
            this.f26094a.a(iVar);
        }

        @Override // com.opos.mobad.ad.c.h
        public String b() {
            return this.f26094a.b();
        }

        @Override // com.opos.mobad.ad.g
        public void b(int i) {
            if (!com.opos.mobad.service.f.b().b(this.b) || this.d) {
                return;
            }
            this.d = true;
            com.opos.mobad.service.i.d.a().a(this.b, this.f26095c, this.e, this.f, i);
        }

        @Override // com.opos.mobad.ad.c.h
        public List<com.opos.mobad.ad.c.e> c() {
            return this.f26094a.c();
        }

        @Override // com.opos.mobad.ad.g
        public void c(int i) {
            this.f26094a.c(i);
        }

        @Override // com.opos.mobad.ad.c.h
        public List<com.opos.mobad.ad.c.e> d() {
            return this.f26094a.d();
        }

        @Override // com.opos.mobad.ad.c.h
        public int e() {
            return this.f26094a.e();
        }

        @Override // com.opos.mobad.ad.g
        public int f() {
            return 0;
        }

        @Override // com.opos.mobad.ad.g
        public int g() {
            if (com.opos.mobad.service.f.b().b(this.b)) {
                return this.f;
            }
            return 0;
        }

        @Override // com.opos.mobad.ad.c.h
        public int h() {
            return this.f26094a.h();
        }

        @Override // com.opos.mobad.ad.c.h
        public com.opos.mobad.ad.c.e i() {
            return this.f26094a.i();
        }

        @Override // com.opos.mobad.ad.c.h
        public boolean j() {
            return this.f26094a.j();
        }

        @Override // com.opos.mobad.ad.c.h
        public String k() {
            return this.f26094a.k();
        }

        @Override // com.opos.mobad.ad.c.h
        public String l() {
            return this.f26094a.l();
        }

        @Override // com.opos.mobad.ad.c.h
        public void m() {
            this.f26094a.m();
        }

        @Override // com.opos.mobad.ad.c.h
        public com.opos.mobad.ad.c.b n() {
            return this.f26094a.n();
        }
    }

    public f(final Context context, final String str, com.opos.mobad.f.a.d.a aVar, com.opos.mobad.ad.c.j jVar, List<e.a> list, e.a aVar2, long j, final com.opos.mobad.f.b bVar, final com.opos.mobad.ad.privacy.a aVar3) {
        super(jVar);
        this.d = str;
        this.b = a(str, aVar, list, aVar2, j, new com.opos.mobad.f.a.b.c<com.opos.mobad.ad.c.g>() { // from class: com.opos.mobad.f.a.f.1
            @Override // com.opos.mobad.f.a.b.a
            /* renamed from: a */
            public com.opos.mobad.ad.c.g b(e.a aVar4, com.opos.mobad.f.a.a.n nVar) {
                com.opos.mobad.ad.c b2 = bVar.b(aVar4.f27301a);
                if (b2 == null) {
                    return null;
                }
                return b2.a(context, str, aVar4.b, aVar4.e, aVar4.d, new a(aVar4.f27301a, nVar), aVar3);
            }
        }, new com.opos.mobad.f.a.c.a(context));
    }

    private o<com.opos.mobad.ad.c.g, com.opos.mobad.ad.c.h> a(String str, com.opos.mobad.f.a.d.a aVar, List<e.a> list, e.a aVar2, long j, com.opos.mobad.f.a.b.c<com.opos.mobad.ad.c.g> cVar, com.opos.mobad.f.a.c.a aVar3) {
        return com.opos.mobad.f.a.a.k.a(str, aVar, list, aVar2, j, cVar, aVar3, new b.a() { // from class: com.opos.mobad.f.a.f.2
            @Override // com.opos.mobad.ad.b.a
            public void a() {
                List h = f.this.b.h();
                f fVar = f.this;
                fVar.a(fVar.a(h, fVar.b.j()));
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i, String str2) {
                com.opos.cmn.an.f.a.b("delegator NA", "onAdFailed code=" + i + ",msg =" + str2);
                f.this.a(com.opos.mobad.f.a.a.l.a(i), str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.opos.mobad.ad.c.h> a(List<com.opos.mobad.ad.c.h> list, int i) {
        ArrayList arrayList = list;
        if (list != null) {
            if (list.size() <= 0) {
                return list;
            }
            arrayList = new ArrayList();
            for (com.opos.mobad.ad.c.h hVar : list) {
                if (hVar != null) {
                    int g = hVar.g();
                    int i2 = g;
                    if (g <= 0) {
                        e.a k = this.b.k();
                        i2 = (k == null || k.g <= 0) ? 0 : k.g;
                    }
                    arrayList.add(new b(hVar, this.d, this.f26089c, i, i2));
                }
            }
        }
        return arrayList;
    }

    @Override // com.opos.mobad.l.f, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.service.f.b().s());
    }

    @Override // com.opos.mobad.l.f, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.b.b();
    }

    @Override // com.opos.mobad.l.f
    public boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.f
    public boolean b(String str, int i) {
        this.f26089c = str;
        this.b.a(str, i);
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
