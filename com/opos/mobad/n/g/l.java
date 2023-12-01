package com.opos.mobad.n.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.j;
import com.opos.mobad.n.g.ad;
import com.opos.mobad.n.g.ag;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/l.class */
public class l implements com.opos.mobad.n.a {
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f26866c;
    private int d;
    private Context f;
    private a.InterfaceC0708a g;
    private int h;
    private ad i;
    private TextView j;
    private com.opos.mobad.n.d.e k;
    private RelativeLayout l;
    private com.opos.mobad.n.c.h m;
    private com.opos.mobad.n.c.j n;
    private ag o;
    private ah p;
    private com.opos.mobad.c.a r;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f26865a = false;
    private int e = 0;
    private boolean s = false;
    private Runnable t = new Runnable() { // from class: com.opos.mobad.n.g.l.1
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.f26865a) {
                return;
            }
            int g = l.this.o.g();
            int h = l.this.o.h();
            if (l.this.g != null) {
                l.this.g.d(g, h);
            }
            l.this.o.f();
            l.this.q.postDelayed(this, 500L);
        }
    };
    private Handler q = new Handler(Looper.getMainLooper());

    private l(Context context, aj ajVar, int i, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        this.f = context;
        this.h = i;
        this.r = aVar2;
        f();
        a(ajVar, aVar);
        h();
    }

    public static l a(Context context, aj ajVar, int i, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new l(context, ajVar, i, aVar, aVar2);
    }

    private void a(com.opos.mobad.c.c.a aVar) {
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f);
        this.m = hVar;
        hVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f26866c);
        this.m.setVisibility(4);
        this.l.addView(this.m, layoutParams);
        g();
        com.opos.mobad.n.c.h hVar2 = new com.opos.mobad.n.c.h(this.f);
        hVar2.a(com.opos.cmn.an.h.f.a.a(this.f, 6.0f));
        hVar2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.b, this.e);
        layoutParams2.addRule(3, this.j.getId());
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 8.0f);
        this.m.addView(hVar2, layoutParams2);
        a(aVar, hVar2);
        b(hVar2);
        a(hVar2);
    }

    private void a(com.opos.mobad.c.c.a aVar, com.opos.mobad.n.c.h hVar) {
        this.o = ag.a(this.f, this.b, this.e, aVar);
        hVar.addView(this.o, new RelativeLayout.LayoutParams(this.b, this.e));
        this.o.a(new ag.a() { // from class: com.opos.mobad.n.g.l.4
            @Override // com.opos.mobad.n.g.ag.a
            public void a() {
                l.this.q.removeCallbacks(l.this.t);
                l.this.q.postDelayed(l.this.t, 500L);
            }

            @Override // com.opos.mobad.n.g.ag.a
            public void b() {
                l.this.q.removeCallbacks(l.this.t);
            }
        });
    }

    private void a(com.opos.mobad.n.c.h hVar) {
        this.i = ad.a(this.f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        layoutParams.addRule(3, hVar.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 6.0f);
        this.m.addView(this.i, layoutParams);
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
        this.p.a(eVar.B);
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
        this.n = new com.opos.mobad.n.c.j(context, new j.a(i, i2, i3, i3 / this.d));
        this.l = new RelativeLayout(this.f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, -2);
        layoutParams.width = this.b;
        layoutParams.height = -2;
        this.l.setId(View.generateViewId());
        this.l.setLayoutParams(layoutParams);
        this.l.setVisibility(8);
        this.n.addView(this.l, layoutParams);
        this.n.setLayoutParams(layoutParams);
        a(aVar);
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.l.3
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (l.this.g != null) {
                    l.this.g.g(view, iArr);
                }
            }
        };
        this.l.setOnClickListener(gVar);
        this.l.setOnTouchListener(gVar);
    }

    private void b(com.opos.mobad.n.c.h hVar) {
        this.p = ah.a(this.f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f, 10.0f);
        hVar.addView(this.p, layoutParams);
    }

    private void f() {
        this.b = com.opos.cmn.an.h.f.a.a(this.f, 320.0f);
        this.f26866c = com.opos.cmn.an.h.f.a.a(this.f, 258.0f);
        this.e = com.opos.cmn.an.h.f.a.a(this.f, 180.0f);
        this.d = this.f26866c;
    }

    private void g() {
        TextView textView = new TextView(this.f);
        this.j = textView;
        textView.setId(View.generateViewId());
        this.j.setTextColor(this.f.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.j.setTextSize(1, 17.0f);
        this.j.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.j.setMaxLines(2);
        this.m.addView(this.j, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void h() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f);
        aVar.a(new a.InterfaceC0678a() { // from class: com.opos.mobad.n.g.l.5
            @Override // com.opos.mobad.c.d.a.InterfaceC0678a
            public void a(boolean z) {
                if (l.this.k == null) {
                    return;
                }
                if (z && !l.this.s) {
                    l.this.s = true;
                    l.this.i();
                    if (l.this.g != null) {
                        l.this.g.b();
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "BlockBigImageVideo10 onWindowVisibilityChanged：" + z);
                if (z) {
                    l.this.o.d();
                } else {
                    l.this.o.e();
                }
            }
        });
        this.l.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.m.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        if (!this.f26865a) {
            this.o.a();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "current state has stop mDestroy =" + this.f26865a);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.g = interfaceC0708a;
        this.o.a(interfaceC0708a);
        this.i.a(interfaceC0708a);
        this.p.a(interfaceC0708a);
        this.p.a(new ad.a() { // from class: com.opos.mobad.n.g.l.2
            @Override // com.opos.mobad.n.g.ad.a
            public void a(int i) {
                l.this.o.a(i);
            }
        });
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0708a interfaceC0708a;
        a.InterfaceC0708a interfaceC0708a2;
        if (hVar == null) {
            com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "data is null");
            interfaceC0708a2 = this.g;
        } else {
            com.opos.mobad.n.d.e b = hVar.b();
            if (b != null) {
                com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "render");
                if (!TextUtils.isEmpty(b.f26630a.f26633a) && this.k == null) {
                    this.o.a(b);
                }
                if (this.k == null && (interfaceC0708a = this.g) != null) {
                    interfaceC0708a.e();
                }
                this.k = b;
                com.opos.mobad.n.c.j jVar = this.n;
                if (jVar != null && jVar.getVisibility() != 0) {
                    this.n.setVisibility(0);
                }
                RelativeLayout relativeLayout = this.l;
                if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                    this.l.setVisibility(0);
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
        com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "start countdown...");
        if (!this.f26865a) {
            this.o.b();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "error state mDestroy " + this.f26865a);
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.n;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "destroy");
        this.f26865a = true;
        ag agVar = this.o;
        if (agVar != null) {
            agVar.c();
        }
        this.k = null;
        this.q.removeCallbacks(this.t);
        com.opos.mobad.n.c.j jVar = this.n;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.h;
    }
}
