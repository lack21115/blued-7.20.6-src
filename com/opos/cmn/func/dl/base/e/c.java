package com.opos.cmn.func.dl.base.e;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/e/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public int f24917a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public long f24918c;
    public volatile long d;

    public c(int i, long j, long j2, long j3) {
        this.f24917a = i;
        this.b = j;
        this.f24918c = j3;
        this.d = j2;
    }

    public final String toString() {
        return "ThreadInfo{index=" + this.f24917a + ", startPos=" + this.b + ", contentLen=" + this.f24918c + ", downloadedLen=" + this.d + '}';
    }
}
