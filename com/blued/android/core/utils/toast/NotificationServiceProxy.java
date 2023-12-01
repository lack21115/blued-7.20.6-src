package com.blued.android.core.utils.toast;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/NotificationServiceProxy.class */
final class NotificationServiceProxy implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Object f9752a;

    public NotificationServiceProxy(Object obj) {
        this.f9752a = obj;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        boolean z;
        String name = method.getName();
        int hashCode = name.hashCode();
        if (hashCode == -1581943859) {
            if (name.equals("cancelToast")) {
                z = true;
            }
            z = true;
        } else if (hashCode != 1230397970) {
            if (hashCode == 1967758591 && name.equals("enqueueToast")) {
                z = false;
            }
            z = true;
        } else {
            if (name.equals("enqueueToastEx")) {
                z = true;
            }
            z = true;
        }
        if (!z || z || z) {
            objArr[0] = "android";
        }
        return method.invoke(this.f9752a, objArr);
    }
}
