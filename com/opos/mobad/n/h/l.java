package com.opos.mobad.n.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.m;
import com.opos.mobad.n.g.ae;
import com.opos.mobad.n.h.k;
import java.util.concurrent.Callable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/h/l.class */
public class l extends com.opos.mobad.n.i.a {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f13298a;
    private int d;
    private int e;
    private Context f;
    private com.opos.mobad.c.a g;
    private RelativeLayout h;
    private ae i;
    private b j;
    private m k;
    private k l;
    private g m;
    private h n;
    private RelativeLayout o;
    private RelativeLayout p;
    private Handler q;
    private com.opos.mobad.n.d.e r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private Runnable w;
    private com.opos.mobad.c.d.a x;
    private a y;

    private l(Context context, int i, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2, boolean z) {
        super(i);
        this.f13298a = null;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = true;
        this.w = new Runnable() { // from class: com.opos.mobad.n.h.l.1
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.o() == 8) {
                    return;
                }
                long f = l.this.k.f();
                l.this.c(f, l.this.k.g());
                l.this.a(f);
                l.this.q.postDelayed(this, 1000L);
            }
        };
        this.y = new a() { // from class: com.opos.mobad.n.h.l.6
            @Override // com.opos.mobad.n.h.a
            public void a() {
                if (l.this.r == null) {
                    return;
                }
                l lVar = l.this;
                lVar.a(lVar.r, l.this.k.b());
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void a(int i2, String str) {
                if (l.this.o() != 8) {
                    l.this.q.removeCallbacks(l.this.w);
                }
                l.this.a(i2, str);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void a(long j, long j2) {
                l.this.p();
                l.this.q.removeCallbacks(l.this.w);
                l.this.r();
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void a(View view, int[] iArr) {
                l.this.h(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void a(View view, int[] iArr, boolean z2) {
                l.this.a(view, iArr, z2);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void b() {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void b(int i2) {
                l.this.a(i2);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void b(long j, long j2) {
                l.this.b(j, j2);
                if (l.this.o() != 8) {
                    l.this.q.removeCallbacks(l.this.w);
                    l.this.q.post(l.this.w);
                }
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void b(View view, int[] iArr) {
                l.this.c(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void c(int i2) {
                l.this.b(i2);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void c(long j, long j2) {
                l.this.a(j, j2);
                if (l.this.o() != 8) {
                    l.this.q.removeCallbacks(l.this.w);
                }
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void c(View view, int[] iArr) {
                l.this.b(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void d(long j, long j2) {
                if (j == 0) {
                    l.this.q.removeCallbacks(l.this.w);
                    l.this.q.postDelayed(l.this.w, 10L);
                    l lVar = l.this;
                    lVar.c(0L, lVar.k.g());
                    l.this.q();
                }
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void d(View view, int[] iArr) {
                l.this.a(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void e() {
                l.this.a(new Callable<Boolean>() { // from class: com.opos.mobad.n.h.l.6.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        l.this.t();
                        l.this.s();
                        return true;
                    }
                });
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void e(View view, int[] iArr) {
                l.this.f(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void f(View view, int[] iArr) {
                l.this.d(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void g(View view, int[] iArr) {
                l.this.e(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void h(View view, int[] iArr) {
                l.this.g(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void i(View view, int[] iArr) {
                l.this.i(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void j(View view, int[] iArr) {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0538a
            public void k(View view, int[] iArr) {
            }
        };
        this.f = context;
        this.q = new Handler(Looper.getMainLooper());
        this.g = aVar2;
        boolean a2 = com.opos.mobad.c.b.a.a(this.f);
        this.u = a2;
        z = a2 ? true : z;
        this.v = z;
        a(z);
        a(aVar, z);
    }

    public static l a(Context context, int i, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new l(context, i, aVar, aVar2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        com.opos.mobad.n.d.e eVar = this.r;
        if (eVar == null || this.t) {
            return;
        }
        if (eVar.D <= 0 || j >= this.r.D) {
            this.t = true;
            this.l.a();
        }
    }

    private void a(com.opos.mobad.c.c.a aVar, boolean z) {
        this.h = new RelativeLayout(this.f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.h.setId(View.generateViewId());
        this.h.setBackgroundColor(Color.parseColor("#000000"));
        this.h.setLayoutParams(layoutParams);
        this.h.setVisibility(8);
        b(aVar, z);
        c(z);
        b(z);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.l.3
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                l.this.e(view, iArr);
            }
        };
        this.h.setOnClickListener(gVar);
        this.h.setOnTouchListener(gVar);
    }

    private void a(com.opos.mobad.n.d.e eVar) {
        a(eVar.r, eVar.s, eVar.i, eVar.j, eVar.k);
        c(eVar);
        b(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.n.d.e eVar, com.opos.mobad.c.c.a aVar) {
        if (this.f13298a != null) {
            this.o.setBackground(new BitmapDrawable(this.f13298a));
        } else {
            com.opos.mobad.n.c.m.a(aVar, eVar.f12942a.f12945a, new m.a() { // from class: com.opos.mobad.n.h.l.5
                @Override // com.opos.mobad.n.c.m.a
                public void a() {
                }

                @Override // com.opos.mobad.n.c.m.a
                public void a(Bitmap bitmap) {
                    if (l.this.o() == 8) {
                        return;
                    }
                    l lVar = l.this;
                    lVar.f13298a = com.opos.mobad.n.c.d.a(lVar.f, bitmap, 75, 0.25f, 56.0f);
                    com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.n.h.l.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (l.this.o() == 8) {
                                return;
                            }
                            l.this.o.setBackground(new BitmapDrawable(l.this.f13298a));
                        }
                    });
                }
            });
        }
    }

    private void a(boolean z) {
        Context context;
        float f = 16.0f;
        if (z) {
            this.d = com.opos.cmn.an.h.f.a.a(this.f, 49.0f);
            context = this.f;
        } else {
            this.d = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
            context = this.f;
            f = 42.0f;
        }
        this.e = com.opos.cmn.an.h.f.a.a(context, f);
    }

    private void a(boolean z, String str, boolean z2, com.opos.mobad.n.d.g gVar, String str2) {
        this.i.a(z, str, z2, gVar, str2);
    }

    public static l b(Context context, int i, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new l(context, i, aVar, aVar2, false);
    }

    private void b(com.opos.mobad.c.c.a aVar, boolean z) {
        c(aVar, z);
        i();
    }

    private void b(com.opos.mobad.n.d.e eVar) {
        int a2;
        this.j.a(eVar.m, eVar.l, eVar.f, eVar.e, this.g);
        this.j.a(eVar);
        if (eVar.m == null || TextUtils.isEmpty(eVar.m.f12945a)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
            if (this.v) {
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f, 66.0f);
                a2 = com.opos.cmn.an.h.f.a.a(this.f, 66.0f);
            } else {
                a2 = com.opos.cmn.an.h.f.a.a(this.f, 82.0f);
            }
            layoutParams2.height = a2;
        }
    }

    private void b(boolean z) {
        this.n = z ? h.a(this.f) : h.b(this.f);
        this.h.addView(this.n, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void c(com.opos.mobad.c.c.a aVar, boolean z) {
        this.o = new RelativeLayout(this.f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.k = m.a(this.f, aVar);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        if (z) {
            layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f, 76.0f);
        }
        if (z && !this.u) {
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 94.0f);
            aVar.c(1);
        }
        this.o.addView(this.k, layoutParams2);
        this.h.addView(this.o, layoutParams);
    }

    private void c(com.opos.mobad.n.d.e eVar) {
        this.m.a(eVar.s, eVar.C);
        this.l.a(eVar.B);
    }

    private void c(boolean z) {
        int a2;
        RelativeLayout relativeLayout = new RelativeLayout(this.f);
        this.p = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        this.j = b.a(this.f);
        int a3 = this.u ? -1 : com.opos.cmn.an.h.f.a.a(this.f, 360.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a3, -1);
        this.j.setVisibility(4);
        this.p.addView(this.j, layoutParams);
        int a4 = com.opos.cmn.an.h.f.a.a(this.f, 76.0f);
        if (this.u || z) {
            this.j.setBackgroundResource(R.drawable.opos_mobad_drawable_reward_no_radius_bottom_bg);
            a2 = 0;
        } else {
            a2 = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
            a4 += a2;
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a3, a4);
        layoutParams2.addRule(12);
        layoutParams2.addRule(14);
        this.p.setPadding(0, 0, 0, a2);
        this.h.addView(this.p, layoutParams2);
        this.i = ae.a(this.f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f, 14.0f));
        layoutParams3.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        if (z || this.u) {
            layoutParams3.addRule(2, this.p.getId());
        } else {
            layoutParams3.addRule(12);
        }
        this.h.addView(this.i, layoutParams3);
    }

    private void i() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f);
        relativeLayout.setId(View.generateViewId());
        this.m = g.a(this.f);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f, 28.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, a2);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        relativeLayout.addView(this.m, layoutParams);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = this.e;
        k a3 = k.a(this.f);
        this.l = a3;
        a3.setId(View.generateViewId());
        relativeLayout2.addView(this.l, new RelativeLayout.LayoutParams(-2, a2));
        relativeLayout.addView(relativeLayout2, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = this.d;
        this.h.addView(relativeLayout, layoutParams3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        h hVar = this.n;
        if (hVar == null) {
            return;
        }
        hVar.removeAllViews();
        this.h.removeView(this.n);
        this.n = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.opos.mobad.n.d.e eVar = this.r;
        if (eVar != null && eVar.G == 1) {
            this.l.b();
            return;
        }
        this.m.setVisibility(8);
        this.l.setVisibility(4);
        this.j.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.x == null) {
            com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f);
            this.x = aVar;
            aVar.a(new a.InterfaceC0508a() { // from class: com.opos.mobad.n.h.l.4
                @Override // com.opos.mobad.c.d.a.InterfaceC0508a
                public void a(boolean z) {
                    if (l.this.r == null) {
                        return;
                    }
                    if (!z) {
                        l.this.l();
                        return;
                    }
                    l.this.n();
                    l.this.k();
                }
            });
        }
        if (this.h.indexOfChild(this.x) < 0) {
            this.h.addView(this.x, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.j.setVisibility(0);
        this.m.setVisibility(0);
    }

    @Override // com.opos.mobad.n.i.a, com.opos.mobad.n.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        super.a(interfaceC0538a);
        this.i.a(this.y);
        this.l.a(this.y);
        this.k.a(this.y);
        this.j.a(this.y);
        this.m.a(this.y);
        h hVar = this.n;
        if (hVar != null) {
            hVar.a(this.y);
        }
        this.l.a(new k.a() { // from class: com.opos.mobad.n.h.l.2
            @Override // com.opos.mobad.n.h.k.a
            public void a(int i) {
                l.this.k.a(i);
            }
        });
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        if (hVar == null) {
            com.opos.cmn.an.f.a.a("RewardVideoTemplate", "data is null");
        } else {
            com.opos.mobad.n.d.e b = hVar.b();
            if (b != null) {
                if (!TextUtils.isEmpty(b.f12942a.f12945a) && this.r == null) {
                    this.k.a(b);
                }
                this.r = b;
                RelativeLayout relativeLayout = this.h;
                if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                    this.h.setVisibility(0);
                }
                a(b);
                return;
            }
            com.opos.cmn.an.f.a.d("RewardVideoTemplate", "render with data null");
        }
        a(1);
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.h;
    }

    @Override // com.opos.mobad.n.i.a
    public boolean f() {
        this.k.a();
        return true;
    }

    @Override // com.opos.mobad.n.i.a
    public boolean g() {
        com.opos.cmn.an.f.a.b("RewardVideoTemplate", "start countdown...");
        this.k.c();
        return true;
    }

    @Override // com.opos.mobad.n.i.a
    public void h() {
        com.opos.cmn.an.f.a.b("RewardVideoTemplate", "do End");
        this.k.d();
        this.j.a();
        this.q.removeCallbacks(this.w);
        RelativeLayout relativeLayout = this.h;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }
}
