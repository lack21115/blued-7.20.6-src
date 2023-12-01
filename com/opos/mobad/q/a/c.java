package com.opos.mobad.q.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.AppPrivacyData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.o.d.e;
import com.opos.mobad.q.a.d;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/c.class */
public class c extends m {

    /* renamed from: a  reason: collision with root package name */
    protected Activity f27148a;
    protected Context b;

    /* renamed from: c  reason: collision with root package name */
    protected com.opos.mobad.n.a f27149c;
    protected AdItemData d;
    protected MaterialData e;
    protected com.opos.mobad.n.d.h f;
    protected d g;
    protected g h;
    protected boolean i;
    protected long j;
    protected com.opos.mobad.n.a k;
    private boolean p;
    private com.opos.mobad.o.a.a q;
    private int r;
    private boolean s;

    public c(Activity activity, String str, com.opos.mobad.cmn.a.a aVar, com.opos.mobad.n.a aVar2, d dVar, com.opos.mobad.o.a.a aVar3, com.opos.mobad.q.a.e.a aVar4) {
        this(activity, str, aVar, aVar2, dVar, aVar3, aVar4, null);
    }

    public c(Activity activity, String str, com.opos.mobad.cmn.a.a aVar, com.opos.mobad.n.a aVar2, d dVar, com.opos.mobad.o.a.a aVar3, com.opos.mobad.q.a.e.a aVar4, com.opos.mobad.n.a aVar5) {
        super(activity.getApplicationContext(), str, aVar, aVar4, aVar4);
        this.f = null;
        this.p = false;
        this.j = -1L;
        this.r = 2;
        this.s = false;
        this.b = activity.getApplicationContext();
        this.f27148a = activity;
        this.f27149c = aVar2;
        this.g = dVar;
        dVar.a(new d.b() { // from class: com.opos.mobad.q.a.c.1
            @Override // com.opos.mobad.q.a.d.b
            public void a(View view, int[] iArr) {
                c.this.a(iArr);
            }

            @Override // com.opos.mobad.q.a.d.b
            public void b(View view, int[] iArr) {
                c.this.j();
            }
        });
        this.f27149c.a(this);
        if (aVar5 != null) {
            this.k = aVar5;
            aVar5.a(this);
        }
        this.q = aVar3;
        aVar3.a(new com.opos.mobad.o.a.b() { // from class: com.opos.mobad.q.a.c.2
            @Override // com.opos.mobad.o.a.b
            public void a(int i) {
                c.this.l.c(i);
                c.this.f.b(false);
                c.this.f27149c.a(c.this.f);
            }

            @Override // com.opos.mobad.o.a.b
            public void a(boolean z) {
                c.this.j();
            }
        });
        aVar.a(new a.b() { // from class: com.opos.mobad.q.a.c.3
            @Override // com.opos.mobad.cmn.a.a.b
            public void a() {
                c.this.g.a();
            }

            @Override // com.opos.mobad.cmn.a.a.b
            public void a(final a.InterfaceC0679a interfaceC0679a) {
                c.this.f27149c.a();
                c.this.g.a(new d.a() { // from class: com.opos.mobad.q.a.c.3.1
                    @Override // com.opos.mobad.q.a.d.a
                    public void a() {
                        c.this.f27149c.b();
                        a.InterfaceC0679a interfaceC0679a2 = interfaceC0679a;
                        if (interfaceC0679a2 != null) {
                            interfaceC0679a2.a();
                        }
                    }

                    @Override // com.opos.mobad.q.a.d.a
                    public void b() {
                        c.this.f27149c.b();
                        a.InterfaceC0679a interfaceC0679a2 = interfaceC0679a;
                        if (interfaceC0679a2 != null) {
                            interfaceC0679a2.b();
                        }
                    }
                });
            }
        });
    }

    private void a(boolean z) {
        if (z) {
            try {
                if (1 == com.opos.cmn.an.h.b.a.b(this.b) || com.opos.cmn.an.h.b.a.b(this.b) == 0) {
                    b(false);
                    return;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("InteractivePresenter", "", (Throwable) e);
                return;
            }
        }
        b(true);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private void b(boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private void b(int[] iArr) {
        CharSequence c2 = this.n.c(this.j);
        if (TextUtils.isEmpty(c2)) {
            a(iArr);
            return;
        }
        this.f27149c.a();
        this.g.a(c2);
    }

    private void h() {
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.q.a.c.6
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f == null) {
                    return;
                }
                if (c.this.o >= 0) {
                    c.this.f.f(c.this.n.e(c.this.j));
                }
                c.this.f27149c.a(c.this.f);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r0.Q() == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void i() {
        /*
            r3 = this;
            r0 = r3
            com.opos.mobad.n.d.h r0 = r0.f
            if (r0 != 0) goto L8
            return
        L8:
            r0 = r3
            com.opos.mobad.q.a.l r0 = r0.n
            boolean r0 = r0.b()
            r6 = r0
            r0 = 1
            r4 = r0
            r0 = r6
            if (r0 == 0) goto L28
            r0 = r3
            int r0 = r0.r
            r1 = 1
            if (r0 != r1) goto L28
        L1e:
            r0 = r3
            com.opos.mobad.n.d.h r0 = r0.f
            r1 = 0
            com.opos.mobad.n.d.h r0 = r0.c(r1)
            return
        L28:
            r0 = r3
            int r0 = r0.r
            r5 = r0
            r0 = r5
            r1 = 1
            if (r0 != r1) goto L3c
        L32:
            r0 = r3
            com.opos.mobad.n.d.h r0 = r0.f
            r1 = r4
            com.opos.mobad.n.d.h r0 = r0.c(r1)
            return
        L3c:
            r0 = 2
            r4 = r0
            r0 = r5
            r1 = 2
            if (r0 != r1) goto L46
            goto L1e
        L46:
            r0 = r3
            com.opos.mobad.model.data.AdItemData r0 = r0.d
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L1e
            r0 = r7
            boolean r0 = r0.Q()
            if (r0 == 0) goto L1e
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.q.a.c.i():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.i || this.s) {
            com.opos.cmn.an.f.a.b("InteractivePresenter", "has complete not start");
        } else {
            this.f27149c.b();
        }
    }

    public void a() {
    }

    public void a(int i) {
        this.r = i;
        if (this.f == null) {
            return;
        }
        i();
        this.f27149c.a(this.f);
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void a(int i, String str) {
        super.a(i, str);
        this.g.b();
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void a(long j, long j2) {
        super.a(j, j2);
        this.f.d(2);
        this.f.f(this.n.e(this.j));
        this.f27149c.a(this.f);
        this.i = true;
    }

    public void a(Configuration configuration) {
    }

    @Override // com.opos.mobad.n.a.InterfaceC0708a
    public void a(View view, int[] iArr) {
        if (this.q != null) {
            this.f27149c.a();
            this.q.a(this.f27149c.c());
        }
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void a(View view, int[] iArr, boolean z) {
        this.f.d(!z ? 1 : 0);
        this.f27149c.a(this.f);
    }

    public void a(AdItemData adItemData, String str) {
        this.n.a(adItemData, str);
        h();
    }

    protected void a(int[] iArr) {
        l(null, iArr);
    }

    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            b((int[]) null);
            return true;
        } else if (i == 24) {
            a(false);
            return false;
        } else if (i == 25) {
            a(true);
            return false;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.mobad.q.a.m
    public boolean a(View view, int[] iArr, com.opos.mobad.cmn.a.b.a aVar) {
        return a(view, iArr, aVar, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(View view, int[] iArr, com.opos.mobad.cmn.a.b.a aVar, boolean z) {
        boolean a2;
        if (z) {
            boolean a3 = super.a(view, iArr, aVar, new a.c() { // from class: com.opos.mobad.q.a.c.8
                @Override // com.opos.mobad.cmn.a.a.c
                public void a(int i) {
                    if (i == 8 && (c.this.f27149c instanceof f)) {
                        ((f) c.this.f27149c).f();
                    }
                }

                @Override // com.opos.mobad.cmn.a.a.c
                public void a(int i, int i2) {
                }
            });
            a2 = a3;
            if (!a3) {
                a2 = a3;
                if (aVar == com.opos.mobad.cmn.a.b.a.Video) {
                    a2 = a3;
                    if (!this.i) {
                        if (this.s) {
                            this.f27149c.b();
                        } else {
                            this.f27149c.a();
                        }
                        this.s = !this.s;
                        return a3;
                    }
                }
            }
        } else {
            a2 = super.a(view, iArr, aVar);
        }
        return a2;
    }

    public boolean a(AdItemData adItemData, MaterialData materialData, int i, g gVar) {
        this.d = adItemData;
        this.e = materialData;
        this.h = gVar;
        long u = materialData.u();
        int e = this.f27149c.e();
        com.opos.mobad.n.a aVar = this.k;
        a(adItemData, materialData, u, e, aVar != null ? aVar.e() : 0);
        d(i);
        if (System.currentTimeMillis() > adItemData.s()) {
            com.opos.cmn.an.f.a.b("InteractivePresenter", "exp time");
            this.l.a(GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR);
            return false;
        }
        this.p = false;
        this.f = com.opos.mobad.model.a.a(this.b, adItemData, materialData, false);
        i();
        this.f27149c.a(this.f);
        com.opos.mobad.n.a aVar2 = this.k;
        if (aVar2 != null) {
            aVar2.a(this.f);
            this.k.c().setVisibility(8);
        }
        this.s = false;
        this.i = false;
        return true;
    }

    @Override // com.opos.mobad.n.a.InterfaceC0708a
    public void b() {
        super.a(this.f27149c.c());
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void b(int i) {
        super.b(i);
        this.g.b();
    }

    @Override // com.opos.mobad.n.a.InterfaceC0708a
    public void b(View view, int[] iArr) {
        String str;
        com.opos.cmn.an.f.a.b("InteractivePresenter", "onAppSafeClick");
        Activity activity = this.f27148a;
        if (activity == null || activity.isFinishing()) {
            str = "illegal activity";
        } else {
            AppPrivacyData O = this.d.O();
            if (O != null && !TextUtils.isEmpty(O.b)) {
                this.f27149c.a();
                this.g.a("隐私政策", O.b, new e.b() { // from class: com.opos.mobad.q.a.c.4
                    @Override // com.opos.mobad.o.d.e.b
                    public void a() {
                        c.this.j();
                    }
                });
                return;
            }
            str = "illegal url";
        }
        com.opos.cmn.an.f.a.a("InteractivePresenter", str);
    }

    public void b(AdItemData adItemData, String str) {
        this.n.b(adItemData, str);
        this.p = true;
        com.opos.mobad.n.d.h hVar = this.f;
        if (hVar == null) {
            return;
        }
        hVar.d(com.opos.mobad.model.a.a(this.b, this.e, true));
        h();
    }

    @Override // com.opos.mobad.q.a.m
    public void c() {
        com.opos.cmn.an.f.a.b("InteractivePresenter", "destroy");
        super.c();
        com.opos.mobad.o.a.a aVar = this.q;
        if (aVar != null) {
            aVar.a();
        }
        com.opos.mobad.n.a aVar2 = this.f27149c;
        if (aVar2 != null) {
            aVar2.d();
        }
        d dVar = this.g;
        if (dVar != null) {
            dVar.c();
        }
        com.opos.mobad.n.a aVar3 = this.k;
        if (aVar3 != null) {
            aVar3.d();
        }
    }

    @Override // com.opos.mobad.n.a.InterfaceC0708a
    public void c(View view, int[] iArr) {
        String str;
        com.opos.cmn.an.f.a.b("InteractivePresenter", "onAppPermissionClick");
        Activity activity = this.f27148a;
        if (activity == null || activity.isFinishing()) {
            str = "illegal activity";
        } else {
            AppPrivacyData O = this.d.O();
            if (O != null && !TextUtils.isEmpty(O.f26468a)) {
                this.f27149c.a();
                this.g.a("应用权限", O.f26468a, new e.b() { // from class: com.opos.mobad.q.a.c.5
                    @Override // com.opos.mobad.o.d.e.b
                    public void a() {
                        c.this.j();
                    }
                });
                return;
            }
            str = "illegal url";
        }
        com.opos.cmn.an.f.a.a("InteractivePresenter", str);
    }

    public void d() {
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void d(long j, long j2) {
        super.d(j, j2);
        this.j = j2;
        h();
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void d(View view, int[] iArr) {
        b(iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        a((int[]) null);
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void f(View view, int[] iArr) {
        super.f(view, iArr);
        h();
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void g(View view, int[] iArr) {
        super.g(view, iArr);
        h();
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void h(View view, int[] iArr) {
        super.h(view, iArr);
        h();
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void i(View view, int[] iArr) {
        int i = this.r;
        if (i == 1) {
            if (this.n.d()) {
                l(view, iArr);
            }
        } else if (i == 0) {
            com.opos.mobad.service.a.a().e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(View view, int[] iArr) {
        super.d(view, iArr);
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.c.7
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.h != null) {
                    c.this.h.a();
                }
            }
        });
    }
}
