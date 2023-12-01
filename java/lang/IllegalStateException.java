package java.lang;

/* loaded from: source-2895416-dex2jar.jar:java/lang/IllegalStateException.class */
public class IllegalStateException extends RuntimeException {
    private static final long serialVersionUID = -1848914673093119416L;

    public IllegalStateException() {
    }

    public IllegalStateException(String str) {
        super(str);
    }

    public IllegalStateException(String str, Throwable th) {
        super(str, th);
    }

    public IllegalStateException(Throwable th) {
        super(th == null ? null : th.toString(), th);
    }
}
