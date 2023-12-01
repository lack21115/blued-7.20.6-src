package com.opos.mobad.service;

import android.os.Handler;
import android.os.Looper;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f13623a = new Handler(Looper.getMainLooper());

    public static final Handler a() {
        return f13623a;
    }

    public static void a(Runnable runnable) {
        f13623a.post(runnable);
    }

    public static final void a(Runnable runnable, long j) {
        f13623a.postDelayed(runnable, j);
    }

    public static final void b(Runnable runnable) {
        f13623a.removeCallbacks(runnable);
    }

    public static final void c(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f13623a.post(runnable);
        }
    }
}
