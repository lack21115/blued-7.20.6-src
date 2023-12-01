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
            return new b(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString(com.alipay.sdk.tid.b.f));
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
                    jSONObject.put("apdid", bVar.a);
                    jSONObject.put("deviceInfoHash", bVar.b);
                    jSONObject.put(com.alipay.sdk.tid.b.f, bVar.c);
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
                String a = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx");
                if (com.alipay.security.mobile.module.a.a.a(a)) {
                    return null;
                }
                return a(a);
            } finally {
            }
        }
    }

    public static b b(Context context) {
        b a;
        synchronized (a.class) {
            try {
                String a2 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid");
                String str = a2;
                if (com.alipay.security.mobile.module.a.a.a(a2)) {
                    str = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx");
                }
                a = a(str);
            } catch (Throwable th) {
                throw th;
            }
        }
        return a;
    }

    public static b c(Context context) {
        synchronized (a.class) {
            try {
                String a = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid");
                if (com.alipay.security.mobile.module.a.a.a(a)) {
                    return null;
                }
                return a(a);
            } finally {
            }
        }
    }
}
