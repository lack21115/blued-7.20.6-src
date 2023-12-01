package com.blued.android.module.external_sense_library.utils;

import android.os.HandlerThread;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/utils/ThreadHandlerManager.class */
public class ThreadHandlerManager {
    private static ThreadHandlerManager a;
    private HandlerThread b;
    private HandlerThread c;

    private ThreadHandlerManager() {
        c();
    }

    public static ThreadHandlerManager a() {
        if (a == null) {
            synchronized (ThreadHandlerManager.class) {
                try {
                    if (a == null) {
                        a = new ThreadHandlerManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    private void c() {
        if (this.b == null) {
            HandlerThread handlerThread = new HandlerThread("data_thread");
            this.b = handlerThread;
            handlerThread.start();
        }
        if (this.c == null) {
            HandlerThread handlerThread2 = new HandlerThread("log_thread");
            this.c = handlerThread2;
            handlerThread2.start();
        }
    }

    public HandlerThread b() {
        return this.c;
    }
}
