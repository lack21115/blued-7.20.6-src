package com.j256.ormlite.table;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/table/TableInfo.class */
public class TableInfo<T, ID> {
    private static final FieldType[] NO_FOREIGN_COLLECTIONS = new FieldType[0];
    private final BaseDaoImpl<T, ID> baseDaoImpl;
    private final Constructor<T> constructor;
    private final Class<T> dataClass;
    private Map<String, FieldType> fieldNameMap;
    private final FieldType[] fieldTypes;
    private final boolean foreignAutoCreate;
    private final FieldType[] foreignCollections;
    private final FieldType idField;
    private final String tableName;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x005e, code lost:
        if (r0.isGeneratedIdSequence() != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TableInfo(com.j256.ormlite.db.DatabaseType r5, com.j256.ormlite.dao.BaseDaoImpl<T, ID> r6, com.j256.ormlite.table.DatabaseTableConfig<T> r7) throws java.sql.SQLException {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.table.TableInfo.<init>(com.j256.ormlite.db.DatabaseType, com.j256.ormlite.dao.BaseDaoImpl, com.j256.ormlite.table.DatabaseTableConfig):void");
    }

    public TableInfo(ConnectionSource connectionSource, BaseDaoImpl<T, ID> baseDaoImpl, Class<T> cls) throws SQLException {
        this(connectionSource.getDatabaseType(), baseDaoImpl, DatabaseTableConfig.fromClass(connectionSource, cls));
    }

    private static <T, ID> void wireNewInstance(BaseDaoImpl<T, ID> baseDaoImpl, T t) {
        if (t instanceof BaseDaoEnabled) {
            ((BaseDaoEnabled) t).setDao(baseDaoImpl);
        }
    }

    public T createObject() throws SQLException {
        ObjectFactory<T> objectFactory = null;
        try {
            if (this.baseDaoImpl != null) {
                objectFactory = this.baseDaoImpl.getObjectFactory();
            }
            T newInstance = objectFactory == null ? this.constructor.newInstance(new Object[0]) : objectFactory.createObject(this.constructor, this.baseDaoImpl.getDataClass());
            wireNewInstance(this.baseDaoImpl, newInstance);
            return newInstance;
        } catch (Exception e) {
            throw SqlExceptionUtil.create("Could not create object for " + this.constructor.getDeclaringClass(), e);
        }
    }

    public Constructor<T> getConstructor() {
        return this.constructor;
    }

    public Class<T> getDataClass() {
        return this.dataClass;
    }

    public FieldType getFieldTypeByColumnName(String str) {
        FieldType fieldType;
        if (this.fieldNameMap == null) {
            HashMap hashMap = new HashMap();
            FieldType[] fieldTypeArr = this.fieldTypes;
            int length = fieldTypeArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                FieldType fieldType2 = fieldTypeArr[i2];
                hashMap.put(fieldType2.getColumnName().toLowerCase(), fieldType2);
                i = i2 + 1;
            }
            this.fieldNameMap = hashMap;
        }
        FieldType fieldType3 = this.fieldNameMap.get(str.toLowerCase());
        if (fieldType3 != null) {
            return fieldType3;
        }
        FieldType[] fieldTypeArr2 = this.fieldTypes;
        int length2 = fieldTypeArr2.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                throw new IllegalArgumentException("Unknown column name '" + str + "' in table " + this.tableName);
            }
            if (fieldTypeArr2[i4].getFieldName().equals(str)) {
                throw new IllegalArgumentException("You should use columnName '" + fieldType.getColumnName() + "' for table " + this.tableName + " instead of fieldName '" + fieldType.getFieldName() + "'");
            }
            i3 = i4 + 1;
        }
    }

    public FieldType[] getFieldTypes() {
        return this.fieldTypes;
    }

    public FieldType[] getForeignCollections() {
        return this.foreignCollections;
    }

    public FieldType getIdField() {
        return this.idField;
    }

    public String getTableName() {
        return this.tableName;
    }

    public boolean hasColumnName(String str) {
        FieldType[] fieldTypeArr = this.fieldTypes;
        int length = fieldTypeArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (fieldTypeArr[i2].getColumnName().equals(str)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public boolean isForeignAutoCreate() {
        return this.foreignAutoCreate;
    }

    public boolean isUpdatable() {
        return this.idField != null && this.fieldTypes.length > 1;
    }

    public String objectToString(T t) {
        StringBuilder sb = new StringBuilder(64);
        sb.append(t.getClass().getSimpleName());
        FieldType[] fieldTypeArr = this.fieldTypes;
        int length = fieldTypeArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            FieldType fieldType = fieldTypeArr[i2];
            sb.append(' ');
            sb.append(fieldType.getColumnName());
            sb.append("=");
            try {
                sb.append(fieldType.extractJavaFieldValue(t));
                i = i2 + 1;
            } catch (Exception e) {
                throw new IllegalStateException("Could not generate toString of field " + fieldType, e);
            }
        }
    }
}
