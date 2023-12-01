package com.anythink.expressad.exoplayer.b;

import com.anythink.expressad.exoplayer.b.f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/k.class */
final class k implements f {
    private int[] d;
    private boolean e;
    private int[] f;
    private boolean i;
    private ByteBuffer g = f4342a;
    private ByteBuffer h = f4342a;
    private int b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f4361c = -1;

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void a(ByteBuffer byteBuffer) {
        com.anythink.expressad.exoplayer.k.a.b(this.f != null);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = ((limit - position) / (this.b * 2)) * this.f.length * 2;
        if (this.g.capacity() < length) {
            this.g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.g.clear();
        }
        while (position < limit) {
            int[] iArr = this.f;
            int length2 = iArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length2) {
                    this.g.putShort(byteBuffer.getShort((iArr[i2] * 2) + position));
                    i = i2 + 1;
                }
            }
            position += this.b * 2;
        }
        byteBuffer.position(limit);
        this.g.flip();
        this.h = this.g;
    }

    public final void a(int[] iArr) {
        this.d = iArr;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a() {
        return this.e;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a(int i, int i2, int i3) {
        boolean z = !Arrays.equals(this.d, this.f);
        int[] iArr = this.d;
        this.f = iArr;
        if (iArr == null) {
            this.e = false;
            return z;
        } else if (i3 != 2) {
            throw new f.a(i, i2, i3);
        } else {
            if (!z && this.f4361c == i && this.b == i2) {
                return false;
            }
            this.f4361c = i;
            this.b = i2;
            this.e = i2 != this.f.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                int[] iArr2 = this.f;
                if (i5 >= iArr2.length) {
                    return true;
                }
                int i6 = iArr2[i5];
                if (i6 >= i2) {
                    throw new f.a(i, i2, i3);
                }
                this.e = (i6 != i5) | this.e;
                i4 = i5 + 1;
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int b() {
        int[] iArr = this.f;
        return iArr == null ? this.b : iArr.length;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int c() {
        return 2;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int d() {
        return this.f4361c;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void e() {
        this.i = true;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final ByteBuffer f() {
        ByteBuffer byteBuffer = this.h;
        this.h = f4342a;
        return byteBuffer;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean g() {
        return this.i && this.h == f4342a;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void h() {
        this.h = f4342a;
        this.i = false;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void i() {
        h();
        this.g = f4342a;
        this.b = -1;
        this.f4361c = -1;
        this.f = null;
        this.d = null;
        this.e = false;
    }
}
