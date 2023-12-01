package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/common/PackageManagerCompat.class */
public class PackageManagerCompat {
    private static final String TAG = "PackageUtils";
    private static final String VERSION = "6.0.2.300";
    private static String sAppVersion = "";

    public static String getAppPackageName(Context context) {
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return "";
        }
        try {
            return packageManager.getPackageInfo(context.getPackageName(), 16384).packageName;
        } catch (PackageManager.NameNotFoundException | RuntimeException e) {
            Logger.w("PackageUtils", "Failed to get Package managers Package Info");
            return "";
        }
    }

    public static String getAppVersion(Context context) {
        if (TextUtils.isEmpty(sAppVersion)) {
            if (ContextHolder.getAppContext() != null) {
                context = ContextHolder.getAppContext();
            }
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return sAppVersion;
            }
            try {
                sAppVersion = String.valueOf(packageManager.getPackageInfo(context.getPackageName(), 16384).versionCode);
            } catch (PackageManager.NameNotFoundException | RuntimeException e) {
                Logger.w("PackageUtils", "Failed to get Package managers Package Info");
            }
            return sAppVersion;
        }
        return sAppVersion;
    }

    private static Bundle getBundleFromApp(Context context) {
        PackageManager packageManager;
        Bundle bundle = Bundle.EMPTY;
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        if (context != null && (packageManager = context.getPackageManager()) != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    return applicationInfo.metaData;
                }
            } catch (PackageManager.NameNotFoundException | RuntimeException e) {
                Logger.w("PackageUtils", "NameNotFoundException:", e);
            }
            return bundle;
        }
        return bundle;
    }

    private static Bundle getBundleFromKit(Context context) {
        if (ContextHolder.getKitContext() != null) {
            context = ContextHolder.getKitContext();
        }
        if (context == null) {
            Logger.v("PackageUtils", "the kitContext is null");
            return Bundle.EMPTY;
        } else if (context.getApplicationInfo() == null) {
            Logger.v("PackageUtils", "the kit applicationInfo is null");
            return Bundle.EMPTY;
        } else {
            Bundle bundle = context.getApplicationInfo().metaData;
            Bundle bundle2 = bundle;
            if (bundle == null) {
                bundle2 = Bundle.EMPTY;
            }
            return bundle2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
        if (r0.isEmpty() != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.os.Bundle getBundleFromKitOrAPP(android.content.Context r2) {
        /*
            r0 = r2
            android.os.Bundle r0 = getBundleFromKit(r0)
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L12
            r0 = r4
            r3 = r0
            r0 = r4
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L17
        L12:
            r0 = r2
            android.os.Bundle r0 = getBundleFromApp(r0)
            r3 = r0
        L17:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.PackageManagerCompat.getBundleFromKitOrAPP(android.content.Context):android.os.Bundle");
    }

    public static String getMetaDataFromApp(Context context, String str, String str2) {
        Bundle bundleFromApp = getBundleFromApp(context);
        return bundleFromApp != null ? bundleFromApp.getString(str, str2) : str2;
    }

    public static String getMetaDataFromKit(Context context, String str, String str2) {
        try {
            Bundle bundleFromKit = getBundleFromKit(context);
            return bundleFromKit == null ? str2 : bundleFromKit.getString(str, str2);
        } catch (RuntimeException e) {
            Logger.v("PackageUtils", "the kit metaData is runtimeException");
            return str2;
        }
    }

    public static String getMetaDataFromKitOrApp(Context context, String str, String str2) {
        return getBundleFromKitOrAPP(context).getString(str, str2);
    }

    public static Map<String, String> getMetaDataMapFromKitOrApp(Context context, String str) {
        HashMap hashMap = new HashMap();
        Bundle bundleFromKitOrAPP = getBundleFromKitOrAPP(context);
        for (String str2 : getBundleFromKitOrAPP(context).keySet()) {
            if (str2.startsWith(str)) {
                String string = bundleFromKitOrAPP.getString(str2);
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put(str2.substring(str.length()), string);
                }
            }
        }
        return hashMap;
    }
}
