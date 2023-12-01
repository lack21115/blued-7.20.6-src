package com.opos.mobad.k;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.opos.mobad.k.f;
import com.opos.mobad.model.data.AppPrivacyData;
import com.opos.mobad.o.d.e;
import com.opos.mobad.q.a.m;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/k/b.class */
class b extends m {

    /* renamed from: a  reason: collision with root package name */
    private final Context f26279a;
    private f.a b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f26280c;
    private com.opos.mobad.n.a d;
    private String e;
    private Activity f;
    private Dialog g;
    private final long h;

    public b(Context context, String str, com.opos.mobad.cmn.a.a aVar, d dVar) {
        super(context, str, aVar, null, dVar);
        this.b = null;
        this.f26280c = false;
        this.h = 500L;
        this.f26279a = com.opos.mobad.service.b.a(context.getApplicationContext());
        this.e = str;
    }

    private void d() {
        Activity activity;
        Dialog dialog = this.g;
        if (dialog == null || !dialog.isShowing() || (activity = this.f) == null || activity.isFinishing() || this.f.isDestroyed()) {
            com.opos.cmn.an.f.a.b("InterSplash$Presenter", "dialog not dismiss for finishing");
        } else {
            this.g.dismiss();
        }
    }

    public View a() {
        com.opos.cmn.an.f.a.b("InterSplash$Presenter", "getSplashView" + this.d);
        com.opos.mobad.n.a aVar = this.d;
        if (aVar == null) {
            return null;
        }
        return aVar.c();
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void a(int i, String str) {
        super.a(i, str);
        this.l.b(false, null);
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void a(long j, long j2) {
        this.m.a(j2);
        this.l.b(false, null);
    }

    public void a(Activity activity) {
        this.f = activity;
    }

    @Override // com.opos.mobad.n.a.InterfaceC0708a
    public void a(View view, int[] iArr) {
    }

    public void a(f.a aVar, com.opos.mobad.n.a aVar2, com.opos.mobad.n.d dVar, com.opos.mobad.n.c cVar) {
        String str;
        com.opos.cmn.an.f.a.b("InterSplash$Presenter", "createSplash");
        if (aVar == null) {
            str = "create splash failed,splashVo Data is null!";
        } else if (aVar2 != null) {
            this.d = aVar2;
            aVar2.a(this);
            this.b = aVar;
            a(aVar.b.b, aVar.b.f26483c, aVar.a(), this.d.e());
            this.d.a(f.a(this.f26279a, aVar, dVar, cVar));
            return;
        } else {
            str = "create splash failed,ad template is null!";
        }
        com.opos.cmn.an.f.a.c("InterSplash$Presenter", str);
    }

    @Override // com.opos.mobad.q.a.m
    public boolean a(View view, final int[] iArr, com.opos.mobad.cmn.a.b.a aVar) {
        boolean a2 = super.a(view, iArr, aVar);
        if (a2) {
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.k.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.l.b(false, iArr);
                }
            }, 100L);
        }
        return a2;
    }

    @Override // com.opos.mobad.n.a.InterfaceC0708a
    public void b() {
        super.a(this.d.c());
    }

    @Override // com.opos.mobad.n.a.InterfaceC0708a
    public void b(View view, int[] iArr) {
        String str;
        Activity activity = this.f;
        if (activity == null || activity.isFinishing()) {
            str = "illegal activity";
        } else {
            AppPrivacyData O = this.b.b.b.O();
            if (O != null && !TextUtils.isEmpty(O.b)) {
                this.d.a();
                d();
                this.g = com.opos.mobad.o.d.e.a(this.f, "隐私政策", O.b, new e.b() { // from class: com.opos.mobad.k.b.2
                    @Override // com.opos.mobad.o.d.e.b
                    public void a() {
                        if (b.this.f26280c) {
                            return;
                        }
                        b.this.d.b();
                    }
                });
                return;
            }
            str = "illegal url";
        }
        com.opos.cmn.an.f.a.a("InterSplash$Presenter", str);
    }

    @Override // com.opos.mobad.q.a.m
    public void c() {
        if (this.f26280c) {
            return;
        }
        synchronized (b.class) {
            try {
                super.c();
                com.opos.cmn.an.f.a.b("InterSplash$Presenter", "destroy");
                if (this.d != null) {
                    this.d.d();
                }
                d();
                this.f = null;
                this.f26280c = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.opos.mobad.n.a.InterfaceC0708a
    public void c(View view, int[] iArr) {
        String str;
        Activity activity = this.f;
        if (activity == null || activity.isFinishing()) {
            str = "illegal activity";
        } else {
            AppPrivacyData O = this.b.b.b.O();
            if (O != null && !TextUtils.isEmpty(O.f26468a)) {
                this.d.a();
                d();
                this.g = com.opos.mobad.o.d.e.a(this.f, "应用权限", O.f26468a, new e.b() { // from class: com.opos.mobad.k.b.3
                    @Override // com.opos.mobad.o.d.e.b
                    public void a() {
                        if (b.this.f26280c) {
                            return;
                        }
                        b.this.d.b();
                    }
                });
                return;
            }
            str = "illegal url";
        }
        com.opos.cmn.an.f.a.a("InterSplash$Presenter", str);
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void d(long j, long j2) {
        long a2 = this.b.a();
        if (j2 > 0) {
            a2 = Math.min(j2, this.b.a());
        }
        super.d(j, a2);
        if (j2 <= this.b.a() + 500 || this.b.f26294c) {
            return;
        }
        com.opos.cmn.an.f.a.b("InterSplash$Presenter", "report material video over time " + (this.b.a() + 500));
        this.b.f26294c = true;
        com.opos.mobad.service.i.d.a().c().d(this.b.b.f26483c.aa());
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void d(View view, int[] iArr) {
        this.l.b(true, iArr);
    }
}
