package com.anythink.core.common.c;

import android.database.sqlite.SQLiteDatabase;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/c/a.class */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    protected b f6567a;

    public a(b bVar) {
        this.f6567a = null;
        this.f6567a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SQLiteDatabase a() {
        SQLiteDatabase a2;
        synchronized (this) {
            a2 = this.f6567a.a();
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SQLiteDatabase b() {
        SQLiteDatabase b;
        synchronized (this) {
            b = this.f6567a.b();
        }
        return b;
    }
}
