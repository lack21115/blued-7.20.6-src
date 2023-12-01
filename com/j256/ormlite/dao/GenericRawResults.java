package com.j256.ormlite.dao;

import java.sql.SQLException;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/dao/GenericRawResults.class */
public interface GenericRawResults<T> extends CloseableWrappedIterable<T> {
    @Override // com.j256.ormlite.dao.CloseableWrappedIterable
    void close() throws SQLException;

    String[] getColumnNames();

    T getFirstResult() throws SQLException;

    int getNumberColumns();

    List<T> getResults() throws SQLException;
}
