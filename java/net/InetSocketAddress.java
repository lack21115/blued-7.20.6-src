package java.net;

import java.io.IOException;
import java.io.ObjectInputStream;

/* loaded from: source-2895416-dex2jar.jar:java/net/InetSocketAddress.class */
public class InetSocketAddress extends SocketAddress {
    private static final long serialVersionUID = 5076001401234631237L;
    private final InetAddress addr;
    private final String hostname;
    private final int port;

    public InetSocketAddress() {
        this.addr = null;
        this.hostname = null;
        this.port = -1;
    }

    public InetSocketAddress(int i) {
        this((InetAddress) null, i);
    }

    public InetSocketAddress(String str, int i) {
        this(str, i, true);
    }

    InetSocketAddress(String str, int i, boolean z) {
        if (str == null || i < 0 || i > 65535) {
            throw new IllegalArgumentException("host=" + str + ", port=" + i);
        }
        InetAddress inetAddress = null;
        String str2 = str;
        if (z) {
            try {
                inetAddress = InetAddress.getByName(str);
                str2 = null;
            } catch (UnknownHostException e) {
                inetAddress = null;
                str2 = str;
            }
        }
        this.addr = inetAddress;
        this.hostname = str2;
        this.port = i;
    }

    public InetSocketAddress(InetAddress inetAddress, int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("port=" + i);
        }
        this.addr = inetAddress == null ? Inet4Address.ANY : inetAddress;
        this.hostname = null;
        this.port = i;
    }

    public static InetSocketAddress createUnresolved(String str, int i) {
        return new InetSocketAddress(str, i, false);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            z = true;
        } else {
            z = false;
            if (obj instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
                z = false;
                if (this.port == inetSocketAddress.port) {
                    if (this.addr == null && inetSocketAddress.addr == null) {
                        return this.hostname.equals(inetSocketAddress.hostname);
                    }
                    z = false;
                    if (this.addr != null) {
                        return this.addr.equals(inetSocketAddress.addr);
                    }
                }
            }
        }
        return z;
    }

    public final InetAddress getAddress() {
        return this.addr;
    }

    public final String getHostName() {
        return this.addr != null ? this.addr.getHostName() : this.hostname;
    }

    public final String getHostString() {
        return this.hostname != null ? this.hostname : this.addr.getHostAddress();
    }

    public final int getPort() {
        return this.port;
    }

    public final int hashCode() {
        return this.addr == null ? this.hostname.hashCode() + this.port : this.addr.hashCode() + this.port;
    }

    public final boolean isUnresolved() {
        return this.addr == null;
    }

    public String toString() {
        return (this.addr != null ? this.addr.toString() : this.hostname) + ":" + this.port;
    }
}
