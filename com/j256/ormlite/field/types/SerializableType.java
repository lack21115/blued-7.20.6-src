package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.SQLException;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/field/types/SerializableType.class */
public class SerializableType extends BaseDataType {
    private static final SerializableType singleTon = new SerializableType();

    private SerializableType() {
        super(SqlType.SERIALIZABLE, new Class[0]);
    }

    protected SerializableType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public static SerializableType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Class<?> getPrimaryClass() {
        return Serializable.class;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isAppropriateId() {
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isArgumentHolderRequired() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isComparable() {
        return false;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public boolean isStreamType() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForField(Field field) {
        return Serializable.class.isAssignableFrom(field.getType());
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) throws SQLException {
        ObjectOutputStream objectOutputStream;
        Exception e;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(obj);
                    objectOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                } catch (Exception e2) {
                    e = e2;
                    StringBuilder sb = new StringBuilder();
                    ObjectOutputStream objectOutputStream3 = objectOutputStream;
                    sb.append("Could not write serialized object to byte array: ");
                    ObjectOutputStream objectOutputStream4 = objectOutputStream;
                    sb.append(obj);
                    objectOutputStream2 = objectOutputStream;
                    throw SqlExceptionUtil.create(sb.toString(), e);
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream2 = objectOutputStream;
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            objectOutputStream = null;
            e = e4;
        }
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        throw new SQLException("Default values for serializable types are not supported");
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object resultStringToJava(FieldType fieldType, String str, int i) throws SQLException {
        throw new SQLException("Serializable type cannot be converted from string to Java");
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return databaseResults.getBytes(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.ObjectInputStream] */
    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object sqlArgToJava(com.j256.ormlite.field.FieldType r7, java.lang.Object r8, int r9) throws java.sql.SQLException {
        /*
            r6 = this;
            r0 = r8
            byte[] r0 = (byte[]) r0
            byte[] r0 = (byte[]) r0
            r11 = r0
            java.io.ObjectInputStream r0 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L34
            r1 = r0
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L34
            r3 = r2
            r4 = r11
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L34
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L34
            r8 = r0
            r0 = r8
            r7 = r0
            r0 = r8
            java.lang.Object r0 = r0.readObject()     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L86
            r10 = r0
            r0 = r8
            r0.close()     // Catch: java.io.IOException -> L97
            r0 = r10
            return r0
        L29:
            r10 = move-exception
            goto L38
        L2e:
            r7 = move-exception
            r0 = 0
            r8 = r0
            goto L8d
        L34:
            r10 = move-exception
            r0 = 0
            r8 = r0
        L38:
            r0 = r8
            r7 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L86
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L86
            r12 = r0
            r0 = r8
            r7 = r0
            r0 = r12
            java.lang.String r1 = "Could not read serialized object from byte array: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L86
            r0 = r8
            r7 = r0
            r0 = r12
            r1 = r11
            java.lang.String r1 = java.util.Arrays.toString(r1)     // Catch: java.lang.Throwable -> L86
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L86
            r0 = r8
            r7 = r0
            r0 = r12
            java.lang.String r1 = "(len "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L86
            r0 = r8
            r7 = r0
            r0 = r12
            r1 = r11
            int r1 = r1.length     // Catch: java.lang.Throwable -> L86
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L86
            r0 = r8
            r7 = r0
            r0 = r12
            java.lang.String r1 = ")"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L86
            r0 = r8
            r7 = r0
            r0 = r12
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L86
            r1 = r10
            java.sql.SQLException r0 = com.j256.ormlite.misc.SqlExceptionUtil.create(r0, r1)     // Catch: java.lang.Throwable -> L86
            throw r0     // Catch: java.lang.Throwable -> L86
        L86:
            r10 = move-exception
            r0 = r7
            r8 = r0
            r0 = r10
            r7 = r0
        L8d:
            r0 = r8
            if (r0 == 0) goto L95
            r0 = r8
            r0.close()     // Catch: java.io.IOException -> L9b
        L95:
            r0 = r7
            throw r0
        L97:
            r7 = move-exception
            r0 = r10
            return r0
        L9b:
            r8 = move-exception
            goto L95
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.field.types.SerializableType.sqlArgToJava(com.j256.ormlite.field.FieldType, java.lang.Object, int):java.lang.Object");
    }
}
