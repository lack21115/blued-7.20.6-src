package com.anythink.core.common;

import com.anythink.core.api.ATAdInfo;
import com.anythink.core.common.e.ad;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/v.class */
public class v {
    private static volatile v a;
    private ConcurrentHashMap<String, ad> b = new ConcurrentHashMap<>(4);

    private v() {
    }

    public static v a() {
        if (a == null) {
            synchronized (v.class) {
                try {
                    if (a == null) {
                        a = new v();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    private void a(String str, String str2, Object obj) {
        synchronized (this) {
            h(str).a(str2, obj);
        }
    }

    private ad h(String str) {
        ad adVar;
        synchronized (this) {
            ad adVar2 = this.b.get(str);
            adVar = adVar2;
            if (adVar2 == null) {
                adVar = new ad();
                this.b.put(str, adVar);
            }
        }
        return adVar;
    }

    public final Object a(String str) {
        return h(str).a();
    }

    public final String a(String str, int i) {
        return h(str).b(String.valueOf(i));
    }

    public final String a(String str, String str2) {
        return h(str).a(str2);
    }

    public final void a(String str, int i, String str2) {
        h(str).b(String.valueOf(i), str2);
    }

    public final void a(String str, ATAdInfo aTAdInfo) {
        h(str).a(aTAdInfo);
    }

    public final void a(String str, f fVar) {
        h(str).a(fVar);
    }

    public final void a(String str, String str2, String str3) {
        h(str).a(str2, str3);
    }

    public final void a(String str, Map<String, Object> map) {
        synchronized (this) {
            ConcurrentHashMap concurrentHashMap = null;
            if (map != null) {
                try {
                    concurrentHashMap = new ConcurrentHashMap(map);
                } catch (Throwable th) {
                    concurrentHashMap = null;
                }
            }
            h(str).a(concurrentHashMap);
        }
    }

    public final void a(String str, boolean z) {
        h(str).a(z);
    }

    public final void a(String str, Object[] objArr) {
        h(str).a(objArr);
    }

    public final f b(String str) {
        return h(str).b();
    }

    public final Map<String, Object> c(String str) {
        HashMap hashMap;
        synchronized (this) {
            hashMap = new HashMap(2);
            Map<String, Object> c = h(str).c();
            if (c != null) {
                hashMap.putAll(c);
            }
        }
        return hashMap;
    }

    public final com.anythink.core.common.e.d d(String str) {
        return h(str).d();
    }

    public final void e(String str) {
        h(str).a((ATAdInfo) null);
    }

    public final boolean f(String str) {
        return h(str).e();
    }

    public final String g(String str) {
        return h(str).f();
    }
}
