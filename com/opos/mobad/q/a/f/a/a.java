package com.opos.mobad.q.a.f.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.n.a;
import com.opos.mobad.q.a.f.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/f/a/a.class */
public abstract class a implements com.opos.mobad.n.a {

    /* renamed from: a  reason: collision with root package name */
    protected Context f27178a;

    /* renamed from: c  reason: collision with root package name */
    protected TextView f27179c;
    protected TextView d;
    protected com.opos.cmn.e.a.a.c e;
    protected TextView f;
    protected TextView g;
    protected RelativeLayout h;
    protected RelativeLayout i;
    protected Bitmap j;
    protected a.InterfaceC0708a k;
    protected com.opos.mobad.q.a.f.a l;
    protected f m;
    protected int n;
    protected int o;
    protected int p;
    protected int q;
    protected com.opos.mobad.n.d.f r;
    private int t;
    protected int[] b = new int[4];
    protected a.InterfaceC0726a s = new a.InterfaceC0726a() { // from class: com.opos.mobad.q.a.f.a.a.3
        @Override // com.opos.mobad.q.a.f.a.InterfaceC0726a
        public void a() {
            com.opos.cmn.an.f.a.b("BaseFloatLayerView", "end to scale");
            if (a.this.m != null) {
                a.this.m.b();
            }
            if (a.this.l != null) {
                a.this.l.a();
            }
        }

        @Override // com.opos.mobad.q.a.f.a.InterfaceC0726a
        public void a(boolean z) {
        }

        @Override // com.opos.mobad.q.a.f.a.InterfaceC0726a
        public void b() {
            com.opos.cmn.an.f.a.b("BaseFloatLayerView", "start to scale");
            if (a.this.m != null) {
                a.this.m.a();
            }
        }
    };

    public a(Context context, int i, a.InterfaceC0708a interfaceC0708a) {
        this.f27178a = context.getApplicationContext();
        this.k = interfaceC0708a;
        this.t = i;
        f();
        g();
        k();
    }

    private void k() {
        com.opos.mobad.q.a.f.a aVar = new com.opos.mobad.q.a.f.a(this.f27178a);
        this.l = aVar;
        aVar.a(this.s);
        this.i.addView(this.l);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        if (view != null) {
            try {
                view.setOnTouchListener(null);
                view.setOnClickListener(null);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("BaseFloatLayerView", "", (Throwable) e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, final com.opos.mobad.cmn.a.b.a aVar) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.b));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.q.a.f.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (a.this.k != null) {
                        if (aVar == com.opos.mobad.cmn.a.b.a.FloatLayerClickBt) {
                            a.this.k.k(view2, a.this.b);
                        } else {
                            a.this.k.j(view2, a.this.b);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, String str) {
        if (textView != null) {
            String str2 = str;
            if (com.opos.cmn.an.c.a.a(str)) {
                str2 = "";
            }
            textView.setText(str2);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.k = interfaceC0708a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        a(this.f27179c, str);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.t;
    }

    protected void f() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f27178a);
        this.i = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor("#c0000000"));
        this.i.setClickable(true);
        this.i.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.h = new RelativeLayout(this.f27178a);
        this.n = g.a();
        this.o = g.a();
        this.p = g.a();
        this.q = g.a();
    }

    public abstract void g();

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        if (this.r != null) {
            return;
        }
        TextView textView = new TextView(this.f27178a);
        this.d = textView;
        textView.setGravity(17);
        g.a(this.d, com.opos.cmn.an.d.a.a.c(this.f27178a, "opos_module_biz_ui_reward_video_float_layer_close_bn.png"));
        this.i.addView(this.d, i());
    }

    public abstract RelativeLayout.LayoutParams i();

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        this.d.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.b));
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.q.a.f.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (a.this.k != null) {
                    a.this.k.d(view, a.this.b);
                }
            }
        });
    }
}
