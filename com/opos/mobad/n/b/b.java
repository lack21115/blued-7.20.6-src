package com.opos.mobad.n.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.a;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.g;
import com.opos.mobad.n.c.h;
import com.opos.mobad.n.c.j;
import com.opos.mobad.n.g.aj;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/b/b.class */
public class b implements com.opos.mobad.n.a {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f26573a = false;
    private int b = 360;

    /* renamed from: c  reason: collision with root package name */
    private int f26574c = 57;
    private int d;
    private Context e;
    private a.InterfaceC0708a f;
    private int g;
    private int h;
    private com.opos.mobad.n.d.d i;
    private ImageView j;
    private RelativeLayout k;
    private h l;
    private RelativeLayout m;
    private j n;
    private e o;
    private com.opos.mobad.c.a p;

    private b(Context context, aj ajVar, int i, int i2, com.opos.mobad.c.a aVar) {
        this.e = context;
        this.h = i2;
        this.g = i;
        this.p = aVar;
        f();
        a(ajVar);
        k();
    }

    public static b a(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new b(context, ajVar, i, 0, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Bitmap bitmap) {
        com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.b.b.5
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap2;
                if (b.this.f26573a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                    return;
                }
                b.this.j.setImageBitmap(bitmap);
            }
        });
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        c(dVar);
        b(dVar);
    }

    private void a(aj ajVar) {
        aj ajVar2 = ajVar;
        if (ajVar == null) {
            ajVar2 = aj.a(this.e);
        }
        Context context = this.e;
        int i = ajVar2.f26797a;
        int i2 = ajVar2.b;
        int i3 = this.b;
        this.n = new j(context, new j.a(i, i2, i3, i3 / this.d));
        this.k = new RelativeLayout(this.e);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, -2);
        layoutParams.width = this.b;
        layoutParams.height = -2;
        this.k.setId(View.generateViewId());
        this.k.setLayoutParams(layoutParams);
        this.k.setVisibility(8);
        this.n.addView(this.k, layoutParams);
        this.n.setLayoutParams(layoutParams);
        i();
        h();
        g();
        g gVar = new g() { // from class: com.opos.mobad.n.b.b.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (b.this.f != null) {
                    b.this.f.g(view, iArr);
                }
            }
        };
        this.k.setOnClickListener(gVar);
        this.k.setOnTouchListener(gVar);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        this.o.a(dVar.r, dVar.s, dVar.i, dVar.j, dVar.k);
    }

    private void c(final com.opos.mobad.n.d.d dVar) {
        ImageView imageView;
        if (dVar.g == null || dVar.g.size() == 0 || (imageView = this.j) == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.p.a(dVar.g.get(0).f26633a, dVar.g.get(0).b, this.b, this.f26574c, new a.InterfaceC0676a() { // from class: com.opos.mobad.n.b.b.4
            @Override // com.opos.mobad.c.a.InterfaceC0676a
            public void a(int i, Bitmap bitmap) {
                if (b.this.f26573a) {
                    return;
                }
                if (dVar.g.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BannerFullImage", "null imgList");
                } else if (i != 0 && i != 1) {
                    if (b.this.f != null) {
                        b.this.f.c(i);
                    }
                } else {
                    if (i == 1 && b.this.f != null) {
                        b.this.f.c(i);
                    }
                    b.this.a(bitmap);
                }
            }
        });
    }

    private void f() {
        if (this.h == 0) {
            this.b = com.opos.cmn.an.h.f.a.a(this.e, 360.0f);
            this.f26574c = com.opos.cmn.an.h.f.a.a(this.e, 57.0f);
        }
        this.d = this.f26574c;
    }

    private void g() {
        this.m = new RelativeLayout(this.e);
        ImageView imageView = new ImageView(this.e);
        this.m.setId(View.generateViewId());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.opos_mobad_drawable_block_close);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.e, 16.0f), com.opos.cmn.an.h.f.a.a(this.e, 16.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.e, 4.0f);
        g gVar = new g() { // from class: com.opos.mobad.n.b.b.2
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (b.this.f != null) {
                    b.this.f.d(view, iArr);
                }
            }
        };
        imageView.setOnTouchListener(gVar);
        imageView.setOnClickListener(gVar);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.b, -2);
        this.m.addView(imageView, layoutParams);
        this.k.addView(this.m, layoutParams2);
    }

    private void h() {
        this.o = e.a(this.e);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.e, 11.0f));
        layoutParams.addRule(9);
        this.k.addView(this.o, layoutParams);
    }

    private void i() {
        h hVar = new h(this.e);
        this.l = hVar;
        hVar.setId(View.generateViewId());
        this.l.setBackgroundColor(this.e.getResources().getColor(R.color.opos_mobad_root_bg_color));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f26574c);
        this.l.setVisibility(4);
        this.k.addView(this.l, layoutParams);
        j();
    }

    private void j() {
        ImageView imageView = new ImageView(this.e);
        this.j = imageView;
        imageView.setId(View.generateViewId());
        this.l.addView(this.j, new RelativeLayout.LayoutParams(this.b, this.f26574c));
    }

    private void k() {
        final com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.e);
        aVar.a(new a.InterfaceC0678a() { // from class: com.opos.mobad.n.b.b.3
            @Override // com.opos.mobad.c.d.a.InterfaceC0678a
            public void a(boolean z) {
                if (b.this.i == null) {
                    return;
                }
                if (z) {
                    b.this.l();
                    if (b.this.f != null) {
                        b.this.f.b();
                    }
                    aVar.a((a.InterfaceC0678a) null);
                }
                com.opos.cmn.an.f.a.b("BannerFullImage", "BannerFullImage onWindowVisibilityChanged：" + z);
            }
        });
        this.k.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.l.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.f = interfaceC0708a;
        this.o.a(interfaceC0708a);
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
                com.opos.cmn.an.f.a.b("BannerFullImage", "render");
                if (this.i == null && (interfaceC0708a = this.f) != null) {
                    interfaceC0708a.e();
                }
                this.i = a2;
                j jVar = this.n;
                if (jVar != null && jVar.getVisibility() != 0) {
                    this.n.setVisibility(0);
                }
                RelativeLayout relativeLayout = this.k;
                if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                    this.k.setVisibility(0);
                }
                a(a2);
                return;
            } else {
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BannerFullImage", str);
        this.f.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.n;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BannerFullImage", "destroy");
        this.i = null;
        this.f26573a = true;
        j jVar = this.n;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.g;
    }
}
