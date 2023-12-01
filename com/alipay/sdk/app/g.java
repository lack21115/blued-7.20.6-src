package com.alipay.sdk.app;

import android.app.Activity;
import com.alipay.sdk.util.H5PayResultModel;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/g.class */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4596a;
    final /* synthetic */ boolean b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ H5PayCallback f4597c;
    final /* synthetic */ PayTask d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PayTask payTask, String str, boolean z, H5PayCallback h5PayCallback) {
        this.d = payTask;
        this.f4596a = str;
        this.b = z;
        this.f4597c = h5PayCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity;
        activity = this.d.b;
        H5PayResultModel h5Pay = this.d.h5Pay(new com.alipay.sdk.sys.a(activity, this.f4596a, "payInterceptorWithUrl"), this.f4596a, this.b);
        com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "inc finished: " + h5Pay.getResultCode());
        this.f4597c.onPayResult(h5Pay);
    }
}
