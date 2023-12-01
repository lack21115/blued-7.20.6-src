package com.opos.mobad.h.b;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.ad.c.h;
import com.opos.mobad.ad.c.i;
import com.opos.mobad.ad.c.k;
import com.opos.mobad.ad.g;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.AppPrivacyData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/b/c.class */
public class c extends g.a implements h {

    /* renamed from: a  reason: collision with root package name */
    private AdItemData f12477a;
    private MaterialData b;

    /* renamed from: c  reason: collision with root package name */
    private List<com.opos.mobad.ad.c.e> f12478c = null;
    private List<com.opos.mobad.ad.c.e> d = null;
    private final long e = SystemClock.elapsedRealtime();
    private Context f;
    private d g;
    private com.opos.mobad.ad.c.b h;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/b/c$a.class */
    static class a implements com.opos.mobad.ad.c.b {

        /* renamed from: a  reason: collision with root package name */
        private AppPrivacyData f12479a;

        public a(AppPrivacyData appPrivacyData) {
            this.f12479a = appPrivacyData;
        }

        @Override // com.opos.mobad.ad.c.b
        public String a() {
            AppPrivacyData appPrivacyData = this.f12479a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.d;
        }

        @Override // com.opos.mobad.ad.c.b
        public String b() {
            AppPrivacyData appPrivacyData = this.f12479a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.f12781c;
        }
    }

    public c(com.opos.mobad.cmn.a.a aVar, AdItemData adItemData, Context context, String str, com.opos.mobad.ad.privacy.b bVar) {
        this.f12477a = adItemData;
        this.f = context.getApplicationContext();
        this.b = adItemData.i().get(0);
        this.g = new d(context, aVar, adItemData, str, bVar);
        if (this.f12477a.O() != null) {
            this.h = new a(this.f12477a.O());
        }
    }

    @Override // com.opos.mobad.ad.c.h
    public String a() {
        return this.b.h();
    }

    @Override // com.opos.mobad.ad.c.h
    public void a(Context context, FrameLayout frameLayout, k kVar) {
        com.opos.cmn.an.f.a.b("NativeAdvanceData", "bindMediaView nativeMediaView: " + frameLayout + ",listener: " + kVar);
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(frameLayout, kVar);
        }
    }

    @Override // com.opos.mobad.ad.c.h
    public void a(Context context, FrameLayout frameLayout, List<View> list) {
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(context, frameLayout, list);
        }
    }

    @Override // com.opos.mobad.ad.c.h
    public void a(Context context, List<View> list, h.a aVar, List<View> list2, h.a aVar2) {
        d dVar = this.g;
        if (dVar == null) {
            return;
        }
        dVar.a(context, list, aVar, list2, aVar2);
    }

    @Override // com.opos.mobad.ad.c.h
    public void a(i iVar) {
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(iVar);
        }
    }

    @Override // com.opos.mobad.ad.c.h
    public String b() {
        return this.b.i();
    }

    @Override // com.opos.mobad.ad.c.h
    public List<com.opos.mobad.ad.c.e> c() {
        List<MaterialData> i;
        List<MaterialFileData> j;
        if (this.f12478c == null && (i = this.f12477a.i()) != null && i.size() > 0) {
            for (MaterialData materialData : i) {
                if (materialData != null && (j = materialData.j()) != null && j.size() > 0) {
                    this.f12478c = new ArrayList();
                    for (MaterialFileData materialFileData : j) {
                        if (materialFileData != null) {
                            this.f12478c.add(new b(materialFileData));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getIconFiles =");
        List<com.opos.mobad.ad.c.e> list = this.f12478c;
        sb.append(list != null ? Integer.valueOf(list.size()) : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("NativeAdvanceData", sb.toString());
        return this.f12478c;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i) {
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(i);
        }
    }

    @Override // com.opos.mobad.ad.c.h
    public List<com.opos.mobad.ad.c.e> d() {
        List<MaterialData> i;
        List<MaterialFileData> f;
        if (this.d == null && (i = this.f12477a.i()) != null && i.size() > 0) {
            for (MaterialData materialData : i) {
                if (materialData != null && materialData.d() != 13 && (f = materialData.f()) != null && f.size() > 0) {
                    this.d = new ArrayList();
                    for (MaterialFileData materialFileData : f) {
                        if (materialFileData != null) {
                            this.d.add(new b(materialFileData));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getImgFiles =");
        List<com.opos.mobad.ad.c.e> list = this.d;
        sb.append(list != null ? Integer.valueOf(list.size()) : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("NativeAdvanceData", sb.toString());
        return this.d;
    }

    @Override // com.opos.mobad.ad.c.h
    public int e() {
        return this.b.d();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int f() {
        return this.f12477a.X();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        return this.f12477a.Y();
    }

    @Override // com.opos.mobad.ad.c.h
    public int h() {
        return (int) this.b.u();
    }

    @Override // com.opos.mobad.ad.c.h
    public com.opos.mobad.ad.c.e i() {
        MaterialFileData l = this.f12477a.l();
        b bVar = l != null ? new b(l) : null;
        StringBuilder sb = new StringBuilder();
        sb.append("getLogoFile=");
        sb.append(bVar != null ? bVar : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("NativeAdvanceData", sb.toString());
        return bVar;
    }

    @Override // com.opos.mobad.ad.c.h
    public boolean j() {
        return SystemClock.elapsedRealtime() - this.e <= ((long) ((this.f12477a.p() * 60) * 1000));
    }

    @Override // com.opos.mobad.ad.c.h
    public String k() {
        return this.f12477a.n();
    }

    @Override // com.opos.mobad.ad.c.h
    public String l() {
        String a2 = com.opos.mobad.cmn.a.b.g.a(this.f, this.f12477a, false);
        com.opos.cmn.an.f.a.b("NativeAdvanceData", "getClickBnText=" + a2);
        return a2;
    }

    @Override // com.opos.mobad.ad.c.h
    public void m() {
        com.opos.cmn.an.f.a.b("NativeAdvanceData", "release");
        d dVar = this.g;
        if (dVar != null) {
            dVar.a();
            this.g = null;
        }
    }

    @Override // com.opos.mobad.ad.c.h
    public com.opos.mobad.ad.c.b n() {
        return this.h;
    }
}
