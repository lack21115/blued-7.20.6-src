package java.sql;

import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:java/sql/Struct.class */
public interface Struct {
    Object[] getAttributes() throws SQLException;

    Object[] getAttributes(Map<String, Class<?>> map) throws SQLException;

    String getSQLTypeName() throws SQLException;
}
