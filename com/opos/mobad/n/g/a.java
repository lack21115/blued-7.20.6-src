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

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/a.class */
public class a implements com.opos.mobad.n.a {
    private int d;
    private int e;
    private Context g;
    private a.InterfaceC0708a h;
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
    private volatile boolean f26749a = false;
    private int b = 256;

    /* renamed from: c  reason: collision with root package name */
    private int f26750c = 144;
    private int f = 64;
    private boolean t = false;

    private a(Context context, int i, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        this.g = context;
        this.j = i2;
        this.i = i;
        this.v = aVar;
        f();
        a(ajVar);
        n();
    }

    public static a a(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new a(context, i, ajVar, 0, aVar);
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
        int i = ajVar2.f26797a;
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
        g();
        m();
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.a.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (a.this.h != null) {
                    a.this.h.g(view, iArr);
                }
            }
        };
        this.n.setOnClickListener(gVar);
        this.n.setOnTouchListener(gVar);
    }

    public static a b(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new a(context, i, ajVar, 1, aVar);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        y yVar;
        if (dVar.g == null || dVar.g.size() == 0 || (yVar = this.s) == null) {
            return;
        }
        yVar.a(dVar, this.v, this.f26749a, dVar.z);
    }

    public static a c(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new a(context, i, ajVar, 2, aVar);
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        this.p.a(dVar.m, dVar.l, dVar.f, dVar.e, this.v, this.f26749a);
    }

    private void d(final com.opos.mobad.n.d.d dVar) {
        String str;
        ImageView imageView;
        if (this.v == null) {
            str = "mBitmapCache is null";
        } else if (dVar.g != null && dVar.g.size() != 0 && (imageView = this.l) != null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.v.a(dVar.g.get(0).f26633a, dVar.g.get(0).b, this.b, this.f26750c, new a.InterfaceC0676a() { // from class: com.opos.mobad.n.g.a.3
                @Override // com.opos.mobad.c.a.InterfaceC0676a
                public void a(int i, final Bitmap bitmap) {
                    if (a.this.f26749a) {
                        return;
                    }
                    if (dVar.g.get(0) == null) {
                        com.opos.cmn.an.f.a.b("BlockBigImage1", "null imgList");
                    } else if (i != 0 && i != 1) {
                        if (a.this.h != null) {
                            a.this.h.c(i);
                        }
                    } else {
                        if (i == 1 && a.this.h != null) {
                            a.this.h.c(i);
                        }
                        com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.a.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2;
                                if (a.this.f26749a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                    return;
                                }
                                a.this.l.setImageBitmap(bitmap);
                            }
                        });
                    }
                }
            });
            return;
        } else {
            str = "null imgList";
        }
        com.opos.cmn.an.f.a.b("BlockBigImage1", str);
    }

    private void e(com.opos.mobad.n.d.d dVar) {
        this.m.a(dVar.r, dVar.s, dVar.i, dVar.j, dVar.k, dVar.B);
    }

    private void f() {
        int a2;
        int i = this.j;
        if (i == 0) {
            this.b = com.opos.cmn.an.h.f.a.a(this.g, 256.0f);
            this.f26750c = com.opos.cmn.an.h.f.a.a(this.g, 144.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.g, 218.0f);
        } else if (i != 1) {
            if (i != 2) {
                return;
            }
            this.b = com.opos.cmn.an.h.f.a.a(this.g, 256.0f);
            this.f26750c = com.opos.cmn.an.h.f.a.a(this.g, 168.0f);
            this.d = com.opos.cmn.an.h.f.a.a(this.g, 242.0f);
            this.e = this.b;
            this.f = com.opos.cmn.an.h.f.a.a(this.g, 64.0f);
            this.t = true;
            return;
        } else {
            this.b = com.opos.cmn.an.h.f.a.a(this.g, 256.0f);
            this.f26750c = com.opos.cmn.an.h.f.a.a(this.g, 168.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.g, 242.0f);
        }
        this.d = a2;
        this.e = this.b;
        this.f = com.opos.cmn.an.h.f.a.a(this.g, 64.0f);
    }

    private void f(com.opos.mobad.n.d.d dVar) {
        com.opos.mobad.n.d.a aVar = dVar.v;
        if (aVar == null || TextUtils.isEmpty(aVar.f26626a) || TextUtils.isEmpty(aVar.b)) {
            return;
        }
        RelativeLayout relativeLayout = this.r;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        z zVar = this.q;
        if (zVar != null) {
            zVar.setVisibility(0);
            this.q.a(aVar.f26626a, aVar.b);
        }
    }

    private void g() {
        RelativeLayout relativeLayout = new RelativeLayout(this.g);
        this.o = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f26750c);
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
        this.s = y.a(this.g, this.b, this.f26750c, true);
        this.o.addView(this.s, new RelativeLayout.LayoutParams(this.b, this.f26750c));
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
        this.o.addView(this.l, new RelativeLayout.LayoutParams(this.b, this.f26750c));
    }

    private void k() {
        this.m = af.a(this.g, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 16.0f);
        this.m.setVisibility(4);
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
        RelativeLayout relativeLayout = this.o;
        if (relativeLayout != null) {
            layoutParams.addRule(3, relativeLayout.getId());
        }
        this.p.setVisibility(4);
        this.n.addView(this.p, layoutParams);
    }

    private void n() {
        final com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.g);
        aVar.a(new a.InterfaceC0678a() { // from class: com.opos.mobad.n.g.a.2
            @Override // com.opos.mobad.c.d.a.InterfaceC0678a
            public void a(boolean z) {
                if (a.this.k == null) {
                    return;
                }
                if (z) {
                    a.this.o();
                    if (a.this.h != null) {
                        a.this.h.b();
                    }
                    aVar.a((a.InterfaceC0678a) null);
                }
                com.opos.cmn.an.f.a.b("BlockBigImage1", "blockBigImage1 onWindowVisibilityChanged：" + z);
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
    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.h = interfaceC0708a;
        this.q.a(interfaceC0708a);
        this.p.a(interfaceC0708a);
        this.m.a(interfaceC0708a);
        y yVar = this.s;
        if (yVar != null) {
            yVar.a(interfaceC0708a);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        String str;
        a.InterfaceC0708a interfaceC0708a;
        if (hVar == null) {
            str = "data is null";
        } else {
            com.opos.mobad.n.d.d a2 = hVar.a();
            if (a2 == null) {
                str = "adShowData is null";
            } else if (a2.g != null && a2.g.size() > 0) {
                com.opos.cmn.an.f.a.b("BlockBigImage1", "render");
                if (this.k == null && (interfaceC0708a = this.h) != null) {
                    interfaceC0708a.e();
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
        com.opos.cmn.an.f.a.b("BlockBigImage1", str);
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
        com.opos.cmn.an.f.a.b("BlockBigImage1", "destroy");
        this.k = null;
        this.f26749a = true;
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
