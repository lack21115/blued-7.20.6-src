package com.alibaba.mtl.log.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/l.class */
public class l {

    /* renamed from: a  reason: collision with other field name */
    private static String[] f39a = {"Unknown", "Unknown"};

    /* renamed from: a  reason: collision with other field name */
    private static b f38a = new b();

    /* renamed from: a  reason: collision with root package name */
    private static a f4498a = new a();

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/l$a.class */
    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Context f4499a;

        private a() {
        }

        public a a(Context context) {
            this.f4499a = context;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.f4499a;
            if (context == null) {
                return;
            }
            try {
                if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.f4499a.getPackageName()) != 0) {
                    l.f39a[0] = "Unknown";
                    return;
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) this.f4499a.getSystemService(Context.CONNECTIVITY_SERVICE);
                if (connectivityManager == null) {
                    l.f39a[0] = "Unknown";
                    return;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    return;
                }
                if (1 == activeNetworkInfo.getType()) {
                    l.f39a[0] = "Wi-Fi";
                } else if (activeNetworkInfo.getType() == 0) {
                    l.f39a[0] = "2G/3G";
                    l.f39a[1] = activeNetworkInfo.getSubtypeName();
                }
            } catch (Exception e) {
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/l$b.class */
    static class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            r.a().b(l.f4498a.a(context));
        }
    }

    private static String a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "Unknown";
        }
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        context.registerReceiver(f38a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public static void b(Context context) {
        b bVar;
        if (context == null || (bVar = f38a) == null) {
            return;
        }
        context.unregisterReceiver(bVar);
    }

    public static String[] getNetworkState(Context context) {
        return f39a;
    }

    public static String getWifiAddress(Context context) {
        String str = "00:00:00:00:00:00";
        if (context != null) {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            str = "00:00:00:00:00:00";
            if (connectionInfo != null) {
                str = connectionInfo.getMacAddress();
                if (TextUtils.isEmpty(str)) {
                    return "00:00:00:00:00:00";
                }
            }
        }
        return str;
    }

    public static boolean isConnected() {
        Context context = com.alibaba.mtl.log.a.getContext();
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        return activeNetworkInfo.isConnected();
                    }
                    return false;
                }
                return true;
            } catch (Exception e) {
                return true;
            }
        }
        return true;
    }

    public static String u() {
        NetworkInfo activeNetworkInfo;
        Context context = com.alibaba.mtl.log.a.getContext();
        if (context == null) {
            return "Unknown";
        }
        try {
            return (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0 && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) ? activeNetworkInfo.getType() == 1 ? "wifi" : activeNetworkInfo.getType() == 0 ? a(activeNetworkInfo.getSubtype()) : "Unknown" : "Unknown";
        } catch (Throwable th) {
            return "Unknown";
        }
    }
}
