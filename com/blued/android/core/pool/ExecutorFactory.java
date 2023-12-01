package com.blued.android.core.pool;

import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.deque.LinkedBlockingDeque;
import com.blued.android.core.utils.Log;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/pool/ExecutorFactory.class */
public class ExecutorFactory {
    private static ExecutorFactory b;
    private static final String a = ExecutorFactory.class.getSimpleName();
    private static final Long c = 10L;
    private ThreadPoolExecutor d = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory("data"), new ThreadPoolExecutor.DiscardOldestPolicy() { // from class: com.blued.android.core.pool.ExecutorFactory.1
        @Override // java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy, java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            super.rejectedExecution(runnable, threadPoolExecutor);
            String str = ExecutorFactory.a;
            Log.e(str, "DataExecutor rejectedExecution(), e:" + threadPoolExecutor);
        }
    });
    private ThreadPoolExecutor f = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory("preLoader"), new ThreadPoolExecutor.DiscardOldestPolicy() { // from class: com.blued.android.core.pool.ExecutorFactory.2
        @Override // java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy, java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            super.rejectedExecution(runnable, threadPoolExecutor);
            String str = ExecutorFactory.a;
            Log.e(str, "ImageLoader.prePareExecutor rejectedExecution(), e:" + threadPoolExecutor);
        }
    });
    private ThreadPoolExecutor e = new ThreadPoolExecutor(RecyclingUtils.c(), RecyclingUtils.c(), 0, TimeUnit.SECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory("Http"), new ThreadPoolExecutor.DiscardOldestPolicy() { // from class: com.blued.android.core.pool.ExecutorFactory.3
        @Override // java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy, java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            super.rejectedExecution(runnable, threadPoolExecutor);
            String str = ExecutorFactory.a;
            Log.e(str, "HttpExecutor rejectedExecution(), e:" + threadPoolExecutor);
        }
    });

    private ExecutorFactory() {
    }

    public static ExecutorFactory a() {
        if (b == null) {
            synchronized (ExecutorFactory.class) {
                try {
                    if (b == null) {
                        b = new ExecutorFactory();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public ThreadPoolExecutor b() {
        return this.d;
    }

    public ThreadPoolExecutor c() {
        return this.e;
    }

    public ThreadPoolExecutor d() {
        return this.f;
    }
}
