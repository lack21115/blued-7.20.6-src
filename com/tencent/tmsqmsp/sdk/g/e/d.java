package com.tencent.tmsqmsp.sdk.g.e;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/e/d.class */
public class d {
    public static String a(Context context) {
        c a2 = c.a();
        return a2.a(context.getApplicationContext(), a2.f26094c);
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
        return c.a().a(context, false);
    }

    public static String b(Context context) {
        c a2 = c.a();
        return a2.a(context.getApplicationContext(), a2.b);
    }
}
