package java.sql;

/* loaded from: source-2895416-dex2jar.jar:java/sql/Savepoint.class */
public interface Savepoint {
    int getSavepointId() throws SQLException;

    String getSavepointName() throws SQLException;
}
