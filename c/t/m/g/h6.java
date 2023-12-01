package c.t.m.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import com.efs.sdk.base.core.util.NetworkUtil;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/h6.class */
public class h6 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3785a = false;
    public static long b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f3786c = false;
    public static volatile boolean d = false;
    public static List<ScanResult> e;
    public static long f;
    public static final Comparator<ScanResult> g = new a();

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/h6$a.class */
    public static final class a implements Comparator<ScanResult> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ScanResult scanResult, ScanResult scanResult2) {
            return scanResult2.level - scanResult.level;
        }
    }

    public static int a(WifiManager wifiManager) {
        if (wifiManager != null) {
            try {
                return wifiManager.getWifiState();
            } catch (Throwable th) {
                return 4;
            }
        }
        return 4;
    }

    public static String a(t3 t3Var) {
        String bssid;
        Context context = t3Var.f3944a;
        if (context == null) {
            return "{}";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (wifiManager == null || connectivityManager == null) {
                return "{}";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (connectionInfo == null || networkInfo == null || !networkInfo.isConnected() || (bssid = connectionInfo.getBSSID()) == null || bssid.equals("000000000000") || bssid.equals("00-00-00-00-00-00") || bssid.equals("00:00:00:00:00:00") || bssid.equals("02:00:00:00:00:00")) {
                return "{}";
            }
            int rssi = connectionInfo.getRssi();
            String replace = connectionInfo.getSSID().replace("\"", "").replace("|", "");
            String replace2 = bssid.replace(":", "");
            return "{\"mac\":\"" + replace2 + "\",\"rssi\":" + rssi + ",\"ssid\":\"" + replace + "\"}";
        } catch (Exception e2) {
            return "{}";
        }
    }

    public static List<ScanResult> a(WifiManager wifiManager, boolean z) {
        List<ScanResult> list;
        synchronized (h6.class) {
            if (z) {
                list = null;
            } else {
                try {
                    List<ScanResult> list2 = System.currentTimeMillis() - f < 20000 ? e : null;
                    list = list2;
                    if (list2 != null) {
                        list2.size();
                        return list2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            e = null;
            f = 0L;
            List<ScanResult> list3 = list;
            if (wifiManager != null) {
                try {
                    list3 = wifiManager.getScanResults();
                    e = list3;
                    f = System.currentTimeMillis();
                    list3.size();
                    list = list3;
                    f3785a = false;
                } catch (Exception e2) {
                    f3785a = true;
                    s3.a("WIFI", NetworkUtil.NETWORK_CLASS_DENIED);
                    list3 = list;
                }
            }
            List<ScanResult> list4 = list3;
            if (list3 == null) {
                list4 = Collections.emptyList();
            }
            return list4;
        }
    }

    public static boolean b(WifiManager wifiManager) {
        boolean z;
        synchronized (h6.class) {
            z = false;
            if (wifiManager != null) {
                z = false;
                try {
                    try {
                        if (d || System.currentTimeMillis() - b <= com.anythink.expressad.video.module.a.a.m.ag) {
                            z = f3786c;
                        } else {
                            boolean startScan = wifiManager.startScan();
                            f3786c = startScan;
                            b = System.currentTimeMillis();
                            z = startScan;
                        }
                    } catch (Exception e2) {
                        f3785a = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return z;
    }

    public static boolean b(t3 t3Var) {
        try {
            WifiManager f2 = t3Var.f();
            boolean z = false;
            if (f2 != null) {
                z = false;
                if (f2.isWifiEnabled()) {
                    z = true;
                }
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean c(t3 t3Var) {
        WifiManager f2 = t3Var.f();
        boolean z = false;
        if (f2 != null) {
            boolean z2 = false;
            try {
                if (Build.VERSION.SDK_INT >= 23 && Settings.Secure.getInt(t3Var.f3944a.getContentResolver(), Settings.Secure.LOCATION_MODE) == 0) {
                    return false;
                }
                boolean isWifiEnabled = f2.isWifiEnabled();
                z = isWifiEnabled;
                if (!isWifiEnabled) {
                    z = isWifiEnabled;
                    if (Build.VERSION.SDK_INT >= 18) {
                        z2 = isWifiEnabled;
                        return f2.isScanAlwaysAvailable();
                    }
                }
            } catch (Throwable th) {
                z = z2;
                if (th instanceof SecurityException) {
                    f3785a = true;
                    z = z2;
                }
            }
        }
        return z;
    }
}
