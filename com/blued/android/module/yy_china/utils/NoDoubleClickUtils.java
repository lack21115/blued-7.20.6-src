package com.blued.android.module.yy_china.utils;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/NoDoubleClickUtils.class */
public class NoDoubleClickUtils {

    /* renamed from: a  reason: collision with root package name */
    private static long f17871a;

    public static boolean a() {
        boolean z;
        synchronized (NoDoubleClickUtils.class) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                z = currentTimeMillis - f17871a <= 500;
                f17871a = currentTimeMillis;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
