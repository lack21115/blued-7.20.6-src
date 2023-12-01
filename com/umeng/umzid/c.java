package com.umeng.umzid;

import android.util.Log;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/umzid/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile ScheduledThreadPoolExecutor f27288a;
    public static ThreadFactory b = new a();

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/umzid/c$a.class */
    public static final class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public AtomicInteger f27289a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("ZIDThreadPoolExecutor" + this.f27289a.addAndGet(1));
            return thread;
        }
    }

    public static ScheduledThreadPoolExecutor a() {
        if (f27288a == null) {
            synchronized (c.class) {
                try {
                    if (f27288a == null) {
                        f27288a = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4, b);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27288a;
    }

    public static void a(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable th) {
            Log.e("com.umeng.umzid.c", "UmengThreadPoolExecutorFactory execute exception");
        }
    }
}
