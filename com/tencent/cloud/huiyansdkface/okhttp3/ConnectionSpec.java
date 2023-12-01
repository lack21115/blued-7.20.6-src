package com.tencent.cloud.huiyansdkface.okhttp3;

import com.android.org.conscrypt.NativeCrypto;
import com.blued.das.live.LiveProtos;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/ConnectionSpec.class */
public final class ConnectionSpec {
    final boolean e;
    final boolean f;
    final String[] g;
    final String[] h;
    private static final CipherSuite[] i = {CipherSuite.bl, CipherSuite.bm, CipherSuite.bn, CipherSuite.bo, CipherSuite.bp, CipherSuite.aX, CipherSuite.bb, CipherSuite.aY, CipherSuite.bc, CipherSuite.bi, CipherSuite.bh};
    private static final CipherSuite[] j = {CipherSuite.bl, CipherSuite.bm, CipherSuite.bn, CipherSuite.bo, CipherSuite.bp, CipherSuite.aX, CipherSuite.bb, CipherSuite.aY, CipherSuite.bc, CipherSuite.bi, CipherSuite.bh, CipherSuite.aI, CipherSuite.aJ, CipherSuite.ag, CipherSuite.ah, CipherSuite.E, CipherSuite.I, CipherSuite.i};

    /* renamed from: a  reason: collision with root package name */
    public static final ConnectionSpec f35837a = new Builder(true).cipherSuites(i).tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2).supportsTlsExtensions(true).build();
    public static final ConnectionSpec b = new Builder(true).cipherSuites(j).tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();

    /* renamed from: c  reason: collision with root package name */
    public static final ConnectionSpec f35838c = new Builder(true).cipherSuites(j).tlsVersions(TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    public static final ConnectionSpec d = new Builder(false).build();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/ConnectionSpec$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        boolean f35839a;
        String[] b;

        /* renamed from: c  reason: collision with root package name */
        String[] f35840c;
        boolean d;

        public Builder(ConnectionSpec connectionSpec) {
            this.f35839a = connectionSpec.e;
            this.b = connectionSpec.g;
            this.f35840c = connectionSpec.h;
            this.d = connectionSpec.f;
        }

        Builder(boolean z) {
            this.f35839a = z;
        }

        public Builder allEnabledCipherSuites() {
            if (this.f35839a) {
                this.b = null;
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public Builder allEnabledTlsVersions() {
            if (this.f35839a) {
                this.f35840c = null;
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public ConnectionSpec build() {
            return new ConnectionSpec(this);
        }

        public Builder cipherSuites(CipherSuite... cipherSuiteArr) {
            if (!this.f35839a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[cipherSuiteArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= cipherSuiteArr.length) {
                    return cipherSuites(strArr);
                }
                strArr[i2] = cipherSuiteArr[i2].bq;
                i = i2 + 1;
            }
        }

        public Builder cipherSuites(String... strArr) {
            if (this.f35839a) {
                if (strArr.length != 0) {
                    this.b = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public Builder supportsTlsExtensions(boolean z) {
            if (this.f35839a) {
                this.d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public Builder tlsVersions(TlsVersion... tlsVersionArr) {
            if (!this.f35839a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[tlsVersionArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= tlsVersionArr.length) {
                    return tlsVersions(strArr);
                }
                strArr[i2] = tlsVersionArr[i2].f;
                i = i2 + 1;
            }
        }

        public Builder tlsVersions(String... strArr) {
            if (this.f35839a) {
                if (strArr.length != 0) {
                    this.f35840c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
    }

    ConnectionSpec(Builder builder) {
        this.e = builder.f35839a;
        this.g = builder.b;
        this.h = builder.f35840c;
        this.f = builder.d;
    }

    private ConnectionSpec b(SSLSocket sSLSocket, boolean z) {
        String[] intersect = this.g != null ? Util.intersect(CipherSuite.f35831a, sSLSocket.getEnabledCipherSuites(), this.g) : sSLSocket.getEnabledCipherSuites();
        String[] intersect2 = this.h != null ? Util.intersect(Util.h, sSLSocket.getEnabledProtocols(), this.h) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int indexOf = Util.indexOf(CipherSuite.f35831a, supportedCipherSuites, NativeCrypto.TLS_FALLBACK_SCSV);
        String[] strArr = intersect;
        if (z) {
            strArr = intersect;
            if (indexOf != -1) {
                strArr = Util.concat(intersect, supportedCipherSuites[indexOf]);
            }
        }
        return new Builder(this).cipherSuites(strArr).tlsVersions(intersect2).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SSLSocket sSLSocket, boolean z) {
        ConnectionSpec b2 = b(sSLSocket, z);
        String[] strArr = b2.h;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b2.g;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public List<CipherSuite> cipherSuites() {
        String[] strArr = this.g;
        if (strArr != null) {
            return CipherSuite.a(strArr);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ConnectionSpec) {
            if (obj == this) {
                return true;
            }
            ConnectionSpec connectionSpec = (ConnectionSpec) obj;
            boolean z = this.e;
            if (z != connectionSpec.e) {
                return false;
            }
            if (z) {
                return Arrays.equals(this.g, connectionSpec.g) && Arrays.equals(this.h, connectionSpec.h) && this.f == connectionSpec.f;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.e) {
            return ((((LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE + Arrays.hashCode(this.g)) * 31) + Arrays.hashCode(this.h)) * 31) + (!this.f ? 1 : 0);
        }
        return 17;
    }

    public boolean isCompatible(SSLSocket sSLSocket) {
        if (this.e) {
            if (this.h == null || Util.nonEmptyIntersection(Util.h, this.h, sSLSocket.getEnabledProtocols())) {
                return this.g == null || Util.nonEmptyIntersection(CipherSuite.f35831a, this.g, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }

    public boolean isTls() {
        return this.e;
    }

    public boolean supportsTlsExtensions() {
        return this.f;
    }

    public List<TlsVersion> tlsVersions() {
        String[] strArr = this.h;
        if (strArr != null) {
            return TlsVersion.a(strArr);
        }
        return null;
    }

    public String toString() {
        if (this.e) {
            String obj = this.g != null ? cipherSuites().toString() : "[all enabled]";
            String obj2 = this.h != null ? tlsVersions().toString() : "[all enabled]";
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f + ")";
        }
        return "ConnectionSpec()";
    }
}
