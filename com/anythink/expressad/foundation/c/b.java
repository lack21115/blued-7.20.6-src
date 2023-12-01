package com.anythink.expressad.foundation.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/c/b.class */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private a f4920a;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/c/b$a.class */
    final class a extends SQLiteOpenHelper {
        public a(Context context, String str) {
            super(context, str, null, 67);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            b.this.b(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            b.this.a(sQLiteDatabase);
        }
    }

    public b(Context context) {
        this.f4920a = new a(context, c());
    }

    public final SQLiteDatabase a() {
        return this.f4920a.getReadableDatabase();
    }

    protected abstract void a(SQLiteDatabase sQLiteDatabase);

    public final SQLiteDatabase b() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this) {
            try {
                sQLiteDatabase = this.f4920a.getWritableDatabase();
            } catch (Exception e) {
                sQLiteDatabase = null;
            }
        }
        return sQLiteDatabase;
    }

    protected abstract void b(SQLiteDatabase sQLiteDatabase);

    protected abstract String c();

    protected abstract int d();

    protected abstract void e();
}
