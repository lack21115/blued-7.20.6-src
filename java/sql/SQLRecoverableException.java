package java.sql;

/* loaded from: source-2895416-dex2jar.jar:java/sql/SQLRecoverableException.class */
public class SQLRecoverableException extends SQLException {
    private static final long serialVersionUID = -4144386502923131579L;

    public SQLRecoverableException() {
    }

    public SQLRecoverableException(String str) {
        super(str, (String) null, 0);
    }

    public SQLRecoverableException(String str, String str2) {
        super(str, str2, 0);
    }

    public SQLRecoverableException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public SQLRecoverableException(String str, String str2, int i, Throwable th) {
        super(str, str2, i, th);
    }

    public SQLRecoverableException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }

    public SQLRecoverableException(String str, Throwable th) {
        super(str, th);
    }

    public SQLRecoverableException(Throwable th) {
        super(th);
    }
}
