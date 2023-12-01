package com.tencent.cloud.huiyansdkface.analytics;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/analytics/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21810a = c.class.getSimpleName();
    private static String b = "";

    /* renamed from: c  reason: collision with root package name */
    private static DisplayMetrics f21811c = null;

    public static String a() {
        try {
            return TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(Context context) {
        return context.getPackageName();
    }

    public static boolean a(Object... objArr) {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= 3) {
                break;
            }
            Object obj = objArr[i2];
            int i4 = i;
            if (obj != null) {
                i4 = i + obj.toString().length();
            }
            i2++;
            i3 = i4;
        }
        return i > 61440;
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(b)) {
            try {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                b = str;
                if (str == null) {
                    return "";
                }
            } catch (Throwable th) {
                th.printStackTrace();
                WBSLogger.e(f21810a, th.getMessage(), new Object[0]);
            }
            return b;
        }
        return b;
    }

    public static DisplayMetrics c(Context context) {
        if (f21811c == null) {
            f21811c = new DisplayMetrics();
            ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(f21811c);
        }
        return f21811c;
    }

    public static String d(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        String country = locale.getCountry();
        return language + "_" + country;
    }
}
