package com.tencent.liteav.videobase.a;

import java.util.concurrent.CountDownLatch;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/a/g.class */
final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f36581a;
    private final CountDownLatch b;

    private g(Runnable runnable, CountDownLatch countDownLatch) {
        this.f36581a = runnable;
        this.b = countDownLatch;
    }

    public static Runnable a(Runnable runnable, CountDownLatch countDownLatch) {
        return new g(runnable, countDownLatch);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.lambda$runOnDrawAndWaitDone$4(this.f36581a, this.b);
    }
}
