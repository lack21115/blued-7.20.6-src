package com.tencent.cloud.huiyansdkface.okhttp3;

import com.blued.das.live.LiveProtos;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/Handshake.class */
public final class Handshake {

    /* renamed from: a  reason: collision with root package name */
    private final TlsVersion f35855a;
    private final CipherSuite b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Certificate> f35856c;
    private final List<Certificate> d;

    private Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        this.f35855a = tlsVersion;
        this.b = cipherSuite;
        this.f35856c = list;
        this.d = list2;
    }

    public static Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        if (tlsVersion != null) {
            if (cipherSuite != null) {
                return new Handshake(tlsVersion, cipherSuite, Util.immutableList(list), Util.immutableList(list2));
            }
            throw new NullPointerException("cipherSuite == null");
        }
        throw new NullPointerException("tlsVersion == null");
    }

    public static Handshake get(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
                throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
            }
            CipherSuite forJavaName = CipherSuite.forJavaName(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                if ("NONE".equals(protocol)) {
                    throw new IOException("tlsVersion == NONE");
                }
                TlsVersion forJavaName2 = TlsVersion.forJavaName(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException e) {
                    certificateArr = null;
                }
                List immutableList = certificateArr != null ? Util.immutableList(certificateArr) : Collections.emptyList();
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                return new Handshake(forJavaName2, forJavaName, immutableList, localCertificates != null ? Util.immutableList(localCertificates) : Collections.emptyList());
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public CipherSuite cipherSuite() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            boolean z = false;
            if (this.f35855a.equals(handshake.f35855a)) {
                z = false;
                if (this.b.equals(handshake.b)) {
                    z = false;
                    if (this.f35856c.equals(handshake.f35856c)) {
                        z = false;
                        if (this.d.equals(handshake.d)) {
                            z = true;
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return ((((((LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE + this.f35855a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.f35856c.hashCode()) * 31) + this.d.hashCode();
    }

    public List<Certificate> localCertificates() {
        return this.d;
    }

    public Principal localPrincipal() {
        if (this.d.isEmpty()) {
            return null;
        }
        return ((X509Certificate) this.d.get(0)).getSubjectX500Principal();
    }

    public List<Certificate> peerCertificates() {
        return this.f35856c;
    }

    public Principal peerPrincipal() {
        if (this.f35856c.isEmpty()) {
            return null;
        }
        return ((X509Certificate) this.f35856c.get(0)).getSubjectX500Principal();
    }

    public TlsVersion tlsVersion() {
        return this.f35855a;
    }
}
