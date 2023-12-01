package com.blued.android.framework.pool;

import android.util.Log;
import com.blued.android.core.AppInfo;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/pool/ThreadExecutor.class */
public abstract class ThreadExecutor implements Runnable {
    private static final String TAG = "ThreadExecutor";
    private String threadName;
    private ThreadPriority threadPriority;

    private ThreadExecutor() {
        this.threadPriority = ThreadPriority.NORMAL;
    }

    public ThreadExecutor(String str) {
        this.threadPriority = ThreadPriority.NORMAL;
        this.threadName = str;
    }

    public ThreadExecutor(String str, ThreadPriority threadPriority) {
        this.threadPriority = ThreadPriority.NORMAL;
        this.threadName = str;
        this.threadPriority = threadPriority;
    }

    public abstract void execute();

    public String getThreadName() {
        return this.threadName;
    }

    public ThreadPriority getThreadPriority() {
        return this.threadPriority;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (AppInfo.m()) {
            Log.i(TAG, toString() + ": start to run.");
        }
        execute();
    }

    public String toString() {
        return "Thread [name:" + this.threadName + ", priority:" + this.threadPriority.name() + "]";
    }
}
