package com.efs.sdk.base.core.e.a;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/e/a/f.class */
public final class f extends a {
    @Override // com.efs.sdk.base.core.e.a.a
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        Double d;
        com.efs.sdk.base.core.config.a.c a2 = com.efs.sdk.base.core.config.a.c.a();
        String str = bVar.f21764a.f21762a;
        com.efs.sdk.base.core.config.a.b bVar2 = a2.d;
        if (com.efs.sdk.base.core.config.a.c.f21751a.nextDouble() * 100.0d <= ((!bVar2.e.containsKey(str) || (d = bVar2.e.get(str)) == null) ? 100.0d : d.doubleValue())) {
            b(bVar);
        }
    }
}
