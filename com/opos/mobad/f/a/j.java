package com.opos.mobad.f.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.opos.mobad.ad.b;
import com.opos.mobad.ad.e.f;
import com.opos.mobad.f.a.a.c;
import com.opos.mobad.service.a.e;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/j.class */
public class j extends com.opos.mobad.l.i {

    /* renamed from: a  reason: collision with root package name */
    public static final String f26113a = j.class.getSimpleName();
    private com.opos.mobad.ad.e.f b;

    /* renamed from: c  reason: collision with root package name */
    private String f26114c;
    private RelativeLayout d;
    private ViewGroup g;
    private Context h;
    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.b> i;
    private RelativeLayout j;
    private com.opos.mobad.f.b k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/j$a.class */
    public class a extends com.opos.mobad.f.a.a.b implements com.opos.mobad.ad.e.c {

        /* renamed from: c  reason: collision with root package name */
        private final int f26122c;

        public a(int i, com.opos.mobad.f.a.a.n nVar) {
            super(i, nVar);
            this.f26122c = i;
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            j jVar = j.this;
            jVar.c("ad failed:" + i + ",msg:" + str + ", state=" + j.this.d());
            if (1 == j.this.d()) {
                super.a(i, str);
            } else if (2 == j.this.d() && this.f26122c == j.this.i.j()) {
                j.this.c(i, str);
            } else {
                j jVar2 = j.this;
                jVar2.c("ignore fail:" + this.f26122c);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j) {
            j jVar = j.this;
            jVar.c("ad click:" + this.f26122c + "," + j.this.i.i());
            if (this.f26122c != j.this.i.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().b(j.this.f26114c);
            j.this.i();
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            j.this.c("ad show");
            if (this.f26122c != j.this.i.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().a(j.this.f26114c);
            j.this.d(str);
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void b() {
            j jVar = j.this;
            jVar.c("ad close:" + this.f26122c + "," + j.this.i.i());
            if (this.f26122c != j.this.i.j()) {
                return;
            }
            j.this.i_();
        }
    }

    public j(final Activity activity, final String str, com.opos.mobad.ad.e.f fVar, com.opos.mobad.ad.e.c cVar, final com.opos.mobad.f.b bVar) {
        super(cVar);
        String str2;
        String str3;
        if (fVar == null) {
            str2 = f26113a;
            str3 = "SplashAd params null.";
        } else if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            com.opos.cmn.an.f.a.c("", "SplashAd constructor param activity error.");
            c(-1, "SplashAd Constructor param Activity was died.");
            return;
        } else if (com.opos.cmn.an.h.f.a.a(activity)) {
            this.f26114c = str;
            this.h = activity.getApplicationContext();
            this.b = a(fVar);
            this.d = new RelativeLayout(this.h);
            this.g = (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290);
            this.k = bVar;
            if (a(this.b.e.a())) {
                String a2 = com.opos.mobad.ad.a.a(10502);
                c(10502, a2);
                com.opos.cmn.an.f.a.c(f26113a, a2);
                return;
            }
            if (fVar.h) {
                a(this.h, this.b);
            }
            this.i = a(str, new com.opos.mobad.f.a.b.b<com.opos.mobad.ad.e.b>() { // from class: com.opos.mobad.f.a.j.1
                @Override // com.opos.mobad.f.a.b.a
                /* renamed from: a */
                public com.opos.mobad.ad.e.b b(e.a aVar, com.opos.mobad.f.a.a.n nVar) {
                    com.opos.mobad.ad.c b = bVar.b(aVar.f27301a);
                    if (b == null) {
                        return null;
                    }
                    return b.a(activity, str, aVar.b, j.this.b, (com.opos.mobad.ad.e.c) new a(aVar.f27301a, nVar));
                }
            }, new com.opos.mobad.f.a.c.a(this.h));
            return;
        } else {
            str2 = f26113a;
            str3 = "SplashAd must be displayed in full screen mode.";
        }
        com.opos.cmn.an.f.a.c(str2, str3);
        c(-1, str3);
    }

    private com.opos.mobad.ad.e.f a(com.opos.mobad.ad.e.f fVar) {
        String str;
        f.a a2 = new f.a(this.h).a(fVar.f25680a).a(fVar.d).b(fVar.f).c(fVar.h).a(fVar.g);
        if (TextUtils.isEmpty(fVar.b)) {
            Context context = this.h;
            str = com.opos.mobad.l.n.a(context, context.getPackageName());
        } else {
            str = fVar.b;
        }
        String str2 = TextUtils.isEmpty(fVar.f25681c) ? "欢迎使用" : fVar.f25681c;
        return a2.b(str2).a(str).a(k.a(fVar.e, this.h, str, str2)).a();
    }

    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.b> a(final String str, final com.opos.mobad.f.a.b.b<com.opos.mobad.ad.e.b> bVar, final com.opos.mobad.f.a.c.a aVar) {
        final b.a aVar2 = new b.a() { // from class: com.opos.mobad.f.a.j.2
            @Override // com.opos.mobad.ad.b.a
            public void a() {
                j.this.c("onAdReady");
                com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.f.a.j.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.this.d() == 5) {
                            j.this.c("remove but has destroy");
                            return;
                        }
                        j.this.m();
                        j.this.k();
                    }
                });
                j.this.o();
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i, String str2) {
                j jVar = j.this;
                jVar.c("onAdFailed code=" + i + ",msg =" + str2);
                j.this.b(com.opos.mobad.f.a.a.l.a(i), str2);
                j.this.m();
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
                j.this.c("onAdClose");
                j.this.i_();
            }
        };
        final int k = com.opos.mobad.service.f.b().k();
        return new com.opos.mobad.f.a.a.c(str, 60, new c.a<com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.b>>() { // from class: com.opos.mobad.f.a.j.3
            @Override // com.opos.mobad.f.a.a.c.a
            public int a(int i) {
                return j.this.k.a(i);
            }

            @Override // com.opos.mobad.f.a.a.c.a
            public com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.b> a(List<e.a> list, e.a aVar3, long j) {
                return com.opos.mobad.f.a.a.k.a(str, new com.opos.mobad.f.a.d.b(k), list, aVar3, j, bVar, aVar, aVar2);
            }

            @Override // com.opos.mobad.f.a.a.c.a
            public com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.b> a(List<e.a> list, e.a aVar3, long j, int i) {
                return com.opos.mobad.f.a.a.k.a(str, new com.opos.mobad.f.a.d.c(i, k), list, aVar3, j, bVar, aVar, aVar2);
            }
        });
    }

    private boolean a(View view) {
        return (view == null || view.getParent() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.d.removeAllViews();
        com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.b> nVar = this.i;
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
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) ((com.opos.cmn.an.h.f.a.b(this.h) * 0.3778f) + 0.5f));
                layoutParams.addRule(12);
                a2.setId(1);
                a2.setBackgroundColor(-1);
                l.a(this.d, a2, layoutParams);
            }
        }
        com.opos.mobad.ad.e.b i = this.i.i();
        if (i != null) {
            View h = i.h();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            if (z) {
                layoutParams2.addRule(2, 1);
            }
            if (!l.a(this.d, h, layoutParams2)) {
                c(10500, com.opos.mobad.ad.a.a(10500));
                return;
            }
        }
        l.a(this.g, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (d() == 5) {
            c("remove pre view but has destroy");
            return;
        }
        c("removePreLoadView");
        RelativeLayout relativeLayout = this.j;
        if (relativeLayout != null) {
            this.g.removeView(relativeLayout);
            this.j.removeAllViews();
            this.j = null;
        }
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.service.f.b().k());
    }

    public void a(Context context, com.opos.mobad.ad.e.f fVar) {
        View a2 = fVar.e.a();
        boolean z = fVar.d;
        c("showPreLoadPage: " + z);
        if (z) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            this.j = relativeLayout;
            relativeLayout.setBackgroundColor(-1);
            this.j.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.a(context));
            layoutParams.addRule(12);
            this.j.addView(a2, layoutParams);
            l.a(this.g, this.j);
        }
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.b> nVar = this.i;
        if (nVar != null) {
            nVar.b();
        }
        ViewGroup viewGroup = this.g;
        if (viewGroup != null) {
            RelativeLayout relativeLayout = this.j;
            if (relativeLayout != null) {
                viewGroup.removeView(relativeLayout);
            }
            RelativeLayout relativeLayout2 = this.d;
            if (relativeLayout2 != null) {
                viewGroup.removeView(relativeLayout2);
            }
            this.g = null;
        }
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    public boolean b(String str, int i) {
        c("doload");
        this.i.a(str, i);
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return 0;
    }

    public void c(String str) {
        com.opos.cmn.an.f.a.b("delegator Splash", str);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public boolean e() {
        com.opos.mobad.ad.e.b i = this.i.i();
        if (i != null) {
            return i.e();
        }
        return false;
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
