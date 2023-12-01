package bolts;

/* loaded from: source-8756600-dex2jar.jar:bolts/ExecutorException.class */
public class ExecutorException extends RuntimeException {
    public ExecutorException(Exception exc) {
        super("An exception was thrown by an Executor", exc);
    }
}
