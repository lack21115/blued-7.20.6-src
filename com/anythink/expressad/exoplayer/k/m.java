package com.anythink.expressad.exoplayer.k;

import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/m.class */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static final int f7658a = 32;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f7659c;

    public m() {
        this((byte) 0);
    }

    private m(byte b) {
        this.f7659c = new long[32];
    }

    private int a() {
        return this.b;
    }

    private long a(int i) {
        if (i < 0 || i >= this.b) {
            throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.b);
        }
        return this.f7659c[i];
    }

    private void a(long j) {
        int i = this.b;
        long[] jArr = this.f7659c;
        if (i == jArr.length) {
            this.f7659c = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.f7659c;
        int i2 = this.b;
        this.b = i2 + 1;
        jArr2[i2] = j;
    }

    private long[] b() {
        return Arrays.copyOf(this.f7659c, this.b);
    }
}
