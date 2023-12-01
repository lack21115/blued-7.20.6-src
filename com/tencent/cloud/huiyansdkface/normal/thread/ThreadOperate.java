package com.tencent.cloud.huiyansdkface.normal.thread;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/normal/thread/ThreadOperate.class */
public class ThreadOperate {
    private static Handler mHandler = new Handler(Looper.getMainLooper());
    private static ExecutorService mExecutorService = Executors.newFixedThreadPool(3);

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/normal/thread/ThreadOperate$UiThreadCallback.class */
    public interface UiThreadCallback<T> {
        void callback(T t);
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static <T> Future<T> runOnSubThread(final Callable<T> callable) {
        return mExecutorService.submit(new Callable<T>() { // from class: com.tencent.cloud.huiyansdkface.normal.thread.ThreadOperate.2
            @Override // java.util.concurrent.Callable
            public T call() {
                try {
                    return (T) Callable.this.call();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });
    }

    public static void runOnSubThread(final Runnable runnable) {
        mExecutorService.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.normal.thread.ThreadOperate.1
            @Override // java.lang.Runnable
            public void run() {
                Runnable.this.run();
            }
        });
    }

    public static <T> void runOnSubThread(final Callable<T> callable, final UiThreadCallback<T> uiThreadCallback) {
        mExecutorService.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.normal.thread.ThreadOperate.3
            @Override // java.lang.Runnable
            public void run() {
                Object obj;
                try {
                    obj = Callable.this.call();
                } catch (Exception e) {
                    e.printStackTrace();
                    obj = null;
                }
                final Object obj2 = obj;
                ThreadOperate.mHandler.post(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.normal.thread.ThreadOperate.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (uiThreadCallback != null) {
                            try {
                                uiThreadCallback.callback(obj2);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
    }

    public static void runOnUiThread(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            mHandler.post(runnable);
        }
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j) {
        mHandler.postDelayed(runnable, j);
    }
}
