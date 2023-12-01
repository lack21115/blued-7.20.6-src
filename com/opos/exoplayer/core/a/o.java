package com.opos.exoplayer.core.a;

import com.opos.exoplayer.core.a.d;
import com.opos.exoplayer.core.i.u;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/o.class */
final class o implements d {
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private int f11357c;
    private int d;
    private int f;
    private int g;
    private byte[] j;
    private int k;
    private boolean l;
    private ByteBuffer h = f11326a;
    private ByteBuffer i = f11326a;
    private int e = -1;

    public void a(int i, int i2) {
        this.f11357c = i;
        this.d = i2;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int min = Math.min(i, this.g);
        this.g -= min;
        byteBuffer.position(position + min);
        if (this.g > 0) {
            return;
        }
        int i2 = i - min;
        int length = (this.k + i2) - this.j.length;
        if (this.h.capacity() < length) {
            this.h = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.h.clear();
        }
        int a2 = u.a(length, 0, this.k);
        this.h.put(this.j, 0, a2);
        int a3 = u.a(length - a2, 0, i2);
        byteBuffer.limit(byteBuffer.position() + a3);
        this.h.put(byteBuffer);
        byteBuffer.limit(limit);
        int i3 = i2 - a3;
        int i4 = this.k - a2;
        this.k = i4;
        byte[] bArr = this.j;
        System.arraycopy(bArr, a2, bArr, 0, i4);
        byteBuffer.get(this.j, this.k, i3);
        this.k = i3 + this.k;
        this.h.flip();
        this.i = this.h;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a() {
        return this.b;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a(int i, int i2, int i3) {
        if (i3 == 2) {
            this.e = i2;
            this.f = i;
            int i4 = this.d;
            this.j = new byte[i4 * i2 * 2];
            boolean z = false;
            this.k = 0;
            int i5 = this.f11357c;
            this.g = i2 * i5 * 2;
            boolean z2 = this.b;
            boolean z3 = (i5 == 0 && i4 == 0) ? false : true;
            this.b = z3;
            if (z2 != z3) {
                z = true;
            }
            return z;
        }
        throw new d.a(i, i2, i3);
    }

    @Override // com.opos.exoplayer.core.a.d
    public int b() {
        return this.e;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int c() {
        return 2;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int d() {
        return this.f;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void e() {
        this.l = true;
    }

    @Override // com.opos.exoplayer.core.a.d
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.i;
        this.i = f11326a;
        return byteBuffer;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean g() {
        return this.l && this.i == f11326a;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void h() {
        this.i = f11326a;
        this.l = false;
        this.g = 0;
        this.k = 0;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void i() {
        h();
        this.h = f11326a;
        this.e = -1;
        this.f = -1;
        this.j = null;
    }
}
