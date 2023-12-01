package com.zx.a.I8b7;

import java.lang.Thread;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/c3.class */
public class c3 {

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicInteger f42112c = new AtomicInteger(1);

    /* renamed from: a  reason: collision with root package name */
    public ScheduledThreadPoolExecutor f42113a = new ScheduledThreadPoolExecutor(2, new a(this));
    public ThreadPoolExecutor b = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new b(this));

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/c3$a.class */
    public class a implements ThreadFactory {

        /* renamed from: com.zx.a.I8b7.c3$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/c3$a$a.class */
        public class C1119a implements Thread.UncaughtExceptionHandler {
            public C1119a(a aVar) {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                StringBuilder a2 = m2.a("caught an exception from ");
                a2.append(thread.getName());
                z1.a(a2.toString(), th);
            }
        }

        public a(c3 c3Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            StringBuilder a2 = m2.a("ZX-Thread-");
            a2.append(c3.f42112c.getAndIncrement());
            thread.setName(a2.toString());
            thread.setUncaughtExceptionHandler(new C1119a(this));
            return thread;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/c3$b.class */
    public class b implements ThreadFactory {

        /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/c3$b$a.class */
        public class a implements Thread.UncaughtExceptionHandler {
            public a(b bVar) {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                StringBuilder a2 = m2.a("caught an exception from ");
                a2.append(thread.getName());
                z1.a(a2.toString(), th);
            }
        }

        public b(c3 c3Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("ZX-Api-Thread");
            thread.setUncaughtExceptionHandler(new a(this));
            return thread;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/c3$c.class */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final c3 f42114a = new c3();
    }
}
