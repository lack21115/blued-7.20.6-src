package com.opos.cmn.e.a.c.c;

import android.content.Context;
import android.view.View;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/c/c/f.class */
public class f extends b implements e {
    public f(Context context, com.opos.cmn.e.a.c.a aVar) {
        super(context, aVar);
        if (com.opos.cmn.e.a.d.a.a()) {
            this.f11099c = new com.opos.cmn.e.a.c.d.d(this.f11098a, this);
        }
    }

    @Override // com.opos.cmn.e.a.c.c.e
    public void a() {
        if (!com.opos.cmn.e.a.d.a.a() || this.f11099c == null) {
            return;
        }
        this.f11099c.a();
    }

    @Override // com.opos.cmn.e.a.c.c.e
    public void a(View view, String str, Object... objArr) {
        if (this.b != null) {
            this.b.a(view, str, objArr);
        }
    }

    @Override // com.opos.cmn.e.a.c.c.e
    public void a(View view, int[] iArr, String str, Object... objArr) {
        if (this.b != null) {
            this.b.a(view, iArr, str, objArr);
        }
    }

    @Override // com.opos.cmn.e.a.c.c.e
    public void a(String str, boolean z, Object... objArr) {
        if (!com.opos.cmn.e.a.d.a.a() || this.f11099c == null) {
            return;
        }
        this.f11099c.a(str, z, objArr);
    }

    @Override // com.opos.cmn.e.a.c.c.e
    public void b() {
        if (!com.opos.cmn.e.a.d.a.a() || this.f11099c == null) {
            return;
        }
        this.f11099c.b();
    }

    @Override // com.opos.cmn.e.a.c.c.e
    public void b(View view, int[] iArr, String str, Object... objArr) {
        if (this.b != null) {
            this.b.b(view, iArr, str, objArr);
        }
    }
}
