package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.at;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Calendar;
import java.util.Date;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/utils/c.class */
public class c {
    private static final String b = "lastReqTime";

    /* renamed from: c  reason: collision with root package name */
    private static final int f27274c = 48;
    private static final int d = 1;
    private static final int e = 720;
    private static final String f = "iss";
    private static final String g = "sinr";
    private static final String h = "clean";
    private static boolean i;
    private static int j;

    /* renamed from: a  reason: collision with root package name */
    private static final String f27273a = at.b().b(at.z);
    private static Object k = new Object();

    static {
        i = false;
        j = 720;
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(appContext, f, "");
            if (TextUtils.isEmpty(imprintProperty) || !"1".equals(imprintProperty)) {
                return;
            }
            synchronized (k) {
                i = true;
            }
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(appContext, g, "");
            if (TextUtils.isEmpty(imprintProperty)) {
                j = 48;
                return;
            }
            try {
                j = a(Integer.parseInt(imprintProperty2));
            } catch (Throwable th) {
                j = 48;
            }
        }
    }

    private static int a(int i2) {
        if (i2 > 720) {
            return 720;
        }
        if (i2 < 1) {
            return 1;
        }
        return i2;
    }

    public static int a(Context context) {
        int i2;
        synchronized (k) {
            i2 = j;
        }
        return i2;
    }

    public static void a(Context context, long j2) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f27273a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(b, j2).commit();
        }
    }

    public static boolean a() {
        boolean z;
        synchronized (k) {
            z = i;
        }
        return z;
    }

    public static boolean a(long j2, long j3, int i2) {
        Date date = new Date(j3);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j2));
        calendar.add(10, i2);
        return date.after(calendar.getTime());
    }

    public static long b(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f27273a, 0);
        long j2 = 0;
        if (sharedPreferences != null) {
            j2 = sharedPreferences.getLong(b, 0L);
        }
        return j2;
    }

    public static void c(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f27273a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(h, true).commit();
        }
    }

    public static void d(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f27273a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(h, false).commit();
        }
    }

    public static boolean e(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f27273a, 0);
        if (sharedPreferences != null) {
            z = sharedPreferences.getBoolean(h, false);
        }
        return z;
    }
}
