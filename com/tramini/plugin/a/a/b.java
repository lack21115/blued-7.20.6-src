package com.tramini.plugin.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/a/b.class */
public class b {
    private static volatile b b;

    /* renamed from: a  reason: collision with root package name */
    Context f40477a;

    private b(Context context) {
        this.f40477a = context;
    }

    public static b a(Context context) {
        if (b == null) {
            synchronized (b.class) {
                try {
                    if (b == null) {
                        b = new b(context.getApplicationContext());
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
            LocalBroadcastManager.getInstance(this.f40477a).unregisterReceiver(broadcastReceiver);
        } catch (Throwable th) {
        }
        try {
            LocalBroadcastManager.getInstance(this.f40477a).unregisterReceiver(broadcastReceiver);
        } catch (Throwable th2) {
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            LocalBroadcastManager.getInstance(this.f40477a).registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable th) {
        }
        try {
            LocalBroadcastManager.getInstance(this.f40477a).registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable th2) {
        }
    }
}
