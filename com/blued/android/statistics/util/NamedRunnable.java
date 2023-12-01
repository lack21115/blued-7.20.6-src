package com.blued.android.statistics.util;

import android.os.Looper;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/util/NamedRunnable.class */
public abstract class NamedRunnable implements Runnable {
    private volatile String a;

    public NamedRunnable(String str) {
        this.a = str;
    }

    protected abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        Thread currentThread = Thread.currentThread();
        if (currentThread != Looper.getMainLooper().getThread()) {
            currentThread.setName(this.a);
        }
        a();
    }
}
