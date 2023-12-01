package com.opos.mobad.h.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.opos.mobad.ad.c.q;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.m;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/b/f.class */
public class f extends m {

    /* renamed from: a  reason: collision with root package name */
    private Context f26185a;
    private a.C0707a b;

    /* renamed from: c  reason: collision with root package name */
    private long f26186c;
    private boolean d;
    private com.opos.mobad.cmn.a.a e;
    private com.opos.mobad.o.a.a f;
    private final com.opos.mobad.n.a g;
    private boolean h;
    private boolean i;
    private boolean j;
    private com.opos.mobad.ad.privacy.b k;
    private boolean p;

    public f(Context context, a.C0707a c0707a, String str, com.opos.mobad.cmn.a.a aVar, com.opos.mobad.o.a.a aVar2, com.opos.mobad.n.a aVar3, b.InterfaceC0687b interfaceC0687b, m.a aVar4, com.opos.mobad.ad.privacy.b bVar) {
        super(context, str, aVar, interfaceC0687b, aVar4);
        this.d = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.p = false;
        this.f26185a = context;
        this.b = c0707a;
        this.f26186c = c0707a.f26482a.h();
        this.e = aVar;
        this.g = aVar3;
        aVar3.a(this);
        this.i = c0707a.f26483c.Z();
        a(this.b.b, this.b.f26483c, aVar3.e());
        this.f = aVar2;
        aVar2.a(new com.opos.mobad.o.a.b() { // from class: com.opos.mobad.h.b.f.1
            @Override // com.opos.mobad.o.a.b
            public void a(int i) {
                f.this.l.c(i);
                f.this.i = false;
                f.this.g.a(com.opos.mobad.model.a.a(f.this.f26185a, f.this.b, f.this.h, f.this.i));
                f fVar = f.this;
                if (fVar.a(fVar.b.f26483c)) {
                    f.this.d((View) null, (int[]) null);
                }
            }

            @Override // com.opos.mobad.o.a.b
            public void a(boolean z) {
                if (z) {
                    f.this.i = false;
                    f.this.g.a(com.opos.mobad.model.a.a(f.this.f26185a, f.this.b, f.this.h, f.this.i));
                    f fVar = f.this;
                    if (fVar.a(fVar.b.f26483c)) {
                        f.this.d((View) null, (int[]) null);
                    }
                }
            }
        });
        this.k = bVar;
    }

    public static q a(int i) {
        String str;
        q qVar = new q(-1, "unknown error.");
        if (i == 1000) {
            qVar.a(10300);
            str = "render ad failed,now time over ad expire time.";
        } else if (i != 1001) {
            return qVar;
        } else {
            qVar.a(10301);
            str = "render ad failed,ad item data is null.";
        }
        qVar.a(str);
        return qVar;
    }

    private ComplianceInfo a(AdItemData adItemData) {
        if (adItemData == null || adItemData.O() == null) {
            return null;
        }
        return new ComplianceInfo(adItemData.O().b, adItemData.O().f26468a);
    }

    public void a() {
        if (this.d) {
            b(1000);
        } else if (this.p) {
        } else {
            this.p = true;
            this.g.a(com.opos.mobad.model.a.a(this.f26185a, this.b, this.h, this.i));
        }
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void a(long j, long j2) {
        super.a(j, j2);
        this.j = false;
    }

    @Override // com.opos.mobad.n.a.InterfaceC0708a
    public void a(View view, int[] iArr) {
        if (a(this.b.f26483c)) {
            return;
        }
        this.f.a(view);
    }

    public void a(String str) {
        com.opos.cmn.an.f.a.b("NativeTemplatePresenter", "notifyInstallCompletedEvent pkgname =" + str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.b.f26483c.k()) || !this.b.f26483c.k().equals(str)) {
            return;
        }
        this.h = true;
        this.g.a(com.opos.mobad.model.a.a(this.f26185a, this.b, true, this.i));
    }

    public boolean a(MaterialData materialData) {
        if (materialData != null) {
            int b = materialData.b();
            if (b != 0) {
                switch (b) {
                    case 45:
                    case 46:
                    case 47:
                        return true;
                    default:
                        return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.opos.mobad.n.a.InterfaceC0708a
    public void b() {
        super.a(this.g.c());
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void b(long j, long j2) {
        super.b(j, j2);
        this.j = false;
    }

    @Override // com.opos.mobad.n.a.InterfaceC0708a
    public void b(View view, int[] iArr) {
        Activity activity = (view == null || !(view.getContext() instanceof Activity)) ? null : (Activity) view.getContext();
        com.opos.mobad.ad.privacy.b bVar = this.k;
        if (activity == null) {
            activity = this.f26185a;
        }
        bVar.a(activity, 0, a(this.b.b), null);
    }

    @Override // com.opos.mobad.q.a.m
    public void c() {
        super.c();
        com.opos.mobad.ad.privacy.b bVar = this.k;
        if (bVar != null) {
            bVar.a();
        }
        this.e = null;
        this.d = true;
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void c(long j, long j2) {
        super.b(j, j2);
        this.j = true;
    }

    @Override // com.opos.mobad.n.a.InterfaceC0708a
    public void c(View view, int[] iArr) {
        Activity activity = (view == null || !(view.getContext() instanceof Activity)) ? null : (Activity) view.getContext();
        com.opos.mobad.ad.privacy.b bVar = this.k;
        if (activity == null) {
            activity = this.f26185a;
        }
        bVar.a(activity, 1, a(this.b.b), null);
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void d(View view, int[] iArr) {
        if (this.i && a(this.b.f26483c)) {
            this.f.a(view);
        } else {
            super.d(view, iArr);
        }
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0708a
    public void e(View view, int[] iArr) {
        if (a(view, iArr, com.opos.mobad.cmn.a.b.a.Video)) {
            return;
        }
        if (this.j) {
            this.g.b();
        } else {
            this.g.a();
        }
        this.j = !this.j;
    }
}
