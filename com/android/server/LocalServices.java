package com.android.server;

import android.util.ArrayMap;

/* loaded from: source-4181928-dex2jar.jar:com/android/server/LocalServices.class */
public final class LocalServices {
    private static final ArrayMap<Class<?>, Object> sLocalServiceObjects = new ArrayMap<>();

    private LocalServices() {
    }

    public static <T> void addService(Class<T> cls, T t) {
        synchronized (sLocalServiceObjects) {
            if (sLocalServiceObjects.containsKey(cls)) {
                throw new IllegalStateException("Overriding service registration");
            }
            sLocalServiceObjects.put(cls, t);
        }
    }

    public static <T> T getService(Class<T> cls) {
        T t;
        synchronized (sLocalServiceObjects) {
            t = (T) sLocalServiceObjects.get(cls);
        }
        return t;
    }
}
