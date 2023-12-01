package com.blued.android.module.im.grpc;

import android.util.Log;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/grpc/IMThreadManager.class */
public class IMThreadManager {
    private ThreadPoolExecutor a;

    public IMThreadManager(int i, int i2) {
        this.a = null;
        if (0 == 0) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, 32767L, TimeUnit.SECONDS, new LinkedBlockingQueue(30), Executors.defaultThreadFactory(), new RejectedExecutionHandler() { // from class: com.blued.android.module.im.grpc.IMThreadManager.1
                @Override // java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                    Log.i("rejectedExecution:", runnable.toString());
                }
            });
            this.a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
    }

    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        if (runnable == null || (threadPoolExecutor = this.a) == null) {
            return;
        }
        try {
            threadPoolExecutor.execute(runnable);
        } catch (OutOfMemoryError e) {
        }
    }
}
