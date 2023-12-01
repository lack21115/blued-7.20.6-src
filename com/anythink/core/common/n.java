package com.anythink.core.common;

import com.anythink.core.common.b.g;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/n.class */
public class n {

    /* renamed from: c  reason: collision with root package name */
    private static volatile n f6861c;

    /* renamed from: a  reason: collision with root package name */
    com.anythink.core.common.c.h f6862a;
    private final String b = getClass().getSimpleName();
    private ConcurrentHashMap<String, String> d = new ConcurrentHashMap<>(3);

    public n() {
        com.anythink.core.common.c.h a2 = com.anythink.core.common.c.h.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.n.a().g()));
        this.f6862a = a2;
        List<com.anythink.core.common.e.p> d = a2.d();
        if (d != null) {
            for (com.anythink.core.common.e.p pVar : d) {
                this.d.put(pVar.a(), "1");
            }
        }
    }

    public static n a() {
        if (f6861c == null) {
            synchronized (n.class) {
                try {
                    if (f6861c == null) {
                        f6861c = new n();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6861c;
    }

    public static int b() {
        return com.anythink.core.common.k.p.b(com.anythink.core.common.b.n.a().g(), com.anythink.core.common.b.g.o, g.o.p, 0);
    }

    public final void a(String str) {
        Map<String, Object> c2 = com.anythink.core.common.k.h.c(com.anythink.core.common.k.c.c(str));
        if (c2.size() == 0) {
            com.anythink.core.common.k.p.a(com.anythink.core.common.b.n.a().g(), com.anythink.core.common.b.g.o, g.o.p, 0);
            return;
        }
        for (Map.Entry<String, Object> entry : c2.entrySet()) {
            try {
                if (com.anythink.core.common.k.h.a(com.anythink.core.common.b.n.a().g(), entry.getValue().toString())) {
                    this.d.put(entry.getKey(), "1");
                    this.f6862a.a(entry.getKey());
                }
            } catch (Throwable th) {
            }
        }
        com.anythink.core.common.k.p.a(com.anythink.core.common.b.n.a().g(), com.anythink.core.common.b.g.o, g.o.p, b() + c2.size());
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.n.1
            @Override // java.lang.Runnable
            public final void run() {
                n.this.f6862a.c();
            }
        });
    }

    public final JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, String> entry : this.d.entrySet()) {
            try {
                jSONArray.put(Long.parseLong(entry.getKey()));
            } catch (Throwable th) {
            }
        }
        return jSONArray;
    }
}
