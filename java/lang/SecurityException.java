package java.lang;

/* loaded from: source-2895416-dex2jar.jar:java/lang/SecurityException.class */
public class SecurityException extends RuntimeException {
    private static final long serialVersionUID = 6878364983674394167L;

    public SecurityException() {
    }

    public SecurityException(String str) {
        super(str);
    }

    public SecurityException(String str, Throwable th) {
        super(str, th);
    }

    public SecurityException(Throwable th) {
        super(th == null ? null : th.toString(), th);
    }
}
