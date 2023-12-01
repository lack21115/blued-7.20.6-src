package com.tencent.turingface.sdk.mfa;

import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/QafBz.class */
public final class QafBz {

    /* renamed from: a  reason: collision with root package name */
    public static Object f26218a;
    public static Method b;

    static {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
                Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
                Method method = (Method) declaredMethod2.invoke(cls, "getRuntime", null);
                b = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
                f26218a = method.invoke(null, new Object[0]);
            } catch (Throwable th) {
            }
        }
    }
}
