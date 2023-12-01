package c.t.m.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/r3.class */
public class r3 {
    public static WifiInfo a() {
        return a(q2.a());
    }

    @Deprecated
    public static WifiInfo a(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) q2.a().getApplicationContext().getSystemService("wifi");
            ConnectivityManager connectivityManager = context == null ? null : (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (wifiManager == null || connectivityManager == null) {
                return null;
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (connectionInfo == null || networkInfo == null || !networkInfo.isConnected()) {
                return null;
            }
            if (a(connectionInfo.getBSSID())) {
                return connectionInfo;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static boolean a(String str) {
        return (str == null || str.equals("000000000000") || str.equals("00-00-00-00-00-00") || str.equals("00:00:00:00:00:00")) ? false : true;
    }
}
