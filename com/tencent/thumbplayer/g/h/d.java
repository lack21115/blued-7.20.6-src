package com.tencent.thumbplayer.g.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/h/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f39362a = new Handler(Looper.getMainLooper());
    private static final ExecutorService b = Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    private static final HandlerThread f39363c;
    private static Handler d;

    static {
        HandlerThread handlerThread = new HandlerThread("tmediacodec-sub");
        f39363c = handlerThread;
        handlerThread.start();
        d = new Handler(f39363c.getLooper());
    }

    public static void a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b.execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static void b(Runnable runnable) {
        d.post(runnable);
    }
}
