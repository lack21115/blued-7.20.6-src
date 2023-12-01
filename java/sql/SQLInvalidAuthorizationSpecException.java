package java.sql;

/* loaded from: source-2895416-dex2jar.jar:java/sql/SQLInvalidAuthorizationSpecException.class */
public class SQLInvalidAuthorizationSpecException extends SQLNonTransientException {
    private static final long serialVersionUID = -64105250450891498L;

    public SQLInvalidAuthorizationSpecException() {
    }

    public SQLInvalidAuthorizationSpecException(String str) {
        super(str, (String) null, 0);
    }

    public SQLInvalidAuthorizationSpecException(String str, String str2) {
        super(str, str2, 0);
    }

    public SQLInvalidAuthorizationSpecException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public SQLInvalidAuthorizationSpecException(String str, String str2, int i, Throwable th) {
        super(str, str2, i, th);
    }

    public SQLInvalidAuthorizationSpecException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }

    public SQLInvalidAuthorizationSpecException(String str, Throwable th) {
        super(str, th);
    }

    public SQLInvalidAuthorizationSpecException(Throwable th) {
        super(th);
    }
}
