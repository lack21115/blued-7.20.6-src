package com.opos.mobad.q.a.f.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.n.a;
import com.opos.mobad.n.d.g;
import com.opos.mobad.n.d.h;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/f/a/d.class */
public class d extends a {
    public d(Context context, int i, a.InterfaceC0538a interfaceC0538a) {
        super(context, i, interfaceC0538a);
    }

    private void a(RelativeLayout relativeLayout) {
        if (this.r != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f13490a, 94.0f), com.opos.cmn.an.h.f.a.a(this.f13490a, 94.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(2, this.o);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f13490a, 24.0f);
        relativeLayout.addView(this.e, layoutParams);
    }

    private void a(RelativeLayout relativeLayout, com.opos.mobad.n.d.f fVar, boolean z) {
        if (this.r == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(2, this.p);
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f13490a, z ? 20 : 40);
            relativeLayout.addView(this.f, layoutParams);
        }
        a(this.f, fVar.b);
        this.f.setVisibility(0);
    }

    private void a(com.opos.mobad.n.d.f fVar) {
        if (this.r == null && fVar.h != null && fVar.h.size() > 0 && fVar.h.get(0) != null) {
            g gVar = fVar.h.get(0);
            if (TextUtils.isEmpty(gVar.f12945a)) {
                return;
            }
            BitmapDrawable a2 = com.opos.mobad.cmn.a.b.g.a(this.f13490a, com.opos.mobad.cmn.a.b.g.a(3, com.opos.mobad.cmn.a.b.g.a(gVar.f12945a, com.opos.cmn.an.h.f.a.b(this.f13490a) / 3, com.opos.cmn.an.h.f.a.c(this.f13490a))));
            if (a2 != null) {
                com.opos.mobad.cmn.a.b.g.a(this.i, a2);
            }
        }
    }

    private void b(RelativeLayout relativeLayout) {
        if (this.r != null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#EB4B4F"));
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f13490a, 7.0f));
        com.opos.mobad.cmn.a.b.g.a(this.f13491c, gradientDrawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f13490a, 184.0f), com.opos.cmn.an.h.f.a.a(this.f13490a, 45.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f13490a, 40.0f);
        relativeLayout.addView(this.f13491c, layoutParams);
    }

    private void b(RelativeLayout relativeLayout, com.opos.mobad.n.d.f fVar, boolean z) {
        if (this.r == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(2, this.q);
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f13490a, z ? 40 : 53);
            relativeLayout.addView(this.g, layoutParams);
        }
        a(this.g, fVar.f12944c);
        this.g.setVisibility(0);
    }

    private boolean b(com.opos.mobad.n.d.f fVar) {
        if (this.r != null) {
            return false;
        }
        boolean z = false;
        if (fVar != null) {
            z = false;
            if (fVar.f12943a != null) {
                z = false;
                if (!TextUtils.isEmpty(fVar.f12943a.f12945a)) {
                    this.j = com.opos.mobad.cmn.a.b.g.a(fVar.f12943a.f12945a, com.opos.cmn.an.h.f.a.a(this.f13490a, 94.0f), com.opos.cmn.an.h.f.a.a(this.f13490a, 94.0f));
                    z = false;
                    if (this.e != null) {
                        z = false;
                        if (this.j != null) {
                            this.e.setImageBitmap(this.j);
                            this.e.setVisibility(0);
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    @Override // com.opos.mobad.n.a
    public void a(h hVar) {
        com.opos.mobad.n.d.f e = hVar.e();
        if (e == null) {
            return;
        }
        h();
        j();
        a(e);
        boolean b = b(e);
        if (b) {
            a(this.h);
        }
        a(this.h, e, b);
        b(this.h, e, b);
        b(this.h);
        a(e.d);
        a(this.f13491c, com.opos.mobad.cmn.a.b.a.FloatLayerClickBt);
        a(this.i, com.opos.mobad.cmn.a.b.a.FloatLayerNonClickBt);
        this.r = e;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        try {
            if (this.j != null && !this.j.isRecycled()) {
                this.j.recycle();
                this.j = null;
                com.opos.cmn.an.f.a.b("LandModelAFloatLayer", "mImgBitmap.recycle()");
            }
            a(this.f, "");
            a(this.g, "");
            a(this.f13491c);
            a(this.d);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("LandModelAFloatLayer", "");
        }
    }

    @Override // com.opos.mobad.q.a.f.a.a
    public void g() {
        this.e = new com.opos.cmn.e.a.a.c(this.f13490a, 28.0f);
        this.e.setScaleType(ImageView.ScaleType.FIT_XY);
        this.e.setVisibility(8);
        this.e.setId(this.n);
        this.f = new TextView(this.f13490a);
        this.f.setGravity(17);
        this.f.setTextColor(Color.parseColor("#000000"));
        this.f.setTextSize(1, 20.0f);
        this.f.setTypeface(Typeface.defaultFromStyle(1));
        this.f.setMaxEms(9);
        this.f.setEllipsize(TextUtils.TruncateAt.END);
        this.f.setMaxLines(2);
        this.f.setVisibility(8);
        this.f.setId(this.o);
        this.g = new TextView(this.f13490a);
        this.g.setGravity(17);
        this.g.setTextColor(Color.parseColor("#98151515"));
        this.g.setTextSize(1, 14.0f);
        this.g.setMaxEms(13);
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        this.g.setVisibility(8);
        this.g.setMaxLines(2);
        this.g.setId(this.p);
        this.f13491c = new TextView(this.f13490a);
        this.f13491c.setGravity(17);
        this.f13491c.setTextColor(Color.parseColor("#ffffff"));
        this.f13491c.setTextSize(1, 16.0f);
        this.f13491c.setId(this.q);
        this.m = new f(this.f13491c, 1.0f, 1.05f, com.igexin.push.config.c.j);
        com.opos.mobad.cmn.a.b.g.a(this.h, new ColorDrawable(Color.parseColor("#e3ffffff")));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f13490a, 260.0f), com.opos.cmn.an.h.f.a.b(this.f13490a));
        layoutParams.addRule(11);
        this.i.addView(this.h, layoutParams);
    }

    @Override // com.opos.mobad.q.a.f.a.a
    public RelativeLayout.LayoutParams i() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f13490a, 30.0f), com.opos.cmn.an.h.f.a.a(this.f13490a, 30.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f13490a, 11.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f13490a, 11.0f);
        return layoutParams;
    }

    @Override // com.opos.mobad.n.a
    /* renamed from: k */
    public RelativeLayout c() {
        return this.i;
    }
}
