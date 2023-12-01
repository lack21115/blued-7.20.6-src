package com.opos.mobad.interstitial.a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.n.a;
import com.opos.mobad.o.c.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/interstitial/a/m.class */
public class m implements com.opos.mobad.n.a {

    /* renamed from: a  reason: collision with root package name */
    private Activity f26243a;
    private a.InterfaceC0708a b;

    /* renamed from: c  reason: collision with root package name */
    private AdItemData f26244c;
    private MaterialData d;
    private com.opos.mobad.n.a e;
    private FrameLayout f;
    private com.opos.mobad.o.c.a g;
    private a.InterfaceC0721a h = new a.InterfaceC0721a() { // from class: com.opos.mobad.interstitial.a.m.1
        @Override // com.opos.mobad.o.c.a.InterfaceC0721a
        public void a_(View view, int[] iArr) {
            a.InterfaceC0708a interfaceC0708a = m.this.b;
            if (interfaceC0708a instanceof com.opos.mobad.q.a.e) {
                ((com.opos.mobad.q.a.e) interfaceC0708a).a_(view, iArr);
            }
        }
    };

    public m(Activity activity, AdItemData adItemData, com.opos.mobad.n.a aVar) {
        this.f26243a = activity;
        this.f = new FrameLayout(activity);
        this.f26244c = adItemData;
        this.d = adItemData.i().get(0);
        this.e = aVar;
    }

    private void a(MaterialData materialData) {
        if (materialData == null || materialData.ab() == null || materialData.ab().a() == null || TextUtils.isEmpty(materialData.ab().a().a())) {
            return;
        }
        com.opos.mobad.o.c.a aVar = this.g;
        if (aVar == null || this.f.indexOfChild(aVar.a()) < 0) {
            com.opos.cmn.an.f.a.b("InterstitialWidgetImpl", "add pendant");
            com.opos.mobad.o.c.a aVar2 = new com.opos.mobad.o.c.a(this.f26243a, this.h);
            this.g = aVar2;
            aVar2.a(new a.b(materialData.ab().a().a(), 75, 75));
            View a2 = this.g.a();
            a2.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f26243a, 75.0f), com.opos.cmn.an.h.f.a.a(this.f26243a, 75.0f));
            if (materialData.ab().c() == 0) {
                layoutParams.gravity = 5;
                if (com.opos.cmn.an.h.f.a.d(this.f26243a)) {
                    layoutParams.gravity |= 80;
                    layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f26243a, 16.0f);
                    layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f26243a, 140.0f);
                } else {
                    layoutParams.gravity |= 16;
                    layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f26243a, 37.0f);
                }
            } else {
                layoutParams.gravity = 3;
                if (com.opos.cmn.an.h.f.a.d(this.f26243a)) {
                    layoutParams.gravity = 48;
                    layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f26243a, 16.0f);
                    layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f26243a, 140.0f);
                } else {
                    layoutParams.gravity |= 16;
                    layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f26243a, 37.0f);
                }
            }
            this.f.addView(a2, layoutParams);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.b = interfaceC0708a;
        this.e.a(interfaceC0708a);
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.cmn.an.f.a.b("InterstitialWidgetImpl", "getRenderView ");
        if (this.f26244c == null || this.d == null) {
            return;
        }
        com.opos.mobad.n.a aVar = this.e;
        if (aVar == null) {
            com.opos.cmn.an.f.a.d("InterstitialWidgetImpl", "unknow creativeType, please check if your creativeType is video or template");
            a.InterfaceC0708a interfaceC0708a = this.b;
            if (interfaceC0708a != null) {
                interfaceC0708a.b(1);
                return;
            }
            return;
        }
        aVar.a(hVar);
        View c2 = this.e.c();
        if (this.f.indexOfChild(c2) < 0) {
            this.f.removeAllViews();
            this.f.addView(c2, new FrameLayout.LayoutParams(-1, -1));
            if (this.d.ac()) {
                a(this.d);
            }
        }
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.f;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        try {
            if (this.e != null) {
                this.e.d();
            }
            if (this.g != null) {
                this.g.b();
            }
            this.f.removeAllViews();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterstitialWidgetImpl", "", (Throwable) e);
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        com.opos.mobad.n.a aVar = this.e;
        if (aVar == null) {
            return 0;
        }
        return aVar.e();
    }
}
