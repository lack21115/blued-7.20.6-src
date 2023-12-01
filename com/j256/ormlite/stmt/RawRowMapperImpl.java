package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/stmt/RawRowMapperImpl.class */
public class RawRowMapperImpl<T, ID> implements RawRowMapper<T> {
    private final TableInfo<T, ID> tableInfo;

    public RawRowMapperImpl(TableInfo<T, ID> tableInfo) {
        this.tableInfo = tableInfo;
    }

    @Override // com.j256.ormlite.dao.RawRowMapper
    public T mapRow(String[] strArr, String[] strArr2) throws SQLException {
        T createObject = this.tableInfo.createObject();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return createObject;
            }
            if (i2 < strArr2.length) {
                FieldType fieldTypeByColumnName = this.tableInfo.getFieldTypeByColumnName(strArr[i2]);
                fieldTypeByColumnName.assignField(createObject, fieldTypeByColumnName.convertStringToJavaField(strArr2[i2], i2), false, null);
            }
            i = i2 + 1;
        }
    }
}
