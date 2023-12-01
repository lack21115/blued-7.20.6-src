package com.blued.android.framework.qrcode.decoding;

import android.app.Activity;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/qrcode/decoding/InactivityTimer.class */
public final class InactivityTimer {
    private final Activity b;

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f9875a = Executors.newSingleThreadScheduledExecutor(new DaemonThreadFactory());

    /* renamed from: c  reason: collision with root package name */
    private ScheduledFuture<?> f9876c = null;

    /* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/qrcode/decoding/InactivityTimer$DaemonThreadFactory.class */
    static final class DaemonThreadFactory implements ThreadFactory {
        private DaemonThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        }
    }

    public InactivityTimer(Activity activity) {
        this.b = activity;
        a();
    }

    private void c() {
        ScheduledFuture<?> scheduledFuture = this.f9876c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f9876c = null;
        }
    }

    public void a() {
        c();
        this.f9876c = this.f9875a.schedule(new FinishListener(this.b), 300L, TimeUnit.SECONDS);
    }

    public void b() {
        c();
        this.f9875a.shutdown();
    }
}
