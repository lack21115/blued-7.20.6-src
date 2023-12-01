package com.opos.mobad.interstitial.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.opos.mobad.n.a;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/interstitial/a/i.class */
public class i extends c {
    private l k;
    private Bitmap l;

    public i(Activity activity, int i, a.InterfaceC0708a interfaceC0708a) {
        super(activity, i, interfaceC0708a);
        this.l = null;
    }

    @Override // com.opos.mobad.interstitial.a.c, com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        super.a(hVar);
        com.opos.mobad.n.d.d a2 = hVar != null ? hVar.a() : null;
        if (a2 == null) {
            com.opos.cmn.an.f.a.b("ImgInterstitial", "render with data null");
            return;
        }
        a(a2, this.h);
        a(false, a2.o);
        a(a2);
        a(this.f);
        b((View) this.h);
        a(a2.o);
        List<com.opos.mobad.n.d.g> list = a2.g;
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(list.get(0).f26633a)) {
            return;
        }
        Bitmap a3 = com.opos.mobad.cmn.a.b.g.a(list.get(0).f26633a, com.opos.cmn.an.h.f.a.a(this.f26227a, 240.0f), com.opos.cmn.an.h.f.a.a(this.f26227a, 200.0f));
        this.l = a3;
        if (a3 != null) {
            this.k.setImageBitmap(a3);
        }
    }

    public void c(RelativeLayout relativeLayout) {
        l lVar = new l(this.f26227a, 14.0f);
        this.k = lVar;
        lVar.setId(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f26227a, 240.0f), com.opos.cmn.an.h.f.a.a(this.f26227a, 200.0f));
        layoutParams.addRule(10);
        relativeLayout.addView(this.k, layoutParams);
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        try {
            if (this.l == null || this.l.isRecycled()) {
                return;
            }
            this.l.recycle();
            this.l = null;
            com.opos.cmn.an.f.a.b("ImgInterstitial", "mImgBitmap.recycle()");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("ImgInterstitial", "");
        }
    }

    @Override // com.opos.mobad.interstitial.a.c
    public void f() {
        c(this.h);
        a(this.h);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f26227a, 240.0f), com.opos.cmn.an.h.f.a.a(this.f26227a, 234.0f));
        layoutParams.addRule(13);
        this.g.addView(this.h, layoutParams);
    }
}
