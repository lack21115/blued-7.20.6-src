package java.sql;

/* loaded from: source-2895416-dex2jar.jar:java/sql/SQLTransactionRollbackException.class */
public class SQLTransactionRollbackException extends SQLTransientException {
    private static final long serialVersionUID = 5246680841170837229L;

    public SQLTransactionRollbackException() {
    }

    public SQLTransactionRollbackException(String str) {
        super(str, (String) null, 0);
    }

    public SQLTransactionRollbackException(String str, String str2) {
        super(str, str2, 0);
    }

    public SQLTransactionRollbackException(String str, String str2, int i) {
        super(str, str2, i);
    }

    public SQLTransactionRollbackException(String str, String str2, int i, Throwable th) {
        super(str, str2, i, th);
    }

    public SQLTransactionRollbackException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }

    public SQLTransactionRollbackException(String str, Throwable th) {
        super(str, th);
    }

    public SQLTransactionRollbackException(Throwable th) {
        super(th);
    }
}
