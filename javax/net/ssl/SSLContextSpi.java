package javax.net.ssl;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.SecureRandom;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/SSLContextSpi.class */
public abstract class SSLContextSpi {
    private SSLParameters createSSLParameters(boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        try {
            SSLSocket sSLSocket = (SSLSocket) engineGetSocketFactory().createSocket();
            SSLParameters sSLParameters = new SSLParameters();
            if (z) {
                enabledCipherSuites = sSLSocket.getSupportedCipherSuites();
                enabledProtocols = sSLSocket.getSupportedProtocols();
            } else {
                enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
                enabledProtocols = sSLSocket.getEnabledProtocols();
            }
            sSLParameters.setCipherSuites(enabledCipherSuites);
            sSLParameters.setProtocols(enabledProtocols);
            sSLParameters.setNeedClientAuth(sSLSocket.getNeedClientAuth());
            sSLParameters.setWantClientAuth(sSLSocket.getWantClientAuth());
            return sSLParameters;
        } catch (IOException e) {
            throw new UnsupportedOperationException("Could not access supported SSL parameters");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SSLEngine engineCreateSSLEngine();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SSLEngine engineCreateSSLEngine(String str, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SSLSessionContext engineGetClientSessionContext();

    /* JADX INFO: Access modifiers changed from: protected */
    public SSLParameters engineGetDefaultSSLParameters() {
        return createSSLParameters(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SSLSessionContext engineGetServerSessionContext();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SSLServerSocketFactory engineGetServerSocketFactory();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SSLSocketFactory engineGetSocketFactory();

    /* JADX INFO: Access modifiers changed from: protected */
    public SSLParameters engineGetSupportedSSLParameters() {
        return createSSLParameters(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom) throws KeyManagementException;
}
