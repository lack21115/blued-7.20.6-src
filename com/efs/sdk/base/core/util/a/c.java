package com.efs.sdk.base.core.util.a;

import com.efs.sdk.base.http.HttpResponse;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/util/a/c.class */
public final class c extends com.efs.sdk.base.core.util.concurrent.d<HttpResponse> {

    /* renamed from: a  reason: collision with root package name */
    public b f21790a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        super(bVar);
        this.f21790a = bVar;
    }

    public final HttpResponse b() {
        this.f21790a.e = "post";
        return a();
    }
}
