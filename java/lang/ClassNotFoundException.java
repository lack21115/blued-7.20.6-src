package java.lang;

/* loaded from: source-2895416-dex2jar.jar:java/lang/ClassNotFoundException.class */
public class ClassNotFoundException extends ReflectiveOperationException {
    private static final long serialVersionUID = 9176873029745254542L;
    private Throwable ex;

    public ClassNotFoundException() {
        super((Throwable) null);
    }

    public ClassNotFoundException(String str) {
        super(str, null);
    }

    public ClassNotFoundException(String str, Throwable th) {
        super(str);
        this.ex = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.ex;
    }

    public Throwable getException() {
        return this.ex;
    }
}
