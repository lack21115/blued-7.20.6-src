package com.blued.android.module.external_sense_library.utils;

import android.util.Log;
import com.blued.android.core.AppInfo;
import java.util.regex.Pattern;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/utils/LogUtils.class */
public class LogUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f11316a = Pattern.compile("GMT([-+]\\d{4})$");
    private static Boolean b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f11317c = true;

    public static int a(String str, String str2, Object... objArr) {
        if (a(str, 2)) {
            return Log.v(str, String.format(str2, objArr));
        }
        return 0;
    }

    public static boolean a(String str, int i) {
        return AppInfo.m();
    }

    public static int b(String str, String str2, Object... objArr) {
        if (a(str, 3)) {
            return Log.d(str, String.format(str2, objArr));
        }
        return 0;
    }

    public static int c(String str, String str2, Object... objArr) {
        if (a(str, 4)) {
            return Log.i(str, String.format(str2, objArr));
        }
        return 0;
    }

    public static int d(String str, String str2, Object... objArr) {
        if (a(str, 6)) {
            return Log.e(str, String.format(str2, objArr));
        }
        return 0;
    }
}
