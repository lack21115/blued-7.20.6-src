package com.j256.ormlite.stmt;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/stmt/ColumnArg.class */
public class ColumnArg {
    private final String columnName;
    private final String tableName;

    public ColumnArg(String str) {
        this.tableName = null;
        this.columnName = str;
    }

    public ColumnArg(String str, String str2) {
        this.tableName = str;
        this.columnName = str2;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public String getTableName() {
        return this.tableName;
    }
}
