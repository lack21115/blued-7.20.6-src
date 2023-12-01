package javax.net.ssl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/SSLSocket.class */
public abstract class SSLSocket extends Socket {
    /* JADX INFO: Access modifiers changed from: protected */
    public SSLSocket() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SSLSocket(String str, int i) throws IOException, UnknownHostException {
        super(str, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SSLSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        super(str, i, inetAddress, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SSLSocket(InetAddress inetAddress, int i) throws IOException {
        super(inetAddress, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SSLSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        super(inetAddress, i, inetAddress2, i2);
    }

    public abstract void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener);

    public abstract boolean getEnableSessionCreation();

    public abstract String[] getEnabledCipherSuites();

    public abstract String[] getEnabledProtocols();

    public abstract boolean getNeedClientAuth();

    public SSLParameters getSSLParameters() {
        SSLParameters sSLParameters = new SSLParameters();
        sSLParameters.setCipherSuites(getEnabledCipherSuites());
        sSLParameters.setProtocols(getEnabledProtocols());
        sSLParameters.setNeedClientAuth(getNeedClientAuth());
        sSLParameters.setWantClientAuth(getWantClientAuth());
        return sSLParameters;
    }

    public abstract SSLSession getSession();

    public abstract String[] getSupportedCipherSuites();

    public abstract String[] getSupportedProtocols();

    public abstract boolean getUseClientMode();

    public abstract boolean getWantClientAuth();

    public abstract void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener);

    public abstract void setEnableSessionCreation(boolean z);

    public abstract void setEnabledCipherSuites(String[] strArr);

    public abstract void setEnabledProtocols(String[] strArr);

    public abstract void setNeedClientAuth(boolean z);

    public void setSSLParameters(SSLParameters sSLParameters) {
        String[] cipherSuites = sSLParameters.getCipherSuites();
        if (cipherSuites != null) {
            setEnabledCipherSuites(cipherSuites);
        }
        String[] protocols = sSLParameters.getProtocols();
        if (protocols != null) {
            setEnabledProtocols(protocols);
        }
        if (sSLParameters.getNeedClientAuth()) {
            setNeedClientAuth(true);
        } else if (sSLParameters.getWantClientAuth()) {
            setWantClientAuth(true);
        } else {
            setWantClientAuth(false);
        }
    }

    public abstract void setUseClientMode(boolean z);

    public abstract void setWantClientAuth(boolean z);

    @Override // java.net.Socket
    public void shutdownInput() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.net.Socket
    public void shutdownOutput() throws IOException {
        throw new UnsupportedOperationException();
    }

    public abstract void startHandshake() throws IOException;
}
