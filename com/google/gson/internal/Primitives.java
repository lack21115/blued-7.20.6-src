package com.google.gson.internal;

import java.lang.reflect.Type;

/* loaded from: source-8110460-dex2jar.jar:com/google/gson/internal/Primitives.class */
public final class Primitives {
    private Primitives() {
    }

    public static boolean isPrimitive(Type type) {
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    public static boolean isWrapperType(Type type) {
        return type == Integer.class || type == Float.class || type == Byte.class || type == Double.class || type == Long.class || type == Character.class || type == Boolean.class || type == Short.class || type == Void.class;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Class<T> unwrap(Class<T> cls) {
        if (cls == Integer.class) {
            return (Class<T>) Integer.TYPE;
        }
        if (cls == Float.class) {
            return (Class<T>) Float.TYPE;
        }
        if (cls == Byte.class) {
            return (Class<T>) Byte.TYPE;
        }
        if (cls == Double.class) {
            return (Class<T>) Double.TYPE;
        }
        if (cls == Long.class) {
            return (Class<T>) Long.TYPE;
        }
        if (cls == Character.class) {
            return (Class<T>) Character.TYPE;
        }
        if (cls == Boolean.class) {
            return (Class<T>) Boolean.TYPE;
        }
        if (cls == Short.class) {
            return (Class<T>) Short.TYPE;
        }
        Class cls2 = cls;
        if (cls == Void.class) {
            cls2 = Void.TYPE;
        }
        return cls2;
    }

    public static <T> Class<T> wrap(Class<T> cls) {
        if (cls == Integer.TYPE) {
            return Integer.class;
        }
        if (cls == Float.TYPE) {
            return Float.class;
        }
        if (cls == Byte.TYPE) {
            return Byte.class;
        }
        if (cls == Double.TYPE) {
            return Double.class;
        }
        if (cls == Long.TYPE) {
            return Long.class;
        }
        if (cls == Character.TYPE) {
            return Character.class;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.class;
        }
        if (cls == Short.TYPE) {
            return Short.class;
        }
        Class<T> cls2 = cls;
        if (cls == Void.TYPE) {
            cls2 = Void.class;
        }
        return cls2;
    }
}
