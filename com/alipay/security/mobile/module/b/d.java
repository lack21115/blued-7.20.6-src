package com.alipay.security.mobile.module.b;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.kuaishou.weapon.p0.bh;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.File;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/security/mobile/module/b/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f4707a = new d();

    private d() {
    }

    public static d a() {
        return f4707a;
    }

    private static String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            return str2;
        }
    }

    public static boolean a(Context context) {
        boolean z;
        int length;
        try {
            if (Build.HARDWARE.contains("goldfish") || Build.PRODUCT.contains("sdk") || Build.FINGERPRINT.contains("generic")) {
                return true;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String deviceId = telephonyManager.getDeviceId();
                if (deviceId != null && (length = deviceId.length()) != 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        } else if (!Character.isWhitespace(deviceId.charAt(i2)) && deviceId.charAt(i2) != '0') {
                            z = false;
                            break;
                        } else {
                            i = i2 + 1;
                        }
                    }
                }
                z = true;
                if (z) {
                    return true;
                }
            }
            return com.alipay.security.mobile.module.a.a.a(Settings.Secure.getString(context.getContentResolver(), "android_id"));
        } catch (Exception e) {
            return false;
        }
    }

    public static String b() {
        return "android";
    }

    public static boolean c() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                return false;
            }
            try {
                if (new File(new String[]{"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"}[i2] + bh.y).exists()) {
                    return true;
                }
                i = i2 + 1;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public static String d() {
        return Build.BOARD;
    }

    public static String e() {
        return Build.BRAND;
    }

    public static String f() {
        return Build.DEVICE;
    }

    public static String g() {
        return Build.DISPLAY;
    }

    public static String h() {
        return Build.VERSION.INCREMENTAL;
    }

    public static String i() {
        return Build.MANUFACTURER;
    }

    public static String j() {
        return Build.MODEL;
    }

    public static String k() {
        return Build.PRODUCT;
    }

    public static String l() {
        return Build.VERSION.RELEASE;
    }

    public static String m() {
        return Build.VERSION.SDK;
    }

    public static String n() {
        return Build.TAGS;
    }

    public static String o() {
        return a("ro.kernel.qemu", "0");
    }
}
