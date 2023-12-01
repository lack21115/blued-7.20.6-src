package com.sobot.network.http.db;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/db/StTableEntity.class */
public class StTableEntity {
    private List<StColumnEntity> list = new ArrayList();
    public String tableName;

    public StTableEntity(String str) {
        this.tableName = str;
    }

    public StTableEntity addColumn(StColumnEntity stColumnEntity) {
        this.list.add(stColumnEntity);
        return this;
    }

    public String buildTableString() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(this.tableName);
        sb.append('(');
        for (StColumnEntity stColumnEntity : this.list) {
            if (stColumnEntity.compositePrimaryKey != null) {
                sb.append("PRIMARY KEY (");
                String[] strArr = stColumnEntity.compositePrimaryKey;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    sb.append(strArr[i2]);
                    sb.append(",");
                    i = i2 + 1;
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append(")");
            } else {
                sb.append(stColumnEntity.columnName);
                sb.append(" ");
                sb.append(stColumnEntity.columnType);
                if (stColumnEntity.isNotNull) {
                    sb.append(" NOT NULL");
                }
                if (stColumnEntity.isPrimary) {
                    sb.append(" PRIMARY KEY");
                }
                if (stColumnEntity.isAutoincrement) {
                    sb.append(" AUTOINCREMENT");
                }
                sb.append(",");
            }
        }
        if (sb.toString().endsWith(",")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(')');
        return sb.toString();
    }

    public int getColumnCount() {
        return this.list.size();
    }

    public int getColumnIndex(String str) {
        int columnCount = getColumnCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= columnCount) {
                return -1;
            }
            if (this.list.get(i2).columnName.equals(str)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public String getColumnName(int i) {
        return this.list.get(i).columnName;
    }
}
