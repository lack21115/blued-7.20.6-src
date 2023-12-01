package com.android.internal.view;

import android.os.Looper;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/WindowManagerPolicyThread.class */
public class WindowManagerPolicyThread {
    static Looper mLooper;
    static Thread mThread;

    public static Looper getLooper() {
        return mLooper;
    }

    public static Thread getThread() {
        return mThread;
    }

    public static void set(Thread thread, Looper looper) {
        mThread = thread;
        mLooper = looper;
    }
}
