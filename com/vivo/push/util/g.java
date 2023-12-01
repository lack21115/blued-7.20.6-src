package com.vivo.push.util;

import android.os.Looper;
import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/util/g.class */
public final class g {
    public static void a(String str) {
        if (p.a() && Looper.myLooper() == Looper.getMainLooper()) {
            Log.w("DebugUtil", "Operation: " + str + " in main thread!", new Throwable());
        }
    }
}
