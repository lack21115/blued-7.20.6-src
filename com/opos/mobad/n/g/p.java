package com.opos.mobad.n.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.j;
import com.opos.mobad.n.g.af;
import com.opos.mobad.n.g.ag;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/p.class */
public class p implements com.opos.mobad.n.a {
    private int d;
    private Context e;
    private a.InterfaceC0708a f;
    private int g;
    private af h;
    private RelativeLayout i;
    private com.opos.mobad.n.c.h j;
    private u k;
    private z l;
    private ag m;
    private com.opos.mobad.n.c.j n;
    private com.opos.mobad.c.a o;
    private com.opos.mobad.n.d.e q;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f26895a = false;
    private int b = 256;

    /* renamed from: c  reason: collision with root package name */
    private int f26896c = 144;
    private boolean r = false;
    private Runnable s = new Runnable() { // from class: com.opos.mobad.n.g.p.1
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.f26895a) {
                return;
            }
            int g = p.this.m.g();
            int h = p.this.m.h();
            if (p.this.f != null) {
                p.this.f.d(g, h);
            }
            p.this.m.f();
            p.this.p.postDelayed(this, 500L);
        }
    };
    private Handler p = new Handler(Looper.getMainLooper());

    private p(Context context, aj ajVar, int i, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        this.e = context;
        this.g = i;
        this.o = aVar2;
        f();
        a(ajVar, aVar);
        j();
    }

    public static p a(Context context, aj ajVar, int i, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new p(context, ajVar, i, aVar, aVar2);
    }

    private void a(com.opos.mobad.c.c.a aVar) {
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.e);
        this.j = hVar;
        hVar.a(com.opos.cmn.an.h.f.a.a(this.e, 14.0f));
        this.j.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f26896c);
        this.j.setVisibility(4);
        this.i.addView(this.j, layoutParams);
        b(aVar);
        h();
        g();
    }

    private void a(com.opos.mobad.n.d.e eVar) {
        b(eVar);
        c(eVar);
        d(eVar);
    }

    private void a(aj ajVar, com.opos.mobad.c.c.a aVar) {
        aj ajVar2 = ajVar;
        if (ajVar == null) {
            ajVar2 = aj.a(this.e);
        }
        Context context = this.e;
        int i = ajVar2.f26797a;
        int i2 = ajVar2.b;
        int i3 = this.b;
        this.n = new com.opos.mobad.n.c.j(context, new j.a(i, i2, i3, i3 / this.d));
        this.i = new RelativeLayout(this.e);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, -2);
        layoutParams.width = this.b;
        layoutParams.height = -2;
        this.i.setId(View.generateViewId());
        this.i.setLayoutParams(layoutParams);
        this.i.setVisibility(8);
        this.n.addView(this.i, layoutParams);
        this.n.setLayoutParams(layoutParams);
        a(aVar);
        i();
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.p.3
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (p.this.f != null) {
                    p.this.f.g(view, iArr);
                }
            }
        };
        this.i.setOnClickListener(gVar);
        this.i.setOnTouchListener(gVar);
    }

    private void b(com.opos.mobad.c.c.a aVar) {
        this.m = ag.a(this.e, this.b, this.f26896c, aVar);
        this.j.addView(this.m, new RelativeLayout.LayoutParams(this.b, this.f26896c));
        this.m.a(new ag.a() { // from class: com.opos.mobad.n.g.p.4
            @Override // com.opos.mobad.n.g.ag.a
            public void a() {
                p.this.p.removeCallbacks(p.this.s);
                p.this.p.postDelayed(p.this.s, 500L);
            }

            @Override // com.opos.mobad.n.g.ag.a
            public void b() {
                p.this.p.removeCallbacks(p.this.s);
            }
        });
    }

    private void b(com.opos.mobad.n.d.e eVar) {
        this.k.a(eVar.l, eVar.f);
    }

    private void c(com.opos.mobad.n.d.e eVar) {
        this.h.a(eVar.r, eVar.s, eVar.i, eVar.j, eVar.k, eVar.B);
    }

    private void d(com.opos.mobad.n.d.e eVar) {
        z zVar;
        com.opos.mobad.n.d.a aVar = eVar.v;
        if (aVar == null || TextUtils.isEmpty(aVar.f26626a) || TextUtils.isEmpty(aVar.b) || (zVar = this.l) == null) {
            return;
        }
        zVar.setVisibility(0);
        this.l.a(aVar.f26626a, aVar.b);
    }

    private void f() {
        this.b = com.opos.cmn.an.h.f.a.a(this.e, 256.0f);
        int a2 = com.opos.cmn.an.h.f.a.a(this.e, 144.0f);
        this.f26896c = a2;
        this.d = a2 + com.opos.cmn.an.h.f.a.a(this.e, 24.0f);
    }

    private void g() {
        u a2 = u.a(this.e);
        this.k = a2;
        a2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, com.opos.cmn.an.h.f.a.a(this.e, 26.0f));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.e, 12.0f);
        this.k.setVisibility(4);
        this.j.addView(this.k, layoutParams);
    }

    private void h() {
        this.h = af.a(this.e, true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.e, 12.0f);
        this.h.setVisibility(4);
        this.j.addView(this.h, layoutParams);
    }

    private void i() {
        this.l = z.b(this.e);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(3, this.j.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.e, 10.0f);
        this.l.setGravity(1);
        this.l.setVisibility(4);
        this.i.addView(this.l, layoutParams);
    }

    private void j() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.e);
        aVar.a(new a.InterfaceC0678a() { // from class: com.opos.mobad.n.g.p.5
            @Override // com.opos.mobad.c.d.a.InterfaceC0678a
            public void a(boolean z) {
                if (p.this.q == null) {
                    return;
                }
                if (z && !p.this.r) {
                    p.this.r = true;
                    p.this.k();
                    if (p.this.f != null) {
                        p.this.f.b();
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo3", "BlockBigImageVideo3 onWindowVisibilityChanged：" + z);
                if (z) {
                    p.this.m.d();
                } else {
                    p.this.m.e();
                }
            }
        });
        this.i.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.j.setVisibility(0);
        this.k.setVisibility(0);
        this.h.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        if (!this.f26895a) {
            this.m.a();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo3", "current state has stop mDestroy = " + this.f26895a);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.f = interfaceC0708a;
        this.l.a(interfaceC0708a);
        this.k.a(interfaceC0708a);
        this.h.a(interfaceC0708a);
        this.m.a(interfaceC0708a);
        this.h.a(new af.a() { // from class: com.opos.mobad.n.g.p.2
            @Override // com.opos.mobad.n.g.af.a
            public void a(int i) {
                p.this.m.a(i);
            }
        });
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0708a interfaceC0708a;
        com.opos.mobad.n.d.e b = hVar.b();
        if (b == null) {
            com.opos.cmn.an.f.a.d("", "render with data null");
            a.InterfaceC0708a interfaceC0708a2 = this.f;
            if (interfaceC0708a2 != null) {
                interfaceC0708a2.b(1);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(b.f26630a.f26633a) && this.q == null) {
            this.m.a(b);
        }
        if (this.q == null && (interfaceC0708a = this.f) != null) {
            interfaceC0708a.e();
        }
        this.q = b;
        com.opos.mobad.n.c.j jVar = this.n;
        if (jVar != null && jVar.getVisibility() != 0) {
            this.n.setVisibility(0);
        }
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
            this.i.setVisibility(0);
        }
        a(b);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo3", "start countdown...");
        if (!this.f26895a) {
            this.m.b();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo3", "error state mDestroy " + this.f26895a);
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.n;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo3", "destroy");
        this.f26895a = true;
        this.m.c();
        this.q = null;
        this.p.removeCallbacks(this.s);
        com.opos.mobad.n.c.j jVar = this.n;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.g;
    }
}
