package com.blued.android.module.yy_china.utils;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/NoDoubleClickUtils.class */
public class NoDoubleClickUtils {
    private static long a;

    public static boolean a() {
        boolean z;
        synchronized (NoDoubleClickUtils.class) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                z = currentTimeMillis - a <= 500;
                a = currentTimeMillis;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
