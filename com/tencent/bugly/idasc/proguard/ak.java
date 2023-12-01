package com.tencent.bugly.idasc.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ak.class */
public final class ak {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f21544a = new AtomicInteger(1);
    private static ak b;

    /* renamed from: c  reason: collision with root package name */
    private ScheduledExecutorService f21545c;

    protected ak() {
        this.f21545c = null;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3, new ThreadFactory() { // from class: com.tencent.bugly.idasc.proguard.ak.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("BuglyThread-" + ak.f21544a.getAndIncrement());
                return thread;
            }
        });
        this.f21545c = newScheduledThreadPool;
        if (newScheduledThreadPool == null || newScheduledThreadPool.isShutdown()) {
            al.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static ak a() {
        ak akVar;
        synchronized (ak.class) {
            try {
                if (b == null) {
                    b = new ak();
                }
                akVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return akVar;
    }

    public final boolean a(Runnable runnable) {
        synchronized (this) {
            if (!c()) {
                al.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
                return false;
            } else if (runnable == null) {
                al.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
                return false;
            } else {
                al.c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
                this.f21545c.execute(runnable);
                return true;
            }
        }
    }

    public final boolean a(Runnable runnable, long j) {
        synchronized (this) {
            if (!c()) {
                al.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
                return false;
            }
            if (j <= 0) {
                j = 0;
            }
            al.c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j), runnable.getClass().getName());
            this.f21545c.schedule(runnable, j, TimeUnit.MILLISECONDS);
            return true;
        }
    }

    public final void b() {
        synchronized (this) {
            if (this.f21545c != null && !this.f21545c.isShutdown()) {
                al.c("[AsyncTaskHandler] Close async handler.", new Object[0]);
                this.f21545c.shutdownNow();
            }
        }
    }

    public final boolean c() {
        boolean z;
        synchronized (this) {
            if (this.f21545c != null) {
                if (!this.f21545c.isShutdown()) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }
}
