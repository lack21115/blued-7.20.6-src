package com.blued.android.module.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/NetworkUtils.class */
public class NetworkUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10889a = NetworkUtils.class.getSimpleName();

    public static boolean a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) AppInfo.d().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return false;
        }
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
            Logger.b(f10889a, "  正常联网的非wifi状态");
            return true;
        }
        Logger.b(f10889a, "  wifi状态");
        return false;
    }

    public static boolean b() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) AppInfo.d().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    public static boolean c() {
        if (b()) {
            return true;
        }
        AppMethods.d(R.string.common_net_error);
        return false;
    }

    public static String d() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) AppInfo.d().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            String str = "";
            if (activeNetworkInfo != null) {
                str = "";
                if (activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() != 1) {
                        str = "";
                        if (activeNetworkInfo.getType() == 0) {
                            str = activeNetworkInfo.getSubtypeName();
                            switch (activeNetworkInfo.getSubtype()) {
                                case 1:
                                case 2:
                                case 4:
                                case 7:
                                case 11:
                                    return "2G";
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                case 9:
                                case 10:
                                case 12:
                                case 14:
                                case 15:
                                    return "3G";
                                case 13:
                                    return "4G";
                                default:
                                    if (str.equalsIgnoreCase("TD-SCDMA") || str.equalsIgnoreCase("WCDMA")) {
                                        return "3G";
                                    }
                                    if (str.equalsIgnoreCase("CDMA2000")) {
                                        return "3G";
                                    }
                                    break;
                            }
                        }
                    } else {
                        return "wifi";
                    }
                }
            }
            return str;
        } catch (Exception e) {
            return "";
        }
    }
}
