package com.anythink.china.b;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.core.common.b.n;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/b/d.class */
public final class d {
    public static String a() {
        NetworkInterface networkInterface;
        try {
            Iterator<E> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            do {
                if (!it.hasNext()) {
                    return "";
                }
                networkInterface = (NetworkInterface) it.next();
            } while (!networkInterface.getName().equalsIgnoreCase("wlan0"));
            byte[] hardwareAddress = networkInterface.getHardwareAddress();
            if (hardwareAddress == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int length = hardwareAddress.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
                i = i2 + 1;
            }
            if (!TextUtils.isEmpty(sb)) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(Context context) {
        WifiInfo wifiInfo;
        if (context == null) {
            return "";
        }
        try {
            wifiInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        } catch (Throwable th) {
            th.printStackTrace();
            wifiInfo = null;
        }
        if (wifiInfo == null) {
            return null;
        }
        String macAddress = wifiInfo.getMacAddress();
        String str = macAddress;
        if (!TextUtils.isEmpty(macAddress)) {
            str = macAddress.toUpperCase(Locale.ENGLISH);
        }
        return str;
    }

    private static String b(Context context) {
        return n.a().c("mac") ? "" : Build.VERSION.SDK_INT < 23 ? a(context) : a();
    }
}
