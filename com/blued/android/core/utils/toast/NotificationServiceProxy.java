package com.blued.android.core.utils.toast;

import com.blued.android.chat.grpc.backup.MsgBackupManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/NotificationServiceProxy.class */
final class NotificationServiceProxy implements InvocationHandler {
    private final Object a;

    public NotificationServiceProxy(Object obj) {
        this.a = obj;
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
            objArr[0] = MsgBackupManager.PLATFORM_ANDROID;
        }
        return method.invoke(this.a, objArr);
    }
}
