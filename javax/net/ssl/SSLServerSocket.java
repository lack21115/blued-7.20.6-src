package javax.net.ssl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/SSLServerSocket.class */
public abstract class SSLServerSocket extends ServerSocket {
    /* JADX INFO: Access modifiers changed from: protected */
    public SSLServerSocket() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SSLServerSocket(int i) throws IOException {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SSLServerSocket(int i, int i2) throws IOException {
        super(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SSLServerSocket(int i, int i2, InetAddress inetAddress) throws IOException {
        super(i, i2, inetAddress);
    }

    public abstract boolean getEnableSessionCreation();

    public abstract String[] getEnabledCipherSuites();

    public abstract String[] getEnabledProtocols();

    public abstract boolean getNeedClientAuth();

    public abstract String[] getSupportedCipherSuites();

    public abstract String[] getSupportedProtocols();

    public abstract boolean getUseClientMode();

    public abstract boolean getWantClientAuth();

    public abstract void setEnableSessionCreation(boolean z);

    public abstract void setEnabledCipherSuites(String[] strArr);

    public abstract void setEnabledProtocols(String[] strArr);

    public abstract void setNeedClientAuth(boolean z);

    public abstract void setUseClientMode(boolean z);

    public abstract void setWantClientAuth(boolean z);
}
