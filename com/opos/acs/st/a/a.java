package com.opos.acs.st.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: source-8303388-dex2jar.jar:com/opos/acs/st/a/a.class */
public final class a extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static SQLiteDatabase f10761a;

    private a(Context context) {
        super(context, "acs_st.db", null, 8);
    }

    public static SQLiteDatabase a(Context context) {
        String str;
        synchronized (a.class) {
            try {
                if (f10761a == null || !f10761a.isOpen()) {
                    try {
                        f10761a = new a(context).getWritableDatabase();
                    } catch (SQLiteException e) {
                        e = e;
                        str = "getInstance SQLiteException";
                        com.opos.cmn.an.f.a.d("SQLiteHelper", str, e);
                        return f10761a;
                    } catch (Exception e2) {
                        e = e2;
                        str = "getInstance Exception";
                        com.opos.cmn.an.f.a.d("SQLiteHelper", str, e);
                        return f10761a;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f10761a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            com.opos.cmn.an.f.a.b("SQLiteHelper", "create table:");
            if (sQLiteDatabase != null) {
                sQLiteDatabase.beginTransaction();
                try {
                    com.opos.cmn.an.f.a.b("SQLiteHelper", "create table\tt_acs_st_db_cache\t(ID\tinteger primary key autoincrement,EVENT_ID\ttext,ACS_ID\ttext,URL\ttext,HEAD_JSON_STRING\ttext,BODY_JSON_STRING\ttext,EVENT_JSON_STRING\ttext,BATCH_ID\ttext,EVENT_TIME\tlong,UPLOAD_TYPE\tinteger);");
                    sQLiteDatabase.execSQL("create table\tt_acs_st_db_cache\t(ID\tinteger primary key autoincrement,EVENT_ID\ttext,ACS_ID\ttext,URL\ttext,HEAD_JSON_STRING\ttext,BODY_JSON_STRING\ttext,EVENT_JSON_STRING\ttext,BATCH_ID\ttext,EVENT_TIME\tlong,UPLOAD_TYPE\tinteger);");
                    com.opos.cmn.an.f.a.b("SQLiteHelper", "create table\tt_stat_batch_entity\t(ID\tinteger primary key autoincrement,BATCH_ID\ttext,ACS_POS_IDS\ttext,EFFECTIVE_TAG\tinteger);");
                    sQLiteDatabase.execSQL("create table\tt_stat_batch_entity\t(ID\tinteger primary key autoincrement,BATCH_ID\ttext,ACS_POS_IDS\ttext,EFFECTIVE_TAG\tinteger);");
                    com.opos.cmn.an.f.a.b("SQLiteHelper", "create table\tt_biz_entity\t(ID\tinteger primary key autoincrement,BIZ_DATA\ttext,EVENT_TIME\tlong,UPDATE_TIME\tlong);");
                    sQLiteDatabase.execSQL("create table\tt_biz_entity\t(ID\tinteger primary key autoincrement,BIZ_DATA\ttext,EVENT_TIME\tlong,UPDATE_TIME\tlong);");
                    sQLiteDatabase.setTransactionSuccessful();
                    com.opos.cmn.an.f.a.c("SQLiteHelper", "setTransactionSuccessful");
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("SQLiteHelper", e.getMessage(), (Throwable) e);
                }
                sQLiteDatabase.endTransaction();
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("SQLiteHelper", e2.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        com.opos.cmn.an.f.a.a("SQLiteHelper", "onDowngrade db old version code=" + i + "\tnew version code=" + i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        com.opos.cmn.an.f.a.a("SQLiteHelper", "upgrade db old version code=" + i + "\tnew version code=" + i2);
        if (i2 <= i || sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.beginTransaction();
        int i3 = i;
        try {
            if (i < 6) {
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_acs_st_db_cache");
                    sQLiteDatabase.execSQL("create table\tt_acs_st_db_cache\t(ID\tinteger primary key autoincrement,EVENT_ID\ttext,ACS_ID\ttext,URL\ttext,HEAD_JSON_STRING\ttext,BODY_JSON_STRING\ttext,EVENT_JSON_STRING\ttext,BATCH_ID\ttext,EVENT_TIME\tlong,UPLOAD_TYPE\tinteger);");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_stat_batch_entity");
                    sQLiteDatabase.execSQL("create table\tt_stat_batch_entity\t(ID\tinteger primary key autoincrement,BATCH_ID\ttext,ACS_POS_IDS\ttext,EFFECTIVE_TAG\tinteger);");
                    i3 = 6;
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("SQLiteHelper", e.getMessage(), (Throwable) e);
                }
            }
            int i4 = i3;
            if (i3 < 7) {
                sQLiteDatabase.execSQL("create table\tt_biz_entity\t(ID\tinteger primary key autoincrement,BIZ_DATA\ttext,EVENT_TIME\tlong,UPDATE_TIME\tlong);");
                i4 = 7;
            }
            if (i4 < 8) {
                sQLiteDatabase.execSQL("ALTER TABLE t_acs_st_db_cache ADD COLUMN UPLOAD_TYPE integer");
            }
            sQLiteDatabase.setTransactionSuccessful();
            com.opos.cmn.an.f.a.c("SQLiteHelper", "setTransactionSuccessful");
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
