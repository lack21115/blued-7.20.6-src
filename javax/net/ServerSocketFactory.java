package javax.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ServerSocketFactory.class */
public abstract class ServerSocketFactory {
    private static ServerSocketFactory defaultFactory;

    public static ServerSocketFactory getDefault() {
        ServerSocketFactory serverSocketFactory;
        synchronized (ServerSocketFactory.class) {
            try {
                if (defaultFactory == null) {
                    defaultFactory = new DefaultServerSocketFactory();
                }
                serverSocketFactory = defaultFactory;
            } catch (Throwable th) {
                throw th;
            }
        }
        return serverSocketFactory;
    }

    public ServerSocket createServerSocket() throws IOException {
        throw new SocketException("Unbound server sockets not implemented");
    }

    public abstract ServerSocket createServerSocket(int i) throws IOException;

    public abstract ServerSocket createServerSocket(int i, int i2) throws IOException;

    public abstract ServerSocket createServerSocket(int i, int i2, InetAddress inetAddress) throws IOException;
}
