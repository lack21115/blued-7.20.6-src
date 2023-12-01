package com.tencent.beacon.a.d;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.opos.acs.st.utils.ErrorContants;
import java.io.File;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/d/c.class */
public class c extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private String f21263a;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c(java.lang.String r7) {
        /*
            r6 = this;
            com.tencent.beacon.a.c.c r0 = com.tencent.beacon.a.c.c.d()
            android.content.Context r0 = r0.c()
            r8 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r9 = r0
            r0 = r9
            java.lang.String r1 = "beacon_db_"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r9
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            r1 = r8
            r2 = r9
            java.lang.String r2 = r2.toString()
            r3 = 0
            r4 = 1
            r0.<init>(r1, r2, r3, r4)
            r0 = r6
            java.lang.String r1 = ""
            r0.f21263a = r1
            java.lang.String r0 = "[DB]"
            r1 = 0
            java.lang.String r2 = "DBOpenHelper construc."
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            com.tencent.beacon.base.util.c.a(r0, r1, r2, r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r8
            java.lang.String r1 = "beacon_db_"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            r1 = r8
            java.lang.String r1 = r1.toString()
            r0.f21263a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.beacon.a.d.c.<init>(java.lang.String):void");
    }

    private boolean a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        try {
            ArrayList<String> arrayList = new ArrayList();
            Cursor query = sQLiteDatabase.query("sqlite_master", new String[]{"name"}, "type = 'table'", null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        arrayList.add(query.getString(0));
                    } catch (Throwable th) {
                        cursor = query;
                        th = th;
                        try {
                            com.tencent.beacon.a.b.g.e().a(ErrorContants.LOCAL_BIZ_EN_ERROR, "[db] drop all tables error! ", th);
                            com.tencent.beacon.base.util.c.a(th);
                            if (cursor == null || cursor.isClosed()) {
                                return false;
                            }
                            cursor.close();
                            return false;
                        } catch (Throwable th2) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            throw th2;
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                for (String str : arrayList) {
                    if (!str.equals("sqlite_sequence") && !str.equals("android_metadata")) {
                        sQLiteDatabase.execSQL("drop table if exists " + str);
                        com.tencent.beacon.base.util.c.a("[DB]", 1, "[db] drop %s", str);
                    }
                }
            }
            if (query == null || query.isClosed()) {
                return true;
            }
            query.close();
            return true;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        if (a(sQLiteDatabase)) {
            com.tencent.beacon.base.util.c.a("[DB]", 0, "[db] drop all success recreate!", new Object[0]);
            onCreate(sQLiteDatabase);
            return;
        }
        com.tencent.beacon.base.util.c.e("[db] drop all fail try deleted file,may next time will success!", new Object[0]);
        File databasePath = com.tencent.beacon.a.c.c.d().c().getDatabasePath(this.f21263a);
        if (databasePath == null || !databasePath.canWrite()) {
            return;
        }
        databasePath.delete();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        super.onConfigure(sQLiteDatabase);
        sQLiteDatabase.setPageSize(4096L);
        sQLiteDatabase.enableWriteAheadLogging();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        com.tencent.beacon.base.util.c.a("[DB]", 0, "DBOpenHelper onCreate.", new Object[0]);
        try {
            for (String str : b.f21262a) {
                sQLiteDatabase.execSQL(str);
            }
        } catch (SQLException e) {
            com.tencent.beacon.a.b.g e2 = com.tencent.beacon.a.b.g.e();
            e2.a(ErrorContants.LOAD_STRATEGY_ERROR, "error msg: " + e.getMessage(), e);
            com.tencent.beacon.base.util.c.b("[DB] crate db table error!", new Object[0]);
            com.tencent.beacon.base.util.c.a(e);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        com.tencent.beacon.base.util.c.a("[DB]", 0, "[db] Downgrade a db  [%s] from v %d to  v%d , deleted all tables!", this.f21263a, Integer.valueOf(i), Integer.valueOf(i2));
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        com.tencent.beacon.base.util.c.a("[DB]", 0, "[db] Upgrade a db  [%s] from v %d to v %d , deleted all tables!", this.f21263a, Integer.valueOf(i), Integer.valueOf(i2));
        b(sQLiteDatabase);
    }
}
