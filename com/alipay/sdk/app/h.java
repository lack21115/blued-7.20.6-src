package com.alipay.sdk.app;

import com.alipay.sdk.util.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/h.class */
public class h implements e.a {
    final /* synthetic */ PayTask a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PayTask payTask) {
        this.a = payTask;
    }

    @Override // com.alipay.sdk.util.e.a
    public void a() {
    }

    @Override // com.alipay.sdk.util.e.a
    public void b() {
        this.a.dismissLoading();
    }
}
