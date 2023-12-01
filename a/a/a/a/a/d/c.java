package a.a.a.a.a.d;

import android.content.Context;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/d/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static c f1296a;
    public static f b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f1297c = false;
    public ScheduledExecutorService d;
    public boolean e = true;

    public c() {
        c();
    }

    public static c a() {
        c cVar;
        synchronized (c.class) {
            try {
                if (f1296a == null) {
                    f1296a = new c();
                }
                cVar = f1296a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public static void a(Context context) {
        if (f1297c) {
            return;
        }
        f1297c = true;
        f a2 = f.a();
        b = a2;
        a2.a(context);
    }

    public boolean b() {
        return this.e;
    }

    public final void c() {
        this.d = Executors.newScheduledThreadPool(1);
        long currentTimeMillis = System.currentTimeMillis() - b.a("method_report_last_time_ms");
        if (currentTimeMillis >= 86400000) {
            this.d.scheduleWithFixedDelay(new d(), 0L, 86400000L, TimeUnit.MILLISECONDS);
        } else {
            this.d.scheduleWithFixedDelay(new d(), 86400000 - currentTimeMillis, 86400000L, TimeUnit.MILLISECONDS);
        }
    }
}
