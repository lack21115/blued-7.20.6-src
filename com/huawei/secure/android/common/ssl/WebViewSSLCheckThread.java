package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import com.blued.das.live.LiveProtos;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import com.huawei.secure.android.common.ssl.util.f;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/ssl/WebViewSSLCheckThread.class */
public class WebViewSSLCheckThread extends Thread {
    private static final String i = WebViewSSLCheckThread.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private SSLSocketFactory f9504a;
    private HostnameVerifier b;

    /* renamed from: c  reason: collision with root package name */
    private org.apache.http.conn.ssl.SSLSocketFactory f9505c;
    private X509HostnameVerifier d;
    private SslErrorHandler e;
    private String f;
    private Callback g;
    private Context h;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/ssl/WebViewSSLCheckThread$Callback.class */
    public interface Callback {
        void onCancel(Context context, String str);

        void onProceed(Context context, String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/ssl/WebViewSSLCheckThread$a.class */
    public static final class a implements okhttp3.Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Callback f9506a;
        final /* synthetic */ Context b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f9507c;
        final /* synthetic */ SslErrorHandler d;

        a(Callback callback, Context context, String str, SslErrorHandler sslErrorHandler) {
            this.f9506a = callback;
            this.b = context;
            this.f9507c = str;
            this.d = sslErrorHandler;
        }

        public void onFailure(Call call, IOException iOException) {
            String str = WebViewSSLCheckThread.i;
            g.b(str, "onFailure , IO Exception : " + iOException.getMessage());
            Callback callback = this.f9506a;
            if (callback != null) {
                callback.onCancel(this.b, this.f9507c);
            } else {
                this.d.cancel();
            }
        }

        public void onResponse(Call call, Response response) throws IOException {
            g.b(WebViewSSLCheckThread.i, "onResponse . proceed");
            Callback callback = this.f9506a;
            if (callback != null) {
                callback.onProceed(this.b, this.f9507c);
            } else {
                this.d.proceed();
            }
        }
    }

    public WebViewSSLCheckThread() {
    }

    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, Context context) throws CertificateException, NoSuchAlgorithmException, IOException, KeyManagementException, KeyStoreException, IllegalAccessException {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setContext(context);
        setSslSocketFactory(new SecureSSLSocketFactoryNew(new c(context)));
        setHostnameVerifier(new StrictHostnameVerifier());
        try {
            setApacheSSLSocketFactory(new SecureApacheSSLSocketFactory((KeyStore) null, new c(context)));
        } catch (UnrecoverableKeyException e) {
            String str2 = i;
            g.b(str2, "WebViewSSLCheckThread: UnrecoverableKeyException : " + e.getMessage());
        }
        setApacheHostnameVerifier(SecureApacheSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setSslSocketFactory(sSLSocketFactory);
        setHostnameVerifier(hostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setApacheSSLSocketFactory(sSLSocketFactory);
        setApacheHostnameVerifier(x509HostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier, Callback callback, Context context) {
        this.e = sslErrorHandler;
        this.f = str;
        this.f9505c = sSLSocketFactory;
        this.d = x509HostnameVerifier;
        this.g = callback;
        this.h = context;
    }

    private void b() {
        g.c(i, "callbackCancel: ");
        Callback callback = this.g;
        if (callback != null) {
            callback.onCancel(this.h, this.f);
        } else if (this.e != null) {
            g.c(i, "callbackCancel 2: ");
            this.e.cancel();
        }
    }

    private void c() {
        g.c(i, "callbackProceed: ");
        Callback callback = this.g;
        if (callback != null) {
            callback.onProceed(this.h, this.f);
            return;
        }
        SslErrorHandler sslErrorHandler = this.e;
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context) {
        checkServerCertificateWithOK(sslErrorHandler, str, context, null);
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context, Callback callback) {
        if (sslErrorHandler == null || TextUtils.isEmpty(str) || context == null) {
            g.b(i, "checkServerCertificateWithOK: handler or url or context is null");
            return;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            SecureSSLSocketFactoryNew secureSSLSocketFactoryNew = new SecureSSLSocketFactoryNew(new c(context));
            secureSSLSocketFactoryNew.setContext(context);
            builder.sslSocketFactory(secureSSLSocketFactoryNew, new c(context));
            builder.hostnameVerifier(new StrictHostnameVerifier());
            builder.build().newCall(new Request.Builder().url(str).build()).enqueue(new a(callback, context, str, sslErrorHandler));
        } catch (Exception e) {
            String str2 = i;
            g.b(str2, "checkServerCertificateWithOK: exception : " + e.getMessage());
            sslErrorHandler.cancel();
        }
    }

    public X509HostnameVerifier getApacheHostnameVerifier() {
        return this.d;
    }

    public org.apache.http.conn.ssl.SSLSocketFactory getApacheSSLSocketFactory() {
        return this.f9505c;
    }

    public Callback getCallback() {
        return this.g;
    }

    public Context getContext() {
        return this.h;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.b;
    }

    public SslErrorHandler getSslErrorHandler() {
        return this.e;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.f9504a;
    }

    public String getUrl() {
        return this.f;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2;
        super.run();
        HttpsURLConnection httpsURLConnection3 = null;
        if (this.f9505c != null && this.d != null) {
            if (this.e == null || TextUtils.isEmpty(this.f)) {
                g.b(i, "sslErrorHandler or url is null");
                b();
                return;
            }
            try {
                try {
                    this.f9505c.setHostnameVerifier(this.d);
                    if (this.f9505c instanceof SecureApacheSSLSocketFactory) {
                        ((SecureApacheSSLSocketFactory) this.f9505c).setContext(this.h);
                    }
                    BasicHttpParams basicHttpParams = new BasicHttpParams();
                    HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
                    HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
                    SchemeRegistry schemeRegistry = new SchemeRegistry();
                    schemeRegistry.register(new Scheme("https", this.f9505c, (int) LiveProtos.Event.LIVE_CHALLENGE_PK_EXPLAIN_CLICK_VALUE));
                    schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                    DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                    HttpGet httpGet = new HttpGet();
                    httpGet.setURI(new URI(this.f));
                    HttpResponse execute = defaultHttpClient.execute(httpGet);
                    g.c(i, "status code is : " + execute.getStatusLine().getStatusCode());
                    f.a((Reader) null);
                    c();
                    return;
                } catch (Throwable th) {
                    f.a((Reader) null);
                    throw th;
                }
            } catch (Exception e) {
                g.b(i, "run: exception : " + e.getMessage());
                b();
                f.a((Reader) null);
                return;
            }
        }
        if (this.f9504a != null) {
            try {
                if (this.b != null) {
                    try {
                        URLConnection openConnection = new URL(this.f).openConnection();
                        if (openConnection instanceof HttpsURLConnection) {
                            httpsURLConnection2 = (HttpsURLConnection) openConnection;
                            try {
                                httpsURLConnection2.setSSLSocketFactory(this.f9504a);
                                httpsURLConnection2.setHostnameVerifier(this.b);
                                httpsURLConnection2.setRequestMethod("GET");
                                httpsURLConnection2.setConnectTimeout(10000);
                                httpsURLConnection2.setReadTimeout(20000);
                                httpsURLConnection2.connect();
                                httpsURLConnection3 = httpsURLConnection2;
                            } catch (Exception e2) {
                                e = e2;
                                String str = i;
                                HttpsURLConnection httpsURLConnection4 = httpsURLConnection2;
                                StringBuilder sb = new StringBuilder();
                                HttpsURLConnection httpsURLConnection5 = httpsURLConnection2;
                                sb.append("exception : ");
                                HttpsURLConnection httpsURLConnection6 = httpsURLConnection2;
                                sb.append(e.getMessage());
                                HttpsURLConnection httpsURLConnection7 = httpsURLConnection2;
                                g.b(str, sb.toString());
                                HttpsURLConnection httpsURLConnection8 = httpsURLConnection2;
                                b();
                                if (httpsURLConnection2 != null) {
                                    httpsURLConnection2.disconnect();
                                    return;
                                }
                                return;
                            }
                        }
                        if (httpsURLConnection3 != null) {
                            httpsURLConnection3.disconnect();
                        }
                        c();
                        return;
                    } catch (Exception e3) {
                        e = e3;
                        httpsURLConnection2 = null;
                    } catch (Throwable th2) {
                        httpsURLConnection = null;
                        th = th2;
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                httpsURLConnection = null;
            }
        }
        b();
    }

    public void setApacheHostnameVerifier(X509HostnameVerifier x509HostnameVerifier) {
        this.d = x509HostnameVerifier;
    }

    public void setApacheSSLSocketFactory(org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory) {
        this.f9505c = sSLSocketFactory;
    }

    public void setCallback(Callback callback) {
        this.g = callback;
    }

    public void setContext(Context context) {
        this.h = context;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.b = hostnameVerifier;
    }

    public void setSslErrorHandler(SslErrorHandler sslErrorHandler) {
        this.e = sslErrorHandler;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f9504a = sSLSocketFactory;
    }

    public void setUrl(String str) {
        this.f = str;
    }
}
