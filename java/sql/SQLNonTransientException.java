package java.sql;

/* loaded from: source-2895416-dex2jar.jar:java/sql/SQLNonTransientException.class */
public class SQLNonTransientException extends SQLException {
    private static final long serialVersionUID = -9104382843534716547L;

    public SQLNonTransientException() {
    }

    public SQLNonTransientException(String str) {
        super(str, (String) null, 0);
    }

    public SQLNonTransientException(String str, String str2) {
        super(str, str2, 0);
    }

    public SQLNonTransientException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public SQLNonTransientException(String str, String str2, int i, Throwable th) {
        super(str, str2, i, th);
    }

    public SQLNonTransientException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }

    public SQLNonTransientException(String str, Throwable th) {
        super(str, th);
    }

    public SQLNonTransientException(Throwable th) {
        super(th);
    }
}
