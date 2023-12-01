package com.anythink.expressad.exoplayer.k;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/j.class */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final int f4815a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4816c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final long h;

    private j(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j) {
        this.f4815a = i;
        this.b = i2;
        this.f4816c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = j;
    }

    private j(byte[] bArr, int i) {
        r rVar = new r(bArr);
        rVar.a(i * 8);
        this.f4815a = rVar.c(16);
        this.b = rVar.c(16);
        this.f4816c = rVar.c(24);
        this.d = rVar.c(24);
        this.e = rVar.c(20);
        this.f = rVar.c(3) + 1;
        this.g = rVar.c(5) + 1;
        this.h = ((rVar.c(4) & 15) << 32) | (rVar.c(32) & 4294967295L);
    }

    private int a() {
        return this.b * this.f * (this.g / 8);
    }

    private long a(long j) {
        return af.a((j * this.e) / 1000000, this.h - 1);
    }

    private int b() {
        return this.g * this.e;
    }

    private long c() {
        return (this.h * 1000000) / this.e;
    }

    private long d() {
        long j;
        long j2;
        int i = this.d;
        if (i > 0) {
            j = (i + this.f4816c) / 2;
            j2 = 1;
        } else {
            int i2 = this.f4815a;
            j = ((((i2 != this.b || i2 <= 0) ? 4096L : i2) * this.f) * this.g) / 8;
            j2 = 64;
        }
        return j + j2;
    }
}
