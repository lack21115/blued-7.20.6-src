package com.tencent.liteav.base.util;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/o.class */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f22650a = new Object();
    private static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static String f22651c = "";

    public static boolean a() {
        boolean z;
        synchronized (f22650a) {
            if (!b) {
                Log.w("SoLoader", "load library txsoundtouch ".concat(String.valueOf(a("txsoundtouch"))));
                Log.w("SoLoader", "load library txffmpeg ".concat(String.valueOf(a("txffmpeg"))));
                boolean a2 = a("livesdk");
                Log.w("SoLoader", "load library livesdk ".concat(String.valueOf(a2)));
                boolean a3 = a("liteavsdk");
                Log.w("SoLoader", "load library liteavsdk ".concat(String.valueOf(a3)));
                b = a2 || a3;
            }
            z = b;
        }
        return z;
    }

    public static boolean a(String str) {
        try {
            Log.w("SoLoader", "load library " + str + " from system path ");
            System.loadLibrary(str);
            return true;
        } catch (Error e) {
            Log.w("SoLoader", "load library : " + e.toString());
            return a(f22651c, str);
        } catch (Exception e2) {
            Log.w("SoLoader", "load library : " + e2.toString());
            return a(f22651c, str);
        }
    }

    private static boolean a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Log.w("SoLoader", "load library " + str2 + " from path " + str);
            System.load(str + "/lib" + str2 + ".so");
            return true;
        } catch (Error e) {
            Log.w("SoLoader", "load library : " + e.toString());
            return false;
        } catch (Exception e2) {
            Log.w("SoLoader", "load library : " + e2.toString());
            return false;
        }
    }

    public static String b() {
        return f22651c;
    }

    public static void b(String str) {
        Log.w("SoLoader", "setLibraryPath ".concat(String.valueOf(str)));
        f22651c = str;
    }
}
