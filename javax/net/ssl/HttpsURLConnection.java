package javax.net.ssl;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/HttpsURLConnection.class */
public abstract class HttpsURLConnection extends HttpURLConnection {
    protected HostnameVerifier hostnameVerifier;
    private SSLSocketFactory sslSocketFactory;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/HttpsURLConnection$NoPreloadHolder.class */
    public static class NoPreloadHolder {
        public static HostnameVerifier defaultHostnameVerifier = new DefaultHostnameVerifier();
        public static SSLSocketFactory defaultSSLSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        private NoPreloadHolder() {
        }
    }

    protected HttpsURLConnection(URL url) {
        super(url);
        this.hostnameVerifier = NoPreloadHolder.defaultHostnameVerifier;
        this.sslSocketFactory = NoPreloadHolder.defaultSSLSocketFactory;
    }

    public static HostnameVerifier getDefaultHostnameVerifier() {
        return NoPreloadHolder.defaultHostnameVerifier;
    }

    public static SSLSocketFactory getDefaultSSLSocketFactory() {
        return NoPreloadHolder.defaultSSLSocketFactory;
    }

    public static void setDefaultHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (hostnameVerifier == null) {
            throw new IllegalArgumentException("HostnameVerifier is null");
        }
        NoPreloadHolder.defaultHostnameVerifier = hostnameVerifier;
    }

    public static void setDefaultSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (sSLSocketFactory == null) {
            throw new IllegalArgumentException("SSLSocketFactory is null");
        }
        NoPreloadHolder.defaultSSLSocketFactory = sSLSocketFactory;
    }

    public abstract String getCipherSuite();

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public abstract Certificate[] getLocalCertificates();

    public Principal getLocalPrincipal() {
        Certificate[] localCertificates = getLocalCertificates();
        if (localCertificates == null || localCertificates.length == 0 || !(localCertificates[0] instanceof X509Certificate)) {
            return null;
        }
        return ((X509Certificate) localCertificates[0]).getSubjectX500Principal();
    }

    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Certificate[] serverCertificates = getServerCertificates();
        if (serverCertificates == null || serverCertificates.length == 0 || !(serverCertificates[0] instanceof X509Certificate)) {
            throw new SSLPeerUnverifiedException("No server's end-entity certificate");
        }
        return ((X509Certificate) serverCertificates[0]).getSubjectX500Principal();
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.sslSocketFactory;
    }

    public abstract Certificate[] getServerCertificates() throws SSLPeerUnverifiedException;

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        if (hostnameVerifier == null) {
            throw new IllegalArgumentException("HostnameVerifier is null");
        }
        this.hostnameVerifier = hostnameVerifier;
    }

    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (sSLSocketFactory == null) {
            throw new IllegalArgumentException("SSLSocketFactory is null");
        }
        this.sslSocketFactory = sSLSocketFactory;
    }
}
