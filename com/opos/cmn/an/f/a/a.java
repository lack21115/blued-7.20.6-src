package com.opos.cmn.an.f.a;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/f/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Boolean f24506a;
    private static volatile Boolean b;

    public static void a(boolean z) {
        synchronized (a.class) {
            try {
                b = Boolean.valueOf(z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean a(Context context) {
        boolean booleanValue;
        synchronized (a.class) {
            try {
                booleanValue = Build.VERSION.SDK_INT <= 29 ? true : b != null ? b.booleanValue() : b(context);
            } finally {
            }
        }
        return booleanValue;
    }

    public static boolean b(Context context) {
        Boolean bool;
        boolean booleanValue;
        synchronized (a.class) {
            try {
                if (f24506a == null) {
                    try {
                        if (Build.VERSION.SDK_INT > 29) {
                            if (context != null) {
                                if (Settings.Global.getInt(context.getApplicationContext().getContentResolver(), "oplus_customize_system_stable_plan_switch") == 0) {
                                    bool = false;
                                    f24506a = bool;
                                }
                            }
                        }
                        bool = true;
                        f24506a = bool;
                    } catch (Throwable th) {
                    }
                }
                if (f24506a == null) {
                    f24506a = true;
                }
                booleanValue = f24506a.booleanValue();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return booleanValue;
    }
}
