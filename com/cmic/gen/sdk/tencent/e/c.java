package com.cmic.gen.sdk.tencent.e;

import android.util.Log;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/e/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final c f21659a = new c();
    private static boolean b = false;

    public static void a(String str, String str2) {
        if (b) {
            Log.e("CMCC-SDK:" + str, "" + str2);
        }
    }

    public static void a(boolean z) {
        b = z;
    }

    public static void b(String str, String str2) {
        if (b) {
            Log.d("CMCC-SDK:" + str, "" + str2);
        }
    }
}
