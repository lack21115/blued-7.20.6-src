package com.opos.mobad.n.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.opos.mobad.c.d.a;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/e/a.class */
public class a extends com.opos.mobad.n.i.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f12948a;
    private d d;
    private com.opos.mobad.n.d.b e;
    private FrameLayout f;
    private RelativeLayout g;
    private RelativeLayout h;
    private com.opos.mobad.c.d.a i;
    private c j;

    public a(Context context, int i) {
        super(i);
        this.f12948a = context;
        this.j = new i();
        a(context);
    }

    private void a(Context context) {
        this.g = new RelativeLayout(context);
        this.f = new FrameLayout(this.f12948a);
        this.h = new RelativeLayout(context);
    }

    private void a(final com.opos.mobad.n.d.b bVar) {
        if (TextUtils.isEmpty(bVar.f12939a)) {
            return;
        }
        if (this.e != null && bVar.f12939a.equals(this.e.f12939a)) {
            b(bVar);
            return;
        }
        if (this.d != null) {
            this.f.removeAllViews();
            this.d.d();
            this.d = null;
        }
        if (com.opos.cmn.an.d.b.a.a(bVar.f12939a)) {
            com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.n.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    com.opos.mobad.n.d.b bVar2 = bVar;
                    aVar.a(bVar2, bVar2.f12939a);
                }
            });
        } else {
            a(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.n.d.b bVar, String str) {
        com.opos.cmn.an.f.a.b("DyTemplate", "show :" + str);
        long currentTimeMillis = System.currentTimeMillis();
        com.opos.cmn.an.f.a.b("DyTemplate", "adDynamicData.duration = " + bVar.w);
        c a2 = this.j.a(bVar.f).b(bVar.e).c(bVar.l).a(new b() { // from class: com.opos.mobad.n.e.a.4
            @Override // com.opos.mobad.n.e.b
            public void a(View view, int[] iArr) {
                a.this.a(view, iArr);
            }

            @Override // com.opos.mobad.n.e.b
            public void b(View view, int[] iArr) {
                a.this.b(view, iArr);
            }

            @Override // com.opos.mobad.n.e.b
            public void c(View view, int[] iArr) {
                a.this.c(view, iArr);
            }

            @Override // com.opos.mobad.n.e.b
            public void d(View view, int[] iArr) {
                a.this.g(view, iArr);
            }

            @Override // com.opos.mobad.n.e.b
            public void e(View view, int[] iArr) {
                a.this.d(view, iArr);
            }

            @Override // com.opos.mobad.n.e.b
            public void f(View view, int[] iArr) {
                a.this.e(view, iArr);
            }
        }).a(new f() { // from class: com.opos.mobad.n.e.a.3
            @Override // com.opos.mobad.n.e.f
            public void a() {
                com.opos.cmn.an.f.a.b("DyTemplate", "load success");
                a.this.a(new Callable<Boolean>() { // from class: com.opos.mobad.n.e.a.3.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        if (a.this.d != null && a.this.r()) {
                            a.this.d.a(false);
                        }
                        a.this.q();
                        a.this.i();
                        return true;
                    }
                });
            }

            @Override // com.opos.mobad.n.e.f
            public void a(String str2) {
                com.opos.cmn.an.f.a.b("DyTemplate", "load fail :" + str2);
                a.this.a(3);
            }
        }).a(new g() { // from class: com.opos.mobad.n.e.a.2
            @Override // com.opos.mobad.n.e.g
            public void a(int i) {
                com.opos.cmn.an.f.a.b("DyTemplate", "onVideoStart :" + i);
                a.this.q();
                a.this.c(0L, (long) i);
            }

            @Override // com.opos.mobad.n.e.g
            public void a(int i, int i2) {
                com.opos.cmn.an.f.a.b("DyTemplate", "onVideoProgress :" + i + "," + i2);
                a.this.c((long) i, (long) i2);
            }

            @Override // com.opos.mobad.n.e.g
            public void a(String str2) {
                com.opos.cmn.an.f.a.b("DyTemplate", "onVideoPlayError :" + str2);
                a.this.a(102, str2);
            }

            @Override // com.opos.mobad.n.e.g
            public void b(int i, int i2) {
                com.opos.cmn.an.f.a.b("DyTemplate", "onVideoPause :" + i + "," + i2);
            }

            @Override // com.opos.mobad.n.e.g
            public void c(int i, int i2) {
                com.opos.cmn.an.f.a.b("DyTemplate", "onVideoPlayEnd :" + i + "," + i2);
                long j = (long) i2;
                a.this.c(j, j);
            }
        });
        if (bVar.v != null) {
            a2.a(bVar.v.b, bVar.v.f12938a);
        }
        if (bVar.j != null && !TextUtils.isEmpty(bVar.j.f12945a)) {
            a2.d(bVar.j.f12945a);
        }
        if (bVar.b != null && !TextUtils.isEmpty(bVar.b.f12945a)) {
            a2.c((Object) bVar.b.f12945a);
        }
        if (bVar.m != null && !TextUtils.isEmpty(bVar.m.f12945a)) {
            a2.e(bVar.m.f12945a);
        }
        if (bVar.g != null && bVar.g.size() > 0) {
            com.opos.mobad.n.d.g gVar = bVar.g.get(0);
            if (gVar != null) {
                a2.a((Object) gVar.f12945a);
            }
            ArrayList arrayList = new ArrayList();
            for (com.opos.mobad.n.d.g gVar2 : bVar.g) {
                if (gVar != null) {
                    arrayList.add(gVar2.f12945a);
                }
            }
            a2.b(arrayList);
        }
        d a3 = a2.a(this.f12948a, str);
        this.d = a3;
        View a4 = a3.a();
        com.opos.cmn.an.f.a.b("DyTemplate", "show view :" + a4 + ", costTime = " + currentTimeMillis);
        this.f.removeAllViews();
        this.f.addView(a4, new ViewGroup.LayoutParams(-1, -2));
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        if (this.e != null) {
            return;
        }
        this.h.addView(this.f, new RelativeLayout.LayoutParams(-1, -2));
        this.g.addView(this.h, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void b(com.opos.mobad.n.d.b bVar) {
        d dVar = this.d;
        if (dVar == null) {
            return;
        }
        dVar.a(bVar.f);
        this.d.b(bVar.e);
        this.d.c(bVar.l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.i == null) {
            com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f12948a);
            this.i = aVar;
            aVar.a(new a.InterfaceC0508a() { // from class: com.opos.mobad.n.e.a.5
                @Override // com.opos.mobad.c.d.a.InterfaceC0508a
                public void a(boolean z) {
                    com.opos.cmn.an.f.a.b("DyTemplate", "visible change:" + z);
                    if (a.this.d == null) {
                        return;
                    }
                    if (!z) {
                        a.this.l();
                        return;
                    }
                    a.this.n();
                    a.this.k();
                }
            });
        }
        if (this.f.indexOfChild(this.i) < 0) {
            this.f.addView(this.i, new ViewGroup.LayoutParams(0, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.h.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        com.opos.mobad.n.d.b bVar = this.e;
        return (bVar == null || bVar.b == null) ? false : true;
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.mobad.n.d.b d = hVar.d();
        if (d == null) {
            com.opos.cmn.an.f.a.b("DyTemplate", "adShowData is null");
            a(1);
            return;
        }
        com.opos.cmn.an.f.a.b("DyTemplate", "render");
        a(d);
        a((com.opos.mobad.n.d.d) d);
        this.e = d;
    }

    public void a(boolean z) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(z);
        }
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.g;
    }

    @Override // com.opos.mobad.n.i.a
    public boolean f() {
        d dVar = this.d;
        if (dVar == null) {
            return false;
        }
        dVar.b();
        return true;
    }

    @Override // com.opos.mobad.n.i.a
    public boolean g() {
        d dVar = this.d;
        if (dVar == null) {
            return false;
        }
        dVar.c();
        return true;
    }

    @Override // com.opos.mobad.n.i.a
    public void h() {
        com.opos.cmn.an.f.a.b("DyTemplate", "destroy");
        this.g.removeAllViews();
        this.f.removeAllViews();
        d dVar = this.d;
        if (dVar != null) {
            dVar.d();
        }
    }
}
