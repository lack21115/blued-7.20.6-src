package com.efs.sdk.base.core.e.a;

import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.http.HttpResponse;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/e/a/e.class */
public final class e extends a {
    @Override // com.efs.sdk.base.core.e.a.a
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        HttpResponse a2;
        if (!bVar.b.f8160a) {
            b(bVar);
            return;
        }
        com.efs.sdk.base.core.c.d a3 = com.efs.sdk.base.core.c.d.a();
        if (!bVar.b.b || com.efs.sdk.base.core.c.b.a().a(bVar.f8158a.f8156a, bVar.a())) {
            f.a.a().f8174c.b();
            f.a.a().f8174c.c();
            a2 = a3.b.a(bVar, false);
        } else {
            a2 = new HttpResponse();
            a2.data = "flow_limit";
        }
        bVar.b.f8161c = a2;
        b(bVar);
    }
}
