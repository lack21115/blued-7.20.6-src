package com.qiniu.pili.droid.shortvideo.transcoder.audio;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/transcoder/audio/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private long f27815a;
    private long b;

    public d(long j, long j2) {
        this.f27815a = j;
        this.b = j2;
    }

    public long a() {
        return this.f27815a;
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.b - this.f27815a;
    }

    public String toString() {
        return "[" + this.f27815a + "-" + this.b + "]";
    }
}
