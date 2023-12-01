package com.soft.blued.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.blued.android.framework.init.InitTaskManager;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/manager/BluedBroadcastReceiver.class */
public class BluedBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    String f16004a;

    /* renamed from: c  reason: collision with root package name */
    Context f16005c;
    boolean b = false;
    private final List<BroadcastReceiverListener> d = new ArrayList();

    public BluedBroadcastReceiver(Context context, String str) {
        this.f16004a = str;
        this.f16005c = context.getApplicationContext();
    }

    public void a(BroadcastReceiverListener broadcastReceiverListener) {
        if (!this.d.contains(broadcastReceiverListener)) {
            this.d.add(broadcastReceiverListener);
        }
        if (!this.b) {
            this.f16005c.registerReceiver(this, new IntentFilter(this.f16004a));
            this.b = true;
        }
        Logger.b("registerReceiver " + this.f16004a + ", actionCount:" + this.d.size(), new Object[0]);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Logger.b("BluedBroadcastReceiver.onReceive(), intent:" + intent.getAction(), new Object[0]);
        if (this.f16005c == null) {
            this.f16005c = context.getApplicationContext();
        }
        if (!InitTaskManager.b()) {
            Logger.b("InitHelper is not init, return", new Object[0]);
            return;
        }
        for (BroadcastReceiverListener broadcastReceiverListener : this.d) {
            if (broadcastReceiverListener != null) {
                broadcastReceiverListener.a(this.f16004a, intent);
            }
        }
    }
}
