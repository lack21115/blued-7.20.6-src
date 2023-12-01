package com.tencent.tmsbeacon.a.b;

import android.os.Handler;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/a/b/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f25770a;

    /* renamed from: com.tencent.tmsbeacon.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/a/b/a$a.class */
    public static class C0860a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f25771a = new f();
    }

    public static a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f25770a == null) {
                    f25770a = new f();
                }
                aVar = f25770a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public static void a(ScheduledExecutorService scheduledExecutorService) {
        synchronized (a.class) {
            try {
                if (f25770a == null) {
                    f25770a = new f(scheduledExecutorService);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static a b() {
        return C0860a.f25771a;
    }

    public abstract Handler a(int i);

    public abstract void a(int i, long j, long j2, Runnable runnable);

    public abstract void a(int i, boolean z);

    public abstract void a(long j, Runnable runnable);

    public abstract void a(Runnable runnable);

    public abstract void a(boolean z);

    public abstract void b(int i);

    public abstract void c();
}
