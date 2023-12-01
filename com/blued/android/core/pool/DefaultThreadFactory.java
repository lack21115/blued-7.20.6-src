package com.blued.android.core.pool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/pool/DefaultThreadFactory.class */
public class DefaultThreadFactory implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f9706a = new AtomicInteger(1);
    private final ThreadGroup b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f9707c;
    private final String d;

    public DefaultThreadFactory() {
        this("default");
    }

    public DefaultThreadFactory(String str) {
        this.f9707c = new AtomicInteger(1);
        SecurityManager securityManager = System.getSecurityManager();
        this.b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.d = "blued-" + f9706a.getAndIncrement() + "-" + str + "-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.b;
        Thread thread = new Thread(threadGroup, runnable, this.d + this.f9707c.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
