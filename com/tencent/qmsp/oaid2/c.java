package com.tencent.qmsp.oaid2;

import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f38460a = false;
    public static String b = "2g.outt";

    public static void a(String str) {
        if (f38460a) {
            Log.d(b, str);
        }
    }

    public static void b(String str) {
        if (f38460a) {
            Log.e(b, str);
        }
    }

    public static void c(String str) {
        if (f38460a) {
            Log.i(b, str);
        }
    }
}
