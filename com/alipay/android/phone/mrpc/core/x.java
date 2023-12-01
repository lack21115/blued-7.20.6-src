package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/android/phone/mrpc/core/x.class */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    private g f4540a;
    private z b = new z(this);

    public x(g gVar) {
        this.f4540a = gVar;
    }

    public final g a() {
        return this.f4540a;
    }

    public final <T> T a(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new y(this.f4540a, cls, this.b));
    }
}
