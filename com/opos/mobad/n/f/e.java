package com.opos.mobad.n.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.a;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.a.t;
import com.opos.mobad.n.c.m;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/f/e.class */
public class e implements com.opos.mobad.n.a {

    /* renamed from: a  reason: collision with root package name */
    private static int f12993a = 0;
    private static int b = 1;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.mobad.c.a f12994c;
    private RelativeLayout e;
    private RelativeLayout f;
    private Context g;
    private a.InterfaceC0538a h;
    private View i;
    private int j;
    private View k;
    private ProgressBar l;
    private View m;
    private k n;
    private com.opos.mobad.c.c.a o;
    private int q;
    private com.opos.mobad.n.d.e v;
    private int w;
    private t x;
    private c z;
    private boolean d = false;
    private boolean p = false;
    private boolean r = false;
    private boolean s = false;
    private Runnable t = new Runnable() { // from class: com.opos.mobad.n.f.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.p) {
                return;
            }
            if (e.this.h != null) {
                e.this.h.d(e.this.o.d(), e.this.o.c());
            }
            e.this.l.setProgress(e.this.f());
            com.opos.cmn.an.f.a.b("InterstitialLandVideo", "on progress" + e.this.l.getProgress());
            e.this.u.postDelayed(this, 500L);
        }
    };
    private boolean y = false;
    private com.opos.mobad.c.c.b A = new com.opos.mobad.c.c.b() { // from class: com.opos.mobad.n.f.e.3
        @Override // com.opos.mobad.c.c.b
        public void a(int i, String str) {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onError:" + i + "," + str);
            if (e.this.h != null) {
                e.this.h.a(i, str);
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void c() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPrepare");
            e.this.m();
            if (e.this.h != null) {
                e.this.h.d(0L, e.this.o.c());
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void d() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onStart");
            e.this.u.removeCallbacks(e.this.t);
            e.this.u.postDelayed(e.this.t, 500L);
            e.this.h.d(e.this.o.d(), e.this.o.c());
            e.this.l.setProgress(0);
            e.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void e() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onComplete");
            if (e.this.h != null) {
                e.this.h.a(e.this.o.c(), e.this.o.c());
            }
            e.this.u.removeCallbacks(e.this.t);
            e.this.k();
        }

        @Override // com.opos.mobad.c.c.b
        public void f() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onResume");
            e.this.y = false;
            e.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void g() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPause");
            e.this.m.setVisibility(0);
        }

        @Override // com.opos.mobad.c.c.b
        public void h() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingStart");
            e.this.j();
        }

        @Override // com.opos.mobad.c.c.b
        public void i() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingEnd");
            e.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void j() {
            if (e.this.v == null) {
                return;
            }
            e eVar = e.this;
            eVar.b(eVar.v);
        }
    };
    private Bitmap B = null;
    private Handler u = new Handler(Looper.getMainLooper());

    public e(Context context, int i, t tVar, int i2, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        this.g = context;
        this.w = i;
        this.e = new RelativeLayout(context);
        this.o = aVar;
        aVar.a(this.A);
        this.q = i2;
        this.x = tVar;
        this.f12994c = aVar2;
        a(tVar, i2);
        g();
        h();
    }

    public static final com.opos.mobad.n.a a(Context context, int i, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new e(context.getApplicationContext(), i, new t(489, 275, t.a.RIGHT), f12993a, aVar, aVar2);
    }

    private void a(t tVar, int i) {
        this.j = View.generateViewId();
        RelativeLayout relativeLayout = new RelativeLayout(this.g);
        this.f = relativeLayout;
        relativeLayout.setId(this.j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 489.0f), com.opos.cmn.an.h.f.a.a(this.g, 275.0f));
        layoutParams.addRule(13);
        this.e.addView(this.f, layoutParams);
        this.e.setBackgroundColor(-16777216);
        this.i = this.o.b();
        this.o.d(-16777216);
        this.i.setBackgroundColor(-16777216);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, tVar.f12872a), com.opos.cmn.an.h.f.a.a(this.g, tVar.b));
        layoutParams2.addRule(13);
        this.f.addView(this.i, layoutParams2);
        View view = new View(this.g);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(7, this.j);
        layoutParams3.addRule(5, this.j);
        layoutParams3.addRule(6, this.j);
        layoutParams3.addRule(8, this.j);
        this.f.addView(view, layoutParams3);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.e.4
            @Override // com.opos.mobad.n.c.g
            public void a(View view2, int[] iArr) {
                if (e.this.h != null) {
                    e.this.h.e(view2, iArr);
                }
            }
        };
        view.setOnTouchListener(gVar);
        view.setOnClickListener(gVar);
        this.k = new ProgressBar(this.g);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 30.0f), com.opos.cmn.an.h.f.a.a(this.g, 39.0f));
        layoutParams4.addRule(13);
        this.k.setVisibility(0);
        this.f.addView(this.k, layoutParams4);
        View view2 = new View(this.g);
        this.m = view2;
        view2.setBackground(this.g.getResources().getDrawable(R.drawable.opos_mobad_continue_bn));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 60.0f), com.opos.cmn.an.h.f.a.a(this.g, 60.0f));
        layoutParams5.addRule(13);
        this.m.setVisibility(4);
        this.f.addView(this.m, layoutParams5);
        this.n = k.e(this.g, 36, 12, 10, -1275068416);
        com.opos.mobad.n.c.g gVar2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.e.5
            @Override // com.opos.mobad.n.c.g
            public void a(View view3, int[] iArr) {
                if (e.this.h != null) {
                    e.this.h.g(view3, iArr);
                }
            }
        };
        this.n.setOnClickListener(gVar2);
        this.n.setOnTouchListener(gVar2);
        com.opos.mobad.n.c.g gVar3 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.e.6
            @Override // com.opos.mobad.n.c.g
            public void a(View view3, int[] iArr) {
                if (e.this.h != null) {
                    e.this.h.f(view3, iArr);
                }
            }
        };
        this.n.c().setOnClickListener(gVar3);
        this.n.c().setOnTouchListener(gVar3);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.g, 68.0f));
        layoutParams6.addRule(12);
        this.f.addView(this.n, layoutParams6);
        ProgressBar progressBar = new ProgressBar(this.g);
        this.l = progressBar;
        progressBar.setId(View.generateViewId());
        m.a(this.l, "mOnlyIndeterminate", new Boolean(false));
        this.l.setIndeterminate(false);
        this.l.setProgressDrawable(new ClipDrawable(new ColorDrawable(-1), 3, 1));
        this.l.setBackgroundColor(0);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.g, 2.0f));
        layoutParams7.addRule(12);
        this.l.setVisibility(0);
        this.f.addView(this.l, layoutParams7);
    }

    private void a(com.opos.mobad.n.d.e eVar) {
        if (this.v != null) {
            return;
        }
        b(eVar);
    }

    public static final com.opos.mobad.n.a b(Context context, int i, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new e(context.getApplicationContext(), i, new t(155, 275, t.a.RIGHT), b, aVar, aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.opos.mobad.n.d.e eVar) {
        if (this.q == b) {
            if (this.B != null) {
                this.f.setBackground(new BitmapDrawable(this.B));
            } else {
                m.a(this.o, eVar.f12942a.f12945a, new m.a() { // from class: com.opos.mobad.n.f.e.7
                    @Override // com.opos.mobad.n.c.m.a
                    public void a() {
                    }

                    @Override // com.opos.mobad.n.c.m.a
                    public void a(Bitmap bitmap) {
                        if (e.this.p) {
                            return;
                        }
                        e eVar2 = e.this;
                        eVar2.B = com.opos.mobad.n.c.d.a(eVar2.g, bitmap, 75, 0.25f, 56.0f);
                        com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.n.f.e.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (e.this.p) {
                                    return;
                                }
                                e.this.f.setBackground(new BitmapDrawable(e.this.B));
                            }
                        });
                    }
                });
            }
        }
    }

    private void c(com.opos.mobad.n.d.e eVar) {
        this.z.a(eVar.f, eVar.e, eVar.l);
        if (this.v != null) {
            return;
        }
        if (eVar.m == null || TextUtils.isEmpty(eVar.m.f12945a)) {
            this.n.a();
            return;
        }
        int a2 = com.opos.cmn.an.h.f.a.a(this.g, 44.0f);
        this.f12994c.a(eVar.m.f12945a, eVar.m.b, a2, a2, new a.InterfaceC0506a() { // from class: com.opos.mobad.n.f.e.8
            @Override // com.opos.mobad.c.a.InterfaceC0506a
            public void a(int i, final Bitmap bitmap) {
                if (i != 0 && i != 1) {
                    if (e.this.h != null) {
                        e.this.h.c(i);
                        return;
                    }
                    return;
                }
                if (i == 1 && e.this.h != null) {
                    e.this.h.c(i);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.e.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (e.this.p || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        e.this.z.a(bitmap);
                    }
                });
            }
        });
    }

    private void d(com.opos.mobad.n.d.e eVar) {
        this.n.a(eVar.f, eVar.e, eVar.l, eVar.A);
        if (this.v != null) {
            return;
        }
        if (eVar.m == null || TextUtils.isEmpty(eVar.m.f12945a)) {
            this.n.a();
            return;
        }
        int a2 = com.opos.cmn.an.h.f.a.a(this.g, 44.0f);
        this.f12994c.a(eVar.m.f12945a, eVar.m.b, a2, a2, new a.InterfaceC0506a() { // from class: com.opos.mobad.n.f.e.9
            @Override // com.opos.mobad.c.a.InterfaceC0506a
            public void a(int i, final Bitmap bitmap) {
                if (i != 0 && i != 1) {
                    if (e.this.h != null) {
                        e.this.h.c(i);
                    }
                } else if (e.this.p || bitmap == null || bitmap.isRecycled()) {
                } else {
                    if (i == 1 && e.this.h != null) {
                        e.this.h.c(i);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.e.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.p) {
                                return;
                            }
                            e.this.n.a(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void e(com.opos.mobad.n.d.e eVar) {
        this.o.a(eVar.f12942a.f12945a, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f() {
        if (0 == this.o.c()) {
            return 0;
        }
        return (int) Math.min(100L, Math.max(0L, (this.o.d() * 100) / this.o.c()));
    }

    private void g() {
        this.z = this.q == b ? c.f(this.g) : c.e(this.g);
    }

    private void h() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.g);
        aVar.a(new a.InterfaceC0508a() { // from class: com.opos.mobad.n.f.e.2
            @Override // com.opos.mobad.c.d.a.InterfaceC0508a
            public void a(boolean z) {
                if (e.this.v == null) {
                    return;
                }
                if (!z) {
                    e.this.o.f();
                    return;
                }
                e.this.l();
                if (e.this.o.i() != 5) {
                    if (e.this.o.i() == 3 && e.this.y) {
                        com.opos.cmn.an.f.a.b("InterstitialLandVideo", "resume but user pause");
                    } else {
                        e.this.o.g();
                    }
                }
            }
        });
        this.e.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.k.setVisibility(8);
        this.m.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.k.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.d = true;
        this.l.setProgress(100);
        this.n.setVisibility(4);
        if (this.f.indexOfChild(this.z) < 0) {
            this.f.addView(this.z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (!this.s || this.r) {
            this.r = true;
            return;
        }
        a.InterfaceC0538a interfaceC0538a = this.h;
        if (interfaceC0538a != null) {
            interfaceC0538a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.s = true;
        a.InterfaceC0538a interfaceC0538a = this.h;
        if (interfaceC0538a != null) {
            interfaceC0538a.e();
            if (this.r) {
                this.h.b();
            }
        }
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        if (this.d) {
            com.opos.cmn.an.f.a.b("InterstitialLandVideo", "do no stop for has complete");
            return;
        }
        this.y = true;
        this.o.f();
        this.u.removeCallbacks(this.t);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.h = interfaceC0538a;
        this.z.a(interfaceC0538a);
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.mobad.n.d.e b2 = hVar.b();
        if (b2 == null) {
            com.opos.cmn.an.f.a.d("InterstitialLandVideo", "render with data null");
            a.InterfaceC0538a interfaceC0538a = this.h;
            if (interfaceC0538a != null) {
                interfaceC0538a.b(1);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(b2.f12942a.f12945a) && this.v == null) {
            e(b2);
        }
        this.o.a(b2.B == 1 ? 1.0f : 0.0f);
        d(b2);
        a(b2);
        c(b2);
        this.v = b2;
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        if (this.d) {
            com.opos.cmn.an.f.a.b("InterstitialLandVideo", "do no start for has complete");
            return;
        }
        this.o.g();
        this.u.post(this.t);
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.e;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        this.v = null;
        com.opos.mobad.c.c.a aVar = this.o;
        if (aVar != null) {
            aVar.f();
            this.o.h();
        }
        this.p = true;
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.w;
    }
}
