package com.tramini.plugin.a.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/b/d.class */
public class d extends b {

    /* renamed from: a  reason: collision with root package name */
    private static d f26804a;

    private d(Context context) {
        super(context);
    }

    public static d a(Context context) {
        if (f26804a == null) {
            synchronized (d.class) {
                try {
                    f26804a = new d(context.getApplicationContext());
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f26804a;
    }

    private static void c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS il(id TEXT ,value TEXT ,time INTEGER)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS il_all(id TEXT ,value TEXT ,time INTEGER)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.tramini.plugin.a.b.b
    protected final void a(SQLiteDatabase sQLiteDatabase) {
        c(sQLiteDatabase);
    }

    @Override // com.tramini.plugin.a.b.b
    protected final void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'il'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'il_all'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        c(sQLiteDatabase);
    }

    @Override // com.tramini.plugin.a.b.b
    protected final String c() {
        return "tramini.db";
    }
}
