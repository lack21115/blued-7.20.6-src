package com.baidu.mobads.sdk.internal;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/ba.class */
public class ba {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6489a = "TaskScheduler";
    private static volatile ba d;
    private ThreadPoolExecutor b;

    /* renamed from: c  reason: collision with root package name */
    private ScheduledThreadPoolExecutor f6490c;

    private ba() {
        b();
    }

    public static ba a() {
        if (d == null) {
            synchronized (ba.class) {
                try {
                    if (d == null) {
                        d = new ba();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    private void b() {
        this.b = bb.a(1, 1);
        this.f6490c = bb.a(1);
    }

    public void a(h hVar) {
        ThreadPoolExecutor threadPoolExecutor;
        if (hVar == null || (threadPoolExecutor = this.b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            hVar.a(System.currentTimeMillis());
            FutureTask futureTask = null;
            if (this.b != null) {
                futureTask = null;
                if (!this.b.isShutdown()) {
                    futureTask = (FutureTask) this.b.submit(hVar);
                }
            }
            hVar.a((Future) futureTask);
        } catch (Throwable th) {
        }
    }

    public void a(h hVar, long j, long j2, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (hVar == null || (scheduledThreadPoolExecutor = this.f6490c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            hVar.a(System.currentTimeMillis());
            hVar.a((Future) this.f6490c.scheduleAtFixedRate(hVar, j, j2, timeUnit));
        } catch (Throwable th) {
        }
    }

    public void a(h hVar, long j, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (hVar == null || (scheduledThreadPoolExecutor = this.f6490c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            hVar.a(System.currentTimeMillis());
            hVar.a((Future) this.f6490c.schedule(hVar, j, timeUnit));
        } catch (Throwable th) {
        }
    }

    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        if (runnable == null || (threadPoolExecutor = this.b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            this.b.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
