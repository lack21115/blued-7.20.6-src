package com.huawei.hmf.tasks.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hmf/tasks/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final int f22355a;
    static final int b;

    /* renamed from: c  reason: collision with root package name */
    private static final a f22356c = new a();
    private static final int e;
    private final Executor d = new ExecutorC0386a((byte) 0);

    /* renamed from: com.huawei.hmf.tasks.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hmf/tasks/a/a$a.class */
    static final class ExecutorC0386a implements Executor {
        private ExecutorC0386a() {
        }

        /* synthetic */ ExecutorC0386a(byte b) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        e = availableProcessors;
        f22355a = availableProcessors + 1;
        b = (availableProcessors * 2) + 1;
    }

    public static ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f22355a, b, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b() {
        return f22356c.d;
    }
}
