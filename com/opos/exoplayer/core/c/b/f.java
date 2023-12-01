package com.opos.exoplayer.core.c.b;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/b/f.class */
final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final long[] f11411a = {128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] b = new byte[8];

    /* renamed from: c  reason: collision with root package name */
    private int f11412c;
    private int d;

    public static int a(int i) {
        long[] jArr;
        int i2;
        int i3 = 0;
        do {
            jArr = f11411a;
            if (i3 >= jArr.length) {
                return -1;
            }
            i2 = i3 + 1;
            i3 = i2;
        } while ((jArr[i3] & i) == 0);
        return i2;
    }

    public static long a(byte[] bArr, int i, boolean z) {
        long j = bArr[0] & 255;
        long j2 = j;
        if (z) {
            j2 = j & f11411a[i - 1];
        }
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return j2;
            }
            j2 = (j2 << 8) | (bArr[i3] & 255);
            i2 = i3 + 1;
        }
    }

    public long a(com.opos.exoplayer.core.c.f fVar, boolean z, boolean z2, int i) {
        if (this.f11412c == 0) {
            if (!fVar.a(this.b, 0, 1, z)) {
                return -1L;
            }
            int a2 = a(this.b[0] & 255);
            this.d = a2;
            if (a2 == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f11412c = 1;
        }
        int i2 = this.d;
        if (i2 > i) {
            this.f11412c = 0;
            return -2L;
        }
        if (i2 != 1) {
            fVar.b(this.b, 1, i2 - 1);
        }
        this.f11412c = 0;
        return a(this.b, this.d, z2);
    }

    public void a() {
        this.f11412c = 0;
        this.d = 0;
    }

    public int b() {
        return this.d;
    }
}
