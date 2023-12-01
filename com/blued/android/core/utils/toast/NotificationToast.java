package com.blued.android.core.utils.toast;

import android.app.Application;
import android.widget.Toast;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/NotificationToast.class */
public class NotificationToast extends SystemToast {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f9753a;

    public NotificationToast(Application application) {
        super(application);
    }

    private static void a() {
        if (f9753a) {
            return;
        }
        f9753a = true;
        try {
            Method declaredMethod = Toast.class.getDeclaredMethod("getService", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke == null) {
                return;
            }
            if (Proxy.isProxyClass(invoke.getClass()) && (Proxy.getInvocationHandler(invoke) instanceof NotificationServiceProxy)) {
                return;
            }
            Object newProxyInstance = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Class.forName("android.app.INotificationManager")}, new NotificationServiceProxy(invoke));
            Field declaredField = Toast.class.getDeclaredField("sService");
            declaredField.setAccessible(true);
            declaredField.set(null, newProxyInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.Toast, com.blued.android.core.utils.toast.config.IToast
    public void show() {
        a();
        super.show();
    }
}
