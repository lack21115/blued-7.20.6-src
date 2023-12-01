package com.loopj.android.http;

import com.blued.das.live.LiveProtos;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpVersion;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;

/* loaded from: source-7994992-dex2jar.jar:com/loopj/android/http/MySSLSocketFactory.class */
public class MySSLSocketFactory extends SSLSocketFactory {
    SSLContext sslContext;

    public MySSLSocketFactory(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        this.sslContext = SSLContext.getInstance("TLS");
        this.sslContext.init(null, new TrustManager[]{new X509TrustManager() { // from class: com.loopj.android.http.MySSLSocketFactory.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }}, null);
    }

    public static SSLSocketFactory getFixedSocketFactory() {
        try {
            MySSLSocketFactory mySSLSocketFactory = new MySSLSocketFactory(getKeystore());
            mySSLSocketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            return mySSLSocketFactory;
        } catch (Throwable th) {
            th.printStackTrace();
            return SSLSocketFactory.getSocketFactory();
        }
    }

    public static KeyStore getKeystore() {
        KeyStore keyStore;
        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            try {
                keyStore.load(null, null);
                return keyStore;
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                return keyStore;
            }
        } catch (Throwable th2) {
            th = th2;
            keyStore = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.security.KeyStore getKeystoreOfCA(java.io.InputStream r4) {
        /*
            r0 = 0
            r6 = r0
            r0 = 0
            r7 = r0
            java.lang.String r0 = "X.509"
            java.security.cert.CertificateFactory r0 = java.security.cert.CertificateFactory.getInstance(r0)     // Catch: java.lang.Throwable -> L34 java.security.cert.CertificateException -> L3a
            r8 = r0
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L34 java.security.cert.CertificateException -> L3a
            r1 = r0
            r2 = r4
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L34 java.security.cert.CertificateException -> L3a
            r5 = r0
            r0 = r5
            r4 = r0
            r0 = r8
            r1 = r5
            java.security.cert.Certificate r0 = r0.generateCertificate(r1)     // Catch: java.security.cert.CertificateException -> L30 java.lang.Throwable -> L7e
            r6 = r0
            r0 = r5
            r0.close()     // Catch: java.io.IOException -> L26
            r0 = r6
            r4 = r0
            goto L55
        L26:
            r4 = move-exception
            r0 = r4
            r0.printStackTrace()
            r0 = r6
            r4 = r0
            goto L55
        L30:
            r6 = move-exception
            goto L3d
        L34:
            r4 = move-exception
            r0 = r6
            r5 = r0
            goto L83
        L3a:
            r6 = move-exception
            r0 = 0
            r5 = r0
        L3d:
            r0 = r5
            r4 = r0
            r0 = r6
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L7e
            r0 = r5
            if (r0 == 0) goto L53
            r0 = r5
            r0.close()     // Catch: java.io.IOException -> L4e
            goto L53
        L4e:
            r4 = move-exception
            r0 = r4
            r0.printStackTrace()
        L53:
            r0 = 0
            r4 = r0
        L55:
            java.lang.String r0 = java.security.KeyStore.getDefaultType()
            r5 = r0
            r0 = r5
            java.security.KeyStore r0 = java.security.KeyStore.getInstance(r0)     // Catch: java.lang.Exception -> L75
            r5 = r0
            r0 = r5
            r1 = 0
            r2 = 0
            r0.load(r1, r2)     // Catch: java.lang.Exception -> L6d
            r0 = r5
            java.lang.String r1 = "ca"
            r2 = r4
            r0.setCertificateEntry(r1, r2)     // Catch: java.lang.Exception -> L6d
            r0 = r5
            return r0
        L6d:
            r6 = move-exception
            r0 = r5
            r4 = r0
            r0 = r6
            r5 = r0
            goto L78
        L75:
            r5 = move-exception
            r0 = r7
            r4 = r0
        L78:
            r0 = r5
            r0.printStackTrace()
            r0 = r4
            return r0
        L7e:
            r6 = move-exception
            r0 = r4
            r5 = r0
            r0 = r6
            r4 = r0
        L83:
            r0 = r5
            if (r0 == 0) goto L93
            r0 = r5
            r0.close()     // Catch: java.io.IOException -> L8e
            goto L93
        L8e:
            r5 = move-exception
            r0 = r5
            r0.printStackTrace()
        L93:
            r0 = r4
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loopj.android.http.MySSLSocketFactory.getKeystoreOfCA(java.io.InputStream):java.security.KeyStore");
    }

    public static DefaultHttpClient getNewHttpClient(KeyStore keyStore) {
        try {
            MySSLSocketFactory mySSLSocketFactory = new MySSLSocketFactory(keyStore);
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", mySSLSocketFactory, (int) LiveProtos.Event.LIVE_CHALLENGE_PK_EXPLAIN_CLICK_VALUE));
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
            return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        } catch (Exception e) {
            return new DefaultHttpClient();
        }
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        return this.sslContext.getSocketFactory().createSocket();
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return this.sslContext.getSocketFactory().createSocket(socket, str, i, z);
    }

    public void fixHttpsURLConnection() {
        HttpsURLConnection.setDefaultSSLSocketFactory(this.sslContext.getSocketFactory());
    }
}
