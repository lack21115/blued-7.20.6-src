package com.opos.mobad.h.d;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.opos.cmn.j.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.j;
import com.opos.mobad.n.d.h;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/d/a.class */
public abstract class a extends com.opos.mobad.cmn.a.c implements com.opos.mobad.n.a {
    protected int h;
    protected int i;
    protected a.InterfaceC0538a j;
    protected float k;
    protected RelativeLayout l;
    protected RelativeLayout m;
    protected TextView n;
    protected com.opos.cmn.e.a.a.a o;
    protected RelativeLayout p;
    protected TextView q;
    protected com.opos.cmn.e.a.a.a r;
    protected com.opos.mobad.o.a.a s;
    private RelativeLayout t;
    private int u;
    private volatile int v;
    private com.opos.cmn.j.b w;
    private boolean x;
    private com.opos.mobad.n.d.d y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.h.d.a$4  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/d/a$4.class */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12514a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[com.opos.mobad.cmn.a.b.a.values().length];
            f12514a = iArr;
            try {
                iArr[com.opos.mobad.cmn.a.b.a.NonClickBt.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12514a[com.opos.mobad.cmn.a.b.a.ClickBt.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public a(Context context, a.InterfaceC0538a interfaceC0538a, float f) {
        super(context);
        this.h = 0;
        this.i = 0;
        this.k = 1.0f;
        this.v = 0;
        this.x = false;
        this.j = interfaceC0538a;
        b(f);
        g();
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, int[] iArr, com.opos.mobad.cmn.a.b.a aVar) {
        int i = AnonymousClass4.f12514a[aVar.ordinal()];
        if (i == 1) {
            this.j.g(view, iArr);
        } else if (i != 2) {
        } else {
            this.j.f(view, iArr);
        }
    }

    private boolean a(com.opos.mobad.n.d.d dVar, TextView textView) {
        if (dVar == null) {
            return false;
        }
        String charSequence = textView.getText() != null ? textView.getText().toString() : "";
        com.opos.cmn.an.f.a.b("BaseNativeTempletCreative", "notifyInstallCompletedEvent desc =" + charSequence + "," + dVar.l);
        return !charSequence.equals(dVar.l);
    }

    private void b(float f) {
        int b = com.opos.cmn.an.h.f.a.b(this.f12208a);
        j jVar = new j(this.f12208a, new j.a(b, (int) (b * 0.6f), f));
        this.t = jVar;
        jVar.setVisibility(4);
        RelativeLayout relativeLayout = new RelativeLayout(this.f12208a);
        this.l = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        this.l.setVisibility(4);
        this.t.addView(this.l, new ViewGroup.LayoutParams(-1, -1));
        o();
        p();
    }

    private void o() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f12208a);
        this.m = relativeLayout;
        relativeLayout.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n(), l());
        layoutParams.addRule(10);
        layoutParams.leftMargin = a(16.0f);
        layoutParams.rightMargin = a(16.0f);
        this.l.addView(this.m, layoutParams);
    }

    private void p() {
        this.p = new RelativeLayout(this.f12208a);
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.f12208a, 6.66f);
        cVar.setImageDrawable(new ColorDrawable(Color.parseColor("#f5f5f5")));
        this.p.addView(cVar, new RelativeLayout.LayoutParams(-1, -1));
        q();
        r();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n(), a(40.0f));
        layoutParams.addRule(3, 1);
        layoutParams.leftMargin = a(16.0f);
        layoutParams.rightMargin = a(16.0f);
        layoutParams.topMargin = a(10.0f);
        layoutParams.bottomMargin = a(20.0f);
        this.l.addView(this.p, layoutParams);
    }

    private void q() {
        TextView textView = new TextView(this.f12208a);
        this.q = textView;
        textView.setGravity(17);
        this.q.setTextColor(Color.parseColor("#999999"));
        this.q.setTextSize(1, m() * 14.0f);
        this.q.setMaxEms(9);
        this.q.setEllipsize(TextUtils.TruncateAt.END);
        this.q.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        layoutParams.leftMargin = a(16.0f);
        this.p.addView(this.q, layoutParams);
    }

    private void r() {
        com.opos.cmn.e.a.a.a aVar = new com.opos.cmn.e.a.a.a(this.f12208a, "opos_module_biz_ui_native_templet_click_bn_normal_bg_img.png", "opos_module_biz_ui_native_templet_click_bn_pressed_bg_img.png");
        this.r = aVar;
        aVar.setGravity(17);
        this.r.setTextColor(Color.parseColor("#0095ff"));
        this.r.setTextSize(1, m() * 12.0f);
        this.r.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a(79.0f), a(24.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.rightMargin = a(16.0f);
        this.p.addView(this.r, layoutParams);
    }

    private void s() {
        com.opos.cmn.j.b bVar = new com.opos.cmn.j.b(this.f12208a);
        this.w = bVar;
        bVar.a(new b.a() { // from class: com.opos.mobad.h.d.a.3
            @Override // com.opos.cmn.j.b.a
            public void a(boolean z) {
                if (a.this.v == 4) {
                    com.opos.cmn.an.f.a.b("BaseNativeTempletCreative", "has destroy");
                    return;
                }
                com.opos.cmn.an.f.a.b("BaseNativeTempletCreative", "is view visible =" + z);
                if (!z) {
                    a.this.v = 2;
                } else if (a.this.v == 0) {
                    a.this.v = 1;
                    if (a.this.x) {
                        a.this.t();
                    }
                }
            }
        });
        this.l.addView(this.w, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.v == 1) {
            this.v = 3;
            com.opos.cmn.an.f.a.b("BaseNativeTempletCreative", "NT onWindowVisibility");
            a.InterfaceC0538a interfaceC0538a = this.j;
            if (interfaceC0538a != null) {
                interfaceC0538a.b();
            }
            this.w.a((b.a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(float f) {
        return com.opos.cmn.an.h.f.a.a(this.f12208a, m() * f);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final View view, AdItemData adItemData, final com.opos.mobad.cmn.a.b.a aVar) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.d));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.h.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    a aVar2 = a.this;
                    aVar2.a(view, aVar2.d, aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, AdItemData adItemData, boolean z) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.d));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.h.d.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    com.opos.cmn.an.f.a.b("BaseNativeTempletCreative", "close click origin");
                    a.this.j.d(view2, a.this.d);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(RelativeLayout.LayoutParams layoutParams) {
        if (this.b.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        this.m.addView(this.b, layoutParams);
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
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.j = interfaceC0538a;
    }

    @Override // com.opos.mobad.n.a
    public void a(h hVar) {
        com.opos.mobad.n.d.d a2 = hVar.a();
        if (a2 == null) {
            this.j.b(1);
            return;
        }
        if (this.y == null) {
            this.j.e();
        }
        this.y = a2;
        if (a(a2, this.r)) {
            this.r.setText(this.y.l);
        }
        if (this.x) {
            return;
        }
        this.x = true;
        this.t.setVisibility(0);
        this.l.setVisibility(0);
        t();
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(RelativeLayout.LayoutParams layoutParams) {
        com.opos.cmn.e.a.a.a aVar = new com.opos.cmn.e.a.a.a(this.f12208a, "opos_module_biz_ui_cmn_close_bn_bg_img.png", "opos_module_biz_ui_cmn_close_bn_bg_img.png");
        this.o = aVar;
        aVar.setGravity(17);
        this.o.setTextColor(-1);
        this.o.setSingleLine();
        this.m.addView(this.o, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(AdItemData adItemData) {
        this.r.setText(c(adItemData));
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.u;
    }

    @Override // com.opos.mobad.cmn.a.c
    public void j() {
        RelativeLayout relativeLayout = this.t;
        if (relativeLayout != null && relativeLayout.getChildCount() > 0) {
            this.t.removeAllViews();
            this.t.setVisibility(8);
        }
        com.opos.mobad.o.a.a aVar = this.s;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.opos.mobad.n.a
    /* renamed from: k */
    public RelativeLayout c() {
        return this.t;
    }

    protected abstract int l();

    /* JADX INFO: Access modifiers changed from: protected */
    public float m() {
        return this.k;
    }

    protected int n() {
        return (int) (com.opos.cmn.an.h.f.a.b(this.f12208a) * m());
    }
}
