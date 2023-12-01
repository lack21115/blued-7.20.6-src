package com.anythink.expressad.exoplayer.b;

import com.anythink.expressad.exoplayer.b.f;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/q.class */
public final class q implements f {
    private static final long b = 150000;

    /* renamed from: c  reason: collision with root package name */
    private static final long f7214c = 20000;
    private static final short d = 1024;
    private static final byte e = 4;
    private static final int f = 0;
    private static final int g = 1;
    private static final int h = 2;
    private int k;
    private boolean l;
    private boolean o;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private long v;
    private ByteBuffer m = f7181a;
    private ByteBuffer n = f7181a;
    private int i = -1;
    private int j = -1;
    private byte[] p = new byte[0];
    private byte[] q = new byte[0];

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/q$a.class */
    @interface a {
    }

    private int a(long j) {
        return (int) ((j * this.j) / 1000000);
    }

    private void a(int i) {
        if (this.m.capacity() < i) {
            this.m = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.m.clear();
        }
        if (i > 0) {
            this.u = true;
        }
    }

    private void a(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int min = Math.min(byteBuffer.remaining(), this.t);
        int i2 = this.t - min;
        System.arraycopy((Object) bArr, i - i2, (Object) this.q, 0, i2);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.q, i2, min);
    }

    private void a(byte[] bArr, int i) {
        a(i);
        this.m.put(bArr, 0, i);
        this.m.flip();
        this.n = this.m;
    }

    private void b(ByteBuffer byteBuffer) {
        int position;
        int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.p.length));
        int limit2 = byteBuffer.limit();
        int i = 1;
        while (true) {
            int i2 = limit2 - i;
            if (i2 < byteBuffer.position()) {
                position = byteBuffer.position();
                break;
            } else if (Math.abs((int) byteBuffer.get(i2)) > 4) {
                int i3 = this.k;
                position = ((i2 / i3) * i3) + i3;
                break;
            } else {
                limit2 = i2;
                i = 2;
            }
        }
        if (position == byteBuffer.position()) {
            this.r = 1;
        } else {
            byteBuffer.limit(position);
            a(byteBuffer.remaining());
            this.m.put(byteBuffer);
            this.m.flip();
            this.n = this.m;
        }
        byteBuffer.limit(limit);
    }

    private void c(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int f2 = f(byteBuffer);
        int position = f2 - byteBuffer.position();
        byte[] bArr = this.p;
        int length = bArr.length;
        int i = this.s;
        int i2 = length - i;
        if (f2 < limit && position < i2) {
            a(bArr, i);
            this.s = 0;
            this.r = 0;
            return;
        }
        int min = Math.min(position, i2);
        byteBuffer.limit(byteBuffer.position() + min);
        byteBuffer.get(this.p, this.s, min);
        int i3 = this.s + min;
        this.s = i3;
        byte[] bArr2 = this.p;
        if (i3 == bArr2.length) {
            if (this.u) {
                a(bArr2, this.t);
                this.v += (this.s - (this.t * 2)) / this.k;
            } else {
                this.v += (i3 - this.t) / this.k;
            }
            a(byteBuffer, this.p, this.s);
            this.s = 0;
            this.r = 2;
        }
        byteBuffer.limit(limit);
    }

    private void d(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int f2 = f(byteBuffer);
        byteBuffer.limit(f2);
        this.v += byteBuffer.remaining() / this.k;
        a(byteBuffer, this.q, this.t);
        if (f2 < limit) {
            a(this.q, this.t);
            this.r = 0;
            byteBuffer.limit(limit);
        }
    }

    private void e(ByteBuffer byteBuffer) {
        a(byteBuffer.remaining());
        this.m.put(byteBuffer);
        this.m.flip();
        this.n = this.m;
    }

    private int f(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 1;
        while (true) {
            int i2 = position + i;
            if (i2 >= byteBuffer.limit()) {
                return byteBuffer.limit();
            }
            if (Math.abs((int) byteBuffer.get(i2)) > 4) {
                int i3 = this.k;
                return i3 * (i2 / i3);
            }
            position = i2;
            i = 2;
        }
    }

    private int g(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int i = 1;
        while (true) {
            int i2 = limit - i;
            if (i2 < byteBuffer.position()) {
                return byteBuffer.position();
            }
            if (Math.abs((int) byteBuffer.get(i2)) > 4) {
                int i3 = this.k;
                return ((i2 / i3) * i3) + i3;
            }
            limit = i2;
            i = 2;
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void a(ByteBuffer byteBuffer) {
        int position;
        while (byteBuffer.hasRemaining() && !this.n.hasRemaining()) {
            int i = this.r;
            if (i == 0) {
                int limit = byteBuffer.limit();
                byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.p.length));
                int limit2 = byteBuffer.limit();
                int i2 = 1;
                while (true) {
                    int i3 = limit2 - i2;
                    if (i3 < byteBuffer.position()) {
                        position = byteBuffer.position();
                        break;
                    } else if (Math.abs((int) byteBuffer.get(i3)) > 4) {
                        int i4 = this.k;
                        position = ((i3 / i4) * i4) + i4;
                        break;
                    } else {
                        limit2 = i3;
                        i2 = 2;
                    }
                }
                if (position == byteBuffer.position()) {
                    this.r = 1;
                } else {
                    byteBuffer.limit(position);
                    a(byteBuffer.remaining());
                    this.m.put(byteBuffer);
                    this.m.flip();
                    this.n = this.m;
                }
                byteBuffer.limit(limit);
            } else if (i == 1) {
                int limit3 = byteBuffer.limit();
                int f2 = f(byteBuffer);
                int position2 = f2 - byteBuffer.position();
                byte[] bArr = this.p;
                int length = bArr.length;
                int i5 = this.s;
                int i6 = length - i5;
                if (f2 >= limit3 || position2 >= i6) {
                    int min = Math.min(position2, i6);
                    byteBuffer.limit(byteBuffer.position() + min);
                    byteBuffer.get(this.p, this.s, min);
                    int i7 = this.s + min;
                    this.s = i7;
                    byte[] bArr2 = this.p;
                    if (i7 == bArr2.length) {
                        if (this.u) {
                            a(bArr2, this.t);
                            this.v += (this.s - (this.t * 2)) / this.k;
                        } else {
                            this.v += (i7 - this.t) / this.k;
                        }
                        a(byteBuffer, this.p, this.s);
                        this.s = 0;
                        this.r = 2;
                    }
                    byteBuffer.limit(limit3);
                } else {
                    a(bArr, i5);
                    this.s = 0;
                    this.r = 0;
                }
            } else if (i != 2) {
                throw new IllegalStateException();
            } else {
                int limit4 = byteBuffer.limit();
                int f3 = f(byteBuffer);
                byteBuffer.limit(f3);
                this.v += byteBuffer.remaining() / this.k;
                a(byteBuffer, this.q, this.t);
                if (f3 < limit4) {
                    a(this.q, this.t);
                    this.r = 0;
                    byteBuffer.limit(limit4);
                }
            }
        }
    }

    public final void a(boolean z) {
        this.l = z;
        h();
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a() {
        return this.j != -1 && this.l;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a(int i, int i2, int i3) {
        if (i3 == 2) {
            if (this.j == i && this.i == i2) {
                return false;
            }
            this.j = i;
            this.i = i2;
            this.k = i2 * 2;
            return true;
        }
        throw new f.a(i, i2, i3);
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int b() {
        return this.i;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int c() {
        return 2;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int d() {
        return this.j;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void e() {
        this.o = true;
        int i = this.s;
        if (i > 0) {
            a(this.p, i);
        }
        if (this.u) {
            return;
        }
        this.v += this.t / this.k;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final ByteBuffer f() {
        ByteBuffer byteBuffer = this.n;
        this.n = f7181a;
        return byteBuffer;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean g() {
        return this.o && this.n == f7181a;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void h() {
        if (a()) {
            int a2 = a(b) * this.k;
            if (this.p.length != a2) {
                this.p = new byte[a2];
            }
            int a3 = a(f7214c) * this.k;
            this.t = a3;
            if (this.q.length != a3) {
                this.q = new byte[a3];
            }
        }
        this.r = 0;
        this.n = f7181a;
        this.o = false;
        this.v = 0L;
        this.s = 0;
        this.u = false;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void i() {
        this.l = false;
        h();
        this.m = f7181a;
        this.i = -1;
        this.j = -1;
        this.t = 0;
        this.p = new byte[0];
        this.q = new byte[0];
    }

    public final long j() {
        return this.v;
    }
}
