package com.bytedance.applog.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.bdtracker.b;
import com.bytedance.bdtracker.z2;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/collector/Collector.class */
public class Collector extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String[] stringArrayExtra = intent.getStringArrayExtra("K_DATA");
        if (stringArrayExtra == null || stringArrayExtra.length <= 0) {
            z2.c("U SHALL NOT PASS!", (Throwable) null);
        } else {
            b.a(stringArrayExtra);
        }
    }
}
