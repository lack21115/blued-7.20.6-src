package com.opos.mobad.interstitial.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.n.a;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/interstitial/a/g.class */
public class g extends b {
    private ImageView m;
    private Bitmap n;
    private RelativeLayout o;

    public g(Context context, int i, a.InterfaceC0708a interfaceC0708a) {
        super(context, i, interfaceC0708a);
        this.n = null;
    }

    private int b(com.opos.mobad.n.d.d dVar) {
        return dVar.p != 0 ? 135 : 120;
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.k, 14.0f);
        a(dVar, this.o, layoutParams);
    }

    private void h() {
        this.o = new RelativeLayout(this.k);
        k();
        l();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, 2);
        layoutParams.addRule(12);
        this.d.addView(this.o, layoutParams);
    }

    private void i() {
        RelativeLayout relativeLayout = new RelativeLayout(this.k);
        this.i = new TextView(this.k);
        this.i.setGravity(17);
        this.i.setTextColor(Color.parseColor("#2f2f2f"));
        this.i.setTextSize(1, 17.0f);
        this.i.setMaxEms(12);
        this.i.setEllipsize(TextUtils.TruncateAt.END);
        this.i.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(this.i, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(2, 2);
        layoutParams2.addRule(10);
        this.d.addView(relativeLayout, layoutParams2);
    }

    private void j() {
        ImageView imageView = new ImageView(this.k);
        this.m = imageView;
        imageView.setId(2);
        this.m.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.k, 120.0f));
        layoutParams.addRule(15);
        this.d.addView(this.m, layoutParams);
    }

    private void k() {
        this.j = new com.opos.cmn.e.a.a.a(this.k, "opos_module_biz_ui_cmn_click_bn_normal_red_bg_img.png", "opos_module_biz_ui_cmn_click_bn_pressed_red_bg_img.png");
        this.j.setGravity(17);
        this.j.setTextColor(-1);
        this.j.setTextSize(1, 12.0f);
        this.j.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 77.0f), com.opos.cmn.an.h.f.a.a(this.k, 23.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.k, 14.0f);
        this.o.addView(this.j, layoutParams);
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
        layoutParams.addRule(15);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.k, 10.0f);
        this.o.addView(this.h, layoutParams);
    }

    private void m() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 240.0f), com.opos.cmn.an.h.f.a.a(this.k, 210.0f));
        layoutParams.addRule(13);
        a(layoutParams);
    }

    private void n() {
        b(new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 264.0f), com.opos.cmn.an.h.f.a.a(this.k, 234.0f)));
    }

    @Override // com.opos.mobad.interstitial.a.b, com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        super.a(hVar);
        com.opos.mobad.n.d.d a2 = hVar != null ? hVar.a() : null;
        if (a2 == null) {
            com.opos.cmn.an.f.a.b("GM640X320Interstitial", "render with data null");
            return;
        }
        c(a2);
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
        float b = b(a2);
        Bitmap a3 = com.opos.mobad.cmn.a.b.g.a(list.get(0).f26633a, com.opos.cmn.an.h.f.a.a(this.k, 240.0f), com.opos.cmn.an.h.f.a.a(this.k, b));
        this.n = a3;
        if (a3 != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.height = com.opos.cmn.an.h.f.a.a(this.k, b);
            this.m.setLayoutParams(layoutParams);
            this.m.setImageBitmap(this.n);
        }
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        try {
            if (this.n != null && !this.n.isRecycled()) {
                this.n.recycle();
                this.n = null;
                com.opos.cmn.an.f.a.b("GM640X320Interstitial", "mAdBitmap.recycle()");
            }
            a(this.h, "");
            a(this.i, "");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("GM640X320Interstitial", "");
        }
    }

    @Override // com.opos.mobad.interstitial.a.b
    public void f() {
        j();
        i();
        h();
        m();
    }
}
