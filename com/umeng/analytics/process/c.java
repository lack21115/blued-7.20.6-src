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
    private static c f27115a;
    private ConcurrentHashMap<String, a> b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private Context f27116c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/process/c$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private AtomicInteger f27117a = new AtomicInteger();
        private SQLiteOpenHelper b;

        /* renamed from: c  reason: collision with root package name */
        private SQLiteDatabase f27118c;

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
                if (this.f27117a.incrementAndGet() == 1) {
                    this.f27118c = this.b.getWritableDatabase();
                }
                sQLiteDatabase = this.f27118c;
            }
            return sQLiteDatabase;
        }

        void b() {
            synchronized (this) {
                try {
                    if (this.f27117a.decrementAndGet() == 0) {
                        this.f27118c.close();
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
        if (f27115a == null) {
            synchronized (c.class) {
                try {
                    if (f27115a == null) {
                        f27115a = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        c cVar = f27115a;
        cVar.f27116c = context;
        return cVar;
    }

    private a c(String str) {
        if (this.b.get(str) == null) {
            a a2 = a.a(this.f27116c, str);
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
