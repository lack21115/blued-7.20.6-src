package com.squareup.okhttp;

import com.android.org.conscrypt.NativeCrypto;
import com.blued.das.live.LiveProtos;
import com.squareup.okhttp.internal.Util;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/ConnectionSpec.class */
public final class ConnectionSpec {
    private static final CipherSuite[] APPROVED_CIPHER_SUITES = {CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
    public static final ConnectionSpec CLEARTEXT;
    public static final ConnectionSpec COMPATIBLE_TLS;
    public static final ConnectionSpec MODERN_TLS;
    private final String[] cipherSuites;
    private final boolean supportsTlsExtensions;
    private final boolean tls;
    private final String[] tlsVersions;

    /* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/ConnectionSpec$Builder.class */
    public static final class Builder {
        private String[] cipherSuites;
        private boolean supportsTlsExtensions;
        private boolean tls;
        private String[] tlsVersions;

        public Builder(ConnectionSpec connectionSpec) {
            this.tls = connectionSpec.tls;
            this.cipherSuites = connectionSpec.cipherSuites;
            this.tlsVersions = connectionSpec.tlsVersions;
            this.supportsTlsExtensions = connectionSpec.supportsTlsExtensions;
        }

        Builder(boolean z) {
            this.tls = z;
        }

        public Builder allEnabledCipherSuites() {
            if (this.tls) {
                this.cipherSuites = null;
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public Builder allEnabledTlsVersions() {
            if (this.tls) {
                this.tlsVersions = null;
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public ConnectionSpec build() {
            return new ConnectionSpec(this);
        }

        public Builder cipherSuites(CipherSuite... cipherSuiteArr) {
            if (!this.tls) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[cipherSuiteArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= cipherSuiteArr.length) {
                    return cipherSuites(strArr);
                }
                strArr[i2] = cipherSuiteArr[i2].javaName;
                i = i2 + 1;
            }
        }

        public Builder cipherSuites(String... strArr) {
            if (this.tls) {
                if (strArr.length != 0) {
                    this.cipherSuites = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public Builder supportsTlsExtensions(boolean z) {
            if (this.tls) {
                this.supportsTlsExtensions = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public Builder tlsVersions(TlsVersion... tlsVersionArr) {
            if (!this.tls) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[tlsVersionArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= tlsVersionArr.length) {
                    return tlsVersions(strArr);
                }
                strArr[i2] = tlsVersionArr[i2].javaName;
                i = i2 + 1;
            }
        }

        public Builder tlsVersions(String... strArr) {
            if (this.tls) {
                if (strArr.length != 0) {
                    this.tlsVersions = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
    }

    static {
        ConnectionSpec build = new Builder(true).cipherSuites(APPROVED_CIPHER_SUITES).tlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
        MODERN_TLS = build;
        COMPATIBLE_TLS = new Builder(build).tlsVersions(TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
        CLEARTEXT = new Builder(false).build();
    }

    private ConnectionSpec(Builder builder) {
        this.tls = builder.tls;
        this.cipherSuites = builder.cipherSuites;
        this.tlsVersions = builder.tlsVersions;
        this.supportsTlsExtensions = builder.supportsTlsExtensions;
    }

    private static boolean nonEmptyIntersection(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (Util.contains(strArr2, strArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private ConnectionSpec supportedSpec(SSLSocket sSLSocket, boolean z) {
        String[] strArr = this.cipherSuites;
        String[] enabledCipherSuites = strArr != null ? (String[]) Util.intersect(String.class, strArr, sSLSocket.getEnabledCipherSuites()) : sSLSocket.getEnabledCipherSuites();
        String[] strArr2 = this.tlsVersions;
        String[] enabledProtocols = strArr2 != null ? (String[]) Util.intersect(String.class, strArr2, sSLSocket.getEnabledProtocols()) : sSLSocket.getEnabledProtocols();
        String[] strArr3 = enabledCipherSuites;
        if (z) {
            strArr3 = enabledCipherSuites;
            if (Util.contains(sSLSocket.getSupportedCipherSuites(), NativeCrypto.TLS_FALLBACK_SCSV)) {
                strArr3 = Util.concat(enabledCipherSuites, NativeCrypto.TLS_FALLBACK_SCSV);
            }
        }
        return new Builder(this).cipherSuites(strArr3).tlsVersions(enabledProtocols).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void apply(SSLSocket sSLSocket, boolean z) {
        ConnectionSpec supportedSpec = supportedSpec(sSLSocket, z);
        String[] strArr = supportedSpec.tlsVersions;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = supportedSpec.cipherSuites;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public List<CipherSuite> cipherSuites() {
        String[] strArr = this.cipherSuites;
        if (strArr == null) {
            return null;
        }
        CipherSuite[] cipherSuiteArr = new CipherSuite[strArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            String[] strArr2 = this.cipherSuites;
            if (i2 >= strArr2.length) {
                return Util.immutableList(cipherSuiteArr);
            }
            cipherSuiteArr[i2] = CipherSuite.forJavaName(strArr2[i2]);
            i = i2 + 1;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof ConnectionSpec) {
            if (obj == this) {
                return true;
            }
            ConnectionSpec connectionSpec = (ConnectionSpec) obj;
            boolean z = this.tls;
            if (z != connectionSpec.tls) {
                return false;
            }
            if (z) {
                return Arrays.equals(this.cipherSuites, connectionSpec.cipherSuites) && Arrays.equals(this.tlsVersions, connectionSpec.tlsVersions) && this.supportsTlsExtensions == connectionSpec.supportsTlsExtensions;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.tls) {
            return ((((LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE + Arrays.hashCode(this.cipherSuites)) * 31) + Arrays.hashCode(this.tlsVersions)) * 31) + (!this.supportsTlsExtensions ? 1 : 0);
        }
        return 17;
    }

    public boolean isCompatible(SSLSocket sSLSocket) {
        if (this.tls) {
            String[] strArr = this.tlsVersions;
            if (strArr == null || nonEmptyIntersection(strArr, sSLSocket.getEnabledProtocols())) {
                String[] strArr2 = this.cipherSuites;
                return strArr2 == null || nonEmptyIntersection(strArr2, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }

    public boolean isTls() {
        return this.tls;
    }

    public boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    public List<TlsVersion> tlsVersions() {
        String[] strArr = this.tlsVersions;
        if (strArr == null) {
            return null;
        }
        TlsVersion[] tlsVersionArr = new TlsVersion[strArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            String[] strArr2 = this.tlsVersions;
            if (i2 >= strArr2.length) {
                return Util.immutableList(tlsVersionArr);
            }
            tlsVersionArr[i2] = TlsVersion.forJavaName(strArr2[i2]);
            i = i2 + 1;
        }
    }

    public String toString() {
        if (this.tls) {
            String obj = this.cipherSuites != null ? cipherSuites().toString() : "[all enabled]";
            String obj2 = this.tlsVersions != null ? tlsVersions().toString() : "[all enabled]";
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ")";
        }
        return "ConnectionSpec()";
    }
}
