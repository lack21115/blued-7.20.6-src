package com.efs.sdk.net.a.a;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/a/a/d.class */
public final class d {
    public static <T extends Throwable> void a(Throwable th, Class<T> cls) {
        if (cls.isInstance(th)) {
            throw th;
        }
    }
}
