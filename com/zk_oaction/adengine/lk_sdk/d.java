package com.zk_oaction.adengine.lk_sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/d.class */
public class d {
    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            return activeNetworkInfo.getType() == 1;
        } catch (Exception e) {
            return false;
        }
    }
}
