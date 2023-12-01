package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.platform.Platform;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/tls/CertificateChainCleaner.class */
public abstract class CertificateChainCleaner {
    public static CertificateChainCleaner a(X509TrustManager x509TrustManager) {
        return Platform.e().a(x509TrustManager);
    }

    public abstract List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
