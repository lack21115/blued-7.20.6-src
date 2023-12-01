package com.blued.android.framework.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.blued.android.core.AppInfo;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/NetworkUtils.class */
public class NetworkUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10108a = NetworkUtils.class.getSimpleName();

    public static boolean a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) AppInfo.d().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return false;
        }
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
            Logger.b(f10108a, "  正常联网的非wifi状态");
            return true;
        }
        Logger.b(f10108a, "  wifi状态");
        return false;
    }

    public static boolean b() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) AppInfo.d().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }
}
