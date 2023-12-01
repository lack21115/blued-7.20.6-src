package com.opos.mobad.q.a;

import android.content.Context;
import android.view.View;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.q.a.a;
import com.opos.mobad.q.a.j;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/m.class */
public abstract class m implements e {

    /* renamed from: a  reason: collision with root package name */
    private AdItemData f13541a;
    private MaterialData b;
    public final com.opos.mobad.q.a.a l;
    protected j m;
    protected l n;
    protected long o = -1;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/m$a.class */
    public interface a extends com.opos.mobad.ad.h, a.InterfaceC0554a, j.a {
    }

    public m(Context context, String str, com.opos.mobad.cmn.a.a aVar, b.InterfaceC0517b interfaceC0517b, final a aVar2) {
        this.l = new com.opos.mobad.q.a.a(context, str, aVar, interfaceC0517b, aVar2);
        this.m = new j(context, str, aVar2);
        this.n = new l(context, new com.opos.mobad.ad.h() { // from class: com.opos.mobad.q.a.m.1
            @Override // com.opos.mobad.ad.h
            public void a(Object... objArr) {
                m.this.a(aVar2, objArr);
            }
        });
    }

    private int a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 100) {
                        return i != 101 ? -1 : 10409;
                    }
                    return 10402;
                }
                return 10412;
            }
            return 10411;
        }
        return 10410;
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void a(int i, String str) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onError" + i);
        this.m.a(a(i), str);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void a(long j, long j2) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onComplete" + j);
        this.o = j2;
        this.m.a(j2);
        this.n.b(j);
    }

    public void a(View view) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onShow");
        this.l.a(view);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void a(View view, int[] iArr, boolean z) {
    }

    public void a(com.opos.mobad.ad.h hVar, Object... objArr) {
        if (hVar == null) {
            return;
        }
        hVar.a(objArr);
    }

    public void a(AdItemData adItemData, MaterialData materialData, int i) {
        a(adItemData, materialData, -1L, i, materialData.af());
    }

    public void a(AdItemData adItemData, MaterialData materialData, long j, int i) {
        a(adItemData, materialData, j, i, materialData.af());
    }

    public void a(AdItemData adItemData, MaterialData materialData, long j, int i, int i2) {
        this.f13541a = adItemData;
        this.b = materialData;
        this.o = -1L;
        this.l.a(adItemData, materialData, i, i2);
        this.m.a(adItemData, materialData, j, i);
        this.n.a(adItemData, materialData);
    }

    public boolean a(View view, int[] iArr, com.opos.mobad.cmn.a.b.a aVar) {
        return a(view, iArr, aVar, (a.c) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(View view, int[] iArr, com.opos.mobad.cmn.a.b.a aVar, a.c cVar) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onClick" + aVar);
        if (com.opos.mobad.cmn.a.b.g.a(this.f13541a, aVar)) {
            Map<String, String> map = null;
            long j = this.o;
            if (j > 0) {
                map = com.opos.mobad.cmn.a.b.d.a(j, this.b.u());
            }
            this.l.a(view, iArr, aVar, this.o, map, cVar);
            l lVar = this.n;
            if (lVar != null) {
                lVar.a();
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.opos.mobad.o.c.a.InterfaceC0551a
    public void a_(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.a.b.a.Pendant);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void b(int i) {
        this.l.a(i);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void b(long j, long j2) {
    }

    public void c() {
        this.l.b();
        this.m.a();
        this.n.e();
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void c(int i) {
        this.l.d(i);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void c(long j, long j2) {
    }

    public void d(int i) {
        this.l.b(i);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void d(long j, long j2) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onProcess =" + j + ",duration =" + j2);
        this.o = j;
        this.m.a(j, j2);
        this.n.a(j);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void d(View view, int[] iArr) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onCloseClick");
        this.l.a(false, iArr);
        this.m.a(view, iArr, this.o);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void e() {
        this.l.a();
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void e(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.a.b.a.Video);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void f(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.a.b.a.ClickBt);
    }

    public void g() {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onBackClick");
        this.l.a(true, (int[]) null);
        this.m.a((View) null, (int[]) null, this.o);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void g(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.a.b.a.NonClickBt);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void h(View view, int[] iArr) {
        l lVar = this.n;
        if (lVar != null) {
            lVar.c();
        }
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void i(View view, int[] iArr) {
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void j(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.a.b.a.FloatLayerNonClickBt);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void k(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.a.b.a.FloatLayerClickBt);
    }
}
