package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.BaseForeignCollection;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/stmt/mapped/BaseMappedQuery.class */
public abstract class BaseMappedQuery<T, ID> extends BaseMappedStatement<T, ID> implements GenericRowMapper<T> {
    private Map<String, Integer> columnPositions;
    private Object parent;
    private Object parentId;
    protected final FieldType[] resultsFieldTypes;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseMappedQuery(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, FieldType[] fieldTypeArr2) {
        super(tableInfo, str, fieldTypeArr);
        this.columnPositions = null;
        this.parent = null;
        this.parentId = null;
        this.resultsFieldTypes = fieldTypeArr2;
    }

    @Override // com.j256.ormlite.stmt.GenericRowMapper
    public T mapRow(DatabaseResults databaseResults) throws SQLException {
        boolean z;
        BaseForeignCollection buildForeignCollection;
        boolean z2;
        Map<String, Integer> map = this.columnPositions;
        HashMap hashMap = map;
        if (map == null) {
            hashMap = new HashMap();
        }
        ObjectCache objectCache = databaseResults.getObjectCache();
        if (objectCache != null) {
            T t = (T) objectCache.get(this.clazz, this.idField.resultToJava(databaseResults, hashMap));
            if (t != null) {
                return t;
            }
        }
        T createObject = this.tableInfo.createObject();
        Object obj = null;
        FieldType[] fieldTypeArr = this.resultsFieldTypes;
        int length = fieldTypeArr.length;
        int i = 0;
        boolean z3 = false;
        while (true) {
            z = z3;
            if (i >= length) {
                break;
            }
            FieldType fieldType = fieldTypeArr[i];
            if (fieldType.isForeignCollection()) {
                z2 = true;
            } else {
                Object resultToJava = fieldType.resultToJava(databaseResults, hashMap);
                if (resultToJava == null || this.parent == null || fieldType.getField().getType() != this.parent.getClass() || !resultToJava.equals(this.parentId)) {
                    fieldType.assignField(createObject, resultToJava, false, objectCache);
                } else {
                    fieldType.assignField(createObject, this.parent, true, objectCache);
                }
                z2 = z;
                if (fieldType == this.idField) {
                    obj = resultToJava;
                    z2 = z;
                }
            }
            i++;
            z3 = z2;
        }
        if (z) {
            FieldType[] fieldTypeArr2 = this.resultsFieldTypes;
            int length2 = fieldTypeArr2.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length2) {
                    break;
                }
                FieldType fieldType2 = fieldTypeArr2[i3];
                if (fieldType2.isForeignCollection() && (buildForeignCollection = fieldType2.buildForeignCollection(createObject, obj)) != null) {
                    fieldType2.assignField(createObject, buildForeignCollection, false, objectCache);
                }
                i2 = i3 + 1;
            }
        }
        if (objectCache != 0 && obj != null) {
            objectCache.put(this.clazz, obj, createObject);
        }
        if (this.columnPositions == null) {
            this.columnPositions = hashMap;
        }
        return createObject;
    }

    public void setParentInformation(Object obj, Object obj2) {
        this.parent = obj;
        this.parentId = obj2;
    }
}
