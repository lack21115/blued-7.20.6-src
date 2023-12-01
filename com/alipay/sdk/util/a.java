package com.alipay.sdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/util/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4656a = "00:00:00:00:00:00";

    /* renamed from: c  reason: collision with root package name */
    private static a f4657c;
    private String b;

    private a(Context context) {
        try {
            try {
                String macAddress = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
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
            this.b = f4656a;
        } catch (Throwable th) {
            if (TextUtils.isEmpty(this.b)) {
                this.b = f4656a;
            }
            throw th;
        }
    }

    public static a a(Context context) {
        if (f4657c == null) {
            f4657c = new a(context);
        }
        return f4657c;
    }

    public static d b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
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
