package com.anythink.expressad.exoplayer.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import com.anythink.expressad.exoplayer.k.af;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/scheduler/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4894a = "RequirementsWatcher";
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final c f4895c;
    private final com.anythink.expressad.exoplayer.scheduler.a d;
    private C0070b e;
    private boolean f;
    private a g;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/scheduler/b$a.class */
    final class a extends ConnectivityManager.NetworkCallback {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network network) {
            super.onAvailable(network);
            StringBuilder sb = new StringBuilder();
            sb.append(b.this);
            sb.append(" NetworkCallback.onAvailable");
            b.this.a(false);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network network) {
            super.onLost(network);
            StringBuilder sb = new StringBuilder();
            sb.append(b.this);
            sb.append(" NetworkCallback.onLost");
            b.this.a(false);
        }
    }

    /* renamed from: com.anythink.expressad.exoplayer.scheduler.b$b  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/scheduler/b$b.class */
    final class C0070b extends BroadcastReceiver {
        private C0070b() {
        }

        /* synthetic */ C0070b(b bVar, byte b) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(b.this);
            sb.append(" received ");
            sb.append(intent.getAction());
            b.this.a(false);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/scheduler/b$c.class */
    public interface c {
        void a();

        void b();
    }

    private b(Context context, c cVar, com.anythink.expressad.exoplayer.scheduler.a aVar) {
        this.d = aVar;
        this.f4895c = cVar;
        this.b = context.getApplicationContext();
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append(" created");
    }

    private void a() {
        com.anythink.expressad.exoplayer.k.a.a(Looper.myLooper());
        a(true);
        IntentFilter intentFilter = new IntentFilter();
        if (this.d.a() != 0) {
            if (af.f4793a >= 23) {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.b.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkRequest build = new NetworkRequest.Builder().addCapability(16).build();
                a aVar = new a(this, (byte) 0);
                this.g = aVar;
                connectivityManager.registerNetworkCallback(build, aVar);
            } else {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
        }
        if (this.d.b()) {
            intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
            intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        }
        if (this.d.c()) {
            if (af.f4793a >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            } else {
                intentFilter.addAction(Intent.ACTION_SCREEN_ON);
                intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
            }
        }
        C0070b c0070b = new C0070b(this, (byte) 0);
        this.e = c0070b;
        this.b.registerReceiver(c0070b, intentFilter, null, new Handler());
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append(" started");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        boolean a2 = this.d.a(this.b);
        if (z || a2 != this.f) {
            this.f = a2;
        }
    }

    private void b() {
        this.b.unregisterReceiver(this.e);
        this.e = null;
        if (this.g != null && af.f4793a >= 21) {
            ((ConnectivityManager) this.b.getSystemService(Context.CONNECTIVITY_SERVICE)).unregisterNetworkCallback(this.g);
            this.g = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append(" stopped");
    }

    private com.anythink.expressad.exoplayer.scheduler.a c() {
        return this.d;
    }

    private void d() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.b.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkRequest build = new NetworkRequest.Builder().addCapability(16).build();
        a aVar = new a(this, (byte) 0);
        this.g = aVar;
        connectivityManager.registerNetworkCallback(build, aVar);
    }

    private void e() {
        if (af.f4793a >= 21) {
            ((ConnectivityManager) this.b.getSystemService(Context.CONNECTIVITY_SERVICE)).unregisterNetworkCallback(this.g);
            this.g = null;
        }
    }

    private static void f() {
    }

    private static /* synthetic */ void g() {
    }

    public final String toString() {
        return super.toString();
    }
}
