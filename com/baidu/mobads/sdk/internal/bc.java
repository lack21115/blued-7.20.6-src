package com.baidu.mobads.sdk.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bc.class */
public final class bc implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f6493a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "TaskScheduler #" + this.f6493a.getAndIncrement());
        thread.setUncaughtExceptionHandler(new bd(this));
        return thread;
    }
}
