package com.opos.mobad.f.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.opos.mobad.ad.b;
import com.opos.mobad.ad.e.f;
import com.opos.mobad.f.a.a.c;
import com.opos.mobad.service.a.e;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/c.class */
public class c extends com.opos.mobad.l.b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f26063a = c.class.getSimpleName();
    private com.opos.mobad.ad.e.f b;

    /* renamed from: c  reason: collision with root package name */
    private String f26064c;
    private RelativeLayout d;
    private com.opos.mobad.ad.e.c g;
    private ViewGroup h;
    private Context i;
    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.a> j;
    private com.opos.mobad.f.b k;
    private boolean l;
    private String m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/c$a.class */
    public class a extends com.opos.mobad.f.a.a.b implements com.opos.mobad.ad.e.c {

        /* renamed from: c  reason: collision with root package name */
        private final int f26073c;

        public a(int i, com.opos.mobad.f.a.a.n nVar) {
            super(i, nVar);
            this.f26073c = i;
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            c cVar = c.this;
            cVar.c("ad failed:" + i + ",msg:" + str + ", state=" + c.this.d());
            if (1 == c.this.d()) {
                super.a(i, str);
            } else if (2 == c.this.d() && this.f26073c == c.this.j.j()) {
                c.this.c(i, str);
            } else {
                c cVar2 = c.this;
                cVar2.c("ignore fail:" + this.f26073c);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j) {
            c cVar = c.this;
            cVar.c("ad click:" + this.f26073c + "," + c.this.j.i());
            if (this.f26073c != c.this.j.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().b(c.this.f26064c);
            c.this.i();
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            c.this.c("ad show");
            if (this.f26073c != c.this.j.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().a(c.this.f26064c);
            c.this.d(str);
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void b() {
            c cVar = c.this;
            cVar.c("ad close:" + this.f26073c + "," + c.this.j.i());
            if (this.f26073c != c.this.j.j()) {
                return;
            }
            c.this.i_();
        }
    }

    public c(final Context context, final String str, com.opos.mobad.ad.e.f fVar, com.opos.mobad.ad.e.c cVar, final com.opos.mobad.f.b bVar) {
        super(cVar);
        if (context == null || TextUtils.isEmpty(str) || fVar == null || cVar == null || bVar == null) {
            com.opos.cmn.an.f.a.c(f26063a, "HotSplashAd params null.");
            c(-1, "HotSplashAd params null.");
            return;
        }
        this.g = cVar;
        this.f26064c = str;
        this.i = context.getApplicationContext();
        this.d = new RelativeLayout(this.i);
        this.b = a(fVar);
        this.k = bVar;
        this.j = a(str, new com.opos.mobad.f.a.b.b<com.opos.mobad.ad.e.a>() { // from class: com.opos.mobad.f.a.c.1
            @Override // com.opos.mobad.f.a.b.a
            /* renamed from: a */
            public com.opos.mobad.ad.e.a b(e.a aVar, com.opos.mobad.f.a.a.n nVar) {
                com.opos.mobad.ad.c b = bVar.b(aVar.f27301a);
                if (b == null) {
                    return null;
                }
                return b.a(context, str, aVar.b, c.this.b, new a(aVar.f27301a, nVar));
            }
        }, new com.opos.mobad.f.a.c.a(this.i));
    }

    private com.opos.mobad.ad.e.f a(com.opos.mobad.ad.e.f fVar) {
        String str;
        f.a a2 = new f.a(this.i).a(fVar.f25680a).a(fVar.d).b(fVar.f).c(com.opos.mobad.service.f.b().a(this.f26064c) == com.opos.mobad.m.a.n.VERTICAL.a()).a(fVar.g);
        if (TextUtils.isEmpty(fVar.b)) {
            Context context = this.i;
            str = com.opos.mobad.l.n.a(context, context.getPackageName());
        } else {
            str = fVar.b;
        }
        String str2 = TextUtils.isEmpty(fVar.f25681c) ? "欢迎使用" : fVar.f25681c;
        return a2.b(str2).a(str).a(k.a(fVar.e, this.i, str, str2)).a();
    }

    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.a> a(final String str, final com.opos.mobad.f.a.b.b<com.opos.mobad.ad.e.a> bVar, final com.opos.mobad.f.a.c.a aVar) {
        final b.a aVar2 = new b.a() { // from class: com.opos.mobad.f.a.c.2
            @Override // com.opos.mobad.ad.b.a
            public void a() {
                c.this.c("onAdReady");
                com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.f.a.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.k();
                    }
                });
                c.this.o();
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i, String str2) {
                c cVar = c.this;
                cVar.c("onAdFailed code=" + i + ",msg =" + str2);
                c.this.b(com.opos.mobad.f.a.a.l.a(i), str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
                c.this.c("onAdClose");
                c.this.i_();
            }
        };
        final int k = com.opos.mobad.service.f.b().k();
        return new com.opos.mobad.f.a.a.c(str, 60, new c.a<com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.a>>() { // from class: com.opos.mobad.f.a.c.3
            @Override // com.opos.mobad.f.a.a.c.a
            public int a(int i) {
                return c.this.k.a(i);
            }

            @Override // com.opos.mobad.f.a.a.c.a
            public com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.a> a(List<e.a> list, e.a aVar3, long j) {
                return com.opos.mobad.f.a.a.k.a(str, new com.opos.mobad.f.a.d.b(k), list, aVar3, j, bVar, aVar, aVar2);
            }

            @Override // com.opos.mobad.f.a.a.c.a
            public com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.a> a(List<e.a> list, e.a aVar3, long j, int i) {
                return com.opos.mobad.f.a.a.k.a(str, new com.opos.mobad.f.a.d.c(i, k), list, aVar3, j, bVar, aVar, aVar2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.d.removeAllViews();
        com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.a> nVar = this.j;
        if (nVar == null) {
            return;
        }
        boolean z = nVar.j() != 1;
        if (z && this.b.h) {
            View a2 = this.b.e.a();
            if (this.d != null && a2 != null) {
                if (a2.getParent() != null) {
                    ((ViewGroup) a2.getParent()).removeView(a2);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) ((com.opos.cmn.an.h.f.a.b(this.i) * 0.3778f) + 0.5f));
                layoutParams.addRule(12);
                a2.setId(1);
                a2.setBackgroundColor(-1);
                l.a(this.d, a2, layoutParams);
            }
        }
        com.opos.mobad.ad.e.a i = this.j.i();
        if (i != null) {
            View h = i.h();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            if (z) {
                layoutParams2.addRule(2, 1);
            }
            if (l.a(this.d, h, layoutParams2)) {
                return;
            }
            c(10500, com.opos.mobad.ad.a.a(10500));
        }
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.service.f.b().k());
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void a(int i, String str, int i2) {
        if (com.opos.mobad.service.f.b().b(this.f26064c) && d() == 2 && !this.l) {
            this.l = true;
            com.opos.mobad.service.i.d.a().a(this.f26064c, this.m, i, str, this.j.j(), g(), i2);
        }
    }

    @Override // com.opos.mobad.ad.e.a
    public void a(Activity activity) {
        com.opos.mobad.ad.e.c cVar;
        String str;
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            cVar = this.g;
            str = "activity error.";
        } else if (com.opos.cmn.an.h.f.a.a(activity)) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            this.h = viewGroup;
            if (viewGroup == null) {
                cVar = this.g;
                str = "container null";
            } else {
                View h = h();
                if (h != null) {
                    ViewParent parent = h.getParent();
                    if (parent != null) {
                        if (parent == this.h) {
                            return;
                        }
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(h);
                        } else {
                            cVar = this.g;
                            str = "view had add to container";
                        }
                    }
                    this.h.addView(h, new ViewGroup.LayoutParams(-1, -1));
                    if (this.j.j() == 1 || this.j.j() == 8) {
                        this.j.i().a(activity);
                        return;
                    }
                    return;
                }
                cVar = this.g;
                str = "unknown error.";
            }
        } else {
            cVar = this.g;
            str = "splash must be displayed in full screen mode.";
        }
        cVar.a(-1, str);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        RelativeLayout relativeLayout;
        super.b();
        com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.a> nVar = this.j;
        if (nVar != null) {
            nVar.b();
        }
        ViewGroup viewGroup = this.h;
        if (viewGroup != null && (relativeLayout = this.d) != null) {
            viewGroup.removeView(relativeLayout);
        }
        this.h = null;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void b(int i) {
        if (com.opos.mobad.service.f.b().b(this.f26064c) && d() == 2 && !this.l) {
            this.l = true;
            com.opos.mobad.service.i.d.a().a(this.f26064c, this.m, this.j.j(), g(), i);
        }
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str, int i) {
        c("doload");
        this.l = false;
        this.m = str;
        this.j.a(str, i);
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return 0;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i) {
        com.opos.mobad.ad.e.a i2;
        if (com.opos.mobad.service.f.b().b(this.f26064c) && (i2 = this.j.i()) != null) {
            i2.c(i);
        }
    }

    public void c(String str) {
        com.opos.cmn.an.f.a.b("delegator Splash", str);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public boolean e() {
        com.opos.mobad.ad.e.a i = this.j.i();
        if (i != null) {
            return i.e();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        com.opos.mobad.ad.e.a i;
        if (com.opos.mobad.service.f.b().b(this.f26064c) && (i = this.j.i()) != null) {
            int g = i.g();
            if (g > 0) {
                return g;
            }
            e.a k = this.j.k();
            if (k == null || k.g <= 0) {
                return 0;
            }
            return k.g;
        }
        return 0;
    }

    @Override // com.opos.mobad.ad.e.b
    public View h() {
        if (d() != 2) {
            return null;
        }
        k();
        return this.d;
    }
}
