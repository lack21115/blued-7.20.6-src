package com.tramini.plugin.a.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/b/b.class */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private a f26801a;

    /* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/b/b$a.class */
    final class a extends SQLiteOpenHelper {
        public a(Context context, String str) {
            super(context, str, null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            b.this.a(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            b.this.b(sQLiteDatabase);
        }
    }

    public b(Context context) {
        this.f26801a = new a(context, c());
    }

    public final SQLiteDatabase a() {
        return this.f26801a.getReadableDatabase();
    }

    protected abstract void a(SQLiteDatabase sQLiteDatabase);

    public final SQLiteDatabase b() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this) {
            try {
                sQLiteDatabase = this.f26801a.getWritableDatabase();
            } catch (Exception e) {
                sQLiteDatabase = null;
            }
        }
        return sQLiteDatabase;
    }

    protected abstract void b(SQLiteDatabase sQLiteDatabase);

    protected abstract String c();
}
