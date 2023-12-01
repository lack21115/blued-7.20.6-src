package com.tencent.tendinsv.utils;

import com.tencent.tendinsv.listener.GetPhoneInfoCallbacks;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/o.class */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static ScheduledExecutorService f39109a = new ScheduledThreadPoolExecutor(1);

    public static void a() {
        synchronized (o.class) {
            try {
                if (f39109a != null) {
                    f39109a.shutdownNow();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(final String str, final long j, final int i, final GetPhoneInfoCallbacks getPhoneInfoCallbacks, final long j2, final long j3, final long j4) {
        ScheduledExecutorService scheduledExecutorService = f39109a;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            f39109a = new ScheduledThreadPoolExecutor(1);
        }
        f39109a.schedule(new Runnable() { // from class: com.tencent.tendinsv.utils.o.1
            @Override // java.lang.Runnable
            public void run() {
                GetPhoneInfoCallbacks getPhoneInfoCallbacks2 = GetPhoneInfoCallbacks.this;
                getPhoneInfoCallbacks2.getPhoneInfoFailed(1023, 1023, "请求超过" + (j / 1000) + "秒", "超时", i, str, j2, j3, j4);
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    public void a(long j, long j2, Runnable runnable) {
        f39109a.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS);
    }

    public void b(long j, long j2, Runnable runnable) {
        f39109a.scheduleWithFixedDelay(runnable, j, j2, TimeUnit.MILLISECONDS);
    }
}
