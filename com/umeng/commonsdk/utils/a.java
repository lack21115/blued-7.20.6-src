package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/utils/a.class */
public abstract class a {
    private static final int e = 1;

    /* renamed from: a  reason: collision with root package name */
    private final long f27268a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private long f27269c;
    private HandlerThread f;
    private Handler g;
    private boolean d = false;
    private Handler.Callback h = new Handler.Callback() { // from class: com.umeng.commonsdk.utils.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (a.this) {
                if (a.this.d) {
                    return true;
                }
                long elapsedRealtime = a.this.f27269c - SystemClock.elapsedRealtime();
                if (elapsedRealtime <= 0) {
                    a.this.c();
                    if (a.this.f != null) {
                        a.this.f.quit();
                    }
                } else if (elapsedRealtime < a.this.b) {
                    a.this.g.sendMessageDelayed(a.this.g.obtainMessage(1), elapsedRealtime);
                } else {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    a.this.a(elapsedRealtime);
                    long elapsedRealtime3 = (elapsedRealtime2 + a.this.b) - SystemClock.elapsedRealtime();
                    while (elapsedRealtime3 < 0) {
                        elapsedRealtime3 += a.this.b;
                    }
                    a.this.g.sendMessageDelayed(a.this.g.obtainMessage(1), elapsedRealtime3);
                }
                return false;
            }
        }
    };

    public a(long j, long j2) {
        this.f27268a = j;
        this.b = j2;
        if (d()) {
            this.g = new Handler(this.h);
            return;
        }
        HandlerThread handlerThread = new HandlerThread("CountDownTimerThread");
        this.f = handlerThread;
        handlerThread.start();
        this.g = new Handler(this.f.getLooper(), this.h);
    }

    private boolean d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public final void a() {
        synchronized (this) {
            this.d = true;
            this.g.removeMessages(1);
        }
    }

    public abstract void a(long j);

    public final a b() {
        synchronized (this) {
            this.d = false;
            if (this.f27268a <= 0) {
                c();
                return this;
            }
            this.f27269c = SystemClock.elapsedRealtime() + this.f27268a;
            this.g.sendMessage(this.g.obtainMessage(1));
            return this;
        }
    }

    public abstract void c();
}
