package com.meizu.cloud.pushsdk.d.f;

import com.meizu.cloud.pushinternal.DebugLogger;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/d/f/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static int f10514a;

    private static String a() {
        return Thread.currentThread().getName();
    }

    private static String a(String str) {
        return "PushTracker->" + str;
    }

    private static String a(String str, Object... objArr) {
        return a() + "|" + String.format(str, objArr);
    }

    public static void a(b bVar) {
        f10514a = bVar.a();
    }

    public static void a(String str, String str2, Object... objArr) {
        if (f10514a >= b.ERROR.a()) {
            DebugLogger.e(a(str), a(str2, objArr));
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        if (f10514a >= b.DEBUG.a()) {
            DebugLogger.d(a(str), a(str2, objArr));
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        if (f10514a >= b.VERBOSE.a()) {
            DebugLogger.i(a(str), a(str2, objArr));
        }
    }
}
