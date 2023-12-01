package com.android.internal.os;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BackgroundThread.class */
public final class BackgroundThread extends HandlerThread {
    private static Handler sHandler;
    private static BackgroundThread sInstance;

    private BackgroundThread() {
        super("android.bg", 10);
    }

    private static void ensureThreadLocked() {
        if (sInstance == null) {
            sInstance = new BackgroundThread();
            sInstance.start();
            sHandler = new Handler(sInstance.getLooper());
        }
    }

    public static BackgroundThread get() {
        BackgroundThread backgroundThread;
        synchronized (BackgroundThread.class) {
            try {
                ensureThreadLocked();
                backgroundThread = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return backgroundThread;
    }

    public static Handler getHandler() {
        Handler handler;
        synchronized (BackgroundThread.class) {
            try {
                ensureThreadLocked();
                handler = sHandler;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }
}
