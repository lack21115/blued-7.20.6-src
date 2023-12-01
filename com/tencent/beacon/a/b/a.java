package com.tencent.beacon.a.b;

import android.os.Handler;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/b/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected static volatile a f34921a;
    private boolean b = true;

    /* renamed from: com.tencent.beacon.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/b/a$a.class */
    static class C0894a {

        /* renamed from: a  reason: collision with root package name */
        static final a f34922a = new i();
    }

    public static a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f34921a == null) {
                    f34921a = new i();
                }
                aVar = f34921a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public static void a(ScheduledExecutorService scheduledExecutorService) {
        synchronized (a.class) {
            try {
                if (f34921a == null) {
                    f34921a = new i(scheduledExecutorService);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static a b() {
        return C0894a.f34922a;
    }

    public abstract Handler a(int i);

    public abstract void a(int i, long j, long j2, Runnable runnable);

    public abstract void a(int i, boolean z);

    public abstract void a(long j, Runnable runnable);

    public abstract void a(Runnable runnable);

    public abstract void a(boolean z);

    public abstract void b(int i);

    public boolean c() {
        return this.b;
    }

    public abstract void d();
}
