package java.net;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: source-2895416-dex2jar.jar:java/net/SocketImpl.class */
public abstract class SocketImpl implements SocketOptions {
    protected InetAddress address;
    protected FileDescriptor fd;
    protected int localport;
    protected int port;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void accept(SocketImpl socketImpl) throws IOException;

    protected abstract int available() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bind(InetAddress inetAddress, int i) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void close() throws IOException;

    protected abstract void connect(String str, int i) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void connect(InetAddress inetAddress, int i) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void connect(SocketAddress socketAddress, int i) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void create(boolean z) throws IOException;

    public FileDescriptor getFD$() {
        return this.fd;
    }

    protected FileDescriptor getFileDescriptor() {
        return this.fd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public InetAddress getInetAddress() {
        return this.address;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract InputStream getInputStream() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public int getLocalPort() {
        return this.localport;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract OutputStream getOutputStream() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public int getPort() {
        return this.port;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void listen(int i) throws IOException;

    public void onBind(InetAddress inetAddress, int i) {
    }

    public void onClose() {
    }

    public void onConnect(InetAddress inetAddress, int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void sendUrgentData(int i) throws IOException;

    protected void setPerformancePreferences(int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void shutdownInput() throws IOException {
        throw new IOException("Method has not been implemented");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void shutdownOutput() throws IOException {
        throw new IOException("Method has not been implemented");
    }

    protected boolean supportsUrgentData() {
        return false;
    }

    public String toString() {
        return "Socket[address=" + getInetAddress() + ",port=" + this.port + ",localPort=" + getLocalPort() + "]";
    }
}
