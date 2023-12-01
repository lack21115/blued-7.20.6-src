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

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/h.class */
public class h implements com.opos.mobad.n.a {
    private int d;
    private int e;
    private Context f;
    private a.InterfaceC0538a g;
    private int h;
    private int i;
    private com.opos.mobad.n.d.d j;
    private ImageView k;
    private af l;
    private com.opos.mobad.n.c.h m;
    private RelativeLayout n;
    private RelativeLayout o;
    private y p;
    private TextView q;
    private com.opos.mobad.n.c.j s;
    private com.opos.mobad.c.a t;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f13151a = false;
    private int b = 256;

    /* renamed from: c  reason: collision with root package name */
    private int f13152c = 144;
    private boolean r = false;

    private h(Context context, aj ajVar, int i, int i2, com.opos.mobad.c.a aVar) {
        this.f = context;
        this.i = i2;
        this.h = i;
        this.t = aVar;
        f();
        a(ajVar);
        l();
    }

    public static h a(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new h(context, ajVar, i, 0, aVar);
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
        this.s = new com.opos.mobad.n.c.j(context, new j.a(i, i2, i3, i3 / this.d));
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f);
        this.m = hVar;
        hVar.a(com.opos.cmn.an.h.f.a.a(this.f, 14.0f));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, this.d);
        layoutParams.width = this.b;
        layoutParams.height = this.d;
        this.m.setId(View.generateViewId());
        this.m.setBackgroundColor(this.f.getResources().getColor(R.color.opos_mobad_root_bg_color));
        this.m.setLayoutParams(layoutParams);
        this.m.setVisibility(8);
        this.s.addView(this.m, layoutParams);
        this.s.setLayoutParams(layoutParams);
        k();
        g();
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.h.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (h.this.g != null) {
                    h.this.g.g(view, iArr);
                }
            }
        };
        this.m.setOnClickListener(gVar);
        this.m.setOnTouchListener(gVar);
    }

    public static h b(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new h(context, ajVar, i, 1, aVar);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        y yVar;
        if (dVar.g == null || dVar.g.size() == 0 || (yVar = this.p) == null) {
            return;
        }
        yVar.a(dVar, this.t, this.f13151a, dVar.z);
    }

    public static h c(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new h(context, ajVar, i, 2, aVar);
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        String str = dVar.f;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.q.setText(str);
    }

    private void d(final com.opos.mobad.n.d.d dVar) {
        ImageView imageView;
        if (dVar.g == null || dVar.g.size() == 0 || (imageView = this.k) == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.t.a(dVar.g.get(0).f12945a, dVar.g.get(0).b, this.b, this.f13152c, new a.InterfaceC0506a() { // from class: com.opos.mobad.n.g.h.3
            @Override // com.opos.mobad.c.a.InterfaceC0506a
            public void a(int i, final Bitmap bitmap) {
                if (h.this.f13151a) {
                    return;
                }
                if (dVar.g.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage5", "null imgList");
                } else if (i != 0 && i != 1) {
                    if (h.this.g != null) {
                        h.this.g.c(i);
                    }
                } else {
                    if (i == 1 && h.this.g != null) {
                        h.this.g.c(i);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (h.this.f13151a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            h.this.k.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void e(com.opos.mobad.n.d.d dVar) {
        this.l.a(dVar.r, dVar.s, dVar.i, dVar.j, dVar.k, dVar.B);
    }

    private void f() {
        int a2;
        int i = this.i;
        if (i == 0) {
            this.b = com.opos.cmn.an.h.f.a.a(this.f, 256.0f);
            this.f13152c = com.opos.cmn.an.h.f.a.a(this.f, 144.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f, 188.0f);
        } else if (i != 1) {
            if (i != 2) {
                return;
            }
            this.b = com.opos.cmn.an.h.f.a.a(this.f, 256.0f);
            this.f13152c = com.opos.cmn.an.h.f.a.a(this.f, 168.0f);
            this.d = com.opos.cmn.an.h.f.a.a(this.f, 212.0f);
            this.e = this.b;
            this.r = true;
            return;
        } else {
            this.b = com.opos.cmn.an.h.f.a.a(this.f, 256.0f);
            this.f13152c = com.opos.cmn.an.h.f.a.a(this.f, 168.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f, 212.0f);
        }
        this.d = a2;
        this.e = this.b;
    }

    private void g() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f);
        this.n = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f13152c);
        RelativeLayout relativeLayout2 = this.o;
        if (relativeLayout2 != null) {
            layoutParams.addRule(3, relativeLayout2.getId());
        }
        this.n.setVisibility(4);
        this.m.addView(this.n, layoutParams);
        if (this.r) {
            h();
        } else {
            i();
        }
        j();
    }

    private void h() {
        this.p = y.a(this.f, this.b, this.f13152c, true);
        this.n.addView(this.p, new RelativeLayout.LayoutParams(this.b, this.f13152c));
    }

    private void i() {
        this.k = new ImageView(this.f);
        this.n.addView(this.k, new RelativeLayout.LayoutParams(this.b, this.f13152c));
    }

    private void j() {
        this.l = af.a(this.f, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, -2);
        this.l.setVisibility(4);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        this.n.addView(this.l, layoutParams);
    }

    private void k() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f);
        this.o = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, com.opos.cmn.an.h.f.a.a(this.f, 44.0f));
        this.o.setVisibility(4);
        TextView textView = new TextView(this.f);
        this.q = textView;
        textView.setTextColor(this.f.getResources().getColor(R.color.opos_mobad_title_color));
        this.q.setTextSize(1, 12.0f);
        this.q.setGravity(17);
        this.q.setMaxLines(1);
        this.q.setEllipsize(TextUtils.TruncateAt.END);
        this.q.setSingleLine();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f, 16.0f);
        layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f, 12.0f);
        layoutParams2.leftMargin = a2;
        layoutParams2.rightMargin = a2;
        this.o.addView(this.q, layoutParams2);
        this.m.addView(this.o, layoutParams);
    }

    private void l() {
        final com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f);
        aVar.a(new a.InterfaceC0508a() { // from class: com.opos.mobad.n.g.h.2
            @Override // com.opos.mobad.c.d.a.InterfaceC0508a
            public void a(boolean z) {
                if (h.this.j == null) {
                    return;
                }
                if (z) {
                    h.this.m();
                    if (h.this.g != null) {
                        h.this.g.b();
                    }
                    aVar.a((a.InterfaceC0508a) null);
                }
                com.opos.cmn.an.f.a.b("BlockBigImage5", "blockBigImage5 onWindowVisibilityChanged：" + z);
            }
        });
        this.m.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        this.l.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.g = interfaceC0538a;
        this.l.a(interfaceC0538a);
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
                com.opos.cmn.an.f.a.b("BlockBigImage5", "render");
                if (this.j == null && (interfaceC0538a = this.g) != null) {
                    interfaceC0538a.e();
                }
                this.j = a2;
                com.opos.mobad.n.c.j jVar = this.s;
                if (jVar != null && jVar.getVisibility() != 0) {
                    this.s.setVisibility(0);
                }
                com.opos.mobad.n.c.h hVar2 = this.m;
                if (hVar2 != null && hVar2.getVisibility() != 0) {
                    this.m.setVisibility(0);
                }
                a(a2);
                return;
            } else {
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BlockBigImage5", str);
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
        com.opos.cmn.an.f.a.b("BlockBigImage5", "destroy");
        this.j = null;
        this.f13151a = true;
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
