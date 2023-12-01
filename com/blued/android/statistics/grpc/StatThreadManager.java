package com.blued.android.statistics.grpc;

import android.os.Build;
import com.blued.android.statistics.StatConfig;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/grpc/StatThreadManager.class */
public class StatThreadManager {
    private static final Long a = 10L;
    private static ThreadPoolExecutor b = null;
    private static ExecutorService c = null;

    public static void a() {
        int i;
        int i2;
        if (b != null) {
            return;
        }
        if (Runtime.getRuntime().availableProcessors() > 4) {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            i2 = Runtime.getRuntime().availableProcessors();
            i = availableProcessors >> 1;
        } else if (Build.VERSION.SDK_INT >= 26) {
            i = 4;
            i2 = 8;
        } else {
            i = 2;
            i2 = 4;
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, a.longValue(), TimeUnit.SECONDS, new LinkedBlockingQueue(30), Executors.defaultThreadFactory(), new RejectedExecutionHandler() { // from class: com.blued.android.statistics.grpc.StatThreadManager.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                if (StatConfig.c()) {
                    StatConfig.b().b("rejectedExecution:", runnable);
                }
            }
        });
        b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        if (runnable == null || (threadPoolExecutor = b) == null) {
            return;
        }
        try {
            threadPoolExecutor.execute(runnable);
        } catch (OutOfMemoryError e) {
        }
    }

    public static ExecutorService b() {
        if (c == null) {
            synchronized (ExecutorService.class) {
                try {
                    if (c == null) {
                        c = Executors.newSingleThreadExecutor();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }
}
