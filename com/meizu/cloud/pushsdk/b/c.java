package com.meizu.cloud.pushsdk.b;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f10363a = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(f10363a)) {
            f10363a = !a() ? d(context) : b(context);
            return f10363a;
        }
        return f10363a;
    }

    public static boolean a() {
        String a2 = i.a("ro.target.product");
        if (TextUtils.isEmpty(a2)) {
            DebugLogger.i("DeviceUtils", "current product is phone");
            return true;
        }
        DebugLogger.i("DeviceUtils", "current product is " + a2);
        return false;
    }

    public static String b(Context context) {
        String deviceId;
        try {
            com.meizu.cloud.pushsdk.b.b.d a2 = com.meizu.cloud.pushsdk.b.b.a.a("android.telephony.MzTelephonyManager").a("getDeviceId", new Class[0]).a(new Object[0]);
            if (!a2.f10362a || TextUtils.isEmpty((CharSequence) a2.b)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return null;
                }
                deviceId = telephonyManager.getDeviceId();
            } else {
                deviceId = (String) a2.b;
            }
            return deviceId;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(Context context) {
        return null;
    }

    private static String d(Context context) {
        StringBuilder sb = new StringBuilder();
        String str = Build.SERIAL;
        DebugLogger.i("DeviceUtils", "device serial " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        sb.append(str);
        String c2 = c(context);
        DebugLogger.e("DeviceUtils", "mac address " + c2);
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        sb.append(c2.replace(":", "").toUpperCase());
        return sb.toString();
    }
}
