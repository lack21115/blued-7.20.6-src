package com.opos.mobad.interstitial.a;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/interstitial/a/c.class */
public abstract class c implements com.opos.mobad.n.a {

    /* renamed from: a  reason: collision with root package name */
    protected Activity f12539a;
    protected a.InterfaceC0538a b;

    /* renamed from: c  reason: collision with root package name */
    protected RelativeLayout f12540c;
    protected ImageView d;
    protected ImageView e;
    protected com.opos.cmn.e.a.a.a f;
    protected RelativeLayout g;
    protected RelativeLayout h;
    protected ImageView i;
    protected int[] j = new int[4];
    private int k;
    private com.opos.mobad.n.d.h l;

    public c(Activity activity, int i, a.InterfaceC0538a interfaceC0538a) {
        this.f12539a = activity;
        this.b = interfaceC0538a;
        this.k = i;
        h();
        f();
    }

    private void c(View view) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.j));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.interstitial.a.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    com.opos.cmn.an.f.a.b("BaseInterstitialCreative", "close click origin");
                    c.this.b.d(view2, c.this.j);
                }
            });
        }
    }

    private void c(RelativeLayout relativeLayout) {
        Activity activity;
        float f;
        d(relativeLayout);
        if (this.e == null) {
            ImageView imageView = new ImageView(this.f12539a);
            this.e = imageView;
            imageView.setAlpha(0.7f);
            this.e.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.f12539a, "opos_module_biz_ui_interstitial_close_bn_bg_img.png"));
            this.e.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f12539a, 37.0f), com.opos.cmn.an.h.f.a.a(this.f12539a, 37.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(3, 1);
        if (com.opos.cmn.an.h.f.a.d(this.f12539a)) {
            activity = this.f12539a;
            f = 28.0f;
        } else {
            activity = this.f12539a;
            f = 21.0f;
        }
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(activity, f);
        relativeLayout.addView(this.e, layoutParams);
    }

    private void d(RelativeLayout relativeLayout) {
        if (this.i == null) {
            ImageView imageView = new ImageView(this.f12539a);
            this.i = imageView;
            imageView.setAlpha(0.35f);
            this.i.setImageDrawable(new ColorDrawable(Color.parseColor("#808080")));
        }
        RelativeLayout.LayoutParams layoutParams = com.opos.cmn.an.h.f.a.d(this.f12539a) ? new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f12539a, 1.0f), com.opos.cmn.an.h.f.a.a(this.f12539a, 44.0f)) : new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f12539a, 1.0f), com.opos.cmn.an.h.f.a.a(this.f12539a, 37.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(3, 1);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f12539a, -12.0f);
        relativeLayout.addView(this.i, layoutParams);
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f12539a);
        this.f12540c = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f12539a);
        this.g = relativeLayout2;
        relativeLayout2.setId(1);
        this.h = new RelativeLayout(this.f12539a);
        this.f12540c.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.opos.mobad.interstitial.a.c.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (c.this.b != null) {
                    c.this.b.b();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    private void i() {
        ImageView imageView = this.d;
        if (imageView != null) {
            this.g.removeView(imageView);
        }
        ImageView imageView2 = this.i;
        if (imageView2 != null) {
            this.f12540c.removeView(imageView2);
        }
        ImageView imageView3 = this.e;
        if (imageView3 != null) {
            this.f12540c.removeView(imageView3);
        }
    }

    private void j() {
        RelativeLayout relativeLayout = this.g;
        if (relativeLayout != null) {
            this.f12540c.removeView(relativeLayout);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        ImageView imageView;
        i();
        if (i == 1 || i != 2) {
            b(this.g);
            imageView = this.d;
        } else {
            c(this.f12540c);
            imageView = this.e;
        }
        c(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.j));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.interstitial.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    c.this.b.f(view2, c.this.j);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(RelativeLayout relativeLayout) {
        com.opos.cmn.e.a.a.a aVar = new com.opos.cmn.e.a.a.a(this.f12539a, "opos_module_biz_ui_interstitial_click_bn_normal_yellow_bg_img.png", "opos_module_biz_ui_interstitial_click_bn_pressed_yellow_bg_img.png");
        this.f = aVar;
        aVar.setId(3);
        this.f.setGravity(17);
        this.f.setTextColor(-1);
        this.f.setTextSize(1, 16.0f);
        this.f.setTypeface(Typeface.defaultFromStyle(1));
        this.f.setSingleLine();
        this.f.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f12539a, 240.0f), com.opos.cmn.an.h.f.a.a(this.f12539a, 34.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(3, 2);
        relativeLayout.addView(this.f, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, String str) {
        if (textView != null) {
            String str2 = str;
            if (com.opos.cmn.an.c.a.a(str)) {
                str2 = "";
            }
            textView.setText(str2);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.b = interfaceC0538a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.opos.mobad.n.d.d dVar) {
        if (dVar != null) {
            this.f.setText(dVar.l);
            this.f.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.opos.mobad.n.d.d dVar, RelativeLayout relativeLayout) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(2, 3);
        layoutParams.addRule(11);
        a.a(dVar, relativeLayout, layoutParams);
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0538a interfaceC0538a;
        if (this.l == null && (interfaceC0538a = this.b) != null) {
            interfaceC0538a.e();
        }
        this.l = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, int i) {
        a(z, i, 264, 258);
    }

    protected void a(boolean z, int i, int i2, int i3) {
        float f;
        float f2;
        int a2;
        StringBuilder sb;
        j();
        if (z) {
            com.opos.mobad.cmn.a.b.g.a(this.g, com.opos.cmn.an.d.a.a.c(this.f12539a, "opos_module_biz_ui_interstitial_ad_rl_bg_img.png"));
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f12539a, i2), com.opos.cmn.an.h.f.a.a(this.f12539a, i3));
        if (com.opos.cmn.an.h.f.a.d(this.f12539a)) {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f12539a) ? com.opos.cmn.an.h.f.a.a(this.f12539a, 191.0f) : com.opos.cmn.an.h.f.a.a(this.f12539a, 191.0f) - com.opos.cmn.an.h.f.a.k(this.f12539a);
            sb = new StringBuilder();
        } else {
            if (i == 1) {
                f = 53.0f;
                if (com.opos.cmn.an.h.f.a.a(this.f12539a)) {
                    f2 = 53.0f;
                    a2 = com.opos.cmn.an.h.f.a.a(this.f12539a, f2);
                }
                a2 = com.opos.cmn.an.h.f.a.a(this.f12539a, f) - com.opos.cmn.an.h.f.a.k(this.f12539a);
            } else if (i != 2) {
                f = 38.0f;
                if (com.opos.cmn.an.h.f.a.a(this.f12539a)) {
                    f2 = 38.0f;
                    a2 = com.opos.cmn.an.h.f.a.a(this.f12539a, f2);
                }
                a2 = com.opos.cmn.an.h.f.a.a(this.f12539a, f) - com.opos.cmn.an.h.f.a.k(this.f12539a);
            } else {
                f = 29.0f;
                if (com.opos.cmn.an.h.f.a.a(this.f12539a)) {
                    f2 = 29.0f;
                    a2 = com.opos.cmn.an.h.f.a.a(this.f12539a, f2);
                }
                a2 = com.opos.cmn.an.h.f.a.a(this.f12539a, f) - com.opos.cmn.an.h.f.a.k(this.f12539a);
            }
            layoutParams.topMargin = a2;
            sb = new StringBuilder();
        }
        sb.append("adLP.topMargin =");
        sb.append(layoutParams.topMargin);
        com.opos.cmn.an.f.a.b("BaseInterstitialCreative", sb.toString());
        layoutParams.addRule(14);
        this.f12540c.addView(this.g, layoutParams);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.j));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.interstitial.a.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    c.this.b.g(view2, c.this.j);
                }
            });
        }
    }

    protected void b(RelativeLayout relativeLayout) {
        if (this.d == null) {
            ImageView imageView = new ImageView(this.f12539a);
            this.d = imageView;
            imageView.setAlpha(0.7f);
            this.d.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.f12539a, "opos_module_biz_ui_interstitial_close_bn_bg_img.png"));
            this.d.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f12539a, 37.0f), com.opos.cmn.an.h.f.a.a(this.f12539a, 37.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f12539a, -4.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f12539a, -5.0f);
        relativeLayout.addView(this.d, layoutParams);
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.k;
    }

    public abstract void f();

    @Override // com.opos.mobad.n.a
    /* renamed from: g */
    public RelativeLayout c() {
        return this.f12540c;
    }
}
