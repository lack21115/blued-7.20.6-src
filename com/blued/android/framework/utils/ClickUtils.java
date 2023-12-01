package com.blued.android.framework.utils;

import android.util.Log;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/ClickUtils.class */
public class ClickUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10074a = ClickUtils.class.getSimpleName();
    private static long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static int f10075c = -1;

    public static boolean a() {
        return a(-1, 1000L);
    }

    public static boolean a(int i) {
        return a(i, 1000L);
    }

    public static boolean a(int i, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = b;
        if (f10075c == i && j2 > 0 && currentTimeMillis - j2 < j) {
            Log.d(f10074a, "短时间内按钮多次触发");
            return true;
        }
        b = System.currentTimeMillis();
        f10075c = i;
        return false;
    }
}
