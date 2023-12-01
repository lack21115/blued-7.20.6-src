package java.security;

/* loaded from: source-2895416-dex2jar.jar:java/security/ProviderException.class */
public class ProviderException extends RuntimeException {
    private static final long serialVersionUID = 5256023526693665674L;

    public ProviderException() {
    }

    public ProviderException(String str) {
        super(str);
    }

    public ProviderException(String str, Throwable th) {
        super(str, th);
    }

    public ProviderException(Throwable th) {
        super(th);
    }
}
