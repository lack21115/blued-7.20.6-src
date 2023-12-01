package org.conscrypt;

import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.X509Certificate;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/SSLNullSession.class */
public final class SSLNullSession implements Cloneable, ConscryptSession {
    static final String INVALID_CIPHER = "SSL_NULL_WITH_NULL_NULL";
    private long creationTime;
    private long lastAccessedTime;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/SSLNullSession$DefaultHolder.class */
    public static class DefaultHolder {
        static final SSLNullSession NULL_SESSION = new SSLNullSession();

        private DefaultHolder() {
        }
    }

    private SSLNullSession() {
        long currentTimeMillis = System.currentTimeMillis();
        this.creationTime = currentTimeMillis;
        this.lastAccessedTime = currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ConscryptSession getNullSession() {
        return DefaultHolder.NULL_SESSION;
    }

    @Override // javax.net.ssl.SSLSession
    public int getApplicationBufferSize() {
        return 16384;
    }

    @Override // org.conscrypt.ConscryptSession
    public String getApplicationProtocol() {
        return null;
    }

    @Override // javax.net.ssl.SSLSession
    public String getCipherSuite() {
        return INVALID_CIPHER;
    }

    @Override // javax.net.ssl.SSLSession
    public long getCreationTime() {
        return this.creationTime;
    }

    @Override // javax.net.ssl.SSLSession
    public byte[] getId() {
        return EmptyArray.BYTE;
    }

    @Override // javax.net.ssl.SSLSession
    public long getLastAccessedTime() {
        return this.lastAccessedTime;
    }

    @Override // javax.net.ssl.SSLSession
    public Certificate[] getLocalCertificates() {
        return null;
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getLocalPrincipal() {
        return null;
    }

    @Override // javax.net.ssl.SSLSession
    public int getPacketBufferSize() {
        return com.android.org.conscrypt.NativeCrypto.SSL3_RT_MAX_PACKET_SIZE;
    }

    @Override // javax.net.ssl.SSLSession
    public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        throw new SSLPeerUnverifiedException("No peer certificate");
    }

    @Override // javax.net.ssl.SSLSession
    public java.security.cert.X509Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        throw new SSLPeerUnverifiedException("No peer certificate");
    }

    @Override // javax.net.ssl.SSLSession
    public String getPeerHost() {
        return null;
    }

    @Override // javax.net.ssl.SSLSession
    public int getPeerPort() {
        return -1;
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        throw new SSLPeerUnverifiedException("No peer certificate");
    }

    @Override // org.conscrypt.ConscryptSession
    public byte[] getPeerSignedCertificateTimestamp() {
        return EmptyArray.BYTE;
    }

    @Override // javax.net.ssl.SSLSession
    public String getProtocol() {
        return "NONE";
    }

    @Override // org.conscrypt.ConscryptSession
    public String getRequestedServerName() {
        return null;
    }

    @Override // javax.net.ssl.SSLSession
    public SSLSessionContext getSessionContext() {
        return null;
    }

    @Override // org.conscrypt.ConscryptSession
    public List<byte[]> getStatusResponses() {
        return Collections.emptyList();
    }

    @Override // javax.net.ssl.SSLSession
    public Object getValue(String str) {
        throw new UnsupportedOperationException("All calls to this method should be intercepted by ExternalSession.");
    }

    @Override // javax.net.ssl.SSLSession
    public String[] getValueNames() {
        throw new UnsupportedOperationException("All calls to this method should be intercepted by ExternalSession.");
    }

    @Override // javax.net.ssl.SSLSession
    public void invalidate() {
    }

    @Override // javax.net.ssl.SSLSession
    public boolean isValid() {
        return false;
    }

    @Override // javax.net.ssl.SSLSession
    public void putValue(String str, Object obj) {
        throw new UnsupportedOperationException("All calls to this method should be intercepted by ExternalSession.");
    }

    @Override // javax.net.ssl.SSLSession
    public void removeValue(String str) {
        throw new UnsupportedOperationException("All calls to this method should be intercepted by ExternalSession.");
    }
}
