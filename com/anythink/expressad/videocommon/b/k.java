package com.anythink.expressad.videocommon.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/k.class */
public final class k extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    e.a().b();
                } else if (activeNetworkInfo.getType() == 1) {
                    e.a().a(true);
                } else if (activeNetworkInfo.getType() == 0) {
                    e.a().c();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
