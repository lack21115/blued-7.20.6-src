package android.net;

import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: source-9557208-dex2jar.jar:android/net/LocalSocket.class */
public class LocalSocket implements Closeable {
    public static final int SOCKET_DGRAM = 1;
    public static final int SOCKET_SEQPACKET = 3;
    public static final int SOCKET_STREAM = 2;
    static final int SOCKET_UNKNOWN = 0;
    private LocalSocketImpl impl;
    private volatile boolean implCreated;
    private boolean isBound;
    private boolean isConnected;
    private LocalSocketAddress localAddress;
    private final int sockType;

    public LocalSocket() {
        this(2);
    }

    public LocalSocket(int i) {
        this(new LocalSocketImpl(), i);
        this.isBound = false;
        this.isConnected = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalSocket(LocalSocketImpl localSocketImpl, int i) {
        this.impl = localSocketImpl;
        this.sockType = i;
        this.isConnected = false;
        this.isBound = false;
    }

    public LocalSocket(FileDescriptor fileDescriptor) throws IOException {
        this(new LocalSocketImpl(fileDescriptor), 0);
        this.isBound = true;
        this.isConnected = true;
    }

    private void implCreateIfNeeded() throws IOException {
        if (this.implCreated) {
            return;
        }
        synchronized (this) {
            if (!this.implCreated) {
                this.impl.create(this.sockType);
                this.implCreated = true;
            }
        }
    }

    public void bind(LocalSocketAddress localSocketAddress) throws IOException {
        implCreateIfNeeded();
        synchronized (this) {
            if (this.isBound) {
                throw new IOException("already bound");
            }
            this.localAddress = localSocketAddress;
            this.impl.bind(this.localAddress);
            this.isBound = true;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        implCreateIfNeeded();
        this.impl.close();
    }

    public void closeExternalFd() throws IOException {
        implCreateIfNeeded();
        this.impl.closeExternalFd();
    }

    public void connect(LocalSocketAddress localSocketAddress) throws IOException {
        synchronized (this) {
            if (this.isConnected) {
                throw new IOException("already connected");
            }
            implCreateIfNeeded();
            this.impl.connect(localSocketAddress, 0);
            this.isConnected = true;
            this.isBound = true;
        }
    }

    public void connect(LocalSocketAddress localSocketAddress, int i) throws IOException {
        throw new UnsupportedOperationException();
    }

    public FileDescriptor[] getAncillaryFileDescriptors() throws IOException {
        return this.impl.getAncillaryFileDescriptors();
    }

    public FileDescriptor getFileDescriptor() {
        return this.impl.getFileDescriptor();
    }

    public InputStream getInputStream() throws IOException {
        implCreateIfNeeded();
        return this.impl.getInputStream();
    }

    public LocalSocketAddress getLocalSocketAddress() {
        return this.localAddress;
    }

    public OutputStream getOutputStream() throws IOException {
        implCreateIfNeeded();
        return this.impl.getOutputStream();
    }

    public Credentials getPeerCredentials() throws IOException {
        return this.impl.getPeerCredentials();
    }

    public int getReceiveBufferSize() throws IOException {
        return ((Integer) this.impl.getOption(4098)).intValue();
    }

    public LocalSocketAddress getRemoteSocketAddress() {
        throw new UnsupportedOperationException();
    }

    public int getSendBufferSize() throws IOException {
        return ((Integer) this.impl.getOption(4097)).intValue();
    }

    public int getSoTimeout() throws IOException {
        return ((Integer) this.impl.getOption(4102)).intValue();
    }

    public boolean isBound() {
        boolean z;
        synchronized (this) {
            z = this.isBound;
        }
        return z;
    }

    public boolean isClosed() {
        throw new UnsupportedOperationException();
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this) {
            z = this.isConnected;
        }
        return z;
    }

    public boolean isInputShutdown() {
        throw new UnsupportedOperationException();
    }

    public boolean isOutputShutdown() {
        throw new UnsupportedOperationException();
    }

    public void setFileDescriptorsForSend(FileDescriptor[] fileDescriptorArr) {
        this.impl.setFileDescriptorsForSend(fileDescriptorArr);
    }

    public void setReceiveBufferSize(int i) throws IOException {
        this.impl.setOption(4098, Integer.valueOf(i));
    }

    public void setSendBufferSize(int i) throws IOException {
        this.impl.setOption(4097, Integer.valueOf(i));
    }

    public void setSoTimeout(int i) throws IOException {
        this.impl.setOption(4102, Integer.valueOf(i));
    }

    public void shutdownInput() throws IOException {
        implCreateIfNeeded();
        this.impl.shutdownInput();
    }

    public void shutdownOutput() throws IOException {
        implCreateIfNeeded();
        this.impl.shutdownOutput();
    }

    public String toString() {
        return super.toString() + " impl:" + this.impl;
    }
}
