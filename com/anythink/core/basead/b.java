package com.anythink.core.basead;

import android.content.Context;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.p;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/basead/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f6393a;

    private b() {
    }

    public static b a() {
        if (f6393a == null) {
            synchronized (b.class) {
                try {
                    if (f6393a == null) {
                        f6393a = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6393a;
    }

    public static String a(Context context, String str) {
        return p.b(context, g.v, str, "");
    }

    public static String a(j jVar) {
        return jVar == null ? "" : a(jVar.b, jVar.f6664c, jVar.f);
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
