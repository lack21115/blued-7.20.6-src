package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/e/d.class */
public final class d {
    private static c a(String str) {
        try {
            if (com.alipay.security.mobile.module.a.a.a(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            return new c(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("timestamp"), jSONObject.optString("tid"), jSONObject.optString(com.alipay.sdk.cons.b.g));
        } catch (Exception e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
            return null;
        }
    }

    public static void a() {
        synchronized (d.class) {
        }
    }

    public static void a(Context context) {
        synchronized (d.class) {
            try {
                com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", "");
                com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4", "");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Context context, c cVar) {
        synchronized (d.class) {
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("apdid", cVar.f4551a);
                    jSONObject.put("deviceInfoHash", cVar.b);
                    jSONObject.put("timestamp", cVar.f4552c);
                    jSONObject.put("tid", cVar.d);
                    jSONObject.put(com.alipay.sdk.cons.b.g, cVar.e);
                    String jSONObject2 = jSONObject.toString();
                    com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", jSONObject2);
                    com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4", jSONObject2);
                } catch (Exception e) {
                    com.alipay.apmobilesecuritysdk.c.a.a(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static c b() {
        synchronized (d.class) {
            try {
                String a2 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4");
                if (com.alipay.security.mobile.module.a.a.a(a2)) {
                    return null;
                }
                return a(a2);
            } finally {
            }
        }
    }

    public static c b(Context context) {
        c a2;
        synchronized (d.class) {
            try {
                String a3 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
                String str = a3;
                if (com.alipay.security.mobile.module.a.a.a(a3)) {
                    str = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4");
                }
                a2 = a(str);
            } catch (Throwable th) {
                throw th;
            }
        }
        return a2;
    }

    public static c c(Context context) {
        synchronized (d.class) {
            try {
                String a2 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
                if (com.alipay.security.mobile.module.a.a.a(a2)) {
                    return null;
                }
                return a(a2);
            } finally {
            }
        }
    }
}
