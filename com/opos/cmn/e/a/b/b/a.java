package com.opos.cmn.e.a.b.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/b/b/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected Context f11070a;
    protected com.opos.cmn.e.a.b.c.a b;

    /* renamed from: c  reason: collision with root package name */
    protected RelativeLayout f11071c;
    protected RelativeLayout d;
    protected TextView e;
    protected ImageView f;

    public a(Context context) {
        this(context, 0.6f);
    }

    public a(Context context, float f) {
        this.f11070a = context;
        a(f);
        a();
    }

    private void a(float f) {
        RelativeLayout relativeLayout = new RelativeLayout(this.f11070a);
        this.f11071c = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        b(f);
        this.d = new RelativeLayout(this.f11070a);
        c();
        if (Build.VERSION.SDK_INT >= 29) {
            this.d.setForceDarkAllowed(false);
        }
        TextView textView = new TextView(this.f11070a);
        this.e = textView;
        textView.setId(1);
        this.e.setGravity(17);
        this.e.setMaxLines(3);
        this.e.setEllipsize(TextUtils.TruncateAt.END);
        this.e.setTextColor(Color.parseColor("#2f2f2f"));
        this.e.setTextSize(1, 16.0f);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f11070a, 12.0f);
        this.e.setPadding(a2, 0, a2, 0);
        d();
        ImageView imageView = new ImageView(this.f11070a);
        this.f = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f.setImageDrawable(new ColorDrawable(Color.parseColor("#cdd2d4")));
        e();
        f();
    }

    private void b(float f) {
        ImageView imageView = new ImageView(this.f11070a);
        imageView.setImageDrawable(new ColorDrawable(-16777216));
        imageView.setAlpha(f);
        this.f11071c.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void c() {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.f11070a, 14.0f);
        cVar.setImageDrawable(new ColorDrawable(-1));
        this.d.addView(cVar, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f11070a, 260.0f), com.opos.cmn.an.h.f.a.a(this.f11070a, 91.0f));
        layoutParams.addRule(10);
        this.d.addView(this.e, layoutParams);
    }

    private void e() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f11070a, 260.0f), com.opos.cmn.an.h.f.a.a(this.f11070a, 1.0f));
        layoutParams.addRule(3, 1);
        this.d.addView(this.f, layoutParams);
    }

    private void f() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f11070a, 260.0f), com.opos.cmn.an.h.f.a.a(this.f11070a, 130.0f));
        layoutParams.addRule(13);
        this.f11071c.addView(this.d, layoutParams);
    }

    protected abstract void a();

    public void a(com.opos.cmn.e.a.b.c.a aVar) {
        this.b = aVar;
    }

    public void a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.e.setText(charSequence);
    }

    public View b() {
        return this.f11071c;
    }
}
