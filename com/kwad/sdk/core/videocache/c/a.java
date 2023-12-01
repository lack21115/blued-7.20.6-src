package com.kwad.sdk.core.videocache.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.MediaFormat;
import com.kwad.sdk.core.videocache.m;
import com.kwad.sdk.utils.ao;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/c/a.class */
public final class a extends SQLiteOpenHelper implements b {
    private static final String[] aon = {"_id", "url", "length", MediaFormat.KEY_MIME};

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        super(context, "AndroidVideoCache.db", null, 1);
        ao.checkNotNull(context);
    }

    private static ContentValues a(m mVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", mVar.url);
        contentValues.put("length", Long.valueOf(mVar.aoh));
        contentValues.put(MediaFormat.KEY_MIME, mVar.aoi);
        return contentValues;
    }

    private static m g(Cursor cursor) {
        return new m(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow(MediaFormat.KEY_MIME)));
    }

    @Override // com.kwad.sdk.core.videocache.c.b
    public final void a(String str, m mVar) {
        ao.e(str, mVar);
        boolean z = db(str) != null;
        ContentValues a2 = a(mVar);
        if (z) {
            getWritableDatabase().update("SourceInfo", a2, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, a2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.c.b
    public final m db(String str) {
        Cursor cursor;
        ao.eK(str);
        try {
            cursor = getReadableDatabase().query("SourceInfo", aon, "url=?", new String[]{str}, null, null, null);
            m mVar = null;
            if (cursor != null) {
                try {
                    mVar = !cursor.moveToFirst() ? null : g(cursor);
                } catch (Throwable th) {
                    th = th;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    throw th;
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return mVar;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ao.checkNotNull(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }
}
