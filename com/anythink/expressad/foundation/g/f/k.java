package com.anythink.expressad.foundation.g.f;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/k.class */
public final class k<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f5086a;
    public com.anythink.expressad.foundation.g.f.a.a b;

    /* renamed from: c  reason: collision with root package name */
    public com.anythink.expressad.foundation.g.f.f.c f5087c;

    private k(com.anythink.expressad.foundation.g.f.a.a aVar) {
        this.f5086a = null;
        this.b = null;
        this.f5087c = null;
        this.b = aVar;
    }

    private k(T t, com.anythink.expressad.foundation.g.f.f.c cVar) {
        this.f5086a = null;
        this.b = null;
        this.f5087c = null;
        this.f5086a = t;
        this.f5087c = cVar;
    }

    public static <T> k<T> a(com.anythink.expressad.foundation.g.f.a.a aVar) {
        return new k<>(aVar);
    }

    public static <T> k<T> a(T t, com.anythink.expressad.foundation.g.f.f.c cVar) {
        return new k<>(t, cVar);
    }

    private boolean a() {
        return this.b == null;
    }
}
