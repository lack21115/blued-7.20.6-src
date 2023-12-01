package com.google.common.reflect;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/reflect/AbstractInvocationHandler.class */
public abstract class AbstractInvocationHandler implements InvocationHandler {
    private static final Object[] NO_ARGS = new Object[0];

    private static boolean isProxyOfSameInterfaces(Object obj, Class<?> cls) {
        if (cls.isInstance(obj)) {
            return true;
        }
        return Proxy.isProxyClass(obj.getClass()) && Arrays.equals(obj.getClass().getInterfaces(), cls.getInterfaces());
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    protected abstract Object handleInvocation(Object obj, Method method, Object[] objArr) throws Throwable;

    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, @NullableDecl Object[] objArr) throws Throwable {
        Object[] objArr2 = objArr;
        if (objArr == null) {
            objArr2 = NO_ARGS;
        }
        if (objArr2.length == 0 && method.getName().equals(TTDownloadField.TT_HASHCODE)) {
            return Integer.valueOf(hashCode());
        }
        boolean z = true;
        if (objArr2.length != 1 || !method.getName().equals("equals") || method.getParameterTypes()[0] != Object.class) {
            return (objArr2.length == 0 && method.getName().equals("toString")) ? toString() : handleInvocation(obj, method, objArr2);
        }
        Object obj2 = objArr2[0];
        if (obj2 == null) {
            return false;
        }
        if (obj == obj2) {
            return true;
        }
        if (!isProxyOfSameInterfaces(obj2, obj.getClass()) || !equals(Proxy.getInvocationHandler(obj2))) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public String toString() {
        return super.toString();
    }
}
