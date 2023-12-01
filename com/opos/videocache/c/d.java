package com.opos.videocache.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.MediaFormat;
import com.opos.videocache.f;
import com.opos.videocache.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/c/d.class */
public class d extends SQLiteOpenHelper implements b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f13753a = {"_id", "url", "length", MediaFormat.KEY_MIME};

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context) {
        super(context, "AndroidVideoCache.db", null, 1);
        f.a(context);
    }

    private ContentValues a(j jVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", jVar.f13756a);
        contentValues.put("length", Long.valueOf(jVar.b));
        contentValues.put(MediaFormat.KEY_MIME, jVar.f13757c);
        return contentValues;
    }

    private j a(Cursor cursor) {
        return new j(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow(MediaFormat.KEY_MIME)));
    }

    @Override // com.opos.videocache.c.b
    public j a(String str) {
        Cursor cursor;
        f.a(str);
        try {
            Cursor query = getReadableDatabase().query("SourceInfo", f13753a, "url=?", new String[]{str}, null, null, null);
            j jVar = null;
            if (query != null) {
                try {
                    jVar = !query.moveToFirst() ? null : a(query);
                } catch (Throwable th) {
                    cursor = query;
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return jVar;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    @Override // com.opos.videocache.c.b
    public void a(String str, j jVar) {
        f.a(str, jVar);
        boolean z = a(str) != null;
        ContentValues a2 = a(jVar);
        if (z) {
            getWritableDatabase().update("SourceInfo", a2, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, a2);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        f.a(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }
}
