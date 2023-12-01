package com.zx.a.I8b7;

import android.database.sqlite.SQLiteDatabase;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/c.class */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public b f28418a;

    public abstract String a();

    public void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final SQLiteDatabase b() {
        b bVar = this.f28418a;
        if (bVar != null) {
            return bVar.b().getReadableDatabase();
        }
        StringBuilder a2 = m2.a("table ");
        a2.append(c());
        a2.append(" has not been added to a db");
        throw new RuntimeException(a2.toString());
    }

    public abstract String c();

    public final SQLiteDatabase d() {
        b bVar = this.f28418a;
        if (bVar != null) {
            return bVar.b().getWritableDatabase();
        }
        throw new RuntimeException("table zx_table has not been added to a db");
    }
}
