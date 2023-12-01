package com.soft.blued.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.soft.blued.utils.Logger;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/service/AutoStartReceiver.class */
public class AutoStartReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Logger.a("AutoStartReceiver", "AutoStartReceiver.onReceive(), intent:", intent.getAction());
        AutoStartService.startService(context);
    }
}
