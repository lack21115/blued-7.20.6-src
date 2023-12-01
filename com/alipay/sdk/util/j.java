package com.alipay.sdk.util;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/util/j.class */
public class j {
    private static String a;

    private static String a(Context context) {
        String str;
        if (TextUtils.isEmpty(a)) {
            try {
                str = context.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                c.a(th);
                str = "";
            }
            a = (str + "0000000000000000000000000000").substring(0, 24);
        }
        return a;
    }

    public static void a(com.alipay.sdk.sys.a aVar, Context context, String str, String str2) {
        try {
            String a2 = com.alipay.sdk.encrypt.f.a(a(context), str2, str);
            if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(a2)) {
                com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.c, com.alipay.sdk.app.statistic.c.z, String.format("%s,%s", str, str2));
            }
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, a2).apply();
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public static boolean a(Context context, String str) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(context).contains(str);
        } catch (Throwable th) {
            c.a(th);
            return false;
        }
    }

    public static String b(com.alipay.sdk.sys.a aVar, Context context, String str, String str2) {
        String str3;
        String str4 = null;
        try {
            String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
            String str5 = null;
            if (!TextUtils.isEmpty(string)) {
                str5 = com.alipay.sdk.encrypt.f.b(a(context), string, str);
            }
            String str6 = str5;
            str3 = str5;
            if (!TextUtils.isEmpty(string)) {
                String str7 = str5;
                str3 = str5;
                if (TextUtils.isEmpty(str5)) {
                    str4 = str5;
                    com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.c, com.alipay.sdk.app.statistic.c.y, String.format("%s,%s", str, string));
                    return str5;
                }
            }
        } catch (Exception e) {
            c.a(e);
            str3 = str4;
        }
        return str3;
    }

    public static void b(Context context, String str) {
        try {
            PreferenceManager.getDefaultSharedPreferences(context).edit().remove(str).apply();
        } catch (Throwable th) {
            c.a(th);
        }
    }
}
