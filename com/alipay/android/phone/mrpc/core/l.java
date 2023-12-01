package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/android/phone/mrpc/core/l.class */
public final class l implements ab {
    private static l b;
    private static final ThreadFactory i = new n();

    /* renamed from: a  reason: collision with root package name */
    Context f4529a;

    /* renamed from: c  reason: collision with root package name */
    private ThreadPoolExecutor f4530c;
    private b d = b.a("android");
    private long e;
    private long f;
    private long g;
    private int h;

    private l(Context context) {
        this.f4529a = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 11, 3L, TimeUnit.SECONDS, new ArrayBlockingQueue(20), i, new ThreadPoolExecutor.CallerRunsPolicy());
        this.f4530c = threadPoolExecutor;
        try {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception e) {
        }
        CookieSyncManager.createInstance(this.f4529a);
        CookieManager.getInstance().setAcceptCookie(true);
    }

    public static final l a(Context context) {
        l lVar = b;
        return lVar != null ? lVar : b(context);
    }

    private static final l b(Context context) {
        synchronized (l.class) {
            try {
                if (b != null) {
                    return b;
                }
                l lVar = new l(context);
                b = lVar;
                return lVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final b a() {
        return this.d;
    }

    @Override // com.alipay.android.phone.mrpc.core.ab
    public final Future<u> a(t tVar) {
        if (s.a(this.f4529a)) {
            String str = "HttpManager" + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
            int activeCount = this.f4530c.getActiveCount();
            long completedTaskCount = this.f4530c.getCompletedTaskCount();
            long taskCount = this.f4530c.getTaskCount();
            long j = this.g;
            long j2 = 0;
            long j3 = j == 0 ? 0L : ((this.e * 1000) / j) >> 10;
            int i2 = this.h;
            if (i2 != 0) {
                j2 = this.f / i2;
            }
            String.format(str, Integer.valueOf(activeCount), Long.valueOf(completedTaskCount), Long.valueOf(taskCount), Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(this.e), Long.valueOf(this.f), Long.valueOf(this.g), Integer.valueOf(this.h));
        }
        q qVar = new q(this, (o) tVar);
        m mVar = new m(this, qVar, qVar);
        this.f4530c.execute(mVar);
        return mVar;
    }

    public final void a(long j) {
        this.e += j;
    }

    public final void b(long j) {
        this.f += j;
        this.h++;
    }

    public final void c(long j) {
        this.g += j;
    }
}
