package javax.sql;

import java.sql.SQLException;

/* loaded from: source-2895416-dex2jar.jar:javax/sql/RowSetWriter.class */
public interface RowSetWriter {
    boolean writeData(RowSetInternal rowSetInternal) throws SQLException;
}
