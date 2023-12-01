package java.nio;

import android.system.ErrnoException;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.DatagramSocketImpl;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PlainDatagramSocketImpl;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.spi.SelectorProvider;
import java.util.Arrays;
import libcore.io.IoBridge;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import libcore.util.EmptyArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/nio/DatagramChannelImpl.class */
public class DatagramChannelImpl extends DatagramChannel implements FileDescriptorChannel {
    InetSocketAddress connectAddress;
    boolean connected;
    private final FileDescriptor fd;
    boolean isBound;
    InetAddress localAddress;
    private int localPort;
    private final Object readLock;
    private DatagramSocket socket;
    private final Object writeLock;

    /* loaded from: source-2895416-dex2jar.jar:java/nio/DatagramChannelImpl$DatagramSocketAdapter.class */
    private static class DatagramSocketAdapter extends DatagramSocket {
        private final DatagramChannelImpl channelImpl;

        DatagramSocketAdapter(DatagramSocketImpl datagramSocketImpl, DatagramChannelImpl datagramChannelImpl) {
            super(datagramSocketImpl);
            this.channelImpl = datagramChannelImpl;
            if (datagramChannelImpl.isBound) {
                onBind(datagramChannelImpl.localAddress, datagramChannelImpl.localPort);
            }
            if (datagramChannelImpl.connected) {
                onConnect(datagramChannelImpl.connectAddress.getAddress(), datagramChannelImpl.connectAddress.getPort());
            } else {
                onDisconnect();
            }
            if (datagramChannelImpl.isOpen()) {
                return;
            }
            onClose();
        }

        @Override // java.net.DatagramSocket
        public void bind(SocketAddress socketAddress) throws SocketException {
            if (this.channelImpl.isConnected()) {
                throw new AlreadyConnectedException();
            }
            super.bind(socketAddress);
            this.channelImpl.onBind(false);
        }

        @Override // java.net.DatagramSocket, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (this.channelImpl) {
                super.close();
                if (this.channelImpl.isOpen()) {
                    try {
                        this.channelImpl.close();
                    } catch (IOException e) {
                    }
                }
            }
        }

        @Override // java.net.DatagramSocket
        public void connect(InetAddress inetAddress, int i) {
            try {
                connect(new InetSocketAddress(inetAddress, i));
            } catch (SocketException e) {
            }
        }

        @Override // java.net.DatagramSocket
        public void connect(SocketAddress socketAddress) throws SocketException {
            if (isConnected()) {
                throw new IllegalStateException("Socket is already connected.");
            }
            super.connect(socketAddress);
            this.channelImpl.onBind(false);
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            this.channelImpl.onConnect(inetSocketAddress.getAddress(), inetSocketAddress.getPort(), false);
        }

        @Override // java.net.DatagramSocket
        public void disconnect() {
            super.disconnect();
            this.channelImpl.onDisconnect(false);
        }

        @Override // java.net.DatagramSocket
        public DatagramChannel getChannel() {
            return this.channelImpl;
        }

        @Override // java.net.DatagramSocket
        public void receive(DatagramPacket datagramPacket) throws IOException {
            if (!this.channelImpl.isBlocking()) {
                throw new IllegalBlockingModeException();
            }
            boolean isBound = isBound();
            super.receive(datagramPacket);
            if (isBound) {
                return;
            }
            this.channelImpl.onBind(false);
        }

        @Override // java.net.DatagramSocket
        public void send(DatagramPacket datagramPacket) throws IOException {
            if (!this.channelImpl.isBlocking()) {
                throw new IllegalBlockingModeException();
            }
            boolean isBound = isBound();
            super.send(datagramPacket);
            if (isBound) {
                return;
            }
            this.channelImpl.onBind(false);
        }
    }

    private DatagramChannelImpl() {
        super(SelectorProvider.provider());
        this.connected = false;
        this.isBound = false;
        this.readLock = new Object();
        this.writeLock = new Object();
        this.fd = new FileDescriptor();
        this.connectAddress = new InetSocketAddress(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DatagramChannelImpl(SelectorProvider selectorProvider) throws IOException {
        super(selectorProvider);
        this.connected = false;
        this.isBound = false;
        this.readLock = new Object();
        this.writeLock = new Object();
        this.fd = IoBridge.socket(false);
    }

    private void checkNotNull(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new NullPointerException("source == null");
        }
    }

    private void checkOpen() throws ClosedChannelException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
    }

    private void checkOpenConnected() throws IOException {
        checkOpen();
        if (!isConnected()) {
            throw new NotYetConnectedException();
        }
    }

    private int readImpl(ByteBuffer byteBuffer) throws IOException {
        int recvfrom;
        boolean z = true;
        synchronized (this.readLock) {
            try {
                begin();
                recvfrom = IoBridge.recvfrom(false, this.fd, byteBuffer, 0, null, isConnected());
                if (recvfrom <= 0) {
                    z = false;
                }
                end(z);
            } catch (InterruptedIOException e) {
                end(0 > 0);
                return 0;
            }
        }
        return recvfrom;
    }

    private SocketAddress receiveDirectImpl(ByteBuffer byteBuffer, boolean z) throws IOException {
        DatagramPacket datagramPacket = new DatagramPacket(EmptyArray.BYTE, 0);
        do {
            IoBridge.recvfrom(false, this.fd, byteBuffer, 0, datagramPacket, isConnected());
            if (datagramPacket.getAddress() != null) {
                return datagramPacket.getSocketAddress();
            }
        } while (z);
        return null;
    }

    private SocketAddress receiveImpl(ByteBuffer byteBuffer, boolean z) throws IOException {
        int position = byteBuffer.position();
        DatagramPacket datagramPacket = byteBuffer.hasArray() ? new DatagramPacket(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining()) : new DatagramPacket(new byte[byteBuffer.remaining()], byteBuffer.remaining());
        do {
            int recvfrom = IoBridge.recvfrom(false, this.fd, datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), 0, datagramPacket, isConnected());
            if (datagramPacket.getAddress() != null) {
                if (recvfrom > 0) {
                    if (byteBuffer.hasArray()) {
                        byteBuffer.position(position + recvfrom);
                    } else {
                        byteBuffer.put(datagramPacket.getData(), 0, recvfrom);
                    }
                }
                return datagramPacket.getSocketAddress();
            }
        } while (z);
        return null;
    }

    private int writeImpl(ByteBuffer byteBuffer) throws IOException {
        int sendto;
        boolean z = true;
        synchronized (this.writeLock) {
            begin();
            sendto = IoBridge.sendto(this.fd, byteBuffer, 0, null, 0);
            if (sendto <= 0) {
                z = false;
            }
            end(z);
        }
        return sendto;
    }

    @Override // java.nio.channels.DatagramChannel
    public DatagramChannel connect(SocketAddress socketAddress) throws IOException {
        synchronized (this) {
            checkOpen();
            if (this.connected) {
                throw new IllegalStateException();
            }
            InetSocketAddress validateAddress = SocketChannelImpl.validateAddress(socketAddress);
            InetAddress address = validateAddress.getAddress();
            int port = validateAddress.getPort();
            try {
                begin();
                IoBridge.connect(this.fd, address, port);
                end(true);
            } catch (ConnectException e) {
                end(true);
            }
            if (!this.isBound) {
                onBind(true);
            }
            onConnect(address, port, true);
        }
        return this;
    }

    @Override // java.nio.channels.DatagramChannel
    public DatagramChannel disconnect() throws IOException {
        synchronized (this) {
            if (isConnected() && isOpen()) {
                onDisconnect(true);
                try {
                    Libcore.os.connect(this.fd, InetAddress.UNSPECIFIED, 0);
                } catch (ErrnoException e) {
                    throw e.rethrowAsIOException();
                }
            }
        }
        return this;
    }

    @Override // java.nio.FileDescriptorChannel
    public FileDescriptor getFD() {
        return this.fd;
    }

    @Override // java.nio.channels.spi.AbstractSelectableChannel
    protected void implCloseSelectableChannel() throws IOException {
        synchronized (this) {
            onDisconnect(true);
            IoBridge.closeAndSignalBlockedThreads(this.fd);
            if (this.socket != null && !this.socket.isClosed()) {
                this.socket.onClose();
            }
        }
    }

    @Override // java.nio.channels.spi.AbstractSelectableChannel
    protected void implConfigureBlocking(boolean z) throws IOException {
        IoUtils.setBlocking(this.fd, z);
    }

    @Override // java.nio.channels.DatagramChannel
    public boolean isConnected() {
        boolean z;
        synchronized (this) {
            z = this.connected;
        }
        return z;
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

    void onConnect(InetAddress inetAddress, int i, boolean z) {
        this.connected = true;
        this.connectAddress = new InetSocketAddress(inetAddress, i);
        if (!z || this.socket == null) {
            return;
        }
        this.socket.onConnect(inetAddress, i);
    }

    void onDisconnect(boolean z) {
        this.connected = false;
        this.connectAddress = null;
        if (z && this.socket != null && this.socket.isConnected()) {
            this.socket.onDisconnect();
        }
    }

    @Override // java.nio.channels.DatagramChannel, java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        int i;
        byteBuffer.checkWritable();
        checkOpenConnected();
        if (!byteBuffer.hasRemaining()) {
            i = 0;
        } else if (byteBuffer.isDirect() || byteBuffer.hasArray()) {
            return readImpl(byteBuffer);
        } else {
            byte[] bArr = new byte[byteBuffer.remaining()];
            int readImpl = readImpl(ByteBuffer.wrap(bArr));
            i = readImpl;
            if (readImpl > 0) {
                byteBuffer.put(bArr, 0, readImpl);
                return readImpl;
            }
        }
        return i;
    }

    @Override // java.nio.channels.DatagramChannel, java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException {
        Arrays.checkOffsetAndCount(byteBufferArr.length, i, i2);
        checkOpenConnected();
        int calculateTotalRemaining = FileChannelImpl.calculateTotalRemaining(byteBufferArr, i, i2, true);
        if (calculateTotalRemaining == 0) {
            return 0L;
        }
        ByteBuffer allocate = ByteBuffer.allocate(calculateTotalRemaining);
        int readImpl = readImpl(allocate);
        byte[] array = allocate.array();
        int i3 = readImpl;
        int i4 = i;
        while (i3 > 0) {
            int min = Math.min(byteBufferArr[i4].remaining(), i3);
            byteBufferArr[i4].put(array, readImpl - i3, min);
            i4++;
            i3 -= min;
        }
        return readImpl;
    }

    @Override // java.nio.channels.DatagramChannel
    public SocketAddress receive(ByteBuffer byteBuffer) throws IOException {
        SocketAddress receiveImpl;
        boolean z = true;
        byteBuffer.checkWritable();
        checkOpen();
        if (this.isBound) {
            boolean z2 = false;
            SocketAddress socketAddress = null;
            try {
                begin();
                z2 = false;
                synchronized (this.readLock) {
                    boolean isBlocking = isBlocking();
                    receiveImpl = !byteBuffer.isDirect() ? receiveImpl(byteBuffer, isBlocking) : receiveDirectImpl(byteBuffer, isBlocking);
                    socketAddress = receiveImpl;
                }
                if (receiveImpl == null) {
                    z = false;
                }
                end(z);
                return receiveImpl;
            } catch (InterruptedIOException e) {
                end(z2);
                return null;
            } catch (Throwable th) {
                end(socketAddress != null);
                throw th;
            }
        }
        return null;
    }

    @Override // java.nio.channels.DatagramChannel
    public int send(ByteBuffer byteBuffer, SocketAddress socketAddress) throws IOException {
        int sendto;
        boolean z = true;
        checkNotNull(byteBuffer);
        checkOpen();
        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
        if (inetSocketAddress.getAddress() == null) {
            throw new IOException();
        }
        if (!isConnected() || this.connectAddress.equals(inetSocketAddress)) {
            synchronized (this.writeLock) {
                begin();
                sendto = IoBridge.sendto(this.fd, byteBuffer, 0, inetSocketAddress.getAddress(), inetSocketAddress.getPort());
                if (!this.isBound) {
                    onBind(true);
                }
                if (sendto < 0) {
                    z = false;
                }
                end(z);
            }
            return sendto;
        }
        throw new IllegalArgumentException("Connected to " + this.connectAddress + ", not " + socketAddress);
    }

    @Override // java.nio.channels.DatagramChannel
    public DatagramSocket socket() {
        DatagramSocket datagramSocket;
        synchronized (this) {
            if (this.socket == null) {
                this.socket = new DatagramSocketAdapter(new PlainDatagramSocketImpl(this.fd, this.localPort), this);
            }
            datagramSocket = this.socket;
        }
        return datagramSocket;
    }

    @Override // java.nio.channels.DatagramChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        checkNotNull(byteBuffer);
        checkOpenConnected();
        if (byteBuffer.hasRemaining()) {
            return writeImpl(byteBuffer);
        }
        return 0;
    }

    @Override // java.nio.channels.DatagramChannel, java.nio.channels.GatheringByteChannel
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
