package javax.sql;

import java.sql.SQLException;

/* loaded from: source-2895416-dex2jar.jar:javax/sql/ConnectionPoolDataSource.class */
public interface ConnectionPoolDataSource extends CommonDataSource {
    PooledConnection getPooledConnection() throws SQLException;

    PooledConnection getPooledConnection(String str, String str2) throws SQLException;
}
