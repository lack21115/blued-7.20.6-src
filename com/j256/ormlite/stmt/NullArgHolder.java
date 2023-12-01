package com.j256.ormlite.stmt;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/stmt/NullArgHolder.class */
public class NullArgHolder implements ArgumentHolder {
    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public String getColumnName() {
        return "null-holder";
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public FieldType getFieldType() {
        return null;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public Object getSqlArgValue() {
        return null;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public SqlType getSqlType() {
        return SqlType.STRING;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public void setMetaInfo(FieldType fieldType) {
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public void setMetaInfo(String str) {
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public void setMetaInfo(String str, FieldType fieldType) {
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public void setValue(Object obj) {
        throw new UnsupportedOperationException("Cannot set null on " + getClass());
    }
}
