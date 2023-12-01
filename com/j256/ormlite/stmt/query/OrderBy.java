package com.j256.ormlite.stmt.query;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/stmt/query/OrderBy.class */
public class OrderBy {
    private final boolean ascending;
    private final String columnName;

    public OrderBy(String str, boolean z) {
        this.columnName = str;
        this.ascending = z;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public boolean isAscending() {
        return this.ascending;
    }
}
