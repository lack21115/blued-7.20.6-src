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
import com.opos.mobad.n.g.af;
import com.opos.mobad.n.g.ag;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/s.class */
public class s implements com.opos.mobad.n.a {
    private int d;
    private int e;
    private Context f;
    private a.InterfaceC0708a g;
    private int h;
    private af i;
    private com.opos.mobad.n.c.h j;
    private RelativeLayout k;
    private RelativeLayout l;
    private ag m;
    private TextView n;
    private com.opos.mobad.n.c.j o;
    private com.opos.mobad.c.a p;
    private com.opos.mobad.n.d.e r;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f26916a = false;
    private int b = 256;

    /* renamed from: c  reason: collision with root package name */
    private int f26917c = 144;
    private boolean s = false;
    private Runnable t = new Runnable() { // from class: com.opos.mobad.n.g.s.1
        @Override // java.lang.Runnable
        public void run() {
            if (s.this.f26916a) {
                return;
            }
            int g = s.this.m.g();
            int h = s.this.m.h();
            if (s.this.g != null) {
                s.this.g.d(g, h);
            }
            s.this.m.f();
            s.this.q.postDelayed(this, 500L);
        }
    };
    private Handler q = new Handler(Looper.getMainLooper());

    private s(Context context, aj ajVar, int i, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        this.f = context;
        this.h = i;
        this.p = aVar2;
        f();
        a(ajVar, aVar);
        i();
    }

    public static s a(Context context, aj ajVar, int i, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new s(context, ajVar, i, aVar, aVar2);
    }

    private void a(com.opos.mobad.c.c.a aVar) {
        RelativeLayout relativeLayout = new RelativeLayout(this.f);
        this.k = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f26917c);
        this.k.setVisibility(4);
        this.j.addView(this.k, layoutParams);
        b(aVar);
        g();
    }

    private void a(com.opos.mobad.n.d.e eVar) {
        b(eVar);
        c(eVar);
        d(eVar);
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
        this.o = new com.opos.mobad.n.c.j(context, new j.a(i, i2, i3, i3 / this.d));
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f);
        this.j = hVar;
        hVar.a(com.opos.cmn.an.h.f.a.a(this.f, 14.0f));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, this.d);
        layoutParams.width = this.b;
        layoutParams.height = this.d;
        this.j.setId(View.generateViewId());
        this.j.setBackgroundColor(this.f.getResources().getColor(R.color.opos_mobad_root_bg_color));
        this.j.setLayoutParams(layoutParams);
        this.j.setVisibility(8);
        this.o.addView(this.j, layoutParams);
        this.o.setLayoutParams(layoutParams);
        a(aVar);
        h();
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.s.3
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (s.this.g != null) {
                    s.this.g.g(view, iArr);
                }
            }
        };
        this.j.setOnClickListener(gVar);
        this.j.setOnTouchListener(gVar);
    }

    private void b(com.opos.mobad.c.c.a aVar) {
        this.m = ag.a(this.f, this.b, this.f26917c, aVar);
        this.k.addView(this.m, new RelativeLayout.LayoutParams(this.b, this.f26917c));
        this.m.a(new ag.a() { // from class: com.opos.mobad.n.g.s.4
            @Override // com.opos.mobad.n.g.ag.a
            public void a() {
                s.this.q.removeCallbacks(s.this.t);
                s.this.q.postDelayed(s.this.t, 500L);
            }

            @Override // com.opos.mobad.n.g.ag.a
            public void b() {
                s.this.q.removeCallbacks(s.this.t);
            }
        });
    }

    private void b(com.opos.mobad.n.d.e eVar) {
        String str = eVar.f;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.n.setText(str);
    }

    private void c(com.opos.mobad.n.d.e eVar) {
        this.i.a(eVar.r, eVar.s, eVar.i, eVar.j, eVar.k, eVar.B);
    }

    private void d(com.opos.mobad.n.d.e eVar) {
        com.opos.mobad.n.d.a aVar = eVar.v;
        if (aVar == null || TextUtils.isEmpty(aVar.f26626a)) {
            return;
        }
        TextUtils.isEmpty(aVar.b);
    }

    private void f() {
        this.b = com.opos.cmn.an.h.f.a.a(this.f, 256.0f);
        this.f26917c = com.opos.cmn.an.h.f.a.a(this.f, 144.0f);
        this.d = com.opos.cmn.an.h.f.a.a(this.f, 188.0f);
        this.e = this.b;
    }

    private void g() {
        this.i = af.a(this.f, true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        this.i.setVisibility(4);
        this.k.addView(this.i, layoutParams);
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f);
        this.l = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, com.opos.cmn.an.h.f.a.a(this.f, 44.0f));
        this.l.setVisibility(4);
        RelativeLayout relativeLayout2 = this.k;
        if (relativeLayout2 != null) {
            layoutParams.addRule(3, relativeLayout2.getId());
        }
        TextView textView = new TextView(this.f);
        this.n = textView;
        textView.setTextColor(this.f.getResources().getColor(R.color.opos_mobad_title_color));
        this.n.setTextSize(1, 12.0f);
        this.n.setGravity(17);
        this.n.setMaxLines(1);
        this.n.setEllipsize(TextUtils.TruncateAt.END);
        this.n.setSingleLine();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        layoutParams2.leftMargin = a2;
        layoutParams2.rightMargin = a2;
        this.l.addView(this.n, layoutParams2);
        this.j.addView(this.l, layoutParams);
    }

    private void i() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f);
        aVar.a(new a.InterfaceC0678a() { // from class: com.opos.mobad.n.g.s.5
            @Override // com.opos.mobad.c.d.a.InterfaceC0678a
            public void a(boolean z) {
                if (s.this.r == null) {
                    return;
                }
                if (z && !s.this.s) {
                    s.this.s = true;
                    s.this.j();
                    if (s.this.g != null) {
                        s.this.g.b();
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo6", "BlockBigImageVideo6 onWindowVisibilityChanged：" + z);
                if (z) {
                    s.this.m.d();
                } else {
                    s.this.m.e();
                }
            }
        });
        this.j.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.i.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        if (!this.f26916a) {
            this.m.a();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo6", "current state has stop mDestroy =" + this.f26916a);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.g = interfaceC0708a;
        this.i.a(interfaceC0708a);
        this.m.a(interfaceC0708a);
        this.i.a(new af.a() { // from class: com.opos.mobad.n.g.s.2
            @Override // com.opos.mobad.n.g.af.a
            public void a(int i) {
                s.this.m.a(i);
            }
        });
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0708a interfaceC0708a;
        com.opos.mobad.n.d.e b = hVar.b();
        if (b == null) {
            com.opos.cmn.an.f.a.d("", "render with data null");
            a.InterfaceC0708a interfaceC0708a2 = this.g;
            if (interfaceC0708a2 != null) {
                interfaceC0708a2.b(1);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(b.f26630a.f26633a) && this.r == null) {
            this.m.a(b);
        }
        if (this.r == null && (interfaceC0708a = this.g) != null) {
            interfaceC0708a.e();
        }
        this.r = b;
        com.opos.mobad.n.c.j jVar = this.o;
        if (jVar != null && jVar.getVisibility() != 0) {
            this.o.setVisibility(0);
        }
        com.opos.mobad.n.c.h hVar2 = this.j;
        if (hVar2 != null && hVar2.getVisibility() != 0) {
            this.j.setVisibility(0);
        }
        a(b);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo6", "start countdown...");
        if (!this.f26916a) {
            this.m.b();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo6", "error state mDestroy " + this.f26916a);
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.o;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo6", "destroy");
        this.f26916a = true;
        this.m.c();
        this.r = null;
        this.q.removeCallbacks(this.t);
        com.opos.mobad.n.c.j jVar = this.o;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.h;
    }
}
