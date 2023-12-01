package com.tencent.liteav.base.util;

import java.lang.ref.WeakReference;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/a.class */
public final class a<T> {
    private final InterfaceC0755a<T> b;

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal<T> f22631a = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<T> f22632c = new WeakReference<>(null);

    /* renamed from: com.tencent.liteav.base.util.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/a$a.class */
    public interface InterfaceC0755a<T> {
        T a();
    }

    public a(InterfaceC0755a<T> interfaceC0755a) {
        this.b = interfaceC0755a;
    }

    private T b() {
        T t;
        T t2 = this.f22632c.get();
        if (t2 == null) {
            synchronized (this) {
                T t3 = this.f22632c.get();
                t = t3;
                if (t3 == null) {
                    t = this.b.a();
                    this.f22632c = new WeakReference<>(t);
                }
            }
            return t;
        }
        return t2;
    }

    public final T a() {
        T t = this.f22631a.get();
        T t2 = t;
        if (t == null) {
            t2 = b();
            this.f22631a.set(t2);
        }
        return t2;
    }
}
