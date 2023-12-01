package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/cm.class */
public class cm {

    /* renamed from: a  reason: collision with root package name */
    private static volatile cm f6546a;

    private cm() {
    }

    public static cm a() {
        if (f6546a == null) {
            synchronized (cm.class) {
                try {
                    if (f6546a == null) {
                        f6546a = new cm();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6546a;
    }

    private NetworkCapabilities c(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE);
                return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public Boolean a(Context context) {
        try {
            boolean z = true;
            if (bj.a(context).a() >= 29) {
                NetworkCapabilities c2 = c(context);
                return Boolean.valueOf(c2 != null && c2.hasCapability(12) && c2.hasCapability(16) && c2.hasTransport(1));
            }
            NetworkInfo b = b(context);
            if (b == null || !b.isConnected() || b.getType() != 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Throwable th) {
            return false;
        }
    }

    public NetworkInfo b(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                return ((ConnectivityManager) applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }
}
