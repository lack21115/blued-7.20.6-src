package java.net;

/* loaded from: source-2895416-dex2jar.jar:java/net/PortUnreachableException.class */
public class PortUnreachableException extends SocketException {
    private static final long serialVersionUID = 8462541992376507323L;

    public PortUnreachableException() {
    }

    public PortUnreachableException(String str) {
        super(str);
    }

    public PortUnreachableException(String str, Throwable th) {
        super(str, th);
    }
}
