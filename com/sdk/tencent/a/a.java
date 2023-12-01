package com.sdk.tencent.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/a/a.class */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final String f28001c = "com.sdk.tencent.a.a";
    public static Boolean d = Boolean.valueOf(com.sdk.tencent.f.c.b);
    public static Network e;
    public static boolean f;
    public static ConnectivityManager.NetworkCallback g;

    /* renamed from: a  reason: collision with root package name */
    public HttpURLConnection f28002a;
    public ConnectivityManager b;

    /* renamed from: com.sdk.tencent.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/a/a$a.class */
    public class C0756a extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ URL f28003a;

        public C0756a(URL url) {
            this.f28003a = url;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            a.e = network;
            try {
                a.this.f28002a = (HttpURLConnection) network.openConnection(this.f28003a);
            } catch (IOException e) {
            }
        }
    }

    public a() {
    }

    public a(Context context, URL url) {
        this.b = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        try {
            Network network = e;
            if (network != null && !f) {
                try {
                    this.f28002a = (HttpURLConnection) network.openConnection(url);
                    return;
                } catch (IOException e2) {
                    return;
                }
            }
            f = false;
            C0756a c0756a = new C0756a(url);
            g = c0756a;
            a(c0756a);
        } catch (Exception e3) {
            com.sdk.tencent.n.b.a(f28001c, e3.toString(), d);
        }
    }

    public HttpURLConnection a() {
        HttpURLConnection httpURLConnection;
        long currentTimeMillis = System.currentTimeMillis();
        do {
            if (System.currentTimeMillis() - currentTimeMillis > 2000) {
                return null;
            }
            httpURLConnection = this.f28002a;
        } while (httpURLConnection == null);
        return httpURLConnection;
    }

    public void a(ConnectivityManager.NetworkCallback networkCallback) {
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addCapability(12);
        builder.addTransportType(0);
        NetworkRequest build = builder.build();
        ConnectivityManager connectivityManager = this.b;
        if (connectivityManager != null) {
            connectivityManager.requestNetwork(build, networkCallback);
        }
    }
}
