package com.huawei.hms.hatool;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.InvocationTargetException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/f.class */
public abstract class f {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/f$a.class */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static Object a(Class cls, String str, Class[] clsArr, Object[] objArr) {
        String str2;
        if (cls != null) {
            if (clsArr == null) {
                if (objArr != null) {
                    throw new a("paramsType is null, but params is not null");
                }
            } else if (objArr == null) {
                throw new a("paramsType or params should be same");
            } else {
                if (clsArr.length != objArr.length) {
                    throw new a("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
                }
            }
            try {
                try {
                    return cls.getMethod(str, clsArr).invoke(null, objArr);
                } catch (IllegalAccessException e) {
                    str2 = "invokeStaticFun(): method invoke Exception!";
                    z.f("hmsSdk", str2);
                    return null;
                } catch (IllegalArgumentException e2) {
                    str2 = "invokeStaticFun(): Illegal Argument!";
                    z.f("hmsSdk", str2);
                    return null;
                } catch (InvocationTargetException e3) {
                    str2 = "invokeStaticFun(): Invocation Target Exception!";
                    z.f("hmsSdk", str2);
                    return null;
                }
            } catch (NoSuchMethodException e4) {
                z.f("hmsSdk", "invokeStaticFun(): cls.getMethod(),No Such Method !");
                return null;
            }
        }
        throw new a("class is null in invokeStaticFun");
    }

    public static Object a(String str, String str2, Class[] clsArr, Object[] objArr) {
        String str3;
        try {
            return a(Class.forName(str), str2, clsArr, objArr);
        } catch (a e) {
            str3 = "invokeStaticFun(): Static function call Exception ";
            z.f("hmsSdk", str3);
            return null;
        } catch (ClassNotFoundException e2) {
            str3 = "invokeStaticFun() Not found class!";
            z.f("hmsSdk", str3);
            return null;
        }
    }

    public static String a() {
        return a("ro.build.version.emui", "");
    }

    public static String a(Context context) {
        return context == null ? "" : Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String a2 = a("android.os.SystemProperties", str, str2);
        String str3 = a2;
        if (TextUtils.isEmpty(a2)) {
            str3 = a("com.huawei.android.os.SystemPropertiesEx", str, str2);
        }
        return str3;
    }

    public static String a(String str, String str2, String str3) {
        Object a2 = a(str, MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}, new Object[]{str2, str3});
        if (a2 != null) {
            str3 = (String) a2;
        }
        return str3;
    }

    public static String b() {
        String a2 = a("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
        z.c("hmsSdk", "SystemPropertiesEx: get rom_ver: " + a2);
        String str = a2;
        if (TextUtils.isEmpty(a2)) {
            str = Build.DISPLAY;
            z.c("hmsSdk", "SystemProperties: get rom_ver: " + str);
        }
        return str;
    }

    public static String b(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get("CHANNEL")) == null) {
                return "Unknown";
            }
            String obj2 = obj.toString();
            return obj2.length() > 256 ? "Unknown" : obj2;
        } catch (PackageManager.NameNotFoundException e) {
            z.f("hmsSdk", "getChannel(): The packageName is not correct!");
            return "Unknown";
        }
    }

    public static String c(Context context) {
        return context == null ? "" : context.getPackageName();
    }

    public static String d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(c(context), 16384).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            z.f("hmsSdk", "getVersion(): The package name is not correct!");
            return "";
        }
    }
}
