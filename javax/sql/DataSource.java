package javax.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Wrapper;

/* loaded from: source-2895416-dex2jar.jar:javax/sql/DataSource.class */
public interface DataSource extends CommonDataSource, Wrapper {
    Connection getConnection() throws SQLException;

    Connection getConnection(String str, String str2) throws SQLException;
}
