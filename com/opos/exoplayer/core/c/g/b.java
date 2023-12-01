package com.opos.exoplayer.core.c.g;

import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.c.m;
import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/g/b.class */
final class b implements l {

    /* renamed from: a  reason: collision with root package name */
    private final int f11554a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11555c;
    private final int d;
    private final int e;
    private final int f;
    private long g;
    private long h;

    public b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f11554a = i;
        this.b = i2;
        this.f11555c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
    }

    public long a(long j) {
        return (Math.max(0L, j - this.g) * 1000000) / this.f11555c;
    }

    public void a(long j, long j2) {
        this.g = j;
        this.h = j2;
    }

    @Override // com.opos.exoplayer.core.c.l
    public boolean a() {
        return true;
    }

    @Override // com.opos.exoplayer.core.c.l
    public long b() {
        return ((this.h / this.d) * 1000000) / this.b;
    }

    @Override // com.opos.exoplayer.core.c.l
    public l.a b(long j) {
        long j2 = (this.f11555c * j) / 1000000;
        int i = this.d;
        long a2 = u.a((j2 / i) * i, 0L, this.h - i);
        long j3 = this.g + a2;
        long a3 = a(j3);
        m mVar = new m(a3, j3);
        if (a3 < j) {
            long j4 = this.h;
            int i2 = this.d;
            if (a2 != j4 - i2) {
                long j5 = i2 + j3;
                return new l.a(mVar, new m(a(j5), j5));
            }
        }
        return new l.a(mVar);
    }

    public boolean c() {
        return (this.g == 0 || this.h == 0) ? false : true;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.b * this.e * this.f11554a;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.f11554a;
    }

    public int h() {
        return this.f;
    }
}
