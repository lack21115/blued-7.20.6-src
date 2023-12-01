package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/stmt/mapped/MappedCreate.class */
public class MappedCreate<T, ID> extends BaseMappedStatement<T, ID> {
    private String dataClassName;
    private final String queryNextSequenceStmt;
    private int versionFieldTypeIndex;

    /* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/stmt/mapped/MappedCreate$KeyHolder.class */
    static class KeyHolder implements GeneratedKeyHolder {
        Number key;

        private KeyHolder() {
        }

        @Override // com.j256.ormlite.support.GeneratedKeyHolder
        public void addKey(Number number) throws SQLException {
            if (this.key == null) {
                this.key = number;
                return;
            }
            throw new SQLException("generated key has already been set to " + this.key + ", now set to " + number);
        }

        public Number getKey() {
            return this.key;
        }
    }

    private MappedCreate(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, String str2, int i) {
        super(tableInfo, str, fieldTypeArr);
        this.dataClassName = tableInfo.getDataClass().getSimpleName();
        this.queryNextSequenceStmt = str2;
        this.versionFieldTypeIndex = i;
    }

    private void assignIdValue(T t, Number number, String str, ObjectCache objectCache) throws SQLException {
        this.idField.assignIdValue(t, number, objectCache);
        if (logger.isLevelEnabled(Log.Level.DEBUG)) {
            logger.debug("assigned id '{}' from {} to '{}' in {} object", new Object[]{number, str, this.idField.getFieldName(), this.dataClassName});
        }
    }

    private void assignSequenceId(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        long queryForLong = databaseConnection.queryForLong(this.queryNextSequenceStmt);
        logger.debug("queried for sequence {} using stmt: {}", Long.valueOf(queryForLong), this.queryNextSequenceStmt);
        if (queryForLong != 0) {
            assignIdValue(t, Long.valueOf(queryForLong), "sequence", objectCache);
            return;
        }
        throw new SQLException("Should not have returned 0 for stmt: " + this.queryNextSequenceStmt);
    }

    public static <T, ID> MappedCreate<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) {
        int i;
        FieldType[] fieldTypes;
        StringBuilder sb = new StringBuilder(128);
        appendTableName(databaseType, sb, "INSERT INTO ", tableInfo.getTableName());
        FieldType[] fieldTypes2 = tableInfo.getFieldTypes();
        int length = fieldTypes2.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        while (true) {
            i = i4;
            if (i2 >= length) {
                break;
            }
            FieldType fieldType = fieldTypes2[i2];
            int i5 = i3;
            int i6 = i;
            if (isFieldCreatable(databaseType, fieldType)) {
                if (fieldType.isVersion()) {
                    i = i3;
                }
                i5 = i3 + 1;
                i6 = i;
            }
            i2++;
            i3 = i5;
            i4 = i6;
        }
        FieldType[] fieldTypeArr = new FieldType[i3];
        if (i3 == 0) {
            databaseType.appendInsertNoColumns(sb);
        } else {
            sb.append('(');
            boolean z = true;
            int i7 = 0;
            for (FieldType fieldType2 : tableInfo.getFieldTypes()) {
                if (isFieldCreatable(databaseType, fieldType2)) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(",");
                    }
                    appendFieldColumnName(databaseType, sb, fieldType2, null);
                    fieldTypeArr[i7] = fieldType2;
                    i7++;
                }
            }
            sb.append(") VALUES (");
            boolean z2 = true;
            for (FieldType fieldType3 : tableInfo.getFieldTypes()) {
                if (isFieldCreatable(databaseType, fieldType3)) {
                    if (z2) {
                        z2 = false;
                    } else {
                        sb.append(",");
                    }
                    sb.append("?");
                }
            }
            sb.append(")");
        }
        return new MappedCreate<>(tableInfo, sb.toString(), fieldTypeArr, buildQueryNextSequence(databaseType, tableInfo.getIdField()), i);
    }

    private static String buildQueryNextSequence(DatabaseType databaseType, FieldType fieldType) {
        String generatedIdSequence;
        if (fieldType == null || (generatedIdSequence = fieldType.getGeneratedIdSequence()) == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(64);
        databaseType.appendSelectNextValFromSequence(sb, generatedIdSequence);
        return sb.toString();
    }

    private boolean foreignCollectionsAreAssigned(FieldType[] fieldTypeArr, Object obj) throws SQLException {
        int length = fieldTypeArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (fieldTypeArr[i2].extractJavaFieldValue(obj) == null) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private static boolean isFieldCreatable(DatabaseType databaseType, FieldType fieldType) {
        if (fieldType.isForeignCollection() || fieldType.isReadOnly()) {
            return false;
        }
        return (databaseType.isIdSequenceNeeded() && databaseType.isSelectSequenceBeforeInsert()) || !fieldType.isGeneratedId() || fieldType.isSelfGeneratedId() || fieldType.isAllowGeneratedIdInsert();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009d A[Catch: SQLException -> 0x0211, TRY_LEAVE, TryCatch #0 {SQLException -> 0x0211, blocks: (B:30:0x0093, B:32:0x009d, B:37:0x00bc, B:40:0x00c7, B:42:0x00d4, B:44:0x00e1, B:45:0x00ec, B:47:0x00fa, B:49:0x0104, B:52:0x013e, B:53:0x0141, B:55:0x015c, B:60:0x0171, B:63:0x0186, B:65:0x018f, B:67:0x0198, B:68:0x01a6, B:69:0x01b0, B:70:0x01b1, B:71:0x01b4, B:72:0x01bb, B:75:0x01c1, B:77:0x01d0, B:80:0x01ea, B:82:0x0204, B:84:0x0210, B:51:0x012b), top: B:91:0x0093, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015c A[Catch: SQLException -> 0x0211, TryCatch #0 {SQLException -> 0x0211, blocks: (B:30:0x0093, B:32:0x009d, B:37:0x00bc, B:40:0x00c7, B:42:0x00d4, B:44:0x00e1, B:45:0x00ec, B:47:0x00fa, B:49:0x0104, B:52:0x013e, B:53:0x0141, B:55:0x015c, B:60:0x0171, B:63:0x0186, B:65:0x018f, B:67:0x0198, B:68:0x01a6, B:69:0x01b0, B:70:0x01b1, B:71:0x01b4, B:72:0x01bb, B:75:0x01c1, B:77:0x01d0, B:80:0x01ea, B:82:0x0204, B:84:0x0210, B:51:0x012b), top: B:91:0x0093, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x016c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int insert(com.j256.ormlite.db.DatabaseType r7, com.j256.ormlite.support.DatabaseConnection r8, T r9, com.j256.ormlite.dao.ObjectCache r10) throws java.sql.SQLException {
        /*
            Method dump skipped, instructions count: 590
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.stmt.mapped.MappedCreate.insert(com.j256.ormlite.db.DatabaseType, com.j256.ormlite.support.DatabaseConnection, java.lang.Object, com.j256.ormlite.dao.ObjectCache):int");
    }
}
