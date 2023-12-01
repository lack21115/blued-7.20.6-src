package com.blued.android.framework.utils.upload.qiniu.pool;

import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.pool.ThreadExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/pool/UploadThreadManager.class */
public class UploadThreadManager {

    /* renamed from: a  reason: collision with root package name */
    private static UploadThreadManager f10164a;
    private static final Long b = 10L;

    /* renamed from: c  reason: collision with root package name */
    private ThreadPoolExecutor f10165c;
    private ThreadPoolExecutor d;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/pool/UploadThreadManager$DefaultThreadFactory.class */
    static class DefaultThreadFactory implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private static final AtomicInteger f10167a = new AtomicInteger(1);
        private final ThreadGroup b;

        /* renamed from: c  reason: collision with root package name */
        private final AtomicInteger f10168c = new AtomicInteger(1);
        private final String d;

        DefaultThreadFactory() {
            SecurityManager securityManager = System.getSecurityManager();
            this.b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.d = "blued-" + f10167a.getAndIncrement() + "-pool-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.b;
            Thread thread = new Thread(threadGroup, runnable, this.d + this.f10168c.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    private UploadThreadManager() {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 4, b.longValue(), TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory(), new RejectedExecutionHandler() { // from class: com.blued.android.framework.utils.upload.qiniu.pool.UploadThreadManager.1
                @Override // java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                    if (AppInfo.m()) {
                        Log.i("UploadThreadManager", "rejectedExecution: " + runnable.toString());
                    }
                }
            });
            this.f10165c = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.d = new ThreadPoolExecutor(1, 2, b.longValue(), TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory());
    }

    public static UploadThreadManager a() {
        if (f10164a == null) {
            synchronized (UploadThreadManager.class) {
                try {
                    if (f10164a == null) {
                        f10164a = new UploadThreadManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10164a;
    }

    public void a(ThreadExecutor threadExecutor) {
        ThreadPoolExecutor threadPoolExecutor;
        if (threadExecutor == null || (threadPoolExecutor = this.f10165c) == null) {
            return;
        }
        threadPoolExecutor.execute(threadExecutor);
    }
}
