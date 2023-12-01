package com.efs.sdk.base.core.c;

import com.efs.sdk.base.http.HttpResponse;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/c/e.class */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private com.efs.sdk.base.core.d.b f8134a;
    private c b;

    /* renamed from: c  reason: collision with root package name */
    private String f8135c;

    public e(com.efs.sdk.base.core.d.b bVar, c cVar, String str) {
        this.f8134a = bVar;
        this.b = cVar;
        this.f8135c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar;
        com.efs.sdk.base.core.d.b bVar = this.f8134a;
        HttpResponse httpResponse = (bVar == null || (cVar = this.b) == null) ? new HttpResponse() : cVar.a(bVar, true);
        d.a().a(this.f8135c, httpResponse.succ ? 0 : httpResponse.getHttpCode());
        this.f8135c = null;
        this.b = null;
    }
}
