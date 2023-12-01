package com.sobot.network.http.db;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/db/StColumnEntity.class */
public class StColumnEntity {
    public String columnName;
    public String columnType;
    public String[] compositePrimaryKey;
    public boolean isAutoincrement;
    public boolean isNotNull;
    public boolean isPrimary;

    public StColumnEntity(String str, String str2) {
        this(str, str2, false, false, false);
    }

    public StColumnEntity(String str, String str2, boolean z, boolean z2) {
        this(str, str2, z, z2, false);
    }

    public StColumnEntity(String str, String str2, boolean z, boolean z2, boolean z3) {
        this.columnName = str;
        this.columnType = str2;
        this.isPrimary = z;
        this.isNotNull = z2;
        this.isAutoincrement = z3;
    }

    public StColumnEntity(String... strArr) {
        this.compositePrimaryKey = strArr;
    }
}
