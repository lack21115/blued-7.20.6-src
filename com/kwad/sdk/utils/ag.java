package com.kwad.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import java.net.InetAddress;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/ag.class */
public final class ag {
    private static boolean aAa;
    private static int azZ;

    public static NetworkInfo bZ(Context context) {
        ConnectivityManager connectivityManager;
        if (SystemUtil.b(context, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)) != null) {
            try {
                return connectivityManager.getActiveNetworkInfo();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static int ca(Context context) {
        if (context != null && SystemUtil.b(context, "android.permission.ACCESS_NETWORK_STATE") && SystemUtil.b(context, "android.permission.READ_PHONE_STATE")) {
            try {
                NetworkInfo bZ = bZ(context);
                if (bZ != null && bZ.isConnected()) {
                    if (1 == bZ.getType()) {
                        return 100;
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                    if (telephonyManager != null) {
                        int l = l(context, telephonyManager.getNetworkType());
                        if (l != 20) {
                            switch (l) {
                                case 1:
                                case 2:
                                case 4:
                                case 7:
                                case 11:
                                case 16:
                                    return 2;
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                case 9:
                                case 10:
                                case 12:
                                case 14:
                                case 15:
                                    return 3;
                                case 13:
                                    return 4;
                                default:
                                    return 0;
                            }
                        }
                        return 5;
                    }
                    return 0;
                }
                return 0;
            } catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0138 A[Catch: Exception -> 0x0156, TRY_LEAVE, TryCatch #0 {Exception -> 0x0156, blocks: (B:11:0x001a, B:13:0x002f, B:15:0x0036, B:40:0x00ac, B:61:0x00fb, B:62:0x0102, B:63:0x0109, B:44:0x00bb, B:48:0x00c9, B:52:0x00d7, B:20:0x0064, B:24:0x0073, B:28:0x0081, B:32:0x008f, B:36:0x009d, B:56:0x00e5, B:64:0x010d, B:64:0x010d, B:66:0x0113, B:68:0x011a, B:70:0x0123, B:73:0x012f, B:75:0x0138, B:76:0x013f, B:78:0x0148, B:79:0x014f, B:60:0x00f4), top: B:95:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013f A[Catch: Exception -> 0x0156, TRY_ENTER, TryCatch #0 {Exception -> 0x0156, blocks: (B:11:0x001a, B:13:0x002f, B:15:0x0036, B:40:0x00ac, B:61:0x00fb, B:62:0x0102, B:63:0x0109, B:44:0x00bb, B:48:0x00c9, B:52:0x00d7, B:20:0x0064, B:24:0x0073, B:28:0x0081, B:32:0x008f, B:36:0x009d, B:56:0x00e5, B:64:0x010d, B:64:0x010d, B:66:0x0113, B:68:0x011a, B:70:0x0123, B:73:0x012f, B:75:0x0138, B:76:0x013f, B:78:0x0148, B:79:0x014f, B:60:0x00f4), top: B:95:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0167  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d(android.content.Context r3, java.lang.String r4, boolean r5) {
        /*
            Method dump skipped, instructions count: 467
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.ag.d(android.content.Context, java.lang.String, boolean):int");
    }

    private static boolean eG(String str) {
        return str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED");
    }

    public static boolean eH(String str) {
        return o(str, 3000);
    }

    public static int getActiveNetworkType(Context context) {
        try {
            NetworkInfo bZ = bZ(context);
            if (bZ == null) {
                return -1;
            }
            return bZ.getType();
        } catch (Exception e) {
            return -1;
        }
    }

    private static int getSubId() {
        if (Build.VERSION.SDK_INT >= 24) {
            return SubscriptionManager.getDefaultDataSubscriptionId();
        }
        return -1;
    }

    public static boolean isMobileConnected(Context context) {
        try {
            NetworkInfo bZ = bZ(context);
            if (bZ == null || !bZ.isConnected()) {
                return false;
            }
            return bZ.getType() == 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo bZ = bZ(context);
            if (bZ != null) {
                return bZ.isConnected();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo bZ = bZ(context);
            if (bZ == null || !bZ.isConnected()) {
                return false;
            }
            return 1 == bZ.getType();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075 A[Catch: Exception -> 0x00ae, TRY_ENTER, TryCatch #1 {Exception -> 0x00ae, blocks: (B:6:0x001c, B:10:0x002e, B:13:0x0037, B:25:0x0075, B:27:0x007b, B:30:0x0094, B:33:0x009a, B:14:0x0040, B:16:0x004c), top: B:46:0x001c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int l(android.content.Context r7, int r8) {
        /*
            r0 = r8
            r9 = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 < r1) goto Lac
            r0 = r8
            r9 = r0
            r0 = r7
            r1 = 1
            java.lang.String[] r1 = new java.lang.String[r1]
            r2 = r1
            r3 = 0
            java.lang.String r4 = "android.permission.ACCESS_NETWORK_STATE"
            r2[r3] = r4
            boolean r0 = com.kwad.sdk.utils.SystemUtil.b(r0, r1)
            if (r0 == 0) goto Lac
            r0 = r7
            java.lang.String r1 = "phone"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Exception -> Lae
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch: java.lang.Exception -> Lae
            r12 = r0
            r0 = r12
            if (r0 != 0) goto L2e
            r0 = r8
            return r0
        L2e:
            int r0 = getSubId()     // Catch: java.lang.Exception -> Lae
            r9 = r0
            r0 = r9
            r1 = -1
            if (r0 != r1) goto L40
        L37:
            r0 = r12
            android.telephony.ServiceState r0 = r0.getServiceState()     // Catch: java.lang.Exception -> Lae
            r7 = r0
            goto L6f
        L40:
            r0 = r7
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()     // Catch: java.lang.Exception -> Lae
            int r0 = r0.targetSdkVersion     // Catch: java.lang.Exception -> Lae
            r1 = 29
            if (r0 < r1) goto L59
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> Lae
            r10 = r0
            r0 = r10
            r1 = 29
            if (r0 < r1) goto L59
            goto L37
        L59:
            r0 = r12
            java.lang.String r1 = "getServiceStateForSubscriber"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lb1
            r3 = r2
            r4 = 0
            r5 = r9
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> Lb1
            r3[r4] = r5     // Catch: java.lang.Throwable -> Lb1
            java.lang.Object r0 = com.kwad.sdk.utils.s.a(r0, r1, r2)     // Catch: java.lang.Throwable -> Lb1
            android.telephony.ServiceState r0 = (android.telephony.ServiceState) r0     // Catch: java.lang.Throwable -> Lb1
            r7 = r0
        L6f:
            r0 = r7
            if (r0 != 0) goto L75
            r0 = r8
            return r0
        L75:
            boolean r0 = com.kwad.sdk.utils.as.DQ()     // Catch: java.lang.Exception -> Lae
            if (r0 == 0) goto L99
            java.lang.String r0 = "com.huawei.android.telephony.ServiceStateEx"
            java.lang.String r1 = "getConfigRadioTechnology"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> Lae
            r3 = r2
            r4 = 0
            r5 = r7
            r3[r4] = r5     // Catch: java.lang.Exception -> Lae
            java.lang.Object r0 = com.kwad.sdk.utils.s.a(r0, r1, r2)     // Catch: java.lang.Exception -> Lae
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Exception -> Lae
            r7 = r0
            r0 = r8
            r9 = r0
            r0 = r7
            if (r0 == 0) goto Lac
            r0 = r7
            int r0 = r0.intValue()     // Catch: java.lang.Exception -> Lae
            return r0
        L99:
            r0 = r7
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Lae
            boolean r0 = eG(r0)     // Catch: java.lang.Exception -> Lae
            r11 = r0
            r0 = r8
            r9 = r0
            r0 = r11
            if (r0 == 0) goto Lac
            r0 = 20
            r9 = r0
        Lac:
            r0 = r9
            return r0
        Lae:
            r7 = move-exception
            r0 = r8
            return r0
        Lb1:
            r7 = move-exception
            goto L37
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.ag.l(android.content.Context, int):int");
    }

    private static boolean o(String str, int i) {
        try {
            return InetAddress.getByName(str).isReachable(3000);
        } catch (Throwable th) {
            return false;
        }
    }
}
