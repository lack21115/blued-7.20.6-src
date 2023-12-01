package com.zx.a.I8b7;

import android.database.sqlite.SQLiteOpenHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/b.class */
public abstract class b {
    public SQLiteOpenHelper b;

    /* renamed from: a  reason: collision with root package name */
    public Map<Class<? extends c>, c> f28411a = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f28412c = new AtomicBoolean(false);

    public abstract String a();

    public final SQLiteOpenHelper b() {
        SQLiteOpenHelper sQLiteOpenHelper = this.b;
        if (sQLiteOpenHelper != null) {
            return sQLiteOpenHelper;
        }
        StringBuilder a2 = m2.a("db ");
        a2.append(a());
        a2.append(" has not been initialized");
        throw new RuntimeException(a2.toString());
    }

    public abstract int c();
}
