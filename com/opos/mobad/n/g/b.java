package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.a;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.j;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/b.class */
public class b implements com.opos.mobad.n.a {
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f26799c;
    private int f;
    private Context h;
    private a.InterfaceC0708a i;
    private int j;
    private int k;
    private com.opos.mobad.n.d.d l;
    private ImageView m;
    private ad n;
    private TextView o;
    private x p;
    private RelativeLayout q;
    private com.opos.mobad.n.c.h r;
    private com.opos.mobad.n.c.j s;
    private com.opos.mobad.c.a t;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f26798a = false;
    private int d = 0;
    private int e = 0;
    private boolean g = false;

    private b(Context context, aj ajVar, int i, int i2, com.opos.mobad.c.a aVar) {
        this.h = context;
        this.k = i2;
        this.j = i;
        this.t = aVar;
        f();
        a(ajVar);
        i();
    }

    public static b a(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new b(context, ajVar, i, 0, aVar);
    }

    private void a(final ImageView imageView, final com.opos.mobad.n.d.g gVar) {
        if (imageView == null || gVar == null || TextUtils.isEmpty(gVar.f26633a)) {
            return;
        }
        imageView.setVisibility(0);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.t.a(gVar.f26633a, gVar.b, this.b, this.f26799c, new a.InterfaceC0676a() { // from class: com.opos.mobad.n.g.b.3
            @Override // com.opos.mobad.c.a.InterfaceC0676a
            public void a(int i, final Bitmap bitmap) {
                if (b.this.f26798a) {
                    return;
                }
                if (gVar == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage10", "null imgList");
                } else if (i != 0 && i != 1) {
                    if (b.this.i != null) {
                        b.this.i.c(i);
                    }
                } else {
                    if (i == 1 && b.this.i != null) {
                        b.this.i.c(i);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.b.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (b.this.f26798a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            imageView.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void a(com.opos.mobad.n.c.h hVar) {
        this.m = new ImageView(this.h);
        hVar.addView(this.m, new RelativeLayout.LayoutParams(this.d, this.e));
        this.m.setVisibility(8);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        if (this.g) {
            d(dVar);
        } else {
            c(dVar);
        }
        this.n.a(dVar.r, dVar.s, dVar.i, dVar.j, dVar.k, dVar.B, dVar.f);
        b(dVar);
    }

    private void a(aj ajVar) {
        aj ajVar2 = ajVar;
        if (ajVar == null) {
            ajVar2 = aj.a(this.h);
        }
        Context context = this.h;
        int i = ajVar2.f26797a;
        int i2 = ajVar2.b;
        int i3 = this.b;
        this.s = new com.opos.mobad.n.c.j(context, new j.a(i, i2, i3, i3 / this.f));
        this.q = new RelativeLayout(this.h);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, -2);
        layoutParams.width = this.b;
        layoutParams.height = -2;
        this.q.setId(View.generateViewId());
        this.q.setLayoutParams(layoutParams);
        this.q.setVisibility(8);
        this.s.addView(this.q, layoutParams);
        this.s.setLayoutParams(layoutParams);
        g();
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.b.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (b.this.i != null) {
                    b.this.i.g(view, iArr);
                }
            }
        };
        this.q.setOnClickListener(gVar);
        this.q.setOnTouchListener(gVar);
    }

    public static b b(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new b(context, ajVar, i, 1, aVar);
    }

    private void b(com.opos.mobad.n.c.h hVar) {
        this.p = x.a(this.h, this.d, this.e);
        hVar.addView(this.p, new RelativeLayout.LayoutParams(this.d, this.e));
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        String str = dVar.e;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.o.setText(str);
    }

    public static b c(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new b(context, ajVar, i, 2, aVar);
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        if (dVar.g == null || dVar.g.size() == 0) {
            return;
        }
        a(this.m, dVar.g.get(0));
    }

    private void d(com.opos.mobad.n.d.d dVar) {
        x xVar;
        if (dVar.g == null || dVar.g.size() == 0 || (xVar = this.p) == null) {
            return;
        }
        xVar.a(dVar, this.t, this.f26798a);
    }

    private void f() {
        int a2;
        this.d = com.opos.cmn.an.h.f.a.a(this.h, 320.0f);
        int i = this.k;
        if (i == 0) {
            this.b = com.opos.cmn.an.h.f.a.a(this.h, 320.0f);
            this.f26799c = com.opos.cmn.an.h.f.a.a(this.h, 258.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.h, 180.0f);
        } else if (i != 1) {
            if (i == 2) {
                this.b = com.opos.cmn.an.h.f.a.a(this.h, 320.0f);
                this.f26799c = com.opos.cmn.an.h.f.a.a(this.h, 288.0f);
                this.e = com.opos.cmn.an.h.f.a.a(this.h, 210.0f);
                this.g = true;
            }
            this.f = this.f26799c;
        } else {
            this.b = com.opos.cmn.an.h.f.a.a(this.h, 320.0f);
            this.f26799c = com.opos.cmn.an.h.f.a.a(this.h, 288.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.h, 210.0f);
        }
        this.e = a2;
        this.f = this.f26799c;
    }

    private void g() {
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.h);
        this.r = hVar;
        hVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f26799c);
        this.r.setVisibility(4);
        this.q.addView(this.r, layoutParams);
        h();
    }

    private void h() {
        TextView textView = new TextView(this.h);
        this.o = textView;
        textView.setId(View.generateViewId());
        this.o.setTextColor(this.h.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.o.setTextSize(1, 17.0f);
        this.o.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.o.setMaxLines(2);
        this.r.addView(this.o, new RelativeLayout.LayoutParams(-1, -2));
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.h);
        hVar.a(com.opos.cmn.an.h.f.a.a(this.h, 6.0f));
        hVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.e);
        layoutParams.addRule(3, this.o.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.h, 8.0f);
        if (this.g) {
            b(hVar);
        } else {
            a(hVar);
        }
        this.r.addView(hVar, layoutParams);
        this.n = ad.a(this.h);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.h, 320.0f), -2);
        layoutParams2.addRule(3, hVar.getId());
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.h, 6.0f);
        this.r.addView(this.n, layoutParams2);
    }

    private void i() {
        final com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.h);
        aVar.a(new a.InterfaceC0678a() { // from class: com.opos.mobad.n.g.b.2
            @Override // com.opos.mobad.c.d.a.InterfaceC0678a
            public void a(boolean z) {
                if (b.this.l == null) {
                    return;
                }
                if (z) {
                    b.this.j();
                    if (b.this.i != null) {
                        b.this.i.b();
                    }
                    aVar.a((a.InterfaceC0678a) null);
                }
                com.opos.cmn.an.f.a.b("BlockBigImage10", "BlockBigImage10 onWindowVisibilityChanged：" + z);
            }
        });
        this.q.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.r.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.i = interfaceC0708a;
        this.n.a(interfaceC0708a);
        x xVar = this.p;
        if (xVar != null) {
            xVar.a(interfaceC0708a);
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
                com.opos.cmn.an.f.a.b("BlockBigImage10", "render");
                if (this.l == null && (interfaceC0708a = this.i) != null) {
                    interfaceC0708a.e();
                }
                this.l = a2;
                com.opos.mobad.n.c.j jVar = this.s;
                if (jVar != null && jVar.getVisibility() != 0) {
                    this.s.setVisibility(0);
                }
                RelativeLayout relativeLayout = this.q;
                if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                    this.q.setVisibility(0);
                }
                a(a2);
                return;
            } else {
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BlockBigImage10", str);
        this.i.b(1);
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
        com.opos.cmn.an.f.a.b("BlockBigImage10", "destroy");
        this.l = null;
        this.f26798a = true;
        com.opos.mobad.n.c.j jVar = this.s;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.j;
    }
}
