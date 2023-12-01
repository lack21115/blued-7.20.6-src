package com.huawei.openalliance.ad.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/g.class */
public class g implements ThreadFactory {
    private final ThreadGroup Code;
    private final String I;
    private final AtomicInteger V;
    private final int Z;

    public g(String str) {
        this(str, 5);
    }

    public g(String str, int i) {
        this.V = new AtomicInteger(1);
        this.Z = i;
        this.Code = Thread.currentThread().getThreadGroup();
        this.I = str + "-pool-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.Code;
        Thread thread = new Thread(threadGroup, runnable, this.I + this.V.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int priority = thread.getPriority();
        int i = this.Z;
        if (priority != i) {
            thread.setPriority(i);
        }
        return thread;
    }
}
