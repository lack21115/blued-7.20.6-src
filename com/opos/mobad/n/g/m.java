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

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/m.class */
public class m implements com.opos.mobad.n.a {
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f13185c;
    private int d;
    private Context f;
    private a.InterfaceC0538a g;
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
    private volatile boolean f13184a = false;
    private int e = 0;
    private boolean s = false;
    private Runnable t = new Runnable() { // from class: com.opos.mobad.n.g.m.1
        @Override // java.lang.Runnable
        public void run() {
            if (m.this.f13184a) {
                return;
            }
            int g = m.this.o.g();
            int h = m.this.o.h();
            if (m.this.g != null) {
                m.this.g.d(g, h);
            }
            m.this.o.f();
            m.this.q.postDelayed(this, 500L);
        }
    };
    private Handler q = new Handler(Looper.getMainLooper());

    private m(Context context, aj ajVar, int i, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        this.f = context;
        this.h = i;
        this.r = aVar2;
        f();
        a(ajVar, aVar);
        h();
    }

    public static m a(Context context, aj ajVar, int i, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new m(context, ajVar, i, aVar, aVar2);
    }

    private void a(com.opos.mobad.c.c.a aVar) {
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f);
        this.m = hVar;
        hVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f13185c);
        this.m.setVisibility(4);
        this.l.addView(this.m, layoutParams);
        g();
        com.opos.mobad.n.c.h hVar2 = new com.opos.mobad.n.c.h(this.f);
        hVar2.a(com.opos.cmn.an.h.f.a.a(this.f, 6.0f));
        hVar2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.b, this.e);
        layoutParams2.addRule(3, this.i.getId());
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 6.0f);
        this.m.addView(hVar2, layoutParams2);
        a(aVar, hVar2);
        b(hVar2);
        a(hVar2);
    }

    private void a(com.opos.mobad.c.c.a aVar, com.opos.mobad.n.c.h hVar) {
        this.o = ag.a(this.f, this.b, this.e, aVar);
        hVar.addView(this.o, new RelativeLayout.LayoutParams(this.b, this.e));
        this.o.a(new ag.a() { // from class: com.opos.mobad.n.g.m.4
            @Override // com.opos.mobad.n.g.ag.a
            public void a() {
                m.this.q.removeCallbacks(m.this.t);
                m.this.q.postDelayed(m.this.t, 500L);
            }

            @Override // com.opos.mobad.n.g.ag.a
            public void b() {
                m.this.q.removeCallbacks(m.this.t);
            }
        });
    }

    private void a(com.opos.mobad.n.c.h hVar) {
        TextView textView = new TextView(this.f);
        this.j = textView;
        textView.setTextColor(this.f.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.j.setTextSize(1, 17.0f);
        this.j.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.j.setMaxLines(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, hVar.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 8.0f);
        this.m.addView(this.j, layoutParams);
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
        int i = ajVar2.f13109a;
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
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.m.3
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (m.this.g != null) {
                    m.this.g.g(view, iArr);
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
        this.f13185c = com.opos.cmn.an.h.f.a.a(this.f, 258.0f);
        this.e = com.opos.cmn.an.h.f.a.a(this.f, 180.0f);
        this.d = this.f13185c;
    }

    private void g() {
        ad a2 = ad.a(this.f);
        this.i = a2;
        a2.setId(View.generateViewId());
        this.m.addView(this.i, new RelativeLayout.LayoutParams(this.b, -2));
    }

    private void h() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f);
        aVar.a(new a.InterfaceC0508a() { // from class: com.opos.mobad.n.g.m.5
            @Override // com.opos.mobad.c.d.a.InterfaceC0508a
            public void a(boolean z) {
                if (m.this.k == null) {
                    return;
                }
                if (z && !m.this.s) {
                    m.this.s = true;
                    m.this.i();
                    if (m.this.g != null) {
                        m.this.g.b();
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo11", "BlockBigImageVideo11 onWindowVisibilityChanged：" + z);
                if (z) {
                    m.this.o.d();
                } else {
                    m.this.o.e();
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
        if (!this.f13184a) {
            this.o.a();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo11", "current state has stop mDestroy =" + this.f13184a);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.g = interfaceC0538a;
        this.o.a(interfaceC0538a);
        this.i.a(interfaceC0538a);
        this.p.a(interfaceC0538a);
        this.p.a(new ad.a() { // from class: com.opos.mobad.n.g.m.2
            @Override // com.opos.mobad.n.g.ad.a
            public void a(int i) {
                m.this.o.a(i);
            }
        });
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0538a interfaceC0538a;
        a.InterfaceC0538a interfaceC0538a2;
        if (hVar == null) {
            com.opos.cmn.an.f.a.b("BlockBigImageVideo11", "data is null");
            interfaceC0538a2 = this.g;
        } else {
            com.opos.mobad.n.d.e b = hVar.b();
            if (b != null) {
                com.opos.cmn.an.f.a.b("BlockBigImageVideo11", "render");
                if (!TextUtils.isEmpty(b.f12942a.f12945a) && this.k == null) {
                    this.o.a(b);
                }
                if (this.k == null && (interfaceC0538a = this.g) != null) {
                    interfaceC0538a.e();
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
            interfaceC0538a2 = this.g;
            if (interfaceC0538a2 == null) {
                return;
            }
        }
        interfaceC0538a2.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo11", "start countdown...");
        if (!this.f13184a) {
            this.o.b();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo11", "error state mDestroy " + this.f13184a);
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.n;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo11", "destroy");
        this.f13184a = true;
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
