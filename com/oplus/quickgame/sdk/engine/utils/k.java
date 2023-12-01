package com.oplus.quickgame.sdk.engine.utils;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/k.class */
public class k {
    private static Map<String, Object> a(Cursor cursor) throws Throwable {
        HashMap hashMap = new HashMap();
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return hashMap;
        }
        do {
            hashMap.putAll(c(cursor));
        } while (cursor.moveToNext());
        return hashMap;
    }

    public static Map<String, Object> b(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        try {
            Map<String, Object> a2 = a(cursor);
            try {
                cursor.close();
                return a2;
            } catch (Throwable th) {
                th.printStackTrace();
                return a2;
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                try {
                    cursor.close();
                    return null;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return null;
                }
            } catch (Throwable th4) {
                try {
                    cursor.close();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                throw th4;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.lang.Double] */
    private static Map<String, Object> c(Cursor cursor) {
        String valueOf;
        HashMap hashMap = new HashMap();
        String[] columnNames = cursor.getColumnNames();
        int length = columnNames.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return hashMap;
            }
            String str = columnNames[i2];
            int columnIndex = cursor.getColumnIndex(str);
            int type = cursor.getType(columnIndex);
            if (type == 1) {
                valueOf = Long.valueOf(cursor.getLong(columnIndex));
            } else if (type == 2) {
                valueOf = Double.valueOf(cursor.getDouble(columnIndex));
            } else if (type != 3) {
                if (type == 4) {
                    hashMap.put(str, cursor.getBlob(columnIndex));
                }
                i = i2 + 1;
            } else {
                valueOf = cursor.getString(columnIndex);
            }
            hashMap.put(str, valueOf);
            i = i2 + 1;
        }
    }
}
