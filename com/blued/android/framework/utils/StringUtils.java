package com.blued.android.framework.utils;

import android.text.Editable;
import android.text.TextUtils;
import java.util.regex.Pattern;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/StringUtils.class */
public class StringUtils {
    public static double a(String str, double d) {
        if (b(str)) {
            return d;
        }
        try {
            return Double.valueOf(str).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            return d;
        }
    }

    public static float a(String str, float f) {
        if (b(str)) {
            return f;
        }
        try {
            return Float.valueOf(str).floatValue();
        } catch (Exception e) {
            e.printStackTrace();
            return f;
        }
    }

    public static int a(Editable editable) {
        int i;
        int i2;
        if (TextUtils.isEmpty(editable)) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < editable.length(); i4++) {
            if (editable.charAt(i4) < 128) {
                i = i3;
                i2 = 1;
            } else {
                i = i3;
                i2 = 2;
            }
            i3 = i + i2;
        }
        return i3;
    }

    public static int a(String str) {
        if (!b(str) && Pattern.compile("[0-9]*").matcher(str).matches()) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public static int a(String str, int i) {
        if (b(str)) {
            return i;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public static long a(String str, long j) {
        if (b(str)) {
            return j;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    public static String a(int i, String str) {
        return String.valueOf(i);
    }

    public static boolean a(String str, String str2) {
        return a(str, str2, true);
    }

    public static boolean a(String str, String str2, boolean z) {
        if (str == null || str2 == null) {
            return false;
        }
        if (z || !(TextUtils.isEmpty(str) || TextUtils.isEmpty(str))) {
            return str.equals(str2);
        }
        return false;
    }

    public static boolean b(String str) {
        return str == null || "".equals(str.trim()) || "null".equals(str) || str.equals(" ");
    }

    public static int c(String str) {
        int i;
        int i2;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < str.length(); i4++) {
            if (str.charAt(i4) < 128) {
                i = i3;
                i2 = 1;
            } else {
                i = i3;
                i2 = 2;
            }
            i3 = i + i2;
        }
        return i3;
    }
}
