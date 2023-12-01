package com.opos.exoplayer.core.i;

import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/h.class */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private int f11799a;
    private long[] b;

    public h() {
        this(32);
    }

    public h(int i) {
        this.b = new long[i];
    }

    public int a() {
        return this.f11799a;
    }

    public long a(int i) {
        if (i < 0 || i >= this.f11799a) {
            throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.f11799a);
        }
        return this.b[i];
    }

    public void a(long j) {
        int i = this.f11799a;
        long[] jArr = this.b;
        if (i == jArr.length) {
            this.b = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.b;
        int i2 = this.f11799a;
        this.f11799a = i2 + 1;
        jArr2[i2] = j;
    }

    public long[] b() {
        return Arrays.copyOf(this.b, this.f11799a);
    }
}
