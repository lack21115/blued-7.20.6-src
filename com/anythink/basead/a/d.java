package com.anythink.basead.a;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5867a = d.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static volatile d f5868c;
    ConcurrentHashMap<String, com.anythink.basead.c.d> b = new ConcurrentHashMap<>();

    private d() {
    }

    public static d a() {
        if (f5868c == null) {
            synchronized (d.class) {
                try {
                    if (f5868c == null) {
                        f5868c = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f5868c;
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
