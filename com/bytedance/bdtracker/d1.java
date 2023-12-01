package com.bytedance.bdtracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/d1.class */
public class d1 extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || WifiManager.WIFI_STATE_CHANGED_ACTION.equals(intent.getAction()) || WifiManager.NETWORK_STATE_CHANGED_ACTION.equals(intent.getAction())) {
            s2.b = s2.d(context);
        }
    }
}
