package com.opos.exoplayer.core.b;

import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/b/e.class */
public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public final b f25073a = new b();
    public ByteBuffer b;

    /* renamed from: c  reason: collision with root package name */
    public long f25074c;
    private final int d;

    public e(int i) {
        this.d = i;
    }

    public static e e() {
        return new e(0);
    }

    private ByteBuffer f(int i) {
        int i2 = this.d;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.b;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        throw new IllegalStateException("Buffer too small (" + capacity + " < " + i + ")");
    }

    @Override // com.opos.exoplayer.core.b.a
    public void a() {
        super.a();
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public void e(int i) {
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2 = this.b;
        if (byteBuffer2 == null) {
            byteBuffer = f(i);
        } else {
            int capacity = byteBuffer2.capacity();
            int position = this.b.position();
            int i2 = i + position;
            if (capacity >= i2) {
                return;
            }
            ByteBuffer f = f(i2);
            byteBuffer = f;
            if (position > 0) {
                this.b.position(0);
                this.b.limit(position);
                f.put(this.b);
                byteBuffer = f;
            }
        }
        this.b = byteBuffer;
    }

    public final boolean f() {
        return this.b == null && this.d == 0;
    }

    public final boolean g() {
        return d(1073741824);
    }

    public final void h() {
        this.b.flip();
    }
}
