package com.android.org.conscrypt;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.net.ssl.SSLSessionBindingListener;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.CertificateException;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSessionImpl.class */
public class OpenSSLSessionImpl implements SSLSession {
    private String cipherSuite;
    private long creationTime;
    private byte[] id;
    private boolean isValid;
    long lastAccessedTime;
    final X509Certificate[] localCertificates;
    private volatile javax.security.cert.X509Certificate[] peerCertificateChain;
    final X509Certificate[] peerCertificates;
    private String peerHost;
    private int peerPort;
    private String protocol;
    private AbstractSessionContext sessionContext;
    protected long sslSessionNativePointer;
    private final Map<String, Object> values;

    /* JADX INFO: Access modifiers changed from: protected */
    public OpenSSLSessionImpl(long j, X509Certificate[] x509CertificateArr, X509Certificate[] x509CertificateArr2, String str, int i, AbstractSessionContext abstractSessionContext) {
        this.creationTime = 0L;
        this.lastAccessedTime = 0L;
        this.isValid = true;
        this.values = new HashMap();
        this.peerPort = -1;
        this.sslSessionNativePointer = j;
        this.localCertificates = x509CertificateArr;
        this.peerCertificates = x509CertificateArr2;
        this.peerHost = str;
        this.peerPort = i;
        this.sessionContext = abstractSessionContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLSessionImpl(byte[] bArr, String str, int i, X509Certificate[] x509CertificateArr, AbstractSessionContext abstractSessionContext) throws IOException {
        this(NativeCrypto.d2i_SSL_SESSION(bArr), null, x509CertificateArr, str, i, abstractSessionContext);
        if (this.sslSessionNativePointer == 0) {
            throw new IOException("Invalid session data");
        }
    }

    private void checkPeerCertificatesPresent() throws SSLPeerUnverifiedException {
        if (this.peerCertificates == null || this.peerCertificates.length == 0) {
            throw new SSLPeerUnverifiedException("No peer certificates");
        }
    }

    private javax.security.cert.X509Certificate[] createPeerCertificateChain() throws SSLPeerUnverifiedException {
        try {
            javax.security.cert.X509Certificate[] x509CertificateArr = new javax.security.cert.X509Certificate[this.peerCertificates.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.peerCertificates.length) {
                    return x509CertificateArr;
                }
                x509CertificateArr[i2] = javax.security.cert.X509Certificate.getInstance(this.peerCertificates[i2].getEncoded());
                i = i2 + 1;
            }
        } catch (CertificateEncodingException e) {
            Throwable sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
            sSLPeerUnverifiedException.initCause(sSLPeerUnverifiedException);
            throw sSLPeerUnverifiedException;
        } catch (CertificateException e2) {
            Throwable sSLPeerUnverifiedException2 = new SSLPeerUnverifiedException(e2.getMessage());
            sSLPeerUnverifiedException2.initCause(sSLPeerUnverifiedException2);
            throw sSLPeerUnverifiedException2;
        }
    }

    protected void finalize() throws Throwable {
        try {
            NativeCrypto.SSL_SESSION_free(this.sslSessionNativePointer);
        } finally {
            super.finalize();
        }
    }

    @Override // javax.net.ssl.SSLSession
    public int getApplicationBufferSize() {
        return 16384;
    }

    @Override // javax.net.ssl.SSLSession
    public String getCipherSuite() {
        if (this.cipherSuite == null) {
            String SSL_SESSION_cipher = NativeCrypto.SSL_SESSION_cipher(this.sslSessionNativePointer);
            this.cipherSuite = NativeCrypto.OPENSSL_TO_STANDARD_CIPHER_SUITES.get(SSL_SESSION_cipher);
            if (this.cipherSuite == null) {
                this.cipherSuite = SSL_SESSION_cipher;
            }
        }
        return this.cipherSuite;
    }

    @Override // javax.net.ssl.SSLSession
    public long getCreationTime() {
        if (this.creationTime == 0) {
            this.creationTime = NativeCrypto.SSL_SESSION_get_time(this.sslSessionNativePointer);
        }
        return this.creationTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getEncoded() {
        return NativeCrypto.i2d_SSL_SESSION(this.sslSessionNativePointer);
    }

    @Override // javax.net.ssl.SSLSession
    public byte[] getId() {
        if (this.id == null) {
            resetId();
        }
        return this.id;
    }

    @Override // javax.net.ssl.SSLSession
    public long getLastAccessedTime() {
        return this.lastAccessedTime == 0 ? getCreationTime() : this.lastAccessedTime;
    }

    @Override // javax.net.ssl.SSLSession
    public Certificate[] getLocalCertificates() {
        return this.localCertificates;
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getLocalPrincipal() {
        if (this.localCertificates == null || this.localCertificates.length <= 0) {
            return null;
        }
        return this.localCertificates[0].getSubjectX500Principal();
    }

    @Override // javax.net.ssl.SSLSession
    public int getPacketBufferSize() {
        return 18437;
    }

    @Override // javax.net.ssl.SSLSession
    public javax.security.cert.X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
        javax.security.cert.X509Certificate[] x509CertificateArr = this.peerCertificateChain;
        javax.security.cert.X509Certificate[] x509CertificateArr2 = x509CertificateArr;
        if (x509CertificateArr == null) {
            x509CertificateArr2 = createPeerCertificateChain();
            this.peerCertificateChain = x509CertificateArr2;
        }
        return x509CertificateArr2;
    }

    @Override // javax.net.ssl.SSLSession
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
        return this.peerCertificates;
    }

    @Override // javax.net.ssl.SSLSession
    public String getPeerHost() {
        return this.peerHost;
    }

    @Override // javax.net.ssl.SSLSession
    public int getPeerPort() {
        return this.peerPort;
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
        return this.peerCertificates[0].getSubjectX500Principal();
    }

    @Override // javax.net.ssl.SSLSession
    public String getProtocol() {
        if (this.protocol == null) {
            this.protocol = NativeCrypto.SSL_SESSION_get_version(this.sslSessionNativePointer);
        }
        return this.protocol;
    }

    @Override // javax.net.ssl.SSLSession
    public SSLSessionContext getSessionContext() {
        return this.sessionContext;
    }

    @Override // javax.net.ssl.SSLSession
    public Object getValue(String str) {
        if (str == null) {
            throw new IllegalArgumentException("name == null");
        }
        return this.values.get(str);
    }

    @Override // javax.net.ssl.SSLSession
    public String[] getValueNames() {
        return (String[]) this.values.keySet().toArray(new String[this.values.size()]);
    }

    @Override // javax.net.ssl.SSLSession
    public void invalidate() {
        this.isValid = false;
        this.sessionContext = null;
    }

    @Override // javax.net.ssl.SSLSession
    public boolean isValid() {
        int sessionTimeout;
        if (this.isValid) {
            AbstractSessionContext abstractSessionContext = this.sessionContext;
            if (abstractSessionContext == null || (sessionTimeout = abstractSessionContext.getSessionTimeout()) == 0) {
                return true;
            }
            long currentTimeMillis = (System.currentTimeMillis() - getCreationTime()) / 1000;
            if (currentTimeMillis >= sessionTimeout || currentTimeMillis < 0) {
                this.isValid = false;
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // javax.net.ssl.SSLSession
    public void putValue(String str, Object obj) {
        if (str == null || obj == null) {
            throw new IllegalArgumentException("name == null || value == null");
        }
        Object put = this.values.put(str, obj);
        if (obj instanceof SSLSessionBindingListener) {
            ((SSLSessionBindingListener) obj).valueBound(new SSLSessionBindingEvent(this, str));
        }
        if (put instanceof SSLSessionBindingListener) {
            ((SSLSessionBindingListener) put).valueUnbound(new SSLSessionBindingEvent(this, str));
        }
    }

    @Override // javax.net.ssl.SSLSession
    public void removeValue(String str) {
        if (str == null) {
            throw new IllegalArgumentException("name == null");
        }
        Object remove = this.values.remove(str);
        if (remove instanceof SSLSessionBindingListener) {
            ((SSLSessionBindingListener) remove).valueUnbound(new SSLSessionBindingEvent(this, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetId() {
        this.id = NativeCrypto.SSL_SESSION_session_id(this.sslSessionNativePointer);
    }
}
