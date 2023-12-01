package com.anythink.basead.d.c;

import android.text.TextUtils;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.ab;
import com.anythink.core.common.e.g;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/c/a.class */
public final class a {
    private static void a(ab abVar, com.anythink.basead.d.c cVar) {
        if (abVar == null || cVar == null) {
            return;
        }
        abVar.v(cVar.a());
        abVar.w(cVar.b());
        abVar.a(cVar.d());
        abVar.p(cVar.c());
        abVar.o(cVar.e());
        abVar.b(cVar.f());
        abVar.n(cVar.g());
        abVar.a(cVar.h());
        abVar.b(cVar.i());
        abVar.b(cVar.j());
    }

    public static void a(j jVar, aa aaVar) {
        k kVar;
        if (jVar == null || aaVar == null || (kVar = jVar.m) == null || !(jVar.m instanceof ab)) {
            return;
        }
        k k = aaVar.k();
        if (k != null) {
            k.v(kVar.y());
            k.w(kVar.z());
            k.p(kVar.s());
            k.a(kVar.r());
            k.q(kVar.t());
            k.o(kVar.q());
            k.b(kVar.n());
            k.n(kVar.p());
            k.b(kVar.b());
            k.a(kVar.a());
            k.b(kVar.E());
            jVar.m = k;
        } else {
            aaVar.a(jVar.m);
        }
        if ((!(aaVar instanceof g) || TextUtils.isEmpty(((g) aaVar).a())) && TextUtils.isEmpty(aaVar.A())) {
            jVar.m.r(0);
            jVar.m.t(0);
            jVar.m.H(2);
            jVar.m.h(2);
            jVar.m.A(1);
            jVar.m.s(-2);
        }
    }
}
