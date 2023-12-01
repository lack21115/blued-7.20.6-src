package com.tencent.thumbplayer.utils;

import android.Manifest;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseIntArray;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static int f25742a = -1;
    private static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static int f25743c = -1;
    private static final SparseIntArray d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        d = sparseIntArray;
        sparseIntArray.put(1, 1);
        d.put(2, 1);
        d.put(4, 1);
        d.put(7, 1);
        d.put(11, 1);
        d.put(3, 2);
        d.put(5, 2);
        d.put(6, 2);
        d.put(8, 2);
        d.put(9, 2);
        d.put(10, 2);
        d.put(12, 2);
        d.put(14, 2);
        d.put(15, 2);
        d.put(13, 3);
    }

    public static int a(Context context) {
        int i = f25742a;
        if (i <= 0 || b) {
            if (context == null) {
                return -1;
            }
            int g = g(context);
            f25742a = g;
            return g;
        }
        return i;
    }

    private static int a(Context context, int i) {
        return Build.VERSION.SDK_INT >= 29 ? h(context) : b(context, i);
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static boolean a(Context context, String str) {
        boolean z = true;
        if (a()) {
            if (context == null || TextUtils.isEmpty(str)) {
                return false;
            }
            if (Manifest.permission.WRITE_SETTINGS.equals(str)) {
                return Settings.System.canWrite(context);
            }
            try {
                if (context.checkSelfPermission(str) != 0) {
                    z = false;
                }
                return z;
            } catch (Exception e) {
                TPLogUtil.e("TPNetWorkUtils", e.getMessage());
                return false;
            }
        }
        return true;
    }

    private static int b(Context context, int i) {
        if (d(context) == 20) {
            TPLogUtil.i("TPNetWorkUtils", "get5GNetworkTypeIfNeed netWorkType==4");
            return 4;
        }
        Integer valueOf = Integer.valueOf(d.get(i));
        if (valueOf == null) {
            return -1;
        }
        return valueOf.intValue();
    }

    public static void b(Context context) {
        b = true;
        c(context);
        a(context);
        b = false;
    }

    public static boolean c(Context context) {
        int i = f25743c;
        if (i != -1 && !b) {
            return i == 1;
        }
        if (context != null) {
            try {
                NetworkInfo f = f(context);
                f25743c = 0;
                if (f != null && f.getState() == NetworkInfo.State.CONNECTED) {
                    f25743c = 1;
                }
            } catch (Exception e) {
                TPLogUtil.e("TPNetWorkUtils", e.getMessage());
            }
        }
        return f25743c == 1;
    }

    private static int d(Context context) {
        TelephonyManager telephonyManager;
        int i = 0;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Throwable th) {
            th = th;
        }
        if (telephonyManager == null) {
            TPLogUtil.e("TPNetWorkUtils", "get5GNetworkTypeIfNeed TelephonyManager is null");
            return 0;
        } else if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            TPLogUtil.e("TPNetWorkUtils", "get5GNetworkTypeIfNeed no permission");
            return 0;
        } else if (Build.VERSION.SDK_INT < 29) {
            TPLogUtil.e("TPNetWorkUtils", "get5GNetworkTypeIfNeed less api 29");
            return 0;
        } else {
            int i2 = telephonyManager.getNetworkType();
            try {
            } catch (Throwable th2) {
                th = th2;
                i = i2;
                TPLogUtil.e("TPNetWorkUtils", th.getMessage());
                i2 = i;
                return i2;
            }
            if (i2 != 13) {
                TPLogUtil.i("TPNetWorkUtils", "get5GNetworkTypeIfNeed not NETWORK_TYPE_LTE");
                return i2;
            }
            ServiceState serviceState = telephonyManager.getServiceState();
            if (serviceState == null) {
                TPLogUtil.e("TPNetWorkUtils", "get5GNetworkTypeIfNeed serviceState is null");
                return i2;
            }
            int intValue = ((Integer) k.a(serviceState, "android.telephony.ServiceState", "getNrState", new Class[0], new Object[0])).intValue();
            if (intValue == 2 || intValue == 3) {
                TPLogUtil.i("TPNetWorkUtils", "get5GNetworkTypeIfNeed networkType is 20, 5G");
                return 20;
            }
            return i2;
        }
    }

    private static ConnectivityManager e(Context context) {
        if (context == null) {
            return null;
        }
        return (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    private static NetworkInfo f(Context context) {
        ConnectivityManager e = e(context);
        if (e == null) {
            return null;
        }
        return e.getActiveNetworkInfo();
    }

    private static int g(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                return -1;
            }
            int type = activeNetworkInfo.getType();
            return type != 0 ? type != 1 ? -1 : 0 : a(context, activeNetworkInfo.getSubtype());
        } catch (Throwable th) {
            TPLogUtil.e("TPNetWorkUtils", th.getMessage());
            return -1;
        }
    }

    private static int h(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (a(context, "android.permission.READ_PHONE_STATE")) {
                return b(context, telephonyManager.getDataNetworkType());
            }
            TPLogUtil.e("TPNetWorkUtils", "getNetWorkClassAPI29 fail: no phone permission");
            return -1;
        } catch (Throwable th) {
            TPLogUtil.e("TPNetWorkUtils", th.getMessage());
            return -1;
        }
    }
}
