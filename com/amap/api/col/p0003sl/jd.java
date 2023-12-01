package com.amap.api.col.p0003sl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.amap.api.col.3sl.jd  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jd.class */
public final class jd extends SQLiteOpenHelper {
    private static boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f5202c = false;

    /* renamed from: a  reason: collision with root package name */
    private iz f5203a;

    public jd(Context context, String str, int i, iz izVar) {
        super(context, str, null, i);
        this.f5203a = izVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f5203a.a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.f5203a.a(sQLiteDatabase, i);
    }
}
