package javax.net.ssl;

import java.security.Principal;
import java.security.cert.Certificate;
import java.util.EventObject;
import javax.security.cert.X509Certificate;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/HandshakeCompletedEvent.class */
public class HandshakeCompletedEvent extends EventObject {
    private transient SSLSession session;

    public HandshakeCompletedEvent(SSLSocket sSLSocket, SSLSession sSLSession) {
        super(sSLSocket);
        this.session = sSLSession;
    }

    public String getCipherSuite() {
        return this.session.getCipherSuite();
    }

    public Certificate[] getLocalCertificates() {
        return this.session.getLocalCertificates();
    }

    public Principal getLocalPrincipal() {
        return this.session.getLocalPrincipal();
    }

    public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        return this.session.getPeerCertificateChain();
    }

    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        return this.session.getPeerCertificates();
    }

    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return this.session.getPeerPrincipal();
    }

    public SSLSession getSession() {
        return this.session;
    }

    public SSLSocket getSocket() {
        return (SSLSocket) this.source;
    }
}
