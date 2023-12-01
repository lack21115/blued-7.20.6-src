package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.a;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.j;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/e.class */
public class e implements com.opos.mobad.n.a {
    private int d;
    private int e;
    private Context g;
    private a.InterfaceC0538a h;
    private int i;
    private int j;
    private com.opos.mobad.n.d.d k;
    private ImageView l;
    private af m;
    private com.opos.mobad.n.c.h n;
    private RelativeLayout o;
    private t p;
    private z q;
    private RelativeLayout r;
    private y s;
    private com.opos.mobad.n.c.j u;
    private com.opos.mobad.c.a v;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f13133a = false;
    private int b = 256;

    /* renamed from: c  reason: collision with root package name */
    private int f13134c = 144;
    private int f = 64;
    private boolean t = false;

    private e(Context context, aj ajVar, int i, int i2, com.opos.mobad.c.a aVar) {
        this.g = context;
        this.j = i2;
        this.i = i;
        this.v = aVar;
        f();
        a(ajVar);
        n();
    }

    public static e a(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new e(context, ajVar, i, 0, aVar);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        c(dVar);
        if (this.t) {
            b(dVar);
        } else {
            d(dVar);
        }
        e(dVar);
        f(dVar);
    }

    private void a(aj ajVar) {
        aj ajVar2 = ajVar;
        if (ajVar == null) {
            ajVar2 = aj.a(this.g);
        }
        Context context = this.g;
        int i = ajVar2.f13109a;
        int i2 = ajVar2.b;
        int i3 = this.b;
        this.u = new com.opos.mobad.n.c.j(context, new j.a(i, i2, i3, i3 / this.d));
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.g);
        this.n = hVar;
        hVar.a(com.opos.cmn.an.h.f.a.a(this.g, 14.0f));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, this.d);
        layoutParams.width = this.b;
        layoutParams.height = this.d;
        this.n.setId(View.generateViewId());
        this.n.setBackgroundColor(this.g.getResources().getColor(R.color.opos_mobad_root_bg_color));
        this.n.setLayoutParams(layoutParams);
        this.n.setVisibility(8);
        this.u.addView(this.n, layoutParams);
        this.u.setLayoutParams(layoutParams);
        m();
        g();
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.e.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (e.this.h != null) {
                    e.this.h.g(view, iArr);
                }
            }
        };
        this.n.setOnClickListener(gVar);
        this.n.setOnTouchListener(gVar);
    }

    public static e b(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new e(context, ajVar, i, 1, aVar);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        y yVar;
        if (dVar.g == null || dVar.g.size() == 0 || (yVar = this.s) == null) {
            return;
        }
        yVar.a(dVar, this.v, this.f13133a, dVar.z);
    }

    public static e c(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new e(context, ajVar, i, 2, aVar);
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        this.p.a(dVar.m, dVar.l, dVar.f, dVar.e, this.v, this.f13133a);
    }

    private void d(final com.opos.mobad.n.d.d dVar) {
        ImageView imageView;
        if (dVar.g == null || dVar.g.size() == 0 || (imageView = this.l) == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.v.a(dVar.g.get(0).f12945a, dVar.g.get(0).b, this.b, this.f13134c, new a.InterfaceC0506a() { // from class: com.opos.mobad.n.g.e.3
            @Override // com.opos.mobad.c.a.InterfaceC0506a
            public void a(int i, final Bitmap bitmap) {
                if (e.this.f13133a) {
                    return;
                }
                if (dVar.g.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage2", "null imgList");
                } else if (i != 0 && i != 1) {
                    if (e.this.h != null) {
                        e.this.h.c(i);
                    }
                } else {
                    if (i == 1 && e.this.h != null) {
                        e.this.h.c(i);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.e.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (e.this.f13133a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            e.this.l.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void e(com.opos.mobad.n.d.d dVar) {
        this.m.a(dVar.r, dVar.s, dVar.i, dVar.j, dVar.k, dVar.B);
    }

    private void f() {
        int a2;
        int i = this.j;
        if (i == 0) {
            this.b = com.opos.cmn.an.h.f.a.a(this.g, 256.0f);
            this.f13134c = com.opos.cmn.an.h.f.a.a(this.g, 144.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.g, 218.0f);
        } else if (i != 1) {
            if (i != 2) {
                return;
            }
            this.b = com.opos.cmn.an.h.f.a.a(this.g, 256.0f);
            this.f13134c = com.opos.cmn.an.h.f.a.a(this.g, 168.0f);
            this.d = com.opos.cmn.an.h.f.a.a(this.g, 242.0f);
            this.e = this.b;
            this.f = com.opos.cmn.an.h.f.a.a(this.g, 64.0f);
            this.t = true;
            return;
        } else {
            this.b = com.opos.cmn.an.h.f.a.a(this.g, 256.0f);
            this.f13134c = com.opos.cmn.an.h.f.a.a(this.g, 168.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.g, 242.0f);
        }
        this.d = a2;
        this.e = this.b;
        this.f = com.opos.cmn.an.h.f.a.a(this.g, 64.0f);
    }

    private void f(com.opos.mobad.n.d.d dVar) {
        com.opos.mobad.n.d.a aVar = dVar.v;
        if (aVar == null || TextUtils.isEmpty(aVar.f12938a) || TextUtils.isEmpty(aVar.b)) {
            return;
        }
        RelativeLayout relativeLayout = this.r;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        z zVar = this.q;
        if (zVar != null) {
            zVar.setVisibility(0);
            this.q.a(aVar.f12938a, aVar.b);
        }
    }

    private void g() {
        RelativeLayout relativeLayout = new RelativeLayout(this.g);
        this.o = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f13134c);
        t tVar = this.p;
        if (tVar != null) {
            layoutParams.addRule(3, tVar.getId());
        }
        this.o.setVisibility(4);
        this.n.addView(this.o, layoutParams);
        if (this.t) {
            h();
        } else {
            j();
        }
        k();
        l();
    }

    private void h() {
        this.s = y.a(this.g, this.b, this.f13134c, true);
        this.o.addView(this.s, new RelativeLayout.LayoutParams(this.b, this.f13134c));
    }

    private void i() {
        RelativeLayout relativeLayout = new RelativeLayout(this.g);
        this.r = relativeLayout;
        relativeLayout.setBackgroundResource(R.drawable.opos_mobad_drawable_shape_gradient);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f);
        this.r.setVisibility(4);
        layoutParams.addRule(12);
        this.o.addView(this.r, layoutParams);
    }

    private void j() {
        this.l = new ImageView(this.g);
        this.o.addView(this.l, new RelativeLayout.LayoutParams(this.b, this.f13134c));
    }

    private void k() {
        this.m = af.a(this.g, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        this.m.setVisibility(4);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        this.o.addView(this.m, layoutParams);
    }

    private void l() {
        i();
        this.q = z.a(this.g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 10.0f);
        this.q.setGravity(1);
        this.q.setVisibility(4);
        this.o.addView(this.q, layoutParams);
    }

    private void m() {
        t a2 = t.a(this.g);
        this.p = a2;
        a2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, com.opos.cmn.an.h.f.a.a(this.g, 74.0f));
        this.p.setVisibility(4);
        this.n.addView(this.p, layoutParams);
    }

    private void n() {
        final com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.g);
        aVar.a(new a.InterfaceC0508a() { // from class: com.opos.mobad.n.g.e.2
            @Override // com.opos.mobad.c.d.a.InterfaceC0508a
            public void a(boolean z) {
                if (e.this.k == null) {
                    return;
                }
                if (z) {
                    e.this.o();
                    if (e.this.h != null) {
                        e.this.h.b();
                    }
                    aVar.a((a.InterfaceC0508a) null);
                }
                com.opos.cmn.an.f.a.b("BlockBigImage2", "blockBigImage2 onWindowVisibilityChanged：" + z);
            }
        });
        this.n.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.o.setVisibility(0);
        this.p.setVisibility(0);
        this.m.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.h = interfaceC0538a;
        this.q.a(interfaceC0538a);
        this.p.a(interfaceC0538a);
        this.m.a(interfaceC0538a);
        y yVar = this.s;
        if (yVar != null) {
            yVar.a(interfaceC0538a);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        String str;
        a.InterfaceC0538a interfaceC0538a;
        if (hVar == null) {
            str = "data is null";
        } else {
            com.opos.mobad.n.d.d a2 = hVar.a();
            if (a2 == null) {
                str = "adShowData is null";
            } else if (a2.g != null && a2.g.size() > 0) {
                com.opos.cmn.an.f.a.b("BlockBigImage2", "render");
                if (this.k == null && (interfaceC0538a = this.h) != null) {
                    interfaceC0538a.e();
                }
                this.k = a2;
                com.opos.mobad.n.c.j jVar = this.u;
                if (jVar != null && jVar.getVisibility() != 0) {
                    this.u.setVisibility(0);
                }
                com.opos.mobad.n.c.h hVar2 = this.n;
                if (hVar2 != null && hVar2.getVisibility() != 0) {
                    this.n.setVisibility(0);
                }
                a(a2);
                return;
            } else {
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BlockBigImage2", str);
        this.h.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.u;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImage2", "destroy");
        this.k = null;
        this.f13133a = true;
        com.opos.mobad.n.c.j jVar = this.u;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.i;
    }
}
