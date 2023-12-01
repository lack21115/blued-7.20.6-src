package com.umeng.commonsdk;

import android.content.Context;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/UMInnerManager.class */
public class UMInnerManager {
    private static Class<?> innerImplClazz;
    private static Method sendInternalMethod;

    static {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.UMInnerImpl");
            if (cls != null) {
                innerImplClazz = cls;
                Method declaredMethod = cls.getDeclaredMethod("initAndSendInternal", Context.class);
                if (declaredMethod != null) {
                    sendInternalMethod = declaredMethod;
                }
            }
        } catch (Throwable th) {
        }
    }

    public static void sendInnerPackage(Context context) {
        Method method;
        if (context == null || !UMUtils.isMainProgress(context)) {
            return;
        }
        if (SdkVersion.SDK_TYPE == 1) {
            UMConfigureInternation.sendInternal(context);
            return;
        }
        Class<?> cls = innerImplClazz;
        if (cls == null || (method = sendInternalMethod) == null) {
            return;
        }
        try {
            method.invoke(cls, context);
        } catch (Throwable th) {
        }
    }
}
