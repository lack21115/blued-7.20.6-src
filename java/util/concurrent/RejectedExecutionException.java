package java.util.concurrent;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/RejectedExecutionException.class */
public class RejectedExecutionException extends RuntimeException {
    private static final long serialVersionUID = -375805702767069545L;

    public RejectedExecutionException() {
    }

    public RejectedExecutionException(String str) {
        super(str);
    }

    public RejectedExecutionException(String str, Throwable th) {
        super(str, th);
    }

    public RejectedExecutionException(Throwable th) {
        super(th);
    }
}
