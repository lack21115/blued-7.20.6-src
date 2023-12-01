package com.anythink.expressad.exoplayer.c;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/c/h.class */
public final class h extends f {

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f4393c;
    private final g<?, h, ?> d;

    private h(g<?, h, ?> gVar) {
        this.d = gVar;
    }

    private ByteBuffer a(long j, int i) {
        this.f4389a = j;
        ByteBuffer byteBuffer = this.f4393c;
        if (byteBuffer == null || byteBuffer.capacity() < i) {
            this.f4393c = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        }
        this.f4393c.position(0);
        this.f4393c.limit(i);
        return this.f4393c;
    }

    @Override // com.anythink.expressad.exoplayer.c.a
    public final void a() {
        super.a();
        ByteBuffer byteBuffer = this.f4393c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    @Override // com.anythink.expressad.exoplayer.c.f
    public final void e() {
        this.d.a((g<?, h, ?>) this);
    }
}
