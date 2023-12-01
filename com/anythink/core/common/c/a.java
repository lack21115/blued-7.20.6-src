package com.anythink.core.common.c;

import android.database.sqlite.SQLiteDatabase;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/a.class */
public class a<T> {
    protected b a;

    public a(b bVar) {
        this.a = null;
        this.a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SQLiteDatabase a() {
        SQLiteDatabase a;
        synchronized (this) {
            a = this.a.a();
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SQLiteDatabase b() {
        SQLiteDatabase b;
        synchronized (this) {
            b = this.a.b();
        }
        return b;
    }
}
