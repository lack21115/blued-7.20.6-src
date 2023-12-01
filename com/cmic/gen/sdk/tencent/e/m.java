package com.cmic.gen.sdk.tencent.e;

import android.Manifest;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/e/m.class */
public class m {
    public static int a(Context context, boolean z) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = null;
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            }
            if (networkInfo == null || !networkInfo.isAvailable()) {
                return 0;
            }
            int type = networkInfo.getType();
            if (type != 1) {
                if (type == 0) {
                    c.b("TelephonyUtils", "流量");
                    return 1;
                }
                return 0;
            }
            c.b("TelephonyUtils", "WIFI");
            boolean a2 = g.a(context, Manifest.permission.CHANGE_NETWORK_STATE);
            c.a("TelephonyUtils", "CHANGE_NETWORK_STATE=" + a2);
            if (a2 && z && a(connectivityManager, context)) {
                c.b("TelephonyUtils", "流量数据 WIFI 同开");
                return 3;
            }
            return 2;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String a() {
        return Build.BRAND;
    }

    public static boolean a(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        boolean z = true;
        if (telephonyManager != null) {
            if (1 != telephonyManager.getSimState()) {
                return true;
            }
            z = false;
        }
        return z;
    }

    private static boolean a(ConnectivityManager connectivityManager, Context context) {
        TelephonyManager telephonyManager;
        try {
            if (Build.VERSION.SDK_INT < 26 || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
                declaredMethod.setAccessible(true);
                boolean booleanValue = ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
                c.b("TelephonyUtils", "data is on ---------" + booleanValue);
                return booleanValue;
            }
            return telephonyManager.isDataEnabled();
        } catch (Exception e) {
            c.a("TelephonyUtils", "isMobileEnabled ----反射出错-----");
            return false;
        }
    }

    public static String b() {
        return Build.MODEL;
    }

    public static String c() {
        return "android" + Build.VERSION.RELEASE;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT <= 28;
    }

    public static boolean e() {
        String str = Build.MANUFACTURER;
        c.a("brand", str);
        return "HUAWEI".equalsIgnoreCase(str);
    }
}
