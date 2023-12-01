package com.tramini.plugin.a.b;

import android.database.sqlite.SQLiteDatabase;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/b/a.class */
public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private b f40491a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        this.f40491a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SQLiteDatabase a() {
        SQLiteDatabase a2;
        synchronized (this) {
            a2 = this.f40491a.a();
        }
        return a2;
    }

    protected abstract boolean a(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public final SQLiteDatabase b() {
        SQLiteDatabase b;
        synchronized (this) {
            b = this.f40491a.b();
        }
        return b;
    }
}
