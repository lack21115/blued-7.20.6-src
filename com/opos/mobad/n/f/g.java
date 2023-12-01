package com.opos.mobad.n.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.a;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.a.t;
import com.opos.mobad.n.c.m;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/f/g.class */
public class g implements com.opos.mobad.n.a {

    /* renamed from: a  reason: collision with root package name */
    private static int f13019a = 0;
    private static int b = 1;
    private c A;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13020c;
    private RelativeLayout g;
    private RelativeLayout h;
    private Context i;
    private a.InterfaceC0538a j;
    private View k;
    private int l;
    private View m;
    private ProgressBar n;
    private View o;
    private k p;
    private com.opos.mobad.c.c.a q;
    private int s;
    private com.opos.mobad.n.d.e w;
    private int x;
    private t y;
    private com.opos.mobad.c.a z;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean r = false;
    private boolean t = false;
    private Runnable u = new Runnable() { // from class: com.opos.mobad.n.f.g.1
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.r) {
                return;
            }
            if (g.this.j != null) {
                g.this.j.d(g.this.q.d(), g.this.q.c());
            }
            g.this.n.setProgress(g.this.f());
            com.opos.cmn.an.f.a.b("InterstitialPortVideo", "on progress" + g.this.n.getProgress());
            g.this.v.postDelayed(this, 500L);
        }
    };
    private com.opos.mobad.c.c.b B = new com.opos.mobad.c.c.b() { // from class: com.opos.mobad.n.f.g.3
        @Override // com.opos.mobad.c.c.b
        public void a(int i, String str) {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onError:" + i + "," + str);
            if (g.this.j != null) {
                g.this.j.a(i, str);
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void c() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPrepare");
            g.this.m();
            if (g.this.j != null) {
                g.this.j.d(0L, g.this.q.c());
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void d() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onStart");
            g.this.v.removeCallbacks(g.this.u);
            g.this.v.postDelayed(g.this.u, 500L);
            g.this.j.d(g.this.q.d(), g.this.q.c());
            g.this.n.setProgress(0);
            g.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void e() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onComplete");
            if (g.this.j != null) {
                g.this.j.a(g.this.q.c(), g.this.q.c());
            }
            g.this.v.removeCallbacks(g.this.u);
            g.this.k();
        }

        @Override // com.opos.mobad.c.c.b
        public void f() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onResume");
            g.this.t = false;
            g.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void g() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPause");
            g.this.o.setVisibility(0);
        }

        @Override // com.opos.mobad.c.c.b
        public void h() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingStart");
            g.this.j();
        }

        @Override // com.opos.mobad.c.c.b
        public void i() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingEnd");
            g.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void j() {
        }
    };
    private Handler v = new Handler(Looper.getMainLooper());

    public g(Context context, int i, t tVar, int i2, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        boolean z = false;
        this.i = context;
        this.x = i;
        this.g = new RelativeLayout(context);
        this.q = aVar;
        aVar.a(this.B);
        this.s = i2;
        this.y = tVar;
        this.z = aVar2;
        this.f13020c = m.a(context, 2.12f) >= 0 ? true : z;
        a(tVar, i2);
        g();
        h();
    }

    public static final com.opos.mobad.n.a a(Context context, int i, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new g(context.getApplicationContext(), i, new t(275, 155, t.a.BELOW), f13019a, aVar, aVar2);
    }

    private void a(t tVar, int i) {
        RelativeLayout.LayoutParams layoutParams;
        this.h = new RelativeLayout(this.i);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.i, 275.0f), com.opos.cmn.an.h.f.a.a(this.i, 489.0f));
        layoutParams2.addRule(13);
        this.g.addView(this.h, layoutParams2);
        this.k = this.q.b();
        this.q.d(-16777216);
        this.k.setBackgroundColor(-16777216);
        int generateViewId = View.generateViewId();
        this.l = generateViewId;
        this.k.setId(generateViewId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.i, tVar.f12872a), com.opos.cmn.an.h.f.a.a(this.i, tVar.b));
        layoutParams3.addRule(10);
        this.h.addView(this.k, layoutParams3);
        FrameLayout frameLayout = new FrameLayout(this.i);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(7, this.l);
        layoutParams4.addRule(5, this.l);
        layoutParams4.addRule(6, this.l);
        layoutParams4.addRule(8, this.l);
        this.h.addView(frameLayout, layoutParams4);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.g.4
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (g.this.j != null) {
                    g.this.j.e(view, iArr);
                }
            }
        };
        frameLayout.setOnTouchListener(gVar);
        frameLayout.setOnClickListener(gVar);
        this.m = new ProgressBar(this.i);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.i, 30.0f), com.opos.cmn.an.h.f.a.a(this.i, 39.0f));
        layoutParams5.gravity = 17;
        this.m.setVisibility(0);
        frameLayout.addView(this.m, layoutParams5);
        View view = new View(this.i);
        this.o = view;
        view.setBackground(this.i.getResources().getDrawable(R.drawable.opos_mobad_continue_bn));
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.i, 60.0f), com.opos.cmn.an.h.f.a.a(this.i, 60.0f));
        layoutParams6.gravity = 17;
        this.o.setVisibility(4);
        frameLayout.addView(this.o, layoutParams6);
        if (i == b) {
            this.p = this.f13020c ? k.a(this.i, 44, 14, 12, -1946157056) : k.c(this.i, 44, 14, 12, -1946157056);
            layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.i, 76.0f));
            layoutParams.addRule(8, this.l);
            layoutParams.addRule(7, this.l);
            layoutParams.addRule(5, this.l);
        } else {
            this.p = this.f13020c ? k.b(this.i, 64, 18, 14, -1) : k.d(this.i, 67, 24, 14, -1);
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, this.l);
        }
        this.h.addView(this.p, layoutParams);
        com.opos.mobad.n.c.g gVar2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.g.5
            @Override // com.opos.mobad.n.c.g
            public void a(View view2, int[] iArr) {
                if (g.this.j != null) {
                    g.this.j.g(view2, iArr);
                }
            }
        };
        this.p.setOnClickListener(gVar2);
        this.p.setOnTouchListener(gVar2);
        com.opos.mobad.n.c.g gVar3 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.g.6
            @Override // com.opos.mobad.n.c.g
            public void a(View view2, int[] iArr) {
                if (g.this.j != null) {
                    g.this.j.f(view2, iArr);
                }
            }
        };
        this.p.c().setOnClickListener(gVar3);
        this.p.c().setOnTouchListener(gVar3);
        ProgressBar progressBar = new ProgressBar(this.i);
        this.n = progressBar;
        progressBar.setId(View.generateViewId());
        m.a(this.n, "mOnlyIndeterminate", new Boolean(false));
        this.n.setIndeterminate(false);
        this.n.setProgressDrawable(new ClipDrawable(new ColorDrawable(-1), 3, 1));
        this.n.setBackgroundColor(0);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.i, 2.0f));
        layoutParams7.addRule(8, this.l);
        layoutParams7.addRule(7, this.l);
        layoutParams7.addRule(5, this.l);
        this.n.setVisibility(0);
        this.h.addView(this.n, layoutParams7);
    }

    private void a(com.opos.mobad.n.d.e eVar) {
        if (this.w != null) {
            return;
        }
        this.A.a(eVar.f, eVar.e, eVar.l);
        if (eVar.m == null || TextUtils.isEmpty(eVar.m.f12945a)) {
            this.p.a();
            return;
        }
        int a2 = com.opos.cmn.an.h.f.a.a(this.i, 44.0f);
        this.z.a(eVar.m.f12945a, eVar.m.b, a2, a2, new a.InterfaceC0506a() { // from class: com.opos.mobad.n.f.g.7
            @Override // com.opos.mobad.c.a.InterfaceC0506a
            public void a(int i, final Bitmap bitmap) {
                if (g.this.r) {
                    return;
                }
                if (i != 0 && i != 1) {
                    if (g.this.j != null) {
                        g.this.j.c(i);
                        return;
                    }
                    return;
                }
                if (i == 1 && g.this.j != null) {
                    g.this.j.c(i);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.g.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (g.this.r || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        g.this.A.a(bitmap);
                    }
                });
            }
        });
    }

    public static final com.opos.mobad.n.a b(Context context, int i, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new g(context.getApplicationContext(), i, new t(275, 489, t.a.BELOW), b, aVar, aVar2);
    }

    private void b(com.opos.mobad.n.d.e eVar) {
        if (this.w != null) {
            return;
        }
        int i = eVar.A;
        if (this.s == f13019a) {
            i = 0;
        }
        this.p.a(eVar.f, eVar.e, eVar.l, i);
        if (eVar.m == null || TextUtils.isEmpty(eVar.m.f12945a)) {
            this.p.a();
            return;
        }
        int a2 = com.opos.cmn.an.h.f.a.a(this.i, 44.0f);
        this.z.a(eVar.m.f12945a, eVar.m.b, a2, a2, new a.InterfaceC0506a() { // from class: com.opos.mobad.n.f.g.8
            @Override // com.opos.mobad.c.a.InterfaceC0506a
            public void a(int i2, final Bitmap bitmap) {
                if (g.this.r) {
                    return;
                }
                if (i2 != 0 && i2 != 1) {
                    if (g.this.j != null) {
                        g.this.j.c(i2);
                        return;
                    }
                    return;
                }
                if (i2 == 1 && g.this.j != null) {
                    g.this.j.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.g.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (g.this.r || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        g.this.p.a(bitmap);
                    }
                });
            }
        });
    }

    private void c(com.opos.mobad.n.d.e eVar) {
        this.q.a(eVar.f12942a.f12945a, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f() {
        if (0 == this.q.c()) {
            return 0;
        }
        return (int) Math.min(100L, Math.max(0L, (this.q.d() * 100) / this.q.c()));
    }

    private void g() {
        this.A = this.s == b ? this.f13020c ? c.a(this.i) : c.c(this.i) : this.f13020c ? c.b(this.i) : c.d(this.i);
    }

    private void h() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.i);
        aVar.a(new a.InterfaceC0508a() { // from class: com.opos.mobad.n.f.g.2
            @Override // com.opos.mobad.c.d.a.InterfaceC0508a
            public void a(boolean z) {
                if (g.this.w == null) {
                    return;
                }
                if (!z) {
                    g.this.q.f();
                    return;
                }
                g.this.l();
                if (g.this.q.i() != 5) {
                    if (g.this.q.i() == 3 && g.this.t) {
                        com.opos.cmn.an.f.a.b("InterstitialPortVideo", "resume but user pause");
                    } else {
                        g.this.q.g();
                    }
                }
            }
        });
        this.g.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.m.setVisibility(8);
        this.o.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.m.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.d = true;
        this.n.setProgress(100);
        if (this.s == b) {
            this.p.setVisibility(4);
        }
        if (this.h.indexOfChild(this.A) < 0) {
            this.h.addView(this.A);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (!this.f || this.e) {
            this.e = true;
            return;
        }
        a.InterfaceC0538a interfaceC0538a = this.j;
        if (interfaceC0538a != null) {
            interfaceC0538a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.f = true;
        a.InterfaceC0538a interfaceC0538a = this.j;
        if (interfaceC0538a != null) {
            interfaceC0538a.e();
            if (this.e) {
                this.j.b();
            }
        }
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        com.opos.cmn.an.f.a.b("InterstitialPortVideo", "stop");
        if (this.d) {
            com.opos.cmn.an.f.a.b("InterstitialPortVideo", "do nothing for has complete");
            return;
        }
        this.t = true;
        this.q.f();
        this.v.removeCallbacks(this.u);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.j = interfaceC0538a;
        this.A.a(interfaceC0538a);
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.mobad.n.d.e b2 = hVar.b();
        if (b2 == null) {
            com.opos.cmn.an.f.a.d("InterstitialPortVideo", "render with data null");
            a.InterfaceC0538a interfaceC0538a = this.j;
            if (interfaceC0538a != null) {
                interfaceC0538a.b(1);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(b2.f12942a.f12945a) && this.w == null) {
            c(b2);
        }
        this.q.a(b2.B == 1 ? 1.0f : 0.0f);
        b(b2);
        a(b2);
        this.w = b2;
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        com.opos.cmn.an.f.a.b("InterstitialPortVideo", "start");
        if (this.d) {
            com.opos.cmn.an.f.a.b("InterstitialPortVideo", "do nothing for has complete");
            return;
        }
        this.q.g();
        this.v.post(this.u);
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.g;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        this.w = null;
        com.opos.mobad.c.c.a aVar = this.q;
        if (aVar != null) {
            aVar.f();
            this.q.h();
        }
        this.r = true;
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.x;
    }
}
