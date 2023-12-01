package java.sql;

/* loaded from: source-2895416-dex2jar.jar:java/sql/SQLNonTransientConnectionException.class */
public class SQLNonTransientConnectionException extends SQLNonTransientException {
    private static final long serialVersionUID = -5852318857474782892L;

    public SQLNonTransientConnectionException() {
    }

    public SQLNonTransientConnectionException(String str) {
        super(str, (String) null, 0);
    }

    public SQLNonTransientConnectionException(String str, String str2) {
        super(str, str2, 0);
    }

    public SQLNonTransientConnectionException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public SQLNonTransientConnectionException(String str, String str2, int i, Throwable th) {
        super(str, str2, i, th);
    }

    public SQLNonTransientConnectionException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }

    public SQLNonTransientConnectionException(String str, Throwable th) {
        super(str, th);
    }

    public SQLNonTransientConnectionException(Throwable th) {
        super(th);
    }
}
