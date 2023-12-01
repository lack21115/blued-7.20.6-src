package com.tencent.txcopyrightedmedia.impl.utils;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;
import androidx.core.provider.FontsContractCompat;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final f f40096a;

    public c(f fVar) {
        this.f40096a = fVar;
    }

    public final int a() {
        int i;
        Cursor rawQuery;
        Cursor cursor = null;
        Cursor cursor2 = null;
        int i2 = 0;
        try {
            try {
                rawQuery = this.f40096a.getReadableDatabase().rawQuery("SELECT count( * ) AS count FROM m4a_file_id_cache;", null);
                i = 0;
                if (rawQuery != null) {
                    i = 0;
                    if (rawQuery.moveToNext()) {
                        cursor2 = rawQuery;
                        cursor = rawQuery;
                        i = rawQuery.getInt(rawQuery.getColumnIndex("count"));
                    }
                }
                i2 = i;
            } catch (Exception e) {
                cursor2 = cursor;
                e.printStackTrace();
                if (cursor != null) {
                    i = 0;
                }
            }
            if (rawQuery != null) {
                cursor = rawQuery;
                cursor.close();
                return i;
            }
            return i2;
        } catch (Throwable th) {
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.tencent.txcopyrightedmedia.impl.utils.ax a(java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.txcopyrightedmedia.impl.utils.c.a(java.lang.String, java.lang.String):com.tencent.txcopyrightedmedia.impl.utils.ax");
    }

    public final void a(ax axVar) {
        SQLiteDatabase writableDatabase = this.f40096a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        if (axVar.f40078a != null) {
            contentValues.put("music_id", axVar.f40078a);
        }
        if (axVar.b != null) {
            contentValues.put(FontsContractCompat.Columns.FILE_ID, axVar.b);
        }
        if (axVar.f40079c != null) {
            contentValues.put("url", axVar.f40079c);
        }
        if (axVar.d != null) {
            contentValues.put("music_ext_id", axVar.d);
        }
        contentValues.put("cache_progress", Integer.valueOf(axVar.e));
        if (axVar.f != null) {
            contentValues.put("overlay_key", axVar.f);
        }
        if (axVar.g != null) {
            contentValues.put("overlay_iv", axVar.g);
        }
        contentValues.put("date", Long.valueOf(System.currentTimeMillis()));
        writableDatabase.update("m4a_file_id_cache", contentValues, "music_id=? AND music_ext_id=?", new String[]{axVar.f40078a, axVar.d});
        axVar.h = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [android.util.Pair<java.lang.String, java.lang.String>[]] */
    /* JADX WARN: Type inference failed for: r0v25, types: [android.util.Pair<java.lang.String, java.lang.String>[]] */
    /* JADX WARN: Type inference failed for: r0v36, types: [android.util.Pair[]] */
    public final Pair<String, String>[] a(int i, int i2) {
        Cursor cursor;
        Cursor cursor2 = null;
        Cursor cursor3 = null;
        try {
            try {
                Cursor rawQuery = this.f40096a.getReadableDatabase().rawQuery("SELECT music_id, music_ext_id FROM m4a_file_id_cache ORDER BY date DESC LIMIT ?,?;", new String[]{String.valueOf(i), String.valueOf(i2)});
                Cursor cursor4 = null;
                if (rawQuery != null) {
                    Cursor cursor5 = null;
                    cursor4 = null;
                    try {
                        if (rawQuery.getCount() > 0) {
                            ?? r0 = new Pair[rawQuery.getCount()];
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                cursor5 = r0;
                                cursor4 = r0;
                                if (!rawQuery.moveToNext()) {
                                    break;
                                }
                                r0[i4] = new Pair(rawQuery.getString(rawQuery.getColumnIndex("music_id")), rawQuery.getString(rawQuery.getColumnIndex("music_ext_id")));
                                i3 = i4 + 1;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        cursor3 = rawQuery;
                        cursor = cursor5;
                        e.printStackTrace();
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        cursor2 = cursor;
                        return cursor2;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = rawQuery;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                cursor2 = cursor4;
                if (rawQuery != null) {
                    rawQuery.close();
                    return cursor4;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            }
            return cursor2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void b() {
        this.f40096a.getWritableDatabase().execSQL("DELETE FROM m4a_file_id_cache");
    }

    public final void b(String str, String str2) {
        this.f40096a.getWritableDatabase().delete("m4a_file_id_cache", "music_id=? AND music_ext_id=?", new String[]{str, str2});
    }
}
