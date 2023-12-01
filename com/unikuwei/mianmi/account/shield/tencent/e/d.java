package com.unikuwei.mianmi.account.shield.tencent.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/e/d.class */
public class d {
    public boolean a(Context context, String str) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo.State state = connectivityManager.getNetworkInfo(5).getState();
            g.a("TYPE_MOBILE_HIPRI network state: " + state);
            if (state.compareTo(NetworkInfo.State.CONNECTED) == 0 || state.compareTo(NetworkInfo.State.CONNECTING) == 0) {
                return true;
            }
            Method method = ConnectivityManager.class.getMethod("startUsingNetworkFeature", Integer.TYPE, String.class);
            method.setAccessible(true);
            int intValue = ((Integer) method.invoke(connectivityManager, 0, "enableHIPRI")).intValue();
            g.a("startUsingNetworkFeature for enableHIPRI result: " + intValue);
            if (-1 == intValue) {
                g.a("Wrong result of startUsingNetworkFeature, maybe problems");
                return false;
            } else if (intValue == 0) {
                g.a("No need to perform additional network settings");
                return true;
            } else {
                int c2 = j.c(j.b(str));
                if (-1 == c2) {
                    g.a("Wrong host address transformation, result was -1");
                    return false;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= 3) {
                        break;
                    }
                    try {
                        if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                            break;
                        }
                        Thread.sleep(1000L);
                        i = i2 + 1;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return false;
                    }
                }
                Method method2 = ConnectivityManager.class.getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE);
                method2.setAccessible(true);
                boolean booleanValue = ((Boolean) method2.invoke(connectivityManager, 5, Integer.valueOf(c2))).booleanValue();
                g.a("requestRouteToHost result: " + booleanValue);
                return booleanValue;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
