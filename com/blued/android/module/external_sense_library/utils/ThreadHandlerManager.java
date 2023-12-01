package com.blued.android.module.external_sense_library.utils;

import android.os.HandlerThread;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/utils/ThreadHandlerManager.class */
public class ThreadHandlerManager {

    /* renamed from: a  reason: collision with root package name */
    private static ThreadHandlerManager f11326a;
    private HandlerThread b;

    /* renamed from: c  reason: collision with root package name */
    private HandlerThread f11327c;

    private ThreadHandlerManager() {
        c();
    }

    public static ThreadHandlerManager a() {
        if (f11326a == null) {
            synchronized (ThreadHandlerManager.class) {
                try {
                    if (f11326a == null) {
                        f11326a = new ThreadHandlerManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f11326a;
    }

    private void c() {
        if (this.b == null) {
            HandlerThread handlerThread = new HandlerThread("data_thread");
            this.b = handlerThread;
            handlerThread.start();
        }
        if (this.f11327c == null) {
            HandlerThread handlerThread2 = new HandlerThread("log_thread");
            this.f11327c = handlerThread2;
            handlerThread2.start();
        }
    }

    public HandlerThread b() {
        return this.f11327c;
    }
}
