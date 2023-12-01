package com.getui.gtc.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.getui.gtc.base.db.AbstractTable;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/e/a.class */
public class a extends AbstractTable {

    /* renamed from: a  reason: collision with root package name */
    private SparseArray<Long> f8386a = new SparseArray<>();
    private SparseArray<Long> b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private SparseIntArray f8387c = new SparseIntArray();

    public final long a(int i) {
        Long l = this.f8386a.get(i);
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final void a(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationStyle.EXPANDABLE_IMAGE_URL, Integer.valueOf(i));
        contentValues.put("elt", String.valueOf(j));
        if (replace(null, contentValues) != -1) {
            this.f8386a.put(i, Long.valueOf(j));
        }
    }

    public final void a(int i, long j, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationStyle.EXPANDABLE_IMAGE_URL, Integer.valueOf(i));
        contentValues.put("est", String.valueOf(j));
        contentValues.put("esn", Integer.valueOf(i2));
        if (replace(null, contentValues) != -1) {
            this.b.put(i, Long.valueOf(j));
            this.f8387c.put(i, i2);
        }
    }

    public final long b(int i) {
        Long l = this.b.get(i);
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final int c(int i) {
        return this.f8387c.get(i);
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public String createSql() {
        return "CREATE TABLE IF NOT EXISTS e (ei INTEGER PRIMARY KEY, elt TEXT, est TEXT, esn INTEGER)";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public String getTableName() {
        return "e";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public void initCache() {
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                Cursor query = query(new String[]{NotificationStyle.EXPANDABLE_IMAGE_URL, "elt", "est", "esn"}, null, null);
                if (query == null) {
                    if (query != null) {
                        query.close();
                        return;
                    }
                    return;
                }
                while (true) {
                    cursor2 = query;
                    cursor = query;
                    if (!query.moveToNext()) {
                        break;
                    }
                    int i = query.getInt(query.getColumnIndex(NotificationStyle.EXPANDABLE_IMAGE_URL));
                    try {
                        this.f8386a.put(i, Long.valueOf(Long.parseLong(query.getString(query.getColumnIndex("elt")))));
                    } catch (Exception e) {
                    }
                    try {
                        this.b.put(i, Long.valueOf(Long.parseLong(query.getString(query.getColumnIndex("est")))));
                    } catch (Exception e2) {
                    }
                    this.f8387c.put(i, query.getInt(query.getColumnIndex("esn")));
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            cursor = cursor2;
            com.getui.gtc.i.c.a.a(e3);
            if (cursor2 != null) {
                cursor2.close();
            }
        }
    }
}
