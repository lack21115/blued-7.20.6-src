package java.sql;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/sql/SQLWarning.class */
public class SQLWarning extends SQLException implements Serializable {
    private static final long serialVersionUID = 3917336774604784856L;

    public SQLWarning() {
    }

    public SQLWarning(String str) {
        super(str);
    }

    public SQLWarning(String str, String str2) {
        super(str, str2);
    }

    public SQLWarning(String str, String str2, int i) {
        super(str, str2, i);
    }

    public SQLWarning(String str, String str2, int i, Throwable th) {
        super(str, str2, i, th);
    }

    public SQLWarning(String str, String str2, Throwable th) {
        super(str, str2, th);
    }

    public SQLWarning(String str, Throwable th) {
        super(str, th);
    }

    public SQLWarning(Throwable th) {
        super(th);
    }

    public SQLWarning getNextWarning() {
        SQLException nextException = super.getNextException();
        if (nextException == null) {
            return null;
        }
        if (nextException instanceof SQLWarning) {
            return (SQLWarning) nextException;
        }
        throw new Error("SQLWarning chain holds value that is not a SQLWarning");
    }

    public void setNextWarning(SQLWarning sQLWarning) {
        super.setNextException(sQLWarning);
    }
}
