package com.anythink.basead.a;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/d.class */
public class d {
    public static final String a = d.class.getSimpleName();
    private static volatile d c;
    ConcurrentHashMap<String, com.anythink.basead.c.d> b = new ConcurrentHashMap<>();

    private d() {
    }

    public static d a() {
        if (c == null) {
            synchronized (d.class) {
                try {
                    if (c == null) {
                        c = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    public final com.anythink.basead.c.d a(int i, String str) {
        ConcurrentHashMap<String, com.anythink.basead.c.d> concurrentHashMap = this.b;
        return concurrentHashMap.get(i + str);
    }

    public final void a(int i, String str, com.anythink.basead.c.d dVar) {
        ConcurrentHashMap<String, com.anythink.basead.c.d> concurrentHashMap = this.b;
        concurrentHashMap.put(i + str, dVar);
    }
}
