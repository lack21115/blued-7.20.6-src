package java.net;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:java/net/SocketException.class */
public class SocketException extends IOException {
    private static final long serialVersionUID = -5935874303556886934L;

    public SocketException() {
    }

    public SocketException(String str) {
        super(str);
    }

    public SocketException(String str, Throwable th) {
        super(str, th);
    }

    public SocketException(Throwable th) {
        super(th);
    }
}
