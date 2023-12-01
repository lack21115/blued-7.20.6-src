package java.net;

/* loaded from: source-2895416-dex2jar.jar:java/net/NoRouteToHostException.class */
public class NoRouteToHostException extends SocketException {
    private static final long serialVersionUID = -1897550894873493790L;

    public NoRouteToHostException() {
    }

    public NoRouteToHostException(String str) {
        super(str);
    }

    public NoRouteToHostException(String str, Throwable th) {
        super(str, th);
    }
}
