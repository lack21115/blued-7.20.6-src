package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/aa.class */
public final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f21667a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private long f21668c;
    private final long d;
    private boolean e = true;
    private long f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(Handler handler, String str, long j) {
        this.f21667a = handler;
        this.b = str;
        this.f21668c = j;
        this.d = j;
    }

    public final void a() {
        if (this.e) {
            this.e = false;
            this.f = SystemClock.uptimeMillis();
            this.f21667a.post(this);
        }
    }

    public final void a(long j) {
        this.f21668c = Long.MAX_VALUE;
    }

    public final boolean b() {
        return !this.e && SystemClock.uptimeMillis() > this.f + this.f21668c;
    }

    public final int c() {
        if (this.e) {
            return 0;
        }
        return SystemClock.uptimeMillis() - this.f < this.f21668c ? 1 : 3;
    }

    public final String d() {
        return this.b;
    }

    public final Looper e() {
        return this.f21667a.getLooper();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e = true;
        this.f21668c = this.d;
    }
}
