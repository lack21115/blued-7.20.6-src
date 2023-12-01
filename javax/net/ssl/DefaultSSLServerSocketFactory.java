package javax.net.ssl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/DefaultSSLServerSocketFactory.class */
class DefaultSSLServerSocketFactory extends SSLServerSocketFactory {
    private final String errMessage;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultSSLServerSocketFactory(String str) {
        this.errMessage = str;
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i) throws IOException {
        throw new SocketException(this.errMessage);
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i, int i2) throws IOException {
        throw new SocketException(this.errMessage);
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i, int i2, InetAddress inetAddress) throws IOException {
        throw new SocketException(this.errMessage);
    }

    @Override // javax.net.ssl.SSLServerSocketFactory
    public String[] getDefaultCipherSuites() {
        return EmptyArray.STRING;
    }

    @Override // javax.net.ssl.SSLServerSocketFactory
    public String[] getSupportedCipherSuites() {
        return EmptyArray.STRING;
    }
}
