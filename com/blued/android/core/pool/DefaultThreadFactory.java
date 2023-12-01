package com.blued.android.core.pool;

import com.android.internal.content.NativeLibraryHelper;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/pool/DefaultThreadFactory.class */
public class DefaultThreadFactory implements ThreadFactory {
    private static final AtomicInteger a = new AtomicInteger(1);
    private final ThreadGroup b;
    private final AtomicInteger c;
    private final String d;

    public DefaultThreadFactory() {
        this("default");
    }

    public DefaultThreadFactory(String str) {
        this.c = new AtomicInteger(1);
        SecurityManager securityManager = System.getSecurityManager();
        this.b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.d = "blued-" + a.getAndIncrement() + NativeLibraryHelper.CLEAR_ABI_OVERRIDE + str + NativeLibraryHelper.CLEAR_ABI_OVERRIDE;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.b;
        Thread thread = new Thread(threadGroup, runnable, this.d + this.c.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
