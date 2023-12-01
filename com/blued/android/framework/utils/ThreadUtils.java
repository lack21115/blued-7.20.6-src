package com.blued.android.framework.utils;

import android.os.Handler;
import android.os.Looper;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/ThreadUtils.class */
public class ThreadUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f10117a = new Handler(Looper.getMainLooper());

    private ThreadUtils() {
    }

    public static void a(Runnable runnable) {
        if (a()) {
            runnable.run();
        } else {
            f10117a.post(runnable);
        }
    }

    public static void a(Runnable runnable, long j) {
        f10117a.postDelayed(runnable, j);
    }

    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void b(Runnable runnable) {
        f10117a.post(runnable);
    }

    public static void c(Runnable runnable) {
        f10117a.removeCallbacks(runnable);
    }
}
