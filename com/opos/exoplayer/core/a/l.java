package com.opos.exoplayer.core.a;

import com.opos.exoplayer.core.a.d;
import com.opos.exoplayer.core.i.u;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/l.class */
final class l implements d {
    private static final int b = Float.floatToIntBits(Float.NaN);

    /* renamed from: c  reason: collision with root package name */
    private int f11353c = -1;
    private int d = -1;
    private int e = 0;
    private ByteBuffer f = f11326a;
    private ByteBuffer g = f11326a;
    private boolean h;

    private static void a(int i, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (i * 4.656612875245797E-10d));
        int i2 = floatToIntBits;
        if (floatToIntBits == b) {
            i2 = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(i2);
    }

    @Override // com.opos.exoplayer.core.a.d
    public void a(ByteBuffer byteBuffer) {
        com.opos.exoplayer.core.i.a.b(a());
        boolean z = this.e == 1073741824;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        if (!z) {
            i = (i / 3) * 4;
        }
        if (this.f.capacity() < i) {
            this.f = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.f.clear();
        }
        if (z) {
            while (position < limit) {
                a((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), this.f);
                position += 4;
            }
        } else {
            for (int i2 = position; i2 < limit; i2 += 3) {
                a(((byteBuffer.get(i2) & 255) << 8) | ((byteBuffer.get(i2 + 1) & 255) << 16) | ((byteBuffer.get(i2 + 2) & 255) << 24), this.f);
            }
        }
        byteBuffer.position(byteBuffer.limit());
        this.f.flip();
        this.g = this.f;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a() {
        return u.c(this.e);
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a(int i, int i2, int i3) {
        if (u.c(i3)) {
            if (this.f11353c == i && this.d == i2 && this.e == i3) {
                return false;
            }
            this.f11353c = i;
            this.d = i2;
            this.e = i3;
            return true;
        }
        throw new d.a(i, i2, i3);
    }

    @Override // com.opos.exoplayer.core.a.d
    public int b() {
        return this.d;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int c() {
        return 4;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int d() {
        return this.f11353c;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void e() {
        this.h = true;
    }

    @Override // com.opos.exoplayer.core.a.d
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.g;
        this.g = f11326a;
        return byteBuffer;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean g() {
        return this.h && this.g == f11326a;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void h() {
        this.g = f11326a;
        this.h = false;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void i() {
        h();
        this.f = f11326a;
        this.f11353c = -1;
        this.d = -1;
        this.e = 0;
    }
}
