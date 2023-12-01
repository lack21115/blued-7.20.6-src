package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/android/phone/mrpc/core/x.class */
public final class x {
    private g a;
    private z b = new z(this);

    public x(g gVar) {
        this.a = gVar;
    }

    public final g a() {
        return this.a;
    }

    public final <T> T a(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new y(this.a, cls, this.b));
    }
}
