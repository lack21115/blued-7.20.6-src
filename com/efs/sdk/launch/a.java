package com.efs.sdk.launch;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/launch/a.class */
public class a {
    private static volatile ScheduledThreadPoolExecutor b;

    /* renamed from: a  reason: collision with root package name */
    private static final String f21807a = a.class.getName();

    /* renamed from: c  reason: collision with root package name */
    private static ThreadFactory f21808c = new ThreadFactory() { // from class: com.efs.sdk.launch.a.1

        /* renamed from: a  reason: collision with root package name */
        private AtomicInteger f21809a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("LaunchThreadPoolExecutor" + this.f21809a.addAndGet(1));
            return thread;
        }
    };

    private static ScheduledThreadPoolExecutor a() {
        if (b == null) {
            synchronized (a.class) {
                try {
                    if (b == null) {
                        b = new ScheduledThreadPoolExecutor(4, f21808c);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public static void a(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
