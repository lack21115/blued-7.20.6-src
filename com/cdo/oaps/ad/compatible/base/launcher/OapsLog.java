package com.cdo.oaps.ad.compatible.base.launcher;

import android.util.Log;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/compatible/base/launcher/OapsLog.class */
public class OapsLog {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7915a = "oaps_sdk";
    public static final String b = "oaps_sdk_download";

    /* renamed from: c  reason: collision with root package name */
    public static final String f7916c = "oaps_sdk_storage";
    public static final String d = "oaps_sdk_listener";
    private static final boolean e = false;
    private static boolean f = false;

    public static void d(String str, String str2) {
        if (f) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (f) {
            Log.e(str, str2);
        }
    }

    public static void i(String str) {
        if (f) {
            Log.i(f7915a, str);
        }
    }

    public static void i(String str, String str2) {
        if (f) {
            Log.i(str, str2);
        }
    }

    public static boolean isDebugable() {
        return f;
    }

    public static void setDebug(boolean z) {
        f = z;
    }

    public static void w(String str, String str2) {
        if (f) {
            Log.w(str, str2);
        }
    }
}
