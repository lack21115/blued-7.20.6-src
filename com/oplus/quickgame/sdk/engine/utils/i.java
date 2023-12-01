package com.oplus.quickgame.sdk.engine.utils;

import android.util.Log;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/i.class */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f24417a;

    public static void a() {
        f24417a = true;
    }

    public static void a(String str, String str2) {
        if (f24417a) {
            Log.d(str, str2);
        }
    }

    public static void b() {
        f24417a = false;
    }

    public static void b(String str, String str2) {
        Log.e(str, str2);
    }

    public static void c(String str, String str2) {
        if (f24417a) {
            Log.i(str, str2);
        }
    }
}
