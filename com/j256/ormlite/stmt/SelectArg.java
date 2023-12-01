package com.j256.ormlite.stmt;

import com.j256.ormlite.field.SqlType;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/stmt/SelectArg.class */
public class SelectArg extends BaseArgumentHolder implements ArgumentHolder {
    private boolean hasBeenSet;
    private Object value;

    public SelectArg() {
        this.hasBeenSet = false;
        this.value = null;
    }

    public SelectArg(SqlType sqlType) {
        super(sqlType);
        this.hasBeenSet = false;
        this.value = null;
    }

    public SelectArg(SqlType sqlType, Object obj) {
        super(sqlType);
        this.hasBeenSet = false;
        this.value = null;
        setValue(obj);
    }

    public SelectArg(Object obj) {
        this.hasBeenSet = false;
        this.value = null;
        setValue(obj);
    }

    public SelectArg(String str, Object obj) {
        super(str);
        this.hasBeenSet = false;
        this.value = null;
        setValue(obj);
    }

    @Override // com.j256.ormlite.stmt.BaseArgumentHolder
    protected Object getValue() {
        return this.value;
    }

    @Override // com.j256.ormlite.stmt.BaseArgumentHolder
    protected boolean isValueSet() {
        return this.hasBeenSet;
    }

    @Override // com.j256.ormlite.stmt.BaseArgumentHolder, com.j256.ormlite.stmt.ArgumentHolder
    public void setValue(Object obj) {
        this.hasBeenSet = true;
        this.value = obj;
    }
}
