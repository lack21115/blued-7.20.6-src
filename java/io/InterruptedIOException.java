package java.io;

/* loaded from: source-2895416-dex2jar.jar:java/io/InterruptedIOException.class */
public class InterruptedIOException extends IOException {
    private static final long serialVersionUID = 4020568460727500567L;
    public int bytesTransferred;

    public InterruptedIOException() {
    }

    public InterruptedIOException(String str) {
        super(str);
    }

    public InterruptedIOException(String str, Throwable th) {
        super(str, th);
    }
}
