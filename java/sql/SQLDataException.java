package java.sql;

/* loaded from: source-2895416-dex2jar.jar:java/sql/SQLDataException.class */
public class SQLDataException extends SQLNonTransientException {
    private static final long serialVersionUID = -6889123282670549800L;

    public SQLDataException() {
    }

    public SQLDataException(String str) {
        super(str, (String) null, 0);
    }

    public SQLDataException(String str, String str2) {
        super(str, str2, 0);
    }

    public SQLDataException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public SQLDataException(String str, String str2, int i, Throwable th) {
        super(str, str2, i, th);
    }

    public SQLDataException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }

    public SQLDataException(String str, Throwable th) {
        super(str, th);
    }

    public SQLDataException(Throwable th) {
        super(th);
    }
}
