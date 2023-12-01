package com.huawei.hms.ads.dynamic;

import com.huawei.hms.ads.uiengineloader.aa;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamic/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22461a = "ExecutorsManager";
    private static final long b = 60;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamic/b$a.class */
    static final class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f22462a = new AtomicInteger(1);
        private final String b;

        a(String str) {
            this.b = str + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.b + this.f22462a.getAndIncrement());
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.huawei.hms.ads.dynamic.b.a.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public final void uncaughtException(Thread thread2, Throwable th) {
                    aa.d(b.f22461a, thread2.getName() + " : " + th.getMessage());
                }
            });
            return thread;
        }
    }

    public static ExecutorService a(String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, (long) b, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(str));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
