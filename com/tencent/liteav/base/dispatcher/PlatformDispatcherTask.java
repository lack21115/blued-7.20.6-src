package com.tencent.liteav.base.dispatcher;

import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/dispatcher/PlatformDispatcherTask.class */
class PlatformDispatcherTask implements Runnable {
    private long mNativePlatformDispatcherTask;

    public PlatformDispatcherTask(long j) {
        this.mNativePlatformDispatcherTask = 0L;
        this.mNativePlatformDispatcherTask = j;
    }

    private void destroyTask() {
        long j = this.mNativePlatformDispatcherTask;
        if (j != 0) {
            nativeDestroyTask(j);
            this.mNativePlatformDispatcherTask = 0L;
        }
    }

    public static Handler getMainHandler() {
        return new Handler(Looper.getMainLooper());
    }

    private static native void nativeDestroyTask(long j);

    private static native void nativeRunTask(long j);

    protected void finalize() throws Throwable {
        destroyTask();
        super.finalize();
    }

    @Override // java.lang.Runnable
    public void run() {
        long j = this.mNativePlatformDispatcherTask;
        if (j != 0) {
            nativeRunTask(j);
            destroyTask();
        }
    }
}
