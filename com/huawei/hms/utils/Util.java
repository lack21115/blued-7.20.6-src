package com.huawei.hms.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.common.util.AGCUtils;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/utils/Util.class */
public class Util {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f22928a = false;
    private static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f22929c = new Object();
    private static String d;

    public static int compareHmsVersion(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        if (StringUtil.checkVersion(str) && StringUtil.checkVersion(str2)) {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            if (2 >= split.length || 2 >= split2.length) {
                return 0;
            }
            if (Integer.parseInt(split[0]) > Integer.parseInt(split2[0])) {
                return 1;
            }
            if (Integer.parseInt(split[0]) < Integer.parseInt(split2[0])) {
                return -1;
            }
            if (Integer.parseInt(split[1]) > Integer.parseInt(split2[1])) {
                return 1;
            }
            if (Integer.parseInt(split[1]) < Integer.parseInt(split2[1])) {
                return -1;
            }
            if (Integer.parseInt(split[2]) > Integer.parseInt(split2[2])) {
                return 1;
            }
            return Integer.parseInt(split[2]) < Integer.parseInt(split2[2]) ? -1 : 0;
        }
        return 0;
    }

    public static Activity getActiveActivity(Activity activity, Context context) {
        return UIUtil.getActiveActivity(activity, context);
    }

    public static String getAppId(Context context) {
        return AGCUtils.getAppId(context);
    }

    public static String getAppName(Context context, String str) {
        if (context == null) {
            HMSLog.e("Util", "In getAppName, context is null.");
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("Util", "In getAppName, Failed to get 'PackageManager' instance.");
            return "";
        }
        String str2 = str;
        try {
            if (TextUtils.isEmpty(str)) {
                str2 = context.getPackageName();
            }
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str2, 128));
            return applicationLabel == null ? "" : applicationLabel.toString();
        } catch (Resources.NotFoundException | AndroidException e) {
            HMSLog.e("Util", "In getAppName, Failed to get app name.");
            return "";
        }
    }

    public static String getCpId(Context context) {
        return AGCUtils.getCpId(context);
    }

    public static int getHmsVersion(Context context) {
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("Util", "In getHmsVersion, Failed to get 'PackageManager' instance.");
            return 0;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo != null && applicationInfo.metaData != null && (obj = applicationInfo.metaData.get("com.huawei.hms.version")) != null) {
                String valueOf = String.valueOf(obj);
                if (!TextUtils.isEmpty(valueOf)) {
                    return StringUtil.convertVersion2Integer(valueOf);
                }
            }
            HMSLog.i("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
            return 0;
        } catch (AndroidException e) {
            HMSLog.e("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
            return 0;
        } catch (RuntimeException e2) {
            HMSLog.e("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.", e2);
            return 0;
        }
    }

    public static String getNetType(Context context) {
        return SystemUtils.getNetType(context);
    }

    public static String getProcessName(Context context, int i) {
        return UIUtil.getProcessName(context, i);
    }

    @Deprecated
    public static String getProductCountry() {
        int lastIndexOf;
        String systemProperties = getSystemProperties("ro.product.locale.region", "");
        if (TextUtils.isEmpty(systemProperties)) {
            String systemProperties2 = getSystemProperties("ro.product.locale", "");
            if (TextUtils.isEmpty(systemProperties2) || (lastIndexOf = systemProperties2.lastIndexOf("-")) == -1) {
                String localCountry = SystemUtils.getLocalCountry();
                return TextUtils.isEmpty(localCountry) ? "" : localCountry;
            }
            return systemProperties2.substring(lastIndexOf + 1);
        }
        return systemProperties;
    }

    public static String getServiceActionMetadata(Context context) {
        String str = d;
        if (str != null) {
            return str;
        }
        Intent intent = new Intent(PackageConstants.INTERNAL_SERVICES_ACTION);
        intent.setPackage(context.getPackageName());
        if (context.getPackageManager().resolveService(intent, 128) != null) {
            d = PackageConstants.INTERNAL_SERVICES_ACTION;
            return PackageConstants.INTERNAL_SERVICES_ACTION;
        }
        d = "";
        return "";
    }

    public static String getSystemProperties(String str, String str2) {
        return SystemUtils.getSystemProperties(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
        if (r2.isFinishing() != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.app.Activity getValidActivity(android.app.Activity r2, android.app.Activity r3) {
        /*
            r0 = r2
            if (r0 == 0) goto Ld
            r0 = r2
            r4 = r0
            r0 = r2
            boolean r0 = r0.isFinishing()
            if (r0 == 0) goto L1f
        Ld:
            r0 = r3
            if (r0 == 0) goto L1d
            r0 = r3
            boolean r0 = r0.isFinishing()
            if (r0 == 0) goto L1b
            goto L1d
        L1b:
            r0 = r3
            return r0
        L1d:
            r0 = 0
            r4 = r0
        L1f:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.utils.Util.getValidActivity(android.app.Activity, android.app.Activity):android.app.Activity");
    }

    public static boolean isAvailableLibExist(Context context) {
        boolean z;
        synchronized (f22929c) {
            if (!f22928a) {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    HMSLog.e("Util", "In isAvailableLibExist, Failed to get 'PackageManager' instance.");
                    try {
                        Class.forName("com.huawei.hms.adapter.AvailableAdapter");
                        z = true;
                    } catch (ClassNotFoundException e) {
                        HMSLog.e("Util", "In isAvailableLibExist, Failed to find class AvailableAdapter.");
                        z = false;
                    }
                    b = z;
                    f22928a = true;
                } else {
                    try {
                        try {
                            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                            z = false;
                            if (applicationInfo != null) {
                                z = false;
                                if (applicationInfo.metaData != null) {
                                    Object obj = applicationInfo.metaData.get("availableLoaded");
                                    z = false;
                                    if (obj != null) {
                                        z = false;
                                        if (String.valueOf(obj).equalsIgnoreCase("yes")) {
                                            HMSLog.i("Util", "available exist: true");
                                            z = true;
                                        }
                                    }
                                }
                            }
                        } catch (AndroidException e2) {
                            HMSLog.e("Util", "In isAvailableLibExist, Failed to read meta data for the availableLoaded.");
                            z = false;
                        }
                    } catch (RuntimeException e3) {
                        HMSLog.e("Util", "In isAvailableLibExist, Failed to read meta data for the availableLoaded.", e3);
                        z = false;
                    }
                    b = z;
                    f22928a = true;
                }
            }
        }
        HMSLog.i("Util", "available exist: " + b);
        return b;
    }

    public static boolean isChinaROM() {
        return SystemUtils.isChinaROM();
    }

    public static boolean isEMUI() {
        return SystemUtils.isEMUI();
    }

    public static void unBindServiceCatchException(Context context, ServiceConnection serviceConnection) {
        try {
            HMSLog.i("Util", "Trying to unbind service from " + serviceConnection);
            context.unbindService(serviceConnection);
        } catch (Exception e) {
            HMSLog.e("Util", "On unBindServiceException:" + e.getMessage());
        }
    }
}
