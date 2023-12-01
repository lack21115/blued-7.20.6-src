package com.opos.mobad.cmn.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.model.data.AdItemData;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/c.class */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    protected Context f12208a;
    protected TextView b;

    /* renamed from: c  reason: collision with root package name */
    protected Drawable f12209c;
    public int[] d = new int[4];
    protected boolean e = false;
    protected AdItemData f;
    protected GradientDrawable g;

    public c(Context context) {
        this.f12208a = com.opos.mobad.service.b.a(context);
        k();
    }

    private void k() {
        TextView textView = new TextView(this.f12208a);
        this.b = textView;
        textView.setPadding(com.opos.cmn.an.h.f.a.a(this.f12208a, 4.0f), com.opos.cmn.an.h.f.a.a(this.f12208a, 2.0f), com.opos.cmn.an.h.f.a.a(this.f12208a, 4.0f), com.opos.cmn.an.h.f.a.a(this.f12208a, 2.0f));
        this.b.setTextColor(Color.parseColor("#FFFFFF"));
        this.b.setTextSize(1, 8.0f);
        this.b.setGravity(17);
        this.b.setMaxEms(6);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        this.b.setSingleLine();
        this.b.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.g = gradientDrawable;
        gradientDrawable.setColor(Color.parseColor("#3D151515"));
        this.g.setCornerRadius(5.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        if (view != null) {
            try {
                view.setOnTouchListener(null);
                view.setOnClickListener(null);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("BaseCreative", "", (Throwable) e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AdItemData adItemData) {
        TextView textView;
        int i;
        if (adItemData == null || !adItemData.j()) {
            textView = this.b;
            i = 8;
        } else {
            Drawable b = b(adItemData);
            this.f12209c = b;
            if (b != null) {
                g.a(this.b, b);
            } else {
                g.a(this.b, this.g);
                if (!com.opos.cmn.an.c.a.a(adItemData.B())) {
                    this.b.setText(adItemData.B());
                }
            }
            textView = this.b;
            i = 0;
        }
        textView.setVisibility(i);
    }

    protected Drawable b(AdItemData adItemData) {
        Drawable b = (adItemData == null || adItemData.l() == null || com.opos.cmn.an.c.a.a(adItemData.l().a())) ? null : g.b(this.f12208a, adItemData.l().a());
        StringBuilder sb = new StringBuilder();
        sb.append("getLogoDrawable=");
        sb.append(b != null ? b : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("BaseCreative", sb.toString());
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c(AdItemData adItemData) {
        return g.a(this.f12208a, adItemData, this.e);
    }

    public void d() {
        h();
        i();
        j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RelativeLayout.LayoutParams f() {
        StringBuilder sb = new StringBuilder();
        sb.append("getLogoLP mLogoDrawable=");
        Drawable drawable = this.f12209c;
        if (drawable == null) {
            drawable = com.igexin.push.core.b.l;
        }
        sb.append(drawable);
        com.opos.cmn.an.f.a.b("BaseCreative", sb.toString());
        return this.f12209c != null ? new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f12208a, 26.0f), com.opos.cmn.an.h.f.a.a(this.f12208a, 12.0f)) : new RelativeLayout.LayoutParams(-2, -2);
    }

    public abstract void g();

    public abstract void h();

    protected abstract void i();

    protected abstract void j();
}
