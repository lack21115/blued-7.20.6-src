package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bg.class */
public class bg implements z.a {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ bf f9338c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bf bfVar) {
        this.f9338c = bfVar;
    }

    @Override // com.baidu.mobads.sdk.internal.z.a
    public void onFailure() {
        this.f9338c.i.a(bf.b, "AbstractProdTemplate,load-dex请求，回调失败");
        this.f9338c.j();
    }

    @Override // com.baidu.mobads.sdk.internal.z.a
    public void onSuccess() {
        this.f9338c.i.a(bf.b, "AbstractProdTemplate,load-dex请求，回调成功");
        this.f9338c.i();
    }
}
