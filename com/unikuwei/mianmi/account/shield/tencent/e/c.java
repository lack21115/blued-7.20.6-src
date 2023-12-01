package com.unikuwei.mianmi.account.shield.tencent.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/e/c.class */
public class c {
    private static c f;
    private List<a> d;

    /* renamed from: a  reason: collision with root package name */
    private Network f27310a = null;
    private ConnectivityManager.NetworkCallback b = null;

    /* renamed from: c  reason: collision with root package name */
    private ConnectivityManager f27311c = null;
    private Timer e = null;

    /* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/e/c$a.class */
    public interface a {
        void a(boolean z, Network network);
    }

    private c() {
        this.d = null;
        this.d = new ArrayList();
    }

    public static c a() {
        if (f == null) {
            synchronized (c.class) {
                try {
                    if (f == null) {
                        f = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }

    private void a(Context context, a aVar) {
        synchronized (this) {
            if (this.f27310a != null) {
                aVar.a(true, this.f27310a);
                return;
            }
            a(aVar);
            if (this.b == null || this.d.size() < 2) {
                try {
                    this.f27311c = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkRequest.Builder builder = new NetworkRequest.Builder();
                    builder.addTransportType(0);
                    builder.addCapability(12);
                    NetworkRequest build = builder.build();
                    this.b = new ConnectivityManager.NetworkCallback() { // from class: com.unikuwei.mianmi.account.shield.tencent.e.c.1
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onAvailable(Network network) {
                            super.onAvailable(network);
                            g.a("Network onAvailable");
                            c.this.f27310a = network;
                            c.this.a(true, network);
                            try {
                                NetworkInfo networkInfo = c.this.f27311c.getNetworkInfo(c.this.f27310a);
                                String extraInfo = networkInfo.getExtraInfo();
                                g.a("APN:" + networkInfo.toString());
                                if (TextUtils.isEmpty(extraInfo)) {
                                    return;
                                }
                                h.d(extraInfo);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onLost(Network network) {
                            super.onLost(network);
                            g.a("Network onLost");
                            c.this.b();
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onUnavailable() {
                            super.onUnavailable();
                            g.a("Network onUnavailable");
                            c.this.a(false, (Network) null);
                            c.this.b();
                        }
                    };
                    int i = 3000;
                    if (h.f() < 3000) {
                        i = 2000;
                    }
                    if (Build.VERSION.SDK_INT >= 26) {
                        this.f27311c.requestNetwork(build, this.b, i);
                    } else {
                        Timer timer = new Timer();
                        this.e = timer;
                        timer.schedule(new TimerTask() { // from class: com.unikuwei.mianmi.account.shield.tencent.e.c.2
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                c.this.a(false, (Network) null);
                            }
                        }, i);
                        this.f27311c.requestNetwork(build, this.b);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    a(false, (Network) null);
                }
            }
        }
    }

    private void a(a aVar) {
        synchronized (this) {
            try {
                this.d.add(aVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, Network network) {
        synchronized (this) {
            try {
                if (this.e != null) {
                    this.e.cancel();
                    this.e = null;
                }
                for (a aVar : this.d) {
                    aVar.a(z, network);
                }
                this.d.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(Context context, String str, a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            a(context, aVar);
        } else {
            aVar.a(true, null);
        }
    }

    public void b() {
        synchronized (this) {
            try {
                if (this.e != null) {
                    this.e.cancel();
                    this.e = null;
                }
                if (Build.VERSION.SDK_INT >= 21 && this.f27311c != null && this.b != null) {
                    this.f27311c.unregisterNetworkCallback(this.b);
                }
                this.f27311c = null;
                this.b = null;
                this.f27310a = null;
                this.d.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
