package java.net;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:java/net/ProtocolException.class */
public class ProtocolException extends IOException {
    private static final long serialVersionUID = -6098449442062388080L;

    public ProtocolException() {
    }

    public ProtocolException(String str) {
        super(str);
    }

    public ProtocolException(String str, Throwable th) {
        super(str, th);
    }
}
