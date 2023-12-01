package com.opos.mobad.h.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.heytap.msp.mobad.api.params.INativeTempletAdView;
import com.opos.mobad.ad.c.o;
import com.opos.mobad.ad.c.p;
import com.opos.mobad.ad.g;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.m;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/b/e.class */
public class e extends g.a implements p {

    /* renamed from: a  reason: collision with root package name */
    private Context f12493a;
    private a.C0537a b;

    /* renamed from: c  reason: collision with root package name */
    private f f12494c;
    private com.opos.mobad.n.a d;
    private o e;
    private a.b f;
    private com.opos.mobad.ad.privacy.b g;
    private Object h;
    private b.InterfaceC0517b i = new b.InterfaceC0517b() { // from class: com.opos.mobad.h.b.e.1
        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0517b
        public void a(AdItemData adItemData, String str) {
            com.opos.cmn.an.f.a.b(INativeTempletAdView.TAG, "notifyInstallCompletedEvent:" + str);
            e.this.a(str);
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0517b
        public void b(AdItemData adItemData, String str) {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0517b
        public void c(AdItemData adItemData, String str) {
        }
    };
    private m.a j = new m.a() { // from class: com.opos.mobad.h.b.e.2
        @Override // com.opos.mobad.cmn.a.a.a.b
        public void a(int i, String str) {
            if (e.this.e != null) {
                e.this.e.a(f.a(i), e.this);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j) {
            e.this.e.a(e.this);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            if (e.this.e != null) {
                e.this.e.b(e.this);
            }
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b() {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(long j) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(String str) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void c() {
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void d() {
            e.this.d.d();
            if (e.this.e != null) {
                e.this.e.c(e.this);
            }
        }

        @Override // com.opos.mobad.q.a.a.InterfaceC0554a
        public void j_() {
            if (e.this.e != null) {
                e.this.e.d(e.this);
            }
        }
    };

    public e(Context context, a.C0537a c0537a, String str, com.opos.mobad.cmn.a.a aVar, com.opos.mobad.n.a aVar2, o oVar, com.opos.mobad.cmn.b.c cVar) {
        this.f12493a = context;
        this.b = c0537a;
        this.d = aVar2;
        this.e = oVar;
        this.g = new com.opos.mobad.cmn.b.e(cVar);
        this.f12494c = new f(context, c0537a, str, aVar, new com.opos.mobad.o.a.a(this.f12493a, null), aVar2, this.i, this.j, this.g);
        a.b a2 = com.opos.mobad.cmn.a.b.f.a(context, aVar2.c());
        this.f = a2;
        aVar.a(a2);
    }

    @Override // com.opos.mobad.ad.c.p
    public View a() {
        View c2 = this.d.c();
        if (c2 != null && Build.VERSION.SDK_INT >= 29) {
            c2.setForceDarkAllowed(false);
            com.opos.cmn.an.f.a.b(INativeTempletAdView.TAG, "get Ad view set force");
        }
        return c2;
    }

    @Override // com.opos.mobad.ad.c.p
    public void a(Object obj) {
        this.h = obj;
    }

    public void a(String str) {
        com.opos.cmn.an.f.a.b(INativeTempletAdView.TAG, "notifyInstallCompletedEvent pkgname =" + str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.b.f12795c.k()) || !this.b.f12795c.k().equals(str)) {
            return;
        }
        this.f12494c.a(str);
    }

    @Override // com.opos.mobad.ad.c.p
    public void b() {
        this.f12494c.a();
    }

    @Override // com.opos.mobad.ad.c.p
    public void c() {
        this.d.d();
        this.f12494c.c();
        a.b bVar = this.f;
        if (bVar != null) {
            bVar.a();
        }
        this.g.a();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i) {
        this.f12494c.d(i);
    }

    @Override // com.opos.mobad.ad.c.p
    public Object d() {
        return this.h;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int f() {
        return this.b.b.X();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        return this.b.b.Y();
    }
}
