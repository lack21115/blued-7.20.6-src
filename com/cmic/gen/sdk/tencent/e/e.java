package com.cmic.gen.sdk.tencent.e;

import com.cmic.gen.sdk.tencent.auth.GenTokenListener;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/e/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap<String, GenTokenListener> f8054a = new ConcurrentHashMap<>(16);
    private static ConcurrentHashMap<String, com.cmic.gen.sdk.tencent.a> b = new ConcurrentHashMap<>();

    public static void a(String str, com.cmic.gen.sdk.tencent.a aVar) {
        if (str == null || aVar == null) {
            return;
        }
        b.put(str, aVar);
    }

    public static void a(String str, GenTokenListener genTokenListener) {
        f8054a.put(str, genTokenListener);
    }

    public static boolean a() {
        return f8054a.isEmpty();
    }

    public static boolean a(String str) {
        return !f8054a.containsKey(str);
    }

    public static void b(String str) {
        f8054a.remove(str);
    }

    public static GenTokenListener c(String str) {
        return f8054a.get(str);
    }

    public static com.cmic.gen.sdk.tencent.a d(String str) {
        return str != null ? b.get(str) : new com.cmic.gen.sdk.tencent.a(0);
    }
}
