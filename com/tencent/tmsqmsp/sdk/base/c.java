package com.tencent.tmsqmsp.sdk.base;

import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/base/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f26005a = "2g.outt";
    private static boolean b = false;

    public static void a(String str) {
        if (b) {
            Log.d(f26005a, str);
        }
    }

    public static void a(boolean z) {
        b = z;
    }

    public static void b(String str) {
        if (b) {
            Log.e(f26005a, str);
        }
    }

    public static void c(String str) {
        if (b) {
            Log.i(f26005a, str);
        }
    }
}
