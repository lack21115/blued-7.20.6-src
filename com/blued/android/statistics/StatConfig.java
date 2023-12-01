package com.blued.android.statistics;

import android.content.Context;
import com.android.internal.content.NativeLibraryHelper;
import com.blued.android.statistics.util.Logger;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/StatConfig.class */
public class StatConfig {
    private static Context a;
    private static int b;
    private static int c;
    private static Logger d = new Logger("blued-statistics");

    public static Context a() {
        return a;
    }

    public static String a(String str) {
        if (str == null || str.trim().length() <= 0) {
            return "blued-statistics";
        }
        return "blued-statistics" + NativeLibraryHelper.CLEAR_ABI_OVERRIDE + str;
    }

    private static void a(int i, boolean z) {
        if (z) {
            c = i | c;
        } else {
            c = i & c;
        }
    }

    public static void a(Context context) {
        a = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(boolean z) {
        b = z ? 63 : 0;
        if (z) {
            return;
        }
        b(false);
    }

    private static boolean a(int i) {
        return (b & i) == i;
    }

    public static Logger b() {
        return d;
    }

    protected static void b(boolean z) {
        c = z ? 63 : 0;
    }

    private static boolean b(int i) {
        return (c & i) == i;
    }

    public static void c(boolean z) {
        a(16, z);
    }

    public static boolean c() {
        return c != 0;
    }

    public static boolean d() {
        return a(1);
    }

    public static boolean e() {
        return b(1);
    }

    public static boolean f() {
        return a(2);
    }

    public static boolean g() {
        return b(2);
    }

    public static boolean h() {
        return a(4);
    }

    public static boolean i() {
        return b(4);
    }

    public static boolean j() {
        return a(8);
    }

    public static boolean k() {
        return b(8);
    }

    public static boolean l() {
        return a(16);
    }

    public static boolean m() {
        return b(16);
    }

    public static boolean n() {
        return a(32);
    }

    public static boolean o() {
        return b(32);
    }
}
