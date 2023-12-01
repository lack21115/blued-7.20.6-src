package org.repackage.com.miui.deviceid;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: source-3503164-dex2jar.jar:org/repackage/com/miui/deviceid/IdentifierManager.class */
public class IdentifierManager {

    /* renamed from: a  reason: collision with root package name */
    private static Object f44114a;
    private static Class<?> b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f44115c;
    private static Method d;
    private static Method e;
    private static Method f;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            f44114a = cls.newInstance();
            f44115c = b.getMethod("getUDID", Context.class);
            d = b.getMethod("getOAID", Context.class);
            e = b.getMethod("getVAID", Context.class);
            f = b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e("IdentifierManager", "reflect exception!", e2);
        }
    }

    public static String a(Context context) {
        return a(context, d);
    }

    private static String a(Context context, Method method) {
        Object obj = f44114a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e2) {
            Log.e("IdentifierManager", "invoke exception!", e2);
            return null;
        }
    }

    public static boolean a() {
        return (b == null || f44114a == null) ? false : true;
    }
}
