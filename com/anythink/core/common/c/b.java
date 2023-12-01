package com.anythink.core.common.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/b.class */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private a f6569a;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/b$a.class */
    final class a extends SQLiteOpenHelper {
        public a(Context context, String str) {
            super(context, str, null, 9);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            b.this.a(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            b.this.b(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            b.this.a(sQLiteDatabase, i, i2);
        }
    }

    public b(Context context) {
        this.f6569a = new a(context, c());
    }

    public final SQLiteDatabase a() {
        return this.f6569a.getReadableDatabase();
    }

    protected abstract void a(SQLiteDatabase sQLiteDatabase);

    protected abstract void a(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public final SQLiteDatabase b() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this) {
            try {
                sQLiteDatabase = this.f6569a.getWritableDatabase();
            } catch (Exception e) {
                sQLiteDatabase = null;
            }
        }
        return sQLiteDatabase;
    }

    protected abstract void b(SQLiteDatabase sQLiteDatabase);

    protected abstract String c();

    protected abstract int d();
}
