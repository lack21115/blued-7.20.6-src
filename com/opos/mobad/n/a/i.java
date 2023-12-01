package com.opos.mobad.n.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.b;
import java.io.File;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/i.class */
public class i implements com.opos.mobad.n.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f26516a;
    private RelativeLayout b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.mobad.e.a.g f26517c;
    private int d;
    private a.InterfaceC0708a e;
    private s f;
    private FrameLayout g;
    private com.opos.mobad.c.b.c h;
    private com.opos.mobad.c.b.c i;
    private long k;
    private com.opos.mobad.n.d.c l;
    private com.opos.mobad.n.b m;
    private String n;
    private long j = 0;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;

    public i(Context context, int i, com.opos.mobad.n.b bVar) {
        this.f26516a = context;
        this.d = i;
        this.m = bVar;
        i();
        Handler handler = new Handler(Looper.getMainLooper());
        this.h = new com.opos.mobad.c.b.c(handler, new Runnable() { // from class: com.opos.mobad.n.a.i.1
            @Override // java.lang.Runnable
            public void run() {
                long h = i.this.h();
                long j = h;
                if (i.this.l.w > 0) {
                    j = Math.min(h, i.this.l.w);
                }
                i iVar = i.this;
                iVar.a(iVar.l, j);
                if (i.this.e != null) {
                    i.this.e.d(j, -1L);
                }
                com.opos.cmn.an.f.a.b("InteractiveTemplate", "process:" + j + ",duration:" + i.this.l.w);
                if (i.this.l.w <= 0 || j < i.this.l.w) {
                    com.opos.cmn.an.f.a.b("InteractiveTemplate", "process start next");
                    i.this.h.a(1000L);
                    return;
                }
                com.opos.cmn.an.f.a.b("InteractiveTemplate", "process complete");
                i.this.o = true;
                i.this.f();
                if (i.this.e != null) {
                    i.this.e.a(j, j);
                }
            }
        });
        this.i = new com.opos.mobad.c.b.c(handler, new Runnable() { // from class: com.opos.mobad.n.a.i.2
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("InteractiveTemplate", "render timeout");
                i.this.g.removeAllViews();
                i.this.h.a();
                if (i.this.f26517c != null) {
                    i.this.f26517c.d();
                }
                if (i.this.e != null) {
                    i.this.e.b(2);
                }
            }
        });
    }

    private void a(final com.opos.mobad.n.d.c cVar) {
        if (TextUtils.isEmpty(cVar.f26628a)) {
            return;
        }
        if (this.l != null && cVar.f26628a.equals(this.l.f26628a)) {
            b(cVar);
            return;
        }
        if (this.f26517c != null) {
            this.g.removeAllViews();
            this.f26517c.d();
            this.f26517c = null;
        }
        if (a(cVar.f26628a)) {
            this.m.a(cVar.f26628a, new b.a() { // from class: com.opos.mobad.n.a.i.5
                @Override // com.opos.mobad.n.b.a
                public void a(boolean z, final String str) {
                    if (z) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.opos.mobad.n.a.i.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.a(cVar, str);
                            }
                        });
                    } else if (i.this.e != null) {
                        i.this.e.b(4);
                    }
                }
            });
            return;
        }
        a.InterfaceC0708a interfaceC0708a = this.e;
        if (interfaceC0708a != null) {
            interfaceC0708a.b(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.n.d.c cVar, long j) {
        if (cVar.d <= 0 || j >= cVar.d) {
            this.f.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.n.d.c cVar, String str) {
        com.opos.mobad.n.d.g gVar;
        com.opos.cmn.an.f.a.b("InteractiveTemplate", "show :" + str);
        String str2 = (cVar.g == null || cVar.g.size() <= 0 || cVar.g.get(0) == null || (gVar = cVar.g.get(0)) == null) ? "" : gVar.f26633a;
        this.i.a(com.anythink.expressad.video.module.a.a.m.ag);
        com.opos.mobad.e.a.g a2 = com.opos.mobad.e.a.n.a().a(true).a(cVar.f).b(cVar.e).c(cVar.l).b((Object) cVar.j.f26633a).a((Object) str2).a(new com.opos.mobad.e.a.a() { // from class: com.opos.mobad.n.a.i.7
            @Override // com.opos.mobad.e.a.a
            public void a(Map map, String str3, com.opos.mobad.e.a.l lVar, int i, String str4, int i2) {
                com.opos.cmn.an.f.a.b("InteractiveTemplate", "cl:" + str3 + "," + i);
                int[] iArr = {lVar.f25999c, lVar.d, lVar.f, lVar.g};
                if (i == 0) {
                    if (i.this.e != null) {
                        i.this.e.f(i.this.b, iArr);
                    }
                } else if (1 != i || i.this.e == null) {
                } else {
                    i.this.e.g(i.this.b, iArr);
                }
            }

            @Override // com.opos.mobad.e.a.a
            public void a(Map map, String str3, com.opos.mobad.e.a.l lVar, String str4, int i) {
                com.opos.cmn.an.f.a.b("InteractiveTemplate", "action:" + str3);
                if (i.this.e != null) {
                    i.this.e.h(i.this.b, new int[]{lVar.f25999c, lVar.d, lVar.f, lVar.g});
                }
            }
        }).a(new com.opos.mobad.e.a.i() { // from class: com.opos.mobad.n.a.i.6
            @Override // com.opos.mobad.e.a.i
            public void a(Map map) {
                com.opos.cmn.an.f.a.b("InteractiveTemplate", "load success");
                i.this.i.a();
                i.this.j();
                if (i.this.e != null) {
                    i.this.e.e();
                }
            }

            @Override // com.opos.mobad.e.a.i
            public void a(Map map, String str3) {
                com.opos.cmn.an.f.a.b("InteractiveTemplate", "load fail :" + str3);
                i.this.i.a();
                if (i.this.e != null) {
                    i.this.e.b(3);
                }
            }
        }).a(this.f26516a, str, cVar.b, cVar.f26629c);
        this.f26517c = a2;
        View a3 = a2.a();
        this.n = str;
        com.opos.cmn.an.f.a.b("InteractiveTemplate", "show view :" + a3);
        this.g.removeAllViews();
        this.g.addView(a3, new ViewGroup.LayoutParams(-1, -1));
    }

    private boolean a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return new File(str).exists();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("InteractiveTemplate", "", e);
            return false;
        }
    }

    private void b(com.opos.mobad.n.d.c cVar) {
        com.opos.mobad.n.d.g gVar;
        com.opos.mobad.e.a.g gVar2 = this.f26517c;
        if (gVar2 == null) {
            return;
        }
        gVar2.a(cVar.f);
        this.f26517c.b(cVar.e);
        this.f26517c.c(cVar.l);
        if (cVar.j != null) {
            this.f26517c.b((Object) cVar.j.f26633a);
        }
        this.f26517c.a((Object) ((cVar.g == null || cVar.g.size() <= 0 || cVar.g.get(0) == null || (gVar = cVar.g.get(0)) == null) ? "" : gVar.f26633a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.opos.cmn.an.f.a.b("InteractiveTemplate", "stop process");
        this.h.a();
        if (this.k > 0) {
            this.j = h();
        }
        this.k = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        String str;
        if (this.o) {
            str = "start process but complete";
        } else if (this.l.w > 0) {
            a.InterfaceC0708a interfaceC0708a = this.e;
            if (interfaceC0708a != null) {
                interfaceC0708a.d(this.j, this.l.w);
            }
            com.opos.cmn.an.f.a.b("InteractiveTemplate", "start process");
            this.k = SystemClock.elapsedRealtime();
            this.h.a(1000L);
            return;
        } else {
            str = "start process but duration 0";
        }
        com.opos.cmn.an.f.a.b("InteractiveTemplate", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long h() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.k;
        if (elapsedRealtime <= 0) {
            elapsedRealtime = 0;
        }
        return elapsedRealtime + this.j;
    }

    private void i() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f26516a);
        this.b = relativeLayout;
        relativeLayout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.opos.mobad.n.a.i.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (i.this.e != null) {
                    i.this.e.b();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f26516a);
        aVar.a(new a.InterfaceC0678a() { // from class: com.opos.mobad.n.a.i.4
            @Override // com.opos.mobad.c.d.a.InterfaceC0678a
            public void a(boolean z) {
                com.opos.cmn.an.f.a.b("InteractiveTemplate", "visible change:" + z);
                i.this.q = z;
                if (i.this.f26517c == null) {
                    return;
                }
                if (!z || i.this.p) {
                    i.this.f26517c.b();
                    i.this.f();
                    return;
                }
                i.this.f26517c.c();
                i.this.g();
            }
        });
        this.b.addView(aVar, new ViewGroup.LayoutParams(0, 0));
        FrameLayout frameLayout = new FrameLayout(this.f26516a);
        this.g = frameLayout;
        this.b.addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
        this.f = new s(this.f26516a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f26516a, 50.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f26516a, 16.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f26516a, 16.0f);
        this.b.addView(this.f, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (!this.q || this.p) {
            return;
        }
        com.opos.mobad.e.a.g gVar = this.f26517c;
        if (gVar != null) {
            gVar.c();
        }
        g();
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        com.opos.cmn.an.f.a.b("InteractiveTemplate", "stop");
        this.p = true;
        com.opos.mobad.e.a.g gVar = this.f26517c;
        if (gVar != null) {
            gVar.b();
        }
        f();
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.e = interfaceC0708a;
        this.f.a(interfaceC0708a);
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.mobad.n.d.c c2 = hVar.c();
        if (c2 == null) {
            this.e.b(1);
            return;
        }
        com.opos.cmn.an.f.a.b("InteractiveTemplate", "render");
        this.f.a(c2.C, c2.s);
        a(c2, 0L);
        a(c2);
        this.l = c2;
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        com.opos.cmn.an.f.a.b("InteractiveTemplate", "start");
        this.p = false;
        j();
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.b;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("InteractiveTemplate", "destroy");
        String str = this.n;
        if (!TextUtils.isEmpty(str)) {
            this.m.a(str);
        }
        this.i.b();
        this.h.b();
        this.b.removeAllViews();
        com.opos.mobad.e.a.g gVar = this.f26517c;
        if (gVar != null) {
            gVar.d();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.d;
    }
}
