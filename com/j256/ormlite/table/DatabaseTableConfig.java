package com.j256.ormlite.table;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.JavaxPersistence;
import com.j256.ormlite.support.ConnectionSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/table/DatabaseTableConfig.class */
public class DatabaseTableConfig<T> {
    private Constructor<T> constructor;
    private Class<T> dataClass;
    private List<DatabaseFieldConfig> fieldConfigs;
    private FieldType[] fieldTypes;
    private String tableName;

    public DatabaseTableConfig() {
    }

    public DatabaseTableConfig(Class<T> cls, String str, List<DatabaseFieldConfig> list) {
        this.dataClass = cls;
        this.tableName = str;
        this.fieldConfigs = list;
    }

    private DatabaseTableConfig(Class<T> cls, String str, FieldType[] fieldTypeArr) {
        this.dataClass = cls;
        this.tableName = str;
        this.fieldTypes = fieldTypeArr;
    }

    public DatabaseTableConfig(Class<T> cls, List<DatabaseFieldConfig> list) {
        this(cls, extractTableName(cls), list);
    }

    private FieldType[] convertFieldConfigs(ConnectionSource connectionSource, String str, List<DatabaseFieldConfig> list) throws SQLException {
        FieldType fieldType;
        Field declaredField;
        ArrayList arrayList = new ArrayList();
        for (DatabaseFieldConfig databaseFieldConfig : list) {
            Class<T> cls = this.dataClass;
            while (true) {
                Class<T> cls2 = cls;
                fieldType = null;
                if (cls2 == null) {
                    break;
                }
                try {
                    declaredField = cls2.getDeclaredField(databaseFieldConfig.getFieldName());
                } catch (NoSuchFieldException e) {
                }
                if (declaredField != null) {
                    fieldType = new FieldType(connectionSource, str, declaredField, databaseFieldConfig, this.dataClass);
                    break;
                }
                cls = cls2.getSuperclass();
            }
            if (fieldType == null) {
                throw new SQLException("Could not find declared field with name '" + databaseFieldConfig.getFieldName() + "' for " + this.dataClass);
            }
            arrayList.add(fieldType);
        }
        if (arrayList.isEmpty()) {
            throw new SQLException("No fields were configured for class " + this.dataClass);
        }
        return (FieldType[]) arrayList.toArray(new FieldType[arrayList.size()]);
    }

    private static <T> FieldType[] extractFieldTypes(ConnectionSource connectionSource, Class<T> cls, String str) throws SQLException {
        ArrayList arrayList = new ArrayList();
        Class<T> cls2 = cls;
        while (true) {
            Class<T> cls3 = cls2;
            if (cls3 == null) {
                break;
            }
            Field[] declaredFields = cls3.getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length) {
                    FieldType createFieldType = FieldType.createFieldType(connectionSource, str, declaredFields[i2], cls);
                    if (createFieldType != null) {
                        arrayList.add(createFieldType);
                    }
                    i = i2 + 1;
                }
            }
            cls2 = cls3.getSuperclass();
        }
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("No fields have a " + DatabaseField.class.getSimpleName() + " annotation in " + cls);
        }
        return (FieldType[]) arrayList.toArray(new FieldType[arrayList.size()]);
    }

    public static <T> String extractTableName(Class<T> cls) {
        DatabaseTable databaseTable = (DatabaseTable) cls.getAnnotation(DatabaseTable.class);
        if (databaseTable == null || databaseTable.tableName() == null || databaseTable.tableName().length() <= 0) {
            String entityName = JavaxPersistence.getEntityName(cls);
            return entityName == null ? cls.getSimpleName().toLowerCase() : entityName;
        }
        return databaseTable.tableName();
    }

    public static <T> Constructor<T> findNoArgConstructor(Class<T> cls) {
        try {
            Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            int length = declaredConstructors.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    if (cls.getEnclosingClass() == null) {
                        throw new IllegalArgumentException("Can't find a no-arg constructor for " + cls);
                    }
                    throw new IllegalArgumentException("Can't find a no-arg constructor for " + cls + ".  Missing static on inner class?");
                }
                Constructor<T> constructor = (Constructor<T>) declaredConstructors[i2];
                if (constructor.getParameterTypes().length == 0) {
                    if (constructor.isAccessible()) {
                        return constructor;
                    }
                    try {
                        constructor.setAccessible(true);
                        return constructor;
                    } catch (SecurityException e) {
                        throw new IllegalArgumentException("Could not open access to constructor for " + cls);
                    }
                }
                i = i2 + 1;
            }
        } catch (Exception e2) {
            throw new IllegalArgumentException("Can't lookup declared constructors for " + cls, e2);
        }
    }

    public static <T> DatabaseTableConfig<T> fromClass(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        String extractTableName = extractTableName(cls);
        String str = extractTableName;
        if (connectionSource.getDatabaseType().isEntityNamesMustBeUpCase()) {
            str = extractTableName.toUpperCase();
        }
        return new DatabaseTableConfig<>(cls, str, extractFieldTypes(connectionSource, cls, str));
    }

    public void extractFieldTypes(ConnectionSource connectionSource) throws SQLException {
        if (this.fieldTypes == null) {
            List<DatabaseFieldConfig> list = this.fieldConfigs;
            if (list == null) {
                this.fieldTypes = extractFieldTypes(connectionSource, this.dataClass, this.tableName);
            } else {
                this.fieldTypes = convertFieldConfigs(connectionSource, this.tableName, list);
            }
        }
    }

    public Constructor<T> getConstructor() {
        if (this.constructor == null) {
            this.constructor = findNoArgConstructor(this.dataClass);
        }
        return this.constructor;
    }

    public Class<T> getDataClass() {
        return this.dataClass;
    }

    public List<DatabaseFieldConfig> getFieldConfigs() {
        return this.fieldConfigs;
    }

    public FieldType[] getFieldTypes(DatabaseType databaseType) throws SQLException {
        FieldType[] fieldTypeArr = this.fieldTypes;
        if (fieldTypeArr != null) {
            return fieldTypeArr;
        }
        throw new SQLException("Field types have not been extracted in table config");
    }

    public String getTableName() {
        return this.tableName;
    }

    public void initialize() {
        Class<T> cls = this.dataClass;
        if (cls != null) {
            if (this.tableName == null) {
                this.tableName = extractTableName(cls);
                return;
            }
            return;
        }
        throw new IllegalStateException("dataClass was never set on " + getClass().getSimpleName());
    }

    public void setConstructor(Constructor<T> constructor) {
        this.constructor = constructor;
    }

    public void setDataClass(Class<T> cls) {
        this.dataClass = cls;
    }

    public void setFieldConfigs(List<DatabaseFieldConfig> list) {
        this.fieldConfigs = list;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }
}
