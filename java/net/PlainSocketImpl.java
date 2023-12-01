package java.net;

import android.system.ErrnoException;
import android.system.OsConstants;
import dalvik.system.CloseGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.nio.ByteOrder;
import java.util.Arrays;
import libcore.io.IoBridge;
import libcore.io.Libcore;
import libcore.io.Memory;
import libcore.io.Streams;

/* loaded from: source-2895416-dex2jar.jar:java/net/PlainSocketImpl.class */
public class PlainSocketImpl extends SocketImpl {
    private static InetAddress lastConnectedAddress;
    private static int lastConnectedPort;
    private final CloseGuard guard;
    private Proxy proxy;
    private boolean shutdownInput;
    private boolean streaming;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/net/PlainSocketImpl$PlainSocketInputStream.class */
    public static class PlainSocketInputStream extends InputStream {
        private final PlainSocketImpl socketImpl;

        public PlainSocketInputStream(PlainSocketImpl plainSocketImpl) {
            this.socketImpl = plainSocketImpl;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.socketImpl.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.socketImpl.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            return Streams.readSingleByte(this);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            return this.socketImpl.read(bArr, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/net/PlainSocketImpl$PlainSocketOutputStream.class */
    public static class PlainSocketOutputStream extends OutputStream {
        private final PlainSocketImpl socketImpl;

        public PlainSocketOutputStream(PlainSocketImpl plainSocketImpl) {
            this.socketImpl = plainSocketImpl;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.socketImpl.close();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            Streams.writeSingleByte(this, i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.socketImpl.write(bArr, i, i2);
        }
    }

    public PlainSocketImpl() {
        this(new FileDescriptor());
    }

    public PlainSocketImpl(FileDescriptor fileDescriptor) {
        this.streaming = true;
        this.guard = CloseGuard.get();
        this.fd = fileDescriptor;
        if (fileDescriptor.valid()) {
            this.guard.open("close");
        }
    }

    public PlainSocketImpl(FileDescriptor fileDescriptor, int i, InetAddress inetAddress, int i2) {
        this.streaming = true;
        this.guard = CloseGuard.get();
        this.fd = fileDescriptor;
        this.localport = i;
        this.address = inetAddress;
        this.port = i2;
        if (fileDescriptor.valid()) {
            this.guard.open("close");
        }
    }

    public PlainSocketImpl(Proxy proxy) {
        this(new FileDescriptor());
        this.proxy = proxy;
    }

    private void checkNotClosed() throws IOException {
        if (!this.fd.valid()) {
            throw new SocketException("Socket is closed");
        }
    }

    private void connect(InetAddress inetAddress, int i, int i2) throws IOException {
        InetAddress localHost = inetAddress.isAnyLocalAddress() ? InetAddress.getLocalHost() : inetAddress;
        if (this.streaming && usingSocks()) {
            socksConnect(inetAddress, i, 0);
        } else {
            IoBridge.connect(this.fd, localHost, i, i2);
        }
        this.address = localHost;
        this.port = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        if (this.shutdownInput) {
            return -1;
        }
        int recvfrom = IoBridge.recvfrom(true, this.fd, bArr, i, i2, 0, null, false);
        if (recvfrom == 0) {
            throw new SocketTimeoutException();
        }
        if (recvfrom == -1) {
            this.shutdownInput = true;
        }
        return recvfrom;
    }

    private void socksBind() throws IOException {
        try {
            IoBridge.connect(this.fd, socksGetServerAddress(), socksGetServerPort());
            if (lastConnectedAddress == null) {
                throw new SocketException("Invalid SOCKS client");
            }
            socksSendRequest(2, lastConnectedAddress, lastConnectedPort);
            Socks4Message socksReadReply = socksReadReply();
            if (socksReadReply.getCommandOrResult() != 90) {
                throw new IOException(socksReadReply.getErrorString(socksReadReply.getCommandOrResult()));
            }
            if (socksReadReply.getIP() == 0) {
                this.address = socksGetServerAddress();
            } else {
                byte[] bArr = new byte[4];
                Memory.pokeInt(bArr, 0, socksReadReply.getIP(), ByteOrder.BIG_ENDIAN);
                this.address = InetAddress.getByAddress(bArr);
            }
            this.localport = socksReadReply.getPort();
        } catch (Exception e) {
            throw new IOException("Unable to connect to SOCKS server", e);
        }
    }

    private void socksConnect(InetAddress inetAddress, int i, int i2) throws IOException {
        try {
            IoBridge.connect(this.fd, socksGetServerAddress(), socksGetServerPort(), i2);
            socksRequestConnection(inetAddress, i);
            lastConnectedAddress = inetAddress;
            lastConnectedPort = i;
        } catch (Exception e) {
            throw new SocketException("SOCKS connection failed", e);
        }
    }

    private InetAddress socksGetServerAddress() throws UnknownHostException {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) this.proxy.address();
        String hostName = inetSocketAddress.getHostName();
        String str = hostName;
        if (hostName == null) {
            str = inetSocketAddress.getAddress().getHostAddress();
        }
        return InetAddress.getByName(str);
    }

    private int socksGetServerPort() {
        return ((InetSocketAddress) this.proxy.address()).getPort();
    }

    private Socks4Message socksReadReply() throws IOException {
        int i;
        int read;
        Socks4Message socks4Message = new Socks4Message();
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= 8 || (read = getInputStream().read(socks4Message.getBytes(), i, 8 - i)) == -1) {
                break;
            }
            i2 = i + read;
        }
        if (8 != i) {
            throw new SocketException("Malformed reply from SOCKS server");
        }
        return socks4Message;
    }

    private void socksRequestConnection(InetAddress inetAddress, int i) throws IOException {
        socksSendRequest(1, inetAddress, i);
        Socks4Message socksReadReply = socksReadReply();
        if (socksReadReply.getCommandOrResult() != 90) {
            throw new IOException(socksReadReply.getErrorString(socksReadReply.getCommandOrResult()));
        }
    }

    private void socksSendRequest(int i, InetAddress inetAddress, int i2) throws IOException {
        Socks4Message socks4Message = new Socks4Message();
        socks4Message.setCommandOrResult(i);
        socks4Message.setPort(i2);
        socks4Message.setIP(inetAddress.getAddress());
        socks4Message.setUserId("default");
        getOutputStream().write(socks4Message.getBytes(), 0, socks4Message.getLength());
    }

    private boolean usingSocks() {
        return this.proxy != null && this.proxy.type() == Proxy.Type.SOCKS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void write(byte[] bArr, int i, int i2) throws IOException {
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        if (!this.streaming) {
            IoBridge.sendto(this.fd, bArr, i, i2, 0, this.address, this.port);
            return;
        }
        while (i2 > 0) {
            int sendto = IoBridge.sendto(this.fd, bArr, i, i2, 0, null, 0);
            i2 -= sendto;
            i += sendto;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public void accept(SocketImpl socketImpl) throws IOException {
        if (usingSocks()) {
            ((PlainSocketImpl) socketImpl).socksBind();
            ((PlainSocketImpl) socketImpl).socksAccept();
            return;
        }
        try {
            InetSocketAddress inetSocketAddress = new InetSocketAddress();
            socketImpl.fd.setInt$(Libcore.os.accept(this.fd, inetSocketAddress).getInt$());
            socketImpl.address = inetSocketAddress.getAddress();
            socketImpl.port = inetSocketAddress.getPort();
            socketImpl.setOption(4102, 0);
            socketImpl.localport = IoBridge.getSocketLocalPort(socketImpl.fd);
        } catch (ErrnoException e) {
            if (e.errno != OsConstants.EAGAIN) {
                throw e.rethrowAsSocketException();
            }
            throw new SocketTimeoutException(e);
        }
    }

    @Override // java.net.SocketImpl
    protected int available() throws IOException {
        int available;
        synchronized (this) {
            checkNotClosed();
            available = this.shutdownInput ? 0 : IoBridge.available(this.fd);
        }
        return available;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public void bind(InetAddress inetAddress, int i) throws IOException {
        IoBridge.bind(this.fd, inetAddress, i);
        if (i != 0) {
            this.localport = i;
        } else {
            this.localport = IoBridge.getSocketLocalPort(this.fd);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public void close() throws IOException {
        synchronized (this) {
            this.guard.close();
            IoBridge.closeAndSignalBlockedThreads(this.fd);
        }
    }

    @Override // java.net.SocketImpl
    protected void connect(String str, int i) throws IOException {
        connect(InetAddress.getByName(str), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public void connect(InetAddress inetAddress, int i) throws IOException {
        connect(inetAddress, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public void connect(SocketAddress socketAddress, int i) throws IOException {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
        connect(inetSocketAddress.getAddress(), inetSocketAddress.getPort(), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public void create(boolean z) throws IOException {
        this.streaming = z;
        this.fd = IoBridge.socket(z);
    }

    protected void finalize() throws Throwable {
        try {
            if (this.guard != null) {
                this.guard.warnIfOpen();
            }
            close();
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public InputStream getInputStream() throws IOException {
        PlainSocketInputStream plainSocketInputStream;
        synchronized (this) {
            checkNotClosed();
            plainSocketInputStream = new PlainSocketInputStream(this);
        }
        return plainSocketInputStream;
    }

    @Override // java.net.SocketOptions
    public Object getOption(int i) throws SocketException {
        return IoBridge.getSocketOption(this.fd, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public OutputStream getOutputStream() throws IOException {
        PlainSocketOutputStream plainSocketOutputStream;
        synchronized (this) {
            checkNotClosed();
            plainSocketOutputStream = new PlainSocketOutputStream(this);
        }
        return plainSocketOutputStream;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public void listen(int i) throws IOException {
        if (usingSocks()) {
            return;
        }
        try {
            Libcore.os.listen(this.fd, i);
        } catch (ErrnoException e) {
            throw e.rethrowAsSocketException();
        }
    }

    @Override // java.net.SocketImpl
    public void onBind(InetAddress inetAddress, int i) {
        this.localport = i;
    }

    @Override // java.net.SocketImpl
    public void onClose() {
        this.guard.close();
    }

    @Override // java.net.SocketImpl
    public void onConnect(InetAddress inetAddress, int i) {
        this.address = inetAddress;
        this.port = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public void sendUrgentData(int i) throws IOException {
        try {
            Libcore.os.sendto(this.fd, new byte[]{(byte) i}, 0, 1, OsConstants.MSG_OOB, null, 0);
        } catch (ErrnoException e) {
            throw e.rethrowAsSocketException();
        }
    }

    @Override // java.net.SocketOptions
    public void setOption(int i, Object obj) throws SocketException {
        IoBridge.setSocketOption(this.fd, i, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public void shutdownInput() throws IOException {
        this.shutdownInput = true;
        try {
            Libcore.os.shutdown(this.fd, OsConstants.SHUT_RD);
        } catch (ErrnoException e) {
            throw e.rethrowAsSocketException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public void shutdownOutput() throws IOException {
        try {
            Libcore.os.shutdown(this.fd, OsConstants.SHUT_WR);
        } catch (ErrnoException e) {
            throw e.rethrowAsSocketException();
        }
    }

    public void socksAccept() throws IOException {
        Socks4Message socksReadReply = socksReadReply();
        if (socksReadReply.getCommandOrResult() != 90) {
            throw new IOException(socksReadReply.getErrorString(socksReadReply.getCommandOrResult()));
        }
    }

    @Override // java.net.SocketImpl
    protected boolean supportsUrgentData() {
        return true;
    }
}
