package com.tencent.tendinsv.utils;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.tencent.tendinsv.a.b;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/e.class */
public class e {
    public static String a() {
        String str = "";
        try {
            if (com.tencent.tendinsv.b.P) {
                Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                str = "";
                while (it.hasNext()) {
                    Iterator it2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses()).iterator();
                    String str2 = str;
                    while (true) {
                        str = str2;
                        if (it2.hasNext()) {
                            InetAddress inetAddress = (InetAddress) it2.next();
                            if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                                str2 = inetAddress.getHostAddress();
                            }
                        }
                    }
                }
            }
            return str;
        } catch (Exception e) {
            return "";
        }
    }

    public static String a(Context context) {
        String str = "";
        try {
            int intValue = g.a(context, 1).intValue();
            String b = intValue == 0 ? t.b(context, com.tencent.tendinsv.b.l, (String) null) : t.b(context, com.tencent.tendinsv.b.m, (String) null);
            String str2 = b;
            if (d.a(b)) {
                str2 = b;
                if (com.tencent.tendinsv.b.n) {
                    str2 = b;
                    if (a(context, "android.permission.READ_PHONE_STATE")) {
                        String str3 = b;
                        str2 = a(context, intValue);
                        if (!d.b(str2)) {
                            t.a(context, com.tencent.tendinsv.b.l, "1");
                            t.a(context, com.tencent.tendinsv.b.m, "1");
                        } else if (intValue == 0) {
                            t.a(context, com.tencent.tendinsv.b.l, str2);
                        } else {
                            t.a(context, com.tencent.tendinsv.b.m, str2);
                        }
                    }
                }
            }
            str = str2;
            l.b(com.tencent.tendinsv.b.O, "i_DefaultData", str2);
            return str2;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String a(Context context, int i) {
        try {
            l.b(com.tencent.tendinsv.b.O, "ime by system", Integer.valueOf(i));
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return (String) telephonyManager.getClass().getMethod("getImei", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i));
        } catch (Exception e) {
            return "";
        }
    }

    public static void a(Context context, String[] strArr) {
        try {
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                String str = strArr[i2];
                if (a(context, str)) {
                    l.a(com.tencent.tendinsv.b.K, "getPermission success:", str);
                } else {
                    l.a(com.tencent.tendinsv.b.K, "getPermission lacks:", str);
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            l.d(com.tencent.tendinsv.b.F, "getPermission Exception_e:", e);
        }
    }

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public static boolean a(int i, Context context) {
        synchronized (e.class) {
            try {
                try {
                    if (com.tencent.tendinsv.b.aA) {
                        return p.c(context);
                    }
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    l.d(com.tencent.tendinsv.b.F, "checkProcess Exception", e, b.a.u, Integer.valueOf(i));
                    return true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static String b() {
        return Build.MANUFACTURER;
    }

    public static String c() {
        try {
            return d.b(Build.DISPLAY) ? Build.DISPLAY : "";
        } catch (Exception e) {
            e.printStackTrace();
            l.d(com.tencent.tendinsv.b.F, "getDisplayVersion  Exception_e=", e);
            return "";
        }
    }
}
