package com.autonavi.aps.amapapi.storage;

import android.database.sqlite.SQLiteDatabase;
import com.amap.api.col.p0003sl.iz;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/storage/c.class */
public class c implements iz {
    @Override // com.amap.api.col.p0003sl.iz
    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS c (_id integer primary key autoincrement, a2 varchar(100), a4 varchar(2000), a3 LONG );");
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "SdCardDbCreator", "onCreate");
        }
    }

    @Override // com.amap.api.col.p0003sl.iz
    public final void a(SQLiteDatabase sQLiteDatabase, int i) {
    }

    @Override // com.amap.api.col.p0003sl.iz
    public final String b() {
        return "alsn20170807.db";
    }

    @Override // com.amap.api.col.p0003sl.iz
    public final int c() {
        return 1;
    }
}
