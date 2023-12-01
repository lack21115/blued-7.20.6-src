package com.tencent.tmsbeacon.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.opos.acs.st.utils.ErrorContants;
import com.tencent.tmsbeacon.a.d.a;
import com.tencent.tmsbeacon.module.ModuleName;
import com.tencent.tmsbeacon.module.StrategyModule;
import java.util.Locale;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/d/j.class */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static String f25862a;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/d/j$a.class */
    public static class a extends SQLiteOpenHelper {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(android.content.Context r7, java.lang.String r8) {
            /*
                r6 = this;
                r0 = r8
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto Ld
                java.lang.String r0 = "tmsbeacon_db"
                r8 = r0
                goto L27
            Ld:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = r0
                r1.<init>()
                r9 = r0
                r0 = r9
                java.lang.String r1 = "tmsbeacon_db_"
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r9
                r1 = r8
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r9
                java.lang.String r0 = r0.toString()
                r8 = r0
            L27:
                r0 = r6
                r1 = r7
                r2 = r8
                r3 = 0
                r4 = 30
                r0.<init>(r1, r2, r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmsbeacon.d.j.a.<init>(android.content.Context, java.lang.String):void");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s int unique , %s int , %s blob)", "t_strategy", "_id", "_key", "_ut", "_datas"));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            com.tencent.tmsbeacon.base.util.c.a("[db] Upgrade a db  [%s] from v %d to v %d , deleted all tables!", "tmsbeacon_db", Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    /* JADX WARN: Not initialized variable reg: 13, insn: 0x017d: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r13 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:84:0x017d */
    public static i a(Context context, int i) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        i iVar;
        synchronized (j.class) {
            Cursor cursor = null;
            Cursor cursor2 = null;
            try {
                if (context == null) {
                    com.tencent.tmsbeacon.base.util.c.e("[db] context is null", new Object[0]);
                    return null;
                }
                try {
                    try {
                        sQLiteDatabase2 = new a(context, com.tencent.tmsbeacon.a.c.c.d().f()).getWritableDatabase();
                        try {
                        } catch (Exception e) {
                            e = e;
                            iVar = null;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        iVar = null;
                        sQLiteDatabase2 = null;
                    } catch (Throwable th) {
                        th = th;
                        sQLiteDatabase2 = null;
                    }
                    if (sQLiteDatabase2 == null) {
                        com.tencent.tmsbeacon.base.util.c.e("[db] getWritableDatabase fail!", new Object[0]);
                        if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                            sQLiteDatabase2.close();
                        }
                        return null;
                    }
                    Cursor query = sQLiteDatabase2.query("t_strategy", null, String.format(Locale.US, " %s = %d ", "_key", Integer.valueOf(i)), null, null, null, null);
                    i iVar2 = null;
                    if (query != null) {
                        iVar = null;
                        iVar2 = null;
                        try {
                            if (query.moveToNext()) {
                                i a2 = a(query);
                                iVar2 = a2;
                                if (a2 != null) {
                                    iVar = a2;
                                    com.tencent.tmsbeacon.base.util.c.a("[db] read strategy key: %d", Integer.valueOf(a2.b));
                                    iVar2 = a2;
                                }
                            }
                        } catch (Exception e3) {
                            cursor = query;
                            e = e3;
                            Cursor cursor3 = cursor;
                            com.tencent.tmsbeacon.a.b.d.b().a(ErrorContants.THIRD_PARTY_ST, "[db] TB: t_strategy query fail!");
                            Cursor cursor4 = cursor;
                            com.tencent.tmsbeacon.base.util.c.a(e);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                                sQLiteDatabase2.close();
                            }
                            return iVar;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = query;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                                sQLiteDatabase2.close();
                            }
                            throw th;
                        }
                    }
                    if (query != null && !query.isClosed()) {
                        query.close();
                    }
                    iVar = iVar2;
                    if (sQLiteDatabase2.isOpen()) {
                        sQLiteDatabase2.close();
                        iVar = iVar2;
                    }
                    return iVar;
                } catch (Throwable th3) {
                    th = th3;
                    sQLiteDatabase2 = sQLiteDatabase;
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    private static i a(Cursor cursor) {
        if (cursor == null || cursor.isBeforeFirst() || cursor.isAfterLast()) {
            return null;
        }
        com.tencent.tmsbeacon.base.util.c.a("[db] parse bean.", new Object[0]);
        i iVar = new i();
        iVar.f25860a = cursor.getLong(cursor.getColumnIndex("_id"));
        iVar.b = cursor.getInt(cursor.getColumnIndex("_key"));
        iVar.f25861c = cursor.getBlob(cursor.getColumnIndex("_datas"));
        return iVar;
    }

    public static String a() {
        if (TextUtils.isEmpty(f25862a)) {
            com.tencent.tmsbeacon.a.d.a a2 = com.tencent.tmsbeacon.a.d.a.a();
            f25862a = a2.getString("initsdkdate", "");
            if (!com.tencent.tmsbeacon.base.util.b.d().equals(f25862a)) {
                a.SharedPreferences$EditorC0861a edit = a2.edit();
                if (com.tencent.tmsbeacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                    edit.putString("initsdkdate", com.tencent.tmsbeacon.base.util.b.d());
                }
            }
            return f25862a;
        }
        return f25862a;
    }

    public static boolean b() {
        com.tencent.tmsbeacon.a.d.a a2 = com.tencent.tmsbeacon.a.d.a.a();
        boolean z = false;
        int i = com.tencent.tmsbeacon.base.util.b.d().equals(a()) ? a2.getInt("QUERY_TIMES_KEY", 0) : 0;
        if (i <= com.tencent.tmsbeacon.d.a.a().c()) {
            a.SharedPreferences$EditorC0861a edit = a2.edit();
            if (com.tencent.tmsbeacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                edit.putInt("QUERY_TIMES_KEY", i + 1);
                return false;
            }
        } else {
            com.tencent.tmsbeacon.base.util.c.d("[strategy] sdk init max times", new Object[0]);
            z = true;
        }
        return z;
    }

    public static boolean c() {
        b b = ((StrategyModule) com.tencent.tmsbeacon.a.c.c.d().a(ModuleName.STRATEGY)).b();
        boolean z = false;
        if (b.i()) {
            com.tencent.tmsbeacon.a.d.a a2 = com.tencent.tmsbeacon.a.d.a.a();
            long currentTimeMillis = System.currentTimeMillis();
            long j = ((currentTimeMillis / 60000) + 480) % 1440;
            if (j < 0 || j > 30 || currentTimeMillis - a2.getLong("last_success_strategy_query_time", 0L) > 90000000) {
                if (com.tencent.tmsbeacon.base.util.b.d().equals(a())) {
                    if (a2.getInt("today_success_strategy_query_times", 0) >= b.c()) {
                        z = true;
                    }
                    return z;
                }
                a.SharedPreferences$EditorC0861a edit = a2.edit();
                if (com.tencent.tmsbeacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                    edit.putInt("today_success_strategy_query_times", 0);
                    return false;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public static void d() {
        b b = ((StrategyModule) com.tencent.tmsbeacon.a.c.c.d().a(ModuleName.STRATEGY)).b();
        if (b == null || !b.i()) {
            return;
        }
        com.tencent.tmsbeacon.a.d.a a2 = com.tencent.tmsbeacon.a.d.a.a();
        int i = a2.getInt("today_success_strategy_query_times", 0);
        a.SharedPreferences$EditorC0861a edit = a2.edit();
        if (com.tencent.tmsbeacon.base.util.b.a((SharedPreferences.Editor) edit)) {
            edit.putInt("today_success_strategy_query_times", i + 1).putLong("last_success_strategy_query_time", System.currentTimeMillis());
        }
    }
}
