package com.opos.mobad.n.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.applog.tracker.Tracker;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.d;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/r.class */
public class r implements com.opos.mobad.n.a {
    private f A;
    private m B;

    /* renamed from: a  reason: collision with root package name */
    private Context f26545a;
    private a.InterfaceC0708a b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.mobad.n.d.e f26546c;
    private com.opos.mobad.c.c.a d;
    private int e;
    private int f;
    private RelativeLayout h;
    private RelativeLayout i;
    private View j;
    private ImageView k;
    private View l;
    private View m;
    private View n;
    private b o;
    private View p;
    private com.opos.mobad.n.d q;
    private Drawable s;
    private Drawable t;
    private long x;
    private long y;
    private boolean g = false;
    private long r = -1;
    private volatile int u = 0;
    private volatile int v = 0;
    private boolean z = false;
    private Runnable C = new Runnable() { // from class: com.opos.mobad.n.a.r.1
        @Override // java.lang.Runnable
        public void run() {
            if (r.this.u == 6) {
                return;
            }
            if (r.this.r <= 0) {
                r.this.b.d(r.this.x - r.this.r, r.this.y);
                r.this.w.a();
                r.this.a();
                r.this.p();
                r.this.r();
                return;
            }
            com.opos.cmn.an.f.a.b("SplashVideo", "countdown=" + r.this.r);
            r.this.w.a(1000L);
            if (r.this.q != null) {
                r.this.q.a((int) (r.this.r / 1000));
            }
            r.this.b.d(r.this.x - r.this.r, r.this.y);
            r.this.r -= 1000;
        }
    };
    private com.opos.mobad.c.c.b D = new com.opos.mobad.c.c.b() { // from class: com.opos.mobad.n.a.r.7
        private void a(long j) {
            String str;
            if (j <= 0) {
                str = "error video duration";
            } else {
                r rVar = r.this;
                rVar.r = Math.min(j, rVar.r);
                r rVar2 = r.this;
                rVar2.x = rVar2.r;
                str = "resetVideoDurationIfNeed ori = " + j + ",after =" + r.this.x;
            }
            com.opos.cmn.an.f.a.b("SplashVideo", str);
        }

        @Override // com.opos.mobad.c.c.b
        public void a(int i, String str) {
            com.opos.cmn.an.f.a.b("SplashVideo", "play video error,errCode:" + i + ", errMsg" + str);
            r.this.u = 4;
            r.this.a();
            r.this.p();
            if (r.this.b != null) {
                r.this.b.b(i);
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void c() {
        }

        @Override // com.opos.mobad.c.c.b
        public void d() {
            com.opos.cmn.an.f.a.b("SplashVideo", "play video onStart");
            r.this.u = 2;
            r.this.v = 0;
            r rVar = r.this;
            rVar.y = rVar.d.c();
            a(r.this.y);
            r.this.w.a(0L);
            r.this.o();
        }

        @Override // com.opos.mobad.c.c.b
        public void e() {
            com.opos.cmn.an.f.a.b("SplashVideo", "play video complete");
        }

        @Override // com.opos.mobad.c.c.b
        public void f() {
            com.opos.cmn.an.f.a.b("SplashVideo", "play video onResume");
            r.this.u = 2;
            r.this.v = 0;
        }

        @Override // com.opos.mobad.c.c.b
        public void g() {
            com.opos.cmn.an.f.a.b("SplashVideo", "play video onPause");
            r.this.u = 3;
        }

        @Override // com.opos.mobad.c.c.b
        public void h() {
        }

        @Override // com.opos.mobad.c.c.b
        public void i() {
        }

        @Override // com.opos.mobad.c.c.b
        public void j() {
        }
    };
    private com.opos.mobad.c.b.c w = new com.opos.mobad.c.b.c(com.opos.mobad.c.b.b.a(), this.C);

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/r$a.class */
    public class a extends com.opos.mobad.c.d.a {
        public a(Context context) {
            super(context);
        }

        @Override // com.opos.mobad.c.d.a, android.view.View
        public void onWindowVisibilityChanged(int i) {
            super.onWindowVisibilityChanged(i);
            r.this.b(i == 0);
        }
    }

    public r(Context context, int i, com.opos.mobad.c.c.a aVar, int i2, m mVar) {
        this.B = m.NONE;
        this.f26545a = context;
        this.B = a(mVar);
        this.f = i2;
        this.e = i;
        this.d = aVar;
        aVar.a(this.D);
        this.d.d(0);
        this.d.c(3);
        this.d.a(0.0f);
        h();
        g();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
        if (r6 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.opos.mobad.n.a.m a(com.opos.mobad.n.a.m r5) {
        /*
            r4 = this;
            r0 = r5
            com.opos.mobad.n.a.m r1 = com.opos.mobad.n.a.m.NONE
            if (r0 != r1) goto L9
            r0 = r5
            return r0
        L9:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 >= r1) goto L15
        L11:
            com.opos.mobad.n.a.m r0 = com.opos.mobad.n.a.m.NONE
            return r0
        L15:
            r0 = r5
            com.opos.mobad.n.a.m r1 = com.opos.mobad.n.a.m.SHAKE
            if (r0 != r1) goto L42
            r0 = r4
            android.content.Context r0 = r0.f26545a     // Catch: java.lang.Exception -> L30
            java.lang.String r1 = "sensor"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Exception -> L30
            android.hardware.SensorManager r0 = (android.hardware.SensorManager) r0     // Catch: java.lang.Exception -> L30
            r1 = 1
            android.hardware.Sensor r0 = r0.getDefaultSensor(r1)     // Catch: java.lang.Exception -> L30
            r6 = r0
            goto L3b
        L30:
            r6 = move-exception
            java.lang.String r0 = "SplashVideo"
            java.lang.String r1 = "check"
            r2 = r6
            com.opos.cmn.an.f.a.b(r0, r1, r2)
            r0 = 0
            r6 = r0
        L3b:
            r0 = r6
            if (r0 != 0) goto L42
            goto L11
        L42:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.n.a.r.a(com.opos.mobad.n.a.m):com.opos.mobad.n.a.m");
    }

    public static final com.opos.mobad.n.a a(Context context, int i, com.opos.mobad.c.c.a aVar, m mVar) {
        return new r(context, i, aVar, 0, mVar);
    }

    private void a(com.opos.mobad.n.d.e eVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.i.addView(this.j, layoutParams);
        this.i.addView(this.p, layoutParams);
        if (eVar.v != null) {
            a(eVar.v.f26626a, eVar.v.b);
        }
        k();
        this.A.a(eVar.l, eVar.E, eVar.F);
        if (this.f == 0 && eVar.t != null) {
            View a2 = eVar.t.a();
            this.l = a2;
            if (a2 != null && a2.getParent() != null) {
                ((ViewGroup) this.l.getParent()).removeView(this.l);
            }
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        View view = this.l;
        if (view != null) {
            view.setId(View.generateViewId());
            this.h.addView(this.l, q.b(this.f26545a));
            this.l.setVisibility(0);
            layoutParams2.addRule(2, this.l.getId());
        }
        this.h.addView(this.i, layoutParams2);
        this.m = q.a(eVar, this.h);
        eVar.u.a(new d.a() { // from class: com.opos.mobad.n.a.r.6
            @Override // com.opos.mobad.n.d.a
            public void a(View view2, int[] iArr) {
                if (r.this.b != null) {
                    r.this.a();
                    r.this.p();
                    r.this.b.d(view2, iArr);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(12);
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = com.opos.cmn.an.h.f.a.a(this.f26545a, 22.0f);
        layoutParams3.bottomMargin = m();
        View a3 = com.opos.mobad.n.e.a(this.f26546c, this.i, layoutParams3);
        this.n = a3;
        a3.setVisibility(4);
        this.i.addView(this.k, l());
    }

    private void a(String str, String str2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = m();
        this.i.addView(this.o, layoutParams);
        this.o.a(n(), str, str2);
    }

    private void a(boolean z) {
        com.opos.mobad.c.c.a aVar = this.d;
        if (aVar != null) {
            aVar.a(z ? 1.0f : 0.0f);
        }
        ImageView imageView = this.k;
        if (imageView != null) {
            imageView.setImageDrawable(z ? this.t : this.s);
        }
    }

    public static final com.opos.mobad.n.a b(Context context, int i, com.opos.mobad.c.c.a aVar, m mVar) {
        return new r(context, i, aVar, 1, mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        String str;
        if (this.z == z) {
            com.opos.cmn.an.f.a.b("SplashVideo", "view visbile not change");
            return;
        }
        this.z = z;
        try {
            com.opos.cmn.an.f.a.b("SplashVideo", "onWindowVisibilityChanged isViewVisible= " + z + "," + this.u + "," + this.v);
            if (this.u != 0 && !q()) {
                if (z) {
                    if (this.u != 1 && this.u != 2 && this.u != 4) {
                        if (this.v != 1) {
                            this.d.g();
                            return;
                        }
                        str = "resetVideoPlayerByVisible but is user stop";
                    }
                    str = "resetVideoPlayerByVisible error state" + this.u;
                } else {
                    if (this.u != 3 && this.u != 4) {
                        this.d.f();
                        return;
                    }
                    str = "resetVideoPlayerByVisible current state has stop =" + this.u;
                }
                com.opos.cmn.an.f.a.b("SplashVideo", str);
            }
            str = "resetVideoPlayerByVisible but no action " + this.u;
            com.opos.cmn.an.f.a.b("SplashVideo", str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("SplashVideo", "reset video fail", e);
        }
    }

    public static final com.opos.mobad.n.a c(Context context, int i, com.opos.mobad.c.c.a aVar, m mVar) {
        return new r(context, i, aVar, 2, mVar);
    }

    private void g() {
        final a aVar = new a(this.f26545a);
        aVar.a(new a.InterfaceC0678a() { // from class: com.opos.mobad.n.a.r.2
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0089, code lost:
                if (com.opos.mobad.n.a.q.e(r5.b.f26545a) != false) goto L30;
             */
            @Override // com.opos.mobad.c.d.a.InterfaceC0678a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void a(boolean r6) {
                /*
                    Method dump skipped, instructions count: 268
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.n.a.r.AnonymousClass2.a(boolean):void");
            }
        });
        this.h.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f26545a);
        this.h = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f26545a);
        this.i = relativeLayout2;
        relativeLayout2.setBackgroundColor(-1);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.r.3
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                r.this.A.b();
                if (r.this.b != null) {
                    r.this.b.e(view, iArr);
                }
            }
        };
        this.i.setOnTouchListener(gVar);
        this.i.setOnClickListener(gVar);
        this.p = new FrameLayout(this.f26545a);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{1711276032, 16777215, 16777215, 1711276032});
        gradientDrawable.setGradientType(0);
        this.p.setBackground(gradientDrawable);
        this.p.setVisibility(4);
        View b = this.d.b();
        this.j = b;
        b.setVisibility(0);
        b bVar = new b(this.f26545a);
        this.o = bVar;
        bVar.setVisibility(4);
        i();
        j();
    }

    private void i() {
        f a2 = l.a(this.f26545a, this.B);
        this.A = a2;
        a2.a(new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.r.4
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (r.this.b != null) {
                    r.this.b.f(view, iArr);
                }
            }
        });
    }

    private void j() {
        ImageView imageView = new ImageView(this.f26545a);
        this.k = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.s = this.f26545a.getResources().getDrawable(R.drawable.opos_mobad_drawable_sound_off);
        this.t = this.f26545a.getResources().getDrawable(R.drawable.opos_mobad_drawable_sound_on);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f26545a, 6.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(this.f26545a, 7.0f);
        this.k.setPadding(a2, a3, a2, a3);
        this.k.setImageDrawable(this.s);
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.n.a.r.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                r.this.f();
            }
        });
        this.k.setVisibility(4);
    }

    private void k() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        int i = this.f;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f26545a, i != 1 ? i != 2 ? 72 : 37 : 79);
        this.i.addView(this.A.a(), layoutParams);
    }

    private RelativeLayout.LayoutParams l() {
        int a2 = com.opos.cmn.an.h.f.a.a(this.f26545a, 26.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        int i = this.f26546c.o == 0 ? 96 : 22;
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f26545a, 33.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f26545a, i);
        return layoutParams;
    }

    private int m() {
        return com.opos.cmn.an.h.f.a.a(this.f26545a, this.f != 1 ? 15 : 30);
    }

    private int n() {
        return this.f == 2 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.j.setVisibility(0);
        this.p.setVisibility(0);
        this.m.setVisibility(0);
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        this.k.setVisibility(0);
        this.i.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        try {
            if (q()) {
                com.opos.cmn.an.f.a.b("SplashVideo", "video player has release");
                return;
            }
            final com.opos.mobad.c.c.a aVar = this.d;
            if (aVar != null) {
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.n.a.r.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aVar != null) {
                            com.opos.cmn.an.f.a.b("SplashVideo", "video player release");
                            aVar.h();
                        }
                    }
                });
            }
            com.opos.cmn.an.f.a.b("SplashVideo", "video player release");
            this.u = 5;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("SplashVideo", "releaseVideoPlayer", e);
        }
    }

    private boolean q() {
        return this.u == 5 || this.u == 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (s()) {
            com.opos.cmn.an.f.a.b("SplashVideo", "handleAdClosed");
            a.InterfaceC0708a interfaceC0708a = this.b;
            if (interfaceC0708a != null) {
                long j = this.x;
                interfaceC0708a.a(j, j);
            }
        }
    }

    private boolean s() {
        View c2 = c();
        return c2 != null && c2.isShown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        com.opos.cmn.an.f.a.b("SplashVideo", "start to play video");
        com.opos.mobad.n.d.e eVar = this.f26546c;
        if (eVar == null || eVar.f26630a == null) {
            return;
        }
        this.d.a(this.f26546c.f26630a.f26633a);
        this.d.e();
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        com.opos.cmn.an.f.a.b("SplashVideo", "stop countdown...");
        if (this.u == 3 || q() || this.u == 4) {
            com.opos.cmn.an.f.a.b("SplashVideo", "current state has stop =" + this.u);
            return;
        }
        this.w.a();
        this.d.f();
        this.v = 1;
        this.A.d();
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.o.a(interfaceC0708a);
        this.b = interfaceC0708a;
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.mobad.n.d.e b = hVar.b();
        boolean z = true;
        if (b == null || b.u == null) {
            this.b.b(1);
            return;
        }
        com.opos.cmn.an.f.a.b("SplashVideo", "render");
        this.f26546c = b;
        this.q = b.u;
        long j = b.w;
        this.r = j;
        if (j <= 0) {
            this.r = com.anythink.expressad.video.module.a.a.m.ag;
        }
        this.x = this.r;
        if (b.B != 1) {
            z = false;
        }
        this.g = z;
        a(z);
        a(b);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        com.opos.cmn.an.f.a.b("SplashVideo", "start countdown...");
        if (this.u != 1 && this.u != 2 && !q() && this.u != 4) {
            this.w.a(0L);
            this.d.g();
            this.A.e();
            return;
        }
        com.opos.cmn.an.f.a.b("SplashVideo", "error state" + this.u);
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.h;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("SplashVideo", "destroy");
        this.A.f();
        a();
        p();
        this.f26546c = null;
        this.u = 6;
        this.w.a();
        this.w.b();
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.e;
    }

    public void f() {
        this.g = !this.g;
        com.opos.cmn.an.f.a.b("SplashVideo", "VolumeSwitchIconClicked: " + this.g);
        a(this.g);
    }
}
