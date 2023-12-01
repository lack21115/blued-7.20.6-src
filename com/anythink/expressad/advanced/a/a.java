package com.anythink.expressad.advanced.a;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Boolean> f6989a = new HashMap();

    private static void a() {
        f6989a.clear();
    }

    public static void a(String str) {
        f6989a.put(str, Boolean.TRUE);
    }

    public static boolean b(String str) {
        if (f6989a.containsKey(str)) {
            return f6989a.get(str).booleanValue();
        }
        return false;
    }

    public static void c(String str) {
        f6989a.remove(str);
    }
}
