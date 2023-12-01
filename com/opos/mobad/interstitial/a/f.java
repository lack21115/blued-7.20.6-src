package com.opos.mobad.interstitial.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.n.a;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/interstitial/a/f.class */
public class f extends b {
    private com.opos.cmn.e.a.a.c m;
    private Bitmap n;

    public f(Context context, int i, a.InterfaceC0708a interfaceC0708a) {
        super(context, i, interfaceC0708a);
        this.n = null;
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(3, 3);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 18.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.k, 14.0f);
        a(dVar, this.d, layoutParams);
    }

    private void h() {
        this.i = new TextView(this.k);
        this.i.setTextColor(Color.parseColor("#2f2f2f"));
        this.i.setTextSize(1, 20.0f);
        this.i.setMaxEms(7);
        this.i.setEllipsize(TextUtils.TruncateAt.END);
        this.i.setMaxLines(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.addRule(0, 2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 28.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.k, 14.0f);
        this.d.addView(this.i, layoutParams);
    }

    private void i() {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.k, 14.0f);
        this.m = cVar;
        cVar.setId(2);
        this.m.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 107.0f), com.opos.cmn.an.h.f.a.a(this.k, 70.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 17.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.k, 14.0f);
        this.d.addView(this.m, layoutParams);
    }

    private void j() {
        ImageView imageView = new ImageView(this.k);
        imageView.setId(3);
        imageView.setImageDrawable(new ColorDrawable(Color.parseColor("#cdd2d4")));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 266.0f), com.opos.cmn.an.h.f.a.a(this.k, 1.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 100.0f);
        layoutParams.addRule(14);
        this.d.addView(imageView, layoutParams);
    }

    private void k() {
        this.j = new com.opos.cmn.e.a.a.a(this.k, "opos_module_biz_ui_cmn_click_bn_normal_red_bg_img.png", "opos_module_biz_ui_cmn_click_bn_pressed_red_bg_img.png");
        this.j.setGravity(17);
        this.j.setTextColor(-1);
        this.j.setTextSize(1, 12.0f);
        this.j.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 107.0f), com.opos.cmn.an.h.f.a.a(this.k, 28.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(3, 3);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 13.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.k, 14.0f);
        this.d.addView(this.j, layoutParams);
    }

    private void l() {
        this.h = new TextView(this.k);
        this.h.setGravity(17);
        this.h.setTextColor(Color.parseColor("#999999"));
        this.h.setTextSize(1, 11.0f);
        this.h.setMaxEms(7);
        this.h.setEllipsize(TextUtils.TruncateAt.END);
        this.h.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, 5);
        layoutParams.addRule(3, 3);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, 18.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.k, 10.0f);
        this.d.addView(this.h, layoutParams);
    }

    private void m() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 294.0f), com.opos.cmn.an.h.f.a.a(this.k, 156.0f));
        layoutParams.addRule(13);
        a(layoutParams);
    }

    private void n() {
        b(new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 318.0f), com.opos.cmn.an.h.f.a.a(this.k, 180.0f)));
    }

    @Override // com.opos.mobad.interstitial.a.b, com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        super.a(hVar);
        com.opos.mobad.n.d.d a2 = hVar != null ? hVar.a() : null;
        if (a2 == null) {
            com.opos.cmn.an.f.a.b("GM320X210Interstitial", "render with data null");
            return;
        }
        b(a2);
        n();
        a(this.i, a2.e);
        a(a2);
        a(this.j);
        b(this.d);
        a(this.h, a2.f);
        a(a2.o);
        List<com.opos.mobad.n.d.g> list = a2.g;
        if (list == null || list.size() <= 0 || list.get(0) == null || TextUtils.isEmpty(list.get(0).f26633a)) {
            return;
        }
        Bitmap a3 = com.opos.mobad.cmn.a.b.g.a(list.get(0).f26633a, com.opos.cmn.an.h.f.a.a(this.k, 107.0f), com.opos.cmn.an.h.f.a.a(this.k, 70.0f));
        this.n = a3;
        if (a3 != null) {
            this.m.setImageBitmap(a3);
        }
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        try {
            if (this.n != null && !this.n.isRecycled()) {
                this.n.recycle();
                this.n = null;
                com.opos.cmn.an.f.a.b("GM320X210Interstitial", "mAdBitmap.recycle()");
            }
            a(this.h, "");
            a(this.i, "");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("GM320X210Interstitial", "");
        }
    }

    @Override // com.opos.mobad.interstitial.a.b
    public void f() {
        i();
        h();
        j();
        k();
        l();
        m();
    }
}
