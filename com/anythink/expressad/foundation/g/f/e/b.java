package com.anythink.expressad.foundation.g.f.e;

import android.text.TextUtils;
import com.anythink.expressad.foundation.g.f.c.c;
import com.anythink.expressad.foundation.g.f.d.f;
import com.anythink.expressad.foundation.g.f.i;
import com.sobot.network.http.SobotOkHttpUtils;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/e/b.class */
public final class b implements com.anythink.expressad.foundation.g.f.e.a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f5050a = 100;
    private com.anythink.expressad.foundation.g.f.c.a b;

    /* renamed from: c  reason: collision with root package name */
    private SSLSocketFactory f5051c;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/e/b$a.class */
    static final class a extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private final HttpURLConnection f5052a;

        a(HttpURLConnection httpURLConnection) {
            super(b.b(httpURLConnection));
            this.f5052a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            super.close();
            this.f5052a.disconnect();
        }
    }

    public b(SSLSocketFactory sSLSocketFactory, com.anythink.expressad.foundation.g.f.c.a aVar) {
        this.f5051c = sSLSocketFactory;
        this.b = aVar;
    }

    private HttpURLConnection a(URL url) {
        com.anythink.expressad.foundation.g.f.c.a aVar = this.b;
        HttpURLConnection httpURLConnection = (aVar == null || TextUtils.isEmpty(aVar.b) || TextUtils.isEmpty(this.b.f5024c)) ? (HttpURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.b.b, Integer.valueOf(this.b.f5024c).intValue())));
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }

    private HttpURLConnection a(URL url, i<?> iVar) {
        SSLSocketFactory sSLSocketFactory;
        com.anythink.expressad.foundation.g.f.c.a aVar = this.b;
        HttpURLConnection httpURLConnection = (aVar == null || TextUtils.isEmpty(aVar.b) || TextUtils.isEmpty(this.b.f5024c)) ? (HttpURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.b.b, Integer.valueOf(this.b.f5024c).intValue())));
        httpURLConnection.setInstanceFollowRedirects(false);
        int k = iVar.k();
        httpURLConnection.setConnectTimeout(k);
        httpURLConnection.setReadTimeout(k);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.f5051c) != null) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        return httpURLConnection;
    }

    private static List<c> a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String str : entry.getValue()) {
                    arrayList.add(new c(entry.getKey(), str));
                }
            }
        }
        return arrayList;
    }

    private static void a(HttpURLConnection httpURLConnection, i<?> iVar) {
        switch (iVar.a()) {
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                b(httpURLConnection, iVar);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                b(httpURLConnection, iVar);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod(HttpConstants.RequestMethod.TRACE);
                return;
            case 7:
                b(httpURLConnection, iVar);
                httpURLConnection.setRequestMethod(SobotOkHttpUtils.METHOD.PATCH);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static boolean a(int i, int i2) {
        if (i != 4) {
            return ((100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException e) {
            return httpURLConnection.getErrorStream();
        }
    }

    private static void b(HttpURLConnection httpURLConnection, i<?> iVar) {
        byte[] h = iVar.h();
        if (h != null) {
            boolean z = iVar instanceof f;
            if (z) {
                httpURLConnection.setChunkedStreamingMode(2048);
            }
            httpURLConnection.setDoOutput(true);
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(h);
            if (z) {
                iVar.a((OutputStream) dataOutputStream);
            }
            dataOutputStream.close();
        }
    }

    @Override // com.anythink.expressad.foundation.g.f.e.a
    public final com.anythink.expressad.foundation.g.f.f.b a(i<?> iVar) {
        boolean z;
        SSLSocketFactory sSLSocketFactory;
        URL url = new URL(iVar.d());
        com.anythink.expressad.foundation.g.f.c.a aVar = this.b;
        HttpURLConnection httpURLConnection = (aVar == null || TextUtils.isEmpty(aVar.b) || TextUtils.isEmpty(this.b.f5024c)) ? (HttpURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.b.b, Integer.valueOf(this.b.f5024c).intValue())));
        httpURLConnection.setInstanceFollowRedirects(false);
        int k = iVar.k();
        httpURLConnection.setConnectTimeout(k);
        httpURLConnection.setReadTimeout(k);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.f5051c) != null) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        try {
            for (Map.Entry<String, String> entry : iVar.g().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            switch (iVar.a()) {
                case 0:
                    httpURLConnection.setRequestMethod("GET");
                    break;
                case 1:
                    httpURLConnection.setRequestMethod("POST");
                    b(httpURLConnection, iVar);
                    break;
                case 2:
                    httpURLConnection.setRequestMethod("PUT");
                    b(httpURLConnection, iVar);
                    break;
                case 3:
                    httpURLConnection.setRequestMethod("DELETE");
                    break;
                case 4:
                    httpURLConnection.setRequestMethod("HEAD");
                    break;
                case 5:
                    httpURLConnection.setRequestMethod("OPTIONS");
                    break;
                case 6:
                    httpURLConnection.setRequestMethod(HttpConstants.RequestMethod.TRACE);
                    break;
                case 7:
                    b(httpURLConnection, iVar);
                    httpURLConnection.setRequestMethod(SobotOkHttpUtils.METHOD.PATCH);
                    break;
                default:
                    throw new IllegalStateException("Unknown method type.");
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != -1) {
                if (!((iVar.a() == 4 || (100 <= responseCode && responseCode < 200) || responseCode == 204 || responseCode == 304) ? false : true)) {
                    com.anythink.expressad.foundation.g.f.f.b bVar = new com.anythink.expressad.foundation.g.f.f.b(responseCode, a(httpURLConnection.getHeaderFields()));
                    httpURLConnection.disconnect();
                    return bVar;
                }
                try {
                    return new com.anythink.expressad.foundation.g.f.f.b(responseCode, a(httpURLConnection.getHeaderFields()), new a(httpURLConnection));
                } catch (Throwable th) {
                    th = th;
                    z = true;
                    if (!z) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }
}
