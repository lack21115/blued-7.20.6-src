package javax.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/* loaded from: source-2895416-dex2jar.jar:javax/sql/RowSetInternal.class */
public interface RowSetInternal {
    Connection getConnection() throws SQLException;

    ResultSet getOriginal() throws SQLException;

    ResultSet getOriginalRow() throws SQLException;

    Object[] getParams() throws SQLException;

    void setMetaData(RowSetMetaData rowSetMetaData) throws SQLException;
}
