package com.bytedance.sdk.openadsdk.ox;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/ox/mb.class */
public class mb {
    private static volatile mb ox;
    private volatile ThreadPoolExecutor mb = new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0157mb(), new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.ox.mb.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            com.bytedance.sdk.openadsdk.api.mb.hj("TTThreadManager", "TTThreadManager rejectedExecution:  ");
        }
    });

    /* renamed from: com.bytedance.sdk.openadsdk.ox.mb$mb  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/ox/mb$mb.class */
    public static class ThreadFactoryC0157mb implements ThreadFactory {
        private final String b;
        private final ThreadGroup mb;
        private final AtomicInteger ox;

        ThreadFactoryC0157mb() {
            this("csj_g_pl_mgr");
        }

        ThreadFactoryC0157mb(String str) {
            this.ox = new AtomicInteger(1);
            this.mb = new ThreadGroup("csj_g_pl_mgr");
            this.b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.mb;
            Thread thread = new Thread(threadGroup, runnable, this.b + this.ox.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    public mb() {
        this.mb.allowCoreThreadTimeOut(true);
    }

    public static mb mb() {
        if (ox == null) {
            synchronized (mb.class) {
                try {
                    ox = new mb();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return ox;
    }

    public void mb(Runnable runnable) {
        if (runnable != null) {
            try {
                this.mb.execute(runnable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
