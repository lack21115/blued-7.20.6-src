package com.efs.sdk.base.core.e.a;

import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.http.HttpResponse;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/e/a/e.class */
public final class e extends a {
    @Override // com.efs.sdk.base.core.e.a.a
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        HttpResponse a2;
        if (!bVar.b.f21766a) {
            b(bVar);
            return;
        }
        com.efs.sdk.base.core.c.d a3 = com.efs.sdk.base.core.c.d.a();
        if (!bVar.b.b || com.efs.sdk.base.core.c.b.a().a(bVar.f21764a.f21762a, bVar.a())) {
            f.a.a().f21780c.b();
            f.a.a().f21780c.c();
            a2 = a3.b.a(bVar, false);
        } else {
            a2 = new HttpResponse();
            a2.data = "flow_limit";
        }
        bVar.b.f21767c = a2;
        b(bVar);
    }
}
