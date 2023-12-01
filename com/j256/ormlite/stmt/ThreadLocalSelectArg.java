package com.j256.ormlite.stmt;

import com.j256.ormlite.field.SqlType;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/stmt/ThreadLocalSelectArg.class */
public class ThreadLocalSelectArg extends BaseArgumentHolder implements ArgumentHolder {
    private ThreadLocal<ValueWrapper> threadValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/stmt/ThreadLocalSelectArg$ValueWrapper.class */
    public static class ValueWrapper {
        Object value;

        public ValueWrapper(Object obj) {
            this.value = obj;
        }
    }

    public ThreadLocalSelectArg() {
        this.threadValue = new ThreadLocal<>();
    }

    public ThreadLocalSelectArg(SqlType sqlType, Object obj) {
        super(sqlType);
        this.threadValue = new ThreadLocal<>();
        setValue(obj);
    }

    public ThreadLocalSelectArg(Object obj) {
        this.threadValue = new ThreadLocal<>();
        setValue(obj);
    }

    public ThreadLocalSelectArg(String str, Object obj) {
        super(str);
        this.threadValue = new ThreadLocal<>();
        setValue(obj);
    }

    @Override // com.j256.ormlite.stmt.BaseArgumentHolder
    protected Object getValue() {
        ValueWrapper valueWrapper = this.threadValue.get();
        if (valueWrapper == null) {
            return null;
        }
        return valueWrapper.value;
    }

    @Override // com.j256.ormlite.stmt.BaseArgumentHolder
    protected boolean isValueSet() {
        return this.threadValue.get() != null;
    }

    @Override // com.j256.ormlite.stmt.BaseArgumentHolder, com.j256.ormlite.stmt.ArgumentHolder
    public void setValue(Object obj) {
        this.threadValue.set(new ValueWrapper(obj));
    }
}
