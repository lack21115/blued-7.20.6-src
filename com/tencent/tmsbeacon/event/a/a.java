package com.tencent.tmsbeacon.event.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.opos.acs.st.utils.ErrorContants;
import com.tencent.tmsbeacon.a.d.c;
import com.tencent.tmsbeacon.a.d.d;
import com.tencent.tmsbeacon.event.EventBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/a/a.class */
public class a implements d<EventBean> {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteStatement f25865a;
    private final SQLiteStatement b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f25866c = new Object();
    private final Object d = new Object();
    private com.tencent.tmsbeacon.event.c.b e = com.tencent.tmsbeacon.event.c.b.a();
    private SQLiteDatabase f;
    private SQLiteDatabase g;
    private long h;
    private long i;

    public a() {
        c cVar = new c(com.tencent.tmsbeacon.a.c.b.c(com.tencent.tmsbeacon.a.c.c.d().c()));
        this.f = cVar.getWritableDatabase();
        SQLiteDatabase readableDatabase = cVar.getReadableDatabase();
        this.g = readableDatabase;
        this.f25865a = readableDatabase.compileStatement("INSERT INTO t_r_e (_appKey,_time,_length,_data )VALUES(?,?,?,?)");
        this.b = this.g.compileStatement("INSERT INTO t_n_e (_appKey,_time,_length,_data )VALUES(?,?,?,?)");
        this.h = a("t_r_e");
        long a2 = a("t_n_e");
        this.i = a2;
        if (this.h == 0 && a2 == 0) {
            return;
        }
        String str = " realtime: " + this.h + ", normal: " + this.i;
        com.tencent.tmsbeacon.base.util.c.a("[EventDAO]", str, new Object[0]);
        com.tencent.tmsbeacon.a.b.d.b().a(ErrorContants.LOCAL_DE_ERROR, "[EventDAO]" + str);
    }

    private List<EventBean> a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            b bVar = new b();
            bVar.f25867a = cursor.getLong(0);
            bVar.d = cursor.getString(1);
            bVar.b = cursor.getInt(2);
            bVar.f25868c = cursor.getLong(3);
            bVar.e = cursor.getBlob(4);
            arrayList.add(this.e.c().a(bVar));
        }
        if (!cursor.isClosed()) {
            cursor.close();
        }
        return arrayList;
    }

    private void a(boolean z, boolean z2, long j) {
        if (z) {
            synchronized (this.f25866c) {
                if (z2) {
                    this.h += j;
                } else {
                    this.h -= j;
                }
                com.tencent.tmsbeacon.base.util.c.a("[EventDAO]", "current db realtime:%s", Long.valueOf(this.h));
            }
            return;
        }
        synchronized (this.d) {
            if (z2) {
                this.i += j;
            } else {
                this.i -= j;
            }
            com.tencent.tmsbeacon.base.util.c.a("[EventDAO]", "current db normal:%s", Long.valueOf(this.i));
        }
    }

    public long a(String str) {
        long j;
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT count(?) FROM ");
                sb.append(str);
                Cursor rawQuery = this.g.rawQuery(sb.toString(), new String[]{"_id"});
                rawQuery.moveToFirst();
                cursor = rawQuery;
                cursor2 = rawQuery;
                long j2 = rawQuery.getLong(0);
                j = j2;
                if (!rawQuery.isClosed()) {
                    rawQuery.close();
                    return j2;
                }
            } catch (Exception e) {
                com.tencent.tmsbeacon.a.b.d b = com.tencent.tmsbeacon.a.b.d.b();
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
                b.a(ErrorContants.THIRD_PARTY_ST, sb2.toString(), e);
                cursor = cursor2;
                com.tencent.tmsbeacon.base.util.c.a(e);
                if (cursor2 != null && !cursor2.isClosed()) {
                    cursor2.close();
                }
                j = -1;
            }
            return j;
        } catch (Throwable th) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
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
            list = a(this.g.rawQuery(sb.toString(), null));
        } catch (Exception e) {
            com.tencent.tmsbeacon.base.util.c.a(e);
            com.tencent.tmsbeacon.a.b.d.b().a(ErrorContants.THIRD_PARTY_ST, "type: " + str + " query err: " + e.getMessage(), e);
        }
        com.tencent.tmsbeacon.base.util.c.a("[EventDAO]", "query tableName: %s, args: %s", str, str2);
        com.tencent.tmsbeacon.base.util.c.a("[EventDAO]", "query cost time: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return list;
    }

    public boolean a(int i) {
        boolean z;
        boolean z2 = false;
        if (i == 1) {
            synchronized (this.f25866c) {
                if (this.h >= com.tencent.tmsbeacon.d.b.a().b()) {
                    z2 = true;
                }
            }
            return z2;
        }
        synchronized (this.d) {
            z = false;
            if (this.i >= com.tencent.tmsbeacon.d.b.a().b()) {
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00bd, code lost:
        if (r6.b.executeInsert() >= 0) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.tencent.tmsbeacon.event.EventBean r7) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmsbeacon.event.a.a.a(com.tencent.tmsbeacon.event.EventBean):boolean");
    }

    public boolean a(String str, String str2) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("_id IN (");
            sb.append(str2);
            sb.append(")");
            int delete = this.f.delete(str, sb.toString(), null);
            a(str.equals("t_r_e"), false, delete);
            return delete >= 0;
        } catch (Exception e) {
            com.tencent.tmsbeacon.a.b.d b = com.tencent.tmsbeacon.a.b.d.b();
            b.a(ErrorContants.LOCAL_EN_ERROR, "type: " + str + " delete err: " + e.getMessage() + " target: " + str2, e);
            com.tencent.tmsbeacon.base.util.c.a(e);
            return false;
        }
    }
}
