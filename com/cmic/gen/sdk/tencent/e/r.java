package com.cmic.gen.sdk.tencent.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/e/r.class */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private static r f21676a;
    private ConnectivityManager b;

    /* renamed from: c  reason: collision with root package name */
    private Network f21677c;
    private ConnectivityManager.NetworkCallback d;
    private boolean e;

    /* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/e/r$a.class */
    public interface a {
        void a(Network network);
    }

    private r(Context context) {
        try {
            this.b = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static r a(Context context) {
        if (f21676a == null) {
            synchronized (r.class) {
                try {
                    if (f21676a == null) {
                        f21676a = new r(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21676a;
    }

    public void a(final a aVar) {
        NetworkInfo networkInfo;
        synchronized (this) {
            if (this.b == null) {
                c.a("WifiNetworkUtils", "mConnectivityManager 为空");
                aVar.a(null);
            } else if (this.f21677c != null && !this.e && (networkInfo = this.b.getNetworkInfo(this.f21677c)) != null && networkInfo.isAvailable()) {
                c.a("HttpUtils", "reuse network: ");
                aVar.a(this.f21677c);
            } else {
                if (this.d != null) {
                    try {
                        this.b.unregisterNetworkCallback(this.d);
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.d = null;
                    }
                    c.a("HttpUtils", "clear: ");
                }
                NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
                ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.cmic.gen.sdk.tencent.e.r.1
                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onAvailable(Network network) {
                        try {
                            if (r.this.b.getNetworkCapabilities(network).hasTransport(0)) {
                                r.this.f21677c = network;
                                aVar.a(network);
                                r.this.e = false;
                                return;
                            }
                            c.a("WifiNetworkUtils", "切换失败，未开启数据网络");
                            r.this.f21677c = null;
                            aVar.a(null);
                            r.this.b.unregisterNetworkCallback(r.this.d);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            r.this.f21677c = null;
                            aVar.a(null);
                        }
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onLost(Network network) {
                        r.this.e = true;
                    }
                };
                this.d = networkCallback;
                try {
                    this.b.requestNetwork(build, networkCallback);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    aVar.a(null);
                }
            }
        }
    }

    public boolean a() {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 21) {
            z = false;
            if (this.f21677c != null) {
                z = true;
            }
        }
        return z;
    }

    public void b() {
        if (this.b == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 21 || this.d == null) {
                return;
            }
            this.b.unregisterNetworkCallback(this.d);
            this.d = null;
            this.f21677c = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
