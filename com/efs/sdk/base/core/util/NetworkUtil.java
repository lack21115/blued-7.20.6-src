package com.efs.sdk.base.core.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/util/NetworkUtil.class */
public class NetworkUtil {
    public static final String MOBILE_NETWORK = "2G/3G";
    public static final String NETWORK_CLASS_2G = "2g";
    public static final String NETWORK_CLASS_3G = "3g";
    public static final String NETWORK_CLASS_4G = "4g";
    public static final String NETWORK_CLASS_5G = "5g";
    public static final String NETWORK_CLASS_DENIED = "denied";
    public static final String NETWORK_CLASS_DISCONNECTED = "disconnected";
    public static final String NETWORK_CLASS_UNKNOWN = "unknown";
    public static final String NETWORK_TYPE_WIFI = "wifi";
    public static final String UNKNOW = "";
    public static final String WIFI = "Wi-Fi";

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0049, code lost:
        if (r7.getPackageManager().checkPermission(r8, r7.getPackageName()) == 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004c, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0037, code lost:
        if (((java.lang.Integer) java.lang.Class.forName("android.content.Context").getMethod("checkSelfPermission", java.lang.String.class).invoke(r7, r8)).intValue() == 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean checkPermission(android.content.Context r7, java.lang.String r8) {
        /*
            r0 = 0
            r10 = r0
            r0 = r7
            if (r0 != 0) goto L8
            r0 = 0
            return r0
        L8:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r0 < r1) goto L3d
            java.lang.String r0 = "android.content.Context"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L50
            java.lang.String r1 = "checkSelfPermission"
            r2 = 1
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L50
            r3 = r2
            r4 = 0
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r3[r4] = r5     // Catch: java.lang.Throwable -> L50
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch: java.lang.Throwable -> L50
            r1 = r7
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L50
            r3 = r2
            r4 = 0
            r5 = r8
            r3[r4] = r5     // Catch: java.lang.Throwable -> L50
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: java.lang.Throwable -> L50
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L50
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L50
            r9 = r0
            r0 = r9
            if (r0 != 0) goto L4e
            goto L4c
        L3d:
            r0 = r7
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            r1 = r8
            r2 = r7
            java.lang.String r2 = r2.getPackageName()
            int r0 = r0.checkPermission(r1, r2)
            if (r0 != 0) goto L4e
        L4c:
            r0 = 1
            r10 = r0
        L4e:
            r0 = r10
            return r0
        L50:
            r7 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.core.util.NetworkUtil.checkPermission(android.content.Context, java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r0.isConnected() == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.NetworkInfo getActiveNetworkInfo(android.content.Context r4) {
        /*
            r0 = 0
            r7 = r0
            r0 = r7
            r6 = r0
            r0 = r4
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Throwable -> L74
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch: java.lang.Throwable -> L74
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L1f
            r0 = r7
            r6 = r0
            java.lang.String r0 = "efs.base"
            java.lang.String r1 = "get CONNECTIVITY_SERVICE is null"
            com.efs.sdk.base.core.util.Log.w(r0, r1)     // Catch: java.lang.Throwable -> L74
            r0 = 0
            return r0
        L1f:
            r0 = r7
            r6 = r0
            r0 = r8
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> L74
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L36
            r0 = r4
            r6 = r0
            r0 = r4
            r7 = r0
            r0 = r4
            boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L74
            if (r0 != 0) goto L7f
        L36:
            r0 = r4
            r6 = r0
            r0 = r8
            android.net.NetworkInfo[] r0 = r0.getAllNetworkInfo()     // Catch: java.lang.Throwable -> L74
            r8 = r0
            r0 = r4
            r7 = r0
            r0 = r8
            if (r0 == 0) goto L7f
            r0 = 0
            r5 = r0
        L48:
            r0 = r4
            r6 = r0
            r0 = r4
            r7 = r0
            r0 = r5
            r1 = r8
            int r1 = r1.length     // Catch: java.lang.Throwable -> L74
            if (r0 >= r1) goto L7f
            r0 = r8
            r1 = r5
            r0 = r0[r1]
            if (r0 == 0) goto L6d
            r0 = r4
            r6 = r0
            r0 = r8
            r1 = r5
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L74
            boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L74
            if (r0 == 0) goto L6d
            r0 = r8
            r1 = r5
            r0 = r0[r1]
            r4 = r0
            r0 = r4
            return r0
        L6d:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L48
        L74:
            r4 = move-exception
            java.lang.String r0 = "efs.base"
            java.lang.String r1 = "get network info error"
            r2 = r4
            com.efs.sdk.base.core.util.Log.e(r0, r1, r2)
            r0 = r6
            r7 = r0
        L7f:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.core.util.NetworkUtil.getActiveNetworkInfo(android.content.Context):android.net.NetworkInfo");
    }

    public static String[] getNetworkAccessMode(Context context) {
        String[] strArr = {"", ""};
        if (context == null) {
            return strArr;
        }
        try {
            if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                strArr[0] = "";
                return strArr;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null) {
                strArr[0] = "";
                return strArr;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                strArr[0] = "Wi-Fi";
                return strArr;
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
                strArr[0] = "2G/3G";
                strArr[1] = networkInfo2.getSubtypeName();
            }
            return strArr;
        } catch (Throwable th) {
            return strArr;
        }
    }

    public static String getNetworkType(Context context) {
        if (isRejectAccessNetworkState(context)) {
            return NETWORK_CLASS_DENIED;
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo == null) {
            return "disconnected";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        int subtype = activeNetworkInfo.getSubtype();
        if (subtype != 20) {
            switch (subtype) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2g";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3g";
                case 13:
                    return "4g";
                default:
                    String subtypeName = activeNetworkInfo.getSubtypeName();
                    return TextUtils.isEmpty(subtypeName) ? "unknown" : (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? "3g" : subtypeName;
            }
        }
        return NETWORK_CLASS_5G;
    }

    public static int getNetworkTypeUmeng(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                return telephonyManager.getNetworkType();
            }
            return 0;
        } catch (Exception e) {
            return -100;
        }
    }

    public static boolean hasAccessNetworkState(Context context) {
        try {
            return context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
    }

    public static boolean isRejectAccessNetworkState(Context context) {
        return !hasAccessNetworkState(context);
    }

    public static boolean isWifi(Context context) {
        NetworkInfo activeNetworkInfo;
        return !isRejectAccessNetworkState(context) && (activeNetworkInfo = getActiveNetworkInfo(context)) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
    }
}
