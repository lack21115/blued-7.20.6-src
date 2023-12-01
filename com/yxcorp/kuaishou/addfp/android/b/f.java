package com.yxcorp.kuaishou.addfp.android.b;

import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/yxcorp/kuaishou/addfp/android/b/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static Object f28169a;
    private static Method b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f28170c = 0;

    static {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
                Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
                Method method = (Method) declaredMethod2.invoke(cls, "getRuntime", null);
                b = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
                f28169a = method.invoke(null, new Object[0]);
            } catch (Throwable th) {
            }
        }
    }

    public static boolean a() {
        Method method;
        Object obj = f28169a;
        if (obj == null || (method = b) == null) {
            return false;
        }
        try {
            method.invoke(obj, new String[]{"L"});
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
