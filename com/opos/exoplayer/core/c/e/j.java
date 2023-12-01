package com.opos.exoplayer.core.c.e;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/e/j.class */
final class j {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f11489a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private int f11490c;
    private int d;

    public j(byte[] bArr) {
        this.f11489a = bArr;
        this.b = bArr.length;
    }

    private void c() {
        int i;
        int i2 = this.f11490c;
        com.opos.exoplayer.core.i.a.b(i2 >= 0 && (i2 < (i = this.b) || (i2 == i && this.d == 0)));
    }

    public int a(int i) {
        int i2 = this.f11490c;
        int min = Math.min(i, 8 - this.d);
        int i3 = i2 + 1;
        int i4 = ((this.f11489a[i2] & 255) >> this.d) & (255 >> (8 - min));
        while (min < i) {
            i4 |= (this.f11489a[i3] & 255) << min;
            min += 8;
            i3++;
        }
        b(i);
        return ((-1) >>> (32 - i)) & i4;
    }

    public boolean a() {
        boolean z = (((this.f11489a[this.f11490c] & 255) >> this.d) & 1) == 1;
        b(1);
        return z;
    }

    public int b() {
        return (this.f11490c * 8) + this.d;
    }

    public void b(int i) {
        int i2 = i / 8;
        int i3 = this.f11490c + i2;
        this.f11490c = i3;
        int i4 = (i - (i2 * 8)) + this.d;
        this.d = i4;
        if (i4 > 7) {
            this.f11490c = i3 + 1;
            this.d = i4 - 8;
        }
        c();
    }
}
