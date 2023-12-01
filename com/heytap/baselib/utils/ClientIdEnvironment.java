package com.heytap.baselib.utils;

import android.util.Log;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/baselib/utils/ClientIdEnvironment.class */
public class ClientIdEnvironment {
    static String TAG = "ClientIdUtils";
    public static boolean debug = false;

    public static void log(String str) {
        if (debug) {
            Log.d(TAG, str);
        }
    }
}
