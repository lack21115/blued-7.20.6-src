package com.opos.exoplayer.core.a;

import com.opos.exoplayer.core.a.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/k.class */
final class k implements d {
    private int[] d;
    private boolean e;
    private int[] f;
    private boolean i;
    private ByteBuffer g = f11326a;
    private ByteBuffer h = f11326a;
    private int b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f11352c = -1;

    @Override // com.opos.exoplayer.core.a.d
    public void a(ByteBuffer byteBuffer) {
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

    public void a(int[] iArr) {
        this.d = iArr;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a() {
        return this.e;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a(int i, int i2, int i3) {
        boolean z = !Arrays.equals(this.d, this.f);
        int[] iArr = this.d;
        this.f = iArr;
        if (iArr == null) {
            this.e = false;
            return z;
        } else if (i3 != 2) {
            throw new d.a(i, i2, i3);
        } else {
            if (!z && this.f11352c == i && this.b == i2) {
                return false;
            }
            this.f11352c = i;
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
                    throw new d.a(i, i2, i3);
                }
                this.e = (i6 != i5) | this.e;
                i4 = i5 + 1;
            }
        }
    }

    @Override // com.opos.exoplayer.core.a.d
    public int b() {
        int[] iArr = this.f;
        return iArr == null ? this.b : iArr.length;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int c() {
        return 2;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int d() {
        return this.f11352c;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void e() {
        this.i = true;
    }

    @Override // com.opos.exoplayer.core.a.d
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.h;
        this.h = f11326a;
        return byteBuffer;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean g() {
        return this.i && this.h == f11326a;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void h() {
        this.h = f11326a;
        this.i = false;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void i() {
        h();
        this.g = f11326a;
        this.b = -1;
        this.f11352c = -1;
        this.f = null;
        this.e = false;
    }
}
