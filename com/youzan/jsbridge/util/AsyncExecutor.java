package com.youzan.jsbridge.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/util/AsyncExecutor.class */
public class AsyncExecutor {
    private ExecutorService mJobExecutor;

    /* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/util/AsyncExecutor$AsyncExecutorHolder.class */
    static class AsyncExecutorHolder {
        static AsyncExecutor sInstance = new AsyncExecutor();

        AsyncExecutorHolder() {
        }
    }

    private AsyncExecutor() {
        this.mJobExecutor = Executors.newCachedThreadPool();
    }

    public static AsyncExecutor getInstance() {
        return AsyncExecutorHolder.sInstance;
    }

    public void post(Runnable runnable) {
        if (runnable != null) {
            this.mJobExecutor.execute(runnable);
        }
    }
}
