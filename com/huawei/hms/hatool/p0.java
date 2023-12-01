package com.huawei.hms.hatool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/p0.class */
public class p0 {
    public static p0 b;

    /* renamed from: c  reason: collision with root package name */
    public static p0 f22781c;
    public static p0 d;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f22782a = new ThreadPoolExecutor(0, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new b());

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/p0$a.class */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public Runnable f22783a;

        public a(Runnable runnable) {
            this.f22783a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f22783a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception e) {
                    z.e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/p0$b.class */
    public static class b implements ThreadFactory {
        public static final AtomicInteger d = new AtomicInteger(1);

        /* renamed from: a  reason: collision with root package name */
        public final ThreadGroup f22784a;
        public final AtomicInteger b = new AtomicInteger(1);

        /* renamed from: c  reason: collision with root package name */
        public final String f22785c;

        public b() {
            SecurityManager securityManager = System.getSecurityManager();
            this.f22784a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f22785c = "FormalHASDK-base-" + d.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.f22784a;
            return new Thread(threadGroup, runnable, this.f22785c + this.b.getAndIncrement(), 0L);
        }
    }

    static {
        new p0();
        new p0();
        b = new p0();
        f22781c = new p0();
        d = new p0();
    }

    public static p0 a() {
        return d;
    }

    public static p0 b() {
        return f22781c;
    }

    public static p0 c() {
        return b;
    }

    public void a(o0 o0Var) {
        try {
            this.f22782a.execute(new a(o0Var));
        } catch (RejectedExecutionException e) {
            z.e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
