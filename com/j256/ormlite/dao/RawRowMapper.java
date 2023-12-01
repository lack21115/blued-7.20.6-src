package com.j256.ormlite.dao;

import java.sql.SQLException;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/dao/RawRowMapper.class */
public interface RawRowMapper<T> {
    T mapRow(String[] strArr, String[] strArr2) throws SQLException;
}
