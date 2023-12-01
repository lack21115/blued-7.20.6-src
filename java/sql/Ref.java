package java.sql;

import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:java/sql/Ref.class */
public interface Ref {
    String getBaseTypeName() throws SQLException;

    Object getObject() throws SQLException;

    Object getObject(Map<String, Class<?>> map) throws SQLException;

    void setObject(Object obj) throws SQLException;
}
