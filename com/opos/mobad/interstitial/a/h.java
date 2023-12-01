package com.opos.mobad.interstitial.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/interstitial/a/h.class */
public class h extends c {
    private com.opos.cmn.e.a.a.c k;
    private TextView l;
    private TextView m;
    private Bitmap n;

    public h(Activity activity, int i, a.InterfaceC0708a interfaceC0708a) {
        super(activity, i, interfaceC0708a);
        this.n = null;
    }

    private void c(RelativeLayout relativeLayout) {
        l lVar = new l(this.f26227a, 14.0f);
        lVar.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.f26227a, "opos_module_biz_ui_interstitial_icon_rl_bg_img.jpg"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f26227a, 240.0f), com.opos.cmn.an.h.f.a.a(this.f26227a, 95.0f));
        layoutParams.addRule(10);
        relativeLayout.addView(lVar, layoutParams);
    }

    private void d(RelativeLayout relativeLayout) {
        this.k = new com.opos.cmn.e.a.a.c(this.f26227a, 20.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f26227a, 60.0f), com.opos.cmn.an.h.f.a.a(this.f26227a, 60.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(10);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f26227a, 19.0f);
        relativeLayout.addView(this.k, layoutParams);
    }

    private void e(RelativeLayout relativeLayout) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f26227a);
        com.opos.mobad.cmn.a.b.g.a(relativeLayout2, com.opos.cmn.an.d.a.a.c(this.f26227a, "opos_module_biz_ui_interstitial_text_rl_bg_img.png"));
        f(relativeLayout2);
        g(relativeLayout2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f26227a, 240.0f), com.opos.cmn.an.h.f.a.a(this.f26227a, 120.0f));
        layoutParams.addRule(2, 3);
        relativeLayout.addView(relativeLayout2, layoutParams);
    }

    private void f(RelativeLayout relativeLayout) {
        TextView textView = new TextView(this.f26227a);
        this.l = textView;
        textView.setGravity(17);
        this.l.setTextColor(Color.parseColor("#2f2f2f"));
        this.l.setTextSize(1, 17.0f);
        this.l.setTypeface(Typeface.defaultFromStyle(1));
        this.l.setMaxEms(9);
        this.l.setEllipsize(TextUtils.TruncateAt.END);
        this.l.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(10);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f26227a, 39.0f);
        relativeLayout.addView(this.l, layoutParams);
    }

    private void g(RelativeLayout relativeLayout) {
        TextView textView = new TextView(this.f26227a);
        this.m = textView;
        textView.setGravity(17);
        this.m.setTextColor(Color.parseColor("#8f8f8f"));
        this.m.setTextSize(1, 14.0f);
        this.m.setMaxEms(13);
        this.m.setEllipsize(TextUtils.TruncateAt.END);
        this.m.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f26227a, 35.0f);
        relativeLayout.addView(this.m, layoutParams);
    }

    @Override // com.opos.mobad.interstitial.a.c, com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        super.a(hVar);
        com.opos.mobad.n.d.d a2 = hVar != null ? hVar.a() : null;
        if (a2 == null) {
            com.opos.cmn.an.f.a.b("GraphicMixInterstitial", "render with data null");
            return;
        }
        a(a2, this.h);
        a(true, a2.o);
        a(a2);
        a(this.f);
        b((View) this.h);
        a(a2.o);
        if (a2.m != null) {
            String str = a2.m.f26633a;
            if (!TextUtils.isEmpty(str)) {
                Bitmap a3 = com.opos.mobad.cmn.a.b.g.a(str, com.opos.cmn.an.h.f.a.a(this.f26227a, 60.0f), com.opos.cmn.an.h.f.a.a(this.f26227a, 60.0f));
                this.n = a3;
                if (a3 != null) {
                    this.k.setImageBitmap(a3);
                }
            }
        }
        a(this.l, a2.f);
        a(this.m, a2.e);
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        try {
            if (this.n != null && !this.n.isRecycled()) {
                this.n.recycle();
                this.n = null;
                com.opos.cmn.an.f.a.b("GraphicMixInterstitial", "mIconBitmap.recycle()");
            }
            a(this.l, "");
            a(this.m, "");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("GraphicMixInterstitial", "");
        }
    }

    @Override // com.opos.mobad.interstitial.a.c
    public void f() {
        c(this.h);
        d(this.h);
        a(this.h);
        e(this.h);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f26227a, 240.0f), com.opos.cmn.an.h.f.a.a(this.f26227a, 234.0f));
        layoutParams.addRule(13);
        this.g.addView(this.h, layoutParams);
    }
}
