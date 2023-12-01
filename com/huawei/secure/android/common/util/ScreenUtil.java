package com.huawei.secure.android.common.util;

import android.app.Activity;
import android.view.Window;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/util/ScreenUtil.class */
public class ScreenUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9543a = "ScreenUtil";
    private static final int b = 524288;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/util/ScreenUtil$a.class */
    static class a implements PrivilegedAction {

        /* renamed from: a  reason: collision with root package name */
        Method f9544a;

        public a(Method method) {
            this.f9544a = method;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            Method method = this.f9544a;
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            return null;
        }
    }

    private static void a(Activity activity, int i) {
        if (activity == null || activity.isFinishing()) {
            LogsUtil.e("", "activity is null");
        } else {
            activity.getWindow().addFlags(i);
        }
    }

    private static void b(Activity activity, int i) {
        if (activity == null || activity.isFinishing()) {
            LogsUtil.e("", "activity is null");
        } else {
            activity.getWindow().clearFlags(i);
        }
    }

    public static void disableScreenshots(Activity activity) {
        a(activity, 8192);
    }

    public static void enableScreenshots(Activity activity) {
        b(activity, 8192);
    }

    public static void hideOverlayWindows(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            Window window = activity.getWindow();
            Method declaredMethod = Class.forName("android.view.Window").getDeclaredMethod("addPrivateFlags", Integer.TYPE);
            AccessController.doPrivileged(new a(declaredMethod));
            declaredMethod.invoke(window, 524288);
        } catch (ClassNotFoundException e) {
            LogsUtil.e(f9543a, "hideOverlayWindows ClassNotFoundException");
        } catch (IllegalAccessException e2) {
            LogsUtil.e(f9543a, "hideOverlayWindows IllegalAccessException");
        } catch (NoSuchMethodException e3) {
            LogsUtil.e(f9543a, "hideOverlayWindows NoSuchMethodException");
        } catch (InvocationTargetException e4) {
            LogsUtil.e(f9543a, "hideOverlayWindows InvocationTargetException");
        }
    }
}
