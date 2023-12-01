package com.opos.exoplayer.core.i;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final int f11797a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11798c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final long h;

    public f(byte[] bArr, int i) {
        l lVar = new l(bArr);
        lVar.a(i * 8);
        this.f11797a = lVar.c(16);
        this.b = lVar.c(16);
        this.f11798c = lVar.c(24);
        this.d = lVar.c(24);
        this.e = lVar.c(20);
        this.f = lVar.c(3) + 1;
        this.g = lVar.c(5) + 1;
        this.h = ((lVar.c(4) & 15) << 32) | (lVar.c(32) & 4294967295L);
    }

    public int a() {
        return this.g * this.e;
    }

    public long b() {
        return (this.h * 1000000) / this.e;
    }
}
