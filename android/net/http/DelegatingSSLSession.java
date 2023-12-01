package android.net.http;

import java.security.Principal;
import java.security.cert.Certificate;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.X509Certificate;

/* loaded from: source-9557208-dex2jar.jar:android/net/http/DelegatingSSLSession.class */
public class DelegatingSSLSession implements SSLSession {

    /* loaded from: source-9557208-dex2jar.jar:android/net/http/DelegatingSSLSession$CertificateWrap.class */
    public static class CertificateWrap extends DelegatingSSLSession {
        private final Certificate mCertificate;

        public CertificateWrap(Certificate certificate) {
            this.mCertificate = certificate;
        }

        @Override // android.net.http.DelegatingSSLSession, javax.net.ssl.SSLSession
        public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
            return new Certificate[]{this.mCertificate};
        }
    }

    protected DelegatingSSLSession() {
    }

    @Override // javax.net.ssl.SSLSession
    public int getApplicationBufferSize() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public String getCipherSuite() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public long getCreationTime() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public byte[] getId() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public long getLastAccessedTime() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public Certificate[] getLocalCertificates() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getLocalPrincipal() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public int getPacketBufferSize() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public String getPeerHost() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public int getPeerPort() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public String getProtocol() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public SSLSessionContext getSessionContext() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public Object getValue(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public String[] getValueNames() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public void invalidate() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public boolean isValid() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public void putValue(String str, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.SSLSession
    public void removeValue(String str) {
        throw new UnsupportedOperationException();
    }
}
