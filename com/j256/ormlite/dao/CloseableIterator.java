package com.j256.ormlite.dao;

import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.Iterator;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/dao/CloseableIterator.class */
public interface CloseableIterator<T> extends Iterator<T> {
    void close() throws SQLException;

    void closeQuietly();

    T current() throws SQLException;

    T first() throws SQLException;

    DatabaseResults getRawResults();

    T moveRelative(int i) throws SQLException;

    void moveToNext();

    T nextThrow() throws SQLException;

    T previous() throws SQLException;
}
