package com.blued.android.statistics.util;

import android.os.Build;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/util/DeviceUtils.class */
public class DeviceUtils {
    public static String a() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.toLowerCase().startsWith(str.toLowerCase())) {
            return a(str2);
        }
        return a(str) + " " + str2;
    }

    private static String a(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }
}
