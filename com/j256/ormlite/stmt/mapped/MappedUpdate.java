package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/stmt/mapped/MappedUpdate.class */
public class MappedUpdate<T, ID> extends BaseMappedStatement<T, ID> {
    private final FieldType versionFieldType;
    private final int versionFieldTypeIndex;

    private MappedUpdate(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, FieldType fieldType, int i) {
        super(tableInfo, str, fieldTypeArr);
        this.versionFieldType = fieldType;
        this.versionFieldTypeIndex = i;
    }

    public static <T, ID> MappedUpdate<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) throws SQLException {
        int i;
        FieldType[] fieldTypes;
        FieldType idField = tableInfo.getIdField();
        if (idField == null) {
            throw new SQLException("Cannot update " + tableInfo.getDataClass() + " because it doesn't have an id field");
        }
        StringBuilder sb = new StringBuilder(64);
        appendTableName(databaseType, sb, "UPDATE ", tableInfo.getTableName());
        FieldType[] fieldTypes2 = tableInfo.getFieldTypes();
        int length = fieldTypes2.length;
        FieldType fieldType = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        while (true) {
            i = i4;
            if (i2 >= length) {
                break;
            }
            FieldType fieldType2 = fieldTypes2[i2];
            int i5 = i3;
            FieldType fieldType3 = fieldType;
            int i6 = i;
            if (isFieldUpdatable(fieldType2, idField)) {
                if (fieldType2.isVersion()) {
                    i = i3;
                    fieldType = fieldType2;
                }
                i5 = i3 + 1;
                i6 = i;
                fieldType3 = fieldType;
            }
            i2++;
            i3 = i5;
            fieldType = fieldType3;
            i4 = i6;
        }
        int i7 = i3 + 1;
        int i8 = i7;
        if (fieldType != null) {
            i8 = i7 + 1;
        }
        FieldType[] fieldTypeArr = new FieldType[i8];
        int i9 = 0;
        boolean z = true;
        for (FieldType fieldType4 : tableInfo.getFieldTypes()) {
            if (isFieldUpdatable(fieldType4, idField)) {
                if (z) {
                    sb.append("SET ");
                    z = false;
                } else {
                    sb.append(", ");
                }
                appendFieldColumnName(databaseType, sb, fieldType4, null);
                fieldTypeArr[i9] = fieldType4;
                sb.append("= ?");
                i9++;
            }
        }
        sb.append(' ');
        appendWhereFieldEq(databaseType, idField, sb, null);
        fieldTypeArr[i9] = idField;
        if (fieldType != null) {
            sb.append(" AND ");
            appendFieldColumnName(databaseType, sb, fieldType, null);
            sb.append("= ?");
            fieldTypeArr[i9 + 1] = fieldType;
        }
        return new MappedUpdate<>(tableInfo, sb.toString(), fieldTypeArr, fieldType, i);
    }

    private static boolean isFieldUpdatable(FieldType fieldType, FieldType fieldType2) {
        return (fieldType == fieldType2 || fieldType.isForeignCollection() || fieldType.isReadOnly()) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int update(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        Object obj;
        try {
            if (this.argFieldTypes.length <= 1) {
                return 0;
            }
            Object[] fieldObjects = getFieldObjects(t);
            if (this.versionFieldType != null) {
                obj = this.versionFieldType.moveToNextValue(this.versionFieldType.extractJavaFieldValue(t));
                fieldObjects[this.versionFieldTypeIndex] = this.versionFieldType.convertJavaFieldToSqlArgValue(obj);
            } else {
                obj = null;
            }
            int update = databaseConnection.update(this.statement, fieldObjects, this.argFieldTypes);
            if (update > 0) {
                if (obj != null) {
                    this.versionFieldType.assignField(t, obj, false, null);
                }
                if (objectCache != 0) {
                    Object obj2 = objectCache.get(this.clazz, this.idField.extractJavaFieldValue(t));
                    if (obj2 != null && obj2 != t) {
                        FieldType[] fieldTypes = this.tableInfo.getFieldTypes();
                        int length = fieldTypes.length;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= length) {
                                break;
                            }
                            FieldType fieldType = fieldTypes[i2];
                            if (fieldType != this.idField) {
                                fieldType.assignField(obj2, fieldType.extractJavaFieldValue(t), false, objectCache);
                            }
                            i = i2 + 1;
                        }
                    }
                }
            }
            logger.debug("update data with statement '{}' and {} args, changed {} rows", this.statement, Integer.valueOf(fieldObjects.length), Integer.valueOf(update));
            if (fieldObjects.length > 0) {
                logger.trace("update arguments: {}", (Object) fieldObjects);
            }
            return update;
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Unable to run update stmt on object " + t + ": " + this.statement, e);
        }
    }
}
