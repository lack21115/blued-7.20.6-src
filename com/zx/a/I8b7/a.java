package com.zx.a.I8b7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/a.class */
public class a extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f42097a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar, Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, null, i);
        this.f42097a = bVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            for (Class<? extends c> cls : this.f42097a.f42102a.keySet()) {
                sQLiteDatabase.execSQL(this.f42097a.f42102a.get(cls).a());
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.beginTransaction();
        try {
            for (Class<? extends c> cls : this.f42097a.f42102a.keySet()) {
                this.f42097a.f42102a.get(cls).getClass();
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.beginTransaction();
        try {
            for (Class<? extends c> cls : this.f42097a.f42102a.keySet()) {
                this.f42097a.f42102a.get(cls).a(sQLiteDatabase, i, i2);
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
