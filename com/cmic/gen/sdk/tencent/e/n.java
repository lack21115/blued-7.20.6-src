package com.cmic.gen.sdk.tencent.e;

import android.content.Context;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/e/n.class */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f21670a = new ThreadPoolExecutor(0, 30, 60, TimeUnit.SECONDS, new SynchronousQueue());

    /* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/e/n$a.class */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Thread.UncaughtExceptionHandler f21671a;

        public a() {
            this.f21671a = new Thread.UncaughtExceptionHandler() { // from class: com.cmic.gen.sdk.tencent.e.n.a.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    th.printStackTrace();
                }
            };
        }

        public a(final Context context, final com.cmic.gen.sdk.tencent.a aVar) {
            this.f21671a = new Thread.UncaughtExceptionHandler() { // from class: com.cmic.gen.sdk.tencent.e.n.a.2
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    aVar.a().f21653a.add(th);
                    com.cmic.gen.sdk.tencent.auth.c.getInstance(context).callBackResult("200025", "发生未知错误", aVar, null);
                }
            };
        }

        protected abstract void a();

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setUncaughtExceptionHandler(this.f21671a);
            a();
            Thread.currentThread().setUncaughtExceptionHandler(null);
        }
    }

    public static void a(a aVar) {
        try {
            f21670a.execute(aVar);
        } catch (Exception e) {
            aVar.f21671a.uncaughtException(Thread.currentThread(), e);
        }
    }
}
