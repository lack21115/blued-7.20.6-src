package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/ag.class */
public class ag {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10110a = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=";
    private final String b = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy";

    /* renamed from: c  reason: collision with root package name */
    private final String f10111c = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl";
    private final String d = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==";
    private final String e = "SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=";

    private void a(JSONObject jSONObject, int i) {
        Object a2;
        try {
            Object a3 = Build.VERSION.SDK_INT >= 26 ? dg.a(new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy".getBytes(), 2)), "IActivityManagerSingleton") : dg.a(new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl".getBytes(), 2)), "gDefault");
            if (a3 == null || (a2 = dg.a("android.util.Singleton", a3, MonitorConstants.CONNECT_TYPE_GET, new Object[0])) == null) {
                return;
            }
            a(a2, jSONObject, i);
        } catch (Exception e) {
        }
    }

    private boolean a(Object obj, JSONObject jSONObject, int i) {
        StringBuilder sb;
        if (jSONObject != null) {
            try {
                boolean isProxyClass = Proxy.isProxyClass(obj.getClass());
                String name = obj.getClass().getName();
                int i2 = 1;
                if (isProxyClass) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i);
                    String sb3 = sb2.toString();
                    if (!isProxyClass) {
                        i2 = 0;
                    }
                    jSONObject.put(sb3, i2);
                    sb = new StringBuilder();
                    sb.append(i);
                    sb.append("-c");
                } else if (i != 3 || name.contains("Instrumentation")) {
                    return isProxyClass;
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(i);
                    jSONObject.put(sb4.toString(), isProxyClass ? 1 : 0);
                    sb = new StringBuilder();
                    sb.append(i);
                    sb.append("-c");
                }
                jSONObject.put(sb.toString(), name);
                return isProxyClass;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    private void b(JSONObject jSONObject, int i) {
        try {
            Object a2 = dg.a(new String(c.a(f10110a.getBytes(), 2)), (Object) null, "getPackageManager", new Object[0]);
            if (a2 != null) {
                a(a2, jSONObject, i);
            }
        } catch (Exception e) {
        }
    }

    private void c(JSONObject jSONObject, int i) {
        Object a2;
        Object a3;
        try {
            if (Build.VERSION.SDK_INT < 29 || (a2 = dg.a(new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==".getBytes(), 2)), new String(c.a("SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=".getBytes(), 2)))) == null || (a3 = dg.a("android.util.Singleton", a2, MonitorConstants.CONNECT_TYPE_GET, new Object[0])) == null) {
                return;
            }
            a(a3, jSONObject, i);
        } catch (Exception e) {
        }
    }

    private void d(JSONObject jSONObject, int i) {
        Object a2;
        try {
            Object a3 = dg.a(new String(c.a(f10110a.getBytes(), 2)), (Object) null, "currentActivityThread", new Object[0]);
            if (a3 == null || (a2 = dg.a(a3.getClass(), a3, "mInstrumentation")) == null) {
                return;
            }
            a(a2, jSONObject, i);
        } catch (Exception e) {
        }
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            b(jSONObject, 0);
            a(jSONObject, 1);
            c(jSONObject, 2);
            d(jSONObject, 3);
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            PackageManager packageManager = context.getPackageManager();
            Object a2 = dg.a(packageManager.getClass(), packageManager, "mPM");
            if (a2 != null) {
                if (a(a2, jSONObject, 0)) {
                    return jSONObject;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
