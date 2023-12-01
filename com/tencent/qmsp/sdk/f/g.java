package com.tencent.qmsp.sdk.f;

import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/f/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static String f24913a = "Qp.Log";
    private static boolean b = false;

    public static void a(String str, int i, String str2) {
        if (b) {
            Log.d(str, str2);
        }
    }

    public static void a(boolean z) {
        b = z;
    }

    public static void b(String str, int i, String str2) {
        if (b) {
            Log.e(str, str2);
        }
    }

    public static void c(String str, int i, String str2) {
        if (b) {
            Log.v(str, str2);
        }
    }

    public static void d(String str, int i, String str2) {
        if (b) {
            Log.w(str, str2);
        }
    }
}
