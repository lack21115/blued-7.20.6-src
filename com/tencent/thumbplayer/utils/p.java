package com.tencent.thumbplayer.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/p.class */
public class p {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/p$a.class */
    public static class a implements RejectedExecutionHandler {
        private a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            try {
                threadPoolExecutor.getQueue().put(runnable);
                TPLogUtil.i("TPPlayer[TPThreadPoolExecutor]", "rejectedExecution put task to queue");
            } catch (InterruptedException e) {
                TPLogUtil.e("TPPlayer[TPThreadPoolExecutor]", "rejectedExecution has exception:" + e.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/p$b.class */
    public static class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private AtomicInteger f39447a;

        private b() {
            this.f39447a = new AtomicInteger(0);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("TP-Thread" + this.f39447a.incrementAndGet());
            return thread;
        }
    }

    public static ExecutorService a(int i, int i2) {
        return new ThreadPoolExecutor(i, i2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(20), new b(), new a());
    }
}
