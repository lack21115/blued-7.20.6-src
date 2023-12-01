package com.tencent.qmsp.oaid2;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/y.class */
public class y {
    public static String a(Context context) {
        x a2 = x.a();
        return a2.a(context.getApplicationContext(), a2.f24819c);
    }

    public static final boolean a() {
        Context context = null;
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
            method.setAccessible(true);
            context = (Context) method.invoke(null, new Object[0]);
        } catch (Exception e) {
            Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + e.toString());
        }
        if (context == null) {
            return false;
        }
        return x.a().a(context, false);
    }

    public static String b(Context context) {
        x a2 = x.a();
        return a2.a(context.getApplicationContext(), a2.b);
    }
}
