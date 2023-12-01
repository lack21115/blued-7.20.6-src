package cn.shuzilm.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/y.class */
public class y {
    public static boolean a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    return true;
                }
                if (type == 0) {
                    return false;
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()).hasTransport(1);
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }
}
