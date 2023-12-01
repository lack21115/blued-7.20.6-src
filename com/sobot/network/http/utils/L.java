package com.sobot.network.http.utils;

import android.util.Log;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/utils/L.class */
public class L {
    private static boolean debug = false;

    public static void e(String str) {
        if (debug) {
            Log.e("OkHttp", str);
        }
    }
}
