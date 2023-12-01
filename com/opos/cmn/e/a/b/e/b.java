package com.opos.cmn.e.a.b.e;

import android.app.Activity;
import android.view.View;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/b/e/b.class */
public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    private com.opos.cmn.e.a.b.f.a f24775c;

    public b(Activity activity, com.opos.cmn.e.a.b.d.a aVar) {
        super(activity, aVar);
        this.f24774a = activity;
        this.b = aVar;
        this.f24775c = (aVar == null || aVar.f24770a == 0) ? new com.opos.cmn.e.a.b.f.a(activity, aVar) : new com.opos.cmn.e.a.b.f.a(activity, aVar.f24770a, aVar);
        com.opos.cmn.e.a.d.a.a(activity, this.f24775c);
    }

    @Override // com.opos.cmn.e.a.b.e.c
    public void a(View view) {
        if (view != null) {
            this.f24775c.setContentView(view);
        }
    }

    @Override // com.opos.cmn.e.a.b.e.c
    public boolean a() {
        return this.f24775c.isShowing();
    }

    @Override // com.opos.cmn.e.a.b.e.c
    public void b() {
        this.f24775c.show();
    }

    @Override // com.opos.cmn.e.a.b.e.c
    public void c() {
        this.f24775c.dismiss();
    }
}
