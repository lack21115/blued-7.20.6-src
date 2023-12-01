package com.opos.cmn.biz.requeststatistic.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/requeststatistic/a/b.class */
public class b extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    static final String f10988a = b.class.getSimpleName();

    public b(Context context) {
        super(context, "request_statistic.db", null, 1);
    }

    public final List<c> a(long j, long j2) {
        LinkedList linkedList = new LinkedList();
        Cursor rawQuery = getWritableDatabase().rawQuery("select *\tfrom\trequest_statistic\twhere\tcreateTime\t>=?\tand\tcreateTime\t<=?\tlimit ?;", new String[]{String.valueOf(j), String.valueOf(j2), "100"});
        if (rawQuery != null) {
            try {
                for (boolean moveToFirst = rawQuery.moveToFirst(); moveToFirst; moveToFirst = rawQuery.moveToNext()) {
                    linkedList.add(new c(rawQuery.getLong(rawQuery.getColumnIndex("id")), rawQuery.getString(rawQuery.getColumnIndex("data")), rawQuery.getLong(rawQuery.getColumnIndex("createTime"))));
                }
                try {
                    rawQuery.close();
                    return linkedList;
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b(f10988a, "cursor close fail", e);
                    return linkedList;
                }
            } catch (Throwable th) {
                try {
                    rawQuery.close();
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b(f10988a, "cursor close fail", e2);
                }
                throw th;
            }
        }
        return linkedList;
    }

    public final void a(List<c> list) {
        if (list.isEmpty()) {
            return;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            for (c cVar : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("data", cVar.b);
                contentValues.put("createTime", Long.valueOf(cVar.f10990c));
                cVar.f10989a = getWritableDatabase().insert("request_statistic", null, contentValues);
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table\trequest_statistic\t(id\tinteger primary key,\tdata\ttext,\tcreateTime\tlong)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
