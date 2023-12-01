package com.umeng.commonsdk.internal.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/internal/utils/a.class */
public class a {

    /* renamed from: com.umeng.commonsdk.internal.utils.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/internal/utils/a$a.class */
    public static class C1082a {

        /* renamed from: a  reason: collision with root package name */
        public String f40870a;
        public String b;
    }

    public static float a(Context context) {
        if (context == null) {
            return 0.0f;
        }
        Configuration configuration = new Configuration();
        try {
            configuration.updateFrom(context.getResources().getConfiguration());
            return configuration.fontScale;
        } catch (Exception e) {
            ULog.e("getFontSize:" + e.getMessage());
            return 0.0f;
        }
    }

    public static long a(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        try {
            PackageInfo a2 = com.umeng.commonsdk.utils.b.a().a(context, str, 64);
            if (a2 != null) {
                return a2.firstInstallTime;
            }
            return 0L;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            ULog.e("getAppFirstInstallTime" + th.getMessage());
            return 0L;
        }
    }

    public static boolean a() {
        return h.a();
    }

    public static long b(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        try {
            PackageInfo a2 = com.umeng.commonsdk.utils.b.a().a(context, str, 64);
            if (a2 != null) {
                return a2.lastUpdateTime;
            }
            return 0L;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            ULog.e("getAppLastUpdateTime:" + th.getMessage());
            return 0L;
        }
    }

    public static String b() {
        return new SimpleDateFormat().format(new Date());
    }

    public static void b(Context context) {
    }

    public static int c(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static long c() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public static String c(Context context, String str) {
        try {
            return context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            ULog.e("getAppInstaller:" + e.getMessage());
            return null;
        }
    }

    public static int d(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier(Settings.System.NAVIGATION_BAR_HEIGHT, "dimen", "android"));
    }

    public static int d(Context context, String str) {
        if (context == null) {
            return 0;
        }
        try {
            PackageInfo a2 = com.umeng.commonsdk.utils.b.a().a(context, str, 64);
            int i = 0;
            if (a2 != null) {
                ApplicationInfo applicationInfo = a2.applicationInfo;
                i = 0;
                if (applicationInfo != null) {
                    i = applicationInfo.uid;
                }
            }
            return i;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            ULog.e("getAppUid:" + th.getMessage());
            return 0;
        }
    }

    public static String d() {
        String str;
        String str2 = null;
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            String obj = declaredMethod.invoke(null, "net.hostname").toString();
            str = obj;
            if (obj != null) {
                str = obj;
                if (!obj.equalsIgnoreCase("")) {
                    str2 = obj;
                    return HelperUtils.getUmengMD5(obj);
                }
            }
        } catch (Exception e) {
            ULog.e("getHostName:" + e.getMessage());
            str = str2;
        }
        return str;
    }

    public static DisplayMetrics e(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    private static String e(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                return (String) applicationInfo.loadLabel(context.getPackageManager());
            }
            return null;
        } catch (Exception e) {
            ULog.e("getLabel:" + e.getMessage());
            return null;
        }
    }

    public static List<InputMethodInfo> f(Context context) {
        InputMethodManager inputMethodManager;
        if (context == null || (inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)) == null) {
            return null;
        }
        return inputMethodManager.getInputMethodList();
    }

    public static List<C1082a> g(Context context) {
        String[] list;
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/Android/data/");
            if (file.isDirectory() && (list = file.list()) != null && list.length > 0) {
                int length = list.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    String str = list[i2];
                    if (str != null) {
                        if (!str.startsWith(".")) {
                            C1082a c1082a = new C1082a();
                            c1082a.f40870a = str;
                            c1082a.b = e(context, str);
                            arrayList.add(c1082a);
                        }
                    }
                    i = i2 + 1;
                }
            }
        } catch (Exception e) {
            ULog.e("getAppList:" + e.getMessage());
        }
        return arrayList;
    }

    public static ActivityManager.MemoryInfo h(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public static String i(Context context) {
        if (context == null) {
        }
        return null;
    }

    public static String j(Context context) {
        return null;
    }
}
