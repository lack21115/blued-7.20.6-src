package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/field/types/IntType.class */
public class IntType extends IntegerObjectType {
    private static final IntType singleTon = new IntType();

    private IntType() {
        super(SqlType.INTEGER, new Class[]{Integer.TYPE});
    }

    protected IntType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public static IntType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return true;
    }
}
