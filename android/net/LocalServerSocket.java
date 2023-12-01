package android.net;

import java.io.FileDescriptor;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/net/LocalServerSocket.class */
public class LocalServerSocket {
    private static final int LISTEN_BACKLOG = 50;
    private final LocalSocketImpl impl;
    private final LocalSocketAddress localAddress;

    public LocalServerSocket(FileDescriptor fileDescriptor) throws IOException {
        this.impl = new LocalSocketImpl(fileDescriptor);
        this.impl.listen(50);
        this.localAddress = this.impl.getSockAddress();
    }

    public LocalServerSocket(String str) throws IOException {
        this.impl = new LocalSocketImpl();
        this.impl.create(2);
        this.localAddress = new LocalSocketAddress(str);
        this.impl.bind(this.localAddress);
        this.impl.listen(50);
    }

    public LocalSocket accept() throws IOException {
        LocalSocketImpl localSocketImpl = new LocalSocketImpl();
        this.impl.accept(localSocketImpl);
        return new LocalSocket(localSocketImpl, 0);
    }

    public void close() throws IOException {
        this.impl.close();
    }

    public FileDescriptor getFileDescriptor() {
        return this.impl.getFileDescriptor();
    }

    public LocalSocketAddress getLocalSocketAddress() {
        return this.localAddress;
    }
}
