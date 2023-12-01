package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/ConcurrentModificationException.class */
public class ConcurrentModificationException extends RuntimeException {
    private static final long serialVersionUID = -3666751008965953603L;

    public ConcurrentModificationException() {
    }

    public ConcurrentModificationException(String str) {
        super(str);
    }

    public ConcurrentModificationException(String str, Throwable th) {
        super(str, th);
    }

    public ConcurrentModificationException(Throwable th) {
        super(th);
    }
}
