package com.youzan.jsbridge.util;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/util/Logger.class */
public final class Logger {
    private static final String TAG = "WVC_JsBridge";
    private static boolean sIsDebug = false;

    public static void d(String str) {
        d(TAG, str);
    }

    public static void d(String str, String str2) {
        if (!isDebug() || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(str, str2);
    }

    public static void e(String str) {
        e(TAG, str);
    }

    public static void e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e(str, str2);
    }

    public static void i(String str) {
        i(TAG, str);
    }

    public static void i(String str, String str2) {
        if (!isDebug() || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(str, str2);
    }

    static boolean isDebug() {
        return sIsDebug;
    }

    public static void setIsDebug(boolean z) {
        sIsDebug = z;
    }

    public static void w(String str) {
        w(TAG, str);
    }

    public static void w(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(str, str2);
    }
}
