package com.j256.ormlite.stmt;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/stmt/BaseArgumentHolder.class */
public abstract class BaseArgumentHolder implements ArgumentHolder {
    private String columnName;
    private FieldType fieldType;
    private SqlType sqlType;

    public BaseArgumentHolder() {
        this.columnName = null;
        this.fieldType = null;
        this.sqlType = null;
    }

    public BaseArgumentHolder(SqlType sqlType) {
        this.columnName = null;
        this.fieldType = null;
        this.sqlType = null;
        this.sqlType = sqlType;
    }

    public BaseArgumentHolder(String str) {
        this.columnName = null;
        this.fieldType = null;
        this.sqlType = null;
        this.columnName = str;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public String getColumnName() {
        return this.columnName;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public FieldType getFieldType() {
        return this.fieldType;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public Object getSqlArgValue() throws SQLException {
        if (!isValueSet()) {
            throw new SQLException("Column value has not been set for " + this.columnName);
        }
        Object value = getValue();
        if (value == null) {
            return null;
        }
        FieldType fieldType = this.fieldType;
        return fieldType == null ? value : (fieldType.isForeign() && this.fieldType.getType() == value.getClass()) ? this.fieldType.getForeignIdField().extractJavaFieldValue(value) : this.fieldType.convertJavaFieldToSqlArgValue(value);
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public SqlType getSqlType() {
        return this.sqlType;
    }

    protected abstract Object getValue();

    protected abstract boolean isValueSet();

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public void setMetaInfo(FieldType fieldType) {
        FieldType fieldType2 = this.fieldType;
        if (fieldType2 == null || fieldType2 == fieldType) {
            this.fieldType = fieldType;
            return;
        }
        throw new IllegalArgumentException("FieldType name cannot be set twice from " + this.fieldType + " to " + fieldType + ".  Using a SelectArg twice in query with different columns?");
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public void setMetaInfo(String str) {
        String str2 = this.columnName;
        if (str2 == null || str2.equals(str)) {
            this.columnName = str;
            return;
        }
        throw new IllegalArgumentException("Column name cannot be set twice from " + this.columnName + " to " + str + ".  Using a SelectArg twice in query with different columns?");
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public void setMetaInfo(String str, FieldType fieldType) {
        setMetaInfo(str);
        setMetaInfo(fieldType);
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public abstract void setValue(Object obj);

    public String toString() {
        if (isValueSet()) {
            try {
                Object sqlArgValue = getSqlArgValue();
                return sqlArgValue == null ? "[null]" : sqlArgValue.toString();
            } catch (SQLException e) {
                return "[could not get value: " + e + "]";
            }
        }
        return "[unset]";
    }
}
