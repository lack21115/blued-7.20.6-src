package com.opos.cmn.e.a.b.e;

import android.app.Activity;
import android.view.View;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/b/e/b.class */
public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    private com.opos.cmn.e.a.b.f.a f11087c;

    public b(Activity activity, com.opos.cmn.e.a.b.d.a aVar) {
        super(activity, aVar);
        this.f11086a = activity;
        this.b = aVar;
        this.f11087c = (aVar == null || aVar.f11082a == 0) ? new com.opos.cmn.e.a.b.f.a(activity, aVar) : new com.opos.cmn.e.a.b.f.a(activity, aVar.f11082a, aVar);
        com.opos.cmn.e.a.d.a.a(activity, this.f11087c);
    }

    @Override // com.opos.cmn.e.a.b.e.c
    public void a(View view) {
        if (view != null) {
            this.f11087c.setContentView(view);
        }
    }

    @Override // com.opos.cmn.e.a.b.e.c
    public boolean a() {
        return this.f11087c.isShowing();
    }

    @Override // com.opos.cmn.e.a.b.e.c
    public void b() {
        this.f11087c.show();
    }

    @Override // com.opos.cmn.e.a.b.e.c
    public void c() {
        this.f11087c.dismiss();
    }
}
