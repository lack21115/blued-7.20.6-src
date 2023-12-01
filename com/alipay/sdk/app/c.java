package com.alipay.sdk.app;

import android.app.Activity;
import android.webkit.SslErrorHandler;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/c.class */
class c implements Runnable {
    final /* synthetic */ Activity a;
    final /* synthetic */ SslErrorHandler b;
    final /* synthetic */ b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Activity activity, SslErrorHandler sslErrorHandler) {
        this.c = bVar;
        this.a = activity;
        this.b = sslErrorHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.alipay.sdk.widget.e.a(this.a, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，请安装支付宝后重试。", "确定", new d(this), null, null);
    }
}
