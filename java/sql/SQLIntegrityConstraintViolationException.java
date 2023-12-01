package java.sql;

/* loaded from: source-2895416-dex2jar.jar:java/sql/SQLIntegrityConstraintViolationException.class */
public class SQLIntegrityConstraintViolationException extends SQLNonTransientException {
    private static final long serialVersionUID = 8033405298774849169L;

    public SQLIntegrityConstraintViolationException() {
    }

    public SQLIntegrityConstraintViolationException(String str) {
        super(str, (String) null, 0);
    }

    public SQLIntegrityConstraintViolationException(String str, String str2) {
        super(str, str2, 0);
    }

    public SQLIntegrityConstraintViolationException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public SQLIntegrityConstraintViolationException(String str, String str2, int i, Throwable th) {
        super(str, str2, i, th);
    }

    public SQLIntegrityConstraintViolationException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }

    public SQLIntegrityConstraintViolationException(String str, Throwable th) {
        super(str, th);
    }

    public SQLIntegrityConstraintViolationException(Throwable th) {
        super(th);
    }
}
