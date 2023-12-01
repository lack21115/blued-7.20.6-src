package com.opos.mobad.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.m;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/a/c.class */
public class c extends m implements b {

    /* renamed from: a  reason: collision with root package name */
    private Context f11921a;
    private Activity b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.mobad.o.a.a f11922c;
    private a.C0537a d;
    private boolean e;
    private com.opos.mobad.ad.privacy.b f;
    private boolean g;
    private boolean h;
    private a i;
    private com.opos.mobad.a.a.b j;

    public c(Activity activity, String str, com.opos.mobad.cmn.a.a aVar, com.opos.mobad.o.a.a aVar2, com.opos.mobad.ad.privacy.b bVar, b.InterfaceC0517b interfaceC0517b, a aVar3, com.opos.mobad.a.a.b bVar2) {
        super(activity.getApplicationContext(), str, aVar, interfaceC0517b, aVar3);
        this.e = false;
        this.g = false;
        this.h = false;
        this.b = activity;
        this.f11921a = activity.getApplicationContext();
        this.f = bVar;
        this.f11922c = aVar2;
        aVar2.a(new com.opos.mobad.o.a.b() { // from class: com.opos.mobad.a.c.1
            @Override // com.opos.mobad.o.a.b
            public void a(int i) {
                c.this.l.c(i);
                c.this.e = false;
                c.this.j.a(com.opos.mobad.model.a.a(c.this.f11921a, c.this.d, c.this.g, c.this.e));
                if (c.b(c.this.d.f12795c)) {
                    c.this.d((View) null, (int[]) null);
                }
            }

            @Override // com.opos.mobad.o.a.b
            public void a(boolean z) {
                if (z) {
                    c.this.e = false;
                    c.this.j.a(com.opos.mobad.model.a.a(c.this.f11921a, c.this.d, c.this.g, c.this.e));
                    if (c.b(c.this.d.f12795c)) {
                        c.this.d((View) null, (int[]) null);
                    }
                }
            }
        });
        this.i = aVar3;
        this.j = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(MaterialData materialData) {
        return materialData != null && materialData.b() == 0;
    }

    public View a() {
        com.opos.mobad.a.a.b bVar = this.j;
        if (bVar == null) {
            return null;
        }
        return bVar.c();
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void a(View view, int[] iArr) {
        if (this.h || b(this.d.f12795c)) {
            return;
        }
        this.f11922c.a(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a.C0537a c0537a, com.opos.mobad.n.a aVar) {
        if (aVar == null || c0537a == null) {
            com.opos.cmn.an.f.a.b("InterBannerPresenter", "render fail null data or template = " + aVar);
            b(1);
            return;
        }
        this.d = c0537a;
        a(c0537a.b, c0537a.f12795c, aVar.e());
        this.e = c0537a.f12795c.Z();
        this.g = false;
        this.j.a(aVar);
        this.j.a(this);
        this.j.a(com.opos.mobad.model.a.a(this.f11921a, c0537a, this.g, this.e));
    }

    @Override // com.opos.mobad.a.b
    public void a(boolean z) {
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void b() {
        super.a(this.j.c());
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void b(View view, int[] iArr) {
        if (this.h) {
            return;
        }
        this.f.a(this.b, 0, com.opos.mobad.cmn.a.e.a(this.d.b), null);
    }

    @Override // com.opos.mobad.q.a.m
    public void c() {
        this.h = true;
        this.b = null;
        com.opos.mobad.a.a.b bVar = this.j;
        if (bVar != null) {
            bVar.d();
        }
        com.opos.mobad.ad.privacy.b bVar2 = this.f;
        if (bVar2 != null) {
            bVar2.a();
        }
        super.c();
    }

    @Override // com.opos.mobad.n.a.InterfaceC0538a
    public void c(View view, int[] iArr) {
        if (this.h) {
            return;
        }
        this.f.a(this.b, 1, com.opos.mobad.cmn.a.e.a(this.d.b), null);
    }

    public void d() {
        com.opos.mobad.a.a.b bVar;
        if (this.h || (bVar = this.j) == null) {
            return;
        }
        this.g = true;
        bVar.a(com.opos.mobad.model.a.a(this.f11921a, this.d, true, this.e));
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0538a
    public void d(View view, int[] iArr) {
        if (this.h) {
            return;
        }
        if (this.e && b(this.d.f12795c)) {
            this.f11922c.a(view);
        } else {
            super.d(view, iArr);
        }
    }
}
