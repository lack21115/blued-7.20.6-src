package com.tencent.liteav.base.util;

import java.util.concurrent.CountDownLatch;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/k.class */
final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f36337a;
    private final CountDownLatch b;

    private k(Runnable runnable, CountDownLatch countDownLatch) {
        this.f36337a = runnable;
        this.b = countDownLatch;
    }

    public static Runnable a(Runnable runnable, CountDownLatch countDownLatch) {
        return new k(runnable, countDownLatch);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.f36337a;
        CountDownLatch countDownLatch = this.b;
        runnable.run();
        countDownLatch.countDown();
    }
}
