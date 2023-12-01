package com.sina.weibo.sdk.statistic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/statistic/WBAgentExecutor.class */
class WBAgentExecutor {
    private static ExecutorService mExecutor = Executors.newSingleThreadExecutor();
    private static long TIMEOUT = 5;

    WBAgentExecutor() {
    }

    public static void execute(Runnable runnable) {
        synchronized (WBAgentExecutor.class) {
            try {
                if (mExecutor.isShutdown()) {
                    mExecutor = Executors.newSingleThreadExecutor();
                }
                mExecutor.execute(runnable);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void shutDownExecutor() {
        synchronized (WBAgentExecutor.class) {
            try {
                if (!mExecutor.isShutdown()) {
                    mExecutor.shutdown();
                }
                mExecutor.awaitTermination(TIMEOUT, TimeUnit.SECONDS);
            } catch (Exception e) {
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
