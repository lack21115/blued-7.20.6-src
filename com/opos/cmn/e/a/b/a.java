package com.opos.cmn.e.a.b;

import android.app.Activity;
import com.opos.cmn.e.a.b.b.c;
import com.opos.cmn.e.a.b.d.a;
import com.opos.cmn.e.a.b.e.b;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private c f24756a;
    private com.opos.cmn.e.a.b.e.c b;

    public a(Activity activity) {
        this.f24756a = new c(activity);
        b bVar = new b(activity, new a.C0634a().a(com.opos.cmn.an.h.f.a.a(activity) ? 16973841 : 16973840).a(false).b(false).a());
        this.b = bVar;
        bVar.a(this.f24756a.b());
    }

    public void a() {
        if (this.b.a()) {
            this.b.c();
        }
    }

    public void a(String str, String str2, String str3, com.opos.cmn.e.a.b.c.a aVar) {
        this.f24756a.a((CharSequence) str);
        this.f24756a.b(str2);
        this.f24756a.a(str3);
        this.f24756a.a(aVar);
        this.b.b();
    }
}
