package com.efs.sdk.base.core.e.a;

import com.efs.sdk.base.core.util.Log;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/e/a/c.class */
public final class c extends a {
    private static boolean c(com.efs.sdk.base.core.d.b bVar) {
        if (bVar.b()) {
            return true;
        }
        return (1 == bVar.f21764a.b && !bVar.b.f21766a) || 1 == bVar.f21764a.f21763c;
    }

    @Override // com.efs.sdk.base.core.e.a.a
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        if (c(bVar)) {
            b(bVar);
            return;
        }
        byte[] a2 = com.efs.sdk.base.core.util.c.a(bVar.f21765c);
        if (a2 == null) {
            Log.w("efs.base", "gzip error");
            b(bVar);
            return;
        }
        bVar.a(a2);
        bVar.a("gzip");
        b(bVar);
    }
}
