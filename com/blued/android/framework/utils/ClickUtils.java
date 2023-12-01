package com.blued.android.framework.utils;

import android.util.Log;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/ClickUtils.class */
public class ClickUtils {
    private static final String a = ClickUtils.class.getSimpleName();
    private static long b = 0;
    private static int c = -1;

    public static boolean a() {
        return a(-1, 1000L);
    }

    public static boolean a(int i) {
        return a(i, 1000L);
    }

    public static boolean a(int i, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = b;
        if (c == i && j2 > 0 && currentTimeMillis - j2 < j) {
            Log.d(a, "短时间内按钮多次触发");
            return true;
        }
        b = System.currentTimeMillis();
        c = i;
        return false;
    }
}
