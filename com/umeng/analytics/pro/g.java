package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/g.class */
public class g {
    private static SQLiteOpenHelper b;
    private static Context d;

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f40747a;

    /* renamed from: c  reason: collision with root package name */
    private SQLiteDatabase f40748c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/g$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final g f40749a = new g();

        private a() {
        }
    }

    private g() {
        this.f40747a = new AtomicInteger();
    }

    public static g a(Context context) {
        if (d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            d = applicationContext;
            b = f.a(applicationContext);
        }
        return a.f40749a;
    }

    public SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this) {
            if (this.f40747a.incrementAndGet() == 1) {
                this.f40748c = b.getWritableDatabase();
            }
            sQLiteDatabase = this.f40748c;
        }
        return sQLiteDatabase;
    }

    public void b() {
        synchronized (this) {
            try {
                if (this.f40747a.decrementAndGet() == 0) {
                    this.f40748c.close();
                }
            } catch (Throwable th) {
            }
        }
    }
}
