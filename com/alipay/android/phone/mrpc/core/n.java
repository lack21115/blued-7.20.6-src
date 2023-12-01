package com.alipay.android.phone.mrpc.core;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/android/phone/mrpc/core/n.class */
final class n implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f4532a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "com.alipay.mobile.common.transport.http.HttpManager.HttpWorker #" + this.f4532a.getAndIncrement());
        thread.setPriority(4);
        return thread;
    }
}
