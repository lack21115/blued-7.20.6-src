package com.blued.android.framework.view.pulltorefresh;

import com.blued.android.core.AppInfo;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshHelper.class */
public class PullToRefreshHelper {
    private static int a = 0;
    private static int b = 0;
    private static int c = 0;
    private static int d = 0;
    private static int e = 0;
    private static String f = "";

    public static String a() {
        return a > 0 ? AppInfo.d().getString(a) : "";
    }

    public static void a(int i, int i2, int i3, int i4, int i5) {
        a = i;
        b = i2;
        c = i3;
        d = i4;
        e = i5;
    }

    public static void a(String str) {
        f = str;
    }

    public static String b() {
        return b > 0 ? AppInfo.d().getString(b) : "";
    }

    public static String c() {
        return c > 0 ? AppInfo.d().getString(c) : "";
    }

    public static String d() {
        return d > 0 ? AppInfo.d().getString(d) : "";
    }

    public static String e() {
        return f;
    }
}
