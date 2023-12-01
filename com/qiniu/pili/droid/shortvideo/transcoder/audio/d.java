package com.qiniu.pili.droid.shortvideo.transcoder.audio;

import com.xiaomi.mipush.sdk.Constants;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/transcoder/audio/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private long f14127a;
    private long b;

    public d(long j, long j2) {
        this.f14127a = j;
        this.b = j2;
    }

    public long a() {
        return this.f14127a;
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.b - this.f14127a;
    }

    public String toString() {
        return "[" + this.f14127a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.b + "]";
    }
}
