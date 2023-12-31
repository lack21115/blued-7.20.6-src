package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.manager.ConnectivityMonitor;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/manager/DefaultConnectivityMonitorFactory.class */
public class DefaultConnectivityMonitorFactory implements ConnectivityMonitorFactory {
    @Override // com.bumptech.glide.manager.ConnectivityMonitorFactory
    public ConnectivityMonitor a(Context context, ConnectivityMonitor.ConnectivityListener connectivityListener) {
        boolean z = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z ? new DefaultConnectivityMonitor(context, connectivityListener) : new NullConnectivityMonitor();
    }
}
