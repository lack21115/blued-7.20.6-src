package com.opos.mobad.n.b;

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
import com.opos.mobad.n.c.f;
import com.opos.mobad.n.c.j;
import com.opos.mobad.n.d.g;
import com.opos.mobad.n.d.h;
import com.opos.mobad.n.g.aj;
import com.opos.mobad.n.g.y;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/b/a.class */
public class a implements com.opos.mobad.n.a {
    private int e;
    private Context f;
    private a.InterfaceC0538a g;
    private int h;
    private int i;
    private com.opos.mobad.n.d.d j;
    private ImageView k;
    private RelativeLayout l;
    private RelativeLayout m;
    private d n;
    private y o;
    private RelativeLayout p;
    private j r;
    private f s;
    private RelativeLayout t;
    private e u;
    private com.opos.mobad.c.a v;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f12876a = false;
    private int b = 360;

    /* renamed from: c  reason: collision with root package name */
    private int f12877c = 60;
    private int d = 0;
    private boolean q = false;

    private a(Context context, aj ajVar, int i, int i2, com.opos.mobad.c.a aVar) {
        this.f = context;
        this.i = i2;
        this.h = i;
        this.v = aVar;
        f();
        a(ajVar);
        n();
    }

    public static a a(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new a(context, ajVar, i, 0, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Bitmap bitmap) {
        com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap2;
                if (a.this.f12876a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                    return;
                }
                a.this.s.setImageBitmap(bitmap);
            }
        });
    }

    private void a(RelativeLayout.LayoutParams layoutParams) {
        RelativeLayout relativeLayout = this.t;
        if (relativeLayout != null) {
            layoutParams.addRule(1, relativeLayout.getId());
        }
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        d(dVar);
        if (this.i == 3) {
            a(dVar.m);
            return;
        }
        if (this.q) {
            c(dVar);
        } else {
            e(dVar);
        }
        b(dVar);
    }

    private void a(g gVar) {
        if (this.t == null) {
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f12945a)) {
            this.t.setVisibility(0);
            a(gVar, this.v, this.f12876a);
            return;
        }
        this.t.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f, 8.0f);
        layoutParams.width = this.b;
        this.n.setLayoutParams(layoutParams);
    }

    private void a(g gVar, com.opos.mobad.c.a aVar, final boolean z) {
        this.s.setScaleType(ImageView.ScaleType.FIT_XY);
        if (gVar == null) {
            com.opos.cmn.an.f.a.b("BannerBigImage", "iconUrl is null");
            return;
        }
        int a2 = com.opos.cmn.an.h.f.a.a(this.f, 48.0f);
        aVar.a(gVar.f12945a, gVar.b, a2, a2, new a.InterfaceC0506a() { // from class: com.opos.mobad.n.b.a.4
            @Override // com.opos.mobad.c.a.InterfaceC0506a
            public void a(int i, Bitmap bitmap) {
                if (z) {
                    return;
                }
                if (i != 0 && i != 1) {
                    if (a.this.g != null) {
                        a.this.g.c(i);
                        return;
                    }
                    return;
                }
                if (i == 1 && a.this.g != null) {
                    a.this.g.c(i);
                }
                a.this.a(bitmap);
            }
        });
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
        this.r = new j(context, new j.a(i, i2, i3, i3 / this.e));
        this.l = new RelativeLayout(this.f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, -2);
        layoutParams.width = this.b;
        layoutParams.height = -2;
        this.l.setId(View.generateViewId());
        this.l.setLayoutParams(layoutParams);
        this.l.setVisibility(8);
        this.r.addView(this.l, layoutParams);
        this.r.setLayoutParams(layoutParams);
        h();
        g();
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.b.a.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (a.this.g != null) {
                    a.this.g.g(view, iArr);
                }
            }
        };
        this.l.setOnClickListener(gVar);
        this.l.setOnTouchListener(gVar);
        o();
    }

    public static a b(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new a(context, ajVar, i, 1, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Bitmap bitmap) {
        com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.b.a.7
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap2;
                if (a.this.f12876a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                    return;
                }
                a.this.k.setImageBitmap(bitmap);
            }
        });
    }

    private void b(RelativeLayout.LayoutParams layoutParams) {
        int id;
        if (this.q) {
            y yVar = this.o;
            if (yVar == null) {
                return;
            }
            id = yVar.getId();
        } else {
            ImageView imageView = this.k;
            if (imageView == null) {
                return;
            }
            id = imageView.getId();
        }
        layoutParams.addRule(1, id);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        e eVar = this.u;
        if (eVar == null) {
            return;
        }
        eVar.a(dVar.r, dVar.s, dVar.i, dVar.j, dVar.k);
    }

    public static a c(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new a(context, ajVar, i, 2, aVar);
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        if (this.o == null) {
            return;
        }
        if (dVar.g != null && dVar.g.size() > 0) {
            this.o.a(dVar, this.v, this.f12876a, 3000);
            return;
        }
        com.opos.cmn.an.f.a.b("BannerBigImage", "imgList is null");
        this.g.b(1);
    }

    public static a d(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new a(context, ajVar, i, 3, aVar);
    }

    private void d(com.opos.mobad.n.d.d dVar) {
        this.n.a(dVar.l, dVar.f, dVar.e);
        this.n.a(dVar);
        if (this.i == 3) {
            this.n.b(dVar);
        }
    }

    private void e(final com.opos.mobad.n.d.d dVar) {
        if (this.k == null) {
            return;
        }
        if (dVar.g == null || dVar.g.size() <= 0) {
            com.opos.cmn.an.f.a.b("BannerBigImage", "imgList is null");
            this.g.b(1);
            return;
        }
        this.k.setScaleType(ImageView.ScaleType.FIT_XY);
        this.v.a(dVar.g.get(0).f12945a, dVar.g.get(0).b, this.b, this.f12877c, new a.InterfaceC0506a() { // from class: com.opos.mobad.n.b.a.6
            @Override // com.opos.mobad.c.a.InterfaceC0506a
            public void a(int i, Bitmap bitmap) {
                if (a.this.f12876a) {
                    return;
                }
                if (dVar.g.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BannerBigImage", "null imgList");
                } else if (i != 0 && i != 1) {
                    if (a.this.g != null) {
                        a.this.g.c(i);
                    }
                } else {
                    if (i == 1 && a.this.g != null) {
                        a.this.g.c(i);
                    }
                    a.this.b(bitmap);
                }
            }
        });
    }

    private void f() {
        Context context;
        float f;
        this.b = com.opos.cmn.an.h.f.a.a(this.f, 360.0f);
        this.f12877c = com.opos.cmn.an.h.f.a.a(this.f, 60.0f);
        int i = this.i;
        if (i != 0) {
            f = 91.43f;
            if (i != 1) {
                if (i == 2) {
                    this.d = com.opos.cmn.an.h.f.a.a(this.f, 91.43f);
                    this.q = true;
                } else if (i == 3) {
                    context = this.f;
                    f = 48.0f;
                }
                this.e = this.f12877c;
            }
            context = this.f;
        } else {
            context = this.f;
            f = 106.67f;
        }
        this.d = com.opos.cmn.an.h.f.a.a(context, f);
        this.e = this.f12877c;
    }

    private void g() {
        this.p = new RelativeLayout(this.f);
        ImageView imageView = new ImageView(this.f);
        this.p.setId(View.generateViewId());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.opos_mobad_drawable_block_close);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f, 16.0f), com.opos.cmn.an.h.f.a.a(this.f, 16.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f, 4.0f);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.b.a.2
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (a.this.g != null) {
                    a.this.g.d(view, iArr);
                }
            }
        };
        imageView.setOnTouchListener(gVar);
        imageView.setOnClickListener(gVar);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.b, -2);
        this.p.addView(imageView, layoutParams);
        this.l.addView(this.p, layoutParams2);
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f);
        this.m = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        this.m.setBackgroundColor(this.f.getResources().getColor(R.color.opos_mobad_root_bg_color));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f12877c);
        this.m.setVisibility(4);
        this.l.addView(this.m, layoutParams);
        if (this.i == 3) {
            j();
        } else {
            if (this.q) {
                l();
            } else {
                m();
            }
            i();
        }
        k();
    }

    private void i() {
        this.u = e.a(this.f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f, 11.0f));
        layoutParams.addRule(9);
        this.m.addView(this.u, layoutParams);
    }

    private void j() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f);
        this.t = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        int a2 = com.opos.cmn.an.h.f.a.a(this.f, 0.33f);
        this.t.setPadding(a2, a2, a2, a2);
        this.t.setBackgroundResource(R.drawable.opos_mobad_drawable_block_icon_stroke);
        int i = this.d;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        layoutParams.addRule(15);
        this.t.setVisibility(8);
        Context context = this.f;
        f fVar = new f(context, com.opos.cmn.an.h.f.a.a(context, 8.0f));
        this.s = fVar;
        fVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.t.addView(this.s, new RelativeLayout.LayoutParams(-1, -1));
        this.m.addView(this.t, layoutParams);
    }

    private void k() {
        this.n = this.i == 3 ? d.b(this.f) : d.a(this.f);
        this.n.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b - this.d, -2);
        layoutParams.addRule(15);
        if (this.i == 3) {
            a(layoutParams);
        } else {
            b(layoutParams);
        }
        this.n.setVisibility(4);
        this.m.addView(this.n, layoutParams);
    }

    private void l() {
        y b = y.b(this.f, this.d, this.f12877c, false);
        this.o = b;
        b.setId(View.generateViewId());
        int i = this.d;
        this.m.addView(this.o, new RelativeLayout.LayoutParams(i, i));
    }

    private void m() {
        ImageView imageView = new ImageView(this.f);
        this.k = imageView;
        imageView.setId(View.generateViewId());
        this.m.addView(this.k, new RelativeLayout.LayoutParams(this.d, this.f12877c));
    }

    private void n() {
        final com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f);
        aVar.a(new a.InterfaceC0508a() { // from class: com.opos.mobad.n.b.a.3
            @Override // com.opos.mobad.c.d.a.InterfaceC0508a
            public void a(boolean z) {
                if (a.this.j == null) {
                    return;
                }
                if (z) {
                    if (a.this.g != null) {
                        a.this.g.b();
                    }
                    aVar.a((a.InterfaceC0508a) null);
                }
                com.opos.cmn.an.f.a.b("BannerBigImage", "blockBigImage7 onWindowVisibilityChanged：" + z);
            }
        });
        this.l.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void o() {
        this.m.setVisibility(0);
        this.n.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.g = interfaceC0538a;
        this.n.a(interfaceC0538a);
        y yVar = this.o;
        if (yVar != null) {
            yVar.a(interfaceC0538a);
        }
        e eVar = this.u;
        if (eVar != null) {
            eVar.a(interfaceC0538a);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a(h hVar) {
        a.InterfaceC0538a interfaceC0538a;
        String str;
        if (hVar == null) {
            str = "data is null";
        } else {
            com.opos.mobad.n.d.d a2 = hVar.a();
            if (a2 == null) {
                str = "adShowData is null";
            } else if (this.i != 3 && (a2.g == null || a2.g.size() <= 0)) {
                str = "imgList is null";
            } else if (this.i != 3 || (a2.m != null && !TextUtils.isEmpty(a2.m.f12945a))) {
                com.opos.cmn.an.f.a.b("BannerBigImage", "render");
                if (this.j == null && (interfaceC0538a = this.g) != null) {
                    interfaceC0538a.e();
                }
                this.j = a2;
                j jVar = this.r;
                if (jVar != null && jVar.getVisibility() != 0) {
                    this.r.setVisibility(0);
                }
                RelativeLayout relativeLayout = this.l;
                if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                    this.l.setVisibility(0);
                }
                a(a2);
                return;
            } else {
                str = "icon is null";
            }
        }
        com.opos.cmn.an.f.a.b("BannerBigImage", str);
        this.g.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.r;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BannerBigImage", "destroy");
        this.j = null;
        this.f12876a = true;
        j jVar = this.r;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.h;
    }
}
