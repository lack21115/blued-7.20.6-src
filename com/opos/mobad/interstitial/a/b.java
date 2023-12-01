package com.opos.mobad.interstitial.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/interstitial/a/b.class */
public abstract class b implements com.opos.mobad.n.a {

    /* renamed from: a  reason: collision with root package name */
    protected RelativeLayout f26221a;
    protected RelativeLayout b;

    /* renamed from: c  reason: collision with root package name */
    protected RelativeLayout f26222c;
    protected RelativeLayout d;
    protected ImageView e;
    protected ImageView f;
    protected ImageView g;
    protected TextView h;
    protected TextView i;
    protected com.opos.cmn.e.a.a.a j;
    protected Context k;
    protected int[] l = new int[4];
    private a.InterfaceC0708a m;
    private int n;
    private com.opos.mobad.n.d.h o;

    public b(Context context, int i, a.InterfaceC0708a interfaceC0708a) {
        this.k = context;
        this.m = interfaceC0708a;
        this.n = i;
        h();
        f();
    }

    private void a(RelativeLayout relativeLayout) {
        if (this.g == null) {
            ImageView imageView = new ImageView(this.k);
            this.g = imageView;
            imageView.setAlpha(0.35f);
            this.g.setImageDrawable(new ColorDrawable(Color.parseColor("#808080")));
        }
        RelativeLayout.LayoutParams layoutParams = com.opos.cmn.an.h.f.a.d(this.k) ? new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 1.0f), com.opos.cmn.an.h.f.a.a(this.k, 44.0f)) : new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 1.0f), com.opos.cmn.an.h.f.a.a(this.k, 37.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(3, 1);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, -12.0f);
        relativeLayout.addView(this.g, layoutParams);
    }

    private void c(View view) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.l));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.interstitial.a.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    com.opos.cmn.an.f.a.b("BaseGMCreative", "close click origin");
                    b.this.m.d(view2, b.this.l);
                }
            });
        }
    }

    private void c(RelativeLayout.LayoutParams layoutParams) {
        k();
        this.b.addView(this.f26222c, layoutParams);
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.k);
        this.f26221a = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.b = new RelativeLayout(this.k);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.k);
        this.f26222c = relativeLayout2;
        relativeLayout2.setId(1);
        this.d = new RelativeLayout(this.k);
        i();
        this.f26221a.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.opos.mobad.interstitial.a.b.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (b.this.m != null) {
                    b.this.m.b();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    private void i() {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.k, 14.0f);
        cVar.setScaleType(ImageView.ScaleType.FIT_XY);
        cVar.setImageDrawable(new ColorDrawable(-1));
        this.d.addView(cVar, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void j() {
        RelativeLayout relativeLayout = this.b;
        if (relativeLayout != null) {
            this.f26221a.removeView(relativeLayout);
        }
    }

    private void k() {
        RelativeLayout relativeLayout = this.f26222c;
        if (relativeLayout != null) {
            this.b.removeView(relativeLayout);
        }
    }

    private void l() {
        ImageView imageView = this.f;
        if (imageView != null) {
            this.f26222c.removeView(imageView);
        }
        ImageView imageView2 = this.g;
        if (imageView2 != null) {
            this.b.removeView(imageView2);
        }
        ImageView imageView3 = this.e;
        if (imageView3 != null) {
            this.b.removeView(imageView3);
        }
    }

    private void m() {
        if (this.f == null) {
            ImageView imageView = new ImageView(this.k);
            this.f = imageView;
            imageView.setAlpha(0.7f);
            this.f.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.k, "opos_module_biz_ui_interstitial_close_bn_bg_img.png"));
            this.f.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 37.0f), com.opos.cmn.an.h.f.a.a(this.k, 37.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, -4.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.k, -5.0f);
        this.f26222c.addView(this.f, layoutParams);
    }

    private void n() {
        Context context;
        float f;
        a(this.b);
        if (this.e == null) {
            ImageView imageView = new ImageView(this.k);
            this.e = imageView;
            imageView.setAlpha(0.7f);
            this.e.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.k, "opos_module_biz_ui_interstitial_close_bn_bg_img.png"));
            this.e.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 37.0f), com.opos.cmn.an.h.f.a.a(this.k, 37.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(3, 1);
        if (com.opos.cmn.an.h.f.a.d(this.k)) {
            context = this.k;
            f = 28.0f;
        } else {
            context = this.k;
            f = 21.0f;
        }
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(context, f);
        this.b.addView(this.e, layoutParams);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        ImageView imageView;
        l();
        if (i == 1 || i != 2) {
            m();
            imageView = this.f;
        } else {
            n();
            imageView = this.e;
        }
        c(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.l));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.interstitial.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    b.this.m.f(view2, b.this.l);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.f26222c.addView(this.d, layoutParams);
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
    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.m = interfaceC0708a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.opos.mobad.n.d.d dVar) {
        this.j.setText(dVar.l);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.opos.mobad.n.d.d dVar, RelativeLayout relativeLayout, RelativeLayout.LayoutParams layoutParams) {
        View a2 = com.opos.mobad.n.e.a(dVar, relativeLayout, layoutParams);
        if (a2 != null) {
            a2.setId(5);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0708a interfaceC0708a;
        if (this.o == null && (interfaceC0708a = this.m) != null) {
            interfaceC0708a.e();
        }
        this.o = hVar;
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.l));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.interstitial.a.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    b.this.m.g(view2, b.this.l);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(RelativeLayout.LayoutParams layoutParams) {
        j();
        c(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.f26221a.addView(this.b, layoutParams2);
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.n;
    }

    public abstract void f();

    @Override // com.opos.mobad.n.a
    /* renamed from: g */
    public RelativeLayout c() {
        return this.f26221a;
    }
}
