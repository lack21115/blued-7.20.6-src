package com.opos.mobad.service;

import android.os.Handler;
import android.os.Looper;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f27311a = new Handler(Looper.getMainLooper());

    public static final Handler a() {
        return f27311a;
    }

    public static void a(Runnable runnable) {
        f27311a.post(runnable);
    }

    public static final void a(Runnable runnable, long j) {
        f27311a.postDelayed(runnable, j);
    }

    public static final void b(Runnable runnable) {
        f27311a.removeCallbacks(runnable);
    }

    public static final void c(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f27311a.post(runnable);
        }
    }
}
