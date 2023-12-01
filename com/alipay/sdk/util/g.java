package com.alipay.sdk.util;

import com.alipay.sdk.app.AlipayResultActivity;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/util/g.class */
public class g implements AlipayResultActivity.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CountDownLatch f4664a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, CountDownLatch countDownLatch) {
        this.b = eVar;
        this.f4664a = countDownLatch;
    }

    @Override // com.alipay.sdk.app.AlipayResultActivity.a
    public void a(int i, String str, String str2) {
        this.b.j = com.alipay.sdk.app.j.a(i, str, str2);
        this.f4664a.countDown();
    }
}
