package java.lang.reflect;

/* loaded from: source-2895416-dex2jar.jar:java/lang/reflect/UndeclaredThrowableException.class */
public class UndeclaredThrowableException extends RuntimeException {
    private static final long serialVersionUID = 330127114055056639L;
    private Throwable undeclaredThrowable;

    public UndeclaredThrowableException(Throwable th) {
        this.undeclaredThrowable = th;
        initCause(th);
    }

    public UndeclaredThrowableException(Throwable th, String str) {
        super(str);
        this.undeclaredThrowable = th;
        initCause(th);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.undeclaredThrowable;
    }

    public Throwable getUndeclaredThrowable() {
        return this.undeclaredThrowable;
    }
}
