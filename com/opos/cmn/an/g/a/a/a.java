package com.opos.cmn.an.g.a.a;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import com.opos.cmn.an.g.f;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/g/a/a/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected Context f24541a;
    protected f b;

    /* renamed from: c  reason: collision with root package name */
    protected HttpURLConnection f24542c = a();

    public a(Context context, f fVar) {
        this.f24541a = context;
        this.b = fVar;
        com.opos.cmn.an.f.a.b("HttpURLBaseTask", "init HttpURLBaseTask");
    }

    private HttpURLConnection a() {
        com.opos.cmn.an.f.a.b("HttpURLBaseTask", "start openConnection");
        c();
        HttpURLConnection httpURLConnection = null;
        if (!com.opos.cmn.an.c.a.a(this.b.f24550c)) {
            httpURLConnection = null;
            try {
                URL url = new URL(this.b.f24550c);
                HttpURLConnection openConnection = com.opos.cmn.an.h.c.a.c(this.f24541a) ? !com.opos.cmn.an.c.a.a(Proxy.getDefaultHost()) ? url.openConnection(b()) : url.openConnection() : url.openConnection();
                c(openConnection);
                a(openConnection);
                httpURLConnection = openConnection;
                b(openConnection);
                httpURLConnection = openConnection;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("HttpURLBaseTask", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("HttpURLBaseTask", "end openConnection");
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection) throws ProtocolException {
        if (httpURLConnection != null) {
            httpURLConnection.setConnectTimeout(this.b.e);
            httpURLConnection.setReadTimeout(this.b.f);
            httpURLConnection.setDoInput(true);
            if ("GET".equals(this.b.b)) {
                httpURLConnection.setUseCaches(true);
            } else if ("POST".equals(this.b.b)) {
                httpURLConnection.setDoOutput(true);
            }
            httpURLConnection.setRequestMethod(this.b.b);
        }
    }

    private java.net.Proxy b() {
        return new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort()));
    }

    private void b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null || this.b.d == null || this.b.d.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : this.b.d.entrySet()) {
            if (entry != null) {
                String key = entry.getKey();
                String value = entry.getValue();
                StringBuilder sb = new StringBuilder();
                sb.append("setRequestHeader key=");
                sb.append(key != null ? key : com.igexin.push.core.b.l);
                sb.append(",value=");
                String str = com.igexin.push.core.b.l;
                if (value != null) {
                    str = value;
                }
                sb.append(str);
                com.opos.cmn.an.f.a.b("HttpURLBaseTask", sb.toString());
                httpURLConnection.setRequestProperty(key, value);
            }
        }
    }

    private void c() {
        if (Build.VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    private void c(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            try {
                if (this.b.h != null) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.b.h);
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    SSLSocketFactory d = d();
                    if (d != null) {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(d);
                    }
                    com.opos.cmn.an.f.a.b("HttpURLBaseTask", "setHttpsPropertyIfNeed sslSocketFactory == null, time = " + (System.currentTimeMillis() - currentTimeMillis));
                }
                if (this.b.i != null) {
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(this.b.i);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("HttpURLBaseTask", "setHttpsPropertyIfNeed", e);
            }
        }
    }

    private static SSLSocketFactory d() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            return null;
        }
    }
}
