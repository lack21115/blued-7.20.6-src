package com.opos.mobad.interstitial.a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.opos.mobad.activity.webview.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.n.a;
import com.opos.mobad.o.c.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/interstitial/a/k.class */
public class k implements com.opos.mobad.n.a, com.opos.mobad.q.a.f {

    /* renamed from: a  reason: collision with root package name */
    private Activity f12549a;
    private a.InterfaceC0538a b;

    /* renamed from: c  reason: collision with root package name */
    private AdItemData f12550c;
    private MaterialData d;
    private com.opos.mobad.n.a e;
    private com.opos.mobad.o.c.a f;
    private com.opos.mobad.n.f.a g;
    private com.opos.mobad.activity.webview.b h;
    private a.InterfaceC0551a i = new a.InterfaceC0551a() { // from class: com.opos.mobad.interstitial.a.k.1
        @Override // com.opos.mobad.o.c.a.InterfaceC0551a
        public void a_(View view, int[] iArr) {
            a.InterfaceC0538a interfaceC0538a = k.this.b;
            if (interfaceC0538a instanceof com.opos.mobad.q.a.e) {
                ((com.opos.mobad.q.a.e) interfaceC0538a).a_(view, iArr);
            }
        }
    };

    public k(Activity activity, AdItemData adItemData, com.opos.mobad.activity.webview.b bVar, com.opos.mobad.n.a aVar) {
        this.f12549a = activity;
        this.f12550c = adItemData;
        MaterialData materialData = adItemData.i().get(0);
        this.d = materialData;
        this.g = b(materialData);
        this.e = aVar;
        if (aVar != null) {
            aVar.a(this.b);
            this.g.a(this.e.c());
        }
        this.h = bVar;
        if (bVar != null) {
            bVar.a(new b.a() { // from class: com.opos.mobad.interstitial.a.k.2
                @Override // com.opos.mobad.activity.webview.b.a
                public void a() {
                    if (k.this.b != null) {
                        k.this.b.d((View) null, (int[]) null);
                    }
                }
            });
        }
    }

    private void a(MaterialData materialData) {
        if (materialData == null || materialData.ab() == null || materialData.ab().a() == null || TextUtils.isEmpty(materialData.ab().a().a())) {
            return;
        }
        if (this.f != null && this.g.a().indexOfChild(this.f.a()) >= 0) {
            this.f.a().setVisibility(0);
            return;
        }
        com.opos.cmn.an.f.a.b("InterstitialNewTemplate", "add pendant");
        com.opos.mobad.o.c.a aVar = new com.opos.mobad.o.c.a(this.f12549a, this.i);
        this.f = aVar;
        aVar.a(new a.b(materialData.ab().a().a(), 75, 75));
        View a2 = this.f.a();
        a2.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f12549a, 75.0f), com.opos.cmn.an.h.f.a.a(this.f12549a, 75.0f));
        if (materialData.ab().c() == 0) {
            layoutParams.addRule(11);
            if (com.opos.cmn.an.h.f.a.d(this.f12549a)) {
                layoutParams.addRule(12);
                layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f12549a, 16.0f);
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f12549a, 140.0f);
            } else {
                layoutParams.addRule(15);
                layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f12549a, 37.0f);
            }
        } else {
            layoutParams.addRule(9);
            if (com.opos.cmn.an.h.f.a.d(this.f12549a)) {
                layoutParams.addRule(10);
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f12549a, 16.0f);
                layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f12549a, 140.0f);
            } else {
                layoutParams.addRule(15);
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f12549a, 37.0f);
            }
        }
        this.g.a().addView(a2, layoutParams);
    }

    private com.opos.mobad.n.f.a b(MaterialData materialData) {
        switch (materialData.b()) {
            case 5:
            case 7:
            case 8:
            case 9:
                return com.opos.mobad.n.f.l.a(this.f12549a.getApplicationContext(), 0, false);
            case 6:
            case 10:
            case 11:
            default:
                return com.opos.mobad.n.f.l.a(this.f12549a.getApplicationContext(), 1, false);
            case 12:
            case 14:
                return com.opos.mobad.n.f.l.a(this.f12549a.getApplicationContext(), 0, true);
            case 13:
            case 15:
                return com.opos.mobad.n.f.l.a(this.f12549a.getApplicationContext(), 1, true);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        com.opos.mobad.n.a aVar = this.e;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.b = interfaceC0538a;
        com.opos.mobad.n.a aVar = this.e;
        if (aVar != null) {
            aVar.a(interfaceC0538a);
        }
        this.g.a(interfaceC0538a);
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.cmn.an.f.a.b("InterstitialNewTemplate", "render ");
        if (hVar != null) {
            if (this.e != null) {
                this.g.a(hVar);
                this.e.a(hVar);
                if (this.d.ac()) {
                    a(this.d);
                    return;
                }
                return;
            }
            com.opos.cmn.an.f.a.d("InterstitialNewTemplate", "unknow creativeType, please check if your creativeType is video or template");
            a.InterfaceC0538a interfaceC0538a = this.b;
            if (interfaceC0538a != null) {
                interfaceC0538a.b(1);
            }
        }
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        com.opos.mobad.n.a aVar = this.e;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.g.a();
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        try {
            if (this.e != null) {
                this.e.d();
            }
            if (this.f != null) {
                this.f.b();
            }
            if (this.h != null) {
                this.h.d();
            }
            this.g.a().removeAllViews();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterstitialNewTemplate", "", (Throwable) e);
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        com.opos.mobad.n.a aVar = this.e;
        if (aVar != null) {
            return aVar.e();
        }
        return 0;
    }

    @Override // com.opos.mobad.q.a.f
    public void f() {
        if (this.h == null) {
            return;
        }
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.interstitial.a.k.3
            @Override // java.lang.Runnable
            public void run() {
                k.this.h.a();
                k.this.g.b(k.this.h.c());
                k.this.g.b();
                k.this.a();
            }
        });
    }
}
