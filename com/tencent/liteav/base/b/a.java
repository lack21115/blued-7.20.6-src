package com.tencent.liteav.base.b;

import android.os.SystemClock;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/b/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private long f22591a = 0;
    private final long b;

    public a(long j) {
        this.b = j;
    }

    public final boolean a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f22591a;
        if (j == 0 || elapsedRealtime - j > this.b) {
            this.f22591a = SystemClock.elapsedRealtime();
            return true;
        }
        return false;
    }
}
