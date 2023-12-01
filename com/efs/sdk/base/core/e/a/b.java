package com.efs.sdk.base.core.e.a;

import com.efs.sdk.base.core.b.a;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/e/a/b.class */
public final class b extends a {
    @Override // com.efs.sdk.base.core.e.a.a
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        com.efs.sdk.base.core.b.e a2;
        if (bVar.b.f21766a) {
            b(bVar);
            return;
        }
        com.efs.sdk.base.core.b.a a3 = a.b.a();
        if ("wa".equals(bVar.f21764a.f21762a) || com.efs.sdk.base.core.b.c.a().f21729a) {
            if ((bVar.f21764a.f21763c == 0 && (bVar.f21765c == null || bVar.f21765c.length == 0)) || (a2 = a3.f21726c.a(bVar.f21764a.b)) == null) {
                return;
            }
            a2.a(bVar);
            return;
        }
        if (!a3.f21725a) {
            com.efs.sdk.base.core.f.f a4 = f.a.a();
            int i = com.efs.sdk.base.core.config.a.c.a().d.f21749a;
            if (a4.b != null || ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                a4.b.send(a4.a("disk_limit", i));
            }
        }
        a3.f21725a = true;
    }
}
