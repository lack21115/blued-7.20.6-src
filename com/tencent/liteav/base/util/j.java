package com.tencent.liteav.base.util;

import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/j.class */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    final ThreadPoolExecutor f22642a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    final b b = new b(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    final Map<Runnable, a> f22643c = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/j$a.class */
    public final class a {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f22644a;
        final Runnable b = m.a(this);

        /* renamed from: c  reason: collision with root package name */
        final long f22645c;

        public a(Runnable runnable, long j) {
            this.f22644a = l.a(this, runnable);
            this.f22645c = j;
        }
    }

    public final void a(Runnable runnable) {
        this.f22642a.execute(runnable);
    }

    public final void a(Runnable runnable, long j) {
        a aVar = new a(runnable, j);
        synchronized (this) {
            this.f22643c.put(runnable, aVar);
        }
        j.this.b.postDelayed(aVar.b, aVar.f22645c);
    }

    public final void b(Runnable runnable) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f22642a.execute(k.a(runnable, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public final void c(Runnable runnable) {
        a remove;
        if (runnable == null) {
            return;
        }
        this.f22642a.remove(runnable);
        synchronized (this) {
            remove = this.f22643c.remove(runnable);
        }
        if (remove != null) {
            j.this.b.removeCallbacks(remove.b);
            j.this.f22642a.remove(remove.f22644a);
        }
    }
}
