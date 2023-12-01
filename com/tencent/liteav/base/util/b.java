package com.tencent.liteav.base.util;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/b.class */
public final class b extends Handler {
    private static final long b = TimeUnit.SECONDS.toMillis(30);

    /* renamed from: a  reason: collision with root package name */
    private final String f36324a;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f36325c;
    private Runnable d;

    public b(Looper looper) {
        this(looper, null);
    }

    public b(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.f36325c = new Handler(Looper.getMainLooper());
        this.d = new Runnable() { // from class: com.tencent.liteav.base.util.b.1
            @Override // java.lang.Runnable
            public final void run() {
                LiteavLog.e(b.this.f36324a, "quit looper failed.");
            }
        };
        String str = "TXCHandler_" + hashCode();
        this.f36324a = str;
        LiteavLog.i(str, "[" + Thread.currentThread().getName() + "]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(b bVar, MessageQueue.IdleHandler idleHandler) {
        if (bVar.getLooper() == Looper.getMainLooper()) {
            LiteavLog.e(bVar.f36324a, "try to quitLooper main looper!");
            return;
        }
        LiteavLog.i(bVar.f36324a, "add idle handle.");
        Looper.myQueue().addIdleHandler(idleHandler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Runnable runnable, CountDownLatch countDownLatch) {
        runnable.run();
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(b bVar) {
        LiteavLog.i(bVar.f36324a, "queue idle handle.");
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
            bVar.getLooper().quitSafely();
        } else {
            bVar.getLooper().quit();
        }
        bVar.f36325c.removeCallbacks(bVar.d);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(Runnable runnable, CountDownLatch countDownLatch) {
        runnable.run();
        countDownLatch.countDown();
    }

    public final void a() {
        post(f.a(this, e.a(this)));
        this.f36325c.postDelayed(this.d, b);
    }

    public final boolean a(Runnable runnable) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        boolean post = post(c.a(runnable, countDownLatch));
        if (post) {
            try {
                countDownLatch.await();
                return post;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return post;
    }

    public final boolean a(Runnable runnable, int i) {
        if (getLooper().getThread().isAlive()) {
            if (Looper.myLooper() != getLooper() || i != 0) {
                return i == 0 ? post(runnable) : postDelayed(runnable, i);
            }
            runnable.run();
            return true;
        }
        return false;
    }

    public final boolean a(Runnable runnable, long j) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        boolean post = post(d.a(runnable, countDownLatch));
        if (post) {
            try {
                countDownLatch.await(j, TimeUnit.MILLISECONDS);
                return post;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return post;
    }
}
