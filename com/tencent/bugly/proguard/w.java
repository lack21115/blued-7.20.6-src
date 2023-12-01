package com.tencent.bugly.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/w.class */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f35412a = new AtomicInteger(1);
    private static w b;

    /* renamed from: c  reason: collision with root package name */
    private ScheduledExecutorService f35413c;

    protected w() {
        this.f35413c = null;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3, new ThreadFactory(this) { // from class: com.tencent.bugly.proguard.w.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("BuglyThread-" + w.f35412a.getAndIncrement());
                return thread;
            }
        });
        this.f35413c = newScheduledThreadPool;
        if (newScheduledThreadPool == null || newScheduledThreadPool.isShutdown()) {
            x.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static w a() {
        w wVar;
        synchronized (w.class) {
            try {
                if (b == null) {
                    b = new w();
                }
                wVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return wVar;
    }

    public final boolean a(Runnable runnable) {
        synchronized (this) {
            if (!c()) {
                x.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
                return false;
            } else if (runnable == null) {
                x.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
                return false;
            } else {
                x.c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
                this.f35413c.execute(runnable);
                return true;
            }
        }
    }

    public final boolean a(Runnable runnable, long j) {
        synchronized (this) {
            if (!c()) {
                x.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
                return false;
            } else if (runnable == null) {
                x.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
                return false;
            } else {
                if (j <= 0) {
                    j = 0;
                }
                x.c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j), runnable.getClass().getName());
                this.f35413c.schedule(runnable, j, TimeUnit.MILLISECONDS);
                return true;
            }
        }
    }

    public final void b() {
        synchronized (this) {
            if (this.f35413c != null && !this.f35413c.isShutdown()) {
                x.c("[AsyncTaskHandler] Close async handler.", new Object[0]);
                this.f35413c.shutdownNow();
            }
        }
    }

    public final boolean c() {
        boolean z;
        synchronized (this) {
            if (this.f35413c != null) {
                if (!this.f35413c.isShutdown()) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }
}
