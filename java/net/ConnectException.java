package java.net;

/* loaded from: source-2895416-dex2jar.jar:java/net/ConnectException.class */
public class ConnectException extends SocketException {
    private static final long serialVersionUID = 3831404271622369215L;

    public ConnectException() {
    }

    public ConnectException(String str) {
        super(str);
    }

    public ConnectException(String str, Throwable th) {
        super(str, th);
    }
}
