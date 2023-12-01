package com.jeremyliao.liveeventbus.utils;

import android.os.Looper;

/* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/utils/ThreadUtils.class */
public final class ThreadUtils {
    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
