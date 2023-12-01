package java.net;

import android.system.ErrnoException;
import android.system.OsConstants;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.DatagramChannel;
import libcore.io.IoBridge;
import libcore.io.Libcore;

/* loaded from: source-2895416-dex2jar.jar:java/net/DatagramSocket.class */
public class DatagramSocket implements Closeable {
    static DatagramSocketImplFactory factory;
    InetAddress address;
    DatagramSocketImpl impl;
    boolean isBound;
    private boolean isClosed;
    private boolean isConnected;
    private Object lock;
    private SocketException pendingConnectException;
    int port;

    public DatagramSocket() throws SocketException {
        this(0);
    }

    public DatagramSocket(int i) throws SocketException {
        this.port = -1;
        this.isBound = false;
        this.isConnected = false;
        this.isClosed = false;
        this.lock = new Object();
        checkPort(i);
        createSocket(i, Inet4Address.ANY);
    }

    public DatagramSocket(int i, InetAddress inetAddress) throws SocketException {
        this.port = -1;
        this.isBound = false;
        this.isConnected = false;
        this.isClosed = false;
        this.lock = new Object();
        checkPort(i);
        createSocket(i, inetAddress == null ? Inet4Address.ANY : inetAddress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DatagramSocket(DatagramSocketImpl datagramSocketImpl) {
        this.port = -1;
        this.isBound = false;
        this.isConnected = false;
        this.isClosed = false;
        this.lock = new Object();
        if (datagramSocketImpl == null) {
            throw new NullPointerException("socketImpl == null");
        }
        this.impl = datagramSocketImpl;
    }

    public DatagramSocket(SocketAddress socketAddress) throws SocketException {
        this.port = -1;
        this.isBound = false;
        this.isConnected = false;
        this.isClosed = false;
        this.lock = new Object();
        if (socketAddress != null) {
            if (!(socketAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Local address not an InetSocketAddress: " + socketAddress.getClass());
            }
            checkPort(((InetSocketAddress) socketAddress).getPort());
        }
        this.impl = factory != null ? factory.createDatagramSocketImpl() : new PlainDatagramSocketImpl();
        this.impl.create();
        if (socketAddress != null) {
            try {
                bind(socketAddress);
            } catch (SocketException e) {
                close();
                throw e;
            }
        }
        setBroadcast(true);
    }

    private void checkPort(int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("Port out of range: " + i);
        }
    }

    private void ensureBound() throws SocketException {
        if (isBound()) {
            return;
        }
        this.impl.bind(0, Inet4Address.ANY);
        this.isBound = true;
    }

    public static void setDatagramSocketImplFactory(DatagramSocketImplFactory datagramSocketImplFactory) throws IOException {
        synchronized (DatagramSocket.class) {
            try {
                if (factory != null) {
                    throw new SocketException("Factory already set");
                }
                factory = datagramSocketImplFactory;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void bind(SocketAddress socketAddress) throws SocketException {
        InetAddress address;
        int port;
        checkOpen();
        if (socketAddress == null) {
            port = 0;
            address = Inet4Address.ANY;
        } else if (!(socketAddress instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Local address not an InetSocketAddress: " + socketAddress.getClass());
        } else {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            address = inetSocketAddress.getAddress();
            if (address == null) {
                throw new SocketException("Host is unresolved: " + inetSocketAddress.getHostName());
            }
            port = inetSocketAddress.getPort();
            checkPort(port);
        }
        this.impl.bind(port, address);
        this.isBound = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkOpen() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.isClosed = true;
        this.impl.close();
    }

    public void connect(InetAddress inetAddress, int i) {
        if (inetAddress == null) {
            throw new IllegalArgumentException("address == null");
        }
        try {
            connect(new InetSocketAddress(inetAddress, i));
        } catch (SocketException e) {
            this.pendingConnectException = e;
        }
    }

    public void connect(SocketAddress socketAddress) throws SocketException {
        if (socketAddress == null) {
            throw new IllegalArgumentException("peer == null");
        }
        if (!(socketAddress instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("peer not an InetSocketAddress: " + socketAddress.getClass());
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
        if (inetSocketAddress.getAddress() == null) {
            throw new SocketException("Host is unresolved: " + inetSocketAddress.getHostName());
        }
        synchronized (this.lock) {
            checkOpen();
            ensureBound();
            this.address = inetSocketAddress.getAddress();
            this.port = inetSocketAddress.getPort();
            this.isConnected = true;
            this.impl.connect(this.address, this.port);
        }
    }

    void createSocket(int i, InetAddress inetAddress) throws SocketException {
        synchronized (this) {
            this.impl = factory != null ? factory.createDatagramSocketImpl() : new PlainDatagramSocketImpl();
            this.impl.create();
            try {
                this.impl.bind(i, inetAddress);
                this.isBound = true;
            } catch (SocketException e) {
                close();
                throw e;
            }
        }
    }

    public void disconnect() {
        if (isClosed() || !isConnected()) {
            return;
        }
        this.impl.disconnect();
        this.address = null;
        this.port = -1;
        this.isConnected = false;
    }

    public boolean getBroadcast() throws SocketException {
        checkOpen();
        return ((Boolean) this.impl.getOption(32)).booleanValue();
    }

    public DatagramChannel getChannel() {
        return null;
    }

    public final FileDescriptor getFileDescriptor$() {
        return this.impl.fd;
    }

    public InetAddress getInetAddress() {
        return this.address;
    }

    public InetAddress getLocalAddress() {
        try {
            return IoBridge.getSocketLocalAddress(this.impl.fd);
        } catch (SocketException e) {
            return null;
        }
    }

    public int getLocalPort() {
        if (isClosed()) {
            return -1;
        }
        if (isBound()) {
            return this.impl.getLocalPort();
        }
        return 0;
    }

    public SocketAddress getLocalSocketAddress() {
        if (isClosed() || !isBound()) {
            return null;
        }
        return new InetSocketAddress(getLocalAddress(), getLocalPort());
    }

    public int getPort() {
        return this.port;
    }

    public int getReceiveBufferSize() throws SocketException {
        int intValue;
        synchronized (this) {
            checkOpen();
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
        checkOpen();
        return ((Boolean) this.impl.getOption(4)).booleanValue();
    }

    public int getSendBufferSize() throws SocketException {
        int intValue;
        synchronized (this) {
            checkOpen();
            intValue = ((Integer) this.impl.getOption(4097)).intValue();
        }
        return intValue;
    }

    public int getSoTimeout() throws SocketException {
        int intValue;
        synchronized (this) {
            checkOpen();
            intValue = ((Integer) this.impl.getOption(4102)).intValue();
        }
        return intValue;
    }

    public int getTrafficClass() throws SocketException {
        checkOpen();
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

    boolean isMulticastSocket() {
        return false;
    }

    public void onBind(InetAddress inetAddress, int i) {
        this.isBound = true;
        this.impl.onBind(inetAddress, i);
    }

    public void onClose() {
        this.isClosed = true;
        this.impl.onClose();
    }

    public void onConnect(InetAddress inetAddress, int i) {
        this.isConnected = true;
        this.address = inetAddress;
        this.port = i;
        this.impl.onConnect(inetAddress, i);
    }

    public void onDisconnect() {
        this.address = null;
        this.port = -1;
        this.isConnected = false;
        this.impl.onDisconnect();
    }

    public void receive(DatagramPacket datagramPacket) throws IOException {
        synchronized (this) {
            checkOpen();
            ensureBound();
            if (datagramPacket == null) {
                throw new NullPointerException("pack == null");
            }
            if (this.pendingConnectException != null) {
                throw new SocketException("Pending connect failure", this.pendingConnectException);
            }
            datagramPacket.resetLengthForReceive();
            this.impl.receive(datagramPacket);
        }
    }

    public void send(DatagramPacket datagramPacket) throws IOException {
        checkOpen();
        ensureBound();
        InetAddress address = datagramPacket.getAddress();
        if (this.address != null) {
            if (address == null) {
                datagramPacket.setAddress(this.address);
                datagramPacket.setPort(this.port);
            } else if (!this.address.equals(address) || this.port != datagramPacket.getPort()) {
                throw new IllegalArgumentException("Packet address mismatch with connected address");
            }
        } else if (address == null) {
            throw new NullPointerException("Destination address is null");
        }
        this.impl.send(datagramPacket);
    }

    public void setBroadcast(boolean z) throws SocketException {
        checkOpen();
        this.impl.setOption(32, Boolean.valueOf(z));
    }

    public void setNetworkInterface(NetworkInterface networkInterface) throws SocketException {
        if (networkInterface == null) {
            throw new NullPointerException("netInterface == null");
        }
        try {
            Libcore.os.setsockoptIfreq(this.impl.fd, OsConstants.SOL_SOCKET, OsConstants.SO_BINDTODEVICE, networkInterface.getName());
        } catch (ErrnoException e) {
            throw e.rethrowAsSocketException();
        }
    }

    public void setReceiveBufferSize(int i) throws SocketException {
        synchronized (this) {
            if (i < 1) {
                throw new IllegalArgumentException("size < 1");
            }
            checkOpen();
            this.impl.setOption(4098, Integer.valueOf(i));
        }
    }

    public void setReuseAddress(boolean z) throws SocketException {
        checkOpen();
        this.impl.setOption(4, Boolean.valueOf(z));
    }

    public void setSendBufferSize(int i) throws SocketException {
        synchronized (this) {
            if (i < 1) {
                throw new IllegalArgumentException("size < 1");
            }
            checkOpen();
            this.impl.setOption(4097, Integer.valueOf(i));
        }
    }

    public void setSoTimeout(int i) throws SocketException {
        synchronized (this) {
            if (i < 0) {
                throw new IllegalArgumentException("timeout < 0");
            }
            checkOpen();
            this.impl.setOption(4102, Integer.valueOf(i));
        }
    }

    public void setTrafficClass(int i) throws SocketException {
        checkOpen();
        if (i < 0 || i > 255) {
            throw new IllegalArgumentException("Value doesn't fit in an unsigned byte: " + i);
        }
        this.impl.setOption(3, Integer.valueOf(i));
    }
}
