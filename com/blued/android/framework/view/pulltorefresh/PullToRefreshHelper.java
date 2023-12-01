package com.blued.android.framework.view.pulltorefresh;

import com.blued.android.core.AppInfo;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullToRefreshHelper.class */
public class PullToRefreshHelper {

    /* renamed from: a  reason: collision with root package name */
    private static int f10266a = 0;
    private static int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static int f10267c = 0;
    private static int d = 0;
    private static int e = 0;
    private static String f = "";

    public static String a() {
        return f10266a > 0 ? AppInfo.d().getString(f10266a) : "";
    }

    public static void a(int i, int i2, int i3, int i4, int i5) {
        f10266a = i;
        b = i2;
        f10267c = i3;
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
        return f10267c > 0 ? AppInfo.d().getString(f10267c) : "";
    }

    public static String d() {
        return d > 0 ? AppInfo.d().getString(d) : "";
    }

    public static String e() {
        return f;
    }
}
