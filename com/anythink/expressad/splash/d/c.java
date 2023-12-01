package com.anythink.expressad.splash.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.core.common.a.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.u;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.out.e;
import com.anythink.expressad.out.t;
import com.anythink.expressad.splash.view.ATSplashPopView;
import com.anythink.expressad.splash.view.ATSplashView;
import com.anythink.expressad.splash.view.ATSplashWebview;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/d/c.class */
public final class c implements g {
    private static String b = "SplashProvider";
    private Context A;
    private boolean B;
    private com.anythink.expressad.foundation.d.c C;
    private ATSplashPopView D;

    /* renamed from: c  reason: collision with root package name */
    private String f5389c;
    private String d;
    private long f;
    private int g;
    private int h;
    private com.anythink.expressad.splash.c.c i;
    private com.anythink.expressad.splash.c.d j;
    private b k;
    private e l;
    private d m;
    private ATSplashView n;
    private ATSplashWebview o;
    private ViewGroup p;
    private View q;
    private com.anythink.expressad.d.c r;
    private boolean s;
    private ViewGroup t;
    private boolean u;
    private int w;
    private int x;
    private int e = 5;
    private int v = 1;
    private Object y = new Object();
    private Object z = new Object();

    /* renamed from: a  reason: collision with root package name */
    public boolean f5388a = false;
    private boolean E = false;
    private boolean F = false;

    public c(Context context, String str, String str2) {
        this.w = k.e(n.a().g());
        this.x = k.f(n.a().g());
        this.w = context.getResources().getDisplayMetrics().widthPixels;
        this.x = context.getResources().getDisplayMetrics().heightPixels;
        this.d = str;
        this.f5389c = str2;
        this.A = context;
        if (this.j == null) {
            if (context != null) {
                this.j = new com.anythink.expressad.splash.c.d(context, str, str2);
            } else {
                this.j = new com.anythink.expressad.splash.c.d(n.a().g(), this.d, this.f5389c);
            }
        }
        if (this.o == null) {
            try {
                if (context != null) {
                    this.o = new ATSplashWebview(context);
                } else {
                    this.o = new ATSplashWebview(n.a().g());
                }
            } catch (Exception e) {
            }
            ATSplashWebview aTSplashWebview = this.o;
            if (aTSplashWebview != null) {
                aTSplashWebview.setWebViewClient(new com.anythink.expressad.splash.view.b(this.f5389c, this.j.a()));
            }
        }
        if (this.n == null) {
            if (context != null) {
                this.n = new ATSplashView(context);
            } else {
                this.n = new ATSplashView(n.a().g());
            }
            this.n.setSplashWebview(this.o);
        }
    }

    private ViewGroup a(t tVar) {
        ATSplashPopView aTSplashPopView = new ATSplashPopView(n.a().g(), new ATSplashPopView.a(this.d, this.f5389c, tVar.a(), this.C), this.m);
        this.D = aTSplashPopView;
        return aTSplashPopView;
    }

    private void a(int i, int i2) {
        int e = k.e(n.a().g());
        int f = k.f(n.a().g());
        int i3 = this.v;
        if (i3 == 1) {
            if (f >= i2 * 4) {
                this.x = f - i2;
                this.w = e;
                return;
            }
            this.x = 0;
            this.w = 0;
        } else if (i3 == 2) {
            if (e >= i * 4) {
                this.w = e - i;
                this.x = f;
                return;
            }
            this.x = 0;
            this.w = 0;
        }
    }

    private void a(long j) {
        this.f = j;
    }

    private void a(Context context) {
        if (this.j == null) {
            if (context != null) {
                this.j = new com.anythink.expressad.splash.c.d(context, this.d, this.f5389c);
            } else {
                this.j = new com.anythink.expressad.splash.c.d(n.a().g(), this.d, this.f5389c);
            }
        }
        if (this.o == null) {
            try {
                if (context != null) {
                    this.o = new ATSplashWebview(context);
                } else {
                    this.o = new ATSplashWebview(n.a().g());
                }
            } catch (Exception e) {
            }
            ATSplashWebview aTSplashWebview = this.o;
            if (aTSplashWebview != null) {
                aTSplashWebview.setWebViewClient(new com.anythink.expressad.splash.view.b(this.f5389c, this.j.a()));
            }
        }
        if (this.n == null) {
            if (context != null) {
                this.n = new ATSplashView(context);
            } else {
                this.n = new ATSplashView(n.a().g());
            }
            this.n.setSplashWebview(this.o);
        }
    }

    private void a(View view, RelativeLayout.LayoutParams layoutParams) {
        this.q = view;
        if (view != null) {
            a(layoutParams.width, layoutParams.height);
            ATSplashView aTSplashView = this.n;
            if (aTSplashView != null) {
                aTSplashView.setIconVg(view, layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.anythink.expressad.foundation.d.c cVar, final int i, final boolean z) {
        if (!com.anythink.expressad.splash.c.b.a(this.n, cVar)) {
            if (i > 0) {
                this.j.f5370a.postDelayed(new Runnable() { // from class: com.anythink.expressad.splash.d.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.a(cVar, i - 1, z);
                    }
                }, 1L);
                return;
            }
            d dVar = this.m;
            if (dVar != null) {
                dVar.a("campaignEx is not ready");
                return;
            }
            return;
        }
        l();
        this.j.a(this.e);
        this.j.a(this.t);
        this.j.a(this.m);
        o.d(b, "start show process");
        ViewGroup viewGroup = this.p;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            u.a(this.n);
            this.p.addView(this.n, new ViewGroup.LayoutParams(-1, -1));
        }
        this.j.a(this.u);
        this.j.a(cVar, this.n);
    }

    private void a(String str, ViewGroup viewGroup) {
        if (!TextUtils.isEmpty(str)) {
            a(viewGroup);
            return;
        }
        e eVar = this.l;
        if (eVar != null) {
            eVar.a("token is null or empty");
        }
    }

    private void b(int i) {
        this.v = i;
    }

    private void b(ViewGroup viewGroup) {
        this.t = viewGroup;
    }

    private void c(boolean z) {
        this.B = z;
    }

    private String h() {
        if (this.f5388a) {
            com.anythink.expressad.splash.c.d dVar = this.j;
            return dVar != null ? dVar.b() : "";
        }
        com.anythink.expressad.splash.c.c cVar = this.i;
        return cVar != null ? cVar.a() : "";
    }

    private void i() {
        this.E = true;
        ATSplashPopView aTSplashPopView = this.D;
        if (aTSplashPopView != null) {
            aTSplashPopView.startCountDown();
        }
    }

    private void j() {
        this.E = false;
        ATSplashPopView aTSplashPopView = this.D;
        if (aTSplashPopView != null) {
            aTSplashPopView.release();
        }
    }

    private void k() {
        com.anythink.expressad.splash.c.d dVar = this.j;
        if (dVar != null) {
            dVar.d();
        }
        ATSplashPopView aTSplashPopView = this.D;
        if (aTSplashPopView == null || !this.E) {
            return;
        }
        aTSplashPopView.reStartCountDown();
    }

    private void l() {
        ATSplashWebview aTSplashWebview = this.o;
        if (aTSplashWebview != null) {
            aTSplashWebview.setOnTouchListener(new View.OnTouchListener() { // from class: com.anythink.expressad.splash.d.c.2

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ boolean f5392a = true;

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return !this.f5392a;
                }
            });
        }
        ATSplashView aTSplashView = this.n;
        if (aTSplashView != null) {
            aTSplashView.setOnTouchListener(new View.OnTouchListener() { // from class: com.anythink.expressad.splash.d.c.3

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ boolean f5393a = true;

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return !this.f5393a;
                }
            });
        }
    }

    private void m() {
        com.anythink.expressad.splash.c.d dVar = this.j;
        if (dVar != null) {
            dVar.e();
        }
        ATSplashPopView aTSplashPopView = this.D;
        if (aTSplashPopView == null || !this.E) {
            return;
        }
        aTSplashPopView.pauseCountDown();
    }

    public final void a(int i) {
        this.e = i;
    }

    public final void a(ViewGroup viewGroup) {
        this.p = viewGroup;
        ATSplashView aTSplashView = this.n;
        if (aTSplashView != null) {
            aTSplashView.setDevContainer(viewGroup);
        }
        com.anythink.expressad.splash.c.c cVar = this.i;
        com.anythink.expressad.foundation.d.c c2 = cVar != null ? cVar.c() : null;
        if (c2 == null) {
            e eVar = this.l;
            if (eVar != null) {
                eVar.a("campaignEx is vali");
                return;
            }
            return;
        }
        if (this.r == null) {
            com.anythink.expressad.d.b.a();
            this.r = com.anythink.expressad.d.b.a(com.anythink.expressad.foundation.b.a.b().e(), this.f5389c);
        }
        this.m = new d(this, this.l, this.r.a(), c2);
        o.a(b, "show start");
        int i = this.e;
        if (i < 2 || i > 10) {
            this.e = 5;
        }
        a(c2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z) {
        if (cVar != null && z) {
            if (this.r == null) {
                com.anythink.expressad.d.b.a();
                this.r = com.anythink.expressad.d.b.a(com.anythink.expressad.foundation.b.a.b().e(), this.f5389c);
            }
            this.m = new d(this, this.l, this.r.a(), cVar);
        }
        this.C = cVar;
        ViewGroup viewGroup = this.p;
        if (viewGroup != null) {
            if (this.j == null) {
                this.j = new com.anythink.expressad.splash.c.d(viewGroup.getContext(), this.d, this.f5389c);
            }
            a(cVar, 0, z);
            return;
        }
        d dVar = this.m;
        if (dVar != null) {
            dVar.a("container is null");
        }
    }

    public final void a(com.anythink.expressad.foundation.d.d dVar) {
        synchronized (this.y) {
            if (this.s) {
                if (this.k != null) {
                    this.k.a("current unit is loading");
                    this.s = true;
                }
                return;
            }
            this.s = true;
            this.n.clearResState();
            this.r = new com.anythink.expressad.d.c();
            if (this.i == null) {
                this.i = new com.anythink.expressad.splash.c.c(this.d, this.f5389c, this.f * 1000);
            }
            b bVar = this.k;
            if (bVar != null) {
                bVar.b("");
                this.i.a(this.k);
            }
            this.n.resetLoadState();
            this.i.b(this.e);
            this.i.a(this.n);
            this.i.a(this.r);
            this.i.a(this.w, this.x);
            this.i.b(this.u);
            this.i.a(this.F);
            this.i.a(this.v);
            this.i.a(dVar);
        }
    }

    public final void a(com.anythink.expressad.out.d dVar) {
        if (this.k == null) {
            this.k = new b(this);
        }
        this.k.a(dVar);
    }

    public final void a(e eVar) {
        this.l = eVar;
    }

    public final void a(boolean z) {
        this.F = z;
    }

    public final boolean a() {
        return this.s;
    }

    public final void b() {
        this.s = false;
    }

    public final void b(boolean z) {
        this.u = z;
    }

    public final long c() {
        return this.f;
    }

    public final boolean d() {
        return this.u;
    }

    public final int e() {
        return this.e;
    }

    public final void f() {
        a(100, 100);
    }

    public final void g() {
        this.C = null;
        if (this.l != null) {
            this.l = null;
        }
        if (this.k != null) {
            this.k = null;
        }
        if (this.m != null) {
            this.m = null;
        }
        com.anythink.expressad.splash.c.c cVar = this.i;
        if (cVar != null) {
            cVar.b();
        }
        com.anythink.expressad.splash.c.d dVar = this.j;
        if (dVar != null) {
            dVar.c();
        }
        if (this.A != null) {
            this.A = null;
        }
    }

    public final boolean isReady() {
        return this.i.c() != null && com.anythink.expressad.splash.c.b.a(this.n, this.i.c());
    }
}
