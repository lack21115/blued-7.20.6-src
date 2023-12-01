package com.opos.exoplayer.core.a;

import com.opos.exoplayer.core.a.d;
import com.opos.exoplayer.core.i.u;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/j.class */
public final class j implements d {
    private int b;
    private n e;
    private ByteBuffer i;
    private ShortBuffer j;
    private ByteBuffer k;
    private long l;
    private long m;
    private boolean n;
    private float f = 1.0f;
    private float g = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    private int f25039c = -1;
    private int d = -1;
    private int h = -1;

    public j() {
        ByteBuffer byteBuffer = f25014a;
        this.i = byteBuffer;
        this.j = byteBuffer.asShortBuffer();
        this.k = f25014a;
        this.b = -1;
    }

    public float a(float f) {
        float a2 = u.a(f, 0.1f, 8.0f);
        this.f = a2;
        return a2;
    }

    public long a(long j) {
        long j2 = this.m;
        if (j2 >= 1024) {
            int i = this.h;
            int i2 = this.d;
            long j3 = this.l;
            return i == i2 ? u.d(j, j3, j2) : u.d(j, i * j3, i2 * j2);
        }
        return (long) (this.f * j);
    }

    @Override // com.opos.exoplayer.core.a.d
    public void a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.l += remaining;
            this.e.a(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int b = this.e.b() * this.f25039c * 2;
        if (b > 0) {
            if (this.i.capacity() < b) {
                ByteBuffer order = ByteBuffer.allocateDirect(b).order(ByteOrder.nativeOrder());
                this.i = order;
                this.j = order.asShortBuffer();
            } else {
                this.i.clear();
                this.j.clear();
            }
            this.e.b(this.j);
            this.m += b;
            this.i.limit(b);
            this.k = this.i;
        }
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a() {
        return Math.abs(this.f - 1.0f) >= 0.01f || Math.abs(this.g - 1.0f) >= 0.01f || this.h != this.d;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a(int i, int i2, int i3) {
        if (i3 == 2) {
            int i4 = this.b;
            int i5 = i4;
            if (i4 == -1) {
                i5 = i;
            }
            if (this.d == i && this.f25039c == i2 && this.h == i5) {
                return false;
            }
            this.d = i;
            this.f25039c = i2;
            this.h = i5;
            return true;
        }
        throw new d.a(i, i2, i3);
    }

    public float b(float f) {
        this.g = u.a(f, 0.1f, 8.0f);
        return f;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int b() {
        return this.f25039c;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int c() {
        return 2;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int d() {
        return this.h;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void e() {
        this.e.a();
        this.n = true;
    }

    @Override // com.opos.exoplayer.core.a.d
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.k;
        this.k = f25014a;
        return byteBuffer;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean g() {
        if (this.n) {
            n nVar = this.e;
            return nVar == null || nVar.b() == 0;
        }
        return false;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void h() {
        this.e = new n(this.d, this.f25039c, this.f, this.g, this.h);
        this.k = f25014a;
        this.l = 0L;
        this.m = 0L;
        this.n = false;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void i() {
        this.e = null;
        ByteBuffer byteBuffer = f25014a;
        this.i = byteBuffer;
        this.j = byteBuffer.asShortBuffer();
        this.k = f25014a;
        this.f25039c = -1;
        this.d = -1;
        this.h = -1;
        this.l = 0L;
        this.m = 0L;
        this.n = false;
        this.b = -1;
    }
}
