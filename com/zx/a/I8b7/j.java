package com.zx.a.I8b7;

import com.zx.a.I8b7.g0;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/j.class */
public class j implements g0 {

    /* renamed from: a  reason: collision with root package name */
    public final w1 f42135a;

    public j(w1 w1Var) {
        this.f42135a = w1Var;
    }

    @Override // com.zx.a.I8b7.g0
    public e1 a(g0.a aVar) throws IOException {
        v0 v0Var = (v0) aVar;
        b1 b1Var = v0Var.f42217c;
        HttpURLConnection httpURLConnection = v0Var.d;
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(b1Var.d != null);
        httpURLConnection.setConnectTimeout(this.f42135a.f);
        httpURLConnection.setReadTimeout(this.f42135a.g);
        httpURLConnection.setInstanceFollowRedirects(this.f42135a.e);
        this.f42135a.getClass();
        httpURLConnection.setUseCaches(false);
        if ("https".equalsIgnoreCase(b1Var.f42104a.getProtocol())) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            SSLSocketFactory sSLSocketFactory = this.f42135a.f42221c;
            if (sSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
            }
            HostnameVerifier hostnameVerifier = this.f42135a.d;
            if (hostnameVerifier != null) {
                httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            }
        }
        Map<String, String> map = b1Var.f42105c;
        if (map != null && map.size() > 0) {
            for (String str : map.keySet()) {
                httpURLConnection.setRequestProperty(str, map.get(str));
            }
        }
        httpURLConnection.connect();
        return v0Var.a(b1Var, httpURLConnection);
    }
}
