package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/utils/NetworkHelper.class */
public class NetworkHelper {
    public static void clearCookies(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
        CookieSyncManager.getInstance().sync();
    }

    public static String generateUA(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("Android");
        sb.append("__");
        sb.append("weibo");
        sb.append("__");
        sb.append("sdk");
        sb.append("__");
        try {
            sb.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName.replaceAll("\\s+", BridgeUtil.UNDERLINE_STR));
        } catch (Exception e) {
            sb.append("unknown");
        }
        return sb.toString();
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
    }

    public static NetworkInfo getNetworkInfo(Context context, int i) {
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getNetworkInfo(i);
    }

    public static int getNetworkType(Context context) {
        int i = -1;
        if (context != null) {
            NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
            if (activeNetworkInfo == null) {
                return -1;
            }
            i = activeNetworkInfo.getType();
        }
        return i;
    }

    public static NetworkInfo.DetailedState getWifiConnectivityState(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context, 1);
        return networkInfo == null ? NetworkInfo.DetailedState.FAILED : networkInfo.getDetailedState();
    }

    public static int getWifiState(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            return 4;
        }
        return wifiManager.getWifiState();
    }

    public static boolean hasInternetPermission(Context context) {
        return context == null || context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
    }

    public static boolean isMobileNetwork(Context context) {
        NetworkInfo activeNetworkInfo;
        return (context == null || (activeNetworkInfo = getActiveNetworkInfo(context)) == null || activeNetworkInfo == null || activeNetworkInfo.getType() != 0 || !activeNetworkInfo.isConnected()) ? false : true;
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        return (context == null || (activeNetworkInfo = getActiveNetworkInfo(context)) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }

    public static boolean isWifiValid(Context context) {
        NetworkInfo activeNetworkInfo;
        return context != null && (activeNetworkInfo = getActiveNetworkInfo(context)) != null && 1 == activeNetworkInfo.getType() && activeNetworkInfo.isConnected();
    }

    public static boolean wifiConnection(Context context, String str, String str2) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        String str3 = "\"" + str + "\"";
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        boolean z = true;
        if (connectionInfo != null) {
            if (!str.equals(connectionInfo.getSSID())) {
                if (str3.equals(connectionInfo.getSSID())) {
                    return true;
                }
            }
            return z;
        }
        List<ScanResult> scanResults = wifiManager.getScanResults();
        if (scanResults != null && scanResults.size() != 0) {
            int size = scanResults.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                String str4 = scanResults.get(i).SSID;
                if (str.equals(str4) || str3.equals(str4)) {
                    break;
                }
                size = i;
            }
            WifiConfiguration wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.SSID = str3;
            wifiConfiguration.preSharedKey = "\"" + str2 + "\"";
            wifiConfiguration.status = 2;
            return wifiManager.enableNetwork(wifiManager.addNetwork(wifiConfiguration), false);
        }
        z = false;
        return z;
    }
}
