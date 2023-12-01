package com.huawei.hms.hatool;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/h.class */
public class h {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0066, code lost:
        if (r4.equalsIgnoreCase("CDMA2000") != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(int r3, java.lang.String r4) {
        /*
            r0 = r3
            switch(r0) {
                case 1: goto L6f;
                case 2: goto L6f;
                case 3: goto L72;
                case 4: goto L6f;
                case 5: goto L72;
                case 6: goto L72;
                case 7: goto L6f;
                case 8: goto L72;
                case 9: goto L72;
                case 10: goto L72;
                case 11: goto L6f;
                case 12: goto L72;
                case 13: goto L6c;
                case 14: goto L72;
                case 15: goto L72;
                default: goto L4c;
            }
        L4c:
            r0 = r4
            java.lang.String r1 = "TD-SCDMA"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L72
            r0 = r4
            java.lang.String r1 = "WCDMA"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L72
            r0 = r4
            r5 = r0
            r0 = r4
            java.lang.String r1 = "CDMA2000"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L75
            goto L72
        L6c:
            java.lang.String r0 = "4G"
            return r0
        L6f:
            java.lang.String r0 = "2G"
            return r0
        L72:
            java.lang.String r0 = "3G"
            r5 = r0
        L75:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.h.a(int, java.lang.String):java.lang.String");
    }

    public static String a(Context context) {
        if (context == null || context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
            z.f("hmsSdk", "not have network state phone permission!");
            return "";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        String str = "";
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            str = "";
            if (activeNetworkInfo != null) {
                str = "";
                if (activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() == 1) {
                        return "WIFI";
                    }
                    if (activeNetworkInfo.getType() == 0) {
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        z.c("hmsSdk", "Network getSubtypeName : " + subtypeName);
                        return a(activeNetworkInfo.getSubtype(), subtypeName);
                    } else if (activeNetworkInfo.getType() == 16) {
                        z.f("hmsSdk", "type name = COMPANION_PROXY");
                        return "COMPANION_PROXY";
                    } else if (activeNetworkInfo.getType() == 9) {
                        z.c("hmsSdk", "type name = ETHERNET");
                        return "ETHERNET";
                    } else {
                        z.c("hmsSdk", "type name = " + activeNetworkInfo.getType());
                        str = "OTHER_NETWORK_TYPE";
                    }
                }
            }
        }
        return str;
    }
}
