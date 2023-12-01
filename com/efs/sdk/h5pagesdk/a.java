package com.efs.sdk.h5pagesdk;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/h5pagesdk/a.class */
public class a {
    private static volatile ScheduledThreadPoolExecutor i;
    private static final String TAG = a.class.getName();
    private static ThreadFactory j = new ThreadFactory() { // from class: com.efs.sdk.h5pagesdk.a.1
        private AtomicInteger k = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("H5ThreadPoolExecutor" + this.k.addAndGet(1));
            return thread;
        }
    };

    private static ScheduledThreadPoolExecutor a() {
        if (i == null) {
            synchronized (a.class) {
                try {
                    if (i == null) {
                        i = new ScheduledThreadPoolExecutor(4, j);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return i;
    }

    public static void execute(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
