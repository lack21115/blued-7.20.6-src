package com.anythink.expressad.foundation.g.f;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/k.class */
public final class k<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f7926a;
    public com.anythink.expressad.foundation.g.f.a.a b;

    /* renamed from: c  reason: collision with root package name */
    public com.anythink.expressad.foundation.g.f.f.c f7927c;

    private k(com.anythink.expressad.foundation.g.f.a.a aVar) {
        this.f7926a = null;
        this.b = null;
        this.f7927c = null;
        this.b = aVar;
    }

    private k(T t, com.anythink.expressad.foundation.g.f.f.c cVar) {
        this.f7926a = null;
        this.b = null;
        this.f7927c = null;
        this.f7926a = t;
        this.f7927c = cVar;
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
