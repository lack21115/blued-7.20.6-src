package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ai.class */
public class ai {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ai f41247a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f172a;

    /* renamed from: a  reason: collision with other field name */
    private ScheduledThreadPoolExecutor f175a = new ScheduledThreadPoolExecutor(1);

    /* renamed from: a  reason: collision with other field name */
    private Map<String, ScheduledFuture> f174a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private Object f173a = new Object();

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ai$a.class */
    public static abstract class a implements Runnable {
        /* renamed from: a */
        public abstract String mo11550a();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ai$b.class */
    static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        a f41248a;

        public b(a aVar) {
            this.f41248a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
        }

        void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.f41248a.run();
            b();
        }
    }

    private ai(Context context) {
        this.f172a = context.getSharedPreferences("mipush_extra", 0);
    }

    public static ai a(Context context) {
        if (f41247a == null) {
            synchronized (ai.class) {
                try {
                    if (f41247a == null) {
                        f41247a = new ai(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f41247a;
    }

    private static String a(String str) {
        return "last_job_time".concat(String.valueOf(str));
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f173a) {
            scheduledFuture = this.f174a.get(aVar.mo11550a());
        }
        return scheduledFuture;
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i) {
        this.f175a.schedule(runnable, i, TimeUnit.SECONDS);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11502a(a aVar) {
        return b(aVar, 0);
    }

    public boolean a(a aVar, int i) {
        return a(aVar, i, 0);
    }

    public boolean a(a aVar, int i, int i2) {
        return a(aVar, i, i2, false);
    }

    public boolean a(a aVar, int i, int i2, boolean z) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        String a2 = a(aVar.mo11550a());
        aj ajVar = new aj(this, aVar, z, a2);
        int i3 = i2;
        if (!z) {
            long abs = Math.abs(System.currentTimeMillis() - this.f172a.getLong(a2, 0L)) / 1000;
            i3 = i2;
            if (abs < i - i2) {
                i3 = (int) (i - abs);
            }
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f175a.scheduleAtFixedRate(ajVar, i3, i, TimeUnit.SECONDS);
            synchronized (this.f173a) {
                this.f174a.put(aVar.mo11550a(), scheduleAtFixedRate);
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return true;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11503a(String str) {
        synchronized (this.f173a) {
            ScheduledFuture scheduledFuture = this.f174a.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f174a.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    public boolean b(a aVar, int i) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> schedule = this.f175a.schedule(new ak(this, aVar), i, TimeUnit.SECONDS);
        synchronized (this.f173a) {
            this.f174a.put(aVar.mo11550a(), schedule);
        }
        return true;
    }
}
