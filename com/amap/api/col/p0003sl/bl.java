package com.amap.api.col.p0003sl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;

/* renamed from: com.amap.api.col.3sl.bl  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bl.class */
public class bl implements iz {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bl f4783a;

    private bl() {
    }

    public static bl a() {
        if (f4783a == null) {
            synchronized (bl.class) {
                try {
                    if (f4783a == null) {
                        f4783a = new bl();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f4783a;
    }

    @Override // com.amap.api.col.p0003sl.iz
    public final void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item (_id integer primary key autoincrement, title  TEXT, url TEXT,mAdcode TEXT,fileName TEXT,version TEXT,lLocalLength INTEGER,lRemoteLength INTEGER,localPath TEXT,mIndex INTEGER,isProvince INTEGER NOT NULL,mCompleteCode INTEGER,mCityCode TEXT,mState INTEGER,mPinyin TEXT, UNIQUE(mAdcode));");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_file (_id integer primary key autoincrement,mAdcode TTEXT, file TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_download_info (_id integer primary key autoincrement,mAdcode TEXT,fileLength integer,splitter integer,startPos integer,endPos integer, UNIQUE(mAdcode));");
        } catch (Throwable th) {
            iw.c(th, "DB", "onCreate");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0003sl.iz
    public final void a(SQLiteDatabase sQLiteDatabase, int i) {
        if (sQLiteDatabase != null && i == 1) {
            sQLiteDatabase.execSQL("ALTER TABLE update_item ADD COLUMN mPinyin TEXT;");
            Cursor query = sQLiteDatabase.query("update_item", null, null, null, null, null, null);
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            if (query == null) {
                sQLiteDatabase.close();
                sQLiteDatabase2 = null;
            }
            if (query != null) {
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("url"));
                    String substring = string.substring(string.lastIndexOf(BridgeUtil.SPLIT_MARK) + 1);
                    sQLiteDatabase2.execSQL("update update_item set mPinyin=? where url =?", new String[]{substring.substring(0, substring.lastIndexOf(".")), string});
                }
                query.close();
            }
        }
    }

    @Override // com.amap.api.col.p0003sl.iz
    public final String b() {
        return "offlineDbV4.db";
    }

    @Override // com.amap.api.col.p0003sl.iz
    public final int c() {
        return 2;
    }
}
