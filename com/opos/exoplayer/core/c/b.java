package com.opos.exoplayer.core.c;

import com.opos.exoplayer.core.i.u;
import java.io.EOFException;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/b.class */
public final class b implements f {
    private final com.opos.exoplayer.core.h.g b;

    /* renamed from: c  reason: collision with root package name */
    private final long f11399c;
    private long d;
    private int f;
    private int g;
    private byte[] e = new byte[65536];

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f11398a = new byte[4096];

    public b(com.opos.exoplayer.core.h.g gVar, long j, long j2) {
        this.b = gVar;
        this.d = j;
        this.f11399c = j2;
    }

    private int a(byte[] bArr, int i, int i2, int i3, boolean z) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int a2 = this.b.a(bArr, i + i3, i2 - i3);
        if (a2 == -1) {
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        return i3 + a2;
    }

    private int d(byte[] bArr, int i, int i2) {
        int i3 = this.g;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.e, 0, bArr, i, min);
        f(min);
        return min;
    }

    private void d(int i) {
        int i2 = this.f + i;
        byte[] bArr = this.e;
        if (i2 > bArr.length) {
            this.e = Arrays.copyOf(this.e, u.a(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    private int e(int i) {
        int min = Math.min(this.g, i);
        f(min);
        return min;
    }

    private void f(int i) {
        int i2 = this.g - i;
        this.g = i2;
        this.f = 0;
        byte[] bArr = this.e;
        byte[] bArr2 = bArr;
        if (i2 < bArr.length - 524288) {
            bArr2 = new byte[i2 + 65536];
        }
        System.arraycopy(this.e, i, bArr2, 0, this.g);
        this.e = bArr2;
    }

    private void g(int i) {
        if (i != -1) {
            this.d += i;
        }
    }

    @Override // com.opos.exoplayer.core.c.f
    public int a(int i) {
        int e = e(i);
        int i2 = e;
        if (e == 0) {
            byte[] bArr = this.f11398a;
            i2 = a(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        g(i2);
        return i2;
    }

    @Override // com.opos.exoplayer.core.c.f
    public int a(byte[] bArr, int i, int i2) {
        int d = d(bArr, i, i2);
        int i3 = d;
        if (d == 0) {
            i3 = a(bArr, i, i2, 0, true);
        }
        g(i3);
        return i3;
    }

    @Override // com.opos.exoplayer.core.c.f
    public void a() {
        this.f = 0;
    }

    public boolean a(int i, boolean z) {
        int i2;
        int e = e(i);
        while (true) {
            i2 = e;
            if (i2 >= i || i2 == -1) {
                break;
            }
            e = a(this.f11398a, -i2, Math.min(i, this.f11398a.length + i2), i2, z);
        }
        g(i2);
        return i2 != -1;
    }

    @Override // com.opos.exoplayer.core.c.f
    public boolean a(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        int d = d(bArr, i, i2);
        while (true) {
            i3 = d;
            if (i3 >= i2 || i3 == -1) {
                break;
            }
            d = a(bArr, i, i2, i3, z);
        }
        g(i3);
        return i3 != -1;
    }

    @Override // com.opos.exoplayer.core.c.f
    public long b() {
        return this.d + this.f;
    }

    @Override // com.opos.exoplayer.core.c.f
    public void b(int i) {
        a(i, false);
    }

    @Override // com.opos.exoplayer.core.c.f
    public void b(byte[] bArr, int i, int i2) {
        a(bArr, i, i2, false);
    }

    public boolean b(int i, boolean z) {
        d(i);
        int min = Math.min(this.g - this.f, i);
        while (min < i) {
            int a2 = a(this.e, this.f, i, min, z);
            min = a2;
            if (a2 == -1) {
                return false;
            }
        }
        int i2 = this.f + i;
        this.f = i2;
        this.g = Math.max(this.g, i2);
        return true;
    }

    @Override // com.opos.exoplayer.core.c.f
    public boolean b(byte[] bArr, int i, int i2, boolean z) {
        if (b(i2, z)) {
            System.arraycopy(this.e, this.f - i2, bArr, i, i2);
            return true;
        }
        return false;
    }

    @Override // com.opos.exoplayer.core.c.f
    public long c() {
        return this.d;
    }

    @Override // com.opos.exoplayer.core.c.f
    public void c(int i) {
        b(i, false);
    }

    @Override // com.opos.exoplayer.core.c.f
    public void c(byte[] bArr, int i, int i2) {
        b(bArr, i, i2, false);
    }

    @Override // com.opos.exoplayer.core.c.f
    public long d() {
        return this.f11399c;
    }
}
