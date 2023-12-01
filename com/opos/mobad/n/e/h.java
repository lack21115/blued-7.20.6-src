package com.opos.mobad.n.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.anythink.expressad.video.module.a.a.m;
import com.bytedance.applog.tracker.Tracker;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.a.q;
import com.opos.mobad.n.d;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/e/h.class */
public class h extends com.opos.mobad.n.i.a {

    /* renamed from: a  reason: collision with root package name */
    com.opos.mobad.c.d.a f12955a;
    private Context d;
    private com.opos.mobad.n.d.b e;
    private View f;
    private FrameLayout g;
    private com.opos.mobad.c.b.c h;
    private long i;
    private RelativeLayout j;
    private a k;
    private com.opos.mobad.n.d l;
    private long m;
    private ViewGroup n;
    private View o;
    private ImageView p;
    private boolean q;
    private Drawable r;
    private Drawable s;
    private long t;
    private Runnable u;
    private a.InterfaceC0538a v;

    public h(Context context, int i) {
        super(i);
        this.q = false;
        this.u = new Runnable() { // from class: com.opos.mobad.n.e.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.o() == 8) {
                    return;
                }
                com.opos.cmn.an.f.a.b("SplashDyTemplate", "countdown=" + h.this.m + "," + h.this.o());
                if (h.this.o() <= 2) {
                    h.this.h.a(1000L);
                    return;
                }
                long j = h.this.m;
                h hVar = h.this;
                if (j <= 0) {
                    hVar.r();
                    return;
                }
                hVar.h.a(1000L);
                if (h.this.l != null) {
                    h.this.l.a((int) (h.this.m / 1000));
                }
                h hVar2 = h.this;
                hVar2.c(hVar2.i - h.this.m, h.this.t);
                h.this.m -= 1000;
            }
        };
        this.v = new a.InterfaceC0538a() { // from class: com.opos.mobad.n.e.h.5
            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void a(int i2, String str) {
                h.this.a(i2, str);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void a(long j, long j2) {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void a(View view, int[] iArr) {
                h.this.h(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void a(View view, int[] iArr, boolean z) {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void b() {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void b(int i2) {
                h.this.a(i2);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void b(long j, long j2) {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void b(View view, int[] iArr) {
                h.this.c(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void c(int i2) {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void c(long j, long j2) {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void c(View view, int[] iArr) {
                h.this.b(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void d(long j, long j2) {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void d(View view, int[] iArr) {
                h.this.a(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void e() {
                h.this.m();
                h.this.q();
                h.this.t();
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void e(View view, int[] iArr) {
                h.this.d(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void f(View view, int[] iArr) {
                h.this.d(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void g(View view, int[] iArr) {
                h.this.e(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void h(View view, int[] iArr) {
                h.this.g(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void i(View view, int[] iArr) {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void j(View view, int[] iArr) {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void k(View view, int[] iArr) {
            }
        };
        this.d = context;
        this.h = new com.opos.mobad.c.b.c(com.opos.mobad.c.b.b.a(), this.u);
        a aVar = new a(context, i);
        this.k = aVar;
        aVar.a(this.v);
        a(context);
    }

    private void a(Context context) {
        this.j = new RelativeLayout(context);
        this.g = new FrameLayout(context);
    }

    private void a(com.opos.mobad.n.d.b bVar, com.opos.mobad.n.d.h hVar) {
        this.l = bVar.u;
        if (this.e == null) {
            long j = bVar.w;
            this.m = j;
            if (j <= 0) {
                this.m = m.ag;
            }
            long j2 = this.m;
            this.i = j2;
            this.t = j2;
        }
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        this.j.setBackgroundColor(-1);
        com.opos.mobad.n.d dVar2 = dVar.u;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (b(dVar)) {
            FrameLayout frameLayout = new FrameLayout(this.d);
            this.n = frameLayout;
            frameLayout.setId(View.generateViewId());
            ViewGroup.LayoutParams b = q.b(this.d);
            this.n.setVisibility(0);
            this.j.addView(this.n, b);
            View a2 = dVar.t.a();
            if (a2 != null) {
                if (a2.getParent() != null) {
                    ((ViewGroup) a2.getParent()).removeView(a2);
                }
                this.n.addView(a2);
            }
            layoutParams.addRule(2, this.n.getId());
        }
        this.j.addView(this.g, layoutParams);
        View a3 = dVar.u.a();
        this.o = a3;
        this.j.addView(this.o, q.a(this.d, dVar, a3));
        this.o.setVisibility(4);
        dVar2.a(new d.a() { // from class: com.opos.mobad.n.e.h.1
            @Override // com.opos.mobad.n.d.a
            public void a(View view, int[] iArr) {
                if (h.this.v != null) {
                    h.this.a();
                    h.this.a(view, iArr);
                }
            }
        });
        if (s()) {
            com.opos.cmn.an.f.a.b("SplashDyTemplate", "is video splash");
            b(this.d);
            this.j.addView(this.p, q.a(dVar, this.d));
        }
    }

    private void a(com.opos.mobad.n.d.d dVar, com.opos.mobad.n.d.h hVar) {
        if (this.e != null) {
            return;
        }
        this.k.a(hVar);
        View c2 = this.k.c();
        this.f = c2;
        this.g.addView(c2, new RelativeLayout.LayoutParams(-1, -1));
        a(dVar);
    }

    private void b(Context context) {
        if (s()) {
            ImageView imageView = new ImageView(context);
            this.p = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.r = this.d.getResources().getDrawable(R.drawable.opos_mobad_drawable_sound_off);
            this.s = this.d.getResources().getDrawable(R.drawable.opos_mobad_drawable_sound_on);
            int a2 = com.opos.cmn.an.h.f.a.a(this.d, 6.0f);
            int a3 = com.opos.cmn.an.h.f.a.a(this.d, 7.0f);
            this.p.setPadding(a2, a3, a2, a3);
            this.p.setImageDrawable(this.r);
            this.p.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.n.e.h.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    h.this.i();
                }
            });
            this.p.setVisibility(4);
        }
    }

    private boolean b(com.opos.mobad.n.d.d dVar) {
        return (dVar == null || dVar.t == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        View view = this.o;
        if (view != null) {
            view.setVisibility(0);
        }
        ImageView imageView = this.p;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        this.f.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.j.isShown()) {
            com.opos.cmn.an.f.a.b("SplashDyTemplate", "handleAdClosed");
            this.h.a();
            p();
        }
    }

    private boolean s() {
        com.opos.mobad.n.d.b bVar = this.e;
        return (bVar == null || bVar.b == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.f12955a == null) {
            com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.d);
            this.f12955a = aVar;
            aVar.a(new a.InterfaceC0508a() { // from class: com.opos.mobad.n.e.h.4
                @Override // com.opos.mobad.c.d.a.InterfaceC0508a
                public void a(boolean z) {
                    com.opos.cmn.an.f.a.b("SplashDyTemplate", "visible change:" + z);
                    h hVar = h.this;
                    if (z) {
                        hVar.n();
                        h.this.k();
                    } else {
                        hVar.l();
                    }
                    boolean z2 = true;
                    if (h.this.m > 0) {
                        z2 = h.this.o() == 1;
                    }
                    if (z && z2) {
                        h.this.r();
                        h.this.f12955a.a((a.InterfaceC0508a) null);
                    }
                }
            });
        }
        if (this.g.indexOfChild(this.f12955a) < 0) {
            this.g.addView(this.f12955a, new ViewGroup.LayoutParams(0, 0));
        }
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.mobad.n.d.b d = hVar.d();
        if (d == null) {
            com.opos.cmn.an.f.a.b("SplashDyTemplate", "adShowData is null");
            a(1);
            return;
        }
        com.opos.cmn.an.f.a.b("SplashDyTemplate", "render");
        a(d, hVar);
        a((com.opos.mobad.n.d.d) d, hVar);
        this.e = d;
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.j;
    }

    @Override // com.opos.mobad.n.i.a
    public boolean f() {
        a aVar = this.k;
        if (aVar == null) {
            return false;
        }
        aVar.a();
        this.h.a();
        return true;
    }

    @Override // com.opos.mobad.n.i.a
    public boolean g() {
        a aVar = this.k;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        this.h.a(0L);
        return true;
    }

    @Override // com.opos.mobad.n.i.a
    public void h() {
        com.opos.cmn.an.f.a.b("SplashDyTemplate", "destroy");
        this.j.removeAllViews();
        a aVar = this.k;
        if (aVar != null) {
            aVar.d();
        }
        this.h.a();
        this.h.b();
    }

    public void i() {
        this.q = !this.q;
        com.opos.cmn.an.f.a.b("SplashDyTemplate", "VolumeSwitchIconClicked: " + this.q);
        ImageView imageView = this.p;
        if (imageView != null) {
            imageView.setImageDrawable(this.q ? this.s : this.r);
        }
        a aVar = this.k;
        if (aVar != null) {
            aVar.a(!this.q);
        }
    }
}
