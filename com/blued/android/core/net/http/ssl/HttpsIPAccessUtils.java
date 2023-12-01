package com.blued.android.core.net.http.ssl;

import android.os.Build;
import android.text.TextUtils;
import com.blued.android.core.net.http.HttpDnsUtils;
import com.blued.android.core.utils.Log;
import java.io.IOException;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.conscrypt.Conscrypt;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/ssl/HttpsIPAccessUtils.class */
public class HttpsIPAccessUtils {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f9698a = new ConcurrentHashMap<>();

    public static String a(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = f9698a;
        if (concurrentHashMap == null || !concurrentHashMap.containsValue(str)) {
            return null;
        }
        for (Map.Entry<String, String> entry : f9698a.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void a(List<String> list) {
        if (list != null) {
            for (String str : list) {
                f9698a.put(str, "");
            }
        }
    }

    public static void a(OkHttpClient.Builder builder) {
        boolean z;
        ConcurrentHashMap<String, String> concurrentHashMap = f9698a;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0 || Build.VERSION.SDK_INT < 22) {
            z = false;
        } else {
            builder.hostnameVerifier(b()).addInterceptor(c());
            z = true;
        }
        try {
            if (!(Build.VERSION.SDK_INT < 29)) {
                if (z) {
                    builder.sslSocketFactory(new InternalSSLSocketFactory29(), d());
                    return;
                }
                return;
            }
            Security.insertProviderAt(Conscrypt.newProvider(), 1);
            if (Conscrypt.isAvailable()) {
                X509TrustManager defaultX509TrustManager = Conscrypt.getDefaultX509TrustManager();
                SSLContext sSLContext = SSLContext.getInstance("TLS", "Conscrypt");
                sSLContext.init(null, new TrustManager[]{defaultX509TrustManager}, null);
                if (z) {
                    builder.sslSocketFactory(new InternalSSLSocketFactory22(sSLContext), defaultX509TrustManager);
                } else {
                    builder.sslSocketFactory(new InternalSSLSocketFactoryDefault(sSLContext), defaultX509TrustManager);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static HostnameVerifier b() {
        return new HostnameVerifier() { // from class: com.blued.android.core.net.http.ssl.HttpsIPAccessUtils.1
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                String a2 = HttpsIPAccessUtils.a(str);
                Log.c("HttpsIPAccessUtils", "HostnameVerifier hostname: " + str + " >> " + a2);
                if (!TextUtils.isEmpty(a2)) {
                    str = a2;
                }
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
            }
        };
    }

    private static Interceptor c() {
        return new Interceptor() { // from class: com.blued.android.core.net.http.ssl.HttpsIPAccessUtils.2
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                String str;
                Request request = chain.request();
                HttpUrl url = request.url();
                String host = url.host();
                if (HttpsIPAccessUtils.f9698a.containsKey(host)) {
                    String a2 = HttpDnsUtils.a(host);
                    str = a2;
                    if (!TextUtils.isEmpty(a2)) {
                        HttpsIPAccessUtils.f9698a.put(host, a2);
                        str = a2;
                    }
                } else {
                    str = "";
                }
                if (TextUtils.isEmpty(str)) {
                    return chain.proceed(request);
                }
                String httpUrl = url.toString();
                String replaceFirst = httpUrl.replaceFirst(host, str);
                Headers.Builder add = request.headers().newBuilder().add("host", host);
                Log.c("HttpsIPAccessUtils", "intercept host: " + httpUrl + " >> " + replaceFirst);
                return chain.proceed(request.newBuilder().url(replaceFirst).headers(add.build()).build());
            }
        };
    }

    private static X509TrustManager d() {
        return new X509TrustManager() { // from class: com.blued.android.core.net.http.ssl.HttpsIPAccessUtils.3
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
    }
}
