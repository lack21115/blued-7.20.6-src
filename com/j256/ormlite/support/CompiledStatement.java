package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/support/CompiledStatement.class */
public interface CompiledStatement {
    void cancel() throws SQLException;

    void close() throws SQLException;

    void closeQuietly();

    int getColumnCount() throws SQLException;

    String getColumnName(int i) throws SQLException;

    int runExecute() throws SQLException;

    DatabaseResults runQuery(ObjectCache objectCache) throws SQLException;

    int runUpdate() throws SQLException;

    void setMaxRows(int i) throws SQLException;

    void setObject(int i, Object obj, SqlType sqlType) throws SQLException;

    void setQueryTimeout(long j) throws SQLException;
}
