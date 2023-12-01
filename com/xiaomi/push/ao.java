package com.xiaomi.push;

import android.os.Looper;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ao.class */
public class ao {
    public static void a() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new RuntimeException("can't do this on ui thread");
        }
    }
}
