package com.meizu.cloud.pushsdk.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.b.i;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/util/MzSystemUtils.class */
public class MzSystemUtils {
    private static final String PUSH_SERVICE_PROCESS_NAME = "mzservice_v1";
    private static final String TAG = "MzSystemUtils";
    private static int flymeVersion = -1;
    private static String sCharacteristics;

    public static boolean compareVersion(String str, String str2) {
        int i;
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= min) {
                break;
            }
            int length = split[i2].length() - split2[i2].length();
            i = length;
            if (length != 0) {
                break;
            }
            int compareTo = split[i2].compareTo(split2[i2]);
            i = compareTo;
            if (compareTo != 0) {
                break;
            }
            i2++;
            i3 = compareTo;
        }
        if (i == 0) {
            i = split.length - split2.length;
        }
        if (i >= 0) {
            z = true;
        }
        return z;
    }

    public static String findReceiver(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Intent intent = new Intent(str);
            intent.setPackage(str2);
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
                return null;
            }
            return queryBroadcastReceivers.get(0).activityInfo.name;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getAppVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            return 0;
        }
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            return "";
        }
    }

    public static String getAppVersionName(Context context, String str) {
        try {
            String str2 = context.getPackageManager().getPackageInfo(str, 0).versionName;
            return str2 != null ? str2.length() <= 0 ? "" : str2 : "";
        } catch (Exception e) {
            DebugLogger.e(TAG, "Exception message " + e.getMessage());
            return "";
        }
    }

    public static String getCurrentLanguage() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception e) {
            DebugLogger.e(TAG, "getCurrentLanguage error " + e.getMessage());
            return null;
        }
    }

    public static String getDocumentsPath(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Build.VERSION.SDK_INT >= 19 ? Environment.DIRECTORY_DOCUMENTS : "Documents");
        if (externalFilesDir != null) {
            return externalFilesDir.getPath();
        }
        return "/storage/emulated/0/Android/data/" + context.getPackageName() + "/files/Documents";
    }

    public static int getFlymeVersion() {
        int i = flymeVersion;
        if (i > 0) {
            return i;
        }
        try {
            try {
                int parseInt = Integer.parseInt(i.a("ro.build.flyme.version"));
                flymeVersion = parseInt;
                return parseInt;
            } catch (Exception e) {
                String a2 = i.a("ro.flyme.version.id");
                String str = a2;
                if (TextUtils.isEmpty(a2)) {
                    str = i.a("ro.build.display.id");
                }
                int intValue = Integer.valueOf(str.replace("Flyme", "").replace(" ", "").substring(0, 1)).intValue();
                flymeVersion = intValue;
                return intValue;
            }
        } catch (Exception e2) {
            DebugLogger.e(TAG, "getFlymeVersion error " + e2.getMessage());
            return -1;
        }
    }

    public static String getMzPushServicePackageName(Context context) {
        String packageName = context.getPackageName();
        try {
            String str = isWatch() ? PushConstants.WEARABLE_PUSH_PACKAGE_NAME : PushConstants.PUSH_PACKAGE_NAME;
            String servicesByPackageName = getServicesByPackageName(context, str);
            if (!TextUtils.isEmpty(servicesByPackageName)) {
                if (servicesByPackageName.contains(PUSH_SERVICE_PROCESS_NAME)) {
                    return str;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DebugLogger.i(TAG, "start service package name " + packageName);
        return packageName;
    }

    public static String getNetWorkType(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? type != 7 ? type != 9 ? "OTHER" : "ETHERNET" : "BLUETOOTH" : "WIFI";
                }
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype != 18) {
                    if (subtype != 20) {
                        switch (subtype) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                return "MOBILE_2G";
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                return "MOBILE_3G";
                            case 13:
                                return "MOBILE_4G";
                            default:
                                return "MOBILE_XG";
                        }
                    }
                    return "MOBILE_5G";
                }
                return "MOBILE_4G";
            }
            return "";
        } catch (Exception e) {
            DebugLogger.e(TAG, "Security exception checking connection: " + e.getMessage());
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0068, code lost:
        r3 = r0.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getProcessName(android.content.Context r3) {
        /*
            int r0 = android.os.Process.myPid()     // Catch: java.lang.Exception -> L6f
            r4 = r0
            java.lang.String r0 = ""
            r5 = r0
            r0 = r3
            android.content.Context r0 = r0.getApplicationContext()     // Catch: java.lang.Exception -> L6f
            java.lang.String r1 = "activity"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Exception -> L6f
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0     // Catch: java.lang.Exception -> L6f
            r3 = r0
            r0 = r3
            if (r0 != 0) goto L1b
            r0 = 0
            return r0
        L1b:
            r0 = r3
            java.util.List r0 = r0.getRunningAppProcesses()     // Catch: java.lang.Exception -> L6f
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L6f
            r6 = r0
        L25:
            r0 = r5
            r3 = r0
            r0 = r6
            boolean r0 = r0.hasNext()     // Catch: java.lang.Exception -> L6f
            if (r0 == 0) goto L6d
            r0 = r6
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Exception -> L6f
            android.app.ActivityManager$RunningAppProcessInfo r0 = (android.app.ActivityManager.RunningAppProcessInfo) r0     // Catch: java.lang.Exception -> L6f
            r3 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6f
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> L6f
            r7 = r0
            r0 = r7
            java.lang.String r1 = "processName "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L6f
            r0 = r7
            r1 = r3
            java.lang.String r1 = r1.processName     // Catch: java.lang.Exception -> L6f
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L6f
            java.lang.String r0 = "MzSystemUtils"
            r1 = r7
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L6f
            com.meizu.cloud.pushinternal.DebugLogger.i(r0, r1)     // Catch: java.lang.Exception -> L6f
            r0 = r3
            int r0 = r0.pid     // Catch: java.lang.Exception -> L6f
            r1 = r4
            if (r0 != r1) goto L25
            r0 = r3
            java.lang.String r0 = r0.processName     // Catch: java.lang.Exception -> L6f
            r3 = r0
        L6d:
            r0 = r3
            return r0
        L6f:
            r3 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            r0 = r5
            java.lang.String r1 = "getProcessName error "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r3
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "MzSystemUtils"
            r1 = r5
            java.lang.String r1 = r1.toString()
            com.meizu.cloud.pushinternal.DebugLogger.e(r0, r1)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.util.MzSystemUtils.getProcessName(android.content.Context):java.lang.String");
    }

    private static String getServicesByPackageName(Context context, String str) {
        ServiceInfo[] serviceInfoArr;
        try {
            serviceInfoArr = context.getPackageManager().getPackageInfo(str, 4).services;
        } catch (Exception e) {
            serviceInfoArr = null;
        }
        if (serviceInfoArr == null) {
            return null;
        }
        int length = serviceInfoArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            ServiceInfo serviceInfo = serviceInfoArr[i2];
            if (PushConstants.MZ_PUSH_SERVICE_NAME.equals(serviceInfo.name)) {
                return serviceInfo.processName;
            }
            i = i2 + 1;
        }
    }

    public static boolean isBrandMeizu(Context context) {
        boolean z = !TextUtils.isEmpty(i.a("ro.meizu.product.model")) || !TextUtils.isEmpty(i.a("ro.vendor.meizu.product.model")) || AssistUtils.BRAND_MZ.equalsIgnoreCase(Build.BRAND) || "魅蓝".equalsIgnoreCase(Build.BRAND) || "22c4185e".equalsIgnoreCase(Build.BRAND);
        if (!z) {
            com.meizu.cloud.pushsdk.a.a.b(context.getApplicationContext());
        }
        return z;
    }

    public static boolean isExistReceiver(Context context, String str, String str2) {
        boolean z = false;
        if (!TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            z = false;
            if (queryBroadcastReceivers != null) {
                z = false;
                if (queryBroadcastReceivers.size() > 0) {
                    z = false;
                    if (!TextUtils.isEmpty(queryBroadcastReceivers.get(0).activityInfo.name)) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static boolean isHuaWei() {
        String a2 = i.a("ro.build.version.emui");
        DebugLogger.e(TAG, "huawei eui " + a2);
        return !TextUtils.isEmpty(a2);
    }

    public static boolean isIndiaLocal() {
        return "india".equals(i.a("ro.meizu.locale.region"));
    }

    public static boolean isInteractive(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return true;
        }
        try {
            return Build.VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
        } catch (Exception e) {
            DebugLogger.e(TAG, "isScreenOn error " + e.getMessage());
            return true;
        }
    }

    public static boolean isInternational() {
        if (com.meizu.cloud.pushsdk.b.a.a().f23973a) {
            return com.meizu.cloud.pushsdk.b.a.a().b.booleanValue();
        }
        return false;
    }

    public static boolean isMeizu(Context context) {
        return isBrandMeizu(context);
    }

    public static boolean isMeizuAndFlyme() {
        com.meizu.cloud.pushsdk.b.b.d<Boolean> b = com.meizu.cloud.pushsdk.b.a.b();
        if (b.f23973a) {
            return !b.b.booleanValue();
        }
        return false;
    }

    public static boolean isOverseas() {
        return isInternational() || isIndiaLocal();
    }

    public static boolean isPackageInstalled(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isRunningProcess(Context context, String str) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            boolean z = false;
            if (activityManager == null) {
                return false;
            }
            Iterator<ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                boolean contains = it.next().processName.contains(str);
                z = contains;
                if (contains) {
                    z = contains;
                    break;
                }
            }
            DebugLogger.i(TAG, str + " is running " + z);
            return z;
        } catch (Exception e) {
            DebugLogger.e(TAG, "can not get running process info so set running true");
            return true;
        }
    }

    public static boolean isWatch() {
        if (TextUtils.isEmpty(sCharacteristics)) {
            sCharacteristics = i.a("ro.build.characteristics");
        }
        if (TextUtils.isEmpty(sCharacteristics)) {
            sCharacteristics = "phone";
            return false;
        }
        return sCharacteristics.contains("watch");
    }

    public static boolean isXiaoMi() {
        return "Xiaomi".equals(Build.MODEL) || "Xiaomi".equals(Build.MANUFACTURER);
    }

    public static void sendMessageFromBroadcast(Context context, Intent intent, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            intent.setAction(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
        }
        String findReceiver = findReceiver(context, str, str2);
        if (!TextUtils.isEmpty(findReceiver)) {
            intent.setClassName(str2, findReceiver);
        }
        context.sendBroadcast(intent);
    }
}
