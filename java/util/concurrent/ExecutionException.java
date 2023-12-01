package java.util.concurrent;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ExecutionException.class */
public class ExecutionException extends Exception {
    private static final long serialVersionUID = 7830266012832686185L;

    /* JADX INFO: Access modifiers changed from: protected */
    public ExecutionException() {
    }

    protected ExecutionException(String str) {
        super(str);
    }

    public ExecutionException(String str, Throwable th) {
        super(str, th);
    }

    public ExecutionException(Throwable th) {
        super(th);
    }
}
