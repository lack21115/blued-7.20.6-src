package org.repackage.com.meizu.flyme.openidsdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: source-3503164-dex2jar.jar:org/repackage/com/meizu/flyme/openidsdk/OpenIdHelper.class */
public class OpenIdHelper {

    /* renamed from: a  reason: collision with root package name */
    private static Method f44108a;

    public static String a(Context context) {
        b a2 = b.a();
        return a2.a(context.getApplicationContext(), a2.b);
    }

    public static final boolean a() {
        Context context = null;
        try {
            if (f44108a == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                f44108a = method;
                method.setAccessible(true);
            }
            context = (Context) f44108a.invoke(null, new Object[0]);
        } catch (Exception e) {
            Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + e.toString());
        }
        if (context == null) {
            return false;
        }
        return b.a().a(context, false);
    }
}
