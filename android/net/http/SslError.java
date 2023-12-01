package android.net.http;

import java.security.cert.X509Certificate;

/* loaded from: source-9557208-dex2jar.jar:android/net/http/SslError.class */
public class SslError {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final int SSL_DATE_INVALID = 4;
    public static final int SSL_EXPIRED = 1;
    public static final int SSL_IDMISMATCH = 2;
    public static final int SSL_INVALID = 5;
    @Deprecated
    public static final int SSL_MAX_ERROR = 6;
    public static final int SSL_NOTYETVALID = 0;
    public static final int SSL_UNTRUSTED = 3;
    final SslCertificate mCertificate;
    int mErrors;
    final String mUrl;

    static {
        $assertionsDisabled = !SslError.class.desiredAssertionStatus();
    }

    @Deprecated
    public SslError(int i, SslCertificate sslCertificate) {
        this(i, sslCertificate, "");
    }

    public SslError(int i, SslCertificate sslCertificate, String str) {
        if (!$assertionsDisabled && sslCertificate == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && str == null) {
            throw new AssertionError();
        }
        addError(i);
        this.mCertificate = sslCertificate;
        this.mUrl = str;
    }

    @Deprecated
    public SslError(int i, X509Certificate x509Certificate) {
        this(i, x509Certificate, "");
    }

    public SslError(int i, X509Certificate x509Certificate, String str) {
        this(i, new SslCertificate(x509Certificate), str);
    }

    public static SslError SslErrorFromChromiumErrorCode(int i, SslCertificate sslCertificate, String str) {
        if ($assertionsDisabled || (i >= -299 && i <= -200)) {
            return i == -200 ? new SslError(2, sslCertificate, str) : i == -201 ? new SslError(4, sslCertificate, str) : i == -202 ? new SslError(3, sslCertificate, str) : new SslError(5, sslCertificate, str);
        }
        throw new AssertionError();
    }

    public boolean addError(int i) {
        boolean z = i >= 0 && i < 6;
        if (z) {
            this.mErrors = (1 << i) | this.mErrors;
        }
        return z;
    }

    public SslCertificate getCertificate() {
        return this.mCertificate;
    }

    public int getPrimaryError() {
        if (this.mErrors == 0) {
            return -1;
        }
        int i = 5;
        while (true) {
            int i2 = i;
            if (i2 < 0) {
                if ($assertionsDisabled) {
                    return -1;
                }
                throw new AssertionError();
            } else if ((this.mErrors & (1 << i2)) != 0) {
                return i2;
            } else {
                i = i2 - 1;
            }
        }
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean hasError(int i) {
        boolean z = i >= 0 && i < 6;
        boolean z2 = z;
        if (z) {
            if ((this.mErrors & (1 << i)) == 0) {
                return false;
            }
            z2 = true;
        }
        return z2;
    }

    public String toString() {
        return "primary error: " + getPrimaryError() + " certificate: " + getCertificate() + " on URL: " + getUrl();
    }
}
