package com.tencent.tendinsv.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/a/a.class */
class a extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private File f38988a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, boolean z) {
        super(context, str, cursorFactory, i);
        this.f38988a = z ? null : c.a(c.a(), str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        File file = this.f38988a;
        SQLiteDatabase readableDatabase = file == null ? super.getReadableDatabase() : SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
        onCreate(readableDatabase);
        return readableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        File file = this.f38988a;
        SQLiteDatabase writableDatabase = file == null ? super.getWritableDatabase() : SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
        onCreate(writableDatabase);
        return writableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
