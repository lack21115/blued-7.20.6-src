package java.lang;

/* loaded from: source-2895416-dex2jar.jar:java/lang/UnsupportedOperationException.class */
public class UnsupportedOperationException extends RuntimeException {
    private static final long serialVersionUID = -1242599979055084673L;

    public UnsupportedOperationException() {
    }

    public UnsupportedOperationException(String str) {
        super(str);
    }

    public UnsupportedOperationException(String str, Throwable th) {
        super(str, th);
    }

    public UnsupportedOperationException(Throwable th) {
        super(th == null ? null : th.toString(), th);
    }
}
