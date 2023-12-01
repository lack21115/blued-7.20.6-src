package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ar.class */
public class ar {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40630a = "UMExecutor";
    private static volatile ScheduledThreadPoolExecutor b;

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadFactory f40631c = new ThreadFactory() { // from class: com.umeng.analytics.pro.ar.1

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f40632a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ccg-" + this.f40632a.incrementAndGet());
        }
    };

    private static ScheduledThreadPoolExecutor a() {
        if (b == null) {
            synchronized (ar.class) {
                try {
                    if (b == null) {
                        b = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f40631c);
                        b.setKeepAliveTime(3L, TimeUnit.SECONDS);
                        b.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public static void a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            a().schedule(runnable, j, timeUnit);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "schedule error:" + th.getMessage());
        }
    }
}
