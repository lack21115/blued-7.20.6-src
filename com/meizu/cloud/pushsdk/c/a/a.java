package com.meizu.cloud.pushsdk.c.a;

import com.meizu.cloud.pushinternal.DebugLogger;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f10386a = false;
    private static String b = "AndroidNetworking";

    public static void a() {
        f10386a = true;
    }

    public static void a(String str) {
        if (f10386a) {
            DebugLogger.d(b, str);
        }
    }

    public static void b(String str) {
        if (f10386a) {
            DebugLogger.i(b, str);
        }
    }
}
