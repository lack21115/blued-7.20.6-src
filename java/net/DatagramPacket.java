package java.net;

/* loaded from: source-2895416-dex2jar.jar:java/net/DatagramPacket.class */
public final class DatagramPacket {
    private InetAddress address;
    private byte[] data;
    private int length;
    private int offset;
    private int port;
    private int userSuppliedLength;

    public DatagramPacket(byte[] bArr, int i) {
        this(bArr, 0, i);
    }

    public DatagramPacket(byte[] bArr, int i, int i2) {
        this.port = -1;
        this.offset = 0;
        setData(bArr, i, i2);
    }

    public DatagramPacket(byte[] bArr, int i, int i2, InetAddress inetAddress, int i3) {
        this(bArr, i, i2);
        setPort(i3);
        this.address = inetAddress;
    }

    public DatagramPacket(byte[] bArr, int i, int i2, SocketAddress socketAddress) throws SocketException {
        this(bArr, i, i2);
        setSocketAddress(socketAddress);
    }

    public DatagramPacket(byte[] bArr, int i, InetAddress inetAddress, int i2) {
        this(bArr, 0, i, inetAddress, i2);
    }

    public DatagramPacket(byte[] bArr, int i, SocketAddress socketAddress) throws SocketException {
        this(bArr, 0, i);
        setSocketAddress(socketAddress);
    }

    public InetAddress getAddress() {
        InetAddress inetAddress;
        synchronized (this) {
            inetAddress = this.address;
        }
        return inetAddress;
    }

    public byte[] getData() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.data;
        }
        return bArr;
    }

    public int getLength() {
        int i;
        synchronized (this) {
            i = this.length;
        }
        return i;
    }

    public int getOffset() {
        int i;
        synchronized (this) {
            i = this.offset;
        }
        return i;
    }

    public int getPort() {
        int i;
        synchronized (this) {
            i = this.port;
        }
        return i;
    }

    public SocketAddress getSocketAddress() {
        InetSocketAddress inetSocketAddress;
        synchronized (this) {
            inetSocketAddress = new InetSocketAddress(getAddress(), getPort());
        }
        return inetSocketAddress;
    }

    public void resetLengthForReceive() {
        this.length = this.userSuppliedLength;
    }

    public void setAddress(InetAddress inetAddress) {
        synchronized (this) {
            this.address = inetAddress;
        }
    }

    public void setData(byte[] bArr) {
        synchronized (this) {
            this.length = bArr.length;
            this.userSuppliedLength = this.length;
            this.data = bArr;
            this.offset = 0;
        }
    }

    public void setData(byte[] bArr, int i, int i2) {
        synchronized (this) {
            if ((i | i2) >= 0) {
                if (i <= bArr.length && i2 <= bArr.length - i) {
                    this.data = bArr;
                    this.offset = i;
                    this.length = i2;
                    this.userSuppliedLength = i2;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    public void setLength(int i) {
        synchronized (this) {
            if (i >= 0) {
                if (this.offset + i <= this.data.length) {
                    this.length = i;
                    this.userSuppliedLength = i;
                }
            }
            throw new IndexOutOfBoundsException("length=" + i + ", offset=" + this.offset + ", buffer size=" + this.data.length);
        }
    }

    public void setPort(int i) {
        synchronized (this) {
            if (i < 0 || i > 65535) {
                throw new IllegalArgumentException("Port out of range: " + i);
            }
            this.port = i;
        }
    }

    public void setReceivedLength(int i) {
        this.length = i;
    }

    public void setSocketAddress(SocketAddress socketAddress) {
        synchronized (this) {
            if (!(socketAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Socket address not an InetSocketAddress: " + (socketAddress == null ? null : socketAddress.getClass()));
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            if (inetSocketAddress.isUnresolved()) {
                throw new IllegalArgumentException("Socket address unresolved: " + socketAddress);
            }
            this.port = inetSocketAddress.getPort();
            this.address = inetSocketAddress.getAddress();
        }
    }
}
