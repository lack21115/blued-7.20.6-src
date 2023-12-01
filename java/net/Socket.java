package java.net;

import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.nio.channels.SocketChannel;
import libcore.io.IoBridge;

/* loaded from: source-2895416-dex2jar.jar:java/net/Socket.class */
public class Socket implements Closeable {
    private static SocketImplFactory factory;
    private final Object connectLock;
    final SocketImpl impl;
    private boolean isBound;
    private boolean isClosed;
    private boolean isConnected;
    volatile boolean isCreated;
    private boolean isInputShutdown;
    private boolean isOutputShutdown;
    private InetAddress localAddress;
    private final Proxy proxy;

    public Socket() {
        this.isCreated = false;
        this.isBound = false;
        this.isConnected = false;
        this.isClosed = false;
        this.isInputShutdown = false;
        this.isOutputShutdown = false;
        this.localAddress = Inet4Address.ANY;
        this.connectLock = new Object();
        this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl();
        this.proxy = null;
    }

    public Socket(String str, int i) throws UnknownHostException, IOException {
        this(str, i, (InetAddress) null, 0);
    }

    public Socket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        this();
        tryAllAddresses(str, i, inetAddress, i2, true);
    }

    @Deprecated
    public Socket(String str, int i, boolean z) throws IOException {
        this();
        tryAllAddresses(str, i, null, 0, z);
    }

    public Socket(InetAddress inetAddress, int i) throws IOException {
        this();
        checkDestination(inetAddress, i);
        startupSocket(inetAddress, i, null, 0, true);
    }

    public Socket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        this();
        checkDestination(inetAddress, i);
        startupSocket(inetAddress, i, inetAddress2, i2, true);
    }

    @Deprecated
    public Socket(InetAddress inetAddress, int i, boolean z) throws IOException {
        this();
        checkDestination(inetAddress, i);
        startupSocket(inetAddress, i, null, 0, z);
    }

    public Socket(Proxy proxy) {
        this.isCreated = false;
        this.isBound = false;
        this.isConnected = false;
        this.isClosed = false;
        this.isInputShutdown = false;
        this.isOutputShutdown = false;
        this.localAddress = Inet4Address.ANY;
        this.connectLock = new Object();
        if (proxy == null || proxy.type() == Proxy.Type.HTTP) {
            throw new IllegalArgumentException("Invalid proxy: " + proxy);
        }
        this.proxy = proxy;
        this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl(proxy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Socket(SocketImpl socketImpl) throws SocketException {
        this.isCreated = false;
        this.isBound = false;
        this.isConnected = false;
        this.isClosed = false;
        this.isInputShutdown = false;
        this.isOutputShutdown = false;
        this.localAddress = Inet4Address.ANY;
        this.connectLock = new Object();
        this.impl = socketImpl;
        this.proxy = null;
    }

    private void cacheLocalAddress() throws SocketException {
        this.localAddress = IoBridge.getSocketLocalAddress(this.impl.fd);
    }

    private void checkDestination(InetAddress inetAddress, int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("Port out of range: " + i);
        }
    }

    private void checkOpenAndCreate(boolean z) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (!z) {
            if (!isConnected()) {
                throw new SocketException("Socket is not connected");
            }
        } else if (this.isCreated) {
        } else {
            synchronized (this) {
                if (this.isCreated) {
                    return;
                }
                try {
                    this.impl.create(true);
                    this.isCreated = true;
                } catch (SocketException e) {
                    throw e;
                } catch (IOException e2) {
                    throw new SocketException(e2.toString());
                }
            }
        }
    }

    public static void setSocketImplFactory(SocketImplFactory socketImplFactory) throws IOException {
        synchronized (Socket.class) {
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

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (usingSocks() == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void startupSocket(java.net.InetAddress r6, int r7, java.net.InetAddress r8, int r9, boolean r10) throws java.io.IOException {
        /*
            r5 = this;
            r0 = r9
            if (r0 < 0) goto Lc
            r0 = r9
            r1 = 65535(0xffff, float:9.1834E-41)
            if (r0 <= r1) goto L28
        Lc:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Local port out of range: "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r9
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L28:
            r0 = r8
            if (r0 != 0) goto L83
            java.net.InetAddress r0 = java.net.Inet4Address.ANY
            r8 = r0
        L30:
            r0 = r5
            monitor-enter(r0)
            r0 = r5
            java.net.SocketImpl r0 = r0.impl     // Catch: java.lang.Throwable -> L7e
            r1 = r10
            r0.create(r1)     // Catch: java.lang.Throwable -> L7e
            r0 = r5
            r1 = 1
            r0.isCreated = r1     // Catch: java.lang.Throwable -> L7e
            r0 = r10
            if (r0 == 0) goto L4c
            r0 = r5
            boolean r0 = r0.usingSocks()     // Catch: java.io.IOException -> L74 java.lang.Throwable -> L7e
            if (r0 != 0) goto L56
        L4c:
            r0 = r5
            java.net.SocketImpl r0 = r0.impl     // Catch: java.io.IOException -> L74 java.lang.Throwable -> L7e
            r1 = r8
            r2 = r9
            r0.bind(r1, r2)     // Catch: java.io.IOException -> L74 java.lang.Throwable -> L7e
        L56:
            r0 = r5
            r1 = 1
            r0.isBound = r1     // Catch: java.io.IOException -> L74 java.lang.Throwable -> L7e
            r0 = r5
            r0.cacheLocalAddress()     // Catch: java.io.IOException -> L74 java.lang.Throwable -> L7e
            r0 = r5
            java.net.SocketImpl r0 = r0.impl     // Catch: java.io.IOException -> L74 java.lang.Throwable -> L7e
            r1 = r6
            r2 = r7
            r0.connect(r1, r2)     // Catch: java.io.IOException -> L74 java.lang.Throwable -> L7e
            r0 = r5
            r1 = 1
            r0.isConnected = r1     // Catch: java.io.IOException -> L74 java.lang.Throwable -> L7e
            r0 = r5
            r0.cacheLocalAddress()     // Catch: java.io.IOException -> L74 java.lang.Throwable -> L7e
            r0 = r5
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            return
        L74:
            r6 = move-exception
            r0 = r5
            java.net.SocketImpl r0 = r0.impl     // Catch: java.lang.Throwable -> L7e
            r0.close()     // Catch: java.lang.Throwable -> L7e
            r0 = r6
            throw r0     // Catch: java.lang.Throwable -> L7e
        L7e:
            r6 = move-exception
            r0 = r5
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            r0 = r6
            throw r0
        L83:
            goto L30
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.Socket.startupSocket(java.net.InetAddress, int, java.net.InetAddress, int, boolean):void");
    }

    private void tryAllAddresses(String str, int i, InetAddress inetAddress, int i2, boolean z) throws IOException {
        InetAddress[] allByName = InetAddress.getAllByName(str);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= allByName.length - 1) {
                InetAddress inetAddress2 = allByName[allByName.length - 1];
                checkDestination(inetAddress2, i);
                startupSocket(inetAddress2, i, inetAddress, i2, z);
                return;
            }
            InetAddress inetAddress3 = allByName[i4];
            try {
                checkDestination(inetAddress3, i);
                startupSocket(inetAddress3, i, inetAddress, i2, z);
                return;
            } catch (IOException e) {
                i3 = i4 + 1;
            }
        }
    }

    private boolean usingSocks() {
        return this.proxy != null && this.proxy.type() == Proxy.Type.SOCKS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void accepted() throws SocketException {
        this.isConnected = true;
        this.isBound = true;
        this.isCreated = true;
        cacheLocalAddress();
    }

    public void bind(SocketAddress socketAddress) throws IOException {
        InetAddress address;
        int port;
        checkOpenAndCreate(true);
        if (isBound()) {
            throw new BindException("Socket is already bound");
        }
        if (socketAddress == null) {
            port = 0;
            address = Inet4Address.ANY;
        } else if (!(socketAddress instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Local address not an InetSocketAddress: " + socketAddress.getClass());
        } else {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            address = inetSocketAddress.getAddress();
            if (address == null) {
                throw new UnknownHostException("Host is unresolved: " + inetSocketAddress.getHostName());
            }
            port = inetSocketAddress.getPort();
        }
        synchronized (this) {
            try {
                this.impl.bind(address, port);
                this.isBound = true;
                cacheLocalAddress();
            } catch (IOException e) {
                this.impl.close();
                throw e;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            this.isClosed = true;
            this.isConnected = false;
            this.localAddress = Inet4Address.ANY;
            this.impl.close();
        }
    }

    public void connect(SocketAddress socketAddress) throws IOException {
        connect(socketAddress, 0);
    }

    public void connect(SocketAddress socketAddress, int i) throws IOException {
        checkOpenAndCreate(true);
        if (i < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (isConnected()) {
            throw new SocketException("Already connected");
        }
        if (socketAddress == null) {
            throw new IllegalArgumentException("remoteAddr == null");
        }
        if (!(socketAddress instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Remote address not an InetSocketAddress: " + socketAddress.getClass());
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            throw new UnknownHostException("Host is unresolved: " + inetSocketAddress.getHostName());
        }
        checkDestination(address, inetSocketAddress.getPort());
        synchronized (this.connectLock) {
            try {
                if (!isBound()) {
                    if (!usingSocks()) {
                        this.impl.bind(Inet4Address.ANY, 0);
                    }
                    this.isBound = true;
                }
                this.impl.connect(socketAddress, i);
                this.isConnected = true;
                cacheLocalAddress();
            } catch (IOException e) {
                this.impl.close();
                throw e;
            }
        }
    }

    public SocketChannel getChannel() {
        return null;
    }

    public FileDescriptor getFileDescriptor$() {
        return this.impl.fd;
    }

    public InetAddress getInetAddress() {
        if (isConnected()) {
            return this.impl.getInetAddress();
        }
        return null;
    }

    public InputStream getInputStream() throws IOException {
        checkOpenAndCreate(false);
        if (isInputShutdown()) {
            throw new SocketException("Socket input is shutdown");
        }
        return this.impl.getInputStream();
    }

    public boolean getKeepAlive() throws SocketException {
        checkOpenAndCreate(true);
        return ((Boolean) this.impl.getOption(8)).booleanValue();
    }

    public InetAddress getLocalAddress() {
        return this.localAddress;
    }

    public int getLocalPort() {
        if (isBound()) {
            return this.impl.getLocalPort();
        }
        return -1;
    }

    public SocketAddress getLocalSocketAddress() {
        if (isBound()) {
            return new InetSocketAddress(getLocalAddress(), getLocalPort());
        }
        return null;
    }

    public boolean getOOBInline() throws SocketException {
        checkOpenAndCreate(true);
        return ((Boolean) this.impl.getOption(SocketOptions.SO_OOBINLINE)).booleanValue();
    }

    public OutputStream getOutputStream() throws IOException {
        checkOpenAndCreate(false);
        if (isOutputShutdown()) {
            throw new SocketException("Socket output is shutdown");
        }
        return this.impl.getOutputStream();
    }

    public int getPort() {
        if (isConnected()) {
            return this.impl.getPort();
        }
        return 0;
    }

    public int getReceiveBufferSize() throws SocketException {
        int intValue;
        synchronized (this) {
            checkOpenAndCreate(true);
            intValue = ((Integer) this.impl.getOption(4098)).intValue();
        }
        return intValue;
    }

    public SocketAddress getRemoteSocketAddress() {
        if (isConnected()) {
            return new InetSocketAddress(getInetAddress(), getPort());
        }
        return null;
    }

    public boolean getReuseAddress() throws SocketException {
        checkOpenAndCreate(true);
        return ((Boolean) this.impl.getOption(4)).booleanValue();
    }

    public int getSendBufferSize() throws SocketException {
        int intValue;
        synchronized (this) {
            checkOpenAndCreate(true);
            intValue = ((Integer) this.impl.getOption(4097)).intValue();
        }
        return intValue;
    }

    public int getSoLinger() throws SocketException {
        checkOpenAndCreate(true);
        Object option = this.impl.getOption(128);
        if (option instanceof Integer) {
            return ((Integer) option).intValue();
        }
        return -1;
    }

    public int getSoTimeout() throws SocketException {
        int intValue;
        synchronized (this) {
            checkOpenAndCreate(true);
            intValue = ((Integer) this.impl.getOption(SocketOptions.SO_TIMEOUT)).intValue();
        }
        return intValue;
    }

    public boolean getTcpNoDelay() throws SocketException {
        checkOpenAndCreate(true);
        return ((Boolean) this.impl.getOption(1)).booleanValue();
    }

    public int getTrafficClass() throws SocketException {
        checkOpenAndCreate(true);
        return ((Integer) this.impl.getOption(3)).intValue();
    }

    public boolean isBound() {
        return this.isBound;
    }

    public boolean isClosed() {
        return this.isClosed;
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    public boolean isInputShutdown() {
        return this.isInputShutdown;
    }

    public boolean isOutputShutdown() {
        return this.isOutputShutdown;
    }

    public void onBind(InetAddress inetAddress, int i) {
        this.isBound = true;
        this.localAddress = inetAddress;
        this.impl.onBind(inetAddress, i);
    }

    public void onClose() {
        this.isClosed = true;
        this.isConnected = false;
        this.localAddress = Inet4Address.ANY;
        this.impl.onClose();
    }

    public void onConnect(InetAddress inetAddress, int i) {
        this.isConnected = true;
        this.impl.onConnect(inetAddress, i);
    }

    public void sendUrgentData(int i) throws IOException {
        this.impl.sendUrgentData(i);
    }

    public void setKeepAlive(boolean z) throws SocketException {
        if (this.impl != null) {
            checkOpenAndCreate(true);
            this.impl.setOption(8, Boolean.valueOf(z));
        }
    }

    public void setOOBInline(boolean z) throws SocketException {
        checkOpenAndCreate(true);
        this.impl.setOption(SocketOptions.SO_OOBINLINE, Boolean.valueOf(z));
    }

    public void setPerformancePreferences(int i, int i2, int i3) {
    }

    public void setReceiveBufferSize(int i) throws SocketException {
        synchronized (this) {
            checkOpenAndCreate(true);
            if (i < 1) {
                throw new IllegalArgumentException("size < 1");
            }
            this.impl.setOption(4098, Integer.valueOf(i));
        }
    }

    public void setReuseAddress(boolean z) throws SocketException {
        checkOpenAndCreate(true);
        this.impl.setOption(4, Boolean.valueOf(z));
    }

    public void setSendBufferSize(int i) throws SocketException {
        synchronized (this) {
            checkOpenAndCreate(true);
            if (i < 1) {
                throw new IllegalArgumentException("size < 1");
            }
            this.impl.setOption(4097, Integer.valueOf(i));
        }
    }

    public void setSoLinger(boolean z, int i) throws SocketException {
        checkOpenAndCreate(true);
        if (z && i < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (z) {
            this.impl.setOption(128, Integer.valueOf(i));
        } else {
            this.impl.setOption(128, Boolean.FALSE);
        }
    }

    public void setSoTimeout(int i) throws SocketException {
        synchronized (this) {
            checkOpenAndCreate(true);
            if (i < 0) {
                throw new IllegalArgumentException("timeout < 0");
            }
            this.impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(i));
        }
    }

    public void setTcpNoDelay(boolean z) throws SocketException {
        checkOpenAndCreate(true);
        this.impl.setOption(1, Boolean.valueOf(z));
    }

    public void setTrafficClass(int i) throws SocketException {
        checkOpenAndCreate(true);
        if (i < 0 || i > 255) {
            throw new IllegalArgumentException("Value doesn't fit in an unsigned byte: " + i);
        }
        this.impl.setOption(3, Integer.valueOf(i));
    }

    public void shutdownInput() throws IOException {
        if (isInputShutdown()) {
            throw new SocketException("Socket input is shutdown");
        }
        checkOpenAndCreate(false);
        this.impl.shutdownInput();
        this.isInputShutdown = true;
    }

    public void shutdownOutput() throws IOException {
        if (isOutputShutdown()) {
            throw new SocketException("Socket output is shutdown");
        }
        checkOpenAndCreate(false);
        this.impl.shutdownOutput();
        this.isOutputShutdown = true;
    }

    public String toString() {
        return !isConnected() ? "Socket[unconnected]" : this.impl.toString();
    }
}
