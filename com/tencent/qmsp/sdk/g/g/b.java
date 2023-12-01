package com.tencent.qmsp.sdk.g.g;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/g/b.class */
public class b {
    public static String a(Context context) {
        if (a.f24950a) {
            return e.f.a(a.a(context), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static boolean a() {
        if (a.f24950a) {
            return a.b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String b(Context context) {
        if (a.f24950a) {
            return e.f.a(a.a(context), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static void c(Context context) {
        a.b = e.f.a(a.a(context));
        a.f24950a = true;
    }
}
