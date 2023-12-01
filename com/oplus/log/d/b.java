package com.oplus.log.d;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/d/b.class */
public final class b {
    private static final Object b = new Object();

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f10666a = "";

    /* renamed from: c  reason: collision with root package name */
    private static int f10667c = -1;
    private static String d = "";
    private static Context e = null;
    private static String f = null;

    public static Context a() {
        return e;
    }

    private static String a(String str, String str2) {
        return (String) j.a(j.a("android.os.SystemProperties"), MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}, new Object[]{str, str2});
    }

    public static void a(Context context) {
        if (context != null) {
            e = context.getApplicationContext();
        }
    }

    public static String b(Context context) {
        return context != null ? context.getPackageName() : "";
    }

    public static boolean b() {
        return !AdvanceSetting.CLEAR_NOTIFICATION.equalsIgnoreCase(d());
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(d) && context != null) {
            try {
                d = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e2) {
                if (com.oplus.log.b.a()) {
                    e2.printStackTrace();
                }
            }
        }
        return d;
    }

    public static boolean c() {
        return "in".equalsIgnoreCase(d());
    }

    public static int d(Context context) {
        if (-1 == f10667c && context != null) {
            try {
                f10667c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception e2) {
                if (com.oplus.log.b.a()) {
                    e2.printStackTrace();
                }
            }
        }
        return f10667c;
    }

    private static String d() {
        if (f == null) {
            e();
        }
        return f;
    }

    public static String e(Context context) {
        String str;
        if (f10666a != null) {
            return f10666a;
        }
        synchronized (b) {
            if (f10666a != null) {
                return f10666a;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            Iterator<ActivityManager.RunningAppProcessInfo> it = (runningAppProcesses == null || runningAppProcesses.isEmpty()) ? null : runningAppProcesses.iterator();
            if (it != null) {
                while (it.hasNext()) {
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next != null && next.pid == Process.myPid()) {
                        str = next.processName;
                        break;
                    }
                }
            }
            str = null;
            f10666a = str;
            return str;
        }
    }

    private static void e() {
        String b2 = f.b();
        if (!TextUtils.isEmpty(b2) && b2.trim().equalsIgnoreCase(g.g)) {
            String a2 = a("persist.sys.oem.region", "CN");
            f = a2;
            if ("OverSeas".equalsIgnoreCase(a2)) {
                String country = e.getResources().getConfiguration().locale.getCountry();
                String str = country;
                if ("CN".equalsIgnoreCase(country)) {
                    str = "OC";
                }
                f = str;
                return;
            }
            return;
        }
        String a3 = a("persist.sys." + g.b + ".region", "CN");
        f = a3;
        if ("oc".equalsIgnoreCase(a3)) {
            PackageManager packageManager = e.getPackageManager();
            if (packageManager.hasSystemFeature(g.b + ".version.exp")) {
                return;
            }
            f = "CN";
        }
    }
}
