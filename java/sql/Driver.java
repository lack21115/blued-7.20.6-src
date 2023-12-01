package java.sql;

import java.util.Properties;

/* loaded from: source-2895416-dex2jar.jar:java/sql/Driver.class */
public interface Driver {
    boolean acceptsURL(String str) throws SQLException;

    Connection connect(String str, Properties properties) throws SQLException;

    int getMajorVersion();

    int getMinorVersion();

    DriverPropertyInfo[] getPropertyInfo(String str, Properties properties) throws SQLException;

    boolean jdbcCompliant();
}
