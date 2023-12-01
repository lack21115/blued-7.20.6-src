package com.opos.cmn.g.a;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/g/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f11265a = "";

    private static String a() {
        NetworkInterface networkInterface;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                Iterator it = Collections.list(networkInterfaces).iterator();
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
                    sb.append(String.format("%02x:", Byte.valueOf(hardwareAddress[i2])));
                    i = i2 + 1;
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
            }
            return "";
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("MacTool", "getMacWithNetWorkInterface", th);
            return "";
        }
    }

    public static String a(Context context) {
        WifiManager wifiManager;
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(f11265a)) {
            try {
                if (Build.VERSION.SDK_INT >= 31) {
                    f11265a = "";
                } else if (Build.VERSION.SDK_INT >= 23) {
                    f11265a = a();
                } else if (context != null && context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0 && (wifiManager = (WifiManager) context.getSystemService("wifi")) != null) {
                    try {
                        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                        if (connectionInfo != null) {
                            f11265a = connectionInfo.getMacAddress();
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.c("MacTool", "getMacAddress", e);
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("MacTool", "getMacAddress", e2);
            }
        }
        if (f11265a == null) {
            f11265a = "";
        }
        com.opos.cmn.an.f.a.b("MacTool", "getMacAddress=" + f11265a + " costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        return f11265a;
    }
}
