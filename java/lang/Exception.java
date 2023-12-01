package java.lang;

/* loaded from: source-2895416-dex2jar.jar:java/lang/Exception.class */
public class Exception extends Throwable {
    private static final long serialVersionUID = -3387516993124229948L;

    public Exception() {
    }

    public Exception(String str) {
        super(str);
    }

    public Exception(String str, Throwable th) {
        super(str, th);
    }

    public Exception(Throwable th) {
        super(th);
    }
}
