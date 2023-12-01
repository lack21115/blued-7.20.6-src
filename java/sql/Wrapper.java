package java.sql;

/* loaded from: source-2895416-dex2jar.jar:java/sql/Wrapper.class */
public interface Wrapper {
    boolean isWrapperFor(Class<?> cls) throws SQLException;

    <T> T unwrap(Class<T> cls) throws SQLException;
}
