package java.sql;

/* loaded from: source-2895416-dex2jar.jar:java/sql/SQLSyntaxErrorException.class */
public class SQLSyntaxErrorException extends SQLNonTransientException {
    private static final long serialVersionUID = -1843832610477496053L;

    public SQLSyntaxErrorException() {
    }

    public SQLSyntaxErrorException(String str) {
        super(str, (String) null, 0);
    }

    public SQLSyntaxErrorException(String str, String str2) {
        super(str, str2, 0);
    }

    public SQLSyntaxErrorException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public SQLSyntaxErrorException(String str, String str2, int i, Throwable th) {
        super(str, str2, i, th);
    }

    public SQLSyntaxErrorException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }

    public SQLSyntaxErrorException(String str, Throwable th) {
        super(str, th);
    }

    public SQLSyntaxErrorException(Throwable th) {
        super(th);
    }
}
