package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/android/phone/mrpc/core/y.class */
public final class y implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    protected g f4541a;
    protected Class<?> b;

    /* renamed from: c  reason: collision with root package name */
    protected z f4542c;

    public y(g gVar, Class<?> cls, z zVar) {
        this.f4541a = gVar;
        this.b = cls;
        this.f4542c = zVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return this.f4542c.a(method, objArr);
    }
}
