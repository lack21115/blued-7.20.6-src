package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/i.class */
public final class i {
    public static Map<String, m> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static i f9139c;

    /* renamed from: a  reason: collision with root package name */
    public l f9140a = new l();

    public static i c() {
        if (f9139c == null) {
            d();
        }
        return f9139c;
    }

    public static void d() {
        synchronized (i.class) {
            try {
                if (f9139c == null) {
                    f9139c = new i();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public m a(String str) {
        return b.get(str);
    }

    public Set<String> a() {
        return b.keySet();
    }

    public void a(String str, m mVar) {
        b.put(str, mVar);
    }

    public l b() {
        return this.f9140a;
    }
}
