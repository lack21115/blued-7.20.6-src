package com.blued.android.statistics;

import android.content.Context;
import com.blued.android.statistics.util.Logger;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/StatConfig.class */
public class StatConfig {

    /* renamed from: a  reason: collision with root package name */
    private static Context f18679a;
    private static int b;

    /* renamed from: c  reason: collision with root package name */
    private static int f18680c;
    private static Logger d = new Logger("blued-statistics");

    public static Context a() {
        return f18679a;
    }

    public static String a(String str) {
        if (str == null || str.trim().length() <= 0) {
            return "blued-statistics";
        }
        return "blued-statistics-" + str;
    }

    private static void a(int i, boolean z) {
        if (z) {
            f18680c = i | f18680c;
        } else {
            f18680c = i & f18680c;
        }
    }

    public static void a(Context context) {
        f18679a = context;
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
        f18680c = z ? 63 : 0;
    }

    private static boolean b(int i) {
        return (f18680c & i) == i;
    }

    public static void c(boolean z) {
        a(16, z);
    }

    public static boolean c() {
        return f18680c != 0;
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
