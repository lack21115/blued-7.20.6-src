package com.opos.mobad.n.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.d;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/h.class */
public class h implements com.opos.mobad.n.a {
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private g f12816c;
    private ImageView d;
    private int e;
    private long g;
    private f h;
    private Context i;
    private a.InterfaceC0538a j;
    private com.opos.mobad.n.d.d k;
    private int l;
    private int m;
    private RelativeLayout n;
    private RelativeLayout o;
    private ViewGroup p;
    private View q;
    private View r;
    private b s;
    private com.opos.mobad.n.d t;
    private long u;
    private m v;

    /* renamed from: a  reason: collision with root package name */
    private volatile int f12815a = 0;
    private Runnable w = new Runnable() { // from class: com.opos.mobad.n.a.h.1
        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f12815a == 4) {
                return;
            }
            if (h.this.u <= 0) {
                h.this.j.d(h.this.g - h.this.u, h.this.g);
                h.this.f.a();
                h.this.a();
                h.this.r();
                return;
            }
            com.opos.cmn.an.f.a.b("LogoSplash", "countdown=" + h.this.u);
            h.this.f.a(1000L);
            if (h.this.t != null) {
                h.this.t.a((int) (h.this.u / 1000));
            }
            h.this.j.d(h.this.g - h.this.u, h.this.g);
            h.this.u -= 1000;
        }
    };
    private com.opos.mobad.c.b.c f = new com.opos.mobad.c.b.c(com.opos.mobad.c.b.b.a(), this.w);

    private h(Context context, int i, int i2, m mVar) {
        this.v = m.NONE;
        this.i = context;
        this.v = a(mVar);
        this.m = i2;
        this.l = i;
        g();
        f();
    }

    public static h a(Context context, int i, m mVar) {
        return new h(context, i, 1, mVar);
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
            android.content.Context r0 = r0.i     // Catch: java.lang.Throwable -> L30
            java.lang.String r1 = "sensor"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Throwable -> L30
            android.hardware.SensorManager r0 = (android.hardware.SensorManager) r0     // Catch: java.lang.Throwable -> L30
            r1 = 1
            android.hardware.Sensor r0 = r0.getDefaultSensor(r1)     // Catch: java.lang.Throwable -> L30
            r6 = r0
            goto L3b
        L30:
            r6 = move-exception
            java.lang.String r0 = "LogoSplash"
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
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.n.a.h.a(com.opos.mobad.n.a.m):com.opos.mobad.n.a.m");
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        ViewGroup viewGroup;
        int i;
        int i2 = this.m;
        if ((i2 == 0 || i2 == 1) && dVar.t != null) {
            View a2 = dVar.t.a();
            if (a2 == null) {
                return;
            }
            if (a2.getParent() != null) {
                ((ViewGroup) a2.getParent()).removeView(a2);
            }
            this.p.addView(a2);
            viewGroup = this.p;
            i = 0;
        } else {
            viewGroup = this.p;
            i = 8;
        }
        viewGroup.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, int i2, int i3, int i4) {
        return i * i4 < i2 * i3;
    }

    public static h b(Context context, int i, m mVar) {
        return new h(context, i, 4, mVar);
    }

    private void b(final com.opos.mobad.n.d.d dVar) {
        if (dVar.m != null) {
            this.d.setScaleType(ImageView.ScaleType.FIT_XY);
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.n.a.h.5
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    if (h.this.f12815a == 4) {
                        str = "load ima but has destroyed";
                    } else {
                        final Bitmap b = com.opos.mobad.n.e.b(dVar.m.f12945a, com.opos.cmn.an.h.f.a.a(h.this.i, 85.0f), com.opos.cmn.an.h.f.a.a(h.this.i, 85.0f));
                        final Bitmap a2 = com.opos.mobad.n.c.d.a(h.this.i, b, 75, 0.25f, 56.0f);
                        if (a2 != null) {
                            com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.a.h.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (h.this.f12815a == 4) {
                                        com.opos.cmn.an.f.a.b("LogoSplash", "load bitmap but has destroy");
                                        return;
                                    }
                                    h.this.b.a(h.this.p(), b, dVar.f, dVar.e);
                                    h.this.b.setVisibility(0);
                                    h.this.d.setImageBitmap(a2);
                                }
                            });
                            return;
                        }
                        str = "null blur bitmap";
                    }
                    com.opos.cmn.an.f.a.b("LogoSplash", str);
                }
            });
        }
    }

    public static h c(Context context, int i, m mVar) {
        return new h(context, i, 0, mVar);
    }

    private void c(final com.opos.mobad.n.d.d dVar) {
        this.d.setScaleType(ImageView.ScaleType.FIT_XY);
        this.e = this.p != null ? com.opos.cmn.an.h.f.a.c(this.i) - q.c(this.i) : com.opos.cmn.an.h.f.a.c(this.i);
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.n.a.h.6
            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (h.this.f12815a == 4) {
                    str = "load ima but has destroyed";
                } else if (dVar.g.get(0) == null) {
                    str = "null imgList";
                } else {
                    final Bitmap a2 = com.opos.mobad.n.e.a(dVar.g.get(0).f12945a, com.opos.cmn.an.h.f.a.b(h.this.i), h.this.e);
                    if (a2 != null) {
                        h hVar = h.this;
                        final boolean a3 = hVar.a(hVar.e, com.opos.cmn.an.h.f.a.b(h.this.i), a2.getHeight(), a2.getWidth());
                        com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.a.h.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (h.this.f12815a == 4) {
                                    com.opos.cmn.an.f.a.b("LogoSplash", "load ima but has destroyed");
                                    return;
                                }
                                if (a3) {
                                    h.this.d.setScaleType(ImageView.ScaleType.MATRIX);
                                }
                                h.this.d.setImageBitmap(a2);
                            }
                        });
                        return;
                    }
                    str = "null bitmap";
                }
                com.opos.cmn.an.f.a.b("LogoSplash", str);
            }
        });
    }

    public static h d(Context context, int i, m mVar) {
        return new h(context, i, 2, mVar);
    }

    private void d(com.opos.mobad.n.d.d dVar) {
        if (dVar.v != null) {
            this.s.a(p(), dVar.v.f12938a, dVar.v.b);
        }
        if (TextUtils.isEmpty(dVar.l)) {
            return;
        }
        this.h.a(dVar.l, dVar.E, dVar.F);
    }

    public static h e(Context context, int i, m mVar) {
        return new h(context, i, 3, mVar);
    }

    private void e(com.opos.mobad.n.d.d dVar) {
        a(dVar);
        if (t()) {
            b(dVar);
        } else {
            c(dVar);
        }
        d(dVar);
        this.q = q.a(dVar, this.n);
        dVar.u.a(new d.a() { // from class: com.opos.mobad.n.a.h.7
            @Override // com.opos.mobad.n.d.a
            public void a(View view, int[] iArr) {
                if (h.this.j != null) {
                    h.this.a();
                    h.this.j.d(view, iArr);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.i, 22.0f);
        layoutParams.bottomMargin = o();
        this.r = com.opos.mobad.n.e.a(this.k, this.o, layoutParams);
    }

    private void f() {
        final com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.i);
        aVar.a(new a.InterfaceC0508a() { // from class: com.opos.mobad.n.a.h.2
            @Override // com.opos.mobad.c.d.a.InterfaceC0508a
            public void a(boolean z) {
                if (h.this.k == null) {
                    return;
                }
                if (z && h.this.f12815a == 0) {
                    h.this.b();
                    h.this.h.c();
                    if (h.this.j != null) {
                        h.this.j.b();
                    }
                }
                com.opos.cmn.an.f.a.b("LogoSplash", "splashView onWindowVisibilityChanged：" + z);
                boolean z2 = h.this.u <= 0 || h.this.f12815a == 3;
                if (z && z2) {
                    h.this.r();
                    aVar.a((a.InterfaceC0508a) null);
                }
            }
        });
        this.n.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void g() {
        RelativeLayout relativeLayout = new RelativeLayout(this.i);
        this.n = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        n();
        h();
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.h.3
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                h.this.h.b();
                if (h.this.j != null) {
                    h.this.j.g(view, iArr);
                }
            }
        };
        this.n.setOnClickListener(gVar);
        this.n.setOnTouchListener(gVar);
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.i);
        this.o = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        ViewGroup viewGroup = this.p;
        if (viewGroup != null) {
            layoutParams.addRule(2, viewGroup.getId());
        }
        this.n.addView(this.o, layoutParams);
        if (t()) {
            j();
        } else {
            i();
        }
        k();
        m();
    }

    private void i() {
        this.d = new ImageView(this.i);
        this.o.addView(this.d, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void j() {
        this.b = new a(this.i);
        this.d = new ImageView(this.i);
        this.o.addView(this.d, new RelativeLayout.LayoutParams(-1, -1));
        g gVar = new g(this.i);
        this.f12816c = gVar;
        this.o.addView(gVar);
        this.o.addView(this.b);
    }

    private void k() {
        View frameLayout = new FrameLayout(this.i);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{1711276032, 16777215, 16777215, 1711276032});
        gradientDrawable.setGradientType(0);
        frameLayout.setBackground(gradientDrawable);
        this.o.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void l() {
        f a2 = l.a(this.i, this.v);
        this.h = a2;
        a2.a(new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.h.4
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (h.this.j != null) {
                    h.this.j.f(view, iArr);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        int i = this.m;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.i, i != 2 ? (i == 3 || i == 4) ? 37 : 72 : 79);
        this.o.addView(this.h.a(), layoutParams);
    }

    private void m() {
        l();
        this.s = new b(this.i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = o();
        this.o.addView(this.s, layoutParams);
    }

    private void n() {
        FrameLayout frameLayout = new FrameLayout(this.i);
        this.p = frameLayout;
        frameLayout.setId(View.generateViewId());
        this.n.addView(this.p, q.b(this.i));
        this.p.setVisibility(0);
    }

    private int o() {
        return com.opos.cmn.an.h.f.a.a(this.i, this.m != 2 ? 15 : 30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int p() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private void q() {
        this.o.setVisibility(0);
        this.h.a().setVisibility(0);
        this.q.setVisibility(0);
        this.r.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (s()) {
            com.opos.cmn.an.f.a.b("LogoSplash", "handleAdClosed");
            a.InterfaceC0538a interfaceC0538a = this.j;
            if (interfaceC0538a != null) {
                long j = this.g;
                interfaceC0538a.a(j, j);
            }
        }
    }

    private boolean s() {
        View c2 = c();
        return c2 != null && c2.isShown();
    }

    private boolean t() {
        int i = this.m;
        boolean z = true;
        if (i != 1) {
            if (i == 4) {
                return true;
            }
            z = false;
        }
        return z;
    }

    private boolean u() {
        int i = this.m;
        return i == 4 || i == 3;
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        if (this.f12815a != 2 && this.f12815a != 4) {
            this.f12815a = 2;
            this.f.a();
            this.h.d();
            return;
        }
        com.opos.cmn.an.f.a.b("LogoSplash", "current state has stop =" + this.f12815a);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.s.a(interfaceC0538a);
        this.j = interfaceC0538a;
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        String str;
        com.opos.mobad.n.d.d a2 = hVar.a();
        if (a2 == null || a2.u == null) {
            str = "adShowData is null";
        } else if (t() && (a2.m == null || TextUtils.isEmpty(a2.m.f12945a))) {
            str = "iconUrl is null";
        } else if (t() || (a2.g != null && a2.g.size() > 0)) {
            com.opos.cmn.an.f.a.b("LogoSplash", "render");
            this.k = a2;
            this.t = a2.u;
            long j = a2.w;
            this.u = j;
            if (j <= 0) {
                this.u = com.anythink.expressad.video.module.a.a.m.ag;
            }
            this.g = this.u;
            e(a2);
            return;
        } else {
            str = "imgList is null";
        }
        com.opos.cmn.an.f.a.b("LogoSplash", str);
        this.j.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        q();
        com.opos.cmn.an.f.a.b("LogoSplash", "start countdown...");
        if (this.f12815a != 1 && this.f12815a != 4) {
            this.f12815a = 1;
            this.f.a(0L);
            this.h.e();
            return;
        }
        com.opos.cmn.an.f.a.b("LogoSplash", "error state" + this.f12815a);
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.n;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("LogoSplash", "destroy");
        this.h.f();
        a();
        this.k = null;
        this.f12815a = 4;
        this.f.a();
        this.f.b();
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.l;
    }
}
