package com.blued.android.framework.utils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.blued.android.core.AppInfo;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/NetworkUtils.class */
public class NetworkUtils {
    private static final String a = NetworkUtils.class.getSimpleName();

    public static boolean a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) AppInfo.d().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return false;
        }
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
            Logger.b(a, "  正常联网的非wifi状态");
            return true;
        }
        Logger.b(a, "  wifi状态");
        return false;
    }

    public static boolean b() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) AppInfo.d().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }
}
