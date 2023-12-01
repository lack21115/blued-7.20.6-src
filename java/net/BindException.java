package java.net;

/* loaded from: source-2895416-dex2jar.jar:java/net/BindException.class */
public class BindException extends SocketException {
    private static final long serialVersionUID = -5945005768251722951L;

    public BindException() {
    }

    public BindException(String str) {
        super(str);
    }

    public BindException(String str, Throwable th) {
        super(str, th);
    }
}
