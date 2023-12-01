package javax.sql;

import java.sql.Connection;
import java.sql.SQLException;

/* loaded from: source-2895416-dex2jar.jar:javax/sql/PooledConnection.class */
public interface PooledConnection {
    void addConnectionEventListener(ConnectionEventListener connectionEventListener);

    void addStatementEventListener(StatementEventListener statementEventListener);

    void close() throws SQLException;

    Connection getConnection() throws SQLException;

    void removeConnectionEventListener(ConnectionEventListener connectionEventListener);

    void removeStatementEventListener(StatementEventListener statementEventListener);
}
