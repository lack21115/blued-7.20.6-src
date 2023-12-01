package android.net.http;

import com.android.org.conscrypt.TrustManagerImpl;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;

/* loaded from: source-9557208-dex2jar.jar:android/net/http/X509TrustManagerExtensions.class */
public class X509TrustManagerExtensions {
    TrustManagerImpl mDelegate;

    public X509TrustManagerExtensions(X509TrustManager x509TrustManager) throws IllegalArgumentException {
        if (!(x509TrustManager instanceof TrustManagerImpl)) {
            throw new IllegalArgumentException("tm is an instance of " + x509TrustManager.getClass().getName() + " which is not a supported type of X509TrustManager");
        }
        this.mDelegate = (TrustManagerImpl) x509TrustManager;
    }

    public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
        return this.mDelegate.checkServerTrusted(x509CertificateArr, str, str2);
    }

    public boolean isUserAddedCertificate(X509Certificate x509Certificate) {
        return this.mDelegate.isUserAddedCertificate(x509Certificate);
    }
}
