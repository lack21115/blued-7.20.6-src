package com.tencent.liteav.base.util;

import java.util.concurrent.CountDownLatch;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/k.class */
final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f22646a;
    private final CountDownLatch b;

    private k(Runnable runnable, CountDownLatch countDownLatch) {
        this.f22646a = runnable;
        this.b = countDownLatch;
    }

    public static Runnable a(Runnable runnable, CountDownLatch countDownLatch) {
        return new k(runnable, countDownLatch);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.f22646a;
        CountDownLatch countDownLatch = this.b;
        runnable.run();
        countDownLatch.countDown();
    }
}
