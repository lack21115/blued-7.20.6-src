package com.alipay.sdk.widget;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/k.class */
class k implements Runnable {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a.finish();
    }
}
