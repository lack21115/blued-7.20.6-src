package com.bytedance.bdtracker;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.efs.sdk.base.core.util.NetworkUtil;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/s2.class */
public class s2 {

    /* renamed from: a  reason: collision with root package name */
    public static long f21301a;
    public static a b = a.UNKNOWN;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f21302c = false;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/s2$a.class */
    public enum a {
        UNKNOWN(-1),
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5),
        MOBILE_5G(6),
        WIFI_24GHZ(7),
        WIFI_5GHZ(8),
        MOBILE_3G_H(9),
        MOBILE_3G_HP(10);
        

        /* renamed from: a  reason: collision with root package name */
        public final int f21304a;

        a(int i) {
            this.f21304a = i;
        }

        public boolean a() {
            return (this == UNKNOWN || this == NONE) ? false : true;
        }
    }

    public static void a(Context context) {
        if (System.currentTimeMillis() - f21301a > 2000) {
            b = d(context);
            f21301a = System.currentTimeMillis();
        }
    }

    public static void b(Context context) {
        if (!f21302c && context != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
            intentFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
            context.getApplicationContext().registerReceiver(new d1(), intentFilter);
            f21302c = true;
        }
        if (b == a.UNKNOWN) {
            b = d(context);
        }
    }

    public static String c(Context context) {
        a d = d(context);
        return d == a.WIFI ? "wifi" : d == a.WIFI_24GHZ ? "wifi24ghz" : d == a.WIFI_5GHZ ? "wifi5ghz" : d == a.MOBILE_2G ? "2g" : d == a.MOBILE_3G ? "3g" : d == a.MOBILE_3G_H ? "3gh" : d == a.MOBILE_3G_HP ? "3ghp" : d == a.MOBILE_4G ? "4g" : d == a.MOBILE_5G ? NetworkUtil.NETWORK_CLASS_5G : d == a.MOBILE ? "mobile" : "";
    }

    public static a d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return a.WIFI;
                }
                if (type == 0) {
                    int networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                    if (networkType != 3) {
                        if (networkType == 20) {
                            return a.MOBILE_5G;
                        }
                        if (networkType != 5 && networkType != 6) {
                            switch (networkType) {
                                case 8:
                                case 9:
                                case 10:
                                    break;
                                default:
                                    switch (networkType) {
                                        case 12:
                                        case 14:
                                        case 15:
                                            break;
                                        case 13:
                                            return a.MOBILE_4G;
                                        default:
                                            return a.MOBILE;
                                    }
                            }
                        }
                    }
                    return a.MOBILE_3G;
                }
                return a.MOBILE;
            }
            return a.NONE;
        } catch (Throwable th) {
            return a.MOBILE;
        }
    }

    public static boolean e(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            boolean z = false;
            if (activeNetworkInfo != null) {
                z = false;
                if (activeNetworkInfo.isConnected()) {
                    z = true;
                }
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }
}
