package com.kuaishou.weapon.p0;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/n.class */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static volatile n f23845a;
    private static int b = 3;

    /* renamed from: c  reason: collision with root package name */
    private static int f23846c = 6;
    private static ThreadPoolExecutor d;

    private n() {
    }

    public static n a() {
        if (f23845a == null) {
            synchronized (n.class) {
                try {
                    if (f23845a == null) {
                        f23845a = new n();
                    }
                    if (d == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(b, f23846c, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), new RejectedExecutionHandler() { // from class: com.kuaishou.weapon.p0.n.1
                            @Override // java.util.concurrent.RejectedExecutionHandler
                            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                            }
                        });
                        d = threadPoolExecutor;
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f23845a;
    }

    public static n a(int i, int i2) {
        if (f23845a == null) {
            synchronized (n.class) {
                try {
                    if (f23845a == null) {
                        b = i;
                        f23846c = i2;
                        f23845a = new n();
                        if (d == null) {
                            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(b, f23846c, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), new RejectedExecutionHandler() { // from class: com.kuaishou.weapon.p0.n.2
                                @Override // java.util.concurrent.RejectedExecutionHandler
                                public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                                }
                            });
                            d = threadPoolExecutor;
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f23845a;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                d.execute(runnable);
            } catch (Exception e) {
            }
        }
    }
}
