package javax.sql;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.EventObject;

/* loaded from: source-2895416-dex2jar.jar:javax/sql/ConnectionEvent.class */
public class ConnectionEvent extends EventObject implements Serializable {
    private static final long serialVersionUID = -4843217645290030002L;
    private SQLException ex;

    public ConnectionEvent(PooledConnection pooledConnection) {
        super(pooledConnection);
    }

    public ConnectionEvent(PooledConnection pooledConnection, SQLException sQLException) {
        super(pooledConnection);
        this.ex = sQLException;
    }

    public SQLException getSQLException() {
        return this.ex;
    }
}
