package com.anythink.core.a;

import android.content.Context;
import com.anythink.core.c.d;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.k.p;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/a/c.class */
public final class c {
    private static c a;
    private final String b = "pacing_";

    public static c a() {
        if (a == null) {
            a = new c();
        }
        return a;
    }

    public static void a(String str) {
        try {
            p.a(n.a().g(), g.o, "pacing_".concat(String.valueOf(str)), System.currentTimeMillis());
        } catch (Exception e) {
        }
    }

    public static boolean a(String str, d dVar) {
        if (dVar == null) {
            return true;
        }
        if (dVar.ad() == -1) {
            return false;
        }
        long longValue = p.a(n.a().g(), g.o, "pacing_".concat(String.valueOf(str)), (Long) 0L).longValue();
        if (System.currentTimeMillis() - longValue >= 0) {
            return System.currentTimeMillis() - longValue < dVar.ad();
        }
        a(str);
        return false;
    }

    public final void a(final String str, final String str2) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Context g = n.a().g();
                    p.a(g, g.o, "pacing_" + str + BridgeUtil.UNDERLINE_STR + str2, System.currentTimeMillis());
                } catch (Exception e) {
                }
            }
        });
    }

    public final boolean a(String str, ai aiVar) {
        if (aiVar == null) {
            return true;
        }
        if (aiVar.s() == -1) {
            return false;
        }
        Context g = n.a().g();
        long longValue = p.a(g, g.o, "pacing_" + str + BridgeUtil.UNDERLINE_STR + aiVar.t(), (Long) 0L).longValue();
        if (System.currentTimeMillis() - longValue >= 0) {
            return System.currentTimeMillis() - longValue < aiVar.s();
        }
        a(str, aiVar.t());
        return false;
    }
}
