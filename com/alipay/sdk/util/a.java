package com.alipay.sdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.android.internal.util.cm.QSConstants;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/util/a.class */
public class a {
    private static final String a = "00:00:00:00:00:00";
    private static a c;
    private String b;

    private a(Context context) {
        try {
            try {
                String macAddress = ((WifiManager) context.getApplicationContext().getSystemService(QSConstants.TILE_WIFI)).getConnectionInfo().getMacAddress();
                this.b = macAddress;
                if (!TextUtils.isEmpty(macAddress)) {
                    return;
                }
            } catch (Exception e) {
                c.a(e);
                if (!TextUtils.isEmpty(this.b)) {
                    return;
                }
            }
            this.b = a;
        } catch (Throwable th) {
            if (TextUtils.isEmpty(this.b)) {
                this.b = a;
            }
            throw th;
        }
    }

    public static a a(Context context) {
        if (c == null) {
            c = new a(context);
        }
        return c;
    }

    public static d b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            return (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) ? (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) ? d.NONE : d.WIFI : d.a(activeNetworkInfo.getSubtype());
        } catch (Exception e) {
            return d.NONE;
        }
    }

    public static String c(Context context) {
        return a(context).c().substring(0, 8);
    }

    public static String d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getResources().getConfiguration().locale.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    public String a() {
        return "000000000000000";
    }

    public String b() {
        return "000000000000000";
    }

    public String c() {
        String str = b() + "|";
        String a2 = a();
        if (TextUtils.isEmpty(a2)) {
            return str + "000000000000000";
        }
        return str + a2;
    }

    public String d() {
        return this.b;
    }
}
