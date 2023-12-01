package com.j256.ormlite.dao;

import java.sql.SQLException;
import java.util.Collection;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/dao/ForeignCollection.class */
public interface ForeignCollection<T> extends CloseableIterable<T>, Collection<T> {
    boolean add(T t);

    void closeLastIterator() throws SQLException;

    CloseableIterator<T> closeableIterator(int i);

    CloseableWrappedIterable<T> getWrappedIterable();

    CloseableWrappedIterable<T> getWrappedIterable(int i);

    boolean isEager();

    CloseableIterator<T> iterator(int i);

    CloseableIterator<T> iteratorThrow() throws SQLException;

    CloseableIterator<T> iteratorThrow(int i) throws SQLException;

    int refresh(T t) throws SQLException;

    int refreshAll() throws SQLException;

    int refreshCollection() throws SQLException;

    int update(T t) throws SQLException;

    int updateAll() throws SQLException;
}
