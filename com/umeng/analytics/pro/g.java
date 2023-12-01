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
    private AtomicInteger f27056a;

    /* renamed from: c  reason: collision with root package name */
    private SQLiteDatabase f27057c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/g$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final g f27058a = new g();

        private a() {
        }
    }

    private g() {
        this.f27056a = new AtomicInteger();
    }

    public static g a(Context context) {
        if (d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            d = applicationContext;
            b = f.a(applicationContext);
        }
        return a.f27058a;
    }

    public SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this) {
            if (this.f27056a.incrementAndGet() == 1) {
                this.f27057c = b.getWritableDatabase();
            }
            sQLiteDatabase = this.f27057c;
        }
        return sQLiteDatabase;
    }

    public void b() {
        synchronized (this) {
            try {
                if (this.f27056a.decrementAndGet() == 0) {
                    this.f27057c.close();
                }
            } catch (Throwable th) {
            }
        }
    }
}
