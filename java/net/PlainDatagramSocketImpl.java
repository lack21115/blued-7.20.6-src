package java.net;

import android.system.ErrnoException;
import android.system.OsConstants;
import android.system.StructGroupReq;
import com.blued.android.module.common.web.LoaderConstants;
import dalvik.system.CloseGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import libcore.io.IoBridge;
import libcore.io.Libcore;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/net/PlainDatagramSocketImpl.class */
public class PlainDatagramSocketImpl extends DatagramSocketImpl {
    private InetAddress connectedAddress;
    private volatile boolean isNativeConnected;
    private final CloseGuard guard = CloseGuard.get();
    private int connectedPort = -1;

    public PlainDatagramSocketImpl() {
        this.fd = new FileDescriptor();
    }

    public PlainDatagramSocketImpl(FileDescriptor fileDescriptor, int i) {
        this.fd = fileDescriptor;
        this.localPort = i;
        if (fileDescriptor.valid()) {
            this.guard.open(LoaderConstants.CLOSE);
        }
    }

    private void doRecv(DatagramPacket datagramPacket, int i) throws IOException {
        IoBridge.recvfrom(false, this.fd, datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), i, datagramPacket, this.isNativeConnected);
        if (this.isNativeConnected) {
            updatePacketRecvAddress(datagramPacket);
        }
    }

    private static StructGroupReq makeGroupReq(InetAddress inetAddress, NetworkInterface networkInterface) {
        return new StructGroupReq(networkInterface != null ? networkInterface.getIndex() : 0, inetAddress);
    }

    private void updatePacketRecvAddress(DatagramPacket datagramPacket) {
        datagramPacket.setAddress(this.connectedAddress);
        datagramPacket.setPort(this.connectedPort);
    }

    @Override // java.net.DatagramSocketImpl
    public void bind(int i, InetAddress inetAddress) throws SocketException {
        IoBridge.bind(this.fd, inetAddress, i);
        if (i != 0) {
            this.localPort = i;
        } else {
            this.localPort = IoBridge.getSocketLocalPort(this.fd);
        }
        try {
            setOption(32, Boolean.TRUE);
        } catch (IOException e) {
        }
    }

    @Override // java.net.DatagramSocketImpl
    public void close() {
        synchronized (this) {
            this.guard.close();
            try {
                IoBridge.closeAndSignalBlockedThreads(this.fd);
            } catch (IOException e) {
            }
        }
    }

    @Override // java.net.DatagramSocketImpl
    public void connect(InetAddress inetAddress, int i) throws SocketException {
        IoBridge.connect(this.fd, inetAddress, i);
        try {
            this.connectedAddress = InetAddress.getByAddress(inetAddress.getAddress());
            this.connectedPort = i;
            this.isNativeConnected = true;
        } catch (UnknownHostException e) {
            throw new SocketException("Host is unresolved: " + inetAddress.getHostName());
        }
    }

    @Override // java.net.DatagramSocketImpl
    public void create() throws SocketException {
        this.fd = IoBridge.socket(false);
    }

    @Override // java.net.DatagramSocketImpl
    public void disconnect() {
        try {
            Libcore.os.connect(this.fd, InetAddress.UNSPECIFIED, 0);
        } catch (ErrnoException e) {
            throw new AssertionError(e);
        } catch (SocketException e2) {
        }
        this.connectedPort = -1;
        this.connectedAddress = null;
        this.isNativeConnected = false;
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

    @Override // java.net.SocketOptions
    public Object getOption(int i) throws SocketException {
        return IoBridge.getSocketOption(this.fd, i);
    }

    @Override // java.net.DatagramSocketImpl
    public byte getTTL() throws IOException {
        return (byte) getTimeToLive();
    }

    @Override // java.net.DatagramSocketImpl
    public int getTimeToLive() throws IOException {
        return ((Integer) getOption(17)).intValue();
    }

    @Override // java.net.DatagramSocketImpl
    public void join(InetAddress inetAddress) throws IOException {
        setOption(19, makeGroupReq(inetAddress, null));
    }

    @Override // java.net.DatagramSocketImpl
    public void joinGroup(SocketAddress socketAddress, NetworkInterface networkInterface) throws IOException {
        if (socketAddress instanceof InetSocketAddress) {
            setOption(19, makeGroupReq(((InetSocketAddress) socketAddress).getAddress(), networkInterface));
        }
    }

    @Override // java.net.DatagramSocketImpl
    public void leave(InetAddress inetAddress) throws IOException {
        setOption(20, makeGroupReq(inetAddress, null));
    }

    @Override // java.net.DatagramSocketImpl
    public void leaveGroup(SocketAddress socketAddress, NetworkInterface networkInterface) throws IOException {
        if (socketAddress instanceof InetSocketAddress) {
            setOption(20, makeGroupReq(((InetSocketAddress) socketAddress).getAddress(), networkInterface));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    public void onBind(InetAddress inetAddress, int i) {
        this.localPort = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    public void onClose() {
        this.guard.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    public void onConnect(InetAddress inetAddress, int i) {
        this.isNativeConnected = true;
        this.connectedAddress = inetAddress;
        this.connectedPort = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    public void onDisconnect() {
        this.connectedPort = -1;
        this.connectedAddress = null;
        this.isNativeConnected = false;
    }

    @Override // java.net.DatagramSocketImpl
    protected int peek(InetAddress inetAddress) throws IOException {
        DatagramPacket datagramPacket = new DatagramPacket(EmptyArray.BYTE, 0);
        int peekData = peekData(datagramPacket);
        inetAddress.ipaddress = datagramPacket.getAddress().getAddress();
        return peekData;
    }

    @Override // java.net.DatagramSocketImpl
    public int peekData(DatagramPacket datagramPacket) throws IOException {
        doRecv(datagramPacket, OsConstants.MSG_PEEK);
        return datagramPacket.getPort();
    }

    @Override // java.net.DatagramSocketImpl
    public void receive(DatagramPacket datagramPacket) throws IOException {
        doRecv(datagramPacket, 0);
    }

    @Override // java.net.DatagramSocketImpl
    public void send(DatagramPacket datagramPacket) throws IOException {
        IoBridge.sendto(this.fd, datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), 0, this.isNativeConnected ? null : datagramPacket.getAddress(), this.isNativeConnected ? 0 : datagramPacket.getPort());
    }

    @Override // java.net.SocketOptions
    public void setOption(int i, Object obj) throws SocketException {
        IoBridge.setSocketOption(this.fd, i, obj);
    }

    @Override // java.net.DatagramSocketImpl
    public void setTTL(byte b) throws IOException {
        setTimeToLive(b & 255);
    }

    @Override // java.net.DatagramSocketImpl
    public void setTimeToLive(int i) throws IOException {
        setOption(17, Integer.valueOf(i));
    }
}
