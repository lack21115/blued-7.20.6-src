package com.blued.android.core;

import com.anythink.expressad.video.dynview.a.a;
import java.util.Locale;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/BlueAppLocal.class */
public class BlueAppLocal {
    public static String a() {
        return AppInfo.d().getResources().getConfiguration().locale.getLanguage();
    }

    public static String b() {
        return AppInfo.d().getResources().getConfiguration().locale.getCountry();
    }

    public static Locale c() {
        return AppInfo.d().getResources().getConfiguration().locale;
    }

    public static boolean d() {
        return a.V.equals(a());
    }
}
