package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Process;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23834a = "android.permission.INTERNET";
    public static final String b = "android.permission.ACCESS_NETWORK_STATE";

    /* renamed from: c  reason: collision with root package name */
    public static final String f23835c = "android.permission.READ_PHONE_STATE";
    public static final String d = "android.permission.ACCESS_WIFI_STATE";
    public static final String e = "android.permission.GET_TASKS";
    public static final String f = "android.permission.GET_ACCOUNTS";
    public static final String g = "android.permission.ACCESS_FINE_LOCATION";
    public static final String h = "android.permission.ACCESS_COARSE_LOCATION";
    public static final String i = "android.permission.READ_EXTERNAL_STORAGE";
    public static final String j = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String k = "android.permission.BIND_ACCESSIBILITY_SERVICE";

    public static int a(Context context, String str) {
        if (context == null || str == null) {
            return -1;
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static boolean a(Context context, String[] strArr) {
        if (strArr == null) {
            return true;
        }
        try {
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return true;
                }
                if (a(context, strArr[i3]) != 0) {
                    return false;
                }
                i2 = i3 + 1;
            }
        } catch (Throwable th) {
            return false;
        }
    }
}
