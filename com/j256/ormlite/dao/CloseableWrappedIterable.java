package com.j256.ormlite.dao;

import java.sql.SQLException;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/dao/CloseableWrappedIterable.class */
public interface CloseableWrappedIterable<T> extends CloseableIterable<T> {
    void close() throws SQLException;
}
