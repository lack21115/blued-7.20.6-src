package com.tencent.thumbplayer.utils;

import android.os.SystemClock;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private long f25737a;
    private long b;

    public void a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f25737a = elapsedRealtime;
        this.b = elapsedRealtime;
    }

    public void b() {
        this.b = SystemClock.elapsedRealtime();
    }

    public long c() {
        return SystemClock.elapsedRealtime() - this.b;
    }

    public long d() {
        return SystemClock.elapsedRealtime() - this.f25737a;
    }

    public long e() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.b;
        this.b = elapsedRealtime;
        return elapsedRealtime - j;
    }
}
