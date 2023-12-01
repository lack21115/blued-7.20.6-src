package com.opos.mobad.c.b;

import android.os.Handler;
import android.os.Looper;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/c/b/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f12121a = new Handler(Looper.getMainLooper());

    public static final Handler a() {
        return f12121a;
    }

    public static void a(Runnable runnable) {
        f12121a.post(runnable);
    }

    public static final void a(Runnable runnable, long j) {
        f12121a.postDelayed(runnable, j);
    }

    public static final void b(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f12121a.post(runnable);
        }
    }
}
