package com.opos.mobad.model.d;

import android.content.Context;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.opos.mobad.b.a.b;
import com.opos.mobad.b.a.x;
import com.opos.mobad.b.a.y;
import com.opos.mobad.model.d.m;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.CustomInfoData;
import com.opos.mobad.model.data.MaterialData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/a.class */
public abstract class a extends b {

    /* renamed from: a  reason: collision with root package name */
    protected i f12710a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f12711c;
    private boolean d;
    private o e;
    private com.opos.mobad.model.b.c f;
    private com.opos.mobad.model.b.d g;
    private AdData h;
    private Set<String> i;
    private Set<com.opos.mobad.model.b.e> j;
    private Set<com.opos.mobad.model.b.e> k;

    public a(Context context, String str, com.opos.mobad.model.b.c cVar, boolean z, i iVar, m.a aVar) {
        super(aVar);
        this.i = new HashSet();
        this.b = context;
        this.f12711c = str;
        this.f = cVar;
        this.d = z;
        this.f12710a = iVar;
        this.e = new j(context);
    }

    private AdData a(com.opos.mobad.model.b.c cVar, com.opos.mobad.model.b.d dVar, boolean z, q qVar, Set<com.opos.mobad.model.b.e> set, Set<com.opos.mobad.model.b.e> set2) {
        List<y> list;
        y yVar;
        try {
            if (dVar == null) {
                return new AdData(10001, "net response is null.");
            }
            if (dVar.f() != 0) {
                return new AdData(dVar.f(), dVar.g(), dVar.l(), dVar.m());
            }
            List<com.opos.mobad.b.a.b> h = dVar.h();
            if (h != null && h.size() > 0) {
                if (dVar.i() <= System.currentTimeMillis()) {
                    return new AdData(GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR, com.opos.mobad.ad.a.a(GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR), dVar.l(), dVar.m());
                }
                ArrayList arrayList = new ArrayList();
                int max = Math.max(1, dVar.e());
                CustomInfoData customInfoData = new CustomInfoData(dVar.r());
                int i = 0;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= h.size() || i >= max) {
                        break;
                    }
                    com.opos.mobad.b.a.b bVar = h.get(i3);
                    if (bVar != null && (list = bVar.A) != null && list.size() > 0 && (yVar = list.get(0)) != null && a(cVar.e(), bVar, yVar, false, qVar)) {
                        this.i.add(yVar.aU);
                        qVar.a(yVar, bVar.D);
                        AdItemData adItemData = new AdItemData(bVar, d.a(this.b, yVar, set, set2, z, qVar), d.a(this.b, bVar, set, z, qVar), dVar.k(), dVar.i(), dVar.j(), cVar.a(), customInfoData, cVar.e(), cVar.i(), dVar.s());
                        if (dVar.a()) {
                            adItemData.H();
                        }
                        arrayList.add(adItemData);
                        i++;
                    }
                    i2 = i3 + 1;
                }
                if (arrayList.size() <= 0) {
                    return new AdData(10004, "adItemList is null.", dVar.l(), dVar.m());
                }
                AdData adData = new AdData(dVar.f(), dVar.g(), dVar.l(), dVar.m());
                adData.a(dVar.i());
                adData.a(dVar.o());
                adData.d(dVar.n());
                adData.a(arrayList);
                adData.b(10000);
                adData.a("ok.");
                return adData;
            }
            return new AdData(10002, "response ad list is null.", dVar.l(), dVar.m());
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ALoader", "", (Throwable) e);
            return new AdData(-1, "unknown error.");
        }
    }

    private void a(List<AdItemData> list) {
        MaterialData materialData;
        com.opos.cmn.an.f.a.b("ALoader", "prepare web" + list);
        if (list == null || list.size() <= 0) {
            return;
        }
        for (AdItemData adItemData : list) {
            List<MaterialData> i = adItemData.i();
            if (i != null && i.size() > 0 && (materialData = i.get(0)) != null) {
                u.a(this.b, materialData.i, materialData.h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, com.opos.mobad.b.a.b bVar, y yVar, boolean z, q qVar) {
        if (d.a(this.b, yVar, qVar)) {
            if (b(yVar)) {
                if (d.b(yVar) && !com.opos.mobad.cmn.a.b.h.a(this.b)) {
                    if (qVar != null) {
                        qVar.c(yVar);
                        return false;
                    }
                    return false;
                } else if (d.a(yVar)) {
                    List<x> list = yVar.aq;
                    if (list == null || list.size() <= 0) {
                        if (qVar != null) {
                            qVar.d(yVar);
                            return false;
                        }
                        return false;
                    } else if ((i == 3 || i == 6) && bVar.M != null && b.c.PLAY_CACHE.a() != bVar.M.a()) {
                        if (qVar != null) {
                            qVar.f(yVar);
                            return false;
                        }
                        return false;
                    } else if (d.a(this.b, bVar, list)) {
                        return true;
                    } else {
                        if (qVar != null) {
                            qVar.e(yVar);
                        }
                        if (z) {
                            return z;
                        }
                        a(yVar);
                        return z;
                    }
                } else if (yVar.V != null && yVar.V.size() > 0) {
                    return true;
                } else {
                    if (yVar.S != null && yVar.S.size() > 0) {
                        return true;
                    }
                    if (yVar.ba != null && yVar.ba.size() > 0) {
                        return true;
                    }
                    if (qVar == null) {
                        return false;
                    }
                }
            } else if (qVar == null) {
                return false;
            }
            qVar.b(yVar);
            return false;
        }
        return false;
    }

    private boolean a(final i iVar) {
        Set<com.opos.mobad.model.b.e> set = this.k;
        if (set == null || set.size() <= 0) {
            return false;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.e.a(a.this.k, null);
                i iVar2 = iVar;
                if (iVar2 != null) {
                    iVar2.e();
                    iVar.b(a.this.b);
                }
            }
        });
        return true;
    }

    private static boolean b(y yVar) {
        String str;
        if (!c(yVar) || yVar.ax != y.c.DOWNLOADER) {
            str = "is not downloader mat";
        } else if (yVar.ax != y.c.DOWNLOADER) {
            com.opos.cmn.an.f.a.b("ALoader", "is invalid downloader mat");
            return false;
        } else {
            str = "is downloader mat";
        }
        com.opos.cmn.an.f.a.b("ALoader", str);
        return true;
    }

    private static boolean c(y yVar) {
        return yVar.R == y.h.DOWNLOAD || yVar.au == y.h.DOWNLOAD || yVar.av == y.h.DOWNLOAD || yVar.aI == y.h.DOWNLOAD || yVar.aJ == y.h.DOWNLOAD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (!a(this.f12710a)) {
            this.f12710a.b(this.b);
        }
        c(this.h);
    }

    @Override // com.opos.mobad.model.d.b
    public void a() {
        Set<com.opos.mobad.model.b.e> set = this.j;
        if (set != null && set.size() > 0) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    boolean a2 = (a.this.j == null || a.this.j.size() <= 0) ? true : a.this.e.a(a.this.j, a.this.f12710a, new CustomInfoData(a.this.g.r()));
                    a.this.f12710a.d();
                    if (a2) {
                        a.this.k();
                        return;
                    }
                    AdData adData = new AdData(10011, "download material failed", a.this.h.g(), a.this.h.c());
                    a.this.f12710a.a(a.this.b, adData.d());
                    a.this.b(adData);
                }
            });
            return;
        }
        com.opos.cmn.an.f.a.b("ALoader", "resource available");
        this.f12710a.d();
        k();
    }

    protected abstract void a(y yVar);

    protected abstract void a(com.opos.mobad.model.b.c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(final com.opos.mobad.model.b.d dVar) {
        this.f12710a.b();
        final HashSet hashSet = new HashSet();
        final HashSet hashSet2 = new HashSet();
        final AdData a2 = a(this.f, dVar, !this.d, this.f12710a, hashSet, hashSet2);
        this.f12710a.c();
        com.opos.cmn.an.f.a.b("ALoader", "load data:" + a2);
        if (a2 == null || a2.d() != 10000) {
            this.f12710a.a(this.b, a2 != null ? a2.d() : -1);
            a(a2);
            return;
        }
        a(new Callable<Boolean>() { // from class: com.opos.mobad.model.d.a.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                a.this.j = hashSet;
                a.this.k = hashSet2;
                a.this.h = a2;
                a.this.g = dVar;
                return true;
            }
        });
        if (j() == 8) {
            this.f12710a.a(this.b);
        }
    }

    public void a(final boolean z) {
        final List<com.opos.mobad.b.a.b> h;
        com.opos.cmn.an.f.a.b("ALoader", this + ",cache:" + z);
        com.opos.mobad.model.b.d dVar = this.g;
        if (dVar != null && (h = dVar.h()) != null && h.size() > 0 && this.g.b() > 0) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.a.4
                @Override // java.lang.Runnable
                public void run() {
                    y yVar;
                    com.opos.cmn.an.f.a.b("ALoader", "cache list");
                    ArrayList arrayList = new ArrayList();
                    for (com.opos.mobad.b.a.b bVar : h) {
                        if (bVar.A != null && bVar.A.size() > 0 && (yVar = bVar.A.get(0)) != null && (!z || !a.this.i.contains(yVar.aU))) {
                            a aVar = a.this;
                            if (aVar.a(aVar.f.e(), bVar, yVar, true, null)) {
                                arrayList.add(bVar);
                                if (arrayList.size() >= a.this.g.b()) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                    c.a(a.this.b).a(a.this.f12711c, a.this.g, arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.mobad.model.d.b
    public void b() {
        if (j() != 3) {
            return;
        }
        this.f12710a.a(this.b);
    }

    public void c() {
        AdData adData;
        if (j() != 6 || (adData = this.h) == null) {
            return;
        }
        a(adData.f());
    }

    public boolean d() {
        StringBuilder sb = new StringBuilder();
        sb.append("resource size:");
        Set<com.opos.mobad.model.b.e> set = this.j;
        boolean z = false;
        sb.append(set == null ? 0 : set.size());
        com.opos.cmn.an.f.a.b("ALoader", sb.toString());
        Set<com.opos.mobad.model.b.e> set2 = this.j;
        if (set2 == null || set2.size() <= 0) {
            z = true;
        }
        return z;
    }

    @Override // com.opos.mobad.model.d.b
    protected void e() {
        a(this.f);
    }
}
