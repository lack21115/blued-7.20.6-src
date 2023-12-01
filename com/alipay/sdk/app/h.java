package com.alipay.sdk.app;

import com.alipay.sdk.util.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/h.class */
public class h implements e.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PayTask f4598a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PayTask payTask) {
        this.f4598a = payTask;
    }

    @Override // com.alipay.sdk.util.e.a
    public void a() {
    }

    @Override // com.alipay.sdk.util.e.a
    public void b() {
        this.f4598a.dismissLoading();
    }
}
