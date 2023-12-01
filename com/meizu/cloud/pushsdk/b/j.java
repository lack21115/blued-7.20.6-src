package com.meizu.cloud.pushsdk.b;

import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/j.class */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private String f23993a = null;
    private Boolean b = null;

    /* renamed from: c  reason: collision with root package name */
    private Integer f23994c = null;
    private Thread.UncaughtExceptionHandler d = null;
    private ThreadFactory e = null;

    private static ThreadFactory a(j jVar) {
        final String str = jVar.f23993a;
        final Boolean bool = jVar.b;
        final Integer num = jVar.f23994c;
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = jVar.d;
        ThreadFactory threadFactory = jVar.e;
        if (threadFactory == null) {
            threadFactory = Executors.defaultThreadFactory();
        }
        final ThreadFactory threadFactory2 = threadFactory;
        final AtomicLong atomicLong = str != null ? new AtomicLong(0L) : null;
        return new ThreadFactory() { // from class: com.meizu.cloud.pushsdk.b.j.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = ThreadFactory.this.newThread(runnable);
                String str2 = str;
                if (str2 != null) {
                    newThread.setName(String.format(str2, Long.valueOf(atomicLong.getAndIncrement())));
                }
                Boolean bool2 = bool;
                if (bool2 != null) {
                    newThread.setDaemon(bool2.booleanValue());
                }
                Integer num2 = num;
                if (num2 != null) {
                    newThread.setPriority(num2.intValue());
                }
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = uncaughtExceptionHandler;
                if (uncaughtExceptionHandler2 != null) {
                    newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler2);
                }
                return newThread;
            }
        };
    }

    public j a(String str) {
        String.format(str, 0);
        this.f23993a = str;
        return this;
    }

    public ThreadFactory a() {
        return a(this);
    }
}
