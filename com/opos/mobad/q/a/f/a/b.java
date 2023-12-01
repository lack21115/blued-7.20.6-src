package com.opos.mobad.q.a.f.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.n.a;
import com.opos.mobad.n.d.h;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/f/a/b.class */
public class b extends a {
    public b(Context context, int i, a.InterfaceC0708a interfaceC0708a) {
        super(context, i, interfaceC0708a);
    }

    private void a(LinearLayout linearLayout) {
        this.e = new com.opos.cmn.e.a.a.c(this.f27178a, 33.0f);
        this.e.setScaleType(ImageView.ScaleType.FIT_XY);
        this.e.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f27178a, 50.0f), com.opos.cmn.an.h.f.a.a(this.f27178a, 50.0f));
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f27178a, 13.0f);
        linearLayout.addView(this.e, layoutParams);
    }

    private void b(LinearLayout linearLayout) {
        this.f = new TextView(this.f27178a);
        this.f.setGravity(17);
        this.f.setTextColor(Color.parseColor("#000000"));
        this.f.setTextSize(1, 15.0f);
        this.f.setTypeface(Typeface.defaultFromStyle(1));
        this.f.setMaxEms(9);
        this.f.setEllipsize(TextUtils.TruncateAt.END);
        this.f.setSingleLine();
        this.f.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f27178a, 5.0f);
        linearLayout.addView(this.f, layoutParams);
    }

    private void c(LinearLayout linearLayout) {
        this.g = new TextView(this.f27178a);
        this.g.setGravity(17);
        this.g.setTextColor(Color.parseColor("#000000"));
        this.g.setTextSize(1, 13.0f);
        this.g.setMaxEms(13);
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        this.g.setSingleLine();
        this.g.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f27178a, 52.0f);
        linearLayout.addView(this.g, layoutParams);
    }

    private void d(LinearLayout linearLayout) {
        this.f27179c = new TextView(this.f27178a);
        this.f27179c.setGravity(17);
        this.f27179c.setTextColor(Color.parseColor("#ffffff"));
        this.f27179c.setTextSize(1, 15.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#EB4B4F"));
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f27178a, 7.0f));
        g.a(this.f27179c, gradientDrawable);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f27178a, 120.0f), com.opos.cmn.an.h.f.a.a(this.f27178a, 30.0f));
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f27178a, 3.0f);
        linearLayout.addView(this.f27179c, layoutParams);
        this.m = new f(this.f27179c, 1.0f, 1.2f, com.igexin.push.config.c.j);
    }

    @Override // com.opos.mobad.n.a
    public void a(h hVar) {
        com.opos.mobad.n.d.f e = hVar.e();
        if (e == null) {
            return;
        }
        h();
        j();
        if (this.r == null && e.f26631a != null && !TextUtils.isEmpty(e.f26631a.f26633a)) {
            this.j = g.a(e.f26631a.f26633a, com.opos.cmn.an.h.f.a.a(this.f27178a, 50.0f), com.opos.cmn.an.h.f.a.a(this.f27178a, 50.0f));
            if (this.j != null) {
                this.e.setImageBitmap(this.j);
                this.e.setVisibility(0);
            }
        }
        if (this.f != null && !TextUtils.isEmpty(e.b)) {
            a(this.f, e.b);
            this.f.setVisibility(0);
        }
        if (this.g != null && !TextUtils.isEmpty(e.f26632c)) {
            a(this.g, e.f26632c);
            this.g.setVisibility(0);
        }
        a(e.d);
        a(this.f27179c, com.opos.mobad.cmn.a.b.a.FloatLayerClickBt);
        a(this.i, com.opos.mobad.cmn.a.b.a.FloatLayerNonClickBt);
        this.r = e;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        try {
            if (this.j != null && !this.j.isRecycled()) {
                this.j.recycle();
                this.j = null;
                com.opos.cmn.an.f.a.b("GraphicMixFloatLayer", "mImgBitmap.recycle()");
            }
            a(this.f, "");
            a(this.g, "");
            a(this.f27179c);
            a(this.d);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("GraphicMixFloatLayer", "");
        }
    }

    @Override // com.opos.mobad.q.a.f.a.a
    public void g() {
        g.a(this.h, new ColorDrawable(Color.parseColor("#cfffffff")));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.b(this.f27178a), com.opos.cmn.an.h.f.a.c(this.f27178a) / 3);
        layoutParams.addRule(13);
        LinearLayout linearLayout = new LinearLayout(this.f27178a);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f27178a, 144.0f), -2);
        layoutParams2.addRule(13);
        a(linearLayout);
        b(linearLayout);
        c(linearLayout);
        d(linearLayout);
        this.h.addView(linearLayout, layoutParams2);
        this.i.addView(this.h, layoutParams);
    }

    @Override // com.opos.mobad.q.a.f.a.a
    public RelativeLayout.LayoutParams i() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f27178a, 30.0f), com.opos.cmn.an.h.f.a.a(this.f27178a, 30.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        boolean d = com.opos.cmn.an.h.f.a.d(this.f27178a);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f27178a, d ? 54 : 11);
        int i = 11;
        if (d) {
            i = 24;
        }
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f27178a, i);
        return layoutParams;
    }

    @Override // com.opos.mobad.n.a
    /* renamed from: k */
    public RelativeLayout c() {
        return this.i;
    }
}
