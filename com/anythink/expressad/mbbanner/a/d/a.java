package com.anythink.expressad.mbbanner.a.d;

import android.content.Context;
import android.os.Handler;
import com.anythink.core.common.b.n;
import com.anythink.expressad.mbbanner.a.b.d;
import com.anythink.expressad.mbbanner.a.b.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/mbbanner/a/d/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8021a = a.class.getSimpleName();
    private static volatile a h;
    private Context b = n.a().g();

    /* renamed from: c  reason: collision with root package name */
    private com.anythink.expressad.mbbanner.a.e.a f8022c = new com.anythink.expressad.mbbanner.a.e.a();
    private Map<String, e> d = new ConcurrentHashMap();
    private Map<String, Boolean> e = new ConcurrentHashMap();
    private Map<String, Handler> f = new ConcurrentHashMap();
    private Map<String, Integer> g = new ConcurrentHashMap();

    private a() {
    }

    public static a a() {
        if (h == null) {
            synchronized (a.class) {
                try {
                    if (h == null) {
                        h = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return h;
    }

    private void a(String str, d dVar, com.anythink.expressad.mbbanner.a.c.b bVar) {
        if (this.b == null) {
            this.f8022c.a(bVar, "Banner Context == null!", str);
        } else if (dVar == null || bVar == null) {
            this.f8022c.a(bVar, "Banner request parameters or callback empty!", str);
        } else {
            Map<String, Boolean> map = this.e;
            if (map != null && map.containsKey(str) && this.e.get(str).booleanValue()) {
                this.f8022c.a(bVar, "Current unit is loading!", str);
                return;
            }
            this.e.put(str, Boolean.TRUE);
            new b(this.b, b(str), bVar, this.f8022c);
        }
    }

    private e b(String str) {
        if (this.d.containsKey(str)) {
            return this.d.get(str);
        }
        String e = com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.c c2 = com.anythink.expressad.d.b.c(e, str);
        com.anythink.expressad.d.c cVar = c2;
        if (c2 == null) {
            cVar = com.anythink.expressad.d.c.c(str);
        }
        e eVar = new e(str, "", cVar.t() * 1);
        this.d.put(str, eVar);
        return eVar;
    }

    public final void a(int i, String str) {
        int intValue = this.g.containsKey(str) ? this.g.get(str).intValue() : 0;
        if (i == 1) {
            if (this.f.containsKey(str)) {
                this.f.get(str).removeCallbacksAndMessages(null);
            }
            this.g.put(str, Integer.valueOf(i));
        } else if (i == 2) {
            if (intValue == 1) {
                if (this.f.containsKey(str)) {
                    this.f.get(str).removeCallbacksAndMessages(null);
                }
                this.g.put(str, Integer.valueOf(i));
            }
        } else if (i == 3) {
            if (intValue == 2 || intValue == 4) {
                this.g.put(str, 1);
            }
        } else if (i != 4) {
        } else {
            if (intValue == 0) {
                this.g.put(str, 0);
                return;
            }
            if (this.f.containsKey(str)) {
                this.f.get(str).removeCallbacksAndMessages(null);
            }
            this.g.put(str, Integer.valueOf(i));
        }
    }

    public final void a(String str) {
        if (this.f.containsKey(str)) {
            this.f.get(str).removeCallbacksAndMessages(null);
            this.f.remove(str);
        }
    }

    public final void a(String str, com.anythink.expressad.foundation.d.d dVar, com.anythink.expressad.mbbanner.a.c.b bVar) {
        synchronized (a()) {
            if (this.e != null && this.e.containsKey(str) && this.e.get(str).booleanValue()) {
                this.f8022c.a(bVar, "Current unit is loading!", str);
                return;
            }
            this.e.put(str, Boolean.TRUE);
            new b(this.b, b(str), bVar, this.f8022c).a(str, dVar, new com.anythink.expressad.mbbanner.a.c.d() { // from class: com.anythink.expressad.mbbanner.a.d.a.1
                @Override // com.anythink.expressad.mbbanner.a.c.d
                public final void a(String str2) {
                    synchronized (a.a()) {
                        a.this.e.put(str2, Boolean.FALSE);
                    }
                }
            });
        }
    }

    public final void b() {
        Map<String, e> map = this.d;
        if (map != null) {
            map.clear();
        }
        Map<String, Boolean> map2 = this.e;
        if (map2 != null) {
            map2.clear();
        }
        Map<String, Handler> map3 = this.f;
        if (map3 != null) {
            for (Map.Entry<String, Handler> entry : map3.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().removeCallbacksAndMessages(null);
                }
            }
            this.f.clear();
        }
        Map<String, Integer> map4 = this.g;
        if (map4 != null) {
            map4.clear();
        }
    }
}
