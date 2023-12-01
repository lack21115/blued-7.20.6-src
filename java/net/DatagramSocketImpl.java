package java.net;

import java.io.FileDescriptor;
import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:java/net/DatagramSocketImpl.class */
public abstract class DatagramSocketImpl implements SocketOptions {
    protected FileDescriptor fd;
    protected int localPort = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bind(int i, InetAddress inetAddress) throws SocketException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void close();

    /* JADX INFO: Access modifiers changed from: protected */
    public void connect(InetAddress inetAddress, int i) throws SocketException {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void create() throws SocketException;

    /* JADX INFO: Access modifiers changed from: protected */
    public void disconnect() {
    }

    protected FileDescriptor getFileDescriptor() {
        return this.fd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getLocalPort() {
        return this.localPort;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public abstract byte getTTL() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getTimeToLive() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void join(InetAddress inetAddress) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void joinGroup(SocketAddress socketAddress, NetworkInterface networkInterface) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void leave(InetAddress inetAddress) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void leaveGroup(SocketAddress socketAddress, NetworkInterface networkInterface) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public void onBind(InetAddress inetAddress, int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onClose() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onConnect(InetAddress inetAddress, int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDisconnect() {
    }

    protected abstract int peek(InetAddress inetAddress) throws IOException;

    protected abstract int peekData(DatagramPacket datagramPacket) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void receive(DatagramPacket datagramPacket) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void send(DatagramPacket datagramPacket) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public abstract void setTTL(byte b) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setTimeToLive(int i) throws IOException;
}
