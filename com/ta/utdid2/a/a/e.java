package com.ta.utdid2.a.a;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Random;

/* loaded from: source-8457232-dex2jar.jar:com/ta/utdid2/a/a/e.class */
public class e {
    public static String a() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        byte[] bytes = d.getBytes(currentTimeMillis);
        byte[] bytes2 = d.getBytes(nanoTime);
        byte[] bytes3 = d.getBytes(nextInt);
        byte[] bytes4 = d.getBytes(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, 4);
        System.arraycopy(bytes2, 0, bArr, 4, 4);
        System.arraycopy(bytes3, 0, bArr, 8, 4);
        System.arraycopy(bytes4, 0, bArr, 12, 4);
        return b.encodeToString(bArr, 2);
    }

    public static String a(Context context) {
        String str = null;
        if (!c.a()) {
            str = null;
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    str = null;
                    if (telephonyManager != null) {
                        str = telephonyManager.getDeviceId();
                    }
                } catch (Exception e) {
                    str = null;
                }
            }
        }
        String str2 = str;
        if (g.m6840a(str)) {
            str2 = b();
        }
        String str3 = str2;
        if (g.m6840a(str2)) {
            str3 = b(context);
        }
        String str4 = str3;
        if (g.m6840a(str3)) {
            str4 = a();
        }
        return str4;
    }

    private static String b() {
        String str = h.get("ro.aliyun.clouduuid", "");
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = h.get("ro.sys.aliyun.clouduuid", "");
        }
        return TextUtils.isEmpty(str2) ? c() : str2;
    }

    private static String b(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            str = "";
        }
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("a5f5faddde9e9f02") || str.equalsIgnoreCase("8e17f7422b35fbea")) {
            return "";
        }
        if (str.equalsIgnoreCase("0000000000000000")) {
            return "";
        }
        return str;
    }

    private static String c() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            return "";
        }
    }

    public static String c(Context context) {
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                str = null;
                if (telephonyManager != null) {
                    str = telephonyManager.getSubscriberId();
                }
            } catch (Exception e) {
                str = null;
            }
        }
        String str2 = str;
        if (g.m6840a(str)) {
            str2 = a();
        }
        return str2;
    }
}
