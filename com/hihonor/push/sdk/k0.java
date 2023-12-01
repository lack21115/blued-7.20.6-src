package com.hihonor.push.sdk;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/k0.class */
public final class k0 {
    public static final k0 f = new k0();

    /* renamed from: a  reason: collision with root package name */
    public final int f8701a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Executor f8702c;
    public volatile ExecutorService d;
    public final Object e = new Object();

    /* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/k0$a.class */
    public static class a implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public k0() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.f8701a = availableProcessors + 1;
        this.b = (availableProcessors * 2) + 1;
    }

    public static Executor a() {
        k0 k0Var = f;
        if (k0Var.f8702c == null) {
            synchronized (k0Var.e) {
                if (k0Var.f8702c == null) {
                    k0Var.f8702c = new a();
                }
            }
        }
        return k0Var.f8702c;
    }

    public static void a(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            a().execute(runnable);
        }
    }

    public static ExecutorService c() {
        return f.b();
    }

    public final ExecutorService b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f8701a, this.b, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
