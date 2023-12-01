package com.tencent.beacon.event.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.opos.acs.st.utils.ErrorContants;
import com.tencent.beacon.a.b.g;
import com.tencent.beacon.a.d.c;
import com.tencent.beacon.a.d.d;
import com.tencent.beacon.event.EventBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/a/a.class */
public class a implements d<EventBean> {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f35033a;
    private final SQLiteStatement b;

    /* renamed from: c  reason: collision with root package name */
    private final SQLiteStatement f35034c;
    private final Object d = new Object();
    private final Object e = new Object();
    private com.tencent.beacon.event.c.b f = com.tencent.beacon.event.c.b.a();
    private SQLiteDatabase g;
    private SQLiteDatabase h;
    private long i;
    private long j;

    private a() {
        c cVar = new c(com.tencent.beacon.a.c.b.c(com.tencent.beacon.a.c.c.d().c()));
        this.g = cVar.getWritableDatabase();
        SQLiteDatabase readableDatabase = cVar.getReadableDatabase();
        this.h = readableDatabase;
        this.b = readableDatabase.compileStatement("INSERT INTO t_r_e (_appKey,_time,_length,_data )VALUES(?,?,?,?)");
        this.f35034c = this.h.compileStatement("INSERT INTO t_n_e (_appKey,_time,_length,_data )VALUES(?,?,?,?)");
        this.i = a("t_r_e");
        long a2 = a("t_n_e");
        this.j = a2;
        if (this.i == 0 && a2 == 0) {
            return;
        }
        String str = " realtime: " + this.i + ", normal: " + this.j;
        com.tencent.beacon.base.util.c.a("[EventDAO]", str, new Object[0]);
        g.e().a(ErrorContants.LOCAL_DE_ERROR, "[EventDAO]" + str);
    }

    public static a a() {
        if (f35033a == null) {
            synchronized (a.class) {
                try {
                    if (f35033a == null) {
                        f35033a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f35033a;
    }

    private List<EventBean> a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            b bVar = new b();
            bVar.f35035a = cursor.getLong(0);
            bVar.d = cursor.getString(1);
            bVar.b = cursor.getInt(2);
            bVar.f35036c = cursor.getLong(3);
            bVar.e = cursor.getBlob(4);
            arrayList.add(this.f.c().a(bVar));
        }
        if (!cursor.isClosed()) {
            cursor.close();
        }
        return arrayList;
    }

    private void a(boolean z, boolean z2, long j) {
        if (z) {
            synchronized (this.d) {
                if (z2) {
                    this.i += j;
                } else {
                    this.i -= j;
                }
                com.tencent.beacon.base.util.c.a("[EventDAO]", "current db realtime:%s", Long.valueOf(this.i));
            }
            return;
        }
        synchronized (this.e) {
            if (z2) {
                this.j += j;
            } else {
                this.j -= j;
            }
            com.tencent.beacon.base.util.c.a("[EventDAO]", "current db normal:%s", Long.valueOf(this.j));
        }
    }

    public long a(String str) {
        long j;
        long j2 = null;
        Cursor cursor = null;
        try {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT count(?) FROM ");
                sb.append(str);
                Cursor rawQuery = this.h.rawQuery(sb.toString(), new String[]{"_id"});
                rawQuery.moveToFirst();
                j2 = rawQuery;
                cursor = rawQuery;
                long j3 = rawQuery.getLong(0);
                j = j3;
                if (rawQuery != null) {
                    j = j3;
                    if (!rawQuery.isClosed()) {
                        rawQuery.close();
                        return j3;
                    }
                }
            } catch (Exception e) {
                g e2 = g.e();
                Cursor cursor2 = cursor;
                StringBuilder sb2 = new StringBuilder();
                Cursor cursor3 = cursor;
                sb2.append("type: ");
                Cursor cursor4 = cursor;
                sb2.append(str);
                Cursor cursor5 = cursor;
                sb2.append(" query err: ");
                Cursor cursor6 = cursor;
                sb2.append(e.getMessage());
                Cursor cursor7 = cursor;
                e2.a(ErrorContants.THIRD_PARTY_ST, sb2.toString(), e);
                j2 = cursor;
                com.tencent.beacon.base.util.c.a(e);
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                j = -1;
            }
            return j2;
        } finally {
            if (j2 != null && !j2.isClosed()) {
                j2.close();
            }
        }
    }

    public List<EventBean> a(String str, String str2, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        List<EventBean> list = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" SELECT * FROM ");
            sb.append(str);
            sb.append(" WHERE ");
            sb.append("_id");
            sb.append(" NOT IN (");
            sb.append(str2);
            sb.append(") ORDER BY ");
            sb.append("_time");
            sb.append(" DESC LIMIT ");
            sb.append(i);
            list = a(this.h.rawQuery(sb.toString(), null));
        } catch (Exception e) {
            com.tencent.beacon.base.util.c.a(e);
            g.e().a(ErrorContants.THIRD_PARTY_ST, "type: " + str + " query err: " + e.getMessage(), e);
        }
        com.tencent.beacon.base.util.c.a("[EventDAO]", "query tableName: %s, args: %s", str, str2);
        com.tencent.beacon.base.util.c.a("[EventDAO]", "query cost time: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return list;
    }

    public boolean a(int i) {
        boolean z;
        boolean z2 = false;
        if (i == 1) {
            synchronized (this.d) {
                if (this.i >= com.tencent.beacon.e.b.a().b()) {
                    z2 = true;
                }
            }
            return z2;
        }
        synchronized (this.e) {
            z = false;
            if (this.j >= com.tencent.beacon.e.b.a().b()) {
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00bd, code lost:
        if (r6.f35034c.executeInsert() >= 0) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.tencent.beacon.event.EventBean r7) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.beacon.event.a.a.a(com.tencent.beacon.event.EventBean):boolean");
    }

    public boolean a(String str, String str2) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("_id IN (");
            sb.append(str2);
            sb.append(")");
            int delete = this.g.delete(str, sb.toString(), null);
            a(str.equals("t_r_e"), false, delete);
            return delete >= 0;
        } catch (Exception e) {
            g e2 = g.e();
            e2.a(ErrorContants.LOCAL_EN_ERROR, "type: " + str + " delete err: " + e.getMessage() + " target: " + str2, e);
            com.tencent.beacon.base.util.c.a(e);
            return false;
        }
    }

    public Map<String, Integer> b(String str) {
        Cursor rawQuery;
        HashMap hashMap = new HashMap();
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT _appKey,count(_appKey) FROM ");
                sb.append(str);
                sb.append(" GROUP BY ");
                sb.append("_appKey");
                rawQuery = this.h.rawQuery(sb.toString(), null);
            } catch (Exception e) {
                g e2 = g.e();
                Cursor cursor3 = cursor2;
                StringBuilder sb2 = new StringBuilder();
                Cursor cursor4 = cursor2;
                sb2.append("type: ");
                Cursor cursor5 = cursor2;
                sb2.append(str);
                Cursor cursor6 = cursor2;
                sb2.append(" query err: ");
                Cursor cursor7 = cursor2;
                sb2.append(e.getMessage());
                Cursor cursor8 = cursor2;
                e2.a(ErrorContants.THIRD_PARTY_ST, sb2.toString(), e);
                Cursor cursor9 = cursor2;
                com.tencent.beacon.base.util.c.a(e);
                if (cursor2 != null && !cursor2.isClosed()) {
                    cursor2.close();
                }
            }
            if (!rawQuery.moveToFirst()) {
                if (rawQuery != null) {
                    rawQuery.close();
                    return hashMap;
                }
                return hashMap;
            }
            do {
                cursor = rawQuery;
                cursor2 = rawQuery;
                hashMap.put(rawQuery.getString(0), Integer.valueOf(rawQuery.getInt(1)));
            } while (rawQuery.moveToNext());
            if (rawQuery != null && !rawQuery.isClosed()) {
                rawQuery.close();
                return hashMap;
            }
            return hashMap;
        } catch (Throwable th) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
    }
}
