package com.huawei.secure.android.common.util;

import android.os.Handler;
import android.os.Looper;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/util/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f9552a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        f9552a.post(runnable);
    }
}
