package com.tencent.qimei.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/g/b.class */
public final class b extends BroadcastReceiver implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static b f38328a;

    /* renamed from: c  reason: collision with root package name */
    public ConnectivityManager.NetworkCallback f38329c;
    public ConnectivityManager g;
    public final Map<c, String> b = new ConcurrentHashMap();
    public boolean d = true;
    public volatile boolean e = false;
    public boolean f = false;

    public static b a() {
        if (f38328a == null) {
            synchronized (b.class) {
                try {
                    if (f38328a == null) {
                        f38328a = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f38328a;
    }

    public void a(Context context) {
        synchronized (this) {
            if (this.b.isEmpty()) {
                this.f = com.tencent.qimei.a.a.a();
                if (Build.VERSION.SDK_INT >= 21) {
                    this.f38329c = new a(this);
                    this.g = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkRequest.Builder builder = new NetworkRequest.Builder();
                    builder.addTransportType(1);
                    builder.addTransportType(0);
                    builder.addTransportType(3);
                    ConnectivityManager connectivityManager = this.g;
                    if (connectivityManager != null) {
                        try {
                            connectivityManager.registerNetworkCallback(builder.build(), this.f38329c);
                        } catch (SecurityException e) {
                            com.tencent.qimei.k.a.a(e);
                        }
                    }
                } else if (context != null) {
                    try {
                        context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    } catch (Exception e2) {
                        com.tencent.qimei.k.a.a(e2);
                    }
                }
            }
        }
    }

    public void a(String str) {
        synchronized (this) {
            for (Map.Entry<c, String> entry : this.b.entrySet()) {
                if (str.equals(entry.getValue())) {
                    this.b.remove(entry.getKey());
                }
            }
        }
    }

    public void a(String str, c cVar) {
        synchronized (this) {
            this.b.put(cVar, str);
        }
    }

    public final void b() {
        for (c cVar : this.b.keySet()) {
            cVar.a();
        }
    }

    public void b(Context context) {
        synchronized (this) {
            if (this.b.isEmpty()) {
                if (Build.VERSION.SDK_INT >= 21) {
                    ConnectivityManager connectivityManager = this.g;
                    if (connectivityManager != null) {
                        connectivityManager.unregisterNetworkCallback(this.f38329c);
                    }
                } else if (context != null) {
                    try {
                        context.unregisterReceiver(this);
                    } catch (Exception e) {
                        com.tencent.qimei.k.a.a(e);
                    }
                }
            }
        }
    }

    public final void c() {
        for (c cVar : this.b.keySet()) {
            cVar.b();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.d) {
            this.d = false;
        } else if (this.e) {
        } else {
            com.tencent.qimei.b.a.a().a(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.e = true;
        if (com.tencent.qimei.a.a.a()) {
            b();
        } else {
            c();
        }
        this.e = false;
    }
}
