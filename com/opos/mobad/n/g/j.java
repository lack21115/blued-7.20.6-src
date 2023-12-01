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

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/j.class */
public class j implements com.opos.mobad.n.a {
    private int e;
    private Context f;
    private a.InterfaceC0538a g;
    private int h;
    private int i;
    private com.opos.mobad.n.d.d j;
    private ImageView k;
    private RelativeLayout l;
    private com.opos.mobad.n.c.h m;
    private w n;
    private z o;
    private y p;
    private RelativeLayout q;
    private com.opos.mobad.n.c.j s;
    private com.opos.mobad.c.a t;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f13163a = false;
    private int b = 320;

    /* renamed from: c  reason: collision with root package name */
    private int f13164c = 60;
    private int d = 0;
    private boolean r = false;

    private j(Context context, aj ajVar, int i, int i2, com.opos.mobad.c.a aVar) {
        this.f = context;
        this.i = i2;
        this.h = i;
        this.t = aVar;
        f();
        a(ajVar);
        m();
    }

    public static j a(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new j(context, ajVar, i, 0, aVar);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        c(dVar);
        if (this.r) {
            b(dVar);
        } else {
            d(dVar);
        }
        e(dVar);
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
        this.s = new com.opos.mobad.n.c.j(context, new j.a(i, i2, i3, i3 / this.e));
        this.l = new RelativeLayout(this.f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, -2);
        layoutParams.width = this.b;
        layoutParams.height = -2;
        this.l.setId(View.generateViewId());
        this.l.setLayoutParams(layoutParams);
        this.l.setVisibility(8);
        this.s.addView(this.l, layoutParams);
        this.s.setLayoutParams(layoutParams);
        g();
        h();
        l();
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.j.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (j.this.g != null) {
                    j.this.g.g(view, iArr);
                }
            }
        };
        this.l.setOnClickListener(gVar);
        this.l.setOnTouchListener(gVar);
    }

    public static j b(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new j(context, ajVar, i, 1, aVar);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        y yVar;
        if (dVar.g == null || dVar.g.size() == 0 || (yVar = this.p) == null) {
            return;
        }
        yVar.a(dVar, this.t, this.f13163a, dVar.z);
    }

    public static j c(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new j(context, ajVar, i, 2, aVar);
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        this.n.a(dVar.l, dVar.f, dVar.e);
    }

    private void d(final com.opos.mobad.n.d.d dVar) {
        ImageView imageView;
        if (dVar.g == null || dVar.g.size() == 0 || (imageView = this.k) == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.t.a(dVar.g.get(0).f12945a, dVar.g.get(0).b, this.b, this.f13164c, new a.InterfaceC0506a() { // from class: com.opos.mobad.n.g.j.4
            @Override // com.opos.mobad.c.a.InterfaceC0506a
            public void a(int i, final Bitmap bitmap) {
                if (j.this.f13163a) {
                    return;
                }
                if (dVar.g.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage7", "null imgList");
                } else if (i != 0 && i != 1) {
                    if (j.this.g != null) {
                        j.this.g.c(i);
                    }
                } else {
                    if (i == 1 && j.this.g != null) {
                        j.this.g.c(i);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.j.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (j.this.f13163a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            j.this.k.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void e(com.opos.mobad.n.d.d dVar) {
        z zVar;
        com.opos.mobad.n.d.a aVar = dVar.v;
        if (aVar == null || TextUtils.isEmpty(aVar.f12938a) || TextUtils.isEmpty(aVar.b) || (zVar = this.o) == null) {
            return;
        }
        zVar.setVisibility(0);
        this.o.a(aVar.f12938a, aVar.b);
    }

    private void f() {
        int a2;
        this.d = com.opos.cmn.an.h.f.a.a(this.f, 106.67f);
        int i = this.i;
        if (i == 0) {
            this.b = com.opos.cmn.an.h.f.a.a(this.f, 320.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f, 60.0f);
        } else if (i != 1) {
            if (i == 2) {
                this.b = com.opos.cmn.an.h.f.a.a(this.f, 320.0f);
                this.f13164c = com.opos.cmn.an.h.f.a.a(this.f, 70.0f);
                this.r = true;
            }
            this.e = this.f13164c + com.opos.cmn.an.h.f.a.a(this.f, 16.0f) + com.opos.cmn.an.h.f.a.a(this.f, 24.0f);
        } else {
            this.b = com.opos.cmn.an.h.f.a.a(this.f, 320.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f, 70.0f);
        }
        this.f13164c = a2;
        this.e = this.f13164c + com.opos.cmn.an.h.f.a.a(this.f, 16.0f) + com.opos.cmn.an.h.f.a.a(this.f, 24.0f);
    }

    private void g() {
        this.q = new RelativeLayout(this.f);
        ImageView imageView = new ImageView(this.f);
        this.q.setId(View.generateViewId());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.opos_mobad_drawable_block_close);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f, 16.0f), com.opos.cmn.an.h.f.a.a(this.f, 16.0f));
        layoutParams.addRule(11);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.j.2
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (j.this.g != null) {
                    j.this.g.d(view, iArr);
                }
            }
        };
        imageView.setOnTouchListener(gVar);
        imageView.setOnClickListener(gVar);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.b, -2);
        this.q.addView(imageView, layoutParams);
        this.l.addView(this.q, layoutParams2);
    }

    private void h() {
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f);
        this.m = hVar;
        hVar.a(com.opos.cmn.an.h.f.a.a(this.f, 10.0f));
        this.m.setId(View.generateViewId());
        this.m.setBackgroundColor(this.f.getResources().getColor(R.color.opos_mobad_root_bg_color));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f13164c);
        this.m.setVisibility(4);
        layoutParams.addRule(3, this.q.getId());
        this.l.addView(this.m, layoutParams);
        if (this.r) {
            j();
        } else {
            k();
        }
        i();
    }

    private void i() {
        int id;
        w a2 = w.a(this.f);
        this.n = a2;
        a2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b - this.d, -2);
        layoutParams.addRule(15);
        if (this.r) {
            y yVar = this.p;
            if (yVar != null) {
                id = yVar.getId();
                layoutParams.addRule(1, id);
            }
        } else {
            ImageView imageView = this.k;
            if (imageView != null) {
                id = imageView.getId();
                layoutParams.addRule(1, id);
            }
        }
        this.n.setVisibility(4);
        this.m.addView(this.n, layoutParams);
    }

    private void j() {
        y a2 = y.a(this.f, this.d, this.f13164c, false);
        this.p = a2;
        a2.setId(View.generateViewId());
        int i = this.d;
        this.m.addView(this.p, new RelativeLayout.LayoutParams(i, i));
    }

    private void k() {
        ImageView imageView = new ImageView(this.f);
        this.k = imageView;
        imageView.setId(View.generateViewId());
        this.m.addView(this.k, new RelativeLayout.LayoutParams(this.d, this.f13164c));
    }

    private void l() {
        this.o = z.c(this.f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(3, this.m.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 10.0f);
        this.o.setGravity(1);
        this.o.setVisibility(4);
        this.l.addView(this.o, layoutParams);
    }

    private void m() {
        final com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f);
        aVar.a(new a.InterfaceC0508a() { // from class: com.opos.mobad.n.g.j.3
            @Override // com.opos.mobad.c.d.a.InterfaceC0508a
            public void a(boolean z) {
                if (j.this.j == null) {
                    return;
                }
                if (z) {
                    j.this.n();
                    if (j.this.g != null) {
                        j.this.g.b();
                    }
                    aVar.a((a.InterfaceC0508a) null);
                }
                com.opos.cmn.an.f.a.b("BlockBigImage7", "blockBigImage7 onWindowVisibilityChanged：" + z);
            }
        });
        this.l.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.m.setVisibility(0);
        this.n.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.g = interfaceC0538a;
        this.o.a(interfaceC0538a);
        this.n.a(interfaceC0538a);
        y yVar = this.p;
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
                com.opos.cmn.an.f.a.b("BlockBigImage7", "render");
                if (this.j == null && (interfaceC0538a = this.g) != null) {
                    interfaceC0538a.e();
                }
                this.j = a2;
                com.opos.mobad.n.c.j jVar = this.s;
                if (jVar != null && jVar.getVisibility() != 0) {
                    this.s.setVisibility(0);
                }
                RelativeLayout relativeLayout = this.l;
                if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                    this.l.setVisibility(0);
                }
                a(a2);
                return;
            } else {
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BlockBigImage7", str);
        this.g.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.s;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImage7", "destroy");
        this.j = null;
        this.f13163a = true;
        com.opos.mobad.n.c.j jVar = this.s;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.h;
    }
}
