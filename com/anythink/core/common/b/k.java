package com.anythink.core.common.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/k.class */
public class k {
    private static volatile k b;
    Context a;

    private k(Context context) {
        this.a = context;
    }

    public static k a(Context context) {
        if (b == null) {
            synchronized (k.class) {
                try {
                    if (b == null) {
                        b = new k(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public final void a(BroadcastReceiver broadcastReceiver) {
        try {
            LocalBroadcastManager.getInstance(this.a).unregisterReceiver(broadcastReceiver);
        } catch (Throwable th) {
        }
        try {
            LocalBroadcastManager.getInstance(this.a).unregisterReceiver(broadcastReceiver);
        } catch (Throwable th2) {
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            LocalBroadcastManager.getInstance(this.a).registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable th) {
        }
        try {
            LocalBroadcastManager.getInstance(this.a).registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable th2) {
        }
    }

    public final void a(Intent intent) {
        try {
            LocalBroadcastManager.getInstance(this.a).sendBroadcast(intent);
        } catch (Throwable th) {
        }
        try {
            LocalBroadcastManager.getInstance(this.a).sendBroadcast(intent);
        } catch (Throwable th2) {
        }
    }
}
