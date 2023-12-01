package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.huawei.hms.ads.ge;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/ai.class */
public class ai {
    private static final String Code = ai.class.getSimpleName();

    private static int B(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)) == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    return Code(activeNetworkInfo.getSubtype());
                }
                if (9 == type) {
                    return 1;
                }
                return 1 == type ? 2 : 0;
            }
            return 0;
        } catch (Exception e) {
            ge.I(Code, "get net info err");
            return 0;
        }
    }

    private static boolean C(Context context) {
        String str;
        StringBuilder sb;
        if (context != null) {
            try {
                Class<?> cls = Class.forName(c.I() ? "com.hihonor.android.net.wifi.WifiManagerCommonEx" : "com.huawei.android.net.wifi.WifiManagerCommonEx");
                return ((Boolean) cls.getMethod("getHwMeteredHint", Context.class).invoke(cls.newInstance(), context)).booleanValue();
            } catch (ClassNotFoundException e) {
                e = e;
                str = Code;
                sb = new StringBuilder();
                sb.append("isMeteredWifi ");
                sb.append(e.getClass().getSimpleName());
                ge.I(str, sb.toString());
                return false;
            } catch (Throwable th) {
                e = th;
                str = Code;
                sb = new StringBuilder();
                sb.append("isMeteredWifi ");
                sb.append(e.getClass().getSimpleName());
                ge.I(str, sb.toString());
                return false;
            }
        }
        return false;
    }

    private static int Code(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
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
            case 17:
                return 5;
            case 13:
            case 18:
                return 6;
            case 19:
            default:
                return 0;
            case 20:
                return 7;
        }
    }

    public static boolean Code(Context context) {
        if (context == null) {
            return false;
        }
        boolean z = false;
        if (2 == B(context)) {
            z = false;
            if (!C(context)) {
                z = true;
            }
        }
        return z;
    }

    public static boolean I(Context context) {
        return Code(context) || V(context);
    }

    public static boolean V(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        if (1 == B(context)) {
            z = true;
        }
        return z;
    }

    public static boolean Z(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)) == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e) {
            ge.I(Code, "check net conn err");
            return false;
        }
    }
}
