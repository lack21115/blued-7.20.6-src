package com.opos.cmn.biz.monitor.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/monitor/a/b.class */
public class b extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private SQLiteDatabase f10941a;

    public b(Context context) {
        super(context, "monitor_cache.db", null, 1);
    }

    private SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase = this.f10941a;
        if (sQLiteDatabase != null) {
            return sQLiteDatabase;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.f10941a = writableDatabase;
        return writableDatabase;
    }

    private d a(Cursor cursor) {
        return new d(cursor.getString(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("monitorUrl")), cursor.getLong(cursor.getColumnIndex("createTime")));
    }

    public int a(long j) {
        return a().delete("monitor_cache", "createTime<=?", new String[]{String.valueOf(j)});
    }

    public int a(d dVar) {
        return TextUtils.isEmpty(dVar.f10953a) ? a().delete("monitor_cache", "monitorUrl=? and createTime=?", new String[]{dVar.f10954c, String.valueOf(dVar.b)}) : a().delete("monitor_cache", "id=?", new String[]{dVar.f10953a});
    }

    public List<d> a(long j, long j2, int i) {
        LinkedList linkedList = new LinkedList();
        Cursor rawQuery = a().rawQuery("select *\tfrom\tmonitor_cache\twhere\tcreateTime\t>=?\tand\tcreateTime\t<=?\torder by random() limit ?;", new String[]{String.valueOf(j), String.valueOf(j2), String.valueOf(i)});
        if (rawQuery != null) {
            try {
                for (boolean moveToFirst = rawQuery.moveToFirst(); moveToFirst; moveToFirst = rawQuery.moveToNext()) {
                    linkedList.add(a(rawQuery));
                }
                try {
                    return linkedList;
                } catch (Exception e) {
                    return linkedList;
                }
            } finally {
                try {
                    rawQuery.close();
                } catch (Exception e2) {
                }
            }
        }
        return linkedList;
    }

    public void a(List<d> list) {
        SQLiteDatabase a2 = a();
        a2.beginTransaction();
        try {
            for (d dVar : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("monitorUrl", dVar.f10954c);
                contentValues.put("createTime", Long.valueOf(dVar.b));
                a2.insert("monitor_cache", null, contentValues);
            }
            a2.setTransactionSuccessful();
        } finally {
            a2.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void close() {
        SQLiteDatabase sQLiteDatabase = this.f10941a;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table\tmonitor_cache\t(id\tinteger primary key autoincrement,monitorUrl\ttext,createTime\tlong)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        com.opos.cmn.an.f.a.a("CacheDBHelper", "onDowngrade db old version code=" + i + "\tnew version code=" + i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
