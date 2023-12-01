package com.blued.android.framework.pool;

import android.os.Build;
import android.util.Log;
import com.blued.android.core.AppInfo;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/pool/ThreadManager.class */
public class ThreadManager {
    private static ThreadManager a;
    private static final Long b = 10L;
    private ThreadPoolExecutor c;
    private ExecutorService d;
    private ExecutorService e;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/pool/ThreadManager$DefaultThreadFactory.class */
    static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger a = new AtomicInteger(1);
        private final ThreadGroup b;
        private final AtomicInteger c = new AtomicInteger(1);
        private final String d;

        DefaultThreadFactory() {
            SecurityManager securityManager = System.getSecurityManager();
            this.b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.d = "blued-" + a.getAndIncrement() + "-pool-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.b;
            Thread thread = new Thread(threadGroup, runnable, this.d + this.c.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    private ThreadManager() {
        int i;
        int i2;
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
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, b.longValue(), TimeUnit.SECONDS, new PriorityBlockingQueue(20, new Comparator<Runnable>() { // from class: com.blued.android.framework.pool.ThreadManager.2
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(Runnable runnable, Runnable runnable2) {
                    int ordinal = runnable instanceof ThreadExecutor ? ((ThreadExecutor) runnable).getThreadPriority().ordinal() : ThreadPriority.NORMAL.ordinal();
                    int ordinal2 = runnable2 instanceof ThreadExecutor ? ((ThreadExecutor) runnable2).getThreadPriority().ordinal() : ThreadPriority.NORMAL.ordinal();
                    if (ordinal > ordinal2) {
                        return -1;
                    }
                    return ordinal == ordinal2 ? 0 : 1;
                }
            }), new DefaultThreadFactory(), new RejectedExecutionHandler() { // from class: com.blued.android.framework.pool.ThreadManager.1
                @Override // java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                    if (AppInfo.m()) {
                        Log.i("ThreadManager", "rejectedExecution: " + runnable.toString());
                    }
                }
            });
            this.c = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.d = new ThreadPoolExecutor(1, 2, b.longValue(), TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory());
        this.e = new ThreadPoolExecutor(1, 2, b.longValue(), TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory());
    }

    public static ThreadManager a() {
        if (a == null) {
            synchronized (ThreadManager.class) {
                try {
                    if (a == null) {
                        a = new ThreadManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public void a(ThreadExecutor threadExecutor) {
        ThreadPoolExecutor threadPoolExecutor;
        if (threadExecutor == null || (threadPoolExecutor = this.c) == null) {
            return;
        }
        threadPoolExecutor.execute(threadExecutor);
    }

    public void a(Runnable runnable) {
        ExecutorService executorService;
        if (runnable == null || (executorService = this.d) == null) {
            return;
        }
        executorService.execute(runnable);
    }

    public void b(Runnable runnable) {
        ExecutorService executorService;
        if (runnable == null || (executorService = this.e) == null) {
            return;
        }
        executorService.execute(runnable);
    }
}
