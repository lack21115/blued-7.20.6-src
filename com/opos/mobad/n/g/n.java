package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
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
import com.opos.mobad.n.g.ad;
import com.opos.mobad.n.g.ag;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/n.class */
public class n implements com.opos.mobad.n.a {
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f26880c;
    private int d;
    private Context f;
    private a.InterfaceC0708a g;
    private int h;
    private ad i;
    private TextView j;
    private com.opos.mobad.n.d.e k;
    private com.opos.mobad.n.c.f l;
    private TextView m;
    private RelativeLayout n;
    private com.opos.mobad.n.c.h o;
    private com.opos.mobad.n.c.j p;
    private ag q;
    private ah r;
    private com.opos.mobad.c.a t;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f26879a = false;
    private int e = 0;
    private boolean u = false;
    private Runnable v = new Runnable() { // from class: com.opos.mobad.n.g.n.1
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f26879a) {
                return;
            }
            int g = n.this.q.g();
            int h = n.this.q.h();
            if (n.this.g != null) {
                n.this.g.d(g, h);
            }
            n.this.q.f();
            n.this.s.postDelayed(this, 500L);
        }
    };
    private Handler s = new Handler(Looper.getMainLooper());

    private n(Context context, aj ajVar, int i, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        this.f = context;
        this.h = i;
        this.t = aVar2;
        f();
        a(ajVar, aVar);
        g();
    }

    public static n a(Context context, aj ajVar, int i, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new n(context, ajVar, i, aVar, aVar2);
    }

    private void a(RelativeLayout relativeLayout) {
        relativeLayout.setId(View.generateViewId());
        int a2 = com.opos.cmn.an.h.f.a.a(this.f, 36.0f);
        this.o.addView(relativeLayout, new RelativeLayout.LayoutParams(this.b, a2));
        Context context = this.f;
        com.opos.mobad.n.c.f fVar = new com.opos.mobad.n.c.f(context, com.opos.cmn.an.h.f.a.a(context, 33.33f));
        this.l = fVar;
        fVar.setId(View.generateViewId());
        relativeLayout.addView(this.l, new RelativeLayout.LayoutParams(a2, a2));
        TextView textView = new TextView(this.f);
        this.m = textView;
        textView.setTextColor(this.f.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.m.setTextSize(1, 14.0f);
        this.m.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.m.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f, 8.0f);
        layoutParams.addRule(15);
        layoutParams.addRule(1, this.l.getId());
        relativeLayout.addView(this.m, layoutParams);
    }

    private void a(com.opos.mobad.c.c.a aVar) {
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f);
        this.o = hVar;
        hVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f26880c);
        this.o.setVisibility(4);
        this.n.addView(this.o, layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.f);
        a(relativeLayout);
        b(relativeLayout);
        com.opos.mobad.n.c.h hVar2 = new com.opos.mobad.n.c.h(this.f);
        a(hVar2);
        a(aVar, hVar2);
        c(hVar2);
        b(hVar2);
    }

    private void a(com.opos.mobad.c.c.a aVar, com.opos.mobad.n.c.h hVar) {
        this.q = ag.a(this.f, this.b, this.e, aVar);
        hVar.addView(this.q, new RelativeLayout.LayoutParams(this.b, this.e));
        this.q.a(new ag.a() { // from class: com.opos.mobad.n.g.n.4
            @Override // com.opos.mobad.n.g.ag.a
            public void a() {
                n.this.s.removeCallbacks(n.this.v);
                n.this.s.postDelayed(n.this.v, 500L);
            }

            @Override // com.opos.mobad.n.g.ag.a
            public void b() {
                n.this.s.removeCallbacks(n.this.v);
            }
        });
    }

    private void a(com.opos.mobad.n.c.h hVar) {
        hVar.a(com.opos.cmn.an.h.f.a.a(this.f, 6.0f));
        hVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.e);
        layoutParams.addRule(3, this.j.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 8.0f);
        this.o.addView(hVar, layoutParams);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        String str = dVar.e;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.j.setText(str);
    }

    private void a(com.opos.mobad.n.d.e eVar) {
        this.i.a(eVar.r, eVar.s, eVar.i, eVar.j, eVar.k, eVar.B, eVar.f);
        a((com.opos.mobad.n.d.d) eVar);
        b(eVar);
        this.r.a(eVar.B);
    }

    private void a(com.opos.mobad.n.d.g gVar, com.opos.mobad.c.a aVar, final boolean z) {
        com.opos.mobad.n.c.f fVar;
        if (gVar == null || (fVar = this.l) == null) {
            com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "iconUrl is null");
            return;
        }
        fVar.setVisibility(0);
        this.l.setScaleType(ImageView.ScaleType.FIT_XY);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f, 36.0f);
        aVar.a(gVar.f26633a, gVar.b, a2, a2, new a.InterfaceC0676a() { // from class: com.opos.mobad.n.g.n.6
            @Override // com.opos.mobad.c.a.InterfaceC0676a
            public void a(int i, final Bitmap bitmap) {
                if (z) {
                    return;
                }
                if (i != 0 && i != 1) {
                    if (n.this.g != null) {
                        n.this.g.c(i);
                        return;
                    }
                    return;
                }
                if (i == 1 && n.this.g != null) {
                    n.this.g.c(i);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.n.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (z || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        n.this.l.setImageBitmap(bitmap);
                    }
                });
            }
        });
    }

    private void a(aj ajVar, com.opos.mobad.c.c.a aVar) {
        aj ajVar2 = ajVar;
        if (ajVar == null) {
            ajVar2 = aj.a(this.f);
        }
        Context context = this.f;
        int i = ajVar2.f26797a;
        int i2 = ajVar2.b;
        int i3 = this.b;
        this.p = new com.opos.mobad.n.c.j(context, new j.a(i, i2, i3, i3 / this.d));
        this.n = new RelativeLayout(this.f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, -2);
        layoutParams.width = this.b;
        layoutParams.height = -2;
        this.n.setId(View.generateViewId());
        this.n.setLayoutParams(layoutParams);
        this.n.setVisibility(8);
        this.p.addView(this.n, layoutParams);
        this.p.setLayoutParams(layoutParams);
        a(aVar);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.n.3
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (n.this.g != null) {
                    n.this.g.g(view, iArr);
                }
            }
        };
        this.n.setOnClickListener(gVar);
        this.n.setOnTouchListener(gVar);
    }

    private void b(RelativeLayout relativeLayout) {
        TextView textView = new TextView(this.f);
        this.j = textView;
        textView.setId(View.generateViewId());
        this.j.setTextColor(this.f.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.j.setTextSize(1, 17.0f);
        this.j.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.j.setMaxLines(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, relativeLayout.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        this.o.addView(this.j, layoutParams);
    }

    private void b(com.opos.mobad.n.c.h hVar) {
        this.i = ad.a(this.f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        layoutParams.addRule(3, hVar.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 6.0f);
        this.o.addView(this.i, layoutParams);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        String str = dVar.f;
        if (!TextUtils.isEmpty(str)) {
            this.m.setText(str);
        }
        if (dVar.m != null && !TextUtils.isEmpty(dVar.m.f26633a) && this.t != null) {
            a(dVar.m, this.t, this.f26879a);
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "BlockBigImageVideo12 iconUrl is null");
        this.l.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.m.setLayoutParams(layoutParams);
    }

    private void c(com.opos.mobad.n.c.h hVar) {
        this.r = ah.a(this.f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f, 10.0f);
        hVar.addView(this.r, layoutParams);
    }

    private void f() {
        this.b = com.opos.cmn.an.h.f.a.a(this.f, 320.0f);
        this.f26880c = com.opos.cmn.an.h.f.a.a(this.f, 306.0f);
        this.e = com.opos.cmn.an.h.f.a.a(this.f, 180.0f);
        this.d = this.f26880c;
    }

    private void g() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f);
        aVar.a(new a.InterfaceC0678a() { // from class: com.opos.mobad.n.g.n.5
            @Override // com.opos.mobad.c.d.a.InterfaceC0678a
            public void a(boolean z) {
                if (n.this.k == null) {
                    return;
                }
                if (z && !n.this.u) {
                    n.this.u = true;
                    n.this.h();
                    if (n.this.g != null) {
                        n.this.g.b();
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "BlockBigImageVideo12 onWindowVisibilityChanged：" + z);
                if (z) {
                    n.this.q.d();
                } else {
                    n.this.q.e();
                }
            }
        });
        this.n.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.o.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        if (!this.f26879a) {
            this.q.a();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "current state has stop mDestroy =" + this.f26879a);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.g = interfaceC0708a;
        this.q.a(interfaceC0708a);
        this.i.a(interfaceC0708a);
        this.r.a(interfaceC0708a);
        this.r.a(new ad.a() { // from class: com.opos.mobad.n.g.n.2
            @Override // com.opos.mobad.n.g.ad.a
            public void a(int i) {
                n.this.q.a(i);
            }
        });
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0708a interfaceC0708a;
        a.InterfaceC0708a interfaceC0708a2;
        if (hVar == null) {
            com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "data is null");
            interfaceC0708a2 = this.g;
        } else {
            com.opos.mobad.n.d.e b = hVar.b();
            if (b != null) {
                com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "render");
                if (!TextUtils.isEmpty(b.f26630a.f26633a) && this.k == null) {
                    this.q.a(b);
                }
                if (this.k == null && (interfaceC0708a = this.g) != null) {
                    interfaceC0708a.e();
                }
                this.k = b;
                com.opos.mobad.n.c.j jVar = this.p;
                if (jVar != null && jVar.getVisibility() != 0) {
                    this.p.setVisibility(0);
                }
                RelativeLayout relativeLayout = this.n;
                if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                    this.n.setVisibility(0);
                }
                a(b);
                return;
            }
            com.opos.cmn.an.f.a.d("", "render with data null");
            interfaceC0708a2 = this.g;
            if (interfaceC0708a2 == null) {
                return;
            }
        }
        interfaceC0708a2.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "start countdown...");
        if (!this.f26879a) {
            this.q.b();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "error state mDestroy " + this.f26879a);
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.p;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "destroy");
        this.f26879a = true;
        ag agVar = this.q;
        if (agVar != null) {
            agVar.c();
        }
        this.k = null;
        this.s.removeCallbacks(this.v);
        com.opos.mobad.n.c.j jVar = this.p;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.h;
    }
}
