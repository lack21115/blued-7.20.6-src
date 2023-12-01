package com.tencent.mapsdk.internal;

import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/o.class */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, String> f37672a = new HashMap<>();

    private o() {
    }

    public static String a(String str) {
        return f37672a.get(str);
    }

    public static <T extends p> void a(Class<T> cls) {
        try {
            T newInstance = cls.newInstance();
            if (newInstance != null) {
                String className = newInstance.className();
                String str = className;
                if ("".equals(className)) {
                    str = cls.getName();
                }
                f37672a.put(str, cls.getName());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        }
    }
}
