package javax.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

/* loaded from: source-2895416-dex2jar.jar:javax/net/SocketFactory.class */
public abstract class SocketFactory {
    private static SocketFactory defaultFactory;

    public static SocketFactory getDefault() {
        SocketFactory socketFactory;
        synchronized (SocketFactory.class) {
            try {
                if (defaultFactory == null) {
                    defaultFactory = new DefaultSocketFactory();
                }
                socketFactory = defaultFactory;
            } catch (Throwable th) {
                throw th;
            }
        }
        return socketFactory;
    }

    public Socket createSocket() throws IOException {
        throw new SocketException("Unconnected sockets not implemented");
    }

    public abstract Socket createSocket(String str, int i) throws IOException, UnknownHostException;

    public abstract Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException;

    public abstract Socket createSocket(InetAddress inetAddress, int i) throws IOException;

    public abstract Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException;
}
