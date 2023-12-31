package java.net;

import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: source-2895416-dex2jar.jar:java/net/SecureCacheResponse.class */
public abstract class SecureCacheResponse extends CacheResponse {
    public abstract String getCipherSuite();

    public abstract List<Certificate> getLocalCertificateChain();

    public abstract Principal getLocalPrincipal();

    public abstract Principal getPeerPrincipal() throws SSLPeerUnverifiedException;

    public abstract List<Certificate> getServerCertificateChain() throws SSLPeerUnverifiedException;
}
