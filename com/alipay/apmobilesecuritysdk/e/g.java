package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/e/g.class */
public final class g {
    public static String a(Context context, String str) {
        synchronized (g.class) {
            try {
                String a2 = com.alipay.security.mobile.module.c.e.a(context, "openapi_file_pri", "openApi" + str, "");
                if (com.alipay.security.mobile.module.a.a.a(a2)) {
                    return "";
                }
                String b = com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), a2);
                return com.alipay.security.mobile.module.a.a.a(b) ? "" : b;
            } finally {
            }
        }
    }

    public static void a() {
        synchronized (g.class) {
        }
    }

    public static void a(Context context) {
        synchronized (g.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
                if (edit != null) {
                    edit.clear();
                    edit.commit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        synchronized (g.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
                if (edit != null) {
                    edit.putString("openApi" + str, com.alipay.security.mobile.module.a.a.c.a(com.alipay.security.mobile.module.a.a.c.a(), str2));
                    edit.commit();
                }
            } catch (Throwable th) {
            }
        }
    }
}
