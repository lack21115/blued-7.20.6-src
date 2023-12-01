package com.youzan.spiderman.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/utils/NetWorkUtil.class */
public class NetWorkUtil {
    public static String STATE_2G = "2G";
    public static String STATE_3G = "3G";
    public static String STATE_4G = "4G";
    public static String STATE_WIFI = "wifi";
    public static String STAT_UNCONNECTION = "unconnection";
    public static String UNKNOWN = "unknown";

    public static String getConnectionStatus(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        if (networkInfo != null && networkInfo.isConnected()) {
            int type = networkInfo.getType();
            int subtype = networkInfo.getSubtype();
            if (type == 1) {
                return STATE_WIFI;
            }
            if (type == 0) {
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return STATE_2G;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return STATE_3G;
                    case 13:
                        return STATE_4G;
                    default:
                        return UNKNOWN;
                }
            }
        }
        return STAT_UNCONNECTION;
    }

    public static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        if (hasNetworkStatePermission(context) && (connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)) != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static boolean hasNetworkInternetPermission(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context != null && context.checkSelfPermission("android.permission.INTERNET") == 0;
        }
        return true;
    }

    public static boolean hasNetworkPermission(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context != null && context.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 && context.checkSelfPermission("android.permission.INTERNET") == 0;
        }
        return true;
    }

    public static boolean hasNetworkStatePermission(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context != null && context.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0;
        }
        return true;
    }

    public static boolean isConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean isConnectedWifi(Context context) {
        try {
            NetworkInfo networkInfo = getNetworkInfo(context);
            if (networkInfo == null || !networkInfo.isConnected()) {
                return false;
            }
            return networkInfo.getType() == 1;
        } catch (Exception e) {
            Logger.e("error", e);
            return true;
        }
    }
}
