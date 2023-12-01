package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/cc.class */
public class cc implements Serializable {
    private static Map<Class<? extends bq>, Map<? extends bx, cc>> d = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final String f26990a;
    public final byte b;

    /* renamed from: c  reason: collision with root package name */
    public final cd f26991c;

    public cc(String str, byte b, cd cdVar) {
        this.f26990a = str;
        this.b = b;
        this.f26991c = cdVar;
    }

    public static Map<? extends bx, cc> a(Class<? extends bq> cls) {
        if (!d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e.getMessage());
            } catch (InstantiationException e2) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            }
        }
        return d.get(cls);
    }

    public static void a(Class<? extends bq> cls, Map<? extends bx, cc> map) {
        d.put(cls, map);
    }
}
