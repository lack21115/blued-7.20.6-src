package java.sql;

/* loaded from: source-2895416-dex2jar.jar:java/sql/SQLTimeoutException.class */
public class SQLTimeoutException extends SQLTransientException {
    private static final long serialVersionUID = -4487171280562520262L;

    public SQLTimeoutException() {
    }

    public SQLTimeoutException(String str) {
        super(str, (String) null, 0);
    }

    public SQLTimeoutException(String str, String str2) {
        super(str, str2, 0);
    }

    public SQLTimeoutException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public SQLTimeoutException(String str, String str2, int i, Throwable th) {
        super(str, str2, i, th);
    }

    public SQLTimeoutException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }

    public SQLTimeoutException(String str, Throwable th) {
        super(str, th);
    }

    public SQLTimeoutException(Throwable th) {
        super(th);
    }
}
