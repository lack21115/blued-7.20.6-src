package com.soft.blued.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.blued.android.core.AppInfo;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/NetworkUtils.class */
public class NetworkUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21072a = NetworkUtils.class.getSimpleName();

    public static String a() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) AppInfo.d().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            String str = "";
            if (activeNetworkInfo != null) {
                str = "";
                if (activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() == 1) {
                        return "wifi";
                    }
                    str = "";
                    if (activeNetworkInfo.getType() == 0) {
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        int subtype = activeNetworkInfo.getSubtype();
                        if (subtype != 20) {
                            switch (subtype) {
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
                                    return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA")) ? "3G" : subtypeName.equalsIgnoreCase("CDMA2000") ? "3G" : subtypeName;
                            }
                        }
                        str = "5G";
                    }
                }
            }
            return str;
        } catch (Exception e) {
            return "";
        }
    }

    public static int b() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) AppInfo.d().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            int i = 0;
            if (activeNetworkInfo != null) {
                i = 0;
                if (activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() == 1) {
                        return 2;
                    }
                    i = 0;
                    if (activeNetworkInfo.getType() == 0) {
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        int subtype = activeNetworkInfo.getSubtype();
                        if (subtype != 20) {
                            switch (subtype) {
                                case 1:
                                case 2:
                                case 4:
                                case 7:
                                case 11:
                                    return 4;
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                case 9:
                                case 10:
                                case 12:
                                case 14:
                                case 15:
                                    return 5;
                                case 13:
                                    return 6;
                                default:
                                    if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA")) {
                                        return 5;
                                    }
                                    i = 0;
                                    if (subtypeName.equalsIgnoreCase("CDMA2000")) {
                                        return 5;
                                    }
                                    break;
                            }
                        } else {
                            i = 7;
                        }
                    }
                }
            }
            return i;
        } catch (Exception e) {
            return 0;
        }
    }
}
