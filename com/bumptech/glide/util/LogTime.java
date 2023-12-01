package com.bumptech.glide.util;

import android.os.Build;
import android.os.SystemClock;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/LogTime.class */
public final class LogTime {

    /* renamed from: a  reason: collision with root package name */
    private static final double f7497a;

    static {
        double d = 1.0d;
        if (Build.VERSION.SDK_INT >= 17) {
            d = 1.0d / Math.pow(10.0d, 6.0d);
        }
        f7497a = d;
    }

    private LogTime() {
    }

    public static double a(long j) {
        return (a() - j) * f7497a;
    }

    public static long a() {
        return Build.VERSION.SDK_INT >= 17 ? SystemClock.elapsedRealtimeNanos() : SystemClock.uptimeMillis();
    }
}
