package external.org.apache.commons.lang3.exception;

/* loaded from: source-259656-dex2jar.jar:external/org/apache/commons/lang3/exception/CloneFailedException.class */
public class CloneFailedException extends RuntimeException {
    private static final long serialVersionUID = 20091223;

    public CloneFailedException(String str) {
        super(str);
    }

    public CloneFailedException(String str, Throwable th) {
        super(str, th);
    }

    public CloneFailedException(Throwable th) {
        super(th);
    }
}
