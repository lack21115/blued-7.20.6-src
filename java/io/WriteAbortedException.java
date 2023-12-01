package java.io;

/* loaded from: source-2895416-dex2jar.jar:java/io/WriteAbortedException.class */
public class WriteAbortedException extends ObjectStreamException {
    private static final long serialVersionUID = -3326426625597282442L;
    public Exception detail;

    public WriteAbortedException(String str, Exception exc) {
        super(str);
        this.detail = exc;
        initCause(exc);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.detail;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        String str = message;
        if (this.detail != null) {
            str = message + "; " + this.detail.toString();
        }
        return str;
    }
}
