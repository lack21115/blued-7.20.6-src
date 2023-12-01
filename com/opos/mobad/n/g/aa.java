package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.opos.mobad.c.a;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.j;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/aa.class */
public class aa implements com.opos.mobad.n.a {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f13067a = false;
    private int b = 320;

    /* renamed from: c  reason: collision with root package name */
    private int f13068c = 84;
    private int d = 0;
    private int e;
    private Context f;
    private a.InterfaceC0538a g;
    private int h;
    private int i;
    private com.opos.mobad.n.d.d j;
    private com.opos.mobad.n.c.f k;
    private ac l;
    private RelativeLayout m;
    private com.opos.mobad.n.c.h n;
    private com.opos.mobad.n.c.j o;
    private com.opos.mobad.c.a p;

    private aa(Context context, aj ajVar, int i, int i2, com.opos.mobad.c.a aVar) {
        this.f = context;
        this.i = i2;
        this.h = i;
        this.p = aVar;
        f();
        a(ajVar);
        i();
    }

    public static aa a(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new aa(context, ajVar, i, 1, aVar);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        b(dVar);
        this.l.a(dVar);
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
        this.o = new com.opos.mobad.n.c.j(context, new j.a(i, i2, i3, i3 / this.e));
        this.m = new RelativeLayout(this.f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, -2);
        layoutParams.width = this.b;
        layoutParams.height = -2;
        this.m.setId(View.generateViewId());
        this.m.setLayoutParams(layoutParams);
        this.m.setVisibility(8);
        this.o.addView(this.m, layoutParams);
        this.o.setLayoutParams(layoutParams);
        g();
        com.opos.mobad.n.c.g gVar = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.aa.1
            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (aa.this.g != null) {
                    aa.this.g.g(view, iArr);
                }
            }
        };
        this.m.setOnClickListener(gVar);
        this.m.setOnTouchListener(gVar);
    }

    public static aa b(Context context, aj ajVar, int i, com.opos.mobad.c.a aVar) {
        return new aa(context, ajVar, i, 2, aVar);
    }

    private void b(final com.opos.mobad.n.d.d dVar) {
        com.opos.mobad.n.c.f fVar;
        if (dVar.g == null || dVar.g.size() == 0 || (fVar = this.k) == null) {
            return;
        }
        fVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.p.a(dVar.g.get(0).f12945a, dVar.g.get(0).b, this.b, this.f13068c, new a.InterfaceC0506a() { // from class: com.opos.mobad.n.g.aa.3
            @Override // com.opos.mobad.c.a.InterfaceC0506a
            public void a(int i, final Bitmap bitmap) {
                if (aa.this.f13067a) {
                    return;
                }
                if (dVar.g.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BlockSmallImage7", "null imgList");
                } else if (i != 0 && i != 1) {
                    if (aa.this.g != null) {
                        aa.this.g.c(i);
                    }
                } else {
                    if (i == 1 && aa.this.g != null) {
                        aa.this.g.c(i);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.aa.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (aa.this.f13067a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            aa.this.k.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void f() {
        this.d = com.opos.cmn.an.h.f.a.a(this.f, 128.0f);
        int i = this.i;
        if (i == 1 || i == 2) {
            this.b = com.opos.cmn.an.h.f.a.a(this.f, 320.0f);
            this.f13068c = com.opos.cmn.an.h.f.a.a(this.f, 84.0f);
        }
        this.e = this.f13068c;
    }

    private void g() {
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f);
        this.n = hVar;
        hVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.f13068c);
        this.n.setVisibility(4);
        this.m.addView(this.n, layoutParams);
        h();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h() {
        /*
            Method dump skipped, instructions count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.n.g.aa.h():void");
    }

    private void i() {
        final com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f);
        aVar.a(new a.InterfaceC0508a() { // from class: com.opos.mobad.n.g.aa.2
            @Override // com.opos.mobad.c.d.a.InterfaceC0508a
            public void a(boolean z) {
                if (aa.this.j == null) {
                    return;
                }
                if (z) {
                    aa.this.j();
                    if (aa.this.g != null) {
                        aa.this.g.b();
                    }
                    aVar.a((a.InterfaceC0508a) null);
                }
                com.opos.cmn.an.f.a.b("BlockSmallImage7", "BlockSmallImage7 onWindowVisibilityChanged：" + z);
            }
        });
        this.m.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.n.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.g = interfaceC0538a;
        this.l.a(interfaceC0538a);
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
                com.opos.cmn.an.f.a.b("BlockSmallImage7", "render");
                if (this.j == null && (interfaceC0538a = this.g) != null) {
                    interfaceC0538a.e();
                }
                this.j = a2;
                com.opos.mobad.n.c.j jVar = this.o;
                if (jVar != null && jVar.getVisibility() != 0) {
                    this.o.setVisibility(0);
                }
                RelativeLayout relativeLayout = this.m;
                if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                    this.m.setVisibility(0);
                }
                a(a2);
                return;
            } else {
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BlockSmallImage7", str);
        this.g.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.o;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockSmallImage7", "destroy");
        this.j = null;
        this.f13067a = true;
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
