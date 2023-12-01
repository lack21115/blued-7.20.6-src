package java.lang;

/* loaded from: source-2895416-dex2jar.jar:java/lang/AssertionError.class */
public class AssertionError extends Error {
    private static final long serialVersionUID = -5013299493970297370L;

    public AssertionError() {
    }

    public AssertionError(char c) {
        this(String.valueOf(c));
    }

    public AssertionError(double d) {
        this(Double.toString(d));
    }

    public AssertionError(float f) {
        this(Float.toString(f));
    }

    public AssertionError(int i) {
        this(Integer.toString(i));
    }

    public AssertionError(long j) {
        this(Long.toString(j));
    }

    public AssertionError(Object obj) {
        super(String.valueOf(obj));
        if (obj instanceof Throwable) {
            initCause((Throwable) obj);
        }
    }

    public AssertionError(String str, Throwable th) {
        super(str, th);
    }

    public AssertionError(boolean z) {
        this(String.valueOf(z));
    }
}
