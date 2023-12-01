package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/field/types/LongType.class */
public class LongType extends LongObjectType {
    private static final LongType singleTon = new LongType();

    private LongType() {
        super(SqlType.LONG, new Class[]{Long.TYPE});
    }

    protected LongType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public static LongType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return true;
    }
}
