package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.Preconditions;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/manager/DefaultConnectivityMonitor.class */
final class DefaultConnectivityMonitor implements ConnectivityMonitor {

    /* renamed from: a  reason: collision with root package name */
    final ConnectivityMonitor.ConnectivityListener f21013a;
    boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f21014c;
    private boolean d;
    private final BroadcastReceiver e = new BroadcastReceiver() { // from class: com.bumptech.glide.manager.DefaultConnectivityMonitor.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = DefaultConnectivityMonitor.this.b;
            DefaultConnectivityMonitor defaultConnectivityMonitor = DefaultConnectivityMonitor.this;
            defaultConnectivityMonitor.b = defaultConnectivityMonitor.a(context);
            if (z != DefaultConnectivityMonitor.this.b) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + DefaultConnectivityMonitor.this.b);
                }
                DefaultConnectivityMonitor.this.f21013a.a(DefaultConnectivityMonitor.this.b);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultConnectivityMonitor(Context context, ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.f21014c = context.getApplicationContext();
        this.f21013a = connectivityListener;
    }

    private void a() {
        if (this.d) {
            return;
        }
        this.b = a(this.f21014c);
        try {
            this.f21014c.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.d = true;
        } catch (SecurityException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e);
            }
        }
    }

    private void b() {
        if (this.d) {
            this.f21014c.unregisterReceiver(this.e);
            this.d = false;
        }
    }

    boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) Preconditions.a((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
                return true;
            }
            return true;
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        a();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        b();
    }
}
