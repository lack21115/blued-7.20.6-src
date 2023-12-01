package com.huawei.hms.support.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.huawei.hms.base.log.a;
import com.huawei.hms.base.log.d;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/support/log/HMSLog.class */
public class HMSLog {

    /* renamed from: a  reason: collision with root package name */
    public static final a f9286a = new a();

    public static String a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 16384);
                return "HMS-" + packageInfo.versionName + "(" + packageInfo.versionCode + ")";
            } catch (PackageManager.NameNotFoundException | RuntimeException e) {
                return "HMS-[unknown-version]";
            }
        }
        return "HMS-[unknown-version]";
    }

    public static void d(String str, String str2) {
        f9286a.a(3, str, str2);
    }

    public static void e(String str, long j, String str2) {
        a aVar = f9286a;
        aVar.a(6, str, "[" + j + "] " + str2);
    }

    public static void e(String str, long j, String str2, Throwable th) {
        a aVar = f9286a;
        aVar.b(6, str, "[" + j + "] " + str2, th);
    }

    public static void e(String str, String str2) {
        f9286a.a(6, str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        f9286a.b(6, str, str2, th);
    }

    public static void i(String str, String str2) {
        f9286a.a(4, str, str2);
    }

    public static void init(Context context, int i, String str) {
        f9286a.a(context, i, str);
        f9286a.a(str, "============================================================================\n====== " + a(context) + "\n============================================================================");
    }

    public static boolean isErrorEnable() {
        return f9286a.a(6);
    }

    public static boolean isInfoEnable() {
        return f9286a.a(4);
    }

    public static boolean isWarnEnable() {
        return f9286a.a(5);
    }

    public static void setExtLogger(HMSExtLogger hMSExtLogger, boolean z) throws IllegalArgumentException {
        if (hMSExtLogger == null) {
            throw new IllegalArgumentException("extLogger is not able to be null");
        }
        d dVar = new d(hMSExtLogger);
        if (z) {
            f9286a.a(dVar);
        } else {
            f9286a.a().a(dVar);
        }
    }

    public static void w(String str, String str2) {
        f9286a.a(5, str, str2);
    }
}
