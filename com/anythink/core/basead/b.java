package com.anythink.core.basead;

import android.content.Context;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.p;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/basead/b.class */
public class b {
    private static volatile b a;

    private b() {
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                try {
                    if (a == null) {
                        a = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public static String a(Context context, String str) {
        return p.b(context, g.v, str, "");
    }

    public static String a(j jVar) {
        return jVar == null ? "" : a(jVar.b, jVar.c, jVar.f);
    }

    public static String a(String str, String str2, int i) {
        return str + BridgeUtil.UNDERLINE_STR + str2 + BridgeUtil.UNDERLINE_STR + i;
    }

    public static void a(Context context, String str, String str2) {
        p.a(context, g.v, str, str2);
    }

    public static void b(Context context, String str) {
        p.a(context, g.v, str);
    }
}
