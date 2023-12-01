package com.anythink.expressad.exoplayer.c;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/c/e.class */
public class e extends com.anythink.expressad.exoplayer.c.a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f7226a = 0;
    public static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f7227c = 2;
    public final b d = new b();
    public ByteBuffer e;
    public long f;
    private final int g;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/c/e$a.class */
    public @interface a {
    }

    public e(int i) {
        this.g = i;
    }

    public static e e() {
        return new e(0);
    }

    private ByteBuffer e(int i) {
        int i2 = this.g;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.e;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        throw new IllegalStateException("Buffer too small (" + capacity + " < " + i + ")");
    }

    @Override // com.anythink.expressad.exoplayer.c.a
    public final void a() {
        super.a();
        ByteBuffer byteBuffer = this.e;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final void d(int i) {
        ByteBuffer byteBuffer = this.e;
        if (byteBuffer == null) {
            this.e = e(i);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.e.position();
        int i2 = i + position;
        if (capacity >= i2) {
            return;
        }
        ByteBuffer e = e(i2);
        if (position > 0) {
            this.e.position(0);
            this.e.limit(position);
            e.put(this.e);
        }
        this.e = e;
    }

    public final boolean f() {
        return this.e == null && this.g == 0;
    }

    public final boolean g() {
        return c(1073741824);
    }

    public final void h() {
        this.e.flip();
    }
}
