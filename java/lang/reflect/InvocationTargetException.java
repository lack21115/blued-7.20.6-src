package java.lang.reflect;

/* loaded from: source-2895416-dex2jar.jar:java/lang/reflect/InvocationTargetException.class */
public class InvocationTargetException extends ReflectiveOperationException {
    private static final long serialVersionUID = 4085088731926701167L;
    private Throwable target;

    protected InvocationTargetException() {
        super((Throwable) null);
    }

    public InvocationTargetException(Throwable th) {
        super(null, th);
        this.target = th;
    }

    public InvocationTargetException(Throwable th, String str) {
        super(str, th);
        this.target = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.target;
    }

    public Throwable getTargetException() {
        return this.target;
    }
}
