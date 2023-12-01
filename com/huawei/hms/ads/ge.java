package com.huawei.hms.ads;

import android.os.Build;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ge.class */
public abstract class ge {
    private static gf Code = new gf();

    private static boolean B() {
        return Code.Code(6);
    }

    public static void Code(int i, String str, String str2) {
        Code.Code(i, str, str2);
        Code.Code(str2, "\n============================================================================\n====== " + V() + "\n====== Brand: " + Build.BRAND + " Model: " + Build.MODEL + " Release: " + Build.VERSION.RELEASE + " API: " + Build.VERSION.SDK_INT + "\n============================================================================");
    }

    public static void Code(int i, String str, String str2, Throwable th) {
        Code.Code(i, str, str2, th);
    }

    public static void Code(int i, Throwable th) {
        Code.Code(i, "", th);
    }

    public static void Code(String str, String str2) {
        Code.V(3, str, str2);
    }

    public static void Code(String str, String str2, Object... objArr) {
        if (!Code() || str2 == null) {
            return;
        }
        Code(str, String.format(Locale.ENGLISH, str2, objArr));
    }

    public static boolean Code() {
        return Code.Code(3);
    }

    public static void I(String str, String str2) {
        Code.V(5, str, str2);
    }

    public static void I(String str, String str2, Object... objArr) {
        if (!Z() || str2 == null) {
            return;
        }
        I(str, String.format(Locale.ENGLISH, str2, objArr));
    }

    private static boolean I() {
        return Code.Code(4);
    }

    private static String V() {
        return "HiAd-13.4.61.304";
    }

    public static void V(String str, String str2) {
        Code.V(4, str, str2);
    }

    public static void V(String str, String str2, Object... objArr) {
        if (!I() || str2 == null) {
            return;
        }
        V(str, String.format(Locale.ENGLISH, str2, objArr));
    }

    public static void Z(String str, String str2) {
        Code.V(6, str, str2);
    }

    public static void Z(String str, String str2, Object... objArr) {
        if (!B() || str2 == null) {
            return;
        }
        Z(str, String.format(Locale.ENGLISH, str2, objArr));
    }

    private static boolean Z() {
        return Code.Code(5);
    }
}
