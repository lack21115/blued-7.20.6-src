package com.huawei.secure.android.common.encrypt.utils;

import android.util.Log;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/encrypt/utils/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9484a = "SecurityComp10105310: ";

    private static String a(String str) {
        return f9484a + str;
    }

    public static void a(String str, String str2) {
    }

    public static void a(String str, String str2, Throwable th) {
        Log.e(a(str), str2, th);
    }

    public static void b(String str, String str2) {
        Log.e(a(str), str2);
    }

    public static void c(String str, String str2) {
        Log.i(a(str), str2);
    }

    public static void d(String str, String str2) {
        Log.v(a(str), str2);
    }

    public static void e(String str, String str2) {
        Log.w(a(str), str2);
    }
}
