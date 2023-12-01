package c.t.m.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/j3.class */
public class j3 {

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/j3$a.class */
    public enum a {
        NETWORK_NONE,
        NETWORK_MOBILE,
        NETWORK_WIFI
    }

    public static String a() {
        return a(q2.a());
    }

    @Deprecated
    public static String a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) q3.b(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getTypeName().toUpperCase() + "[" + activeNetworkInfo.getSubtypeName() + "]";
            }
            return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        } catch (Throwable th) {
            return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public static a b() {
        return b(q2.a());
    }

    @Deprecated
    public static a b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) q3.b(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return Build.VERSION.SDK_INT >= 16 ? connectivityManager.isActiveNetworkMetered() ? a.NETWORK_MOBILE : a.NETWORK_WIFI : 1 == activeNetworkInfo.getType() ? a.NETWORK_WIFI : a.NETWORK_MOBILE;
            }
            return a.NETWORK_NONE;
        } catch (Throwable th) {
            return a.NETWORK_NONE;
        }
    }
}
