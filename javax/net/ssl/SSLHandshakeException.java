package javax.net.ssl;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/SSLHandshakeException.class */
public class SSLHandshakeException extends SSLException {
    private static final long serialVersionUID = -5045881315018326890L;

    public SSLHandshakeException(String str) {
        super(str);
    }

    public SSLHandshakeException(String str, Throwable th) {
        super(str, th);
    }

    public SSLHandshakeException(Throwable th) {
        super(th);
    }
}
