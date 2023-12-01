package java.lang;

/* loaded from: source-2895416-dex2jar.jar:java/lang/RuntimeException.class */
public class RuntimeException extends Exception {
    private static final long serialVersionUID = -7034897190745766939L;

    public RuntimeException() {
    }

    public RuntimeException(String str) {
        super(str);
    }

    public RuntimeException(String str, Throwable th) {
        super(str, th);
    }

    public RuntimeException(Throwable th) {
        super(th);
    }
}
