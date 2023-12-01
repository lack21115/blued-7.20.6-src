package com.oplus.log.b.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/b/a/d.class */
public final class d extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private com.oplus.log.f.d f24320a;

    public d(com.oplus.log.f.d dVar) {
        this.f24320a = dVar;
    }

    public final void a(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(this, intentFilter);
        } catch (Throwable th) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        new Thread(new Runnable() { // from class: com.oplus.log.b.a.d.1
            @Override // java.lang.Runnable
            public final void run() {
                if (d.this.f24320a != null) {
                    d.this.f24320a.a(new com.oplus.log.b.b("Network_Info", com.oplus.log.d.c.a(), (byte) 4, null, null));
                }
            }
        }).start();
    }
}
