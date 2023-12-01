package com.anythink.expressad.exoplayer.b;

import com.anythink.expressad.exoplayer.b.f;
import com.anythink.expressad.exoplayer.k.af;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/u.class */
final class u implements f {
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private int f4380c;
    private int d;
    private int g;
    private int k;
    private boolean l;
    private ByteBuffer h = f4342a;
    private ByteBuffer i = f4342a;
    private int e = -1;
    private int f = -1;
    private byte[] j = new byte[0];

    public final void a(int i, int i2) {
        this.f4380c = i;
        this.d = i2;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void a(ByteBuffer byteBuffer) {
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
        int a2 = af.a(length, 0, this.k);
        this.h.put(this.j, 0, a2);
        int a3 = af.a(length - a2, 0, i2);
        byteBuffer.limit(byteBuffer.position() + a3);
        this.h.put(byteBuffer);
        byteBuffer.limit(limit);
        int i3 = i2 - a3;
        int i4 = this.k - a2;
        this.k = i4;
        byte[] bArr = this.j;
        System.arraycopy(bArr, a2, bArr, 0, i4);
        byteBuffer.get(this.j, this.k, i3);
        this.k += i3;
        this.h.flip();
        this.i = this.h;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a() {
        return this.b;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a(int i, int i2, int i3) {
        if (i3 == 2) {
            this.e = i2;
            this.f = i;
            int i4 = this.d;
            this.j = new byte[i4 * i2 * 2];
            this.k = 0;
            int i5 = this.f4380c;
            this.g = i2 * i5 * 2;
            boolean z = this.b;
            boolean z2 = (i5 == 0 && i4 == 0) ? false : true;
            this.b = z2;
            return z != z2;
        }
        throw new f.a(i, i2, i3);
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int b() {
        return this.e;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int c() {
        return 2;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int d() {
        return this.f;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void e() {
        this.l = true;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final ByteBuffer f() {
        ByteBuffer byteBuffer = this.i;
        this.i = f4342a;
        return byteBuffer;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean g() {
        return this.l && this.i == f4342a;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void h() {
        this.i = f4342a;
        this.l = false;
        this.g = 0;
        this.k = 0;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void i() {
        h();
        this.h = f4342a;
        this.e = -1;
        this.f = -1;
        this.j = new byte[0];
    }
}
