package com.anythink.basead.a.b;

import android.text.TextUtils;
import com.anythink.basead.mraid.MraidWebView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/b/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5842a = 0;
    public static final int b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5843c = 100;
    private static Map<String, Integer> d = new HashMap();
    private static ConcurrentHashMap<String, MraidWebView> e = new ConcurrentHashMap<>(3);

    public static String a(j jVar, i iVar) {
        return jVar.d + BridgeUtil.UNDERLINE_STR + iVar.p();
    }

    public static void a(String str, int i) {
        Integer num = d.get(str);
        if (num == null || num.intValue() < i) {
            d.put(str, Integer.valueOf(i));
        }
    }

    public static void a(String str, MraidWebView mraidWebView) {
        e.put(str, mraidWebView);
    }

    public static boolean a(i iVar, int i, k kVar) {
        if (TextUtils.equals(String.valueOf(i), "1")) {
            if (TextUtils.isEmpty(iVar.x())) {
                return false;
            }
            return b(iVar.x(), kVar.S());
        } else if (!TextUtils.equals(String.valueOf(i), "3") || TextUtils.isEmpty(iVar.x())) {
            return true;
        } else {
            return b(iVar.x(), kVar.S());
        }
    }

    public static boolean a(i iVar, j jVar) {
        if (iVar == null) {
            return false;
        }
        k kVar = jVar.m;
        boolean a2 = a(iVar, jVar.j, kVar);
        if (a2) {
            if (iVar.g()) {
                if (kVar.V()) {
                    return e.containsKey(a(jVar, iVar));
                }
                a2 = true;
            }
            return a2;
        }
        return false;
    }

    public static boolean a(String str) {
        Integer num = d.get(str);
        return num != null && num.intValue() == 0;
    }

    public static MraidWebView b(String str) {
        return e.remove(str);
    }

    public static boolean b(String str, int i) {
        return com.anythink.core.common.a.j.a().a(str, i);
    }

    public static boolean c(String str) {
        String a2 = com.anythink.core.common.k.f.a(str);
        com.anythink.core.common.res.d a3 = com.anythink.core.common.res.d.a(n.a().g());
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return new File(a3.a(1) + File.separator + a2 + ".0").exists();
    }
}
