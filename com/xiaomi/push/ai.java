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
    private static volatile ai f27556a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f125a;

    /* renamed from: a  reason: collision with other field name */
    private ScheduledThreadPoolExecutor f128a = new ScheduledThreadPoolExecutor(1);

    /* renamed from: a  reason: collision with other field name */
    private Map<String, ScheduledFuture> f127a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private Object f126a = new Object();

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ai$a.class */
    public static abstract class a implements Runnable {
        /* renamed from: a */
        public abstract String mo8500a();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ai$b.class */
    static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        a f27557a;

        public b(a aVar) {
            this.f27557a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
        }

        void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.f27557a.run();
            b();
        }
    }

    private ai(Context context) {
        this.f125a = context.getSharedPreferences("mipush_extra", 0);
    }

    public static ai a(Context context) {
        if (f27556a == null) {
            synchronized (ai.class) {
                try {
                    if (f27556a == null) {
                        f27556a = new ai(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27556a;
    }

    private static String a(String str) {
        return "last_job_time".concat(String.valueOf(str));
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f126a) {
            scheduledFuture = this.f127a.get(aVar.mo8500a());
        }
        return scheduledFuture;
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i) {
        this.f128a.schedule(runnable, i, TimeUnit.SECONDS);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8452a(a aVar) {
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
        String a2 = a(aVar.mo8500a());
        aj ajVar = new aj(this, aVar, z, a2);
        int i3 = i2;
        if (!z) {
            long abs = Math.abs(System.currentTimeMillis() - this.f125a.getLong(a2, 0L)) / 1000;
            i3 = i2;
            if (abs < i - i2) {
                i3 = (int) (i - abs);
            }
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f128a.scheduleAtFixedRate(ajVar, i3, i, TimeUnit.SECONDS);
            synchronized (this.f126a) {
                this.f127a.put(aVar.mo8500a(), scheduleAtFixedRate);
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return true;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8453a(String str) {
        synchronized (this.f126a) {
            ScheduledFuture scheduledFuture = this.f127a.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f127a.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    public boolean b(a aVar, int i) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> schedule = this.f128a.schedule(new ak(this, aVar), i, TimeUnit.SECONDS);
        synchronized (this.f126a) {
            this.f127a.put(aVar.mo8500a(), schedule);
        }
        return true;
    }
}
