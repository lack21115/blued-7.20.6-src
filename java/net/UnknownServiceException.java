package java.net;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:java/net/UnknownServiceException.class */
public class UnknownServiceException extends IOException {
    private static final long serialVersionUID = -4169033248853639508L;

    public UnknownServiceException() {
    }

    public UnknownServiceException(String str) {
        super(str);
    }

    public UnknownServiceException(String str, Throwable th) {
        super(str, th);
    }
}
