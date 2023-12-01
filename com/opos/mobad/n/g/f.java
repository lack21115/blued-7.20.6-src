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

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/f.class */
public class f implements com.opos.mobad.n.a {
    private int e;
    private Context f;
    private a.InterfaceC0538a g;
    private int h;
    private int i;
    private com.opos.mobad.n.d.d j;
    private ImageView k;
    private af l;
    private RelativeLayout m;
    private com.opos.mobad.n.c.h n;
    private u o;
    private z p;
    private y q;
    private RelativeLayout r;
    private com.opos.mobad.n.c.j t;
    private com.opos.mobad.c.a u;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f13139a = false;
    private int b = 256;

    /* renamed from: c  reason: collision with root package name */
    private int f13140c = 144;
    private int d = 64;
    private boolean s = false;

    private f(Context context, aj ajVar, int i, int i2, com.opos.mobad.c.a aVar) {
        this.f = context;
        this.i = i2;
        this.h = i;
        this.u = aVar;
        f();
        a(ajVar);
        n();
    }

    public static f a(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new f(context, ajVar, i, 0, aVar);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        c(dVar);
        if (this.s) {
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
            ajVar2 = aj.a(this.f);
        }
        Context context = this.f;
        int i = ajVar2.f13109a;
        int i2 = ajVar2.b;
        int i3 = this.b;
        this.t = new com.opos.mobad.n.c.j(context, new j.a(i, i2, i3, i3 / this.e));
        this.m = new RelativeLayout(this.f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, -2);
        layoutParams.width = this.b;
        layoutParams.height = -2;
        this.m.setId(View.generateViewId());
        this.m.setLayoutParams(layoutParams);
        this.m.setVisibility(8);
        this.t.addView(this.m, layoutParams);
        this.t.setLayoutParams(layoutParams);
        g();
        m();
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.f.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (f.this.g != null) {
                    f.this.g.g(view, iArr);
                }
            }
        };
        this.m.setOnClickListener(gVar);
        this.m.setOnTouchListener(gVar);
    }

    public static f b(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new f(context, ajVar, i, 1, aVar);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        y yVar;
        if (dVar.g == null || dVar.g.size() == 0 || (yVar = this.q) == null) {
            return;
        }
        yVar.a(dVar, this.u, this.f13139a, dVar.z);
    }

    public static f c(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new f(context, ajVar, i, 2, aVar);
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        this.o.a(dVar.l, dVar.f);
    }

    private void d(final com.opos.mobad.n.d.d dVar) {
        ImageView imageView;
        if (dVar.g == null || dVar.g.size() == 0 || (imageView = this.k) == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.u.a(dVar.g.get(0).f12945a, dVar.g.get(0).b, this.b, this.f13140c, new a.InterfaceC0506a() { // from class: com.opos.mobad.n.g.f.3
            @Override // com.opos.mobad.c.a.InterfaceC0506a
            public void a(int i, final Bitmap bitmap) {
                if (f.this.f13139a) {
                    return;
                }
                if (dVar.g.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage3", "null imgList");
                } else if (i != 0 && i != 1) {
                    if (f.this.g != null) {
                        f.this.g.c(i);
                    }
                } else {
                    if (i == 1 && f.this.g != null) {
                        f.this.g.c(i);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.f.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (f.this.f13139a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            f.this.k.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void e(com.opos.mobad.n.d.d dVar) {
        this.l.a(dVar.r, dVar.s, dVar.i, dVar.j, dVar.k, dVar.B);
    }

    private void f() {
        int a2;
        this.d = com.opos.cmn.an.h.f.a.a(this.f, 64.0f);
        int i = this.i;
        if (i == 0) {
            this.b = com.opos.cmn.an.h.f.a.a(this.f, 256.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f, 144.0f);
        } else if (i != 1) {
            if (i == 2) {
                this.b = com.opos.cmn.an.h.f.a.a(this.f, 256.0f);
                this.f13140c = com.opos.cmn.an.h.f.a.a(this.f, 168.0f);
                this.s = true;
            }
            this.e = this.f13140c + com.opos.cmn.an.h.f.a.a(this.f, 24.0f);
        } else {
            this.b = com.opos.cmn.an.h.f.a.a(this.f, 256.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f, 168.0f);
        }
        this.f13140c = a2;
        this.e = this.f13140c + com.opos.cmn.an.h.f.a.a(this.f, 24.0f);
    }

    private void f(com.opos.mobad.n.d.d dVar) {
        z zVar;
        com.opos.mobad.n.d.a aVar = dVar.v;
        if (aVar == null || TextUtils.isEmpty(aVar.f12938a) || TextUtils.isEmpty(aVar.b) || (zVar = this.p) == null) {
            return;
        }
        zVar.setVisibility(0);
        this.p.a(aVar.f12938a, aVar.b);
    }

    private void g() {
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f);
        this.n = hVar;
        hVar.a(com.opos.cmn.an.h.f.a.a(this.f, 14.0f));
        this.n.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f13140c);
        this.n.setVisibility(4);
        this.m.addView(this.n, layoutParams);
        if (this.s) {
            j();
        } else {
            k();
        }
        l();
        h();
    }

    private void h() {
        i();
        u a2 = u.a(this.f);
        this.o = a2;
        a2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, com.opos.cmn.an.h.f.a.a(this.f, 26.0f));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        this.o.setVisibility(4);
        this.n.addView(this.o, layoutParams);
    }

    private void i() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f);
        this.r = relativeLayout;
        relativeLayout.setBackgroundResource(R.drawable.opos_mobad_drawable_shape_gradient);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.d);
        this.r.setVisibility(0);
        layoutParams.addRule(12);
        this.n.addView(this.r, layoutParams);
    }

    private void j() {
        this.q = y.a(this.f, this.b, this.f13140c, true);
        this.n.addView(this.q, new RelativeLayout.LayoutParams(this.b, this.f13140c));
    }

    private void k() {
        this.k = new ImageView(this.f);
        this.n.addView(this.k, new RelativeLayout.LayoutParams(this.b, this.f13140c));
    }

    private void l() {
        this.l = af.a(this.f, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        this.l.setVisibility(4);
        this.n.addView(this.l, layoutParams);
    }

    private void m() {
        this.p = z.b(this.f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(3, this.n.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 10.0f);
        this.p.setGravity(1);
        this.p.setVisibility(4);
        this.m.addView(this.p, layoutParams);
    }

    private void n() {
        final com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f);
        aVar.a(new a.InterfaceC0508a() { // from class: com.opos.mobad.n.g.f.2
            @Override // com.opos.mobad.c.d.a.InterfaceC0508a
            public void a(boolean z) {
                if (f.this.j == null) {
                    return;
                }
                if (z) {
                    f.this.o();
                    if (f.this.g != null) {
                        f.this.g.b();
                    }
                    aVar.a((a.InterfaceC0508a) null);
                }
                com.opos.cmn.an.f.a.b("BlockBigImage3", "blockBigImage3 onWindowVisibilityChanged：" + z);
            }
        });
        this.m.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        this.l.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.g = interfaceC0538a;
        this.p.a(interfaceC0538a);
        this.o.a(interfaceC0538a);
        this.l.a(interfaceC0538a);
        y yVar = this.q;
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
                com.opos.cmn.an.f.a.b("BlockBigImage3", "render");
                if (this.j == null && (interfaceC0538a = this.g) != null) {
                    interfaceC0538a.e();
                }
                this.j = a2;
                com.opos.mobad.n.c.j jVar = this.t;
                if (jVar != null && jVar.getVisibility() != 0) {
                    this.t.setVisibility(0);
                }
                RelativeLayout relativeLayout = this.m;
                if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                    this.m.setVisibility(0);
                }
                a(a2);
                return;
            } else {
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BlockBigImage3", str);
        this.g.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.t;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImage3", "destroy");
        this.j = null;
        this.f13139a = true;
        com.opos.mobad.n.c.j jVar = this.t;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.h;
    }
}
