package com.opos.cmn.an.b;

import android.Manifest;
import android.content.Context;
import android.os.Build;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/b/c.class */
public final class c {
    public static String a() {
        return Build.MODEL != null ? Build.MODEL : "";
    }

    public static String a(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            try {
                if (Build.VERSION.SDK_INT <= 28) {
                    if (Build.SERIAL == null) {
                        return "";
                    }
                } else if (applicationContext.checkCallingOrSelfPermission(Manifest.permission.READ_PRIVILEGED_PHONE_STATE) != 0 || Build.SERIAL == null) {
                    return "";
                }
                return Build.SERIAL;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("OSBuildTool", "getSerial", e);
                return "";
            }
        }
        return "";
    }

    public static int b() {
        return Build.VERSION.SDK_INT;
    }

    public static String c() {
        return Build.VERSION.RELEASE != null ? Build.VERSION.RELEASE : "";
    }

    public static String d() {
        return Build.BRAND != null ? Build.BRAND : "";
    }

    public static String e() {
        return Build.MANUFACTURER != null ? Build.MANUFACTURER : "";
    }
}
