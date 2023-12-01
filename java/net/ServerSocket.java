package java.net;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.ServerSocketChannel;
import libcore.io.IoBridge;

/* loaded from: source-2895416-dex2jar.jar:java/net/ServerSocket.class */
public class ServerSocket implements Closeable {
    private static final int DEFAULT_BACKLOG = 50;
    static SocketImplFactory factory;
    private final SocketImpl impl;
    private boolean isBound;
    private boolean isClosed;
    private InetAddress localAddress;

    public ServerSocket() throws IOException {
        this.impl = factory != null ? factory.createSocketImpl() : new PlainServerSocketImpl();
        this.impl.create(true);
    }

    public ServerSocket(int i) throws IOException {
        this(i, 50, Inet4Address.ANY);
    }

    public ServerSocket(int i, int i2) throws IOException {
        this(i, i2, Inet4Address.ANY);
    }

    public ServerSocket(int i, int i2, InetAddress inetAddress) throws IOException {
        checkListen(i);
        this.impl = factory != null ? factory.createSocketImpl() : new PlainServerSocketImpl();
        inetAddress = inetAddress == null ? Inet4Address.ANY : inetAddress;
        synchronized (this) {
            this.impl.create(true);
            try {
                this.impl.bind(inetAddress, i);
                readBackBindState();
                this.impl.listen(i2 <= 0 ? 50 : i2);
            } catch (IOException e) {
                close();
                throw e;
            }
        }
    }

    private void checkListen(int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("Port out of range: " + i);
        }
    }

    private void checkOpen() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
    }

    private void readBackBindState() throws SocketException {
        this.localAddress = IoBridge.getSocketLocalAddress(this.impl.fd);
        this.isBound = true;
    }

    public static void setSocketFactory(SocketImplFactory socketImplFactory) throws IOException {
        synchronized (ServerSocket.class) {
            try {
                if (factory != null) {
                    throw new SocketException("Factory already set");
                }
                factory = socketImplFactory;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Socket accept() throws IOException {
        checkOpen();
        if (isBound()) {
            Socket socket = new Socket();
            try {
                implAccept(socket);
                return socket;
            } catch (IOException e) {
                socket.close();
                throw e;
            }
        }
        throw new SocketException("Socket is not bound");
    }

    public void bind(SocketAddress socketAddress) throws IOException {
        bind(socketAddress, 50);
    }

    public void bind(SocketAddress socketAddress, int i) throws IOException {
        InetAddress address;
        int port;
        checkOpen();
        if (isBound()) {
            throw new BindException("Socket is already bound");
        }
        if (socketAddress == null) {
            address = Inet4Address.ANY;
            port = 0;
        } else if (!(socketAddress instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Local address not an InetSocketAddress: " + socketAddress.getClass());
        } else {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            address = inetSocketAddress.getAddress();
            if (address == null) {
                throw new SocketException("Host is unresolved: " + inetSocketAddress.getHostName());
            }
            port = inetSocketAddress.getPort();
        }
        synchronized (this) {
            try {
                this.impl.bind(address, port);
                readBackBindState();
                SocketImpl socketImpl = this.impl;
                if (i <= 0) {
                    i = 50;
                }
                socketImpl.listen(i);
            } catch (IOException e) {
                close();
                throw e;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.isClosed = true;
        this.impl.close();
    }

    public ServerSocketChannel getChannel() {
        return null;
    }

    public SocketImpl getImpl$() {
        return this.impl;
    }

    public InetAddress getInetAddress() {
        if (isBound()) {
            return this.localAddress;
        }
        return null;
    }

    public int getLocalPort() {
        if (isBound()) {
            return this.impl.getLocalPort();
        }
        return -1;
    }

    public SocketAddress getLocalSocketAddress() {
        if (isBound()) {
            return new InetSocketAddress(this.localAddress, getLocalPort());
        }
        return null;
    }

    public int getReceiveBufferSize() throws SocketException {
        checkOpen();
        return ((Integer) this.impl.getOption(4098)).intValue();
    }

    public boolean getReuseAddress() throws SocketException {
        checkOpen();
        return ((Boolean) this.impl.getOption(4)).booleanValue();
    }

    public int getSoTimeout() throws IOException {
        int intValue;
        synchronized (this) {
            checkOpen();
            intValue = ((Integer) this.impl.getOption(SocketOptions.SO_TIMEOUT)).intValue();
        }
        return intValue;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void implAccept(Socket socket) throws IOException {
        synchronized (this) {
            this.impl.accept(socket.impl);
            socket.accepted();
        }
    }

    public boolean isBound() {
        return this.isBound;
    }

    public boolean isClosed() {
        return this.isClosed;
    }

    public void setPerformancePreferences(int i, int i2, int i3) {
    }

    public void setReceiveBufferSize(int i) throws SocketException {
        checkOpen();
        if (i < 1) {
            throw new IllegalArgumentException("size < 1");
        }
        this.impl.setOption(4098, Integer.valueOf(i));
    }

    public void setReuseAddress(boolean z) throws SocketException {
        checkOpen();
        this.impl.setOption(4, Boolean.valueOf(z));
    }

    public void setSoTimeout(int i) throws SocketException {
        synchronized (this) {
            checkOpen();
            if (i < 0) {
                throw new IllegalArgumentException("timeout < 0");
            }
            this.impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(i));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("ServerSocket[");
        return !isBound() ? sb.append("unbound]").toString() : sb.append("addr=").append(getInetAddress().getHostName()).append(BridgeUtil.SPLIT_MARK).append(getInetAddress().getHostAddress()).append(",port=0,localport=").append(getLocalPort()).append("]").toString();
    }
}
