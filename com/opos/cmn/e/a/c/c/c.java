package com.opos.cmn.e.a.c.c;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/c/c/c.class */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    private com.opos.cmn.e.a.c.d.b f24788c;

    public c(Context context, com.opos.cmn.e.a.c.b.a aVar) {
        super(context, aVar);
        this.f24788c = new com.opos.cmn.e.a.c.d.b(this.f24785a, aVar);
    }

    @Override // com.opos.cmn.e.a.c.c.d
    public WindowManager.LayoutParams a() {
        return this.f24788c.a();
    }

    @Override // com.opos.cmn.e.a.c.c.d
    public void a(int i) {
        this.f24788c.a(i);
    }

    @Override // com.opos.cmn.e.a.c.c.d
    public void a(int i, int i2, int i3) {
        this.f24788c.a(i, i2, i3);
    }

    @Override // com.opos.cmn.e.a.c.c.d
    public void a(View view) {
        this.f24788c.a(view);
    }

    @Override // com.opos.cmn.e.a.c.c.d
    public void b() {
        this.f24788c.b();
    }

    @Override // com.opos.cmn.e.a.c.c.d
    public void c() {
        this.f24788c.c();
    }
}
