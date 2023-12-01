package com.danlan.android.cognition;

import android.util.Log;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/Logger.class */
public class Logger {
    private static String PREFIX = StringFog.decrypt("YkxDTUhXTU5PcGBo");
    private static boolean isDebug = false;

    public static void d(String str) {
        if (isDebug) {
            Log.d(PREFIX, str);
        }
    }

    public static void e(String str) {
        if (isDebug) {
            Log.e(PREFIX, str);
        }
    }

    public static void i(String str) {
        if (isDebug) {
            Log.i(PREFIX, str);
        }
    }

    public static void t(String str) {
        if (!isDebug) {
            return;
        }
        String trim = str.trim();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= trim.length()) {
                return;
            }
            int length = trim.length();
            int i3 = i2 + 4000;
            Log.d(PREFIX, (length <= i3 ? trim.substring(i2) : trim.substring(i2, 4000)).trim());
            i = i3;
        }
    }

    public static void v(String str) {
        if (isDebug) {
            Log.v(PREFIX, str);
        }
    }

    public static void w(String str) {
        if (isDebug) {
            Log.w(PREFIX, str);
        }
    }
}
