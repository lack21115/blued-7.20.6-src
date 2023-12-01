package javax.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.EventObject;

/* loaded from: source-2895416-dex2jar.jar:javax/sql/StatementEvent.class */
public class StatementEvent extends EventObject {
    private static final long serialVersionUID = -8089573731826608315L;
    private SQLException exception;
    private PreparedStatement statement;

    public StatementEvent(PooledConnection pooledConnection, PreparedStatement preparedStatement) {
        this(pooledConnection, preparedStatement, null);
    }

    public StatementEvent(PooledConnection pooledConnection, PreparedStatement preparedStatement, SQLException sQLException) {
        super(pooledConnection);
        this.statement = preparedStatement;
        this.exception = sQLException;
    }

    public SQLException getSQLException() {
        return this.exception;
    }

    public PreparedStatement getStatement() {
        return this.statement;
    }
}
