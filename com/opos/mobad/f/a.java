package com.opos.mobad.f;

import android.app.Activity;
import android.content.Context;
import com.opos.mobad.ad.c;
import com.opos.mobad.ad.c.j;
import com.opos.mobad.ad.c.m;
import com.opos.mobad.ad.c.n;
import com.opos.mobad.ad.c.o;
import com.opos.mobad.ad.c.s;
import com.opos.mobad.f.b.i;
import com.opos.mobad.g;
import com.opos.mobad.service.a.e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private c.a f12319a = new c.a(true, "");

    /* renamed from: c  reason: collision with root package name */
    private AtomicBoolean f12320c = new AtomicBoolean(false);
    private boolean d = false;
    private b b = new b();
    private com.opos.mobad.ad.privacy.a e = new com.opos.mobad.cmn.b.d(new g());

    private com.opos.mobad.ad.b a(com.opos.mobad.f.b.a aVar, e.a aVar2, com.opos.mobad.ad.c cVar) {
        if (aVar instanceof com.opos.mobad.f.b.b) {
            com.opos.mobad.f.b.b bVar = (com.opos.mobad.f.b.b) aVar;
            return cVar.a((Activity) bVar.d, bVar.f12442a, aVar2.b, bVar.f12443c, (com.opos.mobad.ad.a.b) bVar.e);
        } else if (aVar instanceof com.opos.mobad.f.b.d) {
            com.opos.mobad.f.b.d dVar = (com.opos.mobad.f.b.d) aVar;
            return cVar.a((Activity) dVar.d, dVar.f12442a, aVar2.b, com.opos.mobad.service.f.b().a(dVar.f12442a) == com.opos.mobad.service.a.e.b, (com.opos.mobad.ad.b.d) dVar.e);
        } else if (aVar instanceof com.opos.mobad.f.b.c) {
            com.opos.mobad.f.b.c cVar2 = (com.opos.mobad.f.b.c) aVar;
            return cVar.a((Activity) cVar2.d, cVar2.f12442a, aVar2.b, (com.opos.mobad.ad.b.b) cVar2.e);
        } else if (aVar instanceof com.opos.mobad.f.b.e) {
            com.opos.mobad.f.b.e eVar = (com.opos.mobad.f.b.e) aVar;
            return cVar.a(eVar.f12444c, eVar.f12442a, aVar2.b, aVar2.e, aVar2.d, (j) eVar.d, this.e);
        } else if (aVar instanceof com.opos.mobad.f.b.g) {
            com.opos.mobad.f.b.g gVar = (com.opos.mobad.f.b.g) aVar;
            return cVar.a(gVar.f12444c, gVar.e, gVar.f12442a, aVar2.b, (o) gVar.d);
        } else if (aVar instanceof i) {
            i iVar = (i) aVar;
            return cVar.a(iVar.d, iVar.f12442a, aVar2.b, com.opos.mobad.service.f.b().a(iVar.f12442a) == com.opos.mobad.service.a.e.b, (com.opos.mobad.ad.d.b) iVar.e);
        } else if (aVar instanceof com.opos.mobad.f.b.j) {
            com.opos.mobad.f.b.j jVar = (com.opos.mobad.f.b.j) aVar;
            f fVar = new f();
            com.opos.mobad.ad.e.b a2 = cVar.a((Activity) jVar.d, jVar.f12442a, aVar2.b, jVar.f12445c, (com.opos.mobad.ad.e.c) jVar.e);
            fVar.a(a2);
            return a2;
        } else {
            com.opos.cmn.an.f.a.b("AdBaseFactory", "fail create:" + aVar);
            return null;
        }
    }

    private com.opos.mobad.ad.b a(com.opos.mobad.f.b.a aVar, List<e.a> list, e.a aVar2, long j, int i) {
        com.opos.cmn.an.f.a.a("AdBaseFactory", "create ssp posId:" + aVar.f12442a + "," + list + ",reserve =" + aVar2 + "," + i);
        return a(aVar, a(aVar.f12442a, list.get(0)), new d(new com.opos.mobad.f.a.d.c(i, aVar.b), list, aVar2, j, this.b));
    }

    private com.opos.mobad.ad.b a(com.opos.mobad.f.b.a aVar, List<e.a> list, e.a aVar2, long j, long j2) {
        e.a a2 = a(aVar.f12442a, list, aVar2, j);
        com.opos.cmn.an.f.a.a("AdBaseFactory", "create delegator posId:" + aVar.f12442a + "," + list + "," + a2);
        return a(aVar, b(aVar.f12442a, list.get(0)), new d(new com.opos.mobad.f.a.d.b(aVar.b), list, a2, j2, this.b));
    }

    private e.a a(String str) {
        return new e.a(1, str, 100, 30000L, 0, 0);
    }

    private e.a a(String str, e.a aVar) {
        return new e.a(1, str, 100, 30000L, aVar.d, aVar.e);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00fc, code lost:
        if (r14 == null) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.opos.mobad.service.a.e.a a(java.lang.String r12, java.util.List<com.opos.mobad.service.a.e.a> r13, com.opos.mobad.service.a.e.a r14, long r15) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.f.a.a(java.lang.String, java.util.List, com.opos.mobad.service.a.e$a, long):com.opos.mobad.service.a.e$a");
    }

    private e.a a(List<e.a> list, String str, long j) {
        ArrayList arrayList = list == null ? new ArrayList() : list;
        e.a aVar = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (e.a aVar2 : arrayList) {
            if (1 == aVar2.f13613a) {
                aVar = aVar2;
            }
            i2 = aVar2.d;
            i3 = aVar2.e;
            i += aVar2.f;
        }
        e.a aVar3 = aVar;
        if (aVar == null) {
            aVar3 = new e.a(1, str, Math.max(0, 100 - i), j, i2, i3);
            arrayList.add(aVar3);
        }
        return aVar3;
    }

    private com.opos.mobad.ad.b b(com.opos.mobad.f.b.a aVar) {
        com.opos.cmn.an.f.a.a("AdBaseFactory", "create default posId:" + aVar.f12442a);
        ArrayList arrayList = new ArrayList();
        e.a a2 = a(aVar.f12442a);
        return a(aVar, a2, new d(new com.opos.mobad.f.a.d.b(aVar.b), arrayList, a2, 0L, this.b));
    }

    private e.a b(String str, e.a aVar) {
        return new e.a(1, str, 100, 30000L, aVar.d, aVar.e);
    }

    private boolean d() {
        if (this.f12319a.f11982a || !com.opos.cmn.a.a.a()) {
            return com.opos.mobad.service.f.b().b();
        }
        com.opos.cmn.an.f.a.b("AdBaseFactory", "check result fail:" + this.f12319a.b);
        return false;
    }

    public com.opos.mobad.ad.a.a a(Activity activity, String str, com.opos.mobad.ad.a.b bVar) {
        return (com.opos.mobad.ad.a.a) a(new com.opos.mobad.f.b.b(activity, str, com.opos.mobad.service.f.b().i(), true, bVar));
    }

    public com.opos.mobad.ad.b.a a(Activity activity, String str, com.opos.mobad.ad.b.b bVar) {
        return (com.opos.mobad.ad.b.a) a(new com.opos.mobad.f.b.c(activity, str, com.opos.mobad.service.f.b().n(), bVar));
    }

    public com.opos.mobad.ad.b.c a(Activity activity, String str, com.opos.mobad.ad.b.d dVar) {
        return (com.opos.mobad.ad.b.c) a(new com.opos.mobad.f.b.d(activity, str, com.opos.mobad.service.f.b().p(), dVar));
    }

    protected com.opos.mobad.ad.b a(com.opos.mobad.f.b.a aVar) {
        com.opos.mobad.f.b.b bVar;
        e.b a2 = d() ? com.opos.mobad.service.f.b().a(aVar.f12442a, true) : null;
        if (a2 == null || a2.f13615a == null || a2.f13615a.size() <= 0) {
            return b(aVar);
        }
        if (aVar instanceof com.opos.mobad.f.b.b) {
            com.opos.mobad.f.b.b bVar2 = (com.opos.mobad.f.b.b) aVar;
            bVar = new com.opos.mobad.f.b.b((Activity) bVar2.d, aVar.f12442a, aVar.b, false, (com.opos.mobad.ad.a.b) bVar2.e);
        } else {
            bVar = aVar;
        }
        return a2.e != 1 ? a(bVar, a2.f13615a, a(a2.f13615a, aVar.f12442a, a2.f13616c), a2.d, a2.e) : a(bVar, a2.f13615a, a2.b, a2.f13616c, a2.d);
    }

    public c.a a() {
        return this.f12319a;
    }

    public com.opos.mobad.ad.c.c a(Context context, String str, int i, m mVar) {
        b bVar = this.b;
        com.opos.mobad.ad.c.c cVar = null;
        if (bVar == null) {
            return null;
        }
        com.opos.mobad.ad.c b = bVar.b(1);
        if (b != null) {
            if (!(b instanceof com.opos.mobad.f)) {
                return null;
            }
            cVar = ((com.opos.mobad.f) b).a(context, str, str, i, mVar);
        }
        return cVar;
    }

    public com.opos.mobad.ad.c.c a(Context context, String str, com.opos.mobad.ad.c.f fVar) {
        com.opos.mobad.ad.c b;
        b bVar = this.b;
        if (bVar == null || (b = bVar.b(1)) == null) {
            return null;
        }
        return b.a(context, str, str, fVar);
    }

    public com.opos.mobad.ad.c.g a(Context context, String str, j jVar) {
        return (com.opos.mobad.ad.c.g) a(new com.opos.mobad.f.b.e(context, str, com.opos.mobad.service.f.b().s(), jVar));
    }

    public n a(Context context, String str, s sVar, o oVar) {
        return (n) a(new com.opos.mobad.f.b.g(context, str, com.opos.mobad.service.f.b().u(), sVar, oVar));
    }

    public com.opos.mobad.ad.d.a a(Context context, String str, com.opos.mobad.ad.d.b bVar) {
        return (com.opos.mobad.ad.d.a) a(new i(context, str, com.opos.mobad.service.f.b().q(), bVar));
    }

    public com.opos.mobad.ad.e.a a(Context context, String str, com.opos.mobad.ad.e.c cVar, com.opos.mobad.ad.e.f fVar) {
        a(context);
        return new com.opos.mobad.f.a.c(context, str, fVar, cVar, this.b);
    }

    public com.opos.mobad.ad.e.b a(Activity activity, String str, com.opos.mobad.ad.e.c cVar, com.opos.mobad.ad.e.f fVar) {
        a(activity);
        return new com.opos.mobad.f.a.j(activity, str, fVar, cVar, this.b);
    }

    protected void a(Context context) {
        this.b.a(context.getApplicationContext(), com.opos.mobad.service.f.b(), this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Context context, Integer num, com.opos.mobad.ad.c cVar) {
        c.a a2 = this.b.a(context, num, cVar);
        if (a2.f11982a) {
            return;
        }
        this.f12319a = a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final Context context, final boolean z) {
        this.d = z;
        com.opos.mobad.service.f.b().a(new e.d() { // from class: com.opos.mobad.f.a.1
            @Override // com.opos.mobad.service.a.e.d
            public void a() {
                a.this.b.a(context, com.opos.mobad.service.f.b(), z);
            }
        });
        this.b.a(context, com.opos.mobad.service.f.b(), z);
    }

    public com.opos.mobad.ad.e.b b(Activity activity, String str, com.opos.mobad.ad.e.c cVar, com.opos.mobad.ad.e.f fVar) {
        a(activity);
        return new com.opos.mobad.f.a.j(activity, str, fVar, cVar, this.b);
    }

    public boolean b() {
        return this.b.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.b();
        }
    }
}
