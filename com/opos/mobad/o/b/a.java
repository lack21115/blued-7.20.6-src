package com.opos.mobad.o.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.opos.mobad.model.data.AdItemData;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/b/a.class */
public abstract class a implements e, f {
    protected String A;
    protected boolean C;
    protected ImageView D;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    protected AdItemData f27042c;
    protected FrameLayout d;
    protected RelativeLayout e;
    protected ProgressBar f;
    protected TextView g;
    protected TextView h;
    protected ImageView i;
    protected ImageView j;
    protected ImageView k;
    public ImageView l;
    public Bitmap m;
    protected RelativeLayout n;
    protected g o;
    protected i p;
    protected c q;
    protected View r;
    protected View s;
    protected View t;
    protected d u;
    protected boolean v = false;
    protected boolean w = false;
    protected boolean x = false;
    protected boolean y = false;
    protected boolean z = false;
    protected int B = 0;
    protected boolean E = false;
    protected volatile boolean F = false;
    public Handler G = new Handler(Looper.getMainLooper()) { // from class: com.opos.mobad.o.b.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (1 == message.what) {
                a.this.I();
                a.this.y();
                a.this.A();
            }
        }
    };

    public a(Context context, d dVar, FrameLayout frameLayout, boolean z) {
        this.C = false;
        this.b = context.getApplicationContext();
        this.u = dVar;
        this.q = new c(context, this);
        this.o = new g(this.b);
        this.d = frameLayout;
        this.C = z;
        b();
        a();
    }

    private void Q() {
        View c2 = this.o.c();
        this.r = c2;
        c2.setBackgroundColor(Color.parseColor("#00000000"));
        this.r.setClickable(true);
        this.d.addView(this.r, new ViewGroup.LayoutParams(-1, -1));
        this.r.setVisibility(8);
    }

    private void R() {
        ImageView imageView = new ImageView(this.b);
        this.i = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.i.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.b, "opos_module_biz_ui_native_video_continue_click_bn_img.png"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 50.0f), com.opos.cmn.an.h.f.a.a(this.b, 42.0f));
        layoutParams.gravity = 17;
        this.d.addView(this.i, layoutParams);
        this.i.setVisibility(8);
        a(this.i, 2);
        ImageView imageView2 = new ImageView(this.b);
        this.j = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        this.j.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.b, "opos_module_biz_ui_native_video_pause_click_bn_img.png"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 50.0f), com.opos.cmn.an.h.f.a.a(this.b, 42.0f));
        layoutParams2.gravity = 17;
        this.d.addView(this.j, layoutParams2);
        this.j.setVisibility(8);
        a(this.j, 3);
        ImageView imageView3 = new ImageView(this.b);
        this.k = imageView3;
        imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
        this.k.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.b, "opos_module_biz_ui_native_video_continue_click_bn_img.png"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 50.0f), com.opos.cmn.an.h.f.a.a(this.b, 42.0f));
        layoutParams3.gravity = 17;
        this.d.addView(this.k, layoutParams3);
        this.k.setVisibility(8);
        a(this.k, 1);
    }

    private void S() {
        ImageView imageView = new ImageView(this.b);
        this.D = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.D.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 19.0f), com.opos.cmn.an.h.f.a.a(this.b, 15.0f));
        layoutParams.gravity = 53;
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.b, 10.0f);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 13.0f);
        this.d.addView(this.D, layoutParams);
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.o.b.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                a.this.c(!a.this.E);
            }
        });
    }

    private void b() {
        k();
        R();
        Q();
        if (this.C) {
            o();
            m();
            S();
        }
        n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A() {
        ImageView imageView = this.D;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.D.setVisibility(8);
        this.z = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B() {
        D();
        x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
        E();
        y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D() {
        ImageView imageView = this.i;
        if (imageView == null || imageView.getVisibility() != 8) {
            return;
        }
        this.i.setVisibility(0);
        this.i.bringToFront();
        this.w = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E() {
        ImageView imageView = this.i;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.i.setVisibility(8);
        this.w = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F() {
        H();
        x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G() {
        I();
        y();
    }

    protected void H() {
        ImageView imageView = this.j;
        if (imageView == null || imageView.getVisibility() != 8) {
            return;
        }
        this.j.setVisibility(0);
        this.j.bringToFront();
        this.x = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I() {
        ImageView imageView = this.j;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.j.setVisibility(8);
        this.x = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J() {
        ImageView imageView = this.k;
        if (imageView == null || imageView.getVisibility() != 8) {
            return;
        }
        this.k.setVisibility(0);
        this.k.bringToFront();
        this.y = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K() {
        ImageView imageView = this.k;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.k.setVisibility(8);
        this.y = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L() {
        View view = this.r;
        if (view == null || view.getVisibility() != 8) {
            return;
        }
        this.r.setVisibility(0);
        this.r.bringToFront();
        this.o.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M() {
        View view = this.r;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.r.setVisibility(8);
        this.o.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N() {
        E();
        L();
    }

    protected abstract void O();

    protected abstract void P();

    protected abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final View view, final int i) {
        final int[] iArr = new int[4];
        if (view != null) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.opos.mobad.o.b.a.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0 || 1 == motionEvent.getAction()) {
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            iArr[0] = (int) motionEvent.getX();
                            iArr[1] = (int) motionEvent.getY();
                            return false;
                        } else if (action != 1) {
                            return false;
                        } else {
                            iArr[2] = (int) motionEvent.getX();
                            iArr[3] = (int) motionEvent.getY();
                            if (i == 4 && a.this.C) {
                                a.this.P();
                                return false;
                            }
                            return false;
                        }
                    }
                    return false;
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.o.b.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    com.opos.cmn.an.f.a.b("BaseMediaCreative", "clickBnListener status:" + i);
                    a.this.a(view, iArr, i);
                    a.this.O();
                }
            });
        }
    }

    protected abstract void a(View view, int[] iArr, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(boolean z) {
        if (this.D == null || this.F) {
            return;
        }
        this.E = z;
        this.D.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.b, z ? "opos_module_biz_ui_cmn_volume_switch_on_img.png" : "opos_module_biz_ui_cmn_volume_switch_off_img.png"));
        this.F = true;
    }

    public void c(boolean z) {
        boolean z2;
        ImageView imageView;
        Context context;
        String str;
        if (this.D != null) {
            if (z) {
                if (this.E) {
                    return;
                }
                z2 = true;
                k.a().a(this.A, true);
                imageView = this.D;
                context = this.b;
                str = "opos_module_biz_ui_cmn_volume_switch_on_img.png";
            } else if (!this.E) {
                return;
            } else {
                z2 = false;
                k.a().a(this.A, false);
                imageView = this.D;
                context = this.b;
                str = "opos_module_biz_ui_cmn_volume_switch_off_img.png";
            }
            imageView.setImageDrawable(com.opos.cmn.an.d.a.a.c(context, str));
            this.E = z2;
        }
    }

    protected void k() {
        this.n = new RelativeLayout(this.b);
        this.d.addView(this.n, new ViewGroup.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        ImageView imageView = new ImageView(this.b);
        this.l = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.l.setVisibility(8);
        this.d.addView(this.l, layoutParams);
    }

    protected void m() {
        i iVar = new i(this.b, this);
        this.p = iVar;
        View d = iVar.d();
        this.s = d;
        d.setClickable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.s.setVisibility(8);
        this.d.addView(this.s, layoutParams);
    }

    protected void n() {
        View d = this.q.d();
        this.t = d;
        d.setClickable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.t.setVisibility(8);
        this.d.addView(this.t, layoutParams);
    }

    protected void o() {
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        this.e = relativeLayout;
        com.opos.cmn.e.a.d.a.a(relativeLayout, com.opos.cmn.an.d.a.a.c(this.b, "opos_module_biz_ui_native_video_transparent_cover.png"));
        LinearLayout linearLayout = new LinearLayout(this.b);
        linearLayout.setOrientation(0);
        TextView textView = new TextView(this.b);
        this.g = textView;
        textView.setText("00:00");
        this.g.setTextColor(-1);
        this.g.setTextSize(1, 9.0f);
        this.g.setGravity(21);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 26.0f), com.opos.cmn.an.h.f.a.a(this.b, 13.0f));
        layoutParams.weight = 1.0f;
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.b, 6.0f);
        linearLayout.addView(this.g, layoutParams);
        ProgressBar progressBar = new ProgressBar(this.b);
        this.f = progressBar;
        com.opos.cmn.e.a.d.a.a(progressBar, "mOnlyIndeterminate", new Boolean(false));
        this.f.setIndeterminate(false);
        this.f.setProgressDrawable(new ClipDrawable(new ColorDrawable(Color.parseColor("#FF2AD181")), 3, 1));
        this.f.setBackgroundColor(Color.parseColor("#7fD8D8D8"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 260.0f), com.opos.cmn.an.h.f.a.a(this.b, 4.0f));
        layoutParams2.weight = 4.0f;
        layoutParams2.gravity = 16;
        linearLayout.addView(this.f, layoutParams2);
        TextView textView2 = new TextView(this.b);
        this.h = textView2;
        textView2.setText("00:00");
        this.h.setTextColor(-1);
        this.h.setTextSize(1, 9.0f);
        this.h.setGravity(19);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 26.0f), com.opos.cmn.an.h.f.a.a(this.b, 13.0f));
        layoutParams3.weight = 1.0f;
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(this.b, 6.0f);
        linearLayout.addView(this.h, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(12);
        layoutParams4.bottomMargin = com.opos.cmn.an.h.f.a.a(this.b, 12.0f);
        this.e.addView(linearLayout, layoutParams4);
        this.e.setVisibility(8);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.b, 96.0f));
        layoutParams5.gravity = 80;
        this.d.addView(this.e, layoutParams5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        RelativeLayout relativeLayout = this.n;
        if (relativeLayout == null || relativeLayout.getVisibility() != 8) {
            return;
        }
        this.n.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
        RelativeLayout relativeLayout = this.n;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
        ImageView imageView = this.l;
        if (imageView == null || imageView.getVisibility() != 8) {
            return;
        }
        this.l.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() {
        ImageView imageView = this.l;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.l.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        View view = this.t;
        if (view == null || view.getVisibility() != 8) {
            return;
        }
        this.t.setVisibility(0);
        this.t.bringToFront();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
        View view = this.t;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.t.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v() {
        View view = this.s;
        if (view == null || view.getVisibility() != 8) {
            return;
        }
        this.s.setVisibility(0);
        this.s.bringToFront();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
        View view = this.s;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.s.setVisibility(8);
    }

    protected void x() {
        RelativeLayout relativeLayout = this.e;
        if (relativeLayout == null || relativeLayout.getVisibility() != 8) {
            return;
        }
        this.e.setVisibility(0);
        this.e.bringToFront();
        this.v = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y() {
        RelativeLayout relativeLayout = this.e;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        this.e.setVisibility(8);
        this.v = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z() {
        ImageView imageView = this.D;
        if (imageView == null || imageView.getVisibility() != 8) {
            return;
        }
        this.D.setVisibility(0);
        this.D.bringToFront();
        this.z = true;
    }
}
