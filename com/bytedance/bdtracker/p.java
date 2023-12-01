package com.bytedance.bdtracker;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/p.class */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f7673a;
    public static final int b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f7674c;
    public static final int d;
    public static final int e;
    public static final BlockingQueue<Runnable> f;
    public static final a g;
    public static final RejectedExecutionHandler h;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/p$a.class */
    public static class a implements ThreadFactory {
        public static final AtomicInteger d = new AtomicInteger(1);

        /* renamed from: a  reason: collision with root package name */
        public final ThreadGroup f7675a;
        public final AtomicInteger b = new AtomicInteger(1);

        /* renamed from: c  reason: collision with root package name */
        public final String f7676c;

        public a(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.f7675a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f7676c = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + d.getAndIncrement() + "-Thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.f7675a;
            Thread thread = new Thread(threadGroup, runnable, this.f7676c + this.b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        b = availableProcessors;
        if (availableProcessors <= 0) {
            availableProcessors = 1;
        }
        f7674c = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 6)) * 2;
        d = max;
        e = (max * 2) + 1;
        f = new LinkedBlockingQueue();
        g = new a("TTDefaultExecutors");
        h = new RejectedExecutionHandler() { // from class: com.bytedance.bdtracker.-$$Lambda$JNmFrY1MpLFTtw_LmcvVL6C80TQ
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                Executors.newCachedThreadPool().execute(runnable);
            }
        };
        q qVar = new q(d, e, 30L, TimeUnit.SECONDS, f, g, h);
        f7673a = qVar;
        qVar.allowCoreThreadTimeOut(true);
    }
}
