package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/config/b.class */
public class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Boolean> f27151a = new HashMap();
    private static Object b = new Object();

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/config/b$a.class */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f27152a = new b();

        private a() {
        }
    }

    private b() {
    }

    public static boolean a(String str) {
        if (d.a(str)) {
            synchronized (b) {
                if (f27151a.containsKey(str)) {
                    return f27151a.get(str).booleanValue();
                }
                return true;
            }
        }
        return false;
    }

    public static b b() {
        return a.f27152a;
    }

    public void a() {
        synchronized (b) {
            f27151a.clear();
        }
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (b) {
                if (f27151a != null) {
                    f27151a.put(str, bool);
                }
            }
        }
    }
}
