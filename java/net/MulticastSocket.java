package java.net;

import java.io.IOException;
import java.util.Enumeration;

/* loaded from: source-2895416-dex2jar.jar:java/net/MulticastSocket.class */
public class MulticastSocket extends DatagramSocket {
    private InetAddress setAddress;

    public MulticastSocket() throws IOException {
        setReuseAddress(true);
    }

    public MulticastSocket(int i) throws IOException {
        super(i);
        setReuseAddress(true);
    }

    public MulticastSocket(SocketAddress socketAddress) throws IOException {
        super(socketAddress);
        setReuseAddress(true);
    }

    private void checkJoinOrLeave(InetAddress inetAddress) throws IOException {
        checkOpen();
        if (inetAddress == null) {
            throw new IllegalArgumentException("groupAddress == null");
        }
        if (!inetAddress.isMulticastAddress()) {
            throw new IOException("Not a multicast group: " + inetAddress);
        }
    }

    private void checkJoinOrLeave(SocketAddress socketAddress, NetworkInterface networkInterface) throws IOException {
        checkOpen();
        if (socketAddress == null) {
            throw new IllegalArgumentException("groupAddress == null");
        }
        if (networkInterface != null && !networkInterface.getInetAddresses().hasMoreElements()) {
            throw new SocketException("No address associated with interface: " + networkInterface);
        }
        if (!(socketAddress instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Group address not an InetSocketAddress: " + socketAddress.getClass());
        }
        InetAddress address = ((InetSocketAddress) socketAddress).getAddress();
        if (address == null) {
            throw new SocketException("Group address has no address: " + socketAddress);
        }
        if (!address.isMulticastAddress()) {
            throw new IOException("Not a multicast group: " + address);
        }
    }

    @Override // java.net.DatagramSocket
    void createSocket(int i, InetAddress inetAddress) throws SocketException {
        synchronized (this) {
            this.impl = factory != null ? factory.createDatagramSocketImpl() : new PlainDatagramSocketImpl();
            this.impl.create();
            try {
                this.impl.setOption(4, Boolean.TRUE);
                this.impl.bind(i, inetAddress);
                this.isBound = true;
            } catch (SocketException e) {
                close();
                throw e;
            }
        }
    }

    public InetAddress getInterface() throws SocketException {
        NetworkInterface networkInterface;
        Enumeration<InetAddress> inetAddresses;
        checkOpen();
        if (this.setAddress != null) {
            return this.setAddress;
        }
        InetAddress inetAddress = (InetAddress) this.impl.getOption(16);
        if (inetAddress.isAnyLocalAddress() && (networkInterface = getNetworkInterface()) != null && (inetAddresses = networkInterface.getInetAddresses()) != null) {
            while (inetAddresses.hasMoreElements()) {
                InetAddress nextElement = inetAddresses.nextElement();
                if (nextElement instanceof Inet6Address) {
                    return nextElement;
                }
            }
        }
        return inetAddress;
    }

    public boolean getLoopbackMode() throws SocketException {
        checkOpen();
        return !((Boolean) this.impl.getOption(18)).booleanValue();
    }

    public NetworkInterface getNetworkInterface() throws SocketException {
        checkOpen();
        int intValue = ((Integer) this.impl.getOption(31)).intValue();
        return intValue != 0 ? NetworkInterface.getByIndex(intValue) : NetworkInterface.forUnboundMulticastSocket();
    }

    @Deprecated
    public byte getTTL() throws IOException {
        checkOpen();
        return this.impl.getTTL();
    }

    public int getTimeToLive() throws IOException {
        checkOpen();
        return this.impl.getTimeToLive();
    }

    public void joinGroup(InetAddress inetAddress) throws IOException {
        checkJoinOrLeave(inetAddress);
        this.impl.join(inetAddress);
    }

    public void joinGroup(SocketAddress socketAddress, NetworkInterface networkInterface) throws IOException {
        checkJoinOrLeave(socketAddress, networkInterface);
        this.impl.joinGroup(socketAddress, networkInterface);
    }

    public void leaveGroup(InetAddress inetAddress) throws IOException {
        checkJoinOrLeave(inetAddress);
        this.impl.leave(inetAddress);
    }

    public void leaveGroup(SocketAddress socketAddress, NetworkInterface networkInterface) throws IOException {
        checkJoinOrLeave(socketAddress, networkInterface);
        this.impl.leaveGroup(socketAddress, networkInterface);
    }

    @Deprecated
    public void send(DatagramPacket datagramPacket, byte b) throws IOException {
        checkOpen();
        InetAddress address = datagramPacket.getAddress();
        int timeToLive = getTimeToLive();
        if (!address.isMulticastAddress() || ((byte) timeToLive) == b) {
            this.impl.send(datagramPacket);
            return;
        }
        try {
            setTimeToLive(b & 255);
            this.impl.send(datagramPacket);
        } finally {
            setTimeToLive(timeToLive);
        }
    }

    public void setInterface(InetAddress inetAddress) throws SocketException {
        checkOpen();
        if (inetAddress == null) {
            throw new NullPointerException("address == null");
        }
        NetworkInterface byInetAddress = NetworkInterface.getByInetAddress(inetAddress);
        if (byInetAddress == null) {
            throw new SocketException("Address not associated with an interface: " + inetAddress);
        }
        this.impl.setOption(31, Integer.valueOf(byInetAddress.getIndex()));
        this.setAddress = inetAddress;
    }

    public void setLoopbackMode(boolean z) throws SocketException {
        checkOpen();
        this.impl.setOption(18, Boolean.valueOf(!z));
    }

    @Override // java.net.DatagramSocket
    public void setNetworkInterface(NetworkInterface networkInterface) throws SocketException {
        checkOpen();
        if (networkInterface == null) {
            throw new SocketException("networkInterface == null");
        }
        this.impl.setOption(31, Integer.valueOf(networkInterface.getIndex()));
        this.setAddress = null;
    }

    @Deprecated
    public void setTTL(byte b) throws IOException {
        checkOpen();
        this.impl.setTTL(b);
    }

    public void setTimeToLive(int i) throws IOException {
        checkOpen();
        if (i < 0 || i > 255) {
            throw new IllegalArgumentException("TimeToLive out of bounds: " + i);
        }
        this.impl.setTimeToLive(i);
    }
}
