package com.tencent.bugly.idasc.proguard;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import com.huawei.openalliance.ad.constant.bc;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/z.class */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f35355a = "@buglyAllChannel@".split(",");
    public static final String[] b = "@buglyAllChannelPriority@".split(",");

    public static String a(int i) {
        FileReader fileReader;
        int i2;
        try {
            fileReader = new FileReader("/proc/" + i + "/cmdline");
        } catch (Throwable th) {
            th = th;
            fileReader = null;
        }
        try {
            char[] cArr = new char[512];
            fileReader.read(cArr);
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= 512 || cArr[i2] == 0) {
                    break;
                }
                i3 = i2 + 1;
            }
            String substring = new String(cArr).substring(0, i2);
            try {
                fileReader.close();
                return substring;
            } catch (Throwable th2) {
                return substring;
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                String valueOf = String.valueOf(i);
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable th4) {
                        return valueOf;
                    }
                }
                return valueOf;
            } catch (Throwable th5) {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable th6) {
                    }
                }
                throw th5;
            }
        }
    }

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            if (al.a(th)) {
                return bc.b.S;
            }
            th.printStackTrace();
            return bc.b.S;
        }
    }

    public static List<String> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            String str = map.get("BUGLY_DISABLE");
            if (str == null || str.length() == 0) {
                return null;
            }
            String[] split = str.split(",");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= split.length) {
                    return Arrays.asList(split);
                }
                split[i2] = split[i2].trim();
                i = i2 + 1;
            }
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static boolean a() {
        Activity activity;
        Field declaredField;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Field declaredField2 = cls.getDeclaredField("sCurrentActivityThread");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(cls);
            Field declaredField3 = cls.getDeclaredField("mActivities");
            declaredField3.setAccessible(true);
            Iterator it = ((Map) declaredField3.get(obj)).entrySet().iterator();
            do {
                if (!it.hasNext()) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) it.next();
                Field declaredField4 = Class.forName("android.app.ActivityThread$ActivityClientRecord").getDeclaredField("activity");
                declaredField4.setAccessible(true);
                activity = (Activity) declaredField4.get(entry.getValue());
                declaredField = Activity.class.getDeclaredField("mResumed");
                declaredField.setAccessible(true);
            } while (!((Boolean) declaredField.get(activity)).booleanValue());
            return true;
        } catch (Throwable th) {
            al.b(th);
            return true;
        }
    }

    public static boolean a(ActivityManager activityManager) {
        if (activityManager == null) {
            al.c("is proc running, ActivityManager is null", new Object[0]);
            return true;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            al.c("running proc info list is empty, my proc not running.", new Object[0]);
            return false;
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                al.c("my proc is running.", new Object[0]);
                return true;
            }
        }
        al.c("proc not in running proc info list, my proc not running.", new Object[0]);
        return false;
    }

    public static PackageInfo b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(a(context), 0);
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static String c(Context context) {
        CharSequence applicationLabel;
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (packageManager == null || applicationInfo == null || (applicationLabel = packageManager.getApplicationLabel(applicationInfo)) == null) {
                return null;
            }
            return applicationLabel.toString();
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            HashMap hashMap = null;
            if (applicationInfo.metaData != null) {
                hashMap = new HashMap();
                Object obj = applicationInfo.metaData.get("BUGLY_DISABLE");
                if (obj != null) {
                    hashMap.put("BUGLY_DISABLE", obj.toString());
                }
                Object obj2 = applicationInfo.metaData.get("BUGLY_APPID");
                if (obj2 != null) {
                    hashMap.put("BUGLY_APPID", obj2.toString());
                }
                Object obj3 = applicationInfo.metaData.get("BUGLY_APP_CHANNEL");
                if (obj3 != null) {
                    hashMap.put("BUGLY_APP_CHANNEL", obj3.toString());
                }
                Object obj4 = applicationInfo.metaData.get("BUGLY_APP_VERSION");
                if (obj4 != null) {
                    hashMap.put("BUGLY_APP_VERSION", obj4.toString());
                }
                Object obj5 = applicationInfo.metaData.get("BUGLY_ENABLE_DEBUG");
                if (obj5 != null) {
                    hashMap.put("BUGLY_ENABLE_DEBUG", obj5.toString());
                }
                Object obj6 = applicationInfo.metaData.get("com.tencent.rdm.uuid");
                if (obj6 != null) {
                    hashMap.put("com.tencent.rdm.uuid", obj6.toString());
                }
                Object obj7 = applicationInfo.metaData.get("BUGLY_APP_BUILD_NO");
                if (obj7 != null) {
                    hashMap.put("BUGLY_APP_BUILD_NO", obj7.toString());
                }
                Object obj8 = applicationInfo.metaData.get("BUGLY_AREA");
                if (obj8 != null) {
                    hashMap.put("BUGLY_AREA", obj8.toString());
                }
            }
            return hashMap;
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
