package com.kwad.sdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.core.content.ContextCompat;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/NetworkMonitor.class */
public final class NetworkMonitor {
    private static volatile boolean abz = false;
    private final List<a> abA;
    private boolean abB;
    private final BroadcastReceiver abC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/NetworkMonitor$Holder.class */
    public enum Holder {
        INSTANCE;
        
        private final NetworkMonitor mInstance = new NetworkMonitor((byte) 0);

        Holder() {
        }

        final NetworkMonitor getInstance() {
            return this.mInstance;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/NetworkMonitor$NetworkState.class */
    public enum NetworkState {
        NETWORK_NONE,
        NETWORK_MOBILE,
        NETWORK_WIFI
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/NetworkMonitor$a.class */
    public interface a {
        void a(NetworkState networkState);
    }

    private NetworkMonitor() {
        this.abA = new CopyOnWriteArrayList();
        this.abB = false;
        this.abC = new BroadcastReceiver() { // from class: com.kwad.sdk.core.NetworkMonitor.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                ConnectivityManager connectivityManager;
                NetworkMonitor networkMonitor;
                NetworkState networkState;
                try {
                    if ((ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) && (connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)) != null) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                            return;
                        }
                        if (1 == activeNetworkInfo.getType()) {
                            networkMonitor = NetworkMonitor.this;
                            networkState = NetworkState.NETWORK_WIFI;
                        } else if (activeNetworkInfo.getType() == 0) {
                            networkMonitor = NetworkMonitor.this;
                            networkState = NetworkState.NETWORK_MOBILE;
                        } else {
                            networkMonitor = NetworkMonitor.this;
                            networkState = NetworkState.NETWORK_NONE;
                        }
                        networkMonitor.b(networkState);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
    }

    /* synthetic */ NetworkMonitor(byte b) {
        this();
    }

    private void aD(Context context) {
        synchronized (this) {
            if (abz || context == null) {
                return;
            }
            context.getApplicationContext().registerReceiver(this.abC, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            abz = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NetworkState networkState) {
        for (a aVar : this.abA) {
            aVar.a(networkState);
        }
    }

    public static NetworkMonitor getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public final void a(Context context, a aVar) {
        aD(context);
        this.abA.add(aVar);
    }

    public final void a(a aVar) {
        this.abA.remove(aVar);
    }
}
