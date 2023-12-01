package java.sql;

/* loaded from: source-2895416-dex2jar.jar:java/sql/SQLTransientConnectionException.class */
public class SQLTransientConnectionException extends SQLTransientException {
    private static final long serialVersionUID = -2520155553543391200L;

    public SQLTransientConnectionException() {
    }

    public SQLTransientConnectionException(String str) {
        super(str, (String) null, 0);
    }

    public SQLTransientConnectionException(String str, String str2) {
        super(str, str2, 0);
    }

    public SQLTransientConnectionException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public SQLTransientConnectionException(String str, String str2, int i, Throwable th) {
        super(str, str2, i, th);
    }

    public SQLTransientConnectionException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }

    public SQLTransientConnectionException(String str, Throwable th) {
        super(str, th);
    }

    public SQLTransientConnectionException(Throwable th) {
        super(th);
    }
}
