package com.alipay.sdk.widget;

import android.webkit.SslErrorHandler;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/n.class */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SslErrorHandler f4693a;
    final /* synthetic */ j b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar, SslErrorHandler sslErrorHandler) {
        this.b = jVar;
        this.f4693a = sslErrorHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        e.a(this.b.f4685a, "安全警告", "安全連接證書校驗無效，將無法保證訪問資料的安全性，請安裝支付寶 Alipay 後重試。", "確定", new o(this), null, null);
    }
}
