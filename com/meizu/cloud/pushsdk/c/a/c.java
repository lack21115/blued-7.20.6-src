package com.meizu.cloud.pushsdk.c.a;

import com.meizu.cloud.pushsdk.c.c.k;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/a/c.class */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f24010a;
    private final com.meizu.cloud.pushsdk.c.b.a b;

    /* renamed from: c  reason: collision with root package name */
    private k f24011c;

    public c(com.meizu.cloud.pushsdk.c.b.a aVar) {
        this.f24010a = null;
        this.b = aVar;
    }

    public c(T t) {
        this.f24010a = t;
        this.b = null;
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.c.b.a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public T a() {
        return this.f24010a;
    }

    public void a(k kVar) {
        this.f24011c = kVar;
    }

    public boolean b() {
        return this.b == null;
    }

    public com.meizu.cloud.pushsdk.c.b.a c() {
        return this.b;
    }
}
