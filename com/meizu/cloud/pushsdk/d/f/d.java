package com.meizu.cloud.pushsdk.d.f;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/d/f/d.class */
public final class d {
    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static <T> T a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }
}
