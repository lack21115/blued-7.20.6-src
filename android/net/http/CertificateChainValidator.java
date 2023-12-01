package android.net.http;

import android.net.http.DelegatingSSLSession;
import android.util.Slog;
import com.android.org.conscrypt.SSLParametersImpl;
import com.android.org.conscrypt.TrustManagerImpl;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: source-9557208-dex2jar.jar:android/net/http/CertificateChainValidator.class */
public class CertificateChainValidator {
    private static final String TAG = "CertificateChainValidator";
    private X509TrustManager mTrustManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/http/CertificateChainValidator$NoPreloadHolder.class */
    public static class NoPreloadHolder {
        private static final CertificateChainValidator sInstance = new CertificateChainValidator();
        private static final HostnameVerifier sVerifier = HttpsURLConnection.getDefaultHostnameVerifier();

        private NoPreloadHolder() {
        }
    }

    private CertificateChainValidator() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X.509");
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            int length = trustManagers.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                TrustManager trustManager = trustManagers[i2];
                if (trustManager instanceof X509TrustManager) {
                    this.mTrustManager = (X509TrustManager) trustManager;
                }
                i = i2 + 1;
            }
            if (this.mTrustManager == null) {
                throw new RuntimeException("None of the X.509 TrustManagers are X509TrustManager");
            }
        } catch (KeyStoreException e) {
            throw new RuntimeException("X.509 TrustManagerFactory cannot be initialized", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("X.509 TrustManagerFactory must be available", e2);
        }
    }

    private void closeSocketThrowException(SSLSocket sSLSocket, String str) throws IOException {
        if (sSLSocket != null) {
            SSLSession session = sSLSocket.getSession();
            if (session != null) {
                session.invalidate();
            }
            sSLSocket.close();
        }
        throw new SSLHandshakeException(str);
    }

    private void closeSocketThrowException(SSLSocket sSLSocket, String str, String str2) throws IOException {
        if (str == null) {
            str = str2;
        }
        closeSocketThrowException(sSLSocket, str);
    }

    public static CertificateChainValidator getInstance() {
        return NoPreloadHolder.sInstance;
    }

    private X509TrustManager getTrustManager() {
        return this.mTrustManager;
    }

    public static void handleTrustStorageUpdate() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X.509");
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            boolean z = false;
            int length = trustManagers.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                TrustManager trustManager = trustManagers[i2];
                try {
                    Method declaredMethod = trustManager.getClass().getDeclaredMethod("handleTrustStorageUpdate", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(trustManager, new Object[0]);
                    z = true;
                } catch (Exception e) {
                }
                i = i2 + 1;
            }
            if (z) {
                return;
            }
            Slog.w(TAG, "Didn't find a TrustManager to handle CA list update");
        } catch (KeyStoreException e2) {
            Slog.w(TAG, "Couldn't initialize default X.509 TrustManagerFactory", e2);
        } catch (NoSuchAlgorithmException e3) {
            Slog.w(TAG, "Couldn't find default X.509 TrustManagerFactory");
        }
    }

    public static SslError verifyServerCertificates(byte[][] bArr, String str, String str2) throws IOException {
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("bad certificate chain");
        }
        X509Certificate[] x509CertificateArr = new X509Certificate[bArr.length];
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= bArr.length) {
                    return verifyServerDomainAndCertificates(x509CertificateArr, str, str2);
                }
                x509CertificateArr[i2] = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArr[i2]));
                i = i2 + 1;
            }
        } catch (CertificateException e) {
            throw new IOException("can't read certificate", e);
        }
    }

    private static SslError verifyServerDomainAndCertificates(X509Certificate[] x509CertificateArr, String str, String str2) throws IOException {
        X509Certificate x509Certificate = x509CertificateArr[0];
        if (x509Certificate == null) {
            throw new IllegalArgumentException("certificate for this site is null");
        }
        boolean z = false;
        if (str != null) {
            z = false;
            if (!str.isEmpty()) {
                z = false;
                if (NoPreloadHolder.sVerifier.verify(str, new DelegatingSSLSession.CertificateWrap(x509Certificate))) {
                    z = true;
                }
            }
        }
        if (z) {
            try {
                TrustManagerImpl defaultX509TrustManager = SSLParametersImpl.getDefaultX509TrustManager();
                if (defaultX509TrustManager instanceof TrustManagerImpl) {
                    defaultX509TrustManager.checkServerTrusted(x509CertificateArr, str2, str);
                    return null;
                }
                defaultX509TrustManager.checkServerTrusted(x509CertificateArr, str2);
                return null;
            } catch (GeneralSecurityException e) {
                return new SslError(3, x509Certificate);
            }
        }
        return new SslError(2, x509Certificate);
    }

    public SslError doHandshakeAndValidateServerCertificates(HttpsConnection httpsConnection, SSLSocket sSLSocket, String str) throws IOException {
        if (!sSLSocket.getSession().isValid()) {
            closeSocketThrowException(sSLSocket, "failed to perform SSL handshake");
        }
        Certificate[] peerCertificates = sSLSocket.getSession().getPeerCertificates();
        if (peerCertificates == null || peerCertificates.length == 0) {
            closeSocketThrowException(sSLSocket, "failed to retrieve peer certificates");
        } else if (httpsConnection != null && peerCertificates[0] != null) {
            httpsConnection.setCertificate(new SslCertificate((X509Certificate) peerCertificates[0]));
        }
        return verifyServerDomainAndCertificates((X509Certificate[]) peerCertificates, str, "RSA");
    }
}
