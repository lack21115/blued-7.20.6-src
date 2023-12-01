package com.igexin.push.f;

import android.content.Context;
import com.igexin.assist.sdk.AssistPushConsts;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/f/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23637a = "com.igexin.assist.control.stp.ManufacturePushManager";

    public static boolean a(Context context) {
        try {
            Method declaredMethod = Class.forName(f23637a).getDeclaredMethod("checkDevice", Context.class);
            declaredMethod.setAccessible(true);
            boolean booleanValue = ((Boolean) declaredMethod.invoke(null, context)).booleanValue();
            com.igexin.c.a.c.a.b("Assist_UPS", "isSupportStp: ".concat(String.valueOf(booleanValue)));
            return booleanValue;
        } catch (Exception e) {
            e.getMessage();
            try {
                Class<?> cls = Class.forName(f23637a);
                Object newInstance = cls.getConstructor(Context.class).newInstance(context);
                Method declaredMethod2 = cls.getDeclaredMethod("isSupport", new Class[0]);
                declaredMethod2.setAccessible(true);
                com.igexin.c.a.c.a.b("Assist_UPS", "isSupportStp: ".concat(String.valueOf(((Boolean) declaredMethod2.invoke(newInstance, new Object[0])).booleanValue())));
                return false;
            } catch (Exception e2) {
                return false;
            }
        }
    }

    public static boolean a(Context context, String str) {
        String concat = AssistPushConsts.LOG_TAG.concat(String.valueOf(str));
        boolean z = false;
        try {
            StringBuilder sb = new StringBuilder("com.igexin.assist.control.");
            sb.append(str);
            sb.append(".ManufacturePushManager");
            Class<?> cls = Class.forName(sb.toString());
            Object newInstance = cls.getConstructor(Context.class).newInstance(context);
            Field declaredField = cls.getDeclaredField("context");
            boolean isAccessible = declaredField.isAccessible();
            declaredField.setAccessible(true);
            declaredField.set(newInstance, context);
            declaredField.setAccessible(isAccessible);
            boolean booleanValue = ((Boolean) cls.getDeclaredMethod("isSupport", new Class[0]).invoke(newInstance, new Object[0])).booleanValue();
            StringBuilder sb2 = new StringBuilder("isSupport ");
            sb2.append(str);
            sb2.append(" = ");
            sb2.append(booleanValue);
            z = booleanValue;
            com.igexin.c.a.c.a.e.a(concat, sb2.toString());
            return booleanValue;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.e.a(concat, "class non-existent  " + th.getMessage());
            return z;
        }
    }
}
