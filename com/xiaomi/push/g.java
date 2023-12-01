package com.xiaomi.push;

import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ThemeConfig;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static a f27734a;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/g$a.class */
    public interface a {
        Map<String, String> a(Context context, String str);

        /* renamed from: a  reason: collision with other method in class */
        boolean m8754a(Context context, String str);

        boolean b(Context context, String str);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/g$b.class */
    public enum b {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);
        

        /* renamed from: a  reason: collision with other field name */
        private final int f454a;

        b(int i) {
            this.f454a = i;
        }

        public final int a() {
            return this.f454a;
        }
    }

    public static int a(Context context) {
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(ThemeConfig.SYSTEMUI_STATUS_BAR_PKG, 128);
                if (applicationInfo == null || applicationInfo.metaData == null) {
                    return 0;
                }
                return applicationInfo.metaData.getInt("SupportForPushVersionCode");
            } catch (PackageManager.NameNotFoundException e) {
                return 0;
            }
        }
        return 0;
    }

    public static int a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static ApplicationInfo m8746a(Context context, String str) {
        if (str.equals(context.getPackageName())) {
            return context.getApplicationInfo();
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("not found app info ".concat(String.valueOf(str)));
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Drawable m8747a(Context context, String str) {
        ApplicationInfo m8746a = m8746a(context, str);
        Drawable drawable = null;
        if (m8746a != null) {
            drawable = null;
            try {
                Drawable loadIcon = m8746a.loadIcon(context.getPackageManager());
                drawable = loadIcon;
                if (loadIcon == null) {
                    drawable = loadIcon;
                    drawable = m8746a.loadLogo(context.getPackageManager());
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m8344a("get app icon drawable failed, ".concat(String.valueOf(e)));
            }
        }
        return drawable != null ? drawable : new ColorDrawable(0);
    }

    private static b a(Context context, ApplicationInfo applicationInfo) {
        Boolean bool;
        int i = Build.VERSION.SDK_INT;
        if (applicationInfo == null || i < 24) {
            return b.UNKNOWN;
        }
        try {
            if (applicationInfo.packageName.equals(context.getPackageName())) {
                bool = Boolean.valueOf(((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled());
            } else {
                Object a2 = i >= 29 ? bi.a(context.getSystemService("notification"), "getService", new Object[0]) : context.getSystemService("security");
                bool = null;
                if (a2 != null) {
                    bool = (Boolean) bi.b(a2, "areNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid));
                }
            }
            if (bool != null) {
                return bool.booleanValue() ? b.ALLOWED : b.NOT_ALLOWED;
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("are notifications enabled error ".concat(String.valueOf(e)));
        }
        return b.UNKNOWN;
    }

    public static b a(Context context, String str, boolean z) {
        ApplicationInfo applicationInfo;
        b a2;
        if (context == null || TextUtils.isEmpty(str)) {
            return b.UNKNOWN;
        }
        try {
            applicationInfo = str.equals(context.getPackageName()) ? context.getApplicationInfo() : context.getPackageManager().getApplicationInfo(str, 0);
            a2 = a(context, applicationInfo);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("get app op error ".concat(String.valueOf(th)));
        }
        if (a2 != b.UNKNOWN) {
            return a2;
        }
        Integer num = (Integer) bi.a((Class<? extends Object>) AppOpsManager.class, "OP_POST_NOTIFICATION");
        if (num == null) {
            return b.UNKNOWN;
        }
        Integer num2 = (Integer) bi.a((Object) ((AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE)), "checkOpNoThrow", num, Integer.valueOf(applicationInfo.uid), str);
        Integer num3 = (Integer) bi.a((Class<? extends Object>) AppOpsManager.class, "MODE_ALLOWED");
        Integer num4 = (Integer) bi.a((Class<? extends Object>) AppOpsManager.class, "MODE_IGNORED");
        com.xiaomi.channel.commonutils.logger.b.b(String.format("get app mode %s|%s|%s", num2, num3, num4));
        Integer num5 = num3;
        if (num3 == null) {
            num5 = 0;
        }
        Integer num6 = num4;
        if (num4 == null) {
            num6 = 1;
        }
        if (num2 != null) {
            return z ? !num2.equals(num6) ? b.ALLOWED : b.NOT_ALLOWED : num2.equals(num5) ? b.ALLOWED : b.NOT_ALLOWED;
        }
        return b.UNKNOWN;
    }

    public static String a() {
        String processName = Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : (String) bi.a("android.app.ActivityThread", "currentProcessName", new Object[0]);
        return !TextUtils.isEmpty(processName) ? processName : "";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m8748a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e) {
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Map<String, String> m8749a(Context context, String str) {
        a aVar = f27734a;
        if (aVar == null) {
            return null;
        }
        return aVar.a(context, str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8750a(Context context) {
        String a2 = a();
        if (TextUtils.isEmpty(a2) || context == null) {
            return false;
        }
        return a2.equals(context.getPackageName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8751a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (j.m8997a()) {
            a aVar = f27734a;
            return aVar != null && aVar.m8754a(context, str);
        }
        return context.getPackageName().equals(str);
    }

    public static int b(Context context, String str) {
        int i;
        ApplicationInfo m8746a = m8746a(context, str);
        if (m8746a != null) {
            int i2 = m8746a.icon;
            i = i2;
            if (i2 == 0) {
                return m8746a.logo;
            }
        } else {
            i = 0;
        }
        return i;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m8752b(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            String str2 = str;
            if (packageInfo != null) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                str2 = str;
                if (applicationInfo != null) {
                    str2 = packageManager.getApplicationLabel(applicationInfo).toString();
                }
            }
            return str2;
        } catch (PackageManager.NameNotFoundException e) {
            return str;
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m8753b(Context context, String str) {
        a aVar = f27734a;
        return aVar != null && aVar.b(context, str);
    }

    public static boolean c(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean d(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static boolean e(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "freeform_window_state", -1) >= 0) {
                return str.equals(Settings.Secure.getString(context.getContentResolver(), "freeform_package_name"));
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
