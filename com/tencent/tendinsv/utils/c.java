package com.tencent.tendinsv.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int f25402a = -1231545315;

    public static boolean a(Context context) {
        return c(context) == 1;
    }

    public static boolean a(Context context, Object[] objArr) {
        try {
            if (b(context)) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                Class<?> cls = connectivityManager.getClass();
                Class<?>[] clsArr = null;
                if (objArr != null) {
                    clsArr = new Class[]{objArr.getClass()};
                }
                return ((Boolean) cls.getMethod("getMobileDataEnabled", clsArr).invoke(connectivityManager, objArr)).booleanValue();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            l.d(com.tencent.tendinsv.b.F, "getMobileDataState--Exception_e=", e);
            return false;
        }
    }

    public static boolean b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        int simState = telephonyManager != null ? telephonyManager.getSimState() : 0;
        boolean z = false;
        if (simState != 0) {
            z = false;
            if (simState != 1) {
                z = true;
            }
        }
        return z;
    }

    private static int c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.getType() : f25402a;
    }
}
