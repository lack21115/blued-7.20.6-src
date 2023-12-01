package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/config/b.class */
public class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Boolean> f40842a = new HashMap();
    private static Object b = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/config/b$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f40843a = new b();

        private a() {
        }
    }

    private b() {
    }

    public static boolean a(String str) {
        if (d.a(str)) {
            synchronized (b) {
                if (f40842a.containsKey(str)) {
                    return f40842a.get(str).booleanValue();
                }
                return true;
            }
        }
        return false;
    }

    public static b b() {
        return a.f40843a;
    }

    public void a() {
        synchronized (b) {
            f40842a.clear();
        }
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (b) {
                if (f40842a != null) {
                    f40842a.put(str, bool);
                }
            }
        }
    }
}
