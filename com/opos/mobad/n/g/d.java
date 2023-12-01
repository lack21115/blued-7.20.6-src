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

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/d.class */
public class d implements com.opos.mobad.n.a {
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f13125c;
    private int f;
    private Context h;
    private a.InterfaceC0538a i;
    private int j;
    private int k;
    private com.opos.mobad.n.d.d l;
    private ImageView m;
    private ad n;
    private TextView o;
    private x p;
    private com.opos.mobad.n.c.f q;
    private TextView r;
    private RelativeLayout s;
    private com.opos.mobad.n.c.h t;
    private com.opos.mobad.n.c.j u;
    private com.opos.mobad.c.a v;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f13124a = false;
    private int d = 0;
    private int e = 0;
    private boolean g = false;

    private d(Context context, aj ajVar, int i, int i2, com.opos.mobad.c.a aVar) {
        this.h = context;
        this.k = i2;
        this.j = i;
        this.v = aVar;
        f();
        a(ajVar);
        i();
    }

    public static d a(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new d(context, ajVar, i, 0, aVar);
    }

    private void a(final ImageView imageView, final com.opos.mobad.n.d.g gVar) {
        if (imageView == null || gVar == null || TextUtils.isEmpty(gVar.f12945a)) {
            return;
        }
        imageView.setVisibility(0);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.v.a(gVar.f12945a, gVar.b, this.b, this.f13125c, new a.InterfaceC0506a() { // from class: com.opos.mobad.n.g.d.3
            @Override // com.opos.mobad.c.a.InterfaceC0506a
            public void a(int i, final Bitmap bitmap) {
                if (d.this.f13124a) {
                    return;
                }
                if (gVar == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage12", "null imgList");
                } else if (i != 0 && i != 1) {
                    if (d.this.i != null) {
                        d.this.i.c(i);
                    }
                } else {
                    if (i == 1 && d.this.i != null) {
                        d.this.i.c(i);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.d.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (d.this.f13124a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            imageView.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void a(RelativeLayout relativeLayout) {
        relativeLayout.setId(View.generateViewId());
        int a2 = com.opos.cmn.an.h.f.a.a(this.h, 36.0f);
        this.t.addView(relativeLayout, new RelativeLayout.LayoutParams(this.b, a2));
        Context context = this.h;
        com.opos.mobad.n.c.f fVar = new com.opos.mobad.n.c.f(context, com.opos.cmn.an.h.f.a.a(context, 33.33f));
        this.q = fVar;
        fVar.setId(View.generateViewId());
        relativeLayout.addView(this.q, new RelativeLayout.LayoutParams(a2, a2));
        TextView textView = new TextView(this.h);
        this.r = textView;
        textView.setTextColor(this.h.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.r.setTextSize(1, 14.0f);
        this.r.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.r.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.h, 8.0f);
        layoutParams.addRule(15);
        layoutParams.addRule(1, this.q.getId());
        relativeLayout.addView(this.r, layoutParams);
    }

    private void a(com.opos.mobad.n.c.h hVar) {
        hVar.a(com.opos.cmn.an.h.f.a.a(this.h, 6.0f));
        hVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.e);
        layoutParams.addRule(3, this.o.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.h, 8.0f);
        if (this.g) {
            d(hVar);
        } else {
            c(hVar);
        }
        this.t.addView(hVar, layoutParams);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        if (this.g) {
            e(dVar);
        } else {
            d(dVar);
        }
        this.n.a(dVar.r, dVar.s, dVar.i, dVar.j, dVar.k, dVar.B, dVar.f);
        c(dVar);
        b(dVar);
    }

    private void a(com.opos.mobad.n.d.g gVar, com.opos.mobad.c.a aVar, final boolean z) {
        com.opos.mobad.n.c.f fVar;
        if (gVar == null || (fVar = this.q) == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage12", "iconUrl is null");
            return;
        }
        fVar.setVisibility(0);
        this.q.setScaleType(ImageView.ScaleType.FIT_XY);
        int a2 = com.opos.cmn.an.h.f.a.a(this.h, 36.0f);
        aVar.a(gVar.f12945a, gVar.b, a2, a2, new a.InterfaceC0506a() { // from class: com.opos.mobad.n.g.d.4
            @Override // com.opos.mobad.c.a.InterfaceC0506a
            public void a(int i, final Bitmap bitmap) {
                if (z) {
                    return;
                }
                if (i != 0 && i != 1) {
                    if (d.this.i != null) {
                        d.this.i.c(i);
                        return;
                    }
                    return;
                }
                if (i == 1 && d.this.i != null) {
                    d.this.i.c(i);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.d.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (z || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        d.this.q.setImageBitmap(bitmap);
                    }
                });
            }
        });
    }

    private void a(aj ajVar) {
        aj ajVar2 = ajVar;
        if (ajVar == null) {
            ajVar2 = aj.a(this.h);
        }
        Context context = this.h;
        int i = ajVar2.f13109a;
        int i2 = ajVar2.b;
        int i3 = this.b;
        this.u = new com.opos.mobad.n.c.j(context, new j.a(i, i2, i3, i3 / this.f));
        this.s = new RelativeLayout(this.h);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, -2);
        layoutParams.width = this.b;
        layoutParams.height = -2;
        this.s.setId(View.generateViewId());
        this.s.setLayoutParams(layoutParams);
        this.s.setVisibility(8);
        this.u.addView(this.s, layoutParams);
        this.u.setLayoutParams(layoutParams);
        g();
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.d.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (d.this.i != null) {
                    d.this.i.g(view, iArr);
                }
            }
        };
        this.s.setOnClickListener(gVar);
        this.s.setOnTouchListener(gVar);
    }

    public static d b(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new d(context, ajVar, i, 1, aVar);
    }

    private void b(RelativeLayout relativeLayout) {
        TextView textView = new TextView(this.h);
        this.o = textView;
        textView.setId(View.generateViewId());
        this.o.setTextColor(this.h.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.o.setTextSize(1, 17.0f);
        this.o.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.o.setMaxLines(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, relativeLayout.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.h, 12.0f);
        this.t.addView(this.o, layoutParams);
    }

    private void b(com.opos.mobad.n.c.h hVar) {
        this.n = ad.b(this.h);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.h, 320.0f), -2);
        layoutParams.addRule(3, hVar.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.h, 6.0f);
        this.t.addView(this.n, layoutParams);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        String str = dVar.f;
        if (!TextUtils.isEmpty(str)) {
            this.r.setText(str);
        }
        if (dVar.m != null && !TextUtils.isEmpty(this.l.m.f12945a) && this.v != null) {
            a(dVar.m, this.v, this.f13124a);
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImage12", "BlockBigImage12 iconUrl is null");
        this.q.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.r.setLayoutParams(layoutParams);
    }

    public static d c(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new d(context, ajVar, i, 2, aVar);
    }

    private void c(com.opos.mobad.n.c.h hVar) {
        this.m = new ImageView(this.h);
        hVar.addView(this.m, new RelativeLayout.LayoutParams(this.d, this.e));
        this.m.setVisibility(8);
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        String str = dVar.e;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.o.setText(str);
    }

    private void d(com.opos.mobad.n.c.h hVar) {
        this.p = x.a(this.h, this.d, this.e);
        hVar.addView(this.p, new RelativeLayout.LayoutParams(this.d, this.e));
    }

    private void d(com.opos.mobad.n.d.d dVar) {
        if (dVar.g == null || dVar.g.size() == 0) {
            return;
        }
        a(this.m, dVar.g.get(0));
    }

    private void e(com.opos.mobad.n.d.d dVar) {
        x xVar;
        if (dVar.g == null || dVar.g.size() == 0 || (xVar = this.p) == null) {
            return;
        }
        xVar.a(dVar, this.v, this.f13124a);
    }

    private void f() {
        int a2;
        this.d = com.opos.cmn.an.h.f.a.a(this.h, 320.0f);
        int i = this.k;
        if (i == 0) {
            this.b = com.opos.cmn.an.h.f.a.a(this.h, 320.0f);
            this.f13125c = com.opos.cmn.an.h.f.a.a(this.h, 306.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.h, 180.0f);
        } else if (i != 1) {
            if (i == 2) {
                this.b = com.opos.cmn.an.h.f.a.a(this.h, 320.0f);
                this.f13125c = com.opos.cmn.an.h.f.a.a(this.h, 338.0f);
                this.e = com.opos.cmn.an.h.f.a.a(this.h, 210.0f);
                this.g = true;
            }
            this.f = this.f13125c;
        } else {
            this.b = com.opos.cmn.an.h.f.a.a(this.h, 320.0f);
            this.f13125c = com.opos.cmn.an.h.f.a.a(this.h, 338.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.h, 210.0f);
        }
        this.e = a2;
        this.f = this.f13125c;
    }

    private void g() {
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.h);
        this.t = hVar;
        hVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f13125c);
        this.t.setVisibility(4);
        this.s.addView(this.t, layoutParams);
        h();
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.h);
        a(relativeLayout);
        b(relativeLayout);
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.h);
        a(hVar);
        b(hVar);
    }

    private void i() {
        final com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.h);
        aVar.a(new a.InterfaceC0508a() { // from class: com.opos.mobad.n.g.d.2
            @Override // com.opos.mobad.c.d.a.InterfaceC0508a
            public void a(boolean z) {
                if (d.this.l == null) {
                    return;
                }
                if (z) {
                    d.this.j();
                    if (d.this.i != null) {
                        d.this.i.b();
                    }
                    aVar.a((a.InterfaceC0508a) null);
                }
                com.opos.cmn.an.f.a.b("BlockBigImage12", "BlockBigImage12 onWindowVisibilityChanged：" + z);
            }
        });
        this.s.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.t.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.i = interfaceC0538a;
        this.n.a(interfaceC0538a);
        x xVar = this.p;
        if (xVar != null) {
            xVar.a(interfaceC0538a);
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
                com.opos.cmn.an.f.a.b("BlockBigImage12", "render");
                if (this.l == null && (interfaceC0538a = this.i) != null) {
                    interfaceC0538a.e();
                }
                this.l = a2;
                com.opos.mobad.n.c.j jVar = this.u;
                if (jVar != null && jVar.getVisibility() != 0) {
                    this.u.setVisibility(0);
                }
                RelativeLayout relativeLayout = this.s;
                if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                    this.s.setVisibility(0);
                }
                a(a2);
                return;
            } else {
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BlockBigImage12", str);
        this.i.b(1);
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
        com.opos.cmn.an.f.a.b("BlockBigImage12", "destroy");
        this.l = null;
        this.f13124a = true;
        com.opos.mobad.n.c.j jVar = this.u;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.j;
    }
}
