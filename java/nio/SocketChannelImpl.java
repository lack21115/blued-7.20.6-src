package java.nio;

import android.system.ErrnoException;
import android.system.OsConstants;
import java.io.FileDescriptor;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PlainSocketImpl;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketUtils;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.channels.NoConnectionPendingException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SocketChannel;
import java.nio.channels.UnresolvedAddressException;
import java.nio.channels.UnsupportedAddressTypeException;
import java.nio.channels.spi.SelectorProvider;
import java.util.Arrays;
import libcore.io.IoBridge;
import libcore.io.IoUtils;
import libcore.io.Libcore;

/* loaded from: source-2895416-dex2jar.jar:java/nio/SocketChannelImpl.class */
class SocketChannelImpl extends SocketChannel implements FileDescriptorChannel {
    private static final int SOCKET_STATUS_CLOSED = 3;
    private static final int SOCKET_STATUS_CONNECTED = 2;
    private static final int SOCKET_STATUS_PENDING = 1;
    private static final int SOCKET_STATUS_UNCONNECTED = 0;
    private static final int SOCKET_STATUS_UNINITIALIZED = -1;
    private InetSocketAddress connectAddress;
    private final FileDescriptor fd;
    private volatile boolean isBound;
    private InetAddress localAddress;
    private int localPort;
    private final Object readLock;
    private SocketAdapter socket;
    private int status;
    private final Object writeLock;

    /* loaded from: source-2895416-dex2jar.jar:java/nio/SocketChannelImpl$BlockingCheckInputStream.class */
    private static class BlockingCheckInputStream extends FilterInputStream {
        private final SocketChannel channel;

        public BlockingCheckInputStream(InputStream inputStream, SocketChannel socketChannel) {
            super(inputStream);
            this.channel = socketChannel;
        }

        private void checkBlocking() {
            if (!this.channel.isBlocking()) {
                throw new IllegalBlockingModeException();
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            this.channel.close();
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            checkBlocking();
            return this.in.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            checkBlocking();
            return this.in.read(bArr);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            checkBlocking();
            return this.in.read(bArr, i, i2);
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/nio/SocketChannelImpl$BlockingCheckOutputStream.class */
    private static class BlockingCheckOutputStream extends FilterOutputStream {
        private final SocketChannel channel;

        public BlockingCheckOutputStream(OutputStream outputStream, SocketChannel socketChannel) {
            super(outputStream);
            this.channel = socketChannel;
        }

        private void checkBlocking() {
            if (!this.channel.isBlocking()) {
                throw new IllegalBlockingModeException();
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            this.channel.close();
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            checkBlocking();
            this.out.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            checkBlocking();
            this.out.write(bArr);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            checkBlocking();
            this.out.write(bArr, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/nio/SocketChannelImpl$SocketAdapter.class */
    public static class SocketAdapter extends Socket {
        private final SocketChannelImpl channel;
        private final PlainSocketImpl socketImpl;

        SocketAdapter(PlainSocketImpl plainSocketImpl, SocketChannelImpl socketChannelImpl) throws SocketException {
            super(plainSocketImpl);
            this.socketImpl = plainSocketImpl;
            this.channel = socketChannelImpl;
            SocketUtils.setCreated(this);
            if (socketChannelImpl.isBound) {
                onBind(socketChannelImpl.localAddress, socketChannelImpl.localPort);
            }
            if (socketChannelImpl.isConnected()) {
                onConnect(socketChannelImpl.connectAddress.getAddress(), socketChannelImpl.connectAddress.getPort());
            }
            if (socketChannelImpl.isOpen()) {
                return;
            }
            onClose();
        }

        @Override // java.net.Socket
        public void bind(SocketAddress socketAddress) throws IOException {
            if (this.channel.isConnected()) {
                throw new AlreadyConnectedException();
            }
            if (1 == this.channel.status) {
                throw new ConnectionPendingException();
            }
            super.bind(socketAddress);
            this.channel.onBind(false);
        }

        @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (this.channel) {
                super.close();
                if (this.channel.isOpen()) {
                    this.channel.close();
                }
            }
        }

        @Override // java.net.Socket
        public void connect(SocketAddress socketAddress, int i) throws IOException {
            if (!this.channel.isBlocking()) {
                throw new IllegalBlockingModeException();
            }
            if (isConnected()) {
                throw new AlreadyConnectedException();
            }
            super.connect(socketAddress, i);
            this.channel.onBind(false);
            if (super.isConnected()) {
                this.channel.onConnectStatusChanged((InetSocketAddress) socketAddress, 2, false);
            }
        }

        @Override // java.net.Socket
        public SocketChannel getChannel() {
            return this.channel;
        }

        @Override // java.net.Socket
        public FileDescriptor getFileDescriptor$() {
            return this.socketImpl.getFD$();
        }

        @Override // java.net.Socket
        public InputStream getInputStream() throws IOException {
            return new BlockingCheckInputStream(super.getInputStream(), this.channel);
        }

        @Override // java.net.Socket
        public OutputStream getOutputStream() throws IOException {
            return new BlockingCheckOutputStream(super.getOutputStream(), this.channel);
        }
    }

    public SocketChannelImpl(SelectorProvider selectorProvider) throws IOException {
        this(selectorProvider, true);
    }

    public SocketChannelImpl(SelectorProvider selectorProvider, FileDescriptor fileDescriptor) throws IOException {
        super(selectorProvider);
        this.socket = null;
        this.connectAddress = null;
        this.localAddress = null;
        this.status = -1;
        this.isBound = false;
        this.readLock = new Object();
        this.writeLock = new Object();
        this.status = 2;
        this.fd = fileDescriptor;
    }

    public SocketChannelImpl(SelectorProvider selectorProvider, boolean z) throws IOException {
        super(selectorProvider);
        this.socket = null;
        this.connectAddress = null;
        this.localAddress = null;
        this.status = -1;
        this.isBound = false;
        this.readLock = new Object();
        this.writeLock = new Object();
        this.status = 0;
        this.fd = z ? IoBridge.socket(true) : new FileDescriptor();
    }

    private void checkOpenConnected() throws ClosedChannelException {
        synchronized (this) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            if (!isConnected()) {
                throw new NotYetConnectedException();
            }
        }
    }

    private void checkUnconnected() throws IOException {
        synchronized (this) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            if (this.status == 2) {
                throw new AlreadyConnectedException();
            }
            if (this.status == 1) {
                throw new ConnectionPendingException();
            }
        }
    }

    private boolean isEINPROGRESS(IOException iOException) {
        if (!isBlocking() && (iOException instanceof ConnectException)) {
            Throwable cause = iOException.getCause();
            return (cause instanceof ErrnoException) && ((ErrnoException) cause).errno == OsConstants.EINPROGRESS;
        }
        return false;
    }

    private int readImpl(ByteBuffer byteBuffer) throws IOException {
        int recvfrom;
        boolean z = true;
        synchronized (this.readLock) {
            if (isBlocking()) {
                begin();
            }
            recvfrom = IoBridge.recvfrom(true, this.fd, byteBuffer, 0, null, false);
            if (isBlocking()) {
                if (recvfrom <= 0) {
                    z = false;
                }
                end(z);
            }
        }
        return recvfrom;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InetSocketAddress validateAddress(SocketAddress socketAddress) {
        if (socketAddress == null) {
            throw new IllegalArgumentException("socketAddress == null");
        }
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            if (inetSocketAddress.isUnresolved()) {
                throw new UnresolvedAddressException();
            }
            return inetSocketAddress;
        }
        throw new UnsupportedAddressTypeException();
    }

    private int writeImpl(ByteBuffer byteBuffer) throws IOException {
        boolean z = true;
        synchronized (this.writeLock) {
            if (byteBuffer.hasRemaining()) {
                if (isBlocking()) {
                    begin();
                }
                int sendto = IoBridge.sendto(this.fd, byteBuffer, 0, null, 0);
                if (isBlocking()) {
                    if (sendto < 0) {
                        z = false;
                    }
                    end(z);
                }
                return sendto;
            }
            return 0;
        }
    }

    @Override // java.nio.channels.SocketChannel
    public boolean connect(SocketAddress socketAddress) throws IOException {
        boolean z;
        int i;
        checkUnconnected();
        InetSocketAddress validateAddress = validateAddress(socketAddress);
        InetAddress address = validateAddress.getAddress();
        int port = validateAddress.getPort();
        InetAddress inetAddress = address;
        if (address.isAnyLocalAddress()) {
            inetAddress = InetAddress.getLocalHost();
        }
        boolean isBlocking = isBlocking();
        boolean z2 = false;
        try {
            if (isBlocking) {
                z = false;
                try {
                    begin();
                } catch (IOException e) {
                    if (!isEINPROGRESS(e)) {
                        if (isOpen()) {
                            close();
                            z2 = true;
                        }
                        throw e;
                    }
                    i = 1;
                    if (isBlocking) {
                        end(false);
                        i = 1;
                    }
                }
            }
            z = false;
            IoBridge.connect(this.fd, inetAddress, port);
            int i2 = isBlocking ? 2 : 1;
            i = i2;
            if (isBlocking) {
                end(true);
                i = i2;
            }
            if (!this.isBound) {
                onBind(true);
            }
            onConnectStatusChanged(validateAddress, i, true);
            return this.status == 2;
        } catch (Throwable th) {
            if (isBlocking) {
                end(z);
            }
            throw th;
        }
    }

    @Override // java.nio.channels.SocketChannel
    public boolean finishConnect() throws IOException {
        int i = 2;
        synchronized (this) {
            if (isOpen()) {
                if (this.status == 2) {
                    return true;
                }
                if (this.status != 1) {
                    throw new NoConnectionPendingException();
                }
                boolean z = false;
                boolean z2 = false;
                try {
                    try {
                        begin();
                        z2 = false;
                        boolean isConnected = IoBridge.isConnected(this.fd, this.connectAddress.getAddress(), this.connectAddress.getPort(), 0, 0);
                        end(isConnected);
                        synchronized (this) {
                            if (!isConnected) {
                                i = this.status;
                            }
                            this.status = i;
                            if (isConnected && this.socket != null) {
                                this.socket.onConnect(this.connectAddress.getAddress(), this.connectAddress.getPort());
                            }
                        }
                        return isConnected;
                    } catch (ConnectException e) {
                        if (isOpen()) {
                            close();
                            z = true;
                        }
                        z2 = z;
                        throw e;
                    }
                } catch (Throwable th) {
                    end(z2);
                    throw th;
                }
            }
            throw new ClosedChannelException();
        }
    }

    @Override // java.nio.FileDescriptorChannel
    public FileDescriptor getFD() {
        return this.fd;
    }

    @Override // java.nio.channels.spi.AbstractSelectableChannel
    protected void implCloseSelectableChannel() throws IOException {
        synchronized (this) {
            if (this.status != 3) {
                this.status = 3;
                IoBridge.closeAndSignalBlockedThreads(this.fd);
                if (this.socket != null && !this.socket.isClosed()) {
                    this.socket.onClose();
                }
            }
        }
    }

    @Override // java.nio.channels.spi.AbstractSelectableChannel
    protected void implConfigureBlocking(boolean z) throws IOException {
        IoUtils.setBlocking(this.fd, z);
    }

    @Override // java.nio.channels.SocketChannel
    public boolean isConnected() {
        boolean z;
        synchronized (this) {
            z = this.status == 2;
        }
        return z;
    }

    @Override // java.nio.channels.SocketChannel
    public boolean isConnectionPending() {
        boolean z = true;
        synchronized (this) {
            if (this.status != 1) {
                z = false;
            }
        }
        return z;
    }

    public void onAccept(InetSocketAddress inetSocketAddress, boolean z) {
        onBind(z);
        onConnectStatusChanged(inetSocketAddress, 2, z);
    }

    void onBind(boolean z) {
        try {
            SocketAddress socketAddress = Libcore.os.getsockname(this.fd);
            this.isBound = true;
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            this.localAddress = inetSocketAddress.getAddress();
            this.localPort = inetSocketAddress.getPort();
            if (!z || this.socket == null) {
                return;
            }
            this.socket.onBind(this.localAddress, this.localPort);
        } catch (ErrnoException e) {
            throw new AssertionError(e);
        }
    }

    void onConnectStatusChanged(InetSocketAddress inetSocketAddress, int i, boolean z) {
        this.status = i;
        this.connectAddress = inetSocketAddress;
        if (i == 2 && z && this.socket != null) {
            this.socket.onConnect(this.connectAddress.getAddress(), this.connectAddress.getPort());
        }
    }

    @Override // java.nio.channels.SocketChannel, java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        byteBuffer.checkWritable();
        checkOpenConnected();
        if (byteBuffer.hasRemaining()) {
            return readImpl(byteBuffer);
        }
        return 0;
    }

    @Override // java.nio.channels.SocketChannel, java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException {
        Arrays.checkOffsetAndCount(byteBufferArr.length, i, i2);
        checkOpenConnected();
        int calculateTotalRemaining = FileChannelImpl.calculateTotalRemaining(byteBufferArr, i, i2, true);
        if (calculateTotalRemaining == 0) {
            return 0L;
        }
        byte[] bArr = new byte[calculateTotalRemaining];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        int readImpl = readImpl(wrap);
        wrap.flip();
        if (readImpl > 0) {
            int i3 = readImpl;
            int i4 = i;
            while (i3 > 0) {
                int min = Math.min(byteBufferArr[i4].remaining(), i3);
                byteBufferArr[i4].put(bArr, readImpl - i3, min);
                i4++;
                i3 -= min;
            }
        }
        return readImpl;
    }

    @Override // java.nio.channels.SocketChannel
    public Socket socket() {
        SocketAdapter socketAdapter;
        synchronized (this) {
            if (this.socket == null) {
                InetAddress inetAddress = null;
                int i = 0;
                try {
                    if (this.connectAddress != null) {
                        inetAddress = this.connectAddress.getAddress();
                        i = this.connectAddress.getPort();
                    }
                    this.socket = new SocketAdapter(new PlainSocketImpl(this.fd, this.localPort, inetAddress, i), this);
                } catch (SocketException e) {
                    socketAdapter = null;
                }
            }
            socketAdapter = this.socket;
        }
        return socketAdapter;
    }

    @Override // java.nio.channels.SocketChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new NullPointerException("src == null");
        }
        checkOpenConnected();
        if (byteBuffer.hasRemaining()) {
            return writeImpl(byteBuffer);
        }
        return 0;
    }

    @Override // java.nio.channels.SocketChannel, java.nio.channels.GatheringByteChannel
    public long write(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException {
        Arrays.checkOffsetAndCount(byteBufferArr.length, i, i2);
        checkOpenConnected();
        int calculateTotalRemaining = FileChannelImpl.calculateTotalRemaining(byteBufferArr, i, i2, false);
        if (calculateTotalRemaining == 0) {
            return 0L;
        }
        ByteBuffer allocate = ByteBuffer.allocate(calculateTotalRemaining);
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i2 + i) {
                break;
            }
            ByteBuffer byteBuffer = byteBufferArr[i4];
            int position = byteBuffer.position();
            allocate.put(byteBuffer);
            byteBuffer.position(position);
            i3 = i4 + 1;
        }
        allocate.flip();
        int writeImpl = writeImpl(allocate);
        int i5 = i;
        int i6 = writeImpl;
        while (true) {
            int i7 = i6;
            if (i7 <= 0) {
                return writeImpl;
            }
            ByteBuffer byteBuffer2 = byteBufferArr[i5];
            int min = Math.min(i7, byteBuffer2.remaining());
            byteBuffer2.position(byteBuffer2.position() + min);
            i5++;
            i6 = i7 - min;
        }
    }
}
