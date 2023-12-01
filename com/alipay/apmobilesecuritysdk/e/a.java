package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/e/a.class */
public final class a {
    private static b a(String str) {
        try {
            if (com.alipay.security.mobile.module.a.a.a(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            return new b(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("timestamp"));
        } catch (Exception e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
            return null;
        }
    }

    public static void a() {
        synchronized (a.class) {
        }
    }

    public static void a(Context context) {
        synchronized (a.class) {
            try {
                com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid", "");
                com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx", "");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Context context, b bVar) {
        synchronized (a.class) {
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("apdid", bVar.f4549a);
                    jSONObject.put("deviceInfoHash", bVar.b);
                    jSONObject.put("timestamp", bVar.f4550c);
                    String jSONObject2 = jSONObject.toString();
                    com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid", jSONObject2);
                    com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx", jSONObject2);
                } catch (Exception e) {
                    com.alipay.apmobilesecuritysdk.c.a.a(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static b b() {
        synchronized (a.class) {
            try {
                String a2 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx");
                if (com.alipay.security.mobile.module.a.a.a(a2)) {
                    return null;
                }
                return a(a2);
            } finally {
            }
        }
    }

    public static b b(Context context) {
        b a2;
        synchronized (a.class) {
            try {
                String a3 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid");
                String str = a3;
                if (com.alipay.security.mobile.module.a.a.a(a3)) {
                    str = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx");
                }
                a2 = a(str);
            } catch (Throwable th) {
                throw th;
            }
        }
        return a2;
    }

    public static b c(Context context) {
        synchronized (a.class) {
            try {
                String a2 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid");
                if (com.alipay.security.mobile.module.a.a.a(a2)) {
                    return null;
                }
                return a(a2);
            } finally {
            }
        }
    }
}
