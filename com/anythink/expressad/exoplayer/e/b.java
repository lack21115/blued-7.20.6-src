package com.anythink.expressad.exoplayer.e;

import com.anythink.expressad.exoplayer.k.af;
import java.io.EOFException;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/b.class */
public final class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private static final int f4473a = 65536;
    private static final int b = 524288;

    /* renamed from: c  reason: collision with root package name */
    private static final int f4474c = 4096;
    private final com.anythink.expressad.exoplayer.j.h e;
    private final long f;
    private long g;
    private int i;
    private int j;
    private byte[] h = new byte[65536];
    private final byte[] d = new byte[4096];

    public b(com.anythink.expressad.exoplayer.j.h hVar, long j, long j2) {
        this.e = hVar;
        this.g = j;
        this.f = j2;
    }

    private int a(byte[] bArr, int i, int i2, int i3, boolean z) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int a2 = this.e.a(bArr, i + i3, i2 - i3);
        if (a2 == -1) {
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        return i3 + a2;
    }

    private int e(byte[] bArr, int i, int i2) {
        int i3 = this.j;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.h, 0, bArr, i, min);
        h(min);
        return min;
    }

    private void f(int i) {
        int i2 = this.i + i;
        byte[] bArr = this.h;
        if (i2 > bArr.length) {
            this.h = Arrays.copyOf(this.h, af.a(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    private int g(int i) {
        int min = Math.min(this.j, i);
        h(min);
        return min;
    }

    private void h(int i) {
        int i2 = this.j - i;
        this.j = i2;
        this.i = 0;
        byte[] bArr = this.h;
        byte[] bArr2 = bArr;
        if (i2 < bArr.length - 524288) {
            bArr2 = new byte[i2 + 65536];
        }
        System.arraycopy(this.h, i, bArr2, 0, this.j);
        this.h = bArr2;
    }

    private void i(int i) {
        if (i != -1) {
            this.g += i;
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final int a(int i) {
        int g = g(i);
        int i2 = g;
        if (g == 0) {
            byte[] bArr = this.d;
            i2 = a(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        i(i2);
        return i2;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final int a(byte[] bArr, int i, int i2) {
        int e = e(bArr, i, i2);
        int i3 = e;
        if (e == 0) {
            i3 = a(bArr, i, i2, 0, true);
        }
        i(i3);
        return i3;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final void a() {
        this.i = 0;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final <E extends Throwable> void a(long j, E e) {
        com.anythink.expressad.exoplayer.k.a.a(j >= 0);
        this.g = j;
        throw e;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final boolean a(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        int e = e(bArr, i, i2);
        while (true) {
            i3 = e;
            if (i3 >= i2 || i3 == -1) {
                break;
            }
            e = a(bArr, i, i2, i3, z);
        }
        i(i3);
        return i3 != -1;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final long b() {
        return this.g + this.i;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final void b(byte[] bArr, int i, int i2) {
        a(bArr, i, i2, false);
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final boolean b(int i) {
        int i2;
        int g = g(i);
        while (true) {
            i2 = g;
            if (i2 >= i || i2 == -1) {
                break;
            }
            g = a(this.d, -i2, Math.min(i, this.d.length + i2), i2, false);
        }
        i(i2);
        return i2 != -1;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final long c() {
        return this.g;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final void c(int i) {
        int i2;
        int g = g(i);
        while (true) {
            i2 = g;
            if (i2 >= i || i2 == -1) {
                break;
            }
            g = a(this.d, -i2, Math.min(i, this.d.length + i2), i2, false);
        }
        i(i2);
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final boolean c(byte[] bArr, int i, int i2) {
        if (d(i2)) {
            System.arraycopy(this.h, this.i - i2, bArr, i, i2);
            return true;
        }
        return false;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final long d() {
        return this.f;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final void d(byte[] bArr, int i, int i2) {
        if (d(i2)) {
            System.arraycopy(this.h, this.i - i2, bArr, i, i2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final boolean d(int i) {
        f(i);
        int min = Math.min(this.j - this.i, i);
        while (min < i) {
            int a2 = a(this.h, this.i, i, min, false);
            min = a2;
            if (a2 == -1) {
                return false;
            }
        }
        int i2 = this.i + i;
        this.i = i2;
        this.j = Math.max(this.j, i2);
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final void e(int i) {
        d(i);
    }
}
