package com.huawei.hms.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/android/SystemUtils.class */
public class SystemUtils {
    public static final String UNKNOWN = "unknown";

    public static String a() {
        return getSystemProperties("ro.product.locale", "");
    }

    public static String b() {
        return getSystemProperties("ro.product.locale.region", "");
    }

    public static String getAndoridVersion() {
        return getSystemProperties(TPSystemInfo.KEY_PROPERTY_VERSION_RELEASE, "unknown");
    }

    public static String getLocalCountry() {
        Locale locale = Locale.getDefault();
        return locale != null ? locale.getCountry() : "";
    }

    public static String getManufacturer() {
        return getSystemProperties(TPSystemInfo.KEY_PROPERTY_MANUFACTURER, "unknown");
    }

    public static long getMegabyte(double d) {
        double d2 = Build.VERSION.SDK_INT > 25 ? 1000.0d : 1024.0d;
        return (long) (d * d2 * d2);
    }

    public static String getNetType(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? "" : activeNetworkInfo.getTypeName();
    }

    public static String getPhoneModel() {
        return getSystemProperties(TPSystemInfo.KEY_PROPERTY_MODEL, "unknown");
    }

    public static String getSystemProperties(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, str2);
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
            HMSLog.e("SystemUtils", "An exception occurred while reading: getSystemProperties:" + str);
            return str2;
        }
    }

    public static boolean isChinaROM() {
        String b = b();
        if (TextUtils.isEmpty(b)) {
            String a2 = a();
            if (TextUtils.isEmpty(a2)) {
                String localCountry = getLocalCountry();
                if (TextUtils.isEmpty(localCountry)) {
                    return false;
                }
                return AdvanceSetting.CLEAR_NOTIFICATION.equalsIgnoreCase(localCountry);
            }
            return a2.toLowerCase(Locale.US).contains(AdvanceSetting.CLEAR_NOTIFICATION);
        }
        return AdvanceSetting.CLEAR_NOTIFICATION.equalsIgnoreCase(b);
    }

    public static boolean isEMUI() {
        HMSLog.i("SystemUtils", "is Emui :" + HwBuildEx.VERSION.EMUI_SDK_INT);
        return HwBuildEx.VERSION.EMUI_SDK_INT > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isSystemApp(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = r4
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.RuntimeException -> Lf android.content.pm.PackageManager.NameNotFoundException -> L31
            r1 = r5
            r2 = 16384(0x4000, float:2.2959E-41)
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r1, r2)     // Catch: java.lang.RuntimeException -> Lf android.content.pm.PackageManager.NameNotFoundException -> L31
            r4 = r0
            goto L52
        Lf:
            r4 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            r0 = r5
            java.lang.String r1 = "isSystemApp RuntimeException:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "SystemUtils"
            r1 = r5
            java.lang.String r1 = r1.toString()
            com.huawei.hms.support.log.HMSLog.e(r0, r1)
            goto L50
        L31:
            r4 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            r0 = r5
            java.lang.String r1 = "isSystemApp Exception: "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "SystemUtils"
            r1 = r5
            java.lang.String r1 = r1.toString()
            com.huawei.hms.support.log.HMSLog.e(r0, r1)
        L50:
            r0 = 0
            r4 = r0
        L52:
            r0 = r4
            if (r0 == 0) goto L64
            r0 = r4
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo
            int r0 = r0.flags
            r1 = 1
            r0 = r0 & r1
            if (r0 <= 0) goto L64
            r0 = 1
            return r0
        L64:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.android.SystemUtils.isSystemApp(android.content.Context, java.lang.String):boolean");
    }

    public static boolean isTVDevice() {
        return getSystemProperties("ro.build.characteristics", "default").equalsIgnoreCase("tv");
    }
}
