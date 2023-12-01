package java.lang;

/* loaded from: source-2895416-dex2jar.jar:java/lang/ExceptionInInitializerError.class */
public class ExceptionInInitializerError extends LinkageError {
    private static final long serialVersionUID = 1521711792217232256L;
    private Throwable exception;

    public ExceptionInInitializerError() {
        initCause(null);
    }

    public ExceptionInInitializerError(String str) {
        super(str);
        initCause(null);
    }

    public ExceptionInInitializerError(Throwable th) {
        this.exception = th;
        initCause(th);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.exception;
    }

    public Throwable getException() {
        return this.exception;
    }
}
