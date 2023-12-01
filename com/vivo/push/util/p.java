package com.vivo.push.util;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/util/p.class */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final o f41142a = new n();
    private static boolean b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f41143c;

    static {
        b();
    }

    public static int a(String str, String str2) {
        return f41142a.a(str, str2);
    }

    public static int a(String str, String str2, Throwable th) {
        return f41142a.a(str, str2, th);
    }

    public static int a(String str, Throwable th) {
        return f41142a.a(str, th);
    }

    public static String a(Throwable th) {
        return f41142a.a(th);
    }

    public static void a(Context context, String str) {
        f41142a.a(context, str);
    }

    public static void a(boolean z) {
        b();
        f41143c = z;
    }

    public static boolean a() {
        return b && f41143c;
    }

    public static int b(String str, String str2) {
        return f41142a.b(str, str2);
    }

    public static int b(String str, String str2, Throwable th) {
        return f41142a.b(str, str2, th);
    }

    private static void b() {
        b = z.b("persist.sys.log.ctrl", "no").equals("yes");
    }

    public static void b(Context context, String str) {
        f41142a.b(context, str);
    }

    public static int c(String str, String str2) {
        return f41142a.c(str, str2);
    }

    public static void c(Context context, String str) {
        f41142a.c(context, str);
    }

    public static int d(String str, String str2) {
        return f41142a.d(str, str2);
    }

    public static int e(String str, String str2) {
        return f41142a.e(str, str2);
    }
}
