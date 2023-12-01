package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.a;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.j;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/ab.class */
public class ab implements com.opos.mobad.n.a {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f26761a = false;
    private int b = 320;

    /* renamed from: c  reason: collision with root package name */
    private int f26762c = 141;
    private int d = 0;
    private int e = 0;
    private int f;
    private Context g;
    private a.InterfaceC0708a h;
    private int i;
    private int j;
    private com.opos.mobad.n.d.d k;
    private com.opos.mobad.n.c.f l;
    private com.opos.mobad.n.c.f m;
    private com.opos.mobad.n.c.f n;
    private ad o;
    private TextView p;
    private RelativeLayout q;
    private com.opos.mobad.n.c.h r;
    private com.opos.mobad.n.c.j s;
    private com.opos.mobad.c.a t;

    private ab(Context context, aj ajVar, int i, int i2, com.opos.mobad.c.a aVar) {
        this.g = context;
        this.j = i2;
        this.i = i;
        this.t = aVar;
        f();
        a(ajVar);
        i();
    }

    public static ab a(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new ab(context, ajVar, i, 1, aVar);
    }

    private void a(LinearLayout linearLayout) {
        Context context = this.g;
        this.l = new com.opos.mobad.n.c.f(context, com.opos.cmn.an.h.f.a.a(context, 4.0f));
        linearLayout.addView(this.l, new LinearLayout.LayoutParams(this.d, this.e));
        this.l.setVisibility(8);
        Context context2 = this.g;
        this.m = new com.opos.mobad.n.c.f(context2, com.opos.cmn.an.h.f.a.a(context2, 4.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.d, this.e);
        int a2 = com.opos.cmn.an.h.f.a.a(this.g, 10.0f);
        layoutParams.leftMargin = a2;
        linearLayout.addView(this.m, layoutParams);
        this.m.setVisibility(8);
        Context context3 = this.g;
        this.n = new com.opos.mobad.n.c.f(context3, com.opos.cmn.an.h.f.a.a(context3, 4.0f));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.d, this.e);
        layoutParams2.leftMargin = a2;
        linearLayout.addView(this.n, layoutParams2);
        this.n.setVisibility(8);
    }

    private void a(final com.opos.mobad.n.c.f fVar, final com.opos.mobad.n.d.g gVar) {
        if (fVar == null || gVar == null || TextUtils.isEmpty(gVar.f26633a)) {
            return;
        }
        fVar.setVisibility(0);
        fVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.t.a(gVar.f26633a, gVar.b, this.b, this.f26762c, new a.InterfaceC0676a() { // from class: com.opos.mobad.n.g.ab.3
            @Override // com.opos.mobad.c.a.InterfaceC0676a
            public void a(int i, final Bitmap bitmap) {
                if (ab.this.f26761a) {
                    return;
                }
                if (gVar == null) {
                    com.opos.cmn.an.f.a.b("BlockSmallImage9", "null imgList");
                } else if (i != 0 && i != 1) {
                    if (ab.this.h != null) {
                        ab.this.h.c(i);
                    }
                } else {
                    if (i == 1 && ab.this.h != null) {
                        ab.this.h.c(i);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.ab.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (ab.this.f26761a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            fVar.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        c(dVar);
        this.o.a(dVar.r, dVar.s, dVar.i, dVar.j, dVar.k, dVar.B, dVar.f);
        b(dVar);
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
        this.s = new com.opos.mobad.n.c.j(context, new j.a(i, i2, i3, i3 / this.f));
        this.q = new RelativeLayout(this.g);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, -2);
        layoutParams.width = this.b;
        layoutParams.height = -2;
        this.q.setId(View.generateViewId());
        this.q.setLayoutParams(layoutParams);
        this.q.setVisibility(8);
        this.s.addView(this.q, layoutParams);
        this.s.setLayoutParams(layoutParams);
        g();
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.ab.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (ab.this.h != null) {
                    ab.this.h.g(view, iArr);
                }
            }
        };
        this.q.setOnClickListener(gVar);
        this.q.setOnTouchListener(gVar);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        String str = dVar.e;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.p.setText(str);
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        if (dVar.g == null || dVar.g.size() == 0) {
            return;
        }
        a(this.l, dVar.g.get(0));
        if (dVar.g.size() >= 2) {
            a(this.m, dVar.g.get(1));
        }
        if (dVar.g.size() >= 3) {
            a(this.n, dVar.g.get(2));
        }
    }

    private void f() {
        this.d = com.opos.cmn.an.h.f.a.a(this.g, 100.0f);
        this.e = com.opos.cmn.an.h.f.a.a(this.g, 65.62f);
        if (this.j == 1) {
            this.b = com.opos.cmn.an.h.f.a.a(this.g, 320.0f);
            this.f26762c = com.opos.cmn.an.h.f.a.a(this.g, 141.62f);
        }
        this.f = this.f26762c;
    }

    private void g() {
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.g);
        this.r = hVar;
        hVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f26762c);
        this.r.setVisibility(4);
        this.q.addView(this.r, layoutParams);
        h();
    }

    private void h() {
        TextView textView = new TextView(this.g);
        this.p = textView;
        textView.setId(View.generateViewId());
        this.p.setTextColor(this.g.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.p.setTextSize(1, 17.0f);
        this.p.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.p.setMaxLines(2);
        this.r.addView(this.p, new RelativeLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(this.g);
        linearLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.e);
        layoutParams.addRule(3, this.p.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 8.0f);
        a(linearLayout);
        this.r.addView(linearLayout, layoutParams);
        this.o = ad.a(this.g);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 320.0f), -2);
        layoutParams2.addRule(3, linearLayout.getId());
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.g, 6.0f);
        this.r.addView(this.o, layoutParams2);
    }

    private void i() {
        final com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.g);
        aVar.a(new a.InterfaceC0678a() { // from class: com.opos.mobad.n.g.ab.2
            @Override // com.opos.mobad.c.d.a.InterfaceC0678a
            public void a(boolean z) {
                if (ab.this.k == null) {
                    return;
                }
                if (z) {
                    ab.this.j();
                    if (ab.this.h != null) {
                        ab.this.h.b();
                    }
                    aVar.a((a.InterfaceC0678a) null);
                }
                com.opos.cmn.an.f.a.b("BlockSmallImage9", "BlockSmallImage9 onWindowVisibilityChanged：" + z);
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
        this.h = interfaceC0708a;
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
                com.opos.cmn.an.f.a.b("BlockSmallImage9", "render");
                if (this.k == null && (interfaceC0708a = this.h) != null) {
                    interfaceC0708a.e();
                }
                this.k = a2;
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
        com.opos.cmn.an.f.a.b("BlockSmallImage9", str);
        this.h.b(1);
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
        com.opos.cmn.an.f.a.b("BlockSmallImage9", "destroy");
        this.k = null;
        this.f26761a = true;
        com.opos.mobad.n.c.j jVar = this.s;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.i;
    }
}
