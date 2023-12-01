package com.j256.ormlite.stmt;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/stmt/ArgumentHolder.class */
public interface ArgumentHolder {
    String getColumnName();

    FieldType getFieldType();

    Object getSqlArgValue() throws SQLException;

    SqlType getSqlType();

    void setMetaInfo(FieldType fieldType);

    void setMetaInfo(String str);

    void setMetaInfo(String str, FieldType fieldType);

    void setValue(Object obj);
}
