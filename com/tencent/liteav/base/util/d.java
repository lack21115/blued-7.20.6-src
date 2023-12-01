package com.tencent.liteav.base.util;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/d.class */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f36328a;
    private final CountDownLatch b;

    private d(Runnable runnable, CountDownLatch countDownLatch) {
        this.f36328a = runnable;
        this.b = countDownLatch;
    }

    public static Runnable a(Runnable runnable, CountDownLatch countDownLatch) {
        return new d(runnable, countDownLatch);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.a(this.f36328a, this.b);
    }
}
