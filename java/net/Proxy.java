package java.net;

/* loaded from: source-2895416-dex2jar.jar:java/net/Proxy.class */
public class Proxy {
    public static final Proxy NO_PROXY = new Proxy();
    private SocketAddress address;
    private Type type;

    /* loaded from: source-2895416-dex2jar.jar:java/net/Proxy$Type.class */
    public enum Type {
        DIRECT,
        HTTP,
        SOCKS
    }

    private Proxy() {
        this.type = Type.DIRECT;
        this.address = null;
    }

    public Proxy(Type type, SocketAddress socketAddress) {
        if (type == Type.DIRECT || socketAddress == null) {
            throw new IllegalArgumentException("Illegal Proxy.Type or SocketAddress argument");
        }
        this.type = type;
        this.address = socketAddress;
    }

    public SocketAddress address() {
        return this.address;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Proxy) {
            Proxy proxy = (Proxy) obj;
            return this.type == proxy.type && this.address.equals(proxy.address);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = 0 + this.type.hashCode();
        int i = hashCode;
        if (this.address != null) {
            i = hashCode + this.address.hashCode();
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.type != null) {
            sb.append(this.type.toString());
        }
        sb.append("@");
        if (this.type != Type.DIRECT && this.address != null) {
            sb.append(this.address.toString());
        }
        return sb.toString();
    }

    public Type type() {
        return this.type;
    }
}
