package com.sobot.chat.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/IntenetUtil.class */
public class IntenetUtil {
    private static final String NETWORK_2G = "2G";
    private static final String NETWORK_3G = "3G";
    private static final String NETWORK_4G = "4G";
    private static final String NETWORK_NO = "无网络";
    private static final int NETWORK_TYPE_GSM = 16;
    private static final int NETWORK_TYPE_IWLAN = 18;
    private static final int NETWORK_TYPE_TD_SCDMA = 17;
    private static final String NETWORK_UNKNOWN = "未知";
    private static final String NETWORK_WIFI = "WIFI";

    private static NetworkInfo getActiveNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
    }

    public static String getNetworkType(Context context) {
        String str;
        String str2;
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            str = NETWORK_NO;
        } else if (activeNetworkInfo.getType() == 1) {
            return NETWORK_WIFI;
        } else {
            str = NETWORK_UNKNOWN;
            if (activeNetworkInfo.getType() == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        str2 = NETWORK_2G;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return NETWORK_3G;
                    case 13:
                    case 18:
                        str2 = NETWORK_4G;
                        break;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA")) {
                            return NETWORK_3G;
                        }
                        str = NETWORK_UNKNOWN;
                        if (subtypeName.equalsIgnoreCase("CDMA2000")) {
                            return NETWORK_3G;
                        }
                        break;
                }
                return str2;
            }
        }
        return str;
    }

    public static boolean isWifiConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean z = false;
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            z = false;
            if (activeNetworkInfo != null) {
                z = false;
                if (activeNetworkInfo.getType() == 1) {
                    z = true;
                }
            }
        }
        return z;
    }
}
