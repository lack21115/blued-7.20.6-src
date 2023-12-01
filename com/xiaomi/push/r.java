package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/r.class */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private static Context f27874a;

    /* renamed from: a  reason: collision with other field name */
    private static String f858a;

    public static int a() {
        try {
            Class<?> a2 = a(null, "miui.os.Build");
            if (a2.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return a2.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception e) {
            return 0;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Context m9016a() {
        return f27874a;
    }

    public static Class<?> a(Context context, String str) {
        if (str == null || str.trim().length() == 0) {
            throw new ClassNotFoundException("class is empty");
        }
        boolean z = context != null;
        if (z && Build.VERSION.SDK_INT >= 29) {
            try {
                return context.getClassLoader().loadClass(str);
            } catch (Throwable th) {
            }
        }
        try {
            return Class.forName(str);
        } catch (Throwable th2) {
            com.xiaomi.channel.commonutils.logger.b.m8344a(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), th2.getLocalizedMessage()));
            throw new ClassNotFoundException("loadClass fail ", th2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m9017a() {
        synchronized (r.class) {
            try {
                if (f858a != null) {
                    return f858a;
                }
                String str = Build.VERSION.INCREMENTAL;
                String str2 = str;
                if (a() <= 0) {
                    str2 = b();
                    if (TextUtils.isEmpty(str2)) {
                        str2 = c();
                        if (TextUtils.isEmpty(str2)) {
                            str2 = d();
                            if (TextUtils.isEmpty(str2)) {
                                str2 = String.valueOf(q.a("ro.product.brand", "Android") + "_" + str);
                            }
                        }
                    }
                }
                f858a = str2;
                return str2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Context context) {
        f27874a = context.getApplicationContext();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m9018a() {
        return TextUtils.equals((String) bi.a("android.os.SystemProperties", MonitorConstants.CONNECT_TYPE_GET, "sys.boot_completed"), "1");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m9019a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    private static String b() {
        String a2 = q.a("ro.build.version.emui", "");
        f858a = a2;
        return a2;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m9020b() {
        try {
            return a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(Boolean.FALSE);
        } catch (ClassNotFoundException e) {
            com.xiaomi.channel.commonutils.logger.b.d("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return false;
        }
    }

    private static String c() {
        String a2 = q.a("ro.build.version.opporom", "");
        if (!TextUtils.isEmpty(a2) && !a2.startsWith("ColorOS_")) {
            f858a = "ColorOS_".concat(String.valueOf(a2));
        }
        return f858a;
    }

    private static String d() {
        String a2 = q.a("ro.vivo.os.version", "");
        if (!TextUtils.isEmpty(a2) && !a2.startsWith("FuntouchOS_")) {
            f858a = "FuntouchOS_".concat(String.valueOf(a2));
        }
        return f858a;
    }
}
