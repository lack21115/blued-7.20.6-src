package com.efs.sdk.base.core.e.a;

import com.efs.sdk.base.core.b.a;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/e/a/b.class */
public final class b extends a {
    @Override // com.efs.sdk.base.core.e.a.a
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        com.efs.sdk.base.core.b.e a2;
        if (bVar.b.f8160a) {
            b(bVar);
            return;
        }
        com.efs.sdk.base.core.b.a a3 = a.b.a();
        if ("wa".equals(bVar.f8158a.f8156a) || com.efs.sdk.base.core.b.c.a().f8123a) {
            if ((bVar.f8158a.f8157c == 0 && (bVar.f8159c == null || bVar.f8159c.length == 0)) || (a2 = a3.f8120c.a(bVar.f8158a.b)) == null) {
                return;
            }
            a2.a(bVar);
            return;
        }
        if (!a3.f8119a) {
            com.efs.sdk.base.core.f.f a4 = f.a.a();
            int i = com.efs.sdk.base.core.config.a.c.a().d.f8143a;
            if (a4.b != null || ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                a4.b.send(a4.a("disk_limit", i));
            }
        }
        a3.f8119a = true;
    }
}
