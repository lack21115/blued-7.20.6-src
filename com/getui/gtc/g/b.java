package com.getui.gtc.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.getui.gtc.BuildConfig;
import com.igexin.push.GtPushInterface;
import com.igexin.push.core.g;
import com.kuaishou.weapon.p0.t;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/g/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, ClassLoader> f8409a = new HashMap();

    public static ClassLoader a(Bundle bundle) {
        return f8409a.get(bundle.getString(AdvanceSetting.CLEAR_NOTIFICATION));
    }

    public static void a(Context context, ClassLoader classLoader, String str, String str2, String str3) throws Throwable {
        Class<?> loadClass = classLoader.loadClass(str);
        com.getui.gtc.i.c.a.a("start load for class:" + str + ", appId: " + str2 + ", cid: " + str3);
        loadClass.getDeclaredMethod("onCreate", Context.class, String.class, String.class).invoke(loadClass.newInstance(), context, str2, str3);
        com.getui.gtc.i.c.a.a("load success for class:".concat(String.valueOf(str)));
        f8409a.put(str, classLoader);
    }

    public static void a(Context context, String str, String str2, String str3) throws Throwable {
        a(context, context.getClassLoader(), str, str2, str3);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) throws Throwable {
        Class<?> cls = Class.forName("com.getui.gtc.SdkLoader");
        Method declaredMethod = cls.getDeclaredMethod("load", Context.class, String.class, String.class, String.class, String.class, String.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(cls, context, str, str2, str3, str4, str5);
    }

    public static void a(Context context, final String str, final String str2, final String str3, final String str4, final String str5, com.getui.gtc.g.a.b bVar) {
        final com.getui.gtc.g.a.a aVar = new com.getui.gtc.g.a.a(bVar);
        if (aVar.b != null) {
            aVar.a(str, str2, str3, str4, str5);
            return;
        }
        try {
            Class<?> cls = com.getui.gtc.g.a.a.a(context, Class.forName(g.f)).second;
            Class<?> cls2 = cls;
            if (cls == null) {
                cls2 = Class.forName(g.f);
            }
            Intent intent = new Intent(context, cls2);
            intent.setType(BuildConfig.VERSION_NAME);
            context.bindService(intent, new ServiceConnection() { // from class: com.getui.gtc.g.a.a.2
                @Override // android.content.ServiceConnection
                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    a.this.b = GtPushInterface.Stub.asInterface(iBinder);
                    a.this.a(str, str2, str3, str4, str5);
                }

                @Override // android.content.ServiceConnection
                public final void onServiceDisconnected(ComponentName componentName) {
                    a.this.b = null;
                }
            }, 1);
        } catch (Exception e) {
            com.getui.gtc.i.c.a.b(e);
        }
    }

    public static boolean a(Context context, Bundle bundle) {
        try {
            String string = bundle.getString(t.q);
            String string2 = bundle.getString("ad");
            String string3 = bundle.getString("gd");
            String string4 = bundle.getString("od");
            String string5 = bundle.getString(AdvanceSetting.CLEAR_NOTIFICATION);
            if (string == null) {
                a(context, string5, string2, string3);
                return true;
            }
            a(context, string, string4, string5, string2, string3);
            return true;
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th.toString());
            return false;
        }
    }
}
