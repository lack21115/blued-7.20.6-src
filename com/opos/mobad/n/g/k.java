package com.opos.mobad.n.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.j;
import com.opos.mobad.n.g.af;
import com.opos.mobad.n.g.ag;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/k.class */
public class k implements com.opos.mobad.n.a {
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f26859c;
    private int d;
    private int e;
    private Context g;
    private a.InterfaceC0708a h;
    private int i;
    private af j;
    private com.opos.mobad.n.c.h k;
    private RelativeLayout l;
    private t m;
    private z n;
    private RelativeLayout o;
    private ag p;
    private com.opos.mobad.n.c.j q;
    private com.opos.mobad.c.a r;
    private com.opos.mobad.n.d.e t;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f26858a = false;
    private int f = 64;
    private boolean u = false;
    private Runnable v = new Runnable() { // from class: com.opos.mobad.n.g.k.1
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.f26858a) {
                return;
            }
            int g = k.this.p.g();
            int h = k.this.p.h();
            if (k.this.h != null) {
                k.this.h.d(g, h);
            }
            k.this.p.f();
            k.this.s.postDelayed(this, 500L);
        }
    };
    private Handler s = new Handler(Looper.getMainLooper());

    private k(Context context, aj ajVar, int i, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        this.g = context;
        this.i = i;
        this.r = aVar2;
        f();
        a(ajVar, aVar);
        k();
    }

    public static k a(Context context, aj ajVar, int i, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new k(context, ajVar, i, aVar, aVar2);
    }

    private void a(com.opos.mobad.c.c.a aVar) {
        RelativeLayout relativeLayout = new RelativeLayout(this.g);
        this.l = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f26859c);
        this.l.setVisibility(4);
        this.k.addView(this.l, layoutParams);
        b(aVar);
        h();
        i();
    }

    private void a(com.opos.mobad.n.d.e eVar) {
        b(eVar);
        c(eVar);
        d(eVar);
    }

    private void a(aj ajVar, com.opos.mobad.c.c.a aVar) {
        aj ajVar2 = ajVar;
        if (ajVar == null) {
            ajVar2 = aj.a(this.g);
        }
        Context context = this.g;
        int i = ajVar2.f26797a;
        int i2 = ajVar2.b;
        int i3 = this.b;
        this.q = new com.opos.mobad.n.c.j(context, new j.a(i, i2, i3, i3 / this.d));
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.g);
        this.k = hVar;
        hVar.a(com.opos.cmn.an.h.f.a.a(this.g, 14.0f));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, this.d);
        layoutParams.width = this.b;
        layoutParams.height = this.d;
        this.k.setId(View.generateViewId());
        this.k.setBackgroundColor(this.g.getResources().getColor(R.color.opos_mobad_root_bg_color));
        this.k.setLayoutParams(layoutParams);
        this.k.setVisibility(8);
        this.q.addView(this.k, layoutParams);
        this.q.setLayoutParams(layoutParams);
        a(aVar);
        j();
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.k.3
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (k.this.h != null) {
                    k.this.h.g(view, iArr);
                }
            }
        };
        this.k.setOnClickListener(gVar);
        this.k.setOnTouchListener(gVar);
    }

    private void b(com.opos.mobad.c.c.a aVar) {
        this.p = ag.a(this.g, this.b, this.f26859c, aVar);
        this.l.addView(this.p, new RelativeLayout.LayoutParams(this.b, this.f26859c));
        this.p.a(new ag.a() { // from class: com.opos.mobad.n.g.k.4
            @Override // com.opos.mobad.n.g.ag.a
            public void a() {
                k.this.s.removeCallbacks(k.this.v);
                k.this.s.postDelayed(k.this.v, 500L);
            }

            @Override // com.opos.mobad.n.g.ag.a
            public void b() {
                k.this.s.removeCallbacks(k.this.v);
            }
        });
    }

    private void b(com.opos.mobad.n.d.e eVar) {
        this.m.a(eVar.m, eVar.l, eVar.f, eVar.e, this.r, this.f26858a);
    }

    private void c(com.opos.mobad.n.d.e eVar) {
        this.j.a(eVar.r, eVar.s, eVar.i, eVar.j, eVar.k, eVar.B);
    }

    private void d(com.opos.mobad.n.d.e eVar) {
        com.opos.mobad.n.d.a aVar = eVar.v;
        if (aVar == null || TextUtils.isEmpty(aVar.f26626a) || TextUtils.isEmpty(aVar.b)) {
            return;
        }
        RelativeLayout relativeLayout = this.o;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        z zVar = this.n;
        if (zVar != null) {
            zVar.setVisibility(0);
            this.n.a(aVar.f26626a, aVar.b);
        }
    }

    private void f() {
        this.b = com.opos.cmn.an.h.f.a.a(this.g, 256.0f);
        this.f26859c = com.opos.cmn.an.h.f.a.a(this.g, 144.0f);
        this.d = com.opos.cmn.an.h.f.a.a(this.g, 218.0f);
        this.e = this.b;
        this.f = com.opos.cmn.an.h.f.a.a(this.g, 64.0f);
    }

    private void g() {
        RelativeLayout relativeLayout = new RelativeLayout(this.g);
        this.o = relativeLayout;
        relativeLayout.setBackgroundResource(R.drawable.opos_mobad_drawable_shape_gradient);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f);
        this.o.setVisibility(4);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 2.0f);
        this.l.addView(this.o, layoutParams);
    }

    private void h() {
        this.j = af.a(this.g, true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        this.j.setVisibility(4);
        this.l.addView(this.j, layoutParams);
    }

    private void i() {
        g();
        this.n = z.a(this.g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 10.0f);
        this.n.setGravity(1);
        this.n.setVisibility(4);
        this.l.addView(this.n, layoutParams);
    }

    private void j() {
        t a2 = t.a(this.g);
        this.m = a2;
        a2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, com.opos.cmn.an.h.f.a.a(this.g, 74.0f));
        RelativeLayout relativeLayout = this.l;
        if (relativeLayout != null) {
            layoutParams.addRule(3, relativeLayout.getId());
        }
        this.m.setVisibility(4);
        this.k.addView(this.m, layoutParams);
    }

    private void k() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.g);
        aVar.a(new a.InterfaceC0678a() { // from class: com.opos.mobad.n.g.k.5
            @Override // com.opos.mobad.c.d.a.InterfaceC0678a
            public void a(boolean z) {
                if (k.this.t == null) {
                    return;
                }
                if (z && !k.this.u) {
                    k.this.u = true;
                    k.this.l();
                    if (k.this.h != null) {
                        k.this.h.b();
                    }
                }
                if (z) {
                    k.this.p.d();
                } else {
                    k.this.p.e();
                }
            }
        });
        this.k.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        this.j.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        if (!this.f26858a) {
            this.p.a();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo1", "current state has stop mDestroy = " + this.f26858a);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.h = interfaceC0708a;
        this.n.a(interfaceC0708a);
        this.m.a(interfaceC0708a);
        this.j.a(interfaceC0708a);
        this.p.a(interfaceC0708a);
        this.j.a(new af.a() { // from class: com.opos.mobad.n.g.k.2
            @Override // com.opos.mobad.n.g.af.a
            public void a(int i) {
                k.this.p.a(i);
            }
        });
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0708a interfaceC0708a;
        com.opos.mobad.n.d.e b = hVar.b();
        if (b == null) {
            com.opos.cmn.an.f.a.d("", "render with data null");
            a.InterfaceC0708a interfaceC0708a2 = this.h;
            if (interfaceC0708a2 != null) {
                interfaceC0708a2.b(1);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(b.f26630a.f26633a) && this.t == null) {
            this.p.a(b);
        }
        if (this.t == null && (interfaceC0708a = this.h) != null) {
            interfaceC0708a.e();
        }
        this.t = b;
        com.opos.mobad.n.c.j jVar = this.q;
        if (jVar != null && jVar.getVisibility() != 0) {
            this.q.setVisibility(0);
        }
        com.opos.mobad.n.c.h hVar2 = this.k;
        if (hVar2 != null && hVar2.getVisibility() != 0) {
            this.k.setVisibility(0);
        }
        a(b);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo1", "start countdown...");
        if (!this.f26858a) {
            this.p.b();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo1", "error state mDestroy " + this.f26858a);
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.q;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo1", "destroy");
        this.f26858a = true;
        this.p.c();
        this.t = null;
        this.s.removeCallbacks(this.v);
        com.opos.mobad.n.c.j jVar = this.q;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.i;
    }
}
