package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/f0.class */
public final class f0 {
    public static f0 b;

    /* renamed from: a  reason: collision with root package name */
    public volatile Map<String, g0> f22741a = new HashMap();

    public static f0 a() {
        if (b == null) {
            b();
        }
        return b;
    }

    public static void b() {
        synchronized (f0.class) {
            try {
                if (b == null) {
                    b = new f0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final g0 a(String str) {
        if (!this.f22741a.containsKey(str)) {
            this.f22741a.put(str, new g0());
        }
        return this.f22741a.get(str);
    }

    public g0 a(String str, long j) {
        g0 a2 = a(str);
        a2.a(j);
        return a2;
    }
}
