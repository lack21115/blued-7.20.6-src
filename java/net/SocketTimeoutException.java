package java.net;

import java.io.InterruptedIOException;

/* loaded from: source-2895416-dex2jar.jar:java/net/SocketTimeoutException.class */
public class SocketTimeoutException extends InterruptedIOException {
    private static final long serialVersionUID = -8846654841826352300L;

    public SocketTimeoutException() {
    }

    public SocketTimeoutException(String str) {
        super(str);
    }

    public SocketTimeoutException(String str, Throwable th) {
        super(str, th);
    }

    public SocketTimeoutException(Throwable th) {
        super(null, th);
    }
}
