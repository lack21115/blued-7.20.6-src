package com.anythink.china.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.android.internal.util.cm.QSConstants;
import com.blued.android.module.yy_china.model.YYGiftPackageModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/b/b.class */
public final class b {
    private static final String[] a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    public static String a() {
        boolean z;
        try {
            String[] strArr = a;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                z = false;
                if (i2 >= length) {
                    break;
                } else if (new File(strArr[i2]).exists()) {
                    z = true;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (Build.TAGS != null) {
                if (Build.TAGS.contains("test-keys")) {
                    return "1";
                }
            }
            return z ? "1" : "2";
        } catch (Throwable th) {
            return "";
        }
    }

    public static String a(Context context) {
        int port;
        String str;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                String property = System.getProperty("http.proxyHost");
                String property2 = System.getProperty("http.proxyPort");
                if (property2 == null) {
                    property2 = YYGiftPackageModel.YY_GIFT_BAG_TYPE_ID;
                }
                port = Integer.parseInt(property2);
                str = property;
            } else {
                String host = Proxy.getHost(context);
                port = Proxy.getPort(context);
                str = host;
            }
            return (TextUtils.isEmpty(str) || port == -1) ? "2" : "1";
        } catch (Throwable th) {
            return "";
        }
    }

    public static String b() {
        try {
            String str = Build.CPU_ABI;
            String str2 = str;
            if (!TextUtils.isEmpty(Build.CPU_ABI2)) {
                str2 = str + "|" + Build.CPU_ABI2;
            }
            return str2;
        } catch (Throwable th) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b A[Catch: all -> 0x0057, TRY_ENTER, TryCatch #0 {all -> 0x0057, blocks: (B:2:0x0000, B:4:0x0008, B:7:0x0036, B:12:0x004b, B:15:0x0051), top: B:29:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0074 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r4) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L57
            r1 = 28
            if (r0 < r1) goto L50
            r0 = r4
            android.content.Context r0 = r0.getApplicationContext()     // Catch: java.lang.Throwable -> L57
            java.lang.String r1 = "location"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Throwable -> L57
            android.location.LocationManager r0 = (android.location.LocationManager) r0     // Catch: java.lang.Throwable -> L57
            java.lang.String r1 = "gps"
            boolean r0 = r0.isProviderEnabled(r1)     // Catch: java.lang.Throwable -> L57
            r8 = r0
            r0 = r4
            android.content.Context r0 = r0.getApplicationContext()     // Catch: java.lang.Throwable -> L57
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L57
            r9 = r0
            r0 = r9
            java.lang.String r1 = "android.permission.ACCESS_FINE_LOCATION"
            r2 = r4
            java.lang.String r2 = r2.getPackageName()     // Catch: java.lang.Throwable -> L57
            int r0 = r0.checkPermission(r1, r2)     // Catch: java.lang.Throwable -> L57
            r5 = r0
            r0 = 0
            r7 = r0
            r0 = r5
            if (r0 == 0) goto L60
            r0 = r9
            java.lang.String r1 = "android.permission.ACCESS_COARSE_LOCATION"
            r2 = r4
            java.lang.String r2 = r2.getPackageName()     // Catch: java.lang.Throwable -> L57
            int r0 = r0.checkPermission(r1, r2)     // Catch: java.lang.Throwable -> L57
            if (r0 != 0) goto L5b
            goto L60
        L47:
            r0 = r5
            if (r0 == 0) goto L74
            r0 = r4
            java.lang.String r0 = e(r0)     // Catch: java.lang.Throwable -> L57
            return r0
        L50:
            r0 = r4
            java.lang.String r0 = e(r0)     // Catch: java.lang.Throwable -> L57
            r4 = r0
            r0 = r4
            return r0
        L57:
            r4 = move-exception
            java.lang.String r0 = ""
            return r0
        L5b:
            r0 = 0
            r6 = r0
            goto L62
        L60:
            r0 = 1
            r6 = r0
        L62:
            r0 = r7
            r5 = r0
            r0 = r8
            if (r0 == 0) goto L47
            r0 = r7
            r5 = r0
            r0 = r6
            if (r0 == 0) goto L47
            r0 = 1
            r5 = r0
            goto L47
        L74:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.china.b.b.b(android.content.Context):java.lang.String");
    }

    public static String c() {
        try {
            File file = new File("/proc/sys/kernel/random/boot_id");
            if (!file.exists()) {
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return str;
                }
                str = str + readLine;
            }
        } catch (Throwable th) {
            return "";
        }
    }

    public static String[] c(Context context) {
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0);
            StringBuilder sb = new StringBuilder();
            sb.append(packageInfo.firstInstallTime);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(packageInfo.lastUpdateTime);
            return new String[]{sb2, sb3.toString()};
        } catch (Throwable th) {
            return null;
        }
    }

    public static String d() {
        try {
            File file = new File("/data/data");
            if (file.exists()) {
                long lastModified = file.lastModified() / 1000;
                return lastModified + ".000000000";
            }
            return "";
        } catch (Throwable th) {
            return "";
        }
    }

    private static boolean d(Context context) {
        boolean isProviderEnabled = ((LocationManager) context.getApplicationContext().getSystemService(QSConstants.TILE_LOCATION)).isProviderEnabled(GeocodeSearch.GPS);
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return isProviderEnabled && (packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", context.getPackageName()) == 0 || packageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", context.getPackageName()) == 0);
    }

    private static String e(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService(QSConstants.TILE_WIFI)).getConnectionInfo();
            String ssid = connectionInfo == null ? "" : connectionInfo.getSSID();
            String str = ssid;
            if ("<unknown ssid>".equalsIgnoreCase(ssid)) {
                str = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo().getExtraInfo();
            }
            return "<unknown ssid>".equalsIgnoreCase(str) ? "" : str;
        } catch (Throwable th) {
            return "";
        }
    }
}
