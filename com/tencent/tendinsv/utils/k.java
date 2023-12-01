package com.tencent.tendinsv.utils;

import com.tencent.tendinsv.listener.LoginAuthCallbacks;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/k.class */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static ScheduledExecutorService f39101a = new ScheduledThreadPoolExecutor(1);

    public static void a() {
        synchronized (k.class) {
            try {
                if (f39101a != null) {
                    f39101a.shutdownNow();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(final String str, final long j, final LoginAuthCallbacks loginAuthCallbacks, final long j2, final long j3, final long j4) {
        ScheduledExecutorService scheduledExecutorService = f39101a;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            f39101a = new ScheduledThreadPoolExecutor(1);
        }
        f39101a.schedule(new Runnable() { // from class: com.tencent.tendinsv.utils.k.1
            @Override // java.lang.Runnable
            public void run() {
                LoginAuthCallbacks loginAuthCallbacks2 = LoginAuthCallbacks.this;
                loginAuthCallbacks2.getTokenFailed(1023, 1023, "请求超过" + (j / 1000) + "秒", "超时", str, j2, j3, j4);
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    public void a(long j, long j2, Runnable runnable) {
        f39101a.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS);
    }

    public void b(long j, long j2, Runnable runnable) {
        f39101a.scheduleWithFixedDelay(runnable, j, j2, TimeUnit.MILLISECONDS);
    }
}
