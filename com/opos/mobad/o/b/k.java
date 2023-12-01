package com.opos.mobad.o.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/b/k.class */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static volatile k f13388a;
    private RelativeLayout.LayoutParams b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13389c = false;
    private Handler d = new Handler(Looper.getMainLooper());
    private Runnable e = new Runnable() { // from class: com.opos.mobad.o.b.k.1
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.h != null && k.this.h.i() == 2 && k.this.i != null) {
                k.this.i.a(k.this.g, k.this.h.d());
            }
            k.this.d.postDelayed(k.this.e, 1000L);
        }
    };
    private boolean f;
    private String g;
    private com.opos.mobad.c.c.a h;
    private a i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/b/k$a.class */
    public class a implements f {
        private boolean b = true;

        /* renamed from: c  reason: collision with root package name */
        private f f13393c;

        public a(f fVar) {
            this.f13393c = fVar;
        }

        public void a() {
            this.b = false;
        }

        @Override // com.opos.mobad.c.c.b
        public void a(int i, String str) {
            if (this.b) {
                k.this.f = false;
            }
            f fVar = this.f13393c;
            if (fVar != null) {
                fVar.a(i, str);
            }
        }

        public void a(f fVar) {
            this.f13393c = fVar;
        }

        @Override // com.opos.mobad.o.b.f
        public void a(String str, long j) {
            f fVar = this.f13393c;
            if (fVar != null) {
                fVar.a(str, j);
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void c() {
            if (this.b) {
                k.this.f = true;
            }
            k.this.d.post(k.this.e);
            f fVar = this.f13393c;
            if (fVar != null) {
                fVar.c();
            }
            k.this.f13389c = false;
            com.opos.cmn.an.f.a.b("VideoPlayer", "onPrepare url:" + k.this.g);
        }

        @Override // com.opos.mobad.c.c.b
        public void d() {
            if (this.b) {
                k.this.f = true;
            }
            f fVar = this.f13393c;
            if (fVar != null) {
                fVar.d();
            }
            if (k.this.f13389c) {
                k.this.d.post(new Runnable() { // from class: com.opos.mobad.o.b.k.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (k.this.h != null && k.this.f13389c) {
                            com.opos.cmn.an.f.a.b("VideoPlayer", "onStart but pauseVideo");
                            k.this.h.f();
                        }
                        k.this.f13389c = false;
                    }
                });
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void e() {
            if (this.b) {
                k.this.f = false;
                k.this.c();
            }
            k.this.d.removeCallbacks(k.this.e);
            f fVar = this.f13393c;
            if (fVar != null) {
                fVar.e();
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void f() {
            if (this.b) {
                k.this.f = true;
            }
            k.this.d.post(k.this.e);
            f fVar = this.f13393c;
            if (fVar != null) {
                fVar.f();
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void g() {
            if (this.b) {
                k.this.f = false;
            }
            k.this.d.removeCallbacks(k.this.e);
            f fVar = this.f13393c;
            if (fVar != null) {
                fVar.g();
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void h() {
            f fVar = this.f13393c;
            if (fVar != null) {
                fVar.h();
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void i() {
            f fVar = this.f13393c;
            if (fVar != null) {
                fVar.i();
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void j() {
        }
    }

    private k() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.b = layoutParams;
        layoutParams.addRule(13);
    }

    public static k a() {
        k kVar;
        k kVar2 = f13388a;
        if (kVar2 == null) {
            synchronized (k.class) {
                try {
                    k kVar3 = f13388a;
                    kVar = kVar3;
                    if (kVar3 == null) {
                        kVar = new k();
                        f13388a = kVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return kVar;
        }
        return kVar2;
    }

    public void a(Context context, String str, int i, RelativeLayout relativeLayout, f fVar, boolean z) {
        if (context == null || TextUtils.isEmpty(str) || b()) {
            com.opos.cmn.an.f.a.a("VideoPlayer", "play with params null context=" + context + ",isplay:" + b() + ",url=" + str);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (this.h != null) {
            if (!TextUtils.isEmpty(this.g) && this.g.equals(str)) {
                this.h.f();
                View b = this.h.b();
                ViewGroup viewGroup = (ViewGroup) b.getParent();
                if (viewGroup == null || relativeLayout != viewGroup) {
                    com.opos.cmn.an.f.a.b("VideoPlayer", "play to other media view");
                    if (viewGroup != null) {
                        viewGroup.removeView(b);
                    }
                    relativeLayout.removeAllViews();
                    b.setLayoutParams(this.b);
                    relativeLayout.addView(b);
                    relativeLayout.bringToFront();
                }
                this.i.a(fVar);
                com.opos.mobad.c.c.a aVar = this.h;
                if (z) {
                    aVar.a(1.0f);
                } else {
                    aVar.a(0.0f);
                }
                this.h.g();
                return;
            }
            c();
        }
        a aVar2 = new a(fVar);
        this.i = aVar2;
        com.opos.mobad.c.c.a a2 = com.opos.mobad.r.a.d.a(applicationContext, i, aVar2);
        this.h = a2;
        this.g = str;
        this.f = true;
        a2.a(str);
        com.opos.mobad.c.c.a aVar3 = this.h;
        if (z) {
            aVar3.a(1.0f);
        } else {
            aVar3.a(0.0f);
        }
        this.h.b().setLayoutParams(this.b);
        relativeLayout.addView(this.h.b());
    }

    public void a(String str, ViewGroup viewGroup) {
        com.opos.mobad.c.c.a aVar;
        if (TextUtils.isEmpty(this.g) || !this.g.equals(str) || (aVar = this.h) == null) {
            return;
        }
        View b = aVar.b();
        ViewGroup viewGroup2 = (ViewGroup) b.getParent();
        if (viewGroup2 != null && viewGroup != viewGroup2) {
            com.opos.cmn.an.f.a.b("VideoPlayer", "play to other media view");
            viewGroup2.removeView(b);
            viewGroup.removeAllViews();
            viewGroup.addView(b);
            viewGroup.bringToFront();
        }
        this.h.g();
    }

    public void a(String str, boolean z) {
        com.opos.mobad.c.c.a aVar;
        if (TextUtils.isEmpty(this.g) || !this.g.equals(str) || (aVar = this.h) == null) {
            return;
        }
        aVar.a(z ? 1.0f : 0.0f);
    }

    public boolean a(String str) {
        return !TextUtils.isEmpty(this.g) && this.g.equals(str);
    }

    public void b(Context context, String str, int i, RelativeLayout relativeLayout, f fVar, boolean z) {
        if (context == null || TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.a("VideoPlayer", "play with params null context=" + context + ",url=" + str);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (this.h != null) {
            if (!TextUtils.isEmpty(this.g) && this.g.equals(str)) {
                this.h.f();
                View b = this.h.b();
                ViewGroup viewGroup = (ViewGroup) b.getParent();
                if (viewGroup == null || relativeLayout != viewGroup) {
                    com.opos.cmn.an.f.a.b("", "play to other media view");
                    if (viewGroup != null) {
                        viewGroup.removeView(b);
                    }
                    relativeLayout.removeAllViews();
                    b.setLayoutParams(this.b);
                    relativeLayout.addView(b);
                    relativeLayout.bringToFront();
                }
                this.i.a(fVar);
                com.opos.mobad.c.c.a aVar = this.h;
                if (z) {
                    aVar.a(1.0f);
                } else {
                    aVar.a(0.0f);
                }
                this.h.g();
                return;
            }
            c();
        }
        a aVar2 = new a(fVar);
        this.i = aVar2;
        com.opos.mobad.c.c.a a2 = com.opos.mobad.r.a.d.a(applicationContext, i, aVar2);
        this.h = a2;
        this.g = str;
        this.f = true;
        a2.a(str);
        com.opos.mobad.c.c.a aVar3 = this.h;
        if (z) {
            aVar3.a(1.0f);
        } else {
            aVar3.a(0.0f);
        }
        this.h.b().setLayoutParams(this.b);
        relativeLayout.addView(this.h.b());
    }

    public void b(String str) {
        if (TextUtils.isEmpty(this.g) || !this.g.equals(str) || this.h == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("VideoPlayer", "mExoVideoPlayer.getState()=" + this.h.i());
        if (this.h.i() == 1) {
            this.f13389c = true;
        } else {
            this.h.f();
        }
    }

    public boolean b() {
        return this.f;
    }

    public int c(String str) {
        com.opos.mobad.c.c.a aVar;
        if (TextUtils.isEmpty(this.g) || !this.g.equals(str) || (aVar = this.h) == null) {
            return 0;
        }
        return aVar.i();
    }

    public void c() {
        com.opos.cmn.an.f.a.b("VideoPlayer", "video player release");
        if (this.h != null) {
            a aVar = this.i;
            if (aVar != null) {
                aVar.a();
                this.i = null;
            }
            this.d.removeCallbacks(this.e);
            this.h.f();
            final com.opos.mobad.c.c.a aVar2 = this.h;
            com.opos.cmn.an.j.b.d(new Runnable() { // from class: com.opos.mobad.o.b.k.2
                @Override // java.lang.Runnable
                public void run() {
                    com.opos.mobad.c.c.a aVar3 = aVar2;
                    if (aVar3 != null) {
                        aVar3.h();
                    }
                }
            });
            this.h = null;
            this.g = null;
            this.f = false;
        }
    }

    public void c(Context context, String str, int i, RelativeLayout relativeLayout, f fVar, boolean z) {
        if (context == null || TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.a("VideoPlayer", "play with params null");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        com.opos.mobad.c.c.a aVar = this.h;
        if (aVar != null) {
            aVar.h();
        }
        a aVar2 = new a(fVar);
        this.i = aVar2;
        com.opos.mobad.c.c.a a2 = com.opos.mobad.r.a.d.a(applicationContext, i, aVar2);
        this.h = a2;
        a2.b().setLayoutParams(this.b);
        relativeLayout.addView(this.h.b());
        this.g = str;
        this.f = true;
        this.h.a(z ? 1.0f : 0.0f);
        this.h.a(str);
    }

    public long d(String str) {
        com.opos.mobad.c.c.a aVar;
        if (TextUtils.isEmpty(this.g) || !this.g.equals(str) || (aVar = this.h) == null) {
            return 0L;
        }
        return aVar.c();
    }

    public long e(String str) {
        com.opos.mobad.c.c.a aVar;
        if (TextUtils.isEmpty(this.g) || !this.g.equals(str) || (aVar = this.h) == null) {
            return 0L;
        }
        return aVar.d();
    }
}
