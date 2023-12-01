package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/process/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f40806a;
    private ConcurrentHashMap<String, a> b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private Context f40807c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/process/c$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private AtomicInteger f40808a = new AtomicInteger();
        private SQLiteOpenHelper b;

        /* renamed from: c  reason: collision with root package name */
        private SQLiteDatabase f40809c;

        private a() {
        }

        static a a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.b = b.a(appContext, str);
            return aVar;
        }

        SQLiteDatabase a() {
            SQLiteDatabase sQLiteDatabase;
            synchronized (this) {
                if (this.f40808a.incrementAndGet() == 1) {
                    this.f40809c = this.b.getWritableDatabase();
                }
                sQLiteDatabase = this.f40809c;
            }
            return sQLiteDatabase;
        }

        void b() {
            synchronized (this) {
                try {
                    if (this.f40808a.decrementAndGet() == 0) {
                        this.f40809c.close();
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(Context context) {
        if (f40806a == null) {
            synchronized (c.class) {
                try {
                    if (f40806a == null) {
                        f40806a = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        c cVar = f40806a;
        cVar.f40807c = context;
        return cVar;
    }

    private a c(String str) {
        if (this.b.get(str) == null) {
            a a2 = a.a(this.f40807c, str);
            this.b.put(str, a2);
            return a2;
        }
        return this.b.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteDatabase a(String str) {
        SQLiteDatabase a2;
        synchronized (this) {
            a2 = c(str).a();
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        synchronized (this) {
            c(str).b();
        }
    }
}
