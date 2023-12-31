package com.alipay.apmobilesecuritysdk.c;

import android.content.Context;
import android.os.Build;
import com.alipay.security.mobile.module.d.d;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/c/a.class */
public final class a {
    public static void a(Context context, String str, String str2, String str3) {
        synchronized (a.class) {
            try {
                com.alipay.security.mobile.module.d.a b = b(context, str, str2, str3);
                d.a(context.getFilesDir().getAbsolutePath() + "/log/ap", new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + com.anythink.china.common.a.a.f, b.toString());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(String str) {
        synchronized (a.class) {
            try {
                d.a(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Throwable th) {
        synchronized (a.class) {
            try {
                d.a(th);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static com.alipay.security.mobile.module.d.a b(Context context, String str, String str2, String str3) {
        String str4;
        try {
            str4 = context.getPackageName();
        } catch (Throwable th) {
            str4 = "";
        }
        return new com.alipay.security.mobile.module.d.a(Build.MODEL, str4, "APPSecuritySDK-ALIPAYSDK", "3.4.0.201910161639", str, str2, str3);
    }
}
